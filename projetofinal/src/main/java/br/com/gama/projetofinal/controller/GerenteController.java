package br.com.gama.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.projetofinal.dao.GerenteDAO;
import br.com.gama.projetofinal.model.Gerente;

@RestController
@CrossOrigin("*")
public class GerenteController {
	
	@Autowired
	private GerenteDAO dao;
	
	@PostMapping("/login")
	public ResponseEntity<Gerente> logar(@RequestBody Gerente objeto){
		
		Gerente gerente = dao.findByEmailAndSenha(objeto.getEmail(), objeto.getSenha());
		
		if(gerente==null) return ResponseEntity.status(404).build();
		
		return ResponseEntity.ok(gerente);
	}
	
	@PostMapping("/loginracf")
	public ResponseEntity<Gerente> logarRacf(@RequestBody Gerente objeto){
		
		Gerente gerente = dao.findByRacfAndSenha(objeto.getRacf(), objeto.getSenha());
		
		if(gerente==null) return ResponseEntity.status(404).build();
		
		return ResponseEntity.ok(gerente);
	}
	
	@GetMapping("/buscaGerente")
	public ResponseEntity<List<Gerente>> getAll(){
		
		List<Gerente>  lista = (List<Gerente>) dao.findAll();
		
		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
		
	}

}
