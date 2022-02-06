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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bridge")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bridge.findAll", query = "SELECT b FROM Bridge b"),
    @NamedQuery(name = "Bridge.findByBridgeId", query = "SELECT b FROM Bridge b WHERE b.bridgeId = :bridgeId"),
    @NamedQuery(name = "Bridge.findByName", query = "SELECT b FROM Bridge b WHERE b.name = :name"),
    @NamedQuery(name = "Bridge.findByCode", query = "SELECT b FROM Bridge b WHERE b.code = :code"),
    @NamedQuery(name = "Bridge.findByRoute", query = "SELECT b FROM Bridge b WHERE b.route = :route"),
    @NamedQuery(name = "Bridge.findByMileage", query = "SELECT b FROM Bridge b WHERE b.mileage = :mileage"),
    @NamedQuery(name = "Bridge.findByPavedRoute", query = "SELECT b FROM Bridge b WHERE b.pavedRoute = :pavedRoute"),
    @NamedQuery(name = "Bridge.findByHorizontalAlignment", query = "SELECT b FROM Bridge b WHERE b.horizontalAlignment = :horizontalAlignment"),
    @NamedQuery(name = "Bridge.findBySkew", query = "SELECT b FROM Bridge b WHERE b.skew = :skew"),
    @NamedQuery(name = "Bridge.findByNorthUtmCoordinates", query = "SELECT b FROM Bridge b WHERE b.northUtmCoordinates = :northUtmCoordinates"),
    @NamedQuery(name = "Bridge.findByEastUtmCoordinates", query = "SELECT b FROM Bridge b WHERE b.eastUtmCoordinates = :eastUtmCoordinates"),
    @NamedQuery(name = "Bridge.findByPopulationBefore", query = "SELECT b FROM Bridge b WHERE b.populationBefore = :populationBefore"),
    @NamedQuery(name = "Bridge.findByPopulationAfter", query = "SELECT b FROM Bridge b WHERE b.populationAfter = :populationAfter"),
    @NamedQuery(name = "Bridge.findByStatus", query = "SELECT b FROM Bridge b WHERE b.status = :status"),
    @NamedQuery(name = "Bridge.findByTrafficLight", query = "SELECT b FROM Bridge b WHERE b.trafficLight = :trafficLight"),
    @NamedQuery(name = "Bridge.findByEvaluationStartDate", query = "SELECT b FROM Bridge b WHERE b.evaluationStartDate = :evaluationStartDate"),
    @NamedQuery(name = "Bridge.findByEvaluationEndDate", query = "SELECT b FROM Bridge b WHERE b.evaluationEndDate = :evaluationEndDate"),
    @NamedQuery(name = "Bridge.findByLong1", query = "SELECT b FROM Bridge b WHERE b.long1 = :long1"),
    @NamedQuery(name = "Bridge.findByLat", query = "SELECT b FROM Bridge b WHERE b.lat = :lat"),
    @NamedQuery(name = "Bridge.findByType", query = "SELECT b FROM Bridge b WHERE b.type = :type"),
    @NamedQuery(name = "Bridge.findByExtra", query = "SELECT b FROM Bridge b WHERE b.extra = :extra")})
