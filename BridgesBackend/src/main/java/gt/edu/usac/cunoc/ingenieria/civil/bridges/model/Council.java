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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "council")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Council.findAll", query = "SELECT c FROM Council c"),
    @NamedQuery(name = "Council.findByCouncilId", query = "SELECT c FROM Council c WHERE c.councilId = :councilId"),
    @NamedQuery(name = "Council.findByNameCouncil", query = "SELECT c FROM Council c WHERE c.nameCouncil = :nameCouncil"),
    @NamedQuery(name = "Council.findByMaterial", query = "SELECT c FROM Council c WHERE c.material = :material"),
    @NamedQuery(name = "Council.findByCleanGasket", query = "SELECT c FROM Council c WHERE c.cleanGasket = :cleanGasket"),
    @NamedQuery(name = "Council.findByDamage", query = "SELECT c FROM Council c WHERE c.damage = :damage"),
    @NamedQuery(name = "Council.findByExtra", query = "SELECT c FROM Council c WHERE c.extra = :extra")})
public class Council implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "council_id")
    private Long councilId;
    @Size(max = 450)
    @Column(name = "name_council")
    private String nameCouncil;
    @Size(max = 450)
    @Column(name = "material")
    private String material;
    @Size(max = 450)
    @Column(name = "clean_gasket")
    private String cleanGasket;
    @Size(max = 450)
    @Column(name = "damage")
    private String damage;
    @Size(max = 45)
    @Column(name = "extra")
    private String extra;
    @JoinColumn(name = "non_structural_elements_non_structural_elements_id", referencedColumnName = "non_structural_elements_id")
    @ManyToOne
    private NonStructuralElements nonStructuralElementsNonStructuralElementsId;

    public Council() {
    }

    public Council(Long councilId) {
        this.councilId = councilId;
    }

    public Long getCouncilId() {
        return councilId;
    }

    public void setCouncilId(Long councilId) {
        this.councilId = councilId;
    }

    public String getNameCouncil() {
        return nameCouncil;
    }

    public void setNameCouncil(String nameCouncil) {
        this.nameCouncil = nameCouncil;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCleanGasket() {
        return cleanGasket;
    }

    public void setCleanGasket(String cleanGasket) {
        this.cleanGasket = cleanGasket;
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
        hash += (councilId != null ? councilId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Council)) {
            return false;
        }
        Council other = (Council) object;
        if ((this.councilId == null && other.councilId != null) || (this.councilId != null && !this.councilId.equals(other.councilId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Council[ councilId=" + councilId + " ]";
    }
    
}
