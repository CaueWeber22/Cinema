package com.project.systemCinema.service;

import com.project.systemCinema.data.AnalisesEntity;
import com.project.systemCinema.data.AnalisesRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//SERVICE PARA REQUISIÇÃO AO BANCO DE DADOS E REPOSTA PARA ENTIDADES ANÁLISES
@Service
public class AnalisesService {
    @Autowired
    AnalisesRepository analisesRepository;
    
    //Método para buscar análises por ID do filme
    @Transactional
    public List<AnalisesEntity> getAnalisesByIdFilme(Integer idFilme){
        return analisesRepository.findByIdFilme(idFilme);
    }
    
    //Método para buscar análise por seu ID
    @Transactional
    public AnalisesEntity getAnaliseById(Integer id){
        return analisesRepository.findById(id).orElse(null);    
    }
    
    //Método para adicionar análise ao DB
    @Transactional
    public AnalisesEntity criarAnalise(AnalisesEntity analise){
        analise.setId(null);
        analisesRepository.save(analise);
                
        return analise;
    }
    
    @Transactional
    public AnalisesEntity alterarAnalise(AnalisesEntity analiseRequest, Integer id){
        AnalisesEntity analiseAlterar = getAnaliseById(analiseRequest.getId());
        analiseAlterar.setNota(analiseRequest.getNota());
        analiseAlterar.setAnalise(analiseRequest.getAnalise());
        
        analisesRepository.save(analiseAlterar);
        return analiseAlterar;
    }
    
    //Método para deletar análise do DB
    @Transactional 
    public void deletarAnalise(Integer id){
        AnalisesEntity analise = getAnaliseById(id);
        analisesRepository.deleteById(analise.getId());
    }
    
    @Transactional
    public void deletarAnaliseByIdFilme(Integer idFilme){
        analisesRepository.deleteByIdFilme(idFilme);
    }
}
