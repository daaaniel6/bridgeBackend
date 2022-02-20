/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "stretch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stretch.findAll", query = "SELECT s FROM Stretch s"),
    @NamedQuery(name = "Stretch.findByStretchId", query = "SELECT s FROM Stretch s WHERE s.stretchId = :stretchId"),
    @NamedQuery(name = "Stretch.findByLength", query = "SELECT s FROM Stretch s WHERE s.length = :length"),
    @NamedQuery(name = "Stretch.findByTypeSection", query = "SELECT s FROM Stretch s WHERE s.typeSection = :typeSection"),
    @NamedQuery(name = "Stretch.findByName", query = "SELECT s FROM Stretch s WHERE s.name = :name")})
public class Stretch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stretch_id")
    private Long stretchId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "length")
    private Double length;
    @Size(max = 450)
    @Column(name = "type_section")
    private String typeSection;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    
    @JsonIgnore
    @JoinColumn(name = "bridge_bridge_id", referencedColumnName = "bridge_id")
    @ManyToOne
    private Bridge bridgeBridgeId;
//    @Column(name = "bridge_bridge_id", insertable = false, updatable = false)
//    private Integer bridgeBridgeId;

    public Stretch() {
    }

    public Stretch(Long stretchId) {
        this.stretchId = stretchId;
    }

    public Long getStretchId() {
        return stretchId;
    }

    public void setStretchId(Long stretchId) {
        this.stretchId = stretchId;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public String getTypeSection() {
        return typeSection;
    }

    public void setTypeSection(String typeSection) {
        this.typeSection = typeSection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bridge getBridgeBridgeId() {
        return bridgeBridgeId;
    }

    public void setBridgeBridgeId(Bridge bridgeBridgeId) {
        this.bridgeBridgeId = bridgeBridgeId;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stretchId != null ? stretchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stretch)) {
            return false;
        }
        Stretch other = (Stretch) object;
        if ((this.stretchId == null && other.stretchId != null) || (this.stretchId != null && !this.stretchId.equals(other.stretchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Stretch[ stretchId=" + stretchId + " ]";
    }
    
}
