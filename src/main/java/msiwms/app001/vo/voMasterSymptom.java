/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msiwms.app001.vo;

import msiwms.app001.vo.*;

/**
 *
 * @author Magna Solusi
 */
public class voMasterSymptom {
    private Long id;
    private String symptomname;
    private String symptomcode;
    private String symptomcategory;
    private Short status;
    public String getSymptomcategory() {
        return symptomcategory;
    }

    public void setSymptomcategory(String symptomcategory) {
        this.symptomcategory = symptomcategory;
    }

    public String getSymptomname() {
        return symptomname;
    }

    public void setSymptomname(String symptomname) {
        this.symptomname = symptomname;
    }

    public String getSymptomcode() {
        return symptomcode;
    }

    public void setSymptomcode(String symptomcode) {
        this.symptomcode = symptomcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
    
    
}
