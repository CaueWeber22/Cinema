package com.project.systemCinema.data;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

//ENTIDADE PARA OS FILMES
@Data
@Entity
@Table(name = "filmes")
public class FilmesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message="Preencha o título")
    private String titulo;
    
    @NotBlank(message="Preencha o gênero")
    private String genero;
    
    @NotNull(message = "Preencha o ano de lançamento")
    @Min(value = 1850, message = "O ano de lançamento deve ser maior ou igual a 1850")
    @Max(value = 2030, message = "O ano de lançamento deve ser menor ou igual a 2030")
    private Integer ano_lancamento;
    
    @NotBlank(message="Preencha a sinopse")
    private String sinopse;
}
