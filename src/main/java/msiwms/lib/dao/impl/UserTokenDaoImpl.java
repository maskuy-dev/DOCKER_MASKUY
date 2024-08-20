///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package msimpa.lib.dao.impl;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import org.springframework.stereotype.Repository;
//import msimpa.lib.dao.UserTokenDao;
//import msimpa.lib.vo.voUserData;
//import msimpa.lib.dao.DefaultHibernateDao;
//import msisms.model.MsismsMstUser;
//import org.hibernate.query.NativeQuery;
//
///**
// *
// * @author Magna Solusi
// */
//@Repository("userTokenDao")
//public class UserTokenDaoImpl extends DefaultHibernateDao<MsismsMstUser, Number> implements UserTokenDao {
//
//    @Override
//    public voUserData getAuthenticationToken(String token, String servicePath) {
//
////        String sql = "select tu.nid, tu.vfull_name,tu.vusername,tu.vusertoken,tu.ttokenexpiry, \n"
////                + "tu.nstatus from tblm_user tu limit 1";
//        String sql = " select tu.nid, tu.vfull_name, tu.vusername, tu.vusertoken, tu.ttokenexpiry, tu.nstatus, ta.vurl \n"
//                + "                    from tblm_user tu \n"
//                + "                    inner join tblt_role_mapping trm on tu.nid = trm.nid_user \n"
//                + "                    inner join tblm_role_service trs on trs.nid_role = trm.nid_role \n"
//                + "                    inner join tblm_appservice ta on trs.nid_appservice = ta.nid and ta.vurl = :URL \n"
//                + "                    where tu.vusertoken = :TOKEN and tu.ttokenexpiry >= CURRENT_TIMESTAMP";
//        NativeQuery query = getCurrentSession().createNativeQuery(sql);
//
//        query.setParameter("TOKEN", token);
//        query.setParameter("URL", servicePath);
//        List<Object> roleList = query.list();
////        Object queryResult[] = (Object[]) query.uniqueResult();
//
//        voUserData returnData = new voUserData();
//
//        for (Object dr : roleList) {
//            Object queryResult[] = (Object[]) dr;
//            if (queryResult != null) {
//                returnData.setId(queryResult[0] == null ? null : Long.parseLong(queryResult[0].toString()));
//                returnData.setName(queryResult[1] == null ? "" : queryResult[1].toString());
//                returnData.setUsername(queryResult[2] == null ? "" : queryResult[2].toString());
//                returnData.setToken(queryResult[3] == null ? "" : queryResult[3].toString());
//
//                returnData.setTokenexpiry((queryResult[4] instanceof Date) ? (Date) queryResult[4] : null);
//
//                //Timestamp tokenExpiryTemp = (queryResult[4] == null) ? null : (Timestamp) queryResult[4];
//                //Date tokenExpiry = (tokenExpiryTemp == null) ? null : tokenExpiryTemp.toLocalDateTime();
//                //returnData.setTokenexpiry(tokenExpiry);
//                returnData.setStatus(queryResult[5] == null ? null : Integer.parseInt(queryResult[5].toString()));
//            }
//        }
//        return returnData;
//    }
//
//    @Override
//    public voUserData getAuthenticationToken(String token) {
//        String sql = "select tu.nid, tu.vfull_name, tu.vusername, tu.vusertoken, tu.ttokenexpiry, tu.nstatus\n"
//                + "                    from tblm_user tu \n"
//                + "                    where tu.vusertoken = :TOKEN and tu.ttokenexpiry >= CURRENT_TIMESTAMP";
//        NativeQuery query = getCurrentSession().createNativeQuery(sql);
//
//        query.setParameter("TOKEN", token);
//        Object queryResult[] = (Object[]) query.uniqueResult();
//
//        voUserData returnData = new voUserData();
//        if (queryResult != null) {
//            returnData.setId(queryResult[0] == null ? null : Long.parseLong(queryResult[0].toString()));
//            returnData.setName(queryResult[1] == null ? "" : queryResult[1].toString());
//            returnData.setUsername(queryResult[2] == null ? "" : queryResult[2].toString());
//            returnData.setToken(queryResult[3] == null ? "" : queryResult[3].toString());
//
//            returnData.setTokenexpiry((queryResult[4] instanceof Date) ? (Date) queryResult[4] : null);
//            returnData.setStatus(queryResult[5] == null ? null : Integer.parseInt(queryResult[5].toString()));
//        }
//
//        return returnData;
//    }
//
//    @Override
//    public voUserData getAuthenticationTokenRole(String token) {
//        String sql = "select tu.nid, tu.vfull_name, tu.vusername, tu.vusertoken, tu.ttokenexpiry, tu.nstatus,\n"
//                + " d.vcode as vcode,c.nid_school_unit as school_unit,c.nid_cbu,e.nid_school_level,e.vcode as vcode_school_unit \n"
//                + " from tblm_user tu\n"
//                + " join tblt_role_mapping b on tu.nid = b.nid_user\n"
//                + " join tblh_employee c on tu.nid_employee = c.nid\n"
//                + " join tblm_role d on b.nid_role = d.nid\n "
//                + " join tblm_school_unit e on c.nid_school_unit = e.nid  "
//                + " where tu.vusertoken = :TOKEN and tu.ttokenexpiry >= CURRENT_TIMESTAMP";
//        NativeQuery query = getCurrentSession().createNativeQuery(sql);
//
//        query.setParameter("TOKEN", token);
//        List<Object> roleList = query.list();
//
//        voUserData returnData = new voUserData();
//
//        List<String> vcodeRoleList = new ArrayList<String>();
//        for (Object dr : roleList) {
//            Object queryResult[] = (Object[]) dr;
//            
//            if (queryResult != null) {
//                returnData.setId(queryResult[0] == null ? null : Long.parseLong(queryResult[0].toString()));
//                returnData.setName(queryResult[1] == null ? "" : queryResult[1].toString());
//                returnData.setUsername(queryResult[2] == null ? "" : queryResult[2].toString());
//                returnData.setToken(queryResult[3] == null ? "" : queryResult[3].toString());
//
//                returnData.setTokenexpiry((queryResult[4] instanceof Date) ? (Date) queryResult[4] : null);
//                returnData.setStatus(queryResult[5] == null ? null : Integer.parseInt(queryResult[5].toString()));
//                vcodeRoleList.add(queryResult[6] == null ? "" : queryResult[6].toString());
//                returnData.setNidSchoolUnit(queryResult[7] == null ? null : Integer.valueOf(queryResult[7].toString()));
//                returnData.setNidCBU(queryResult[8] == null ? null : Integer.valueOf(queryResult[8].toString()));
//                returnData.setNidSchoolLevel(queryResult[9] == null ? null : Integer.valueOf(queryResult[9].toString()));
//                returnData.setVcodeSchoolUnit(queryResult[10] == null ? "" : queryResult[10].toString());
//            }
//        }
//        returnData.setVcodeRole(vcodeRoleList);
//
//        return returnData;
//    }
//
//}
