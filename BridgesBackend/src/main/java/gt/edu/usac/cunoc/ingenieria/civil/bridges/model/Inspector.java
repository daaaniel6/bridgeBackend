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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "inspector")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inspector.findAll", query = "SELECT i FROM Inspector i"),
    @NamedQuery(name = "Inspector.findByInspectorId", query = "SELECT i FROM Inspector i WHERE i.inspectorId = :inspectorId"),
    @NamedQuery(name = "Inspector.findByName", query = "SELECT i FROM Inspector i WHERE i.name = :name"),
    @NamedQuery(name = "Inspector.findByTelephone", query = "SELECT i FROM Inspector i WHERE i.telephone = :telephone"),
    @NamedQuery(name = "Inspector.findByEmail", query = "SELECT i FROM Inspector i WHERE i.email = :email"),
    @NamedQuery(name = "Inspector.findByRole", query = "SELECT i FROM Inspector i WHERE i.role = :role")})
public class Inspector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inspector_id")
    private Long inspectorId;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @Size(max = 450)
    @Column(name = "telephone")
    private String telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 450)
    @Column(name = "email")
    private String email;
    @Size(max = 450)
    @Column(name = "role")
    private String role;
    @OneToMany(mappedBy = "inspectorInspectorId")
    private List<BridgeInspector> bridgeInspectorList;
    @OneToMany(mappedBy = "inspectorInspectorId")
    private List<Comment> commentList;

    public Inspector() {
    }

    public Inspector(Long inspectorId) {
        this.inspectorId = inspectorId;
    }

    public Long getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(Long inspectorId) {
        this.inspectorId = inspectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public List<BridgeInspector> getBridgeInspectorList() {
        return bridgeInspectorList;
    }

    public void setBridgeInspectorList(List<BridgeInspector> bridgeInspectorList) {
        this.bridgeInspectorList = bridgeInspectorList;
    }

    @XmlTransient
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inspectorId != null ? inspectorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inspector)) {
            return false;
        }
        Inspector other = (Inspector) object;
        if ((this.inspectorId == null && other.inspectorId != null) || (this.inspectorId != null && !this.inspectorId.equals(other.inspectorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Inspector[ inspectorId=" + inspectorId + " ]";
    }
    
}
