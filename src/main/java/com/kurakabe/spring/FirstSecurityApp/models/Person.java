package com.kurakabe.spring.FirstSecurityApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @NotEmpty(message = "Username can not be empty")
    @Size(min = 2, max = 100, message = "username must be from 2 to 100 characters long")
    @Column(name = "username")
    private String username;

    @Min(value = 1900, message = "year of birth must be bigger than 1900")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;



    public Person() {

    }

    public Person(String username, int yearOfBirth, String password) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty(message = "Username can not be empty") @Size(min = 2, max = 100, message = "username must be from 2 to 100 characters long") String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty(message = "Username can not be empty") @Size(min = 2, max = 100, message = "username must be from 2 to 100 characters long") String username) {
        this.username = username;
    }

    @Min(value = 1900, message = "year of birth must be bigger than 1900")
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(@Min(value = 1900, message = "year of birth must be bigger than 1900") int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                '}';
    }
}
