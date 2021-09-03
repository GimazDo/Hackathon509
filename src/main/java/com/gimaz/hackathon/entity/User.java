package com.gimaz.hackathon.entity;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("username")
    @Column(name = "username", unique = true)

    private String username;

    @JsonProperty("password")
    @Column(name = "pass")
    private  String password;

    @JsonProperty("email")
    @Column(name = "email")
    private String email;

    @JsonProperty("roles")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Column(name = "organization_name")
    private String OrganizationName;




    public User(String username, String password, String email, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public String rolesToString()
    {
        String roles = "";
        for (Role role: this.roles) {
            roles = roles.concat(" " + role.getName());
        }
        return roles;
    }
    @Override
    public String toString()
    {
        return String.format("Имя пользователя: '%s' \n Email: '%s' \n Права: '%s'",this.username,this.email,rolesToString());
    }

}
