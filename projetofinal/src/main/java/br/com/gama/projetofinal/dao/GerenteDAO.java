package br.com.gama.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.gama.projetofinal.model.Gerente;

/*
 * DAO => Data Access Object
 * Classes que contém os métodos que irão manipular os dados
 * manipular os dados = CRUD
 * C => Create (inserir dado na tabela)
 * R => Read (consultar dado na tabela)
 * U => Update (alterar dado na tabela)
 * D => Delete (apagar dado na tabela)
 * Classe CrudRepository<1ºClasseBeans,2ºTipodeDadoPK>
 */

public interface GerenteDAO extends CrudRepository<Gerente,Integer>{
	
	public Gerente findByEmailAndSenha(String email, String senha);
	
	public Gerente findByRacfAndSenha(String racf, String senha);

}
