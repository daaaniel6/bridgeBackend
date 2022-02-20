/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "handrail_railing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HandrailRailing.findAll", query = "SELECT h FROM HandrailRailing h"),
    @NamedQuery(name = "HandrailRailing.findByHandrailRailingId", query = "SELECT h FROM HandrailRailing h WHERE h.handrailRailingId = :handrailRailingId"),
    @NamedQuery(name = "HandrailRailing.findByMaterial", query = "SELECT h FROM HandrailRailing h WHERE h.material = :material"),
    @NamedQuery(name = "HandrailRailing.findByAbsenceOfSection", query = "SELECT h FROM HandrailRailing h WHERE h.absenceOfSection = :absenceOfSection"),
    @NamedQuery(name = "HandrailRailing.findByElementDeformation", query = "SELECT h FROM HandrailRailing h WHERE h.elementDeformation = :elementDeformation"),
    @NamedQuery(name = "HandrailRailing.findByBeaten", query = "SELECT h FROM HandrailRailing h WHERE h.beaten = :beaten"),
    @NamedQuery(name = "HandrailRailing.findByPainting", query = "SELECT h FROM HandrailRailing h WHERE h.painting = :painting"),
    @NamedQuery(name = "HandrailRailing.findByOthers", query = "SELECT h FROM HandrailRailing h WHERE h.others = :others"),
    @NamedQuery(name = "HandrailRailing.findByExtra", query = "SELECT h FROM HandrailRailing h WHERE h.extra = :extra")})
public class HandrailRailing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "handrail_railing_id")
    private Long handrailRailingId;
    @Size(max = 450)
    @Column(name = "material")
    private String material;
    @Size(max = 450)
    @Column(name = "absence_of_section")
    private String absenceOfSection;
    @Size(max = 450)
    @Column(name = "element_deformation")
    private String elementDeformation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "beaten")
    private Double beaten;
    @Size(max = 450)
    @Column(name = "painting")
    private String painting;
    @Size(max = 450)
    @Column(name = "others")
    private String others;
    @Size(max = 45)
    @Column(name = "extra")
    private String extra;
    
    @JsonIgnore
    @OneToMany(mappedBy = "handrailRailingHandrailRailingId")
    private List<NonStructuralElements> nonStructuralElementsList;

    public HandrailRailing() {
    }

    public HandrailRailing(Long handrailRailingId) {
        this.handrailRailingId = handrailRailingId;
    }

    public Long getHandrailRailingId() {
        return handrailRailingId;
    }

    public void setHandrailRailingId(Long handrailRailingId) {
        this.handrailRailingId = handrailRailingId;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getAbsenceOfSection() {
        return absenceOfSection;
    }

    public void setAbsenceOfSection(String absenceOfSection) {
        this.absenceOfSection = absenceOfSection;
    }

    public String getElementDeformation() {
        return elementDeformation;
    }

    public void setElementDeformation(String elementDeformation) {
        this.elementDeformation = elementDeformation;
    }

    public Double getBeaten() {
        return beaten;
    }

    public void setBeaten(Double beaten) {
        this.beaten = beaten;
    }

    public String getPainting() {
        return painting;
    }

    public void setPainting(String painting) {
        this.painting = painting;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @XmlTransient
    public List<NonStructuralElements> getNonStructuralElementsList() {
        return nonStructuralElementsList;
    }

    public void setNonStructuralElementsList(List<NonStructuralElements> nonStructuralElementsList) {
        this.nonStructuralElementsList = nonStructuralElementsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (handrailRailingId != null ? handrailRailingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HandrailRailing)) {
            return false;
        }
        HandrailRailing other = (HandrailRailing) object;
        if ((this.handrailRailingId == null && other.handrailRailingId != null) || (this.handrailRailingId != null && !this.handrailRailingId.equals(other.handrailRailingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.HandrailRailing[ handrailRailingId=" + handrailRailingId + " ]";
    }
    
}
