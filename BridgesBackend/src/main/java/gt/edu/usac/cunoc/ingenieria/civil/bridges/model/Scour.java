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
@Table(name = "scour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scour.findAll", query = "SELECT s FROM Scour s"),
    @NamedQuery(name = "Scour.findByScourId", query = "SELECT s FROM Scour s WHERE s.scourId = :scourId"),
    @NamedQuery(name = "Scour.findByName", query = "SELECT s FROM Scour s WHERE s.name = :name"),
    @NamedQuery(name = "Scour.findByThereIsNot", query = "SELECT s FROM Scour s WHERE s.thereIsNot = :thereIsNot"),
    @NamedQuery(name = "Scour.findByYesButThereIsNot", query = "SELECT s FROM Scour s WHERE s.yesButThereIsNot = :yesButThereIsNot"),
    @NamedQuery(name = "Scour.findByYesThereIsExposure", query = "SELECT s FROM Scour s WHERE s.yesThereIsExposure = :yesThereIsExposure"),
    @NamedQuery(name = "Scour.findBySettlementOf", query = "SELECT s FROM Scour s WHERE s.settlementOf = :settlementOf"),
    @NamedQuery(name = "Scour.findByExtra", query = "SELECT s FROM Scour s WHERE s.extra = :extra")})
public class Scour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scour_id")
    private Long scourId;
    @Column(name = "name")
    private String name;
    @Column(name = "there_is_not")
    private String thereIsNot;
    @Column(name = "yes_but_there_is_not")
    private String yesButThereIsNot;
    @Column(name = "yes_there_is_exposure")
    private String yesThereIsExposure;
    @Column(name = "settlement_of")
    private String settlementOf;
    @Column(name = "extra")
    private String extra;
    @OneToMany(mappedBy = "scourScourId")
    private List<Pile> pileList;
    @OneToMany(mappedBy = "scourScourId")
    private List<Stapes> stapesList;

    public Scour() {
    }

    public Scour(Long scourId) {
        this.scourId = scourId;
    }

    public Long getScourId() {
        return scourId;
    }

    public void setScourId(Long scourId) {
        this.scourId = scourId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThereIsNot() {
        return thereIsNot;
    }

    public void setThereIsNot(String thereIsNot) {
        this.thereIsNot = thereIsNot;
    }

    public String getYesButThereIsNot() {
        return yesButThereIsNot;
    }

    public void setYesButThereIsNot(String yesButThereIsNot) {
        this.yesButThereIsNot = yesButThereIsNot;
    }

    public String getYesThereIsExposure() {
        return yesThereIsExposure;
    }

    public void setYesThereIsExposure(String yesThereIsExposure) {
        this.yesThereIsExposure = yesThereIsExposure;
    }

    public String getSettlementOf() {
        return settlementOf;
    }

    public void setSettlementOf(String settlementOf) {
        this.settlementOf = settlementOf;
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
        hash += (scourId != null ? scourId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scour)) {
            return false;
        }
        Scour other = (Scour) object;
        if ((this.scourId == null && other.scourId != null) || (this.scourId != null && !this.scourId.equals(other.scourId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Scour[ scourId=" + scourId + " ]";
    }
    
}
