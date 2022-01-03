/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.model;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "other")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Other.findAll", query = "SELECT o FROM Other o"),
    @NamedQuery(name = "Other.findByOtherId", query = "SELECT o FROM Other o WHERE o.otherId = :otherId"),
    @NamedQuery(name = "Other.findByInformativeSignage", query = "SELECT o FROM Other o WHERE o.informativeSignage = :informativeSignage"),
    @NamedQuery(name = "Other.findByPreventiveSignage", query = "SELECT o FROM Other o WHERE o.preventiveSignage = :preventiveSignage"),
    @NamedQuery(name = "Other.findByRegulatorySignage", query = "SELECT o FROM Other o WHERE o.regulatorySignage = :regulatorySignage"),
    @NamedQuery(name = "Other.findByHorizontalSignage", query = "SELECT o FROM Other o WHERE o.horizontalSignage = :horizontalSignage"),
    @NamedQuery(name = "Other.findByArtificialLighting", query = "SELECT o FROM Other o WHERE o.artificialLighting = :artificialLighting"),
    @NamedQuery(name = "Other.findBySewerSystem", query = "SELECT o FROM Other o WHERE o.sewerSystem = :sewerSystem"),
    @NamedQuery(name = "Other.findByDrainageStatus", query = "SELECT o FROM Other o WHERE o.drainageStatus = :drainageStatus"),
    @NamedQuery(name = "Other.findByObservation", query = "SELECT o FROM Other o WHERE o.observation = :observation"),
    @NamedQuery(name = "Other.findByExtra", query = "SELECT o FROM Other o WHERE o.extra = :extra")})
public class Other implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "other_id")
    private Long otherId;
    @Column(name = "informative_signage")
    private String informativeSignage;
    @Column(name = "preventive_signage")
    private String preventiveSignage;
    @Column(name = "regulatory_signage")
    private String regulatorySignage;
    @Column(name = "horizontal_signage")
    private String horizontalSignage;
    @Column(name = "artificial_lighting")
    private String artificialLighting;
    @Column(name = "sewer_system")
    private String sewerSystem;
    @Column(name = "drainage_status")
    private String drainageStatus;
    @Column(name = "observation")
    private String observation;
    @Column(name = "extra")
    private String extra;
    @OneToMany(mappedBy = "otherOtherId")
    private List<ImageOther> imageOtherList;
    @OneToMany(mappedBy = "otherOtherId")
    private List<Bridge> bridgeList;

    public Other() {
    }

    public Other(Long otherId) {
        this.otherId = otherId;
    }

    public Long getOtherId() {
        return otherId;
    }

    public void setOtherId(Long otherId) {
        this.otherId = otherId;
    }

    public String getInformativeSignage() {
        return informativeSignage;
    }

    public void setInformativeSignage(String informativeSignage) {
        this.informativeSignage = informativeSignage;
    }

    public String getPreventiveSignage() {
        return preventiveSignage;
    }

    public void setPreventiveSignage(String preventiveSignage) {
        this.preventiveSignage = preventiveSignage;
    }

    public String getRegulatorySignage() {
        return regulatorySignage;
    }

    public void setRegulatorySignage(String regulatorySignage) {
        this.regulatorySignage = regulatorySignage;
    }

    public String getHorizontalSignage() {
        return horizontalSignage;
    }

    public void setHorizontalSignage(String horizontalSignage) {
        this.horizontalSignage = horizontalSignage;
    }

    public String getArtificialLighting() {
        return artificialLighting;
    }

    public void setArtificialLighting(String artificialLighting) {
        this.artificialLighting = artificialLighting;
    }

    public String getSewerSystem() {
        return sewerSystem;
    }

    public void setSewerSystem(String sewerSystem) {
        this.sewerSystem = sewerSystem;
    }

    public String getDrainageStatus() {
        return drainageStatus;
    }

    public void setDrainageStatus(String drainageStatus) {
        this.drainageStatus = drainageStatus;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @XmlTransient
    public List<ImageOther> getImageOtherList() {
        return imageOtherList;
    }

    public void setImageOtherList(List<ImageOther> imageOtherList) {
        this.imageOtherList = imageOtherList;
    }

    @XmlTransient
    public List<Bridge> getBridgeList() {
        return bridgeList;
    }

    public void setBridgeList(List<Bridge> bridgeList) {
        this.bridgeList = bridgeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (otherId != null ? otherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Other)) {
            return false;
        }
        Other other = (Other) object;
        if ((this.otherId == null && other.otherId != null) || (this.otherId != null && !this.otherId.equals(other.otherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Other[ otherId=" + otherId + " ]";
    }
    
}
