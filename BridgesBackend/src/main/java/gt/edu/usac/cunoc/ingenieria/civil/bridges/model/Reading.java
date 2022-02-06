/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "reading")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reading.findAll", query = "SELECT r FROM Reading r"),
    @NamedQuery(name = "Reading.findByReadingId", query = "SELECT r FROM Reading r WHERE r.readingId = :readingId"),
    @NamedQuery(name = "Reading.findByReading", query = "SELECT r FROM Reading r WHERE r.reading = :reading"),
    @NamedQuery(name = "Reading.findByDescription", query = "SELECT r FROM Reading r WHERE r.description = :description"),
    @NamedQuery(name = "Reading.findByDateTime", query = "SELECT r FROM Reading r WHERE r.dateTime = :dateTime"),
    @NamedQuery(name = "Reading.findByExtra", query = "SELECT r FROM Reading r WHERE r.extra = :extra")})
public class Reading implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reading_id")
    private Long readingId;
    @Size(max = 450)
    @Column(name = "reading")
    private String reading;
    @Size(max = 450)
    @Column(name = "description")
    private String description;
    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Size(max = 450)
    @Column(name = "extra")
    private String extra;
    @JoinColumn(name = "sensor_sensor_id", referencedColumnName = "sensor_id")
    @ManyToOne
    private Sensor sensorSensorId;

    public Reading() {
    }

    public Reading(Long readingId) {
        this.readingId = readingId;
    }

    public Long getReadingId() {
        return readingId;
    }

    public void setReadingId(Long readingId) {
        this.readingId = readingId;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Sensor getSensorSensorId() {
        return sensorSensorId;
    }

    public void setSensorSensorId(Sensor sensorSensorId) {
        this.sensorSensorId = sensorSensorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (readingId != null ? readingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reading)) {
            return false;
        }
        Reading other = (Reading) object;
        if ((this.readingId == null && other.readingId != null) || (this.readingId != null && !this.readingId.equals(other.readingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Reading[ readingId=" + readingId + " ]";
    }
    
}
