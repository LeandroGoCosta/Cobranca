package com.inuvens.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inuvens.cobranca.model.StatusTitulo;
import com.inuvens.cobranca.model.Titulo;
import com.inuvens.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		//mv.addObject("todosStatusTitulo", StatusTitulo.values());
		return mv;
	}
	
	@GetMapping()
	public ModelAndView salvar(Titulo titulo) {
		
		titulos.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo"); 
		mv.addObject("mensagem","Titulo Salvo com sucesso!!!");
		//mv.addObject("todosStatusTitulo", StatusTitulo.values());
		return mv;
		
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());		
	}
	
	
}
