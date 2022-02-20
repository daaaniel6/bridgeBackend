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
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "pile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pile.findAll", query = "SELECT p FROM Pile p"),
    @NamedQuery(name = "Pile.findByPileId", query = "SELECT p FROM Pile p WHERE p.pileId = :pileId"),
    @NamedQuery(name = "Pile.findByNamePile", query = "SELECT p FROM Pile p WHERE p.namePile = :namePile")})
public class Pile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pile_id")
    private Long pileId;
    @Size(max = 45)
    @Column(name = "name_pile")
    private String namePile;
    @Lob
    @Column(name = "image")
    private byte[] image;
    
    @JoinColumn(name = "scour_scour_id", referencedColumnName = "scour_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Scour scourScourId;
    
    @JoinColumn(name = "support_support_id", referencedColumnName = "support_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Support supportSupportId;
    
    @OneToMany(mappedBy = "pilePileId", cascade = CascadeType.ALL)
    private List<RowWidthPile> rowWidthPileList;
    
    @JsonIgnore
    @OneToMany(mappedBy = "pilePileId")
    private List<Bridge> bridgeList;

    public Pile() {
    }

    public Pile(Long pileId) {
        this.pileId = pileId;
    }

    public Long getPileId() {
        return pileId;
    }

    public void setPileId(Long pileId) {
        this.pileId = pileId;
    }

    public String getNamePile() {
        return namePile;
    }

    public void setNamePile(String namePile) {
        this.namePile = namePile;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Scour getScourScourId() {
        return scourScourId;
    }

    public void setScourScourId(Scour scourScourId) {
        this.scourScourId = scourScourId;
    }

    public Support getSupportSupportId() {
        return supportSupportId;
    }

    public void setSupportSupportId(Support supportSupportId) {
        this.supportSupportId = supportSupportId;
    }

    @XmlTransient
    public List<RowWidthPile> getRowWidthPileList() {
        return rowWidthPileList;
    }

    public void setRowWidthPileList(List<RowWidthPile> rowWidthPileList) {
        this.rowWidthPileList = rowWidthPileList;
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
        hash += (pileId != null ? pileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pile)) {
            return false;
        }
        Pile other = (Pile) object;
        if ((this.pileId == null && other.pileId != null) || (this.pileId != null && !this.pileId.equals(other.pileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Pile[ pileId=" + pileId + " ]";
    }
    
}
