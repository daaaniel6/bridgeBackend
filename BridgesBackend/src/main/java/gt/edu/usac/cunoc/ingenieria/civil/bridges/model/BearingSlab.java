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
@Table(name = "bearing_slab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BearingSlab.findAll", query = "SELECT b FROM BearingSlab b"),
    @NamedQuery(name = "BearingSlab.findByBearingSlabId", query = "SELECT b FROM BearingSlab b WHERE b.bearingSlabId = :bearingSlabId"),
    @NamedQuery(name = "BearingSlab.findByMaterial", query = "SELECT b FROM BearingSlab b WHERE b.material = :material"),
    @NamedQuery(name = "BearingSlab.findByCracksInOneDirection", query = "SELECT b FROM BearingSlab b WHERE b.cracksInOneDirection = :cracksInOneDirection"),
    @NamedQuery(name = "BearingSlab.findByCracksInTwoDirections", query = "SELECT b FROM BearingSlab b WHERE b.cracksInTwoDirections = :cracksInTwoDirections"),
    @NamedQuery(name = "BearingSlab.findByDetachmentOf", query = "SELECT b FROM BearingSlab b WHERE b.detachmentOf = :detachmentOf"),
    @NamedQuery(name = "BearingSlab.findByPotholes", query = "SELECT b FROM BearingSlab b WHERE b.potholes = :potholes"),
    @NamedQuery(name = "BearingSlab.findBySteelExhibition", query = "SELECT b FROM BearingSlab b WHERE b.steelExhibition = :steelExhibition"),
    @NamedQuery(name = "BearingSlab.findByOthers", query = "SELECT b FROM BearingSlab b WHERE b.others = :others"),
    @NamedQuery(name = "BearingSlab.findByExtra", query = "SELECT b FROM BearingSlab b WHERE b.extra = :extra")})
public class BearingSlab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bearing_slab_id")
    private Long bearingSlabId;
    @Size(max = 450)
    @Column(name = "material")
    private String material;
    @Size(max = 450)
    @Column(name = "cracks_in_one_direction")
    private String cracksInOneDirection;
    @Size(max = 450)
    @Column(name = "cracks_in_two_directions")
    private String cracksInTwoDirections;
    @Size(max = 450)
    @Column(name = "detachment_of")
    private String detachmentOf;
    @Size(max = 450)
    @Column(name = "potholes")
    private String potholes;
    @Size(max = 450)
    @Column(name = "steel_exhibition")
    private String steelExhibition;
    @Size(max = 450)
    @Column(name = "others")
    private String others;
    @Size(max = 450)
    @Column(name = "extra")
    private String extra;
    @OneToMany(mappedBy = "bearingSlabBearingSlabId")
    private List<Superstructure> superstructureList;

    public BearingSlab() {
    }

    public BearingSlab(Long bearingSlabId) {
        this.bearingSlabId = bearingSlabId;
    }

    public Long getBearingSlabId() {
        return bearingSlabId;
    }

    public void setBearingSlabId(Long bearingSlabId) {
        this.bearingSlabId = bearingSlabId;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCracksInOneDirection() {
        return cracksInOneDirection;
    }

    public void setCracksInOneDirection(String cracksInOneDirection) {
        this.cracksInOneDirection = cracksInOneDirection;
    }

    public String getCracksInTwoDirections() {
        return cracksInTwoDirections;
    }

    public void setCracksInTwoDirections(String cracksInTwoDirections) {
        this.cracksInTwoDirections = cracksInTwoDirections;
    }

    public String getDetachmentOf() {
        return detachmentOf;
    }

    public void setDetachmentOf(String detachmentOf) {
        this.detachmentOf = detachmentOf;
    }

    public String getPotholes() {
        return potholes;
    }

    public void setPotholes(String potholes) {
        this.potholes = potholes;
    }

    public String getSteelExhibition() {
        return steelExhibition;
    }

    public void setSteelExhibition(String steelExhibition) {
        this.steelExhibition = steelExhibition;
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
    public List<Superstructure> getSuperstructureList() {
        return superstructureList;
    }

    public void setSuperstructureList(List<Superstructure> superstructureList) {
        this.superstructureList = superstructureList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bearingSlabId != null ? bearingSlabId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BearingSlab)) {
            return false;
        }
        BearingSlab other = (BearingSlab) object;
        if ((this.bearingSlabId == null && other.bearingSlabId != null) || (this.bearingSlabId != null && !this.bearingSlabId.equals(other.bearingSlabId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.BearingSlab[ bearingSlabId=" + bearingSlabId + " ]";
    }
    
}
