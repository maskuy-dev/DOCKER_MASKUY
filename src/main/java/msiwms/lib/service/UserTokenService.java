///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package msiwms.lib.service;

import java.util.List;
import java.util.Map;
import msiwms.lib.vo.voUserData;

/**
 *
 * @author kevin.jh
 */
public interface UserTokenService {

    public voUserData authenticateToken(String token, String servicePath);
    
    public voUserData authenticateToken(String token);
    
    public voUserData authenticateTokenRole(String token);

}
