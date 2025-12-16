package com.example.registrationForm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="registration_table",
       uniqueConstraints = {
    		   @UniqueConstraint(columnNames = {"user_email","user_phonenumber"}),
       })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   private String name;
   @Column(name="user_email", nullable=false)
   private String email;
   
   @Column(nullable = false)
   private String password;
   @Column(name="user_phonenumber", nullable=false)
   private String phonenumber;
   
   private String state;
   private String city;
}
