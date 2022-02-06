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
@Table(name = "departament")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departament.findAll", query = "SELECT d FROM Departament d"),
    @NamedQuery(name = "Departament.findByDepartamentId", query = "SELECT d FROM Departament d WHERE d.departamentId = :departamentId"),
    @NamedQuery(name = "Departament.findByName", query = "SELECT d FROM Departament d WHERE d.name = :name"),
    @NamedQuery(name = "Departament.findByLong1", query = "SELECT d FROM Departament d WHERE d.long1 = :long1"),
    @NamedQuery(name = "Departament.findByLat", query = "SELECT d FROM Departament d WHERE d.lat = :lat")})
public class Departament implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "departament_id")
    private Integer departamentId;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "long")
    private String long1;
    @Size(max = 45)
    @Column(name = "lat")
    private String lat;
    

    @OneToMany(mappedBy = "departamentDepartamentId")
    private List<Municipality> municipalityList;
    
    @JsonIgnore
    @OneToMany(mappedBy = "departamentDepartamentId")
    private List<Bridge> bridgeList;

    public Departament() {
    }

    public Departament(Integer departamentId) {
        this.departamentId = departamentId;
    }

    public Integer getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(Integer departamentId) {
        this.departamentId = departamentId;
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

    @XmlTransient
    public List<Municipality> getMunicipalityList() {
        return municipalityList;
    }

    public void setMunicipalityList(List<Municipality> municipalityList) {
        this.municipalityList = municipalityList;
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
        hash += (departamentId != null ? departamentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departament)) {
            return false;
        }
        Departament other = (Departament) object;
        if ((this.departamentId == null && other.departamentId != null) || (this.departamentId != null && !this.departamentId.equals(other.departamentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Departament[ departamentId=" + departamentId + " ]";
    }
    
}
