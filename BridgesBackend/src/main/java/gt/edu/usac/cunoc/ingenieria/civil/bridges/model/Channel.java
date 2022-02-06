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
import javax.persistence.Lob;
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
@Table(name = "channel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Channel.findAll", query = "SELECT c FROM Channel c"),
    @NamedQuery(name = "Channel.findByChannelId", query = "SELECT c FROM Channel c WHERE c.channelId = :channelId"),
    @NamedQuery(name = "Channel.findByRiverName", query = "SELECT c FROM Channel c WHERE c.riverName = :riverName"),
    @NamedQuery(name = "Channel.findByBodyType", query = "SELECT c FROM Channel c WHERE c.bodyType = :bodyType"),
    @NamedQuery(name = "Channel.findByChannelStatus", query = "SELECT c FROM Channel c WHERE c.channelStatus = :channelStatus"),
    @NamedQuery(name = "Channel.findByStateZoneAdjacentToAbutments", query = "SELECT c FROM Channel c WHERE c.stateZoneAdjacentToAbutments = :stateZoneAdjacentToAbutments"),
    @NamedQuery(name = "Channel.findByChanneling", query = "SELECT c FROM Channel c WHERE c.channeling = :channeling"),
    @NamedQuery(name = "Channel.findByOverflow", query = "SELECT c FROM Channel c WHERE c.overflow = :overflow"),
    @NamedQuery(name = "Channel.findByFrequency", query = "SELECT c FROM Channel c WHERE c.frequency = :frequency"),
    @NamedQuery(name = "Channel.findByLastOverflowDate", query = "SELECT c FROM Channel c WHERE c.lastOverflowDate = :lastOverflowDate"),
    @NamedQuery(name = "Channel.findByObservation", query = "SELECT c FROM Channel c WHERE c.observation = :observation"),
    @NamedQuery(name = "Channel.findByExtra", query = "SELECT c FROM Channel c WHERE c.extra = :extra")})
public class Channel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "channel_id")
    private Long channelId;
    @Size(max = 450)
    @Column(name = "river_name")
    private String riverName;
    @Size(max = 450)
    @Column(name = "body_type")
    private String bodyType;
    @Size(max = 450)
    @Column(name = "channel_status")
    private String channelStatus;
    @Size(max = 450)
    @Column(name = "state_zone_adjacent_to_abutments")
    private String stateZoneAdjacentToAbutments;
    @Size(max = 450)
    @Column(name = "channeling")
    private String channeling;
    @Size(max = 450)
    @Column(name = "overflow")
    private String overflow;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "frequency")
    private Double frequency;
    @Column(name = "last_overflow_date")
    @Temporal(TemporalType.DATE)
    private Date lastOverflowDate;
    @Size(max = 4500)
    @Column(name = "observation")
    private String observation;
    @Size(max = 450)
    @Column(name = "extra")
    private String extra;
    @Lob
    @Column(name = "image")
    private byte[] image;
    
    @JsonIgnore
    @OneToMany(mappedBy = "channelChannelId")
    private List<Bridge> bridgeList;

    public Channel() {
    }

    public Channel(Long channelId) {
        this.channelId = channelId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(String channelStatus) {
        this.channelStatus = channelStatus;
    }

    public String getStateZoneAdjacentToAbutments() {
        return stateZoneAdjacentToAbutments;
    }

    public void setStateZoneAdjacentToAbutments(String stateZoneAdjacentToAbutments) {
        this.stateZoneAdjacentToAbutments = stateZoneAdjacentToAbutments;
    }

    public String getChanneling() {
        return channeling;
    }

    public void setChanneling(String channeling) {
        this.channeling = channeling;
    }

    public String getOverflow() {
        return overflow;
    }

    public void setOverflow(String overflow) {
        this.overflow = overflow;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public Date getLastOverflowDate() {
        return lastOverflowDate;
    }

    public void setLastOverflowDate(Date lastOverflowDate) {
        this.lastOverflowDate = lastOverflowDate;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
        hash += (channelId != null ? channelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Channel)) {
            return false;
        }
        Channel other = (Channel) object;
        if ((this.channelId == null && other.channelId != null) || (this.channelId != null && !this.channelId.equals(other.channelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Channel[ channelId=" + channelId + " ]";
    }
    
}
