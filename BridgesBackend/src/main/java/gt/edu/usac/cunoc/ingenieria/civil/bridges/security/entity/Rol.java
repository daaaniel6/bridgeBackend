/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.security.entity;

import com.sun.istack.NotNull;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.enums.NameRol;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author daniel
 */

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private NameRol nameRol;

    public Rol() {
    }

    public Rol(NameRol nemRol) {
        this.nameRol = nemRol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NameRol getNameRol() {
        return nameRol;
    }

    public void setNameRol(NameRol nameRol) {
        this.nameRol = nameRol;
    }
    
    
    
}
