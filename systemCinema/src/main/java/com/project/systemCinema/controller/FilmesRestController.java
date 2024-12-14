package com.project.systemCinema.controller;

import com.project.systemCinema.data.FilmesEntity;
import com.project.systemCinema.service.FilmesService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller para requisições de filmes
@RestController
@RequestMapping("/filme")
public class FilmesRestController {
    @Autowired
    FilmesService filmesService;
    
    //Request para listagem de todos os filmes
    @GetMapping("/listar")
    public ResponseEntity<List> getAllFilmes(){
        List<FilmesEntity> filmes = filmesService.getAllFilmes();
        
        return new ResponseEntity<>(filmes,HttpStatus.OK);
    }
    
    //Request para listagem de filmes que contenham o título
    @GetMapping("/pesquisar/{titulo}")
    public ResponseEntity<List> getFilmesTituloLike(@PathVariable String titulo){
        List<FilmesEntity> filmes = filmesService.getByNomeLike(titulo);
               
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }
    
    //Request para adicionar filme ao DB
    @PostMapping("/adicionar")
    public ResponseEntity<FilmesEntity> criarFilme(@Valid @RequestBody FilmesEntity filme){
         var novoFilme = filmesService.criarFilme(filme);
        
         return new ResponseEntity<>(novoFilme, HttpStatus.CREATED);
    }
    
    //Request para alteração de dados de um filme
    @PutMapping("/alterar/{id}")
    public ResponseEntity<FilmesEntity> atualizarFilme(@Valid @RequestBody FilmesEntity filme, @PathVariable Integer id){
        var filmeAtualizado = filmesService.alterarFilme(filme, id);
        
        return new ResponseEntity<>(filmeAtualizado, HttpStatus.OK);
    }
    
    //Request para delete de filme 
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarFilme(@PathVariable Integer id){
        filmesService.deletarFilme(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
