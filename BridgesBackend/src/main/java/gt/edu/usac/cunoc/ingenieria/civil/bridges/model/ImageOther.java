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
@Table(name = "image_other")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImageOther.findAll", query = "SELECT i FROM ImageOther i"),
    @NamedQuery(name = "ImageOther.findByImageOtherId", query = "SELECT i FROM ImageOther i WHERE i.imageOtherId = :imageOtherId"),
    @NamedQuery(name = "ImageOther.findByName", query = "SELECT i FROM ImageOther i WHERE i.name = :name"),
    @NamedQuery(name = "ImageOther.findByComment", query = "SELECT i FROM ImageOther i WHERE i.comment = :comment")})
public class ImageOther implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "image_other_id")
    private Long imageOtherId;
    @Size(max = 4500)
    @Column(name = "name")
    private String name;
    @Size(max = 450)
    @Column(name = "comment")
    private String comment;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @JoinColumn(name = "other_other_id", referencedColumnName = "other_id")
    @ManyToOne
    private Other otherOtherId;

    public ImageOther() {
    }

    public ImageOther(Long imageOtherId) {
        this.imageOtherId = imageOtherId;
    }

    public Long getImageOtherId() {
        return imageOtherId;
    }

    public void setImageOtherId(Long imageOtherId) {
        this.imageOtherId = imageOtherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Other getOtherOtherId() {
        return otherOtherId;
    }

    public void setOtherOtherId(Other otherOtherId) {
        this.otherOtherId = otherOtherId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageOtherId != null ? imageOtherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImageOther)) {
            return false;
        }
        ImageOther other = (ImageOther) object;
        if ((this.imageOtherId == null && other.imageOtherId != null) || (this.imageOtherId != null && !this.imageOtherId.equals(other.imageOtherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.usac.cunoc.ingenieria.civil.bridges.model.ImageOther[ imageOtherId=" + imageOtherId + " ]";
    }
    
}
