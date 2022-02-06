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
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByCommentId", query = "SELECT c FROM Comment c WHERE c.commentId = :commentId"),
    @NamedQuery(name = "Comment.findByComment", query = "SELECT c FROM Comment c WHERE c.comment = :comment"),
    @NamedQuery(name = "Comment.findByUserId", query = "SELECT c FROM Comment c WHERE c.userId = :userId")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comment_id")
    private Long commentId;
    @Size(max = 4500)
    @Column(name = "comment")
    private String comment;
    @Size(max = 450)
    @Column(name = "user_id")
    private String userId;
    
    @JsonIgnore
    @JoinColumn(name = "bridge_bridge_id", referencedColumnName = "bridge_id")
    @ManyToOne
    private Bridge bridgeBridgeId;
    @JoinColumn(name = "inspector_inspector_id", referencedColumnName = "inspector_id")
    @ManyToOne
    private Inspector inspectorInspectorId;

    public Comment() {
    }

    public Comment(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Comment[ commentId=" + commentId + " ]";
    }
    
}
