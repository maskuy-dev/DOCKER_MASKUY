/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
//package msimpa.lib.service.impl;
//
//import java.time.LocalDateTime;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import msimpa.lib.dao.UserTokenDao;
//import msimpa.lib.vo.voUserData;
//import msimpa.lib.dao.DefaultHibernateDao;
//import msimpa.lib.service.UserTokenService;
//import msisms.model.MsismsMstUser;
//import org.hibernate.query.Query;
//
///**
// *
// * @author kevin.jh
// */
//@Transactional(readOnly = true)
//@Service(value = "UserTokenService")
//@PropertySource({"classpath:config.properties"})
//public class UserTokenServiceImpl extends DefaultHibernateDao<MsismsMstUser, Number> implements UserTokenService {
//
//    @Autowired
//    @Qualifier(value = "userTokenDao")
//    private UserTokenDao userTokenDao;
//
//    @Override
//    public voUserData authenticateToken(String token, String servicePath) {
//
//        voUserData userData = userTokenDao.getAuthenticationToken(token, servicePath);
//        try {
//            if (userData != null) {
//                CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
//
//                CriteriaQuery<MsismsMstUser> criteria = builder.createQuery(MsismsMstUser.class);
//                Root<MsismsMstUser> root = criteria.from(MsismsMstUser.class);
//                criteria.select(root);
//                criteria.where(builder.equal(root.get("vusertoken"), token));
//
//                Query<MsismsMstUser> query = getCurrentSession().createQuery(criteria);
//
//                MsismsMstUser userModelData = query.uniqueResult();
//                if (userModelData != null) {
//                    LocalDateTime tokenExpiryNew = LocalDateTime.now().plusHours(1);
//                    userModelData.setTtokenexpiry(tokenExpiryNew);
//                    userTokenDao.update(userModelData);
//                    userTokenDao.flush();
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return userData;
//    }
//
//    @Override
//    public voUserData authenticateToken(String token) {
//
//        voUserData userData = userTokenDao.getAuthenticationToken(token);
//        try {
//            if (userData != null) {
//                CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
//
//                CriteriaQuery<MsismsMstUser> criteria = builder.createQuery(MsismsMstUser.class);
//                Root<MsismsMstUser> root = criteria.from(MsismsMstUser.class);
//                criteria.select(root);
//                criteria.where(builder.equal(root.get("vusertoken"), token));
//
//                Query<MsismsMstUser> query = getCurrentSession().createQuery(criteria);
//
//                MsismsMstUser userModelData = query.uniqueResult();
//                if (userModelData != null) {
//                    LocalDateTime tokenExpiryNew = LocalDateTime.now().plusHours(1);
//                    userModelData.setTtokenexpiry(tokenExpiryNew);
//                    userTokenDao.update(userModelData);
//                    userTokenDao.flush();
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return userData;
//    }
//    
//    @Override
//    public voUserData authenticateTokenRole(String token) {
//
//        voUserData userData = userTokenDao.getAuthenticationTokenRole(token);
//        try {
//            if (userData != null) {
//                CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
//
//                CriteriaQuery<MsismsMstUser> criteria = builder.createQuery(MsismsMstUser.class);
//                Root<MsismsMstUser> root = criteria.from(MsismsMstUser.class);
//                criteria.select(root);
//                criteria.where(builder.equal(root.get("vusertoken"), token));
//
//                Query<MsismsMstUser> query = getCurrentSession().createQuery(criteria);
//
//                MsismsMstUser userModelData = query.uniqueResult();
//                if (userModelData != null) {
//                    LocalDateTime tokenExpiryNew = LocalDateTime.now().plusHours(1);
//                    userModelData.setTtokenexpiry(tokenExpiryNew);
//                    userTokenDao.update(userModelData);
//                    userTokenDao.flush();
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return userData;
//    }
//}
