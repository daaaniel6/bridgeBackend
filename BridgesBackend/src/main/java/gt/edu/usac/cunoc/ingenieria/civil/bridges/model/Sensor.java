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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sensor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sensor.findAll", query = "SELECT s FROM Sensor s"),
    @NamedQuery(name = "Sensor.findBySensorId", query = "SELECT s FROM Sensor s WHERE s.sensorId = :sensorId"),
    @NamedQuery(name = "Sensor.findByName", query = "SELECT s FROM Sensor s WHERE s.name = :name"),
    @NamedQuery(name = "Sensor.findByData", query = "SELECT s FROM Sensor s WHERE s.data = :data"),
    @NamedQuery(name = "Sensor.findByDescription", query = "SELECT s FROM Sensor s WHERE s.description = :description"),
    @NamedQuery(name = "Sensor.findByExtra", query = "SELECT s FROM Sensor s WHERE s.extra = :extra")})
public class Sensor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sensor_id")
    private Long sensorId;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @Size(max = 450)
    @Column(name = "data")
    private String data;
    @Size(max = 450)
    @Column(name = "description")
    private String description;
    @Size(max = 450)
    @Column(name = "extra")
    private String extra;
    @OneToMany(mappedBy = "sensorSensorId")
    private List<Reading> readingList;
    
    @JsonIgnore
    @JoinColumn(name = "bridge_bridge_id", referencedColumnName = "bridge_id")
    @ManyToOne
    private Bridge bridgeBridgeId;

    public Sensor() {
    }

    public Sensor(Long sensorId) {
        this.sensorId = sensorId;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @XmlTransient
    public List<Reading> getReadingList() {
        return readingList;
    }

    public void setReadingList(List<Reading> readingList) {
        this.readingList = readingList;
    }

    public Bridge getBridgeBridgeId() {
        return bridgeBridgeId;
    }

    public void setBridgeBridgeId(Bridge bridgeBridgeId) {
        this.bridgeBridgeId = bridgeBridgeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sensorId != null ? sensorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensor)) {
            return false;
        }
        Sensor other = (Sensor) object;
        if ((this.sensorId == null && other.sensorId != null) || (this.sensorId != null && !this.sensorId.equals(other.sensorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Sensor[ sensorId=" + sensorId + " ]";
    }
    
}
