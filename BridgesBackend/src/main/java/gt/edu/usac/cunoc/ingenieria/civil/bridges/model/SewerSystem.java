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
@Table(name = "sewer_system")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SewerSystem.findAll", query = "SELECT s FROM SewerSystem s"),
    @NamedQuery(name = "SewerSystem.findBySewerSystemId", query = "SELECT s FROM SewerSystem s WHERE s.sewerSystemId = :sewerSystemId"),
    @NamedQuery(name = "SewerSystem.findByClean", query = "SELECT s FROM SewerSystem s WHERE s.clean = :clean"),
    @NamedQuery(name = "SewerSystem.findByBlocked", query = "SELECT s FROM SewerSystem s WHERE s.blocked = :blocked"),
    @NamedQuery(name = "SewerSystem.findByExtra", query = "SELECT s FROM SewerSystem s WHERE s.extra = :extra")})
public class SewerSystem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sewer_system_id")
    private Long sewerSystemId;
    @Column(name = "clean")
    private String clean;
    @Column(name = "blocked")
    private String blocked;
    @Column(name = "extra")
    private String extra;
    @OneToMany(mappedBy = "sewerSystemSewerSystemId")
    private List<Superstructure> superstructureList;

    public SewerSystem() {
    }

    public SewerSystem(Long sewerSystemId) {
        this.sewerSystemId = sewerSystemId;
    }

    public Long getSewerSystemId() {
        return sewerSystemId;
    }

    public void setSewerSystemId(Long sewerSystemId) {
        this.sewerSystemId = sewerSystemId;
    }

    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
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
        hash += (sewerSystemId != null ? sewerSystemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SewerSystem)) {
            return false;
        }
        SewerSystem other = (SewerSystem) object;
        if ((this.sewerSystemId == null && other.sewerSystemId != null) || (this.sewerSystemId != null && !this.sewerSystemId.equals(other.sewerSystemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.SewerSystem[ sewerSystemId=" + sewerSystemId + " ]";
    }
    
}
