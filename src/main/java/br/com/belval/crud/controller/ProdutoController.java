package br.com.belval.crud.controller;

import java.util.ArrayList;      // importação para Array
import java.util.List;           // importação para List

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.belval.crud.model.Produto;

  ///ADICIONANDO O ATRIBUTO PROXID DO TIPO INT Á CLASSE PRODUTO CONTROLLER ////////////////////////////////////////

@Controller
public class ProdutoController {
	
	private static List<Produto> listaProdutos = new ArrayList<Produto>();
	private static int proxId = 1;  // lista produtos é um atributo serve para armazenar tudo que for inserir
	                               // cada produto inserido deve ter um valor diferente de ID dentro do objeto produto
	@GetMapping("/produto/novo")
	public String novo() {
		return "novo-produto";
	}
	
/////ADICIONADO O METODO NOVO (PRODUTO NOVO)////////////////////////////////////////////////////////////////////////	
	
	@PostMapping("/produto/novo")
	public ModelAndView novo(Produto produto,RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/produto/list");
		redirectAttributes.addFlashAttribute("msg", "Novo produto criado!");	
		produto.setId(proxId++);      //proxId++ significa proximo produto adicionado  
		listaProdutos.add(produto);   // adicinando a lista produto
		
		return modelAndView;
	}
///////ADICIONANDO O METODO LIST E ASSOCIANDO Á URL /////////////////////////////////////////////////////////////////	
	
	 @GetMapping ("/produto/list")
	  public ModelAndView list() {
		 ModelAndView modelAndView = new ModelAndView ("lista-produtos");    // novo produto
		 modelAndView.addObject("produtos",listaProdutos);                  // add produtos
		 return modelAndView;                                               //resultado produto
	 }
	 
/////////ADICIOANDO O ARQUIVO LISTA PRODUTO.HTML AOS TEMPLATES//////////////////////////////////////////////////////
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
