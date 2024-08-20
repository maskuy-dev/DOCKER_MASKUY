/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msiwms.utility;

import java.util.List;
import java.util.Map;
import msiwms.lib.dto.DefaultDtoResponse;
import msiwms.lib.dto.DefaultDtoResponsePaging;

/**
 *
 * @author magnaadmin
 */
public class DtoUtility {
   
    
    public static DefaultDtoResponse buildResponse(Integer responseStatus, Map<String, Object> msg, List data) {
        DefaultDtoResponse defaultDto = null;
        if (null != responseStatus) {
            switch (responseStatus) {
                case 0:
                    defaultDto = new DefaultDtoResponse();
                    defaultDto.setStatus("0");
                    defaultDto.addMessage("message", "failed");
                    break;
                case 1:
                    defaultDto = new DefaultDtoResponse();
                    defaultDto.setStatus("1");
                    defaultDto.addMessage("message", "success");
                    break;
                default:
                    return null;
            }
        }
        if (msg != null) {
            for (Map.Entry<String, Object> entry : msg.entrySet()) {
                defaultDto.addMessage(entry.getKey(), entry.getValue());
            }
        }
        if (data != null) {
            defaultDto.setData(data);
        }
        return defaultDto;
    }
    
    public static DefaultDtoResponsePaging buildResponsePaging(Integer responseStatus, Map<String, Object> msg, List data, int total) {
        DefaultDtoResponse dtoResponse = buildResponse(responseStatus, msg, data);
        DefaultDtoResponsePaging dtoResponsePaging = new DefaultDtoResponsePaging();
        dtoResponsePaging.setStatus(dtoResponse.getStatus());
        dtoResponsePaging.setData(dtoResponse.getData());
        dtoResponsePaging.setMessage(dtoResponse.getMessage());
        dtoResponsePaging.setTotal(total);
        return dtoResponsePaging;
    }
}
