package com.mochimochi.backcrudmarketing.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_idUser")
    private long idUser;

    @NotBlank
    @NotNull
    @Length(min = 10, max = 100)
    @Column(length = 100, nullable = true)
    private String email;

    @NotBlank
    @NotNull
    @Length(min = 10, max = 30)
    @Column(length = 30, nullable = true)
    private String senha;
}
