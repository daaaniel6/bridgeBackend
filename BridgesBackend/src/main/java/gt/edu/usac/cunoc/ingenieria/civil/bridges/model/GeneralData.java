/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "general_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralData.findAll", query = "SELECT g FROM GeneralData g"),
    @NamedQuery(name = "GeneralData.findByGeneralDataId", query = "SELECT g FROM GeneralData g WHERE g.generalDataId = :generalDataId"),
    @NamedQuery(name = "GeneralData.findByLength", query = "SELECT g FROM GeneralData g WHERE g.length = :length"),
    @NamedQuery(name = "GeneralData.findByNumberSections", query = "SELECT g FROM GeneralData g WHERE g.numberSections = :numberSections"),
    @NamedQuery(name = "GeneralData.findByTreadWidth", query = "SELECT g FROM GeneralData g WHERE g.treadWidth = :treadWidth"),
    @NamedQuery(name = "GeneralData.findByCurbWidthRight", query = "SELECT g FROM GeneralData g WHERE g.curbWidthRight = :curbWidthRight"),
    @NamedQuery(name = "GeneralData.findByCurbWidthLeft", query = "SELECT g FROM GeneralData g WHERE g.curbWidthLeft = :curbWidthLeft"),
    @NamedQuery(name = "GeneralData.findByBridgeTypology", query = "SELECT g FROM GeneralData g WHERE g.bridgeTypology = :bridgeTypology"),
    @NamedQuery(name = "GeneralData.findByTopHeadroom", query = "SELECT g FROM GeneralData g WHERE g.topHeadroom = :topHeadroom"),
    @NamedQuery(name = "GeneralData.findByFreeHeightAboveRiver", query = "SELECT g FROM GeneralData g WHERE g.freeHeightAboveRiver = :freeHeightAboveRiver"),
    @NamedQuery(name = "GeneralData.findByBridgeOver", query = "SELECT g FROM GeneralData g WHERE g.bridgeOver = :bridgeOver"),
    @NamedQuery(name = "GeneralData.findByNumberRoads", query = "SELECT g FROM GeneralData g WHERE g.numberRoads = :numberRoads"),
    @NamedQuery(name = "GeneralData.findBySuperstructureMaterial", query = "SELECT g FROM GeneralData g WHERE g.superstructureMaterial = :superstructureMaterial"),
    @NamedQuery(name = "GeneralData.findByTraffic", query = "SELECT g FROM GeneralData g WHERE g.traffic = :traffic"),
    @NamedQuery(name = "GeneralData.findByPercentageTrucksBuses", query = "SELECT g FROM GeneralData g WHERE g.percentageTrucksBuses = :percentageTrucksBuses"),
    @NamedQuery(name = "GeneralData.findByLastEvaluationDate", query = "SELECT g FROM GeneralData g WHERE g.lastEvaluationDate = :lastEvaluationDate")})
