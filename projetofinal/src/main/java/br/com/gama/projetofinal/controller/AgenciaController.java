package br.com.gama.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.projetofinal.dao.AgenciaDAO;
import br.com.gama.projetofinal.model.Agencia;

@RestController
@CrossOrigin("*")
public class AgenciaController {
	
	@Autowired
	private AgenciaDAO dao;
	
	@GetMapping("/agencia")
	public ResponseEntity<List<Agencia>> getAll(){
		List<Agencia> lista = (List<Agencia>) dao.findAll();
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/novaagencia")
	public ResponseEntity<Agencia> gravar(@RequestBody Agencia objeto){
		try {
			dao.save(objeto);
			return ResponseEntity.ok(objeto);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}

}