public class Bridge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bridge_id")
    private Long bridgeId;
    @Size(max = 450)
    @Column(name = "`name`")
    private String name;
    @Size(max = 450)
    @Column(name = "`code`")
    private String code;
    @Size(max = 450)
    @Column(name = "route")
    private String route;
    @Column(name = "mileage")
    private Integer mileage;
    @Size(max = 450)
    @Column(name = "paved_route")
    private String pavedRoute;
    @Size(max = 450)
    @Column(name = "horizontal_alignment")
    private String horizontalAlignment;
    @Size(max = 450)
    @Column(name = "skew")
    private String skew;
    @Size(max = 450)
    @Column(name = "north_utm_coordinates")
    private String northUtmCoordinates;
    @Size(max = 450)
    @Column(name = "east_utm_coordinates")
    private String eastUtmCoordinates;
    @Size(max = 450)
    @Column(name = "population_before")
    private String populationBefore;
    @Size(max = 450)
    @Column(name = "population_after")
    private String populationAfter;
    @Size(max = 450)
    @Column(name = "`status`")
    private String status;
    @Size(max = 450)
    @Column(name = "traffic_light")
    private String trafficLight;
    @Column(name = "evaluation_start_date")
    @Temporal(TemporalType.DATE)
    private Date evaluationStartDate;
    @Column(name = "evaluation_end_date")
    @Temporal(TemporalType.DATE)
    private Date evaluationEndDate;
    @Size(max = 45)
    @Column(name = "`long`")
    private String long1;
    @Size(max = 45)
    @Column(name = "lat")
    private String lat;
    @Size(max = 450)
    @Column(name = "`type`")
    private String type;
    @Size(max = 450)
    @Column(name = "extra")
    private String extra;
    
    
    @OneToMany(mappedBy = "bridgeBridgeId")
    private List<BridgeInspector> bridgeInspectorList;
    @OneToMany(mappedBy = "bridgeBridgeId")
    private List<Stretch> stretchList;
    @OneToMany(mappedBy = "bridgeBridgeId")
    private List<Image> imageList;
    @OneToMany(mappedBy = "bridgeBridgeId")
    private List<Blueprint> blueprintList;
    @OneToMany(mappedBy = "bridgeBridgeId")
    private List<Stapes> stapesList;
    @OneToMany(mappedBy = "bridgeBridgeId")
    private List<Comment> commentList;
    
    
    @OneToMany(mappedBy = "bridgeBridgeId")
    private List<Sensor> sensorList;

    @JoinColumn(name = "channel_channel_id", referencedColumnName = "channel_id")
    @ManyToOne
    private Channel channelChannelId;
    
    
    @JoinColumn(name = "departament_departament_id", referencedColumnName = "departament_id")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Departament departamentDepartamentId;
    
    @JoinColumn(name = "general_data_general_data_id", referencedColumnName = "general_data_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private GeneralData generalDataGeneralDataId;
    @JoinColumn(name = "municipality_municipality_id", referencedColumnName = "municipality_id")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Municipality municipalityMunicipalityId;
    @JoinColumn(name = "non_structural_elements_non_structural_elements_id", referencedColumnName = "non_structural_elements_id")
    @ManyToOne
    private NonStructuralElements nonStructuralElementsNonStructuralElementsId;
    @JoinColumn(name = "other_other_id", referencedColumnName = "other_id")
    @ManyToOne
    private Other otherOtherId;
    @JoinColumn(name = "pile_pile_id", referencedColumnName = "pile_id")
    @ManyToOne
    private Pile pilePileId;
    @JoinColumn(name = "superstructure_superstructure_id", referencedColumnName = "superstructure_id")
    @ManyToOne
    private Superstructure superstructureSuperstructureId;

    public Bridge() {
    }

    public Bridge(Long bridgeId) {
        this.bridgeId = bridgeId;
    }

    public Long getBridgeId() {
        return bridgeId;
    }

    public void setBridgeId(Long bridgeId) {
        this.bridgeId = bridgeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getPavedRoute() {
        return pavedRoute;
    }

    public void setPavedRoute(String pavedRoute) {
        this.pavedRoute = pavedRoute;
    }

    public String getHorizontalAlignment() {
        return horizontalAlignment;
    }

    public void setHorizontalAlignment(String horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    public String getSkew() {
        return skew;
    }

    public void setSkew(String skew) {
        this.skew = skew;
    }

    public String getNorthUtmCoordinates() {
        return northUtmCoordinates;
    }

    public void setNorthUtmCoordinates(String northUtmCoordinates) {
        this.northUtmCoordinates = northUtmCoordinates;
    }

    public String getEastUtmCoordinates() {
        return eastUtmCoordinates;
    }

    public void setEastUtmCoordinates(String eastUtmCoordinates) {
        this.eastUtmCoordinates = eastUtmCoordinates;
    }

    public String getPopulationBefore() {
        return populationBefore;
    }

    public void setPopulationBefore(String populationBefore) {
        this.populationBefore = populationBefore;
    }

    public String getPopulationAfter() {
        return populationAfter;
    }

    public void setPopulationAfter(String populationAfter) {
        this.populationAfter = populationAfter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(String trafficLight) {
        this.trafficLight = trafficLight;
    }

    public Date getEvaluationStartDate() {
        return evaluationStartDate;
    }

    public void setEvaluationStartDate(Date evaluationStartDate) {
        this.evaluationStartDate = evaluationStartDate;
    }

    public Date getEvaluationEndDate() {
        return evaluationEndDate;
    }

    public void setEvaluationEndDate(Date evaluationEndDate) {
        this.evaluationEndDate = evaluationEndDate;
    }

    public String getLong1() {
        return long1;
    }

    public void setLong1(String long1) {
        this.long1 = long1;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @XmlTransient
    public List<BridgeInspector> getBridgeInspectorList() {
        return bridgeInspectorList;
    }

    public void setBridgeInspectorList(List<BridgeInspector> bridgeInspectorList) {
        this.bridgeInspectorList = bridgeInspectorList;
    }

    @XmlTransient
    public List<Stretch> getStretchList() {
        return stretchList;
    }

    public void setStretchList(List<Stretch> stretchList) {
        this.stretchList = stretchList;
    }

    @XmlTransient
    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    @XmlTransient
    public List<Blueprint> getBlueprintList() {
        return blueprintList;
    }

    public void setBlueprintList(List<Blueprint> blueprintList) {
        this.blueprintList = blueprintList;
    }

    @XmlTransient
    public List<Stapes> getStapesList() {
        return stapesList;
    }

    public void setStapesList(List<Stapes> stapesList) {
        this.stapesList = stapesList;
    }

    @XmlTransient
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @XmlTransient
    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<Sensor> sensorList) {
        this.sensorList = sensorList;
    }

    public Channel getChannelChannelId() {
        return channelChannelId;
    }

    public void setChannelChannelId(Channel channelChannelId) {
        this.channelChannelId = channelChannelId;
    }

    public Departament getDepartamentDepartamentId() {
        return departamentDepartamentId;
    }

    public void setDepartamentDepartamentId(Departament departamentDepartamentId) {
        this.departamentDepartamentId = departamentDepartamentId;
    }

    public GeneralData getGeneralDataGeneralDataId() {
        return generalDataGeneralDataId;
    }

    public void setGeneralDataGeneralDataId(GeneralData generalDataGeneralDataId) {
        this.generalDataGeneralDataId = generalDataGeneralDataId;
    }

    public Municipality getMunicipalityMunicipalityId() {
        return municipalityMunicipalityId;
    }

    public void setMunicipalityMunicipalityId(Municipality municipalityMunicipalityId) {
        this.municipalityMunicipalityId = municipalityMunicipalityId;
    }

    public NonStructuralElements getNonStructuralElementsNonStructuralElementsId() {
        return nonStructuralElementsNonStructuralElementsId;
    }

    public void setNonStructuralElementsNonStructuralElementsId(NonStructuralElements nonStructuralElementsNonStructuralElementsId) {
        this.nonStructuralElementsNonStructuralElementsId = nonStructuralElementsNonStructuralElementsId;
    }

    public Other getOtherOtherId() {
        return otherOtherId;
    }

    public void setOtherOtherId(Other otherOtherId) {
        this.otherOtherId = otherOtherId;
    }

    public Pile getPilePileId() {
        return pilePileId;
    }

    public void setPilePileId(Pile pilePileId) {
        this.pilePileId = pilePileId;
    }

    public Superstructure getSuperstructureSuperstructureId() {
        return superstructureSuperstructureId;
    }

    public void setSuperstructureSuperstructureId(Superstructure superstructureSuperstructureId) {
        this.superstructureSuperstructureId = superstructureSuperstructureId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bridgeId != null ? bridgeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bridge)) {
            return false;
        }
        Bridge other = (Bridge) object;
        if ((this.bridgeId == null && other.bridgeId != null) || (this.bridgeId != null && !this.bridgeId.equals(other.bridgeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Bridge[ bridgeId=" + bridgeId + " ]";
    }
    
}
