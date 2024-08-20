/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msiwms.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import msiwms.lib.model.DefaultEntityImpl;

/**
 *
 * @author Magna Solusi
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "tblm_symptom")
public class MsiwmsMasterSymptom extends DefaultEntityImpl implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nid;
    
    @Column(name="vsymptomname", nullable=false)
    private String vsymptomname;
    
    @Column(name="vsymptomcode", nullable=false)
    private String vsymptomcode;
    
    @Column(name="vsymptomcategory", nullable=false)
    private String vsymptomcategory;
    
    @Column(name="nstatus", nullable=true)
    private Short nstatus;
}
