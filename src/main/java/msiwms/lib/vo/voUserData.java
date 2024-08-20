/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msiwms.lib.vo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Magna Solusi
 */
public class voUserData {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpSts() {
        return empSts;
    }

    public void setEmpSts(String empSts) {
        this.empSts = empSts;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenexpiry() {
        return tokenexpiry;
    }

    public void setTokenexpiry(Date tokenexpiry) {
        this.tokenexpiry = tokenexpiry;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Integer> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Integer> roleList) {
        this.roleList = roleList;
    }

    public List<Integer> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Integer> serviceList) {
        this.serviceList = serviceList;
    }

    public Integer getNidSchoolUnit() {
        return nidSchoolUnit;
    }

    public void setNidSchoolUnit(Integer nidSchoolUnit) {
        this.nidSchoolUnit = nidSchoolUnit;
    }

    public Integer getNidCBU() {
        return nidCBU;
    }

    public void setNidCBU(Integer nidCBU) {
        this.nidCBU = nidCBU;
    }

    public Integer getNidSchoolLevel() {
        return nidSchoolLevel;
    }

    public void setNidSchoolLevel(Integer nidSchoolLevel) {
        this.nidSchoolLevel = nidSchoolLevel;
    }

    public String getVcodeSchoolUnit() {
        return vcodeSchoolUnit;
    }

    public void setVcodeSchoolUnit(String vcodeSchoolUnit) {
        this.vcodeSchoolUnit = vcodeSchoolUnit;
    }

    public List<String> getVcodeRole() {
        return vcodeRole;
    }

    public void setVcodeRole(List<String> vcodeRole) {
        this.vcodeRole = vcodeRole;
    }

    private Long id;
    private String name;
    private String username;
    private String email;
    private String empSts;
    private Integer pmId;
    private String token;
    private Date tokenexpiry;
    private Integer status;
    private List<Integer> roleList;
    private List<Integer> serviceList;
    private List<String> vcodeRole;
    private Integer nidSchoolUnit;
    private Integer nidCBU;
    private Integer nidSchoolLevel;
    private String vcodeSchoolUnit;

    /* init
    
        private Long id;
    private String name;
    private String username;
    private String email;
    private String empSts;
    private Integer pmId;
    private String token;
    private Date tokenexpiry;
    private Integer status;
    private List<Integer> roleList;
    private List<Integer> serviceList;
    
     */
}
