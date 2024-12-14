package com.project.systemCinema.controller;

import com.project.systemCinema.data.AnalisesEntity;
import com.project.systemCinema.service.AnalisesService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller para requisições de análises
@RestController
@RequestMapping("/analise")
public class AnalisesRestController {
    @Autowired
    AnalisesService analiseService;
    
    //Request para pesquisa de análises pelo ID do filme
    @GetMapping("/listar/{idFilme}")
    public ResponseEntity<List> listarByIdFilme(@PathVariable Integer idFilme){
        List<AnalisesEntity> listAnalises = analiseService.getAnalisesByIdFilme(idFilme);
        
        return new ResponseEntity<>(listAnalises, HttpStatus.OK);
    }
    
    //Request para criação de nova análise
    @PostMapping("/adicionar")
    public ResponseEntity<AnalisesEntity> adicionarAnalise(@Valid @RequestBody AnalisesEntity analise){
        var novaAnalise = analiseService.criarAnalise(analise);
        return new ResponseEntity<>(novaAnalise, HttpStatus.CREATED);     
    }
    
    //Request para alteração de dados de uma análise
    @PutMapping("/alterar/{id}")
    public ResponseEntity<AnalisesEntity> alterarAnalise 
        (@PathVariable Integer id, @Valid @RequestBody AnalisesEntity analise){
        var alterarAnalise = analiseService.alterarAnalise(analise, id);
            
            return new ResponseEntity<>(alterarAnalise, HttpStatus.OK);
    }
        
    @DeleteMapping("/deletar/{id}") 
    public ResponseEntity deletarAnalise(@PathVariable Integer id){
        analiseService.deletarAnalise(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
