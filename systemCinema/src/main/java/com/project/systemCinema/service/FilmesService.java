package com.project.systemCinema.service;

import com.project.systemCinema.data.FilmesEntity;
import com.project.systemCinema.data.FilmesRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//SERVICE PARA REQUISIÇÃO AO BANCO DE DADOS E REPOSTA PARA ENTIDADES FILMES
@Service
public class FilmesService {
    //iniciando repositório
    @Autowired
    FilmesRepository filmesRepository;
    
    //Método para salvar filme no DB
     @Transactional
    public FilmesEntity criarFilme(FilmesEntity filme){
        filme.setId(null);
        filmesRepository.save(filme);
        
        return filme;
    }
    
    //Método para retornar todos filmes
     @Transactional
    public List<FilmesEntity> getAllFilmes(){      
        return filmesRepository.findAll();
    }
    
    //Método para buscar filme por ID
     @Transactional
    public FilmesEntity getFilmeById(Integer filmeId){
        return filmesRepository.findById(filmeId).orElse(null);
}
    //Método para buscar por nome
    public List<FilmesEntity> getByNomeLike(String titulo){
    List<FilmesEntity> filmes = filmesRepository.findByTituloContaining(titulo);
    
    return filmes;
    }
    
    //Método para alterar dados de filme no DB
     @Transactional
    public FilmesEntity alterarFilme(FilmesEntity filmeRequest, Integer id){
        FilmesEntity filmeAlterar = getFilmeById(id);
        filmeAlterar.setTitulo(filmeRequest.getTitulo());
        filmeAlterar.setGenero(filmeRequest.getGenero());
        filmeAlterar.setSinopse(filmeRequest.getSinopse());
        filmeAlterar.setAno_lancamento(filmeRequest.getAno_lancamento());
        
        filmesRepository.save(filmeAlterar);
        return filmeAlterar;
    }
    
    //Método para deletar filme do DB por meio do id
     @Transactional
    public void deletarFilme(Integer idFilme){
        FilmesEntity filme = getFilmeById(idFilme);
        filmesRepository.deleteById(filme.getId());
    }
}
