package msiwms.app001.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import msiwms.app001.vo.voMasterSymptom;
import msiwms.lib.dto.DefaultDtoPagingParams;
import msiwms.lib.dto.DefaultDtoResponse;
/**
 *
 * @author msiuser
 */
public interface MasterSymptomService {
    DefaultDtoResponse getDropdownCodeSymptom(DefaultDtoPagingParams vo);
    DefaultDtoResponse get(DefaultDtoPagingParams vo);
    DefaultDtoResponse add(voMasterSymptom vo);
}
