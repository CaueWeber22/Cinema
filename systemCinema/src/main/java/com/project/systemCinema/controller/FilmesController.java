package com.project.systemCinema.controller;

import com.project.systemCinema.data.FilmesEntity;
import com.project.systemCinema.service.AnalisesService;
import org.springframework.ui.Model;
import com.project.systemCinema.service.FilmesService;
import jakarta.servlet.http.Cookie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Controlador para filmes
@Controller
public class FilmesController {
    @Autowired
    FilmesService filmeService;
    @Autowired
    AnalisesService analiseService;
    
    //Mapping para visualização da página de cadastro de filmes
    @GetMapping("/CadastroFilme")
    public String ViewCadastroFilme(@CookieValue(name="tema", defaultValue="dark")String tema, Model model){
        System.out.println(tema + " FilmesController");
        model.addAttribute("filme", new FilmesEntity());
        model.addAttribute("tema", tema);
        
        return "CadastroFilme";
    }
    
    //Mapping de post para adicionar novo filme ao DB
    @PostMapping("/CadastroFilme")
    public String cadastrarFilme(
            @Valid @ModelAttribute("filme") FilmesEntity filme, BindingResult result){
   
        if(result.hasErrors()){
            return "CadastroFilme";
        }
        filmeService.criarFilme(filme);
     
    return "redirect:/CadastroFilme";
    }
    
    //Mapping para visualizar página de exibição de filmes
    @GetMapping("/ExibirFilmes")
    public String viewFilmes(Model model){
        model.addAttribute("filmes", filmeService.getAllFilmes());
        
        return "ExibirFilmes";
    }
    
    //Mapping para retornar análises de um filme
    @PostMapping("/ExibirFilmes")
    public String exibirAnalises(@RequestParam("filmeId") Integer filmeId, Model model) {       
        model.addAttribute("filmeId", filmeId);

        return "Analises";
    }  
    
    //Mapping para abrir página de alteração dos filmes (exclusão e alteração de filmes)
    @GetMapping("/AlterarFilmes")
    public String exibirAlterarFilmes(Model model){
        model.addAttribute("filme", new FilmesEntity());
        model.addAttribute("filmes", filmeService.getAllFilmes());
              
        return "AlterarFilmes";
    }

    //Mapping para post de alteração de dados de um filme
    @PostMapping("/AlterarFilme")
    public String alteracaoFilme(
            @Valid @ModelAttribute("filme") FilmesEntity filme, BindingResult result) {
     
        if (result.hasErrors()) {
            return "AlterarFilmes";
        }
        
        
        filmeService.alterarFilme(filme, filme.getId());
        return "redirect:/AlterarFilmes";
    }
    
    //Mapping para exclusão de dados de um filme
    @PostMapping("/DeletarFilme")
    public String deletarFilme(@ModelAttribute("filme") FilmesEntity filme){
        //Deletar análises antes de deletar filme
        analiseService.deletarAnaliseByIdFilme(filme.getId());
        filmeService.deletarFilme(filme.getId());
        
        return "redirect:/AlterarFilmes";
    }

}
