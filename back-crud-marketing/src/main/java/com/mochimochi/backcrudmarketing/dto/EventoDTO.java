package com.mochimochi.backcrudmarketing.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EventoDTO(
    @JsonProperty("_id") long id, 
    @NotBlank @NotNull @Length(min = 5, max = 200) String nome, 
    @NotNull @Length(max = 300) String descricao, 
    String img,
    @Length(max = 200) String urlEvento)
    //Boolean like) 
    {}
