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
@Table(name = "bridge_inspector")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BridgeInspector.findAll", query = "SELECT b FROM BridgeInspector b"),
    @NamedQuery(name = "BridgeInspector.findByBridgeInspectorId", query = "SELECT b FROM BridgeInspector b WHERE b.bridgeInspectorId = :bridgeInspectorId"),
    @NamedQuery(name = "BridgeInspector.findByDescription", query = "SELECT b FROM BridgeInspector b WHERE b.description = :description")})
public class BridgeInspector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bridge_inspector_id")
    private Long bridgeInspectorId;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "bridge_bridge_id", referencedColumnName = "bridge_id")
    @ManyToOne
    private Bridge bridgeBridgeId;
    @JoinColumn(name = "inspector_inspector_id", referencedColumnName = "inspector_id")
    @ManyToOne
    private Inspector inspectorInspectorId;

    public BridgeInspector() {
    }

    public BridgeInspector(Long bridgeInspectorId) {
        this.bridgeInspectorId = bridgeInspectorId;
    }

    public Long getBridgeInspectorId() {
        return bridgeInspectorId;
    }

    public void setBridgeInspectorId(Long bridgeInspectorId) {
        this.bridgeInspectorId = bridgeInspectorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bridge getBridgeBridgeId() {
        return bridgeBridgeId;
    }

    public void setBridgeBridgeId(Bridge bridgeBridgeId) {
        this.bridgeBridgeId = bridgeBridgeId;
    }

    public Inspector getInspectorInspectorId() {
        return inspectorInspectorId;
    }

    public void setInspectorInspectorId(Inspector inspectorInspectorId) {
        this.inspectorInspectorId = inspectorInspectorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bridgeInspectorId != null ? bridgeInspectorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BridgeInspector)) {
            return false;
        }
        BridgeInspector other = (BridgeInspector) object;
        if ((this.bridgeInspectorId == null && other.bridgeInspectorId != null) || (this.bridgeInspectorId != null && !this.bridgeInspectorId.equals(other.bridgeInspectorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.BridgeInspector[ bridgeInspectorId=" + bridgeInspectorId + " ]";
    }
    
}
