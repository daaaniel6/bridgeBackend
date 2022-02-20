/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Bridge;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Comment;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author daniel
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    
    @Size(max = 255)
    @Column(name = "name")
    @NotNull
    private String name;
    
    @Size(max = 255)
    @NotNull
    @Column(name = "user_name", unique = true)
    private String userName;
    
    @Size(max = 255)
    @Column(name = "email")
    @NotNull
    private String email;
    
    @Size(max = 255)
    @Column(name = "password")
    @NotNull
    private String password;
    
//  @Size(max = 255)
    @Column(name = "token_password")
    private String tokenPassword;
    @NotNull
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_rol", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Comment> commentList;
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Bridge> bridgeList;

    public User() {
    }

    public User(String name, String userName, String email, String password) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTokenPassword() {
        return tokenPassword;
    }

    public void setTokenPassword(String tokenPassword) {
        this.tokenPassword = tokenPassword;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Bridge> getBridgeList() {
        return bridgeList;
    }

    public void setBridgeList(List<Bridge> bridgeList) {
        this.bridgeList = bridgeList;
    }

    
    

}
