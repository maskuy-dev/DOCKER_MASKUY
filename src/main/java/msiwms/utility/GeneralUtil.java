package msiwms.utility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import id.co.ahm.jxf.constant.CommonConstant;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.beans.Expression;
import java.beans.Statement;
import java.io.File;
import javax.imageio.ImageIO;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import static org.hibernate.validator.internal.util.ReflectionHelper.isList;

/**
 *
 * @author kevin.jh
 */
public class GeneralUtil {

//<editor-fold defaultstate="collapsed" desc="merge filter into criteria">
    public void decorateCriteriaWithSearch(Criteria criteria, Map<String, Object> filters) {
        if (filters != null) {
            List<Criterion> restrictionList = new ArrayList<Criterion>();
            if (filters.size() > 0) {
                if (!filters.containsKey("any")) {
                    for (Map.Entry<String, Object> filter : filters.entrySet()) {
                        if (filter.getKey() != "any") {
                            String valueStr = filter.getValue().toString();
                            if (isNumeric(valueStr)
                                    && filter.getValue() instanceof Integer) {
                                criteria.add(Restrictions.and(Restrictions.eqOrIsNull(filter.getKey(), Integer.parseInt(filter.getValue().toString()))));
                            } else if (isNumeric(valueStr)
                                    && filter.getValue() instanceof Double) {
                                criteria.add(Restrictions.and(Restrictions.eqOrIsNull(filter.getKey(), Double.parseDouble(filter.getValue().toString()))));
                            } else {
                                if (valueStr.trim().length() > 0) {
                                    criteria.add(Restrictions.and(Restrictions.ilike(filter.getKey(), valueStr)));
                                } else {
                                    criteria.add(Restrictions.and(Restrictions.eqOrIsNull(filter.getKey(), valueStr)));
                                }
                            }
                        }
                    }
                } else {
                    for (Map.Entry<String, Object> filter : filters.entrySet()) {
                        if (filter.getKey() != "any") {
                            restrictionList.add(Restrictions.or(Restrictions.ilike(filter.getKey(), filter.getValue().toString(), MatchMode.ANYWHERE)));
                        }
                    }
                    if (!restrictionList.isEmpty()) {
                        criteria.add(or(restrictionList));
                    }

                }
            }
        }
    }

    public void decorateDetachedCriteriaWithSearch(DetachedCriteria criteria, Map<String, Object> filters) {
        if (filters != null) {
            List<Criterion> restrictionList = new ArrayList<Criterion>();
            if (filters.size() > 0) {
                if (!filters.containsKey("any")) {
                    for (Map.Entry<String, Object> filter : filters.entrySet()) {
                        if (filter.getKey() != "any") {
                            String valueStr = filter.getValue().toString();
                            if (isNumeric(valueStr)
                                    && filter.getValue() instanceof Integer) {
                                criteria.add(Restrictions.and(Restrictions.eqOrIsNull(filter.getKey(), Integer.parseInt(filter.getValue().toString()))));
                            } else if (isNumeric(valueStr)
                                    && filter.getValue() instanceof Double) {
                                criteria.add(Restrictions.and(Restrictions.eqOrIsNull(filter.getKey(), Double.parseDouble(filter.getValue().toString()))));
                            } else {
                                if (valueStr.trim().length() > 0) {
                                    criteria.add(Restrictions.and(Restrictions.ilike(filter.getKey(), valueStr)));
                                } else {
                                    criteria.add(Restrictions.and(Restrictions.eqOrIsNull(filter.getKey(), valueStr)));
                                }
                            }
                        }
                    }
                } else {
                    for (Map.Entry<String, Object> filter : filters.entrySet()) {
                        if (filter.getKey() != "any") {
                            restrictionList.add(Restrictions.or(Restrictions.ilike(filter.getKey(), filter.getValue().toString(), MatchMode.ANYWHERE)));
                        }
                    }
                    if (!restrictionList.isEmpty()) {
                        criteria.add(or(restrictionList));
                    }

                }
            }
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="merge filter into lookup">
    public Map<String, Object> decorateLookupWithSearch(Map<String, Object> filters, Map<String, Object> fields) {
        if (filters != null) {
            if (filters.size() > 0) {
                for (Map.Entry<String, Object> filter : filters.entrySet()) {
                    if (filter.getKey() != null) {
                        if (filter.getKey() == "any") {
                            for (Map.Entry<String, Object> field : fields.entrySet()) {
                                filters.put(field.getKey(), filter.getValue().toString());
                            }
                        }
                    }
                }
            }
        }
        return filters;
    }
//</editor-fold>

    public String generateUsername(String fullName, LocalDate dob) {
        String[] splitName = fullName.split(" ");
        String newUsername = "";
        DateTimeFormatter dtfDay = DateTimeFormatter.ofPattern("dd");
        DateTimeFormatter dtfYear = DateTimeFormatter.ofPattern("yy");

        if (splitName.length > 1) {

            String first = splitName[0].toLowerCase().substring(0, 3);
            String last = splitName[splitName.length - 1].toLowerCase().substring(0, 3);

            String day = dtfDay.format(dob);
            String year = dtfYear.format(dob);

            newUsername = first + last + "" + day + "" + year;
        } else {
            String day = dtfDay.format(dob);
            String year = dtfYear.format(dob);

            String name = "";
            if (splitName[0].length() > 6) {
                name = splitName[0].substring(0, 6);
            } else {
                name = splitName[0];
            }
            newUsername = name.toLowerCase() + "" + day + "" + year;
        }

        return newUsername;
    }

    public Disjunction or(List<Criterion> restrictions) {
        Disjunction result = Restrictions.disjunction();

        for (Criterion restriction : restrictions) {
            result.add(restriction);
        }

        return result;
    }

    public String checkNull(String data) {
        if (data.length() <= 0) {
            return null;
        } else {
            return data;
        }
    }

    public void hibFetchOtM(Object objectIn) throws Exception {
        List<Object> list = new ArrayList<>();
        if (!isList(objectIn.getClass())) {
            list.add(objectIn);
        } else {
            list = (List) objectIn;
        }
        for (Object dr1 : list) {
            Field[] fields = dr1.getClass().getDeclaredFields();
            for (Field f : fields) {
                String getterName = "get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                String setterName = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                if (isList(f.getType())) {
                    Statement stmt;
                    Expression expr;

                    // Get the value of property1
                    expr = new Expression(dr1, getterName, new Object[0]);
                    expr.execute();
                    List result = (List) expr.getValue();
                    if (result.size() <= 0) {
                        stmt = new Statement(dr1, setterName, new Object[]{null});
                        stmt.execute();
                    } else {
                        this.hibFetchOtM(result);
                    }

                }
            }
        }
    }

    private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));
        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }
        return fields;
    }

    public static boolean isImage(File file) {
        try {
            return ImageIO.read(file) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static Map<String, Object> copy(
            Map<String, Object> original) {
        Map<String, Object> copy = new HashMap<>();
        for (Map.Entry<String, Object> entry : original.entrySet()) {
            copy.put(entry.getKey(), entry.getValue());
        }
        return copy;
    }

    public static boolean isNumeric(String str) {
        try {
            new Double(nullFloat(str.trim()));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String nullFloat(String str) {
        return (!hasValue(str)) ? "0" : str;
    }

    public static boolean hasValue(Object o) {
        if (o == null) {
            return false;
        } else if (o.toString().trim().equals("")) {
            return false;
        } else if (o.toString().isEmpty()) {
            return false;
        }
        return true;
    }
}
