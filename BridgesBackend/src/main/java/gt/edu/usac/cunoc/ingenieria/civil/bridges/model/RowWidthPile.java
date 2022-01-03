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
@Table(name = "row_width_pile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RowWidthPile.findAll", query = "SELECT r FROM RowWidthPile r"),
    @NamedQuery(name = "RowWidthPile.findByRowWidthPileId", query = "SELECT r FROM RowWidthPile r WHERE r.rowWidthPileId = :rowWidthPileId"),
    @NamedQuery(name = "RowWidthPile.findByNameRow", query = "SELECT r FROM RowWidthPile r WHERE r.nameRow = :nameRow"),
    @NamedQuery(name = "RowWidthPile.findByMaterial", query = "SELECT r FROM RowWidthPile r WHERE r.material = :material"),
    @NamedQuery(name = "RowWidthPile.findByHeight", query = "SELECT r FROM RowWidthPile r WHERE r.height = :height"),
    @NamedQuery(name = "RowWidthPile.findByWidth", query = "SELECT r FROM RowWidthPile r WHERE r.width = :width"),
    @NamedQuery(name = "RowWidthPile.findByCracksInOneDirection", query = "SELECT r FROM RowWidthPile r WHERE r.cracksInOneDirection = :cracksInOneDirection"),
    @NamedQuery(name = "RowWidthPile.findByCracksInTwoDirections", query = "SELECT r FROM RowWidthPile r WHERE r.cracksInTwoDirections = :cracksInTwoDirections"),
    @NamedQuery(name = "RowWidthPile.findByStoneLossPerBlow", query = "SELECT r FROM RowWidthPile r WHERE r.stoneLossPerBlow = :stoneLossPerBlow"),
    @NamedQuery(name = "RowWidthPile.findBySteelExhibition", query = "SELECT r FROM RowWidthPile r WHERE r.steelExhibition = :steelExhibition"),
    @NamedQuery(name = "RowWidthPile.findByOthers", query = "SELECT r FROM RowWidthPile r WHERE r.others = :others"),
    @NamedQuery(name = "RowWidthPile.findByExtra", query = "SELECT r FROM RowWidthPile r WHERE r.extra = :extra")})
public class RowWidthPile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "row_width_pile_id")
    private Long rowWidthPileId;
    @Column(name = "name_row")
    private String nameRow;
    @Column(name = "material")
    private String material;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "height")
    private Double height;
    @Column(name = "width")
    private Long width;
    @Column(name = "cracks_in_one_direction")
    private String cracksInOneDirection;
    @Column(name = "cracks_in_two_directions")
    private String cracksInTwoDirections;
    @Column(name = "stone_loss_per_blow")
    private String stoneLossPerBlow;
    @Column(name = "steel_exhibition")
    private String steelExhibition;
    @Column(name = "others")
    private String others;
    @Column(name = "extra")
    private String extra;
    @JoinColumn(name = "pile_pile_id", referencedColumnName = "pile_id")
    @ManyToOne
    private Pile pilePileId;

    public RowWidthPile() {
    }

    public RowWidthPile(Long rowWidthPileId) {
        this.rowWidthPileId = rowWidthPileId;
    }

    public Long getRowWidthPileId() {
        return rowWidthPileId;
    }

    public void setRowWidthPileId(Long rowWidthPileId) {
        this.rowWidthPileId = rowWidthPileId;
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

    public Pile getPilePileId() {
        return pilePileId;
    }

    public void setPilePileId(Pile pilePileId) {
        this.pilePileId = pilePileId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rowWidthPileId != null ? rowWidthPileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RowWidthPile)) {
            return false;
        }
        RowWidthPile other = (RowWidthPile) object;
        if ((this.rowWidthPileId == null && other.rowWidthPileId != null) || (this.rowWidthPileId != null && !this.rowWidthPileId.equals(other.rowWidthPileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.RowWidthPile[ rowWidthPileId=" + rowWidthPileId + " ]";
    }
    
}
