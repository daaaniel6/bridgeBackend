/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.security.dto;

/**
 *
 * @author daniel
 */
public class JwtDto {

    private String token;
    // private String bearer = "Bearer";
    // private String username;
    // private Collection<? extends GrantedAuthority> authorities;

    public JwtDto() {
    }

    public JwtDto(String token) {
        this.token = token;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
