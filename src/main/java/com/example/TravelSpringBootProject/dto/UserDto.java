package com.example.TravelSpringBootProject.dto;

import com.example.TravelSpringBootProject.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserDto extends BaseDto {
    @Length(min = 10,max = 50)
    @Email
    @NotNull
    private String email;

    @Length(min = 8,max = 64)
    @NotNull
    private String password;

    @NotNull
    private int status;

    @NotNull
    private Set<Role> roles = new HashSet<>();

    private String accessToken;
    private String refreshToken;

    public UserDto(){};

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
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


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
