/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msiwms.app001.dao;

import msiwms.app001.dao.*;
import java.util.List;
import msiwms.app001.vo.voMasterSymptom;
import msiwms.lib.dao.DefaultDao;
import msiwms.lib.dto.DefaultDtoPagingParams;
import msiwms.model.MsiwmsMasterSymptom;

/**
 *
 * @author Magna Solusi
 */
public interface MasterSymptomDao extends DefaultDao<MsiwmsMasterSymptom, Number> {
    public List<voMasterSymptom> getData(DefaultDtoPagingParams vo);
}
