/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msiwms.app001.dao.impl;

import msiwms.app001.dao.impl.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import msiwms.app001.dao.MasterSymptomDao;
import msiwms.app001.vo.voMasterSymptom;
import msiwms.lib.dao.DefaultHibernateDao;
import msiwms.lib.dto.DefaultDtoPagingParams;
import msiwms.model.MsiwmsMasterSymptom;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Magna Solusi
 */
@Repository("masterSymptomDao")

public class MasterSymptomDaoImpl extends DefaultHibernateDao<MsiwmsMasterSymptom, Number> implements MasterSymptomDao{

    @Override
    public List<voMasterSymptom> getData(DefaultDtoPagingParams vo) {
        Map<String, Object> searchFilter = vo.getSearch();

        String sql = "SELECT nid, vsymptomname, vsymptomcode, vsymptomcategory, nstatus "
                + " FROM tblm_symptom "
                + " WHERE 1=1 ";
        
        if (searchFilter.containsKey("nid")) {
            sql += "    AND nid = :ID ";
        }
        
        if (searchFilter.containsKey("symptomname")) {
            sql += "    AND vsymptomname = :SYMPTOMNAME ";
        }
        
        if (searchFilter.containsKey("symptomcode")) {
            sql += "    AND vsymptomcode = :SYMPTOMCODE ";
        }
        
        if (searchFilter.containsKey("symptomcategory")) {
            sql += "    AND vsymptomcategory = :SYMPTOMCATEGORY ";
        }

        if (searchFilter.containsKey("status")){
            sql += "    AND nstatus = :STATUS ";
        }

        Query query = getCurrentSession().createSQLQuery(sql);
        
        if (searchFilter.containsKey("nid")) {
            query.setParameter("ID", searchFilter.get("nid"));
        }
        
        if (searchFilter.containsKey("symptomname")) {
            query.setParameter("SYMPTOMNAME", searchFilter.get("symptomname").toString());
        }
        
        if (searchFilter.containsKey("symptomcode")) {
            query.setParameter("SYMPTOMCODE", searchFilter.get("symptomcode").toString());
        }
        
        if (searchFilter.containsKey("symptomcategory")) {
            query.setParameter("SYMPTOMCATEGORY", searchFilter.get("symptomcategory").toString());
        }
        
        if (searchFilter.containsKey("status")) {
            query.setParameter("STATUS", searchFilter.get("status"));
        }

        Object[] obj;
        List<voMasterSymptom> returnArray = new ArrayList<>();
        List queryResult = query.list();

        for (Object object : queryResult) {
            voMasterSymptom dr = new voMasterSymptom();
            obj = (Object[]) object;
            dr.setId((obj[0] == null) ? null : Long.parseLong(obj[0].toString()));
            dr.setSymptomname((obj[1] == null) ? "" : obj[1].toString());
            dr.setSymptomcode((obj[1] == null) ? "" : obj[2].toString());
            dr.setSymptomcategory((obj[1] == null) ? "" : obj[3].toString());
            dr.setStatus((obj[2] == null) ? null : Short.parseShort(obj[4].toString()));
            returnArray.add(dr);
        }
        return returnArray;
    }
    
}
