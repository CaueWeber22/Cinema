package com.project.systemCinema.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

//Entidade para análises
@Data
@Entity
@Table(name="analises")
public class AnalisesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message = "Preencha a análise")
    private String analise;
    
    @NotNull(message = "O ID do filme é obrigatório")
    private Integer idFilme;
    
    @NotNull(message = "Dê uma nota")
    @Min(value = 0, message="Escolha uma nota entre 0 e 10")
    @Max(value = 10, message="Escolha uma nota entre 0 e 10")
    private Integer nota;
}
