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
@Table(name = "concrete_row")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConcreteRow.findAll", query = "SELECT c FROM ConcreteRow c"),
    @NamedQuery(name = "ConcreteRow.findByConcreteRowId", query = "SELECT c FROM ConcreteRow c WHERE c.concreteRowId = :concreteRowId"),
    @NamedQuery(name = "ConcreteRow.findByNameConcrete", query = "SELECT c FROM ConcreteRow c WHERE c.nameConcrete = :nameConcrete"),
    @NamedQuery(name = "ConcreteRow.findByDiagonalCracks", query = "SELECT c FROM ConcreteRow c WHERE c.diagonalCracks = :diagonalCracks"),
    @NamedQuery(name = "ConcreteRow.findByVerticalCracks", query = "SELECT c FROM ConcreteRow c WHERE c.verticalCracks = :verticalCracks"),
    @NamedQuery(name = "ConcreteRow.findByStoneLossPerBlow", query = "SELECT c FROM ConcreteRow c WHERE c.stoneLossPerBlow = :stoneLossPerBlow"),
    @NamedQuery(name = "ConcreteRow.findBySteelExhibition", query = "SELECT c FROM ConcreteRow c WHERE c.steelExhibition = :steelExhibition"),
    @NamedQuery(name = "ConcreteRow.findByOthers", query = "SELECT c FROM ConcreteRow c WHERE c.others = :others"),
    @NamedQuery(name = "ConcreteRow.findByExtra", query = "SELECT c FROM ConcreteRow c WHERE c.extra = :extra")})
public class ConcreteRow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "concrete_row_id")
    private Long concreteRowId;
    @Column(name = "name_concrete")
    private String nameConcrete;
    @Column(name = "diagonal_cracks")
    private String diagonalCracks;
    @Column(name = "vertical_cracks")
    private String verticalCracks;
    @Column(name = "stone_loss_per_blow")
    private String stoneLossPerBlow;
    @Column(name = "steel_exhibition")
    private String steelExhibition;
    @Column(name = "others")
    private String others;
    @Column(name = "extra")
    private String extra;
    @JoinColumn(name = "superstructure_superstructure_id", referencedColumnName = "superstructure_id")
    @ManyToOne
    private Superstructure superstructureSuperstructureId;

    public ConcreteRow() {
    }

    public ConcreteRow(Long concreteRowId) {
        this.concreteRowId = concreteRowId;
    }

    public Long getConcreteRowId() {
        return concreteRowId;
    }

    public void setConcreteRowId(Long concreteRowId) {
        this.concreteRowId = concreteRowId;
    }

    public String getNameConcrete() {
        return nameConcrete;
    }

    public void setNameConcrete(String nameConcrete) {
        this.nameConcrete = nameConcrete;
    }

    public String getDiagonalCracks() {
        return diagonalCracks;
    }

    public void setDiagonalCracks(String diagonalCracks) {
        this.diagonalCracks = diagonalCracks;
    }

    public String getVerticalCracks() {
        return verticalCracks;
    }

    public void setVerticalCracks(String verticalCracks) {
        this.verticalCracks = verticalCracks;
    }

    public String getStoneLossPerBlow() {
        return stoneLossPerBlow;
    }

    public void setStoneLossPerBlow(String stoneLossPerBlow) {
        this.stoneLossPerBlow = stoneLossPerBlow;
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

    public Superstructure getSuperstructureSuperstructureId() {
        return superstructureSuperstructureId;
    }

    public void setSuperstructureSuperstructureId(Superstructure superstructureSuperstructureId) {
        this.superstructureSuperstructureId = superstructureSuperstructureId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (concreteRowId != null ? concreteRowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConcreteRow)) {
            return false;
        }
        ConcreteRow other = (ConcreteRow) object;
        if ((this.concreteRowId == null && other.concreteRowId != null) || (this.concreteRowId != null && !this.concreteRowId.equals(other.concreteRowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.ConcreteRow[ concreteRowId=" + concreteRowId + " ]";
    }
    
}
