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
@Table(name = "railing_posts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RailingPosts.findAll", query = "SELECT r FROM RailingPosts r"),
    @NamedQuery(name = "RailingPosts.findByRailingPostsId", query = "SELECT r FROM RailingPosts r WHERE r.railingPostsId = :railingPostsId"),
    @NamedQuery(name = "RailingPosts.findByMaterial", query = "SELECT r FROM RailingPosts r WHERE r.material = :material"),
    @NamedQuery(name = "RailingPosts.findByAbsenceOfSection", query = "SELECT r FROM RailingPosts r WHERE r.absenceOfSection = :absenceOfSection"),
    @NamedQuery(name = "RailingPosts.findByElementDeformation", query = "SELECT r FROM RailingPosts r WHERE r.elementDeformation = :elementDeformation"),
    @NamedQuery(name = "RailingPosts.findByBeaten", query = "SELECT r FROM RailingPosts r WHERE r.beaten = :beaten"),
    @NamedQuery(name = "RailingPosts.findByPainting", query = "SELECT r FROM RailingPosts r WHERE r.painting = :painting"),
    @NamedQuery(name = "RailingPosts.findByOthers", query = "SELECT r FROM RailingPosts r WHERE r.others = :others"),
    @NamedQuery(name = "RailingPosts.findByExtra", query = "SELECT r FROM RailingPosts r WHERE r.extra = :extra")})
public class RailingPosts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "railing_posts_id")
    private Long railingPostsId;
    @Size(max = 450)
    @Column(name = "material")
    private String material;
    @Size(max = 450)
    @Column(name = "absence_of_section")
    private String absenceOfSection;
    @Size(max = 450)
    @Column(name = "element_deformation")
    private String elementDeformation;
    @Column(name = "beaten")
    private Integer beaten;
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
    @OneToMany(mappedBy = "railingPostsRailingPostsId")
    private List<NonStructuralElements> nonStructuralElementsList;

    public RailingPosts() {
    }

    public RailingPosts(Long railingPostsId) {
        this.railingPostsId = railingPostsId;
    }

    public Long getRailingPostsId() {
        return railingPostsId;
    }

    public void setRailingPostsId(Long railingPostsId) {
        this.railingPostsId = railingPostsId;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getAbsenceOfSection() {
        return absenceOfSection;
    }

    public void setAbsenceOfSection(String absenceOfSection) {
        this.absenceOfSection = absenceOfSection;
    }

    public String getElementDeformation() {
        return elementDeformation;
    }

    public void setElementDeformation(String elementDeformation) {
        this.elementDeformation = elementDeformation;
    }

    public Integer getBeaten() {
        return beaten;
    }

    public void setBeaten(Integer beaten) {
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
        hash += (railingPostsId != null ? railingPostsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RailingPosts)) {
            return false;
        }
        RailingPosts other = (RailingPosts) object;
        if ((this.railingPostsId == null && other.railingPostsId != null) || (this.railingPostsId != null && !this.railingPostsId.equals(other.railingPostsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.RailingPosts[ railingPostsId=" + railingPostsId + " ]";
    }
    
}
