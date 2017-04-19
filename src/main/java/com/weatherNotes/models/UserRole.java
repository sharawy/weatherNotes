package com.weatherNotes.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "UserRoles"
)
public class UserRole implements java.io.Serializable {

    @Range(min = 1, max = 4)
    @Min(value=1)
    @Id
    private Integer userRoleId;
    @Column(unique = true)
    private String userRoleName;

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }
   
 
}
