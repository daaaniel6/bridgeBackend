/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "protection_works")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProtectionWorks.findAll", query = "SELECT p FROM ProtectionWorks p"),
    @NamedQuery(name = "ProtectionWorks.findByProtectionWorksId", query = "SELECT p FROM ProtectionWorks p WHERE p.protectionWorksId = :protectionWorksId"),
    @NamedQuery(name = "ProtectionWorks.findByNameProtectionWorks", query = "SELECT p FROM ProtectionWorks p WHERE p.nameProtectionWorks = :nameProtectionWorks"),
    @NamedQuery(name = "ProtectionWorks.findByMaterial", query = "SELECT p FROM ProtectionWorks p WHERE p.material = :material"),
    @NamedQuery(name = "ProtectionWorks.findByType", query = "SELECT p FROM ProtectionWorks p WHERE p.type = :type"),
    @NamedQuery(name = "ProtectionWorks.findByLong1", query = "SELECT p FROM ProtectionWorks p WHERE p.long1 = :long1"),
    @NamedQuery(name = "ProtectionWorks.findByWidth", query = "SELECT p FROM ProtectionWorks p WHERE p.width = :width"),
    @NamedQuery(name = "ProtectionWorks.findByHeight", query = "SELECT p FROM ProtectionWorks p WHERE p.height = :height")})
public class ProtectionWorks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "protection_works_id")
    private Long protectionWorksId;
    @Column(name = "name_protection_works")
    private String nameProtectionWorks;
    @Column(name = "material")
    private String material;
    @Column(name = "type")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "long")
    private Double long1;
    @Column(name = "width")
    private Double width;
    @Column(name = "height")
    private Double height;
    @JoinColumn(name = "non_structural_elements_non_structural_elements_id", referencedColumnName = "non_structural_elements_id")
    @ManyToOne
    private NonStructuralElements nonStructuralElementsNonStructuralElementsId;

    public ProtectionWorks() {
    }

    public ProtectionWorks(Long protectionWorksId) {
        this.protectionWorksId = protectionWorksId;
    }

    public Long getProtectionWorksId() {
        return protectionWorksId;
    }

    public void setProtectionWorksId(Long protectionWorksId) {
        this.protectionWorksId = protectionWorksId;
    }

    public String getNameProtectionWorks() {
        return nameProtectionWorks;
    }

    public void setNameProtectionWorks(String nameProtectionWorks) {
        this.nameProtectionWorks = nameProtectionWorks;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLong1() {
        return long1;
    }

    public void setLong1(Double long1) {
        this.long1 = long1;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public NonStructuralElements getNonStructuralElementsNonStructuralElementsId() {
        return nonStructuralElementsNonStructuralElementsId;
    }

    public void setNonStructuralElementsNonStructuralElementsId(NonStructuralElements nonStructuralElementsNonStructuralElementsId) {
        this.nonStructuralElementsNonStructuralElementsId = nonStructuralElementsNonStructuralElementsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (protectionWorksId != null ? protectionWorksId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProtectionWorks)) {
            return false;
        }
        ProtectionWorks other = (ProtectionWorks) object;
        if ((this.protectionWorksId == null && other.protectionWorksId != null) || (this.protectionWorksId != null && !this.protectionWorksId.equals(other.protectionWorksId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.ProtectionWorks[ protectionWorksId=" + protectionWorksId + " ]";
    }
    
}
