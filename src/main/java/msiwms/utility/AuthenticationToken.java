/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msiwms.utility;

import java.util.HashMap;
import java.util.Map;
import msiwms.lib.dto.DefaultDtoResponse;
import msiwms.lib.vo.voUserData;
//import msi.app000.vo.voUserData;

/**
 *
 * @author Magna Solusi
 */
public class AuthenticationToken {

    public static Map<Integer, Object> authenticateUser(voUserData userData) {
        Map<Integer, Object> returnData = new HashMap();
        if (userData.getToken() == null) {
            Map<String, Object> msg = new HashMap<String, Object>();
            msg.put("errmsg", "Authentication Denied");
            returnData.put(1, DtoUtility.buildResponse(0, msg, null));
        } else {

        }
        return returnData;
    }
}
