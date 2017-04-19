package com.weatherNotes.models;
// Generated Apr 27, 2016 4:03:05 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "Users")
public class User implements java.io.Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer userId;
    
    @OneToOne(fetch = FetchType.EAGER)
    private UserRole userRole;
    @NotEmpty
    private String userName;
    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9]*[a-zA-Z0-9\\ \\_\\.\\#\\!\\@\\$\\%\\'\\^\\&\\*\\(\\)\\-\\+\\=\\?\\>\\<\\,\\\\\\/\\;\\{\\}\\[\\]\\|\\\"\\:\\~]*$", message = "Invalid Password")
    private String password;
    @NotEmpty
    @Length(min = 11,max = 11,message = "must be 11 digits")
    @Pattern(regexp = "[0-9]+",message = "must be numeric values only")  
    private String mobile;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
