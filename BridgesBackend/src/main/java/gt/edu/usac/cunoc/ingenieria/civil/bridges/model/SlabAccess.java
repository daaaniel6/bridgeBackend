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
@Table(name = "slab_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SlabAccess.findAll", query = "SELECT s FROM SlabAccess s"),
    @NamedQuery(name = "SlabAccess.findBySlabAccessId", query = "SELECT s FROM SlabAccess s WHERE s.slabAccessId = :slabAccessId"),
    @NamedQuery(name = "SlabAccess.findByNameSalabAccess", query = "SELECT s FROM SlabAccess s WHERE s.nameSalabAccess = :nameSalabAccess"),
    @NamedQuery(name = "SlabAccess.findByMaterial", query = "SELECT s FROM SlabAccess s WHERE s.material = :material"),
    @NamedQuery(name = "SlabAccess.findByGoodCondition", query = "SELECT s FROM SlabAccess s WHERE s.goodCondition = :goodCondition"),
    @NamedQuery(name = "SlabAccess.findByDamage", query = "SELECT s FROM SlabAccess s WHERE s.damage = :damage"),
    @NamedQuery(name = "SlabAccess.findByExtra", query = "SELECT s FROM SlabAccess s WHERE s.extra = :extra")})
public class SlabAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "slab_access_id")
    private Long slabAccessId;
    @Column(name = "name_salab_access")
    private String nameSalabAccess;
    @Column(name = "material")
    private String material;
    @Column(name = "good_condition")
    private String goodCondition;
    @Column(name = "damage")
    private String damage;
    @Column(name = "extra")
    private String extra;
    @JoinColumn(name = "non_structural_elements_non_structural_elements_id", referencedColumnName = "non_structural_elements_id")
    @ManyToOne
    private NonStructuralElements nonStructuralElementsNonStructuralElementsId;

    public SlabAccess() {
    }

    public SlabAccess(Long slabAccessId) {
        this.slabAccessId = slabAccessId;
    }

    public Long getSlabAccessId() {
        return slabAccessId;
    }

    public void setSlabAccessId(Long slabAccessId) {
        this.slabAccessId = slabAccessId;
    }

    public String getNameSalabAccess() {
        return nameSalabAccess;
    }

    public void setNameSalabAccess(String nameSalabAccess) {
        this.nameSalabAccess = nameSalabAccess;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getGoodCondition() {
        return goodCondition;
    }

    public void setGoodCondition(String goodCondition) {
        this.goodCondition = goodCondition;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public NonStructuralElements getNonStructuralElementsNonStructuralElementsId() {
        return nonStructuralElementsNonStructuralElementsId;
    }

    public void setNonStructuralElementsNonStructuralElementsId(NonStructuralElements nonStructuralElementsNonStructuralElementsId) {
        this.nonStructuralElementsNonStructuralElementsId = nonStructuralElementsNonStructuralElementsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (slabAccessId != null ? slabAccessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SlabAccess)) {
            return false;
        }
        SlabAccess other = (SlabAccess) object;
        if ((this.slabAccessId == null && other.slabAccessId != null) || (this.slabAccessId != null && !this.slabAccessId.equals(other.slabAccessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.SlabAccess[ slabAccessId=" + slabAccessId + " ]";
    }
    
}
