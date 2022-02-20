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
@Table(name = "barrier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barrier.findAll", query = "SELECT b FROM Barrier b"),
    @NamedQuery(name = "Barrier.findByBarrierId", query = "SELECT b FROM Barrier b WHERE b.barrierId = :barrierId"),
    @NamedQuery(name = "Barrier.findByMaterial", query = "SELECT b FROM Barrier b WHERE b.material = :material"),
    @NamedQuery(name = "Barrier.findByCracksInOneDirection", query = "SELECT b FROM Barrier b WHERE b.cracksInOneDirection = :cracksInOneDirection"),
    @NamedQuery(name = "Barrier.findByCracksInTwoDirections", query = "SELECT b FROM Barrier b WHERE b.cracksInTwoDirections = :cracksInTwoDirections"),
    @NamedQuery(name = "Barrier.findByBeaten", query = "SELECT b FROM Barrier b WHERE b.beaten = :beaten"),
    @NamedQuery(name = "Barrier.findByPainting", query = "SELECT b FROM Barrier b WHERE b.painting = :painting"),
    @NamedQuery(name = "Barrier.findByOthers", query = "SELECT b FROM Barrier b WHERE b.others = :others"),
    @NamedQuery(name = "Barrier.findByExtra", query = "SELECT b FROM Barrier b WHERE b.extra = :extra")})
public class Barrier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "barrier_id")
    private Long barrierId;
    @Size(max = 450)
    @Column(name = "material")
    private String material;
    @Size(max = 450)
    @Column(name = "cracks_in_one_direction")
    private String cracksInOneDirection;
    @Size(max = 450)
    @Column(name = "cracks_in_two_directions")
    private String cracksInTwoDirections;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "beaten")
    private Double beaten;
    @Size(max = 450)
    @Column(name = "painting")
    private String painting;
    @Size(max = 450)
    @Column(name = "others")
    private String others;
    @Size(max = 45)
    @Column(name = "extra")
    private String extra;
    
    @JsonIgnore
    @OneToMany(mappedBy = "barrierBarrierId")
    private List<NonStructuralElements> nonStructuralElementsList;

    public Barrier() {
    }

    public Barrier(Long barrierId) {
        this.barrierId = barrierId;
    }

    public Long getBarrierId() {
        return barrierId;
    }

    public void setBarrierId(Long barrierId) {
        this.barrierId = barrierId;
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

    public Double getBeaten() {
        return beaten;
    }

    public void setBeaten(Double beaten) {
        this.beaten = beaten;
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

    @XmlTransient
    public List<NonStructuralElements> getNonStructuralElementsList() {
        return nonStructuralElementsList;
    }

    public void setNonStructuralElementsList(List<NonStructuralElements> nonStructuralElementsList) {
        this.nonStructuralElementsList = nonStructuralElementsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (barrierId != null ? barrierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrier)) {
            return false;
        }
        Barrier other = (Barrier) object;
        if ((this.barrierId == null && other.barrierId != null) || (this.barrierId != null && !this.barrierId.equals(other.barrierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Barrier[ barrierId=" + barrierId + " ]";
    }
    
}
