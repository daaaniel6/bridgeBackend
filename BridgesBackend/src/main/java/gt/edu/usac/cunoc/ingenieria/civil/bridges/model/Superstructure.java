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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "superstructure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Superstructure.findAll", query = "SELECT s FROM Superstructure s"),
    @NamedQuery(name = "Superstructure.findBySuperstructureId", query = "SELECT s FROM Superstructure s WHERE s.superstructureId = :superstructureId")})
public class Superstructure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "superstructure_id")
    private Long superstructureId;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @OneToMany(mappedBy = "superstructureSuperstructureId")
    private List<ConcreteRow> concreteRowList;
    @JoinColumn(name = "bearing_slab_bearing_slab_id", referencedColumnName = "bearing_slab_id")
    @ManyToOne
    private BearingSlab bearingSlabBearingSlabId;
    @JoinColumn(name = "sewer_system_sewer_system_id", referencedColumnName = "sewer_system_id")
    @ManyToOne
    private SewerSystem sewerSystemSewerSystemId;
    @OneToMany(mappedBy = "superstructureSuperstructureId")
    private List<SteelRow> steelRowList;
    
    @JsonIgnore
    @OneToMany(mappedBy = "superstructureSuperstructureId")
    private List<Bridge> bridgeList;

    public Superstructure() {
    }

    public Superstructure(Long superstructureId) {
        this.superstructureId = superstructureId;
    }

    public Long getSuperstructureId() {
        return superstructureId;
    }

    public void setSuperstructureId(Long superstructureId) {
        this.superstructureId = superstructureId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @XmlTransient
    public List<ConcreteRow> getConcreteRowList() {
        return concreteRowList;
    }

    public void setConcreteRowList(List<ConcreteRow> concreteRowList) {
        this.concreteRowList = concreteRowList;
    }

    public BearingSlab getBearingSlabBearingSlabId() {
        return bearingSlabBearingSlabId;
    }

    public void setBearingSlabBearingSlabId(BearingSlab bearingSlabBearingSlabId) {
        this.bearingSlabBearingSlabId = bearingSlabBearingSlabId;
    }

    public SewerSystem getSewerSystemSewerSystemId() {
        return sewerSystemSewerSystemId;
    }

    public void setSewerSystemSewerSystemId(SewerSystem sewerSystemSewerSystemId) {
        this.sewerSystemSewerSystemId = sewerSystemSewerSystemId;
    }

    @XmlTransient
    public List<SteelRow> getSteelRowList() {
        return steelRowList;
    }

    public void setSteelRowList(List<SteelRow> steelRowList) {
        this.steelRowList = steelRowList;
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
        hash += (superstructureId != null ? superstructureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Superstructure)) {
            return false;
        }
        Superstructure other = (Superstructure) object;
        if ((this.superstructureId == null && other.superstructureId != null) || (this.superstructureId != null && !this.superstructureId.equals(other.superstructureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Superstructure[ superstructureId=" + superstructureId + " ]";
    }
    
}
