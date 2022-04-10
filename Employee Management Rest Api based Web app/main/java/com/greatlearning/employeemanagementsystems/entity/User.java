package com.greatlearning.employeemanagementsystems.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

   @Id
   @Column(name = "user_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name="username")
   private String username;
   @Column(name="password")
   private String password;
   
   @ManyToMany(mappedBy = "users",cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
   private Set<Role> roles;

   public void addRole(Role role){
       if(this.roles == null){
           this.roles = new HashSet<>();
       }
       //set the bidirectional mapping
       this.roles.add(role);
       role.getUsers().add(this);
   }
   
   public User(String username,String password,Set<Role> roles) {
	   super();
	   this.username=username;
	   this.password=password;
	   this.roles=roles;
   }

}
