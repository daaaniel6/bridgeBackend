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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "support")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Support.findAll", query = "SELECT s FROM Support s"),
    @NamedQuery(name = "Support.findBySupportId", query = "SELECT s FROM Support s WHERE s.supportId = :supportId"),
    @NamedQuery(name = "Support.findByName", query = "SELECT s FROM Support s WHERE s.name = :name"),
    @NamedQuery(name = "Support.findByMaterial", query = "SELECT s FROM Support s WHERE s.material = :material"),
    @NamedQuery(name = "Support.findByCrushedNeoprene", query = "SELECT s FROM Support s WHERE s.crushedNeoprene = :crushedNeoprene"),
    @NamedQuery(name = "Support.findByOutOfPlace", query = "SELECT s FROM Support s WHERE s.outOfPlace = :outOfPlace"),
    @NamedQuery(name = "Support.findByRusty", query = "SELECT s FROM Support s WHERE s.rusty = :rusty"),
    @NamedQuery(name = "Support.findByBoltMissing", query = "SELECT s FROM Support s WHERE s.boltMissing = :boltMissing"),
    @NamedQuery(name = "Support.findByBrokenBolt", query = "SELECT s FROM Support s WHERE s.brokenBolt = :brokenBolt"),
    @NamedQuery(name = "Support.findByOthers", query = "SELECT s FROM Support s WHERE s.others = :others"),
    @NamedQuery(name = "Support.findByExtra", query = "SELECT s FROM Support s WHERE s.extra = :extra")})
public class Support implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "support_id")
    private Long supportId;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @Size(max = 450)
    @Column(name = "material")
    private String material;
    @Size(max = 450)
    @Column(name = "crushed_neoprene")
    private String crushedNeoprene;
    @Size(max = 450)
    @Column(name = "out_of_place")
    private String outOfPlace;
    @Size(max = 450)
    @Column(name = "rusty")
    private String rusty;
    @Size(max = 450)
    @Column(name = "bolt_missing")
    private String boltMissing;
    @Size(max = 450)
    @Column(name = "broken_bolt")
    private String brokenBolt;
    @Size(max = 450)
    @Column(name = "others")
    private String others;
    @Size(max = 450)
    @Column(name = "extra")
    private String extra;
    @OneToMany(mappedBy = "supportSupportId")
    private List<Pile> pileList;
    @OneToMany(mappedBy = "supportSupportId")
    private List<Stapes> stapesList;

    public Support() {
    }

    public Support(Long supportId) {
        this.supportId = supportId;
    }

    public Long getSupportId() {
        return supportId;
    }

    public void setSupportId(Long supportId) {
        this.supportId = supportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCrushedNeoprene() {
        return crushedNeoprene;
    }

    public void setCrushedNeoprene(String crushedNeoprene) {
        this.crushedNeoprene = crushedNeoprene;
    }

    public String getOutOfPlace() {
        return outOfPlace;
    }

    public void setOutOfPlace(String outOfPlace) {
        this.outOfPlace = outOfPlace;
    }

    public String getRusty() {
        return rusty;
    }

    public void setRusty(String rusty) {
        this.rusty = rusty;
    }

    public String getBoltMissing() {
        return boltMissing;
    }

    public void setBoltMissing(String boltMissing) {
        this.boltMissing = boltMissing;
    }

    public String getBrokenBolt() {
        return brokenBolt;
    }

    public void setBrokenBolt(String brokenBolt) {
        this.brokenBolt = brokenBolt;
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
    public List<Pile> getPileList() {
        return pileList;
    }

    public void setPileList(List<Pile> pileList) {
        this.pileList = pileList;
    }

    @XmlTransient
    public List<Stapes> getStapesList() {
        return stapesList;
    }

    public void setStapesList(List<Stapes> stapesList) {
        this.stapesList = stapesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supportId != null ? supportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Support)) {
            return false;
        }
        Support other = (Support) object;
        if ((this.supportId == null && other.supportId != null) || (this.supportId != null && !this.supportId.equals(other.supportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Support[ supportId=" + supportId + " ]";
    }
    
}
