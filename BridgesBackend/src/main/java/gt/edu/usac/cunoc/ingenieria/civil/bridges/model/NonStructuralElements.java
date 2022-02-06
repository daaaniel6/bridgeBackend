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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "non_structural_elements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NonStructuralElements.findAll", query = "SELECT n FROM NonStructuralElements n"),
    @NamedQuery(name = "NonStructuralElements.findByNonStructuralElementsId", query = "SELECT n FROM NonStructuralElements n WHERE n.nonStructuralElementsId = :nonStructuralElementsId")})
public class NonStructuralElements implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "non_structural_elements_id")
    private Long nonStructuralElementsId;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @JoinColumn(name = "barrier_barrier_id", referencedColumnName = "barrier_id")
    @ManyToOne
    private Barrier barrierBarrierId;
    @JoinColumn(name = "handrail_railing_handrail_railing_id", referencedColumnName = "handrail_railing_id")
    @ManyToOne
    private HandrailRailing handrailRailingHandrailRailingId;
    @JoinColumn(name = "railing_posts_railing_posts_id", referencedColumnName = "railing_posts_id")
    @ManyToOne
    private RailingPosts railingPostsRailingPostsId;
    @OneToMany(mappedBy = "nonStructuralElementsNonStructuralElementsId")
    private List<ProtectionWorks> protectionWorksList;
    @OneToMany(mappedBy = "nonStructuralElementsNonStructuralElementsId")
    private List<Council> councilList;
    @OneToMany(mappedBy = "nonStructuralElementsNonStructuralElementsId")
    private List<SlabAccess> slabAccessList;
    
    @JsonIgnore
    @OneToMany(mappedBy = "nonStructuralElementsNonStructuralElementsId")
    private List<Bridge> bridgeList;

    public NonStructuralElements() {
    }

    public NonStructuralElements(Long nonStructuralElementsId) {
        this.nonStructuralElementsId = nonStructuralElementsId;
    }

    public Long getNonStructuralElementsId() {
        return nonStructuralElementsId;
    }

    public void setNonStructuralElementsId(Long nonStructuralElementsId) {
        this.nonStructuralElementsId = nonStructuralElementsId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Barrier getBarrierBarrierId() {
        return barrierBarrierId;
    }

    public void setBarrierBarrierId(Barrier barrierBarrierId) {
        this.barrierBarrierId = barrierBarrierId;
    }

    public HandrailRailing getHandrailRailingHandrailRailingId() {
        return handrailRailingHandrailRailingId;
    }

    public void setHandrailRailingHandrailRailingId(HandrailRailing handrailRailingHandrailRailingId) {
        this.handrailRailingHandrailRailingId = handrailRailingHandrailRailingId;
    }

    public RailingPosts getRailingPostsRailingPostsId() {
        return railingPostsRailingPostsId;
    }

    public void setRailingPostsRailingPostsId(RailingPosts railingPostsRailingPostsId) {
        this.railingPostsRailingPostsId = railingPostsRailingPostsId;
    }

    @XmlTransient
    public List<ProtectionWorks> getProtectionWorksList() {
        return protectionWorksList;
    }

    public void setProtectionWorksList(List<ProtectionWorks> protectionWorksList) {
        this.protectionWorksList = protectionWorksList;
    }

    @XmlTransient
    public List<Council> getCouncilList() {
        return councilList;
    }

    public void setCouncilList(List<Council> councilList) {
        this.councilList = councilList;
    }

    @XmlTransient
    public List<SlabAccess> getSlabAccessList() {
        return slabAccessList;
    }

    public void setSlabAccessList(List<SlabAccess> slabAccessList) {
        this.slabAccessList = slabAccessList;
    }

    @XmlTransient
    public List<Bridge> getBridgeList() {
        return bridgeList;
    }

    public void setBridgeList(List<Bridge> bridgeList) {
        this.bridgeList = bridgeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nonStructuralElementsId != null ? nonStructuralElementsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NonStructuralElements)) {
            return false;
        }
        NonStructuralElements other = (NonStructuralElements) object;
        if ((this.nonStructuralElementsId == null && other.nonStructuralElementsId != null) || (this.nonStructuralElementsId != null && !this.nonStructuralElementsId.equals(other.nonStructuralElementsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.NonStructuralElements[ nonStructuralElementsId=" + nonStructuralElementsId + " ]";
    }
    
}
