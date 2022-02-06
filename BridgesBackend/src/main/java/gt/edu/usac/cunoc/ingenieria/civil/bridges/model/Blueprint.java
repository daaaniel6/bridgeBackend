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
import javax.persistence.Lob;
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
@Table(name = "blueprint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blueprint.findAll", query = "SELECT b FROM Blueprint b"),
    @NamedQuery(name = "Blueprint.findByBlueprintId", query = "SELECT b FROM Blueprint b WHERE b.blueprintId = :blueprintId"),
    @NamedQuery(name = "Blueprint.findByName", query = "SELECT b FROM Blueprint b WHERE b.name = :name"),
    @NamedQuery(name = "Blueprint.findByDescription", query = "SELECT b FROM Blueprint b WHERE b.description = :description"),
    @NamedQuery(name = "Blueprint.findByNumber", query = "SELECT b FROM Blueprint b WHERE b.number = :number"),
    @NamedQuery(name = "Blueprint.findByHeight", query = "SELECT b FROM Blueprint b WHERE b.height = :height"),
    @NamedQuery(name = "Blueprint.findByWidth", query = "SELECT b FROM Blueprint b WHERE b.width = :width")})
public class Blueprint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "blueprint_id")
    private Long blueprintId;
    @Lob
    @Column(name = "blueprint")
    private byte[] blueprint;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @Size(max = 450)
    @Column(name = "description")
    private String description;
    @Column(name = "number")
    private Integer number;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "height")
    private Double height;
    @Column(name = "width")
    private Double width;
    
    @JsonIgnore
    @JoinColumn(name = "bridge_bridge_id", referencedColumnName = "bridge_id")
    @ManyToOne
    private Bridge bridgeBridgeId;

    public Blueprint() {
    }

    public Blueprint(Long blueprintId) {
        this.blueprintId = blueprintId;
    }

    public Long getBlueprintId() {
        return blueprintId;
    }

    public void setBlueprintId(Long blueprintId) {
        this.blueprintId = blueprintId;
    }

    public byte[] getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(byte[] blueprint) {
        this.blueprint = blueprint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
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
        hash += (blueprintId != null ? blueprintId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blueprint)) {
            return false;
        }
        Blueprint other = (Blueprint) object;
        if ((this.blueprintId == null && other.blueprintId != null) || (this.blueprintId != null && !this.blueprintId.equals(other.blueprintId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Blueprint[ blueprintId=" + blueprintId + " ]";
    }
    
}
