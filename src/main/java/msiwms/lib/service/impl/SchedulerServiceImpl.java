//package msimpa.lib.service.impl;
////---> PACKAGE
//
//import msimpa.lib.dao.SchedulerDao;
//import msimpa.lib.service.SchedulerService;
//import msimpa.lib.dao.DefaultHibernateDao;
//import msisms.model.MsismsTxnScheduler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//@Transactional(propagation = Propagation.REQUIRES_NEW)
//@Service(value = "schedulerService")
//public class SchedulerServiceImpl extends DefaultHibernateDao<MsismsTxnScheduler, Number> implements SchedulerService {
//
//    @Autowired
//    @Qualifier(value = "schedulerDao")
//    private SchedulerDao schedulerDao;
//
//    public MsismsTxnScheduler logScheduler(String module, String function) {
//        MsismsTxnScheduler newData = new MsismsTxnScheduler();
//        newData.setVmodule(module);
//        newData.setVfunction(function);
//        schedulerDao.save(newData, "SCHEDULER");
//        return newData;
//    }
//
//    public void logScheduler(MsismsTxnScheduler newData, String result, Integer status) {
//        newData.setVresult(result);
//        newData.setNstatus(status);
//        schedulerDao.update(newData, "SCHEDULER");
//    }
//}
