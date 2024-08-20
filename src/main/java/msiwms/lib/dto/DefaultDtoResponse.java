/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msiwms.lib.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author magnaadmin
 */
public class DefaultDtoResponse {

    
    private String status;
    private List data;
    private Map<String,Object> message;

    public void addMessage(String key,Object value) {
        if(this.message==null){
            this.message=new HashMap<String, Object>();
        }
        this.message.put(key,value);
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String stat) {
        this.status = stat;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Map<String, Object> getMessage() {
        return message;
    }

    public void setMessage(Map<String, Object> message) {
        this.message = message;
    }
}

