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
@Table(name = "municipality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipality.findAll", query = "SELECT m FROM Municipality m"),
    @NamedQuery(name = "Municipality.findByMunicipalityId", query = "SELECT m FROM Municipality m WHERE m.municipalityId = :municipalityId"),
    @NamedQuery(name = "Municipality.findByName", query = "SELECT m FROM Municipality m WHERE m.name = :name"),
    @NamedQuery(name = "Municipality.findByLong1", query = "SELECT m FROM Municipality m WHERE m.long1 = :long1"),
    @NamedQuery(name = "Municipality.findByLat", query = "SELECT m FROM Municipality m WHERE m.lat = :lat")})
public class Municipality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "municipality_id")
    private Integer municipalityId;
    @Column(name = "name")
    private String name;
    @Column(name = "long")
    private String long1;
    @Column(name = "lat")
    private String lat;
    @JoinColumn(name = "departament_departament_id", referencedColumnName = "departament_id")
    @ManyToOne
    private Departament departamentDepartamentId;

    public Municipality() {
    }

    public Municipality(Integer municipalityId) {
        this.municipalityId = municipalityId;
    }

    public Integer getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(Integer municipalityId) {
        this.municipalityId = municipalityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Departament getDepartamentDepartamentId() {
        return departamentDepartamentId;
    }

    public void setDepartamentDepartamentId(Departament departamentDepartamentId) {
        this.departamentDepartamentId = departamentDepartamentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipalityId != null ? municipalityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipality)) {
            return false;
        }
        Municipality other = (Municipality) object;
        if ((this.municipalityId == null && other.municipalityId != null) || (this.municipalityId != null && !this.municipalityId.equals(other.municipalityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Municipality[ municipalityId=" + municipalityId + " ]";
    }
    
}
