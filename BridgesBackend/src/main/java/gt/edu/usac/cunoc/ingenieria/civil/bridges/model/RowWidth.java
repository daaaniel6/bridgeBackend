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
@Table(name = "row_width")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RowWidth.findAll", query = "SELECT r FROM RowWidth r"),
    @NamedQuery(name = "RowWidth.findByRowWidthId", query = "SELECT r FROM RowWidth r WHERE r.rowWidthId = :rowWidthId"),
    @NamedQuery(name = "RowWidth.findByNameRow", query = "SELECT r FROM RowWidth r WHERE r.nameRow = :nameRow"),
    @NamedQuery(name = "RowWidth.findByMaterial", query = "SELECT r FROM RowWidth r WHERE r.material = :material"),
    @NamedQuery(name = "RowWidth.findByHeight", query = "SELECT r FROM RowWidth r WHERE r.height = :height"),
    @NamedQuery(name = "RowWidth.findByWidth", query = "SELECT r FROM RowWidth r WHERE r.width = :width"),
    @NamedQuery(name = "RowWidth.findByCracksInOneDirection", query = "SELECT r FROM RowWidth r WHERE r.cracksInOneDirection = :cracksInOneDirection"),
    @NamedQuery(name = "RowWidth.findByCracksInTwoDirections", query = "SELECT r FROM RowWidth r WHERE r.cracksInTwoDirections = :cracksInTwoDirections"),
    @NamedQuery(name = "RowWidth.findByStoneLossPerBlow", query = "SELECT r FROM RowWidth r WHERE r.stoneLossPerBlow = :stoneLossPerBlow"),
    @NamedQuery(name = "RowWidth.findBySteelExhibition", query = "SELECT r FROM RowWidth r WHERE r.steelExhibition = :steelExhibition"),
    @NamedQuery(name = "RowWidth.findByOthers", query = "SELECT r FROM RowWidth r WHERE r.others = :others"),
    @NamedQuery(name = "RowWidth.findByExtra", query = "SELECT r FROM RowWidth r WHERE r.extra = :extra")})
public class RowWidth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "row_width_id")
    private Long rowWidthId;
    @Size(max = 450)
    @Column(name = "name_row")
    private String nameRow;
    @Size(max = 450)
    @Column(name = "material")
    private String material;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "height")
    private Double height;
    @Column(name = "width")
    private Long width;
    @Size(max = 450)
    @Column(name = "cracks_in_one_direction")
    private String cracksInOneDirection;
    @Size(max = 450)
    @Column(name = "cracks_in_two_directions")
    private String cracksInTwoDirections;
    @Size(max = 450)
    @Column(name = "stone_loss_per_blow")
    private String stoneLossPerBlow;
    @Size(max = 450)
    @Column(name = "steel_exhibition")
    private String steelExhibition;
    @Size(max = 450)
    @Column(name = "others")
    private String others;
    @Size(max = 450)
    @Column(name = "extra")
    private String extra;
    @JoinColumn(name = "stapes_stapes_id", referencedColumnName = "stapes_id")
    @ManyToOne
    private Stapes stapesStapesId;

    public RowWidth() {
    }

    public RowWidth(Long rowWidthId) {
        this.rowWidthId = rowWidthId;
    }

    public Long getRowWidthId() {
        return rowWidthId;
    }

    public void setRowWidthId(Long rowWidthId) {
        this.rowWidthId = rowWidthId;
    }

    public String getNameRow() {
        return nameRow;
    }

    public void setNameRow(String nameRow) {
        this.nameRow = nameRow;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
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

    public Stapes getStapesStapesId() {
        return stapesStapesId;
    }

    public void setStapesStapesId(Stapes stapesStapesId) {
        this.stapesStapesId = stapesStapesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rowWidthId != null ? rowWidthId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RowWidth)) {
            return false;
        }
        RowWidth other = (RowWidth) object;
        if ((this.rowWidthId == null && other.rowWidthId != null) || (this.rowWidthId != null && !this.rowWidthId.equals(other.rowWidthId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.RowWidth[ rowWidthId=" + rowWidthId + " ]";
    }
    
}