public class GeneralData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "general_data_id")
    private Long generalDataId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "length")
    private Double length;
    @Column(name = "number_sections")
    private Integer numberSections;
    @Column(name = "tread_width")
    private Double treadWidth;
    @Column(name = "curb_width_right")
    private Double curbWidthRight;
    @Column(name = "curb_width_left")
    private Double curbWidthLeft;
    @Size(max = 450)
    @Column(name = "bridge_typology")
    private String bridgeTypology;
    @Column(name = "top_headroom")
    private Double topHeadroom;
    @Column(name = "free_height_above_river")
    private Double freeHeightAboveRiver;
    @Size(max = 450)
    @Column(name = "bridge_over")
    private String bridgeOver;
    @Column(name = "number_roads")
    private Integer numberRoads;
    @Size(max = 450)
    @Column(name = "superstructure_material")
    private String superstructureMaterial;
    
    @Size(max = 450)
    @Column(name = "design_load")
    private String designLoad;
    @Column(name = "year_of_construction")
    private Integer yearOfConstruction;
    @Size(max = 450)
    @Column(name = "substructure_material")
    private String substructureMaterial;
    
    
    @Column(name = "traffic")
    private Double traffic;
    @Column(name = "percentage_trucks_buses")
    private Double percentageTrucksBuses;
    @Column(name = "last_evaluation_date")
    @Temporal(TemporalType.DATE)
    private Date lastEvaluationDate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "generalDataGeneralDataId")
    private List<Bridge> bridgeList;

    public GeneralData() {
    }

    public GeneralData(Long generalDataId) {
        this.generalDataId = generalDataId;
    }

    public Long getGeneralDataId() {
        return generalDataId;
    }

    public void setGeneralDataId(Long generalDataId) {
        this.generalDataId = generalDataId;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getNumberSections() {
        return numberSections;
    }

    public void setNumberSections(Integer numberSections) {
        this.numberSections = numberSections;
    }

    public Double getTreadWidth() {
        return treadWidth;
    }

    public void setTreadWidth(Double treadWidth) {
        this.treadWidth = treadWidth;
    }

    public Double getCurbWidthRight() {
        return curbWidthRight;
    }

    public void setCurbWidthRight(Double curbWidthRight) {
        this.curbWidthRight = curbWidthRight;
    }

    public Double getCurbWidthLeft() {
        return curbWidthLeft;
    }

    public void setCurbWidthLeft(Double curbWidthLeft) {
        this.curbWidthLeft = curbWidthLeft;
    }

    public String getBridgeTypology() {
        return bridgeTypology;
    }

    public void setBridgeTypology(String bridgeTypology) {
        this.bridgeTypology = bridgeTypology;
    }

    public Double getTopHeadroom() {
        return topHeadroom;
    }

    public void setTopHeadroom(Double topHeadroom) {
        this.topHeadroom = topHeadroom;
    }

    public Double getFreeHeightAboveRiver() {
        return freeHeightAboveRiver;
    }

    public void setFreeHeightAboveRiver(Double freeHeightAboveRiver) {
        this.freeHeightAboveRiver = freeHeightAboveRiver;
    }

    public String getBridgeOver() {
        return bridgeOver;
    }

    public void setBridgeOver(String bridgeOver) {
        this.bridgeOver = bridgeOver;
    }

    public Integer getNumberRoads() {
        return numberRoads;
    }

    public void setNumberRoads(Integer numberRoads) {
        this.numberRoads = numberRoads;
    }

    public String getSuperstructureMaterial() {
        return superstructureMaterial;
    }

    public void setSuperstructureMaterial(String superstructureMaterial) {
        this.superstructureMaterial = superstructureMaterial;
    }

    public Double getTraffic() {
        return traffic;
    }

    public void setTraffic(Double traffic) {
        this.traffic = traffic;
    }

    public Double getPercentageTrucksBuses() {
        return percentageTrucksBuses;
    }

    public void setPercentageTrucksBuses(Double percentageTrucksBuses) {
        this.percentageTrucksBuses = percentageTrucksBuses;
    }

    public Date getLastEvaluationDate() {
        return lastEvaluationDate;
    }

    public void setLastEvaluationDate(Date lastEvaluationDate) {
        this.lastEvaluationDate = lastEvaluationDate;
    }

    @XmlTransient
    public List<Bridge> getBridgeList() {
        return bridgeList;
    }

    public void setBridgeList(List<Bridge> bridgeList) {
        this.bridgeList = bridgeList;
    }

    public String getDesignLoad() {
        return designLoad;
    }

    public void setDesignLoad(String designLoad) {
        this.designLoad = designLoad;
    }

    public Integer getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(Integer yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public String getSubstructureMaterial() {
        return substructureMaterial;
    }

    public void setSubstructureMaterial(String substructureMaterial) {
        this.substructureMaterial = substructureMaterial;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generalDataId != null ? generalDataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneralData)) {
            return false;
        }
        GeneralData other = (GeneralData) object;
        if ((this.generalDataId == null && other.generalDataId != null) || (this.generalDataId != null && !this.generalDataId.equals(other.generalDataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.GeneralData[ generalDataId=" + generalDataId + " ]";
    }
    
}
