/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.emailpassword.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author daniel
 */
public class ChangePasswordDTO {

    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;
    @NotBlank
    private String tokenPassword;

    public ChangePasswordDTO() {
    }

    public ChangePasswordDTO(String password, String confirmPassword, String tokenPassword) {
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.tokenPassword = tokenPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getTokenPassword() {
        return tokenPassword;
    }

    public void setTokenPassword(String tokenPassword) {
        this.tokenPassword = tokenPassword;
    }

}
