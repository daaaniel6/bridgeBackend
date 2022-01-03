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
@Table(name = "steel_row")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SteelRow.findAll", query = "SELECT s FROM SteelRow s"),
    @NamedQuery(name = "SteelRow.findBySteelRowId", query = "SELECT s FROM SteelRow s WHERE s.steelRowId = :steelRowId"),
    @NamedQuery(name = "SteelRow.findByNameSteel", query = "SELECT s FROM SteelRow s WHERE s.nameSteel = :nameSteel"),
    @NamedQuery(name = "SteelRow.findByOxide", query = "SELECT s FROM SteelRow s WHERE s.oxide = :oxide"),
    @NamedQuery(name = "SteelRow.findByMissingBolts", query = "SELECT s FROM SteelRow s WHERE s.missingBolts = :missingBolts"),
    @NamedQuery(name = "SteelRow.findByHitElement", query = "SELECT s FROM SteelRow s WHERE s.hitElement = :hitElement"),
    @NamedQuery(name = "SteelRow.findByCutElement", query = "SELECT s FROM SteelRow s WHERE s.cutElement = :cutElement"),
    @NamedQuery(name = "SteelRow.findByPainting", query = "SELECT s FROM SteelRow s WHERE s.painting = :painting"),
    @NamedQuery(name = "SteelRow.findByOthers", query = "SELECT s FROM SteelRow s WHERE s.others = :others"),
    @NamedQuery(name = "SteelRow.findByExtra", query = "SELECT s FROM SteelRow s WHERE s.extra = :extra")})
public class SteelRow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "steel_row_id")
    private Long steelRowId;
    @Column(name = "name_steel")
    private String nameSteel;
    @Column(name = "oxide")
    private String oxide;
    @Column(name = "missing_bolts")
    private String missingBolts;
    @Column(name = "hit_element")
    private String hitElement;
    @Column(name = "cut_element")
    private String cutElement;
    @Column(name = "painting")
    private String painting;
    @Column(name = "others")
    private String others;
    @Column(name = "extra")
    private String extra;
    @JoinColumn(name = "superstructure_superstructure_id", referencedColumnName = "superstructure_id")
    @ManyToOne
    private Superstructure superstructureSuperstructureId;

    public SteelRow() {
    }

    public SteelRow(Long steelRowId) {
        this.steelRowId = steelRowId;
    }

    public Long getSteelRowId() {
        return steelRowId;
    }

    public void setSteelRowId(Long steelRowId) {
        this.steelRowId = steelRowId;
    }

    public String getNameSteel() {
        return nameSteel;
    }

    public void setNameSteel(String nameSteel) {
        this.nameSteel = nameSteel;
    }

    public String getOxide() {
        return oxide;
    }

    public void setOxide(String oxide) {
        this.oxide = oxide;
    }

    public String getMissingBolts() {
        return missingBolts;
    }

    public void setMissingBolts(String missingBolts) {
        this.missingBolts = missingBolts;
    }

    public String getHitElement() {
        return hitElement;
    }

    public void setHitElement(String hitElement) {
        this.hitElement = hitElement;
    }

    public String getCutElement() {
        return cutElement;
    }

    public void setCutElement(String cutElement) {
        this.cutElement = cutElement;
    }

    public String getPainting() {
        return painting;
    }

    public void setPainting(String painting) {
        this.painting = painting;
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
        hash += (steelRowId != null ? steelRowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SteelRow)) {
            return false;
        }
        SteelRow other = (SteelRow) object;
        if ((this.steelRowId == null && other.steelRowId != null) || (this.steelRowId != null && !this.steelRowId.equals(other.steelRowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.SteelRow[ steelRowId=" + steelRowId + " ]";
    }
    
}
