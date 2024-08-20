/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msiwms.app001.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import msiwms.app001.dao.MasterSymptomDao;
import msiwms.app001.service.MasterSymptomService;
import msiwms.app001.vo.voMasterSymptom;
import msiwms.lib.dao.DefaultHibernateDao;
import msiwms.lib.dto.DefaultDtoPagingParams;
import msiwms.lib.dto.DefaultDtoResponse;
import msiwms.model.MsiwmsMasterSymptom;
import msiwms.utility.DtoUtility;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Magna Solusi
 */
@Transactional(readOnly = true)
@Service(value = "masterSymptomService")
public class MasterSymptomServceImpl extends DefaultHibernateDao<MsiwmsMasterSymptom, Number> implements MasterSymptomService {

    @Autowired
    @Qualifier(value = "masterSymptomDao")
    private MasterSymptomDao masterSymptomDao;
    
    public DefaultDtoResponse getDropdownCodeSymptom(DefaultDtoPagingParams vo) {
        Map<String, Object> filters = new HashMap<>();

        List<voMasterSymptom> returnData = masterSymptomDao.getData(vo);
        Map<String, Object> msg = new HashMap<String, Object>();

        return DtoUtility.buildResponse(1, msg, returnData);
    }
    
    @Override
    public DefaultDtoResponse get(DefaultDtoPagingParams vo) {
        Map<String, Object> filters = new HashMap<>();

        List<voMasterSymptom> returnData = masterSymptomDao.getData(vo);
        Map<String, Object> msg = new HashMap<String, Object>();

        return DtoUtility.buildResponse(1, msg, returnData);

    }
    
    private MsiwmsMasterSymptom insertSampleData(voMasterSymptom insertData) {
        MsiwmsMasterSymptom newRow = new MsiwmsMasterSymptom();
        newRow.setNid(insertData.getId());
        newRow.setVsymptomname(insertData.getSymptomname());
        newRow.setVsymptomcode(insertData.getSymptomcode());
        newRow.setVsymptomcategory(insertData.getSymptomcategory());
        newRow.setNstatus(Short.parseShort("1"));
        newRow.setCreateBy("Username Login");
        newRow.setCreateDate(new Date());
        return newRow;
    }

    @Override
    public DefaultDtoResponse add(voMasterSymptom vo) {
        Map<String, Object> msg = new HashMap<String, Object>();
        MsiwmsMasterSymptom insertedData = insertSampleData(vo);
        Criteria criteria = getCurrentSession().createCriteria(MsiwmsMasterSymptom.class);
        MsiwmsMasterSymptom checkName = (MsiwmsMasterSymptom) criteria.add(Restrictions.eq("vsymptomcode", vo.getSymptomcode())).uniqueResult();
        if (checkName == null) {
            try {
                masterSymptomDao.save(insertedData);
                msg.put("msg", "data inserted");
                return DtoUtility.buildResponse(1, msg, null);
            } catch (Exception ex) {
                ex.printStackTrace();
                msg.put("errmsg", ex.getMessage());
                return DtoUtility.buildResponse(0, msg, null);
            }
        } else {
            msg.put("errmsg", "data already exist");
            return DtoUtility.buildResponse(0, msg, null);
        }
    }
}
