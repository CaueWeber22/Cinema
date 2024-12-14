package com.project.systemCinema.data;

import com.project.systemCinema.data.AnalisesEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//REPOSITÓRIO PARA ABSTRAÇÃO DA LÓGICA DE DADOS DAS ANÁLISES
@Repository
public interface AnalisesRepository extends JpaRepository<AnalisesEntity, Integer> {
   List<AnalisesEntity> findByIdFilme(Integer idFilme);
   void deleteByIdFilme(Integer idFilme);
}
  
