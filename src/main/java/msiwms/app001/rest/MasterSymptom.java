/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msiwms.app001.rest;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import msiwms.app001.service.MasterSymptomService;
import msiwms.app001.vo.voMasterSymptom;
import msiwms.lib.dto.DefaultDtoPagingParams;
import msiwms.lib.dto.DefaultDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Magna Solusi
 */
@RestController
@RequestMapping("/symptom")
public class MasterSymptom {
    
    @Autowired
    private MasterSymptomService masterSymptomService;
    
    @RequestMapping(value = "/dropdowncode", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DefaultDtoResponse getData(
            @RequestHeader(value = "AUTHTOKEN", defaultValue = "") String token,
            @RequestBody DefaultDtoPagingParams vo,
            HttpServletRequest request) throws IOException {

        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        return masterSymptomService.getDropdownCodeSymptom(vo);
    }
    
    @RequestMapping(value = "/monitoring", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DefaultDtoResponse getDataMonitoring(
            @RequestHeader(value = "AUTHTOKEN", defaultValue = "") String token,
            @RequestBody DefaultDtoPagingParams vo,
            HttpServletRequest request) throws IOException {

        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        return masterSymptomService.get(vo);
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DefaultDtoResponse addData(
            @RequestHeader(value = "AUTHTOKEN", defaultValue = "") String token,
            @RequestBody voMasterSymptom vo,
            HttpServletRequest request) throws IOException {
        
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        return masterSymptomService.add(vo);
    }
    
    
}
