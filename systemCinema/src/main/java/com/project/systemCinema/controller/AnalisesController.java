package com.project.systemCinema.controller;

import com.project.systemCinema.data.AnalisesEntity;
import com.project.systemCinema.service.AnalisesService;
import com.project.systemCinema.service.FilmesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Controller para análise
@Controller
public class AnalisesController {
    @Autowired
    AnalisesService analiseService;
    @Autowired
    FilmesService filmeService;
    
    //Mapping para visualização de página para cadastro de análises
    @GetMapping("/CadastroAnalise")
    public String viewCadastroAnalise(Model model, AnalisesEntity analise){
        model.addAttribute("filmes", filmeService.getAllFilmes());
        model.addAttribute("analise", analise);
        
        return "CadastroAnalise";
    }
    
    //Mapping de post para adicionar nova análise ao DB
    @PostMapping("/CadastroAnalise")
    public String cadastrarAnálise(
            @Valid @ModelAttribute("analises") AnalisesEntity analise, BindingResult result){
   
        if(result.hasErrors()){
            return "CadastroAnalise";
        }
        analiseService.criarAnalise(analise);
     
    return "redirect:/CadastroAnalise";
    }   
    
    //Mapping para retornar páginas com análises de um
    @GetMapping("/Analises")
    public String viewAnalisesFilme(@RequestParam("filmeId") Integer filmeId, Model model) { 
        model.addAttribute("analises", analiseService.getAnalisesByIdFilme(filmeId));
        model.addAttribute("filme", filmeService.getFilmeById(filmeId));
        model.addAttribute("id", 0);
       
        return "Analises";
    }
    
    //Mapping para delete de análise
    @PostMapping("/DeletarAnalise")
    public String deletarAnalise(@RequestParam("id") Integer id, @RequestParam("idFilme") Integer idFilme) {        
        analiseService.deletarAnalise(id);
    
        return ("redirect:/Analises?filmeId="+idFilme); 
    }

    //Mapping para abrir página de alteração de análise
    @GetMapping("/AlterarAnalise")  
    public String viewAlterarAnalise(@RequestParam("id") Integer analiseId, Model model){
        model.addAttribute("analise", analiseService.getAnaliseById(analiseId));       
        
        return "AlterarAnalise";
    }
    
    //Mapping para alterar dados de análise
    @PostMapping("/AlteracaoAnalise")
    public String alterarAnálise(
            @Valid @ModelAttribute("analises") AnalisesEntity analise, BindingResult result, Model model){          
         
        if(result.hasErrors()){
            System.out.println("Erro");
            return "AlterarAnalise";
        }
        model.addAttribute("analise", analise);
        analiseService.alterarAnalise(analise, analise.getId());
     
    return "AlterarAnalise";
    }   

}
