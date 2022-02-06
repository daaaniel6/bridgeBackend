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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "stapes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stapes.findAll", query = "SELECT s FROM Stapes s"),
    @NamedQuery(name = "Stapes.findByStapesId", query = "SELECT s FROM Stapes s WHERE s.stapesId = :stapesId"),
    @NamedQuery(name = "Stapes.findByNameStapes", query = "SELECT s FROM Stapes s WHERE s.nameStapes = :nameStapes")})
public class Stapes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stapes_id")
    private Long stapesId;
    @Size(max = 450)
    @Column(name = "name_stapes")
    private String nameStapes;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @OneToMany(mappedBy = "stapesStapesId")
    private List<RowWidth> rowWidthList;
    
    @JsonIgnore
    @JoinColumn(name = "bridge_bridge_id", referencedColumnName = "bridge_id")
    @ManyToOne
    private Bridge bridgeBridgeId;
    @JoinColumn(name = "scour_scour_id", referencedColumnName = "scour_id")
    @ManyToOne
    private Scour scourScourId;
    @JoinColumn(name = "support_support_id", referencedColumnName = "support_id")
    @ManyToOne
    private Support supportSupportId;

    public Stapes() {
    }

    public Stapes(Long stapesId) {
        this.stapesId = stapesId;
    }

    public Long getStapesId() {
        return stapesId;
    }

    public void setStapesId(Long stapesId) {
        this.stapesId = stapesId;
    }

    public String getNameStapes() {
        return nameStapes;
    }

    public void setNameStapes(String nameStapes) {
        this.nameStapes = nameStapes;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @XmlTransient
    public List<RowWidth> getRowWidthList() {
        return rowWidthList;
    }

    public void setRowWidthList(List<RowWidth> rowWidthList) {
        this.rowWidthList = rowWidthList;
    }

    public Bridge getBridgeBridgeId() {
        return bridgeBridgeId;
    }

    public void setBridgeBridgeId(Bridge bridgeBridgeId) {
        this.bridgeBridgeId = bridgeBridgeId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stapesId != null ? stapesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stapes)) {
            return false;
        }
        Stapes other = (Stapes) object;
        if ((this.stapesId == null && other.stapesId != null) || (this.stapesId != null && !this.stapesId.equals(other.stapesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Stapes[ stapesId=" + stapesId + " ]";
    }
    
}
