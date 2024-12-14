package com.project.systemCinema.data;

import com.project.systemCinema.data.FilmesEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//REPOSITÓRIO PARA ABSTRAÇÃO DA LÓGICA DE DADOS DOS FILMES
@Repository
public interface FilmesRepository extends JpaRepository<FilmesEntity, Integer> {
    List<FilmesEntity> findByTituloContaining(String titulo); 
}
