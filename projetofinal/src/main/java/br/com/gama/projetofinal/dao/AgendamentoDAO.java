package br.com.gama.projetofinal.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.gama.projetofinal.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer>{
	
	public List<Agendamento> findByAgenciaId(int id);
	
	public List<Agendamento> findByDataagendamento(Date dataagendamento);
	
	public List<Agendamento> findByNomecli(String nomecli);
	
	public List<Agendamento> findByAgenciaIdAndDataagendamento(int id, Date dataagendamento);
	
	public List<Agendamento> findByAgenciaIdAndNomecli(int id, String nomecli);
	
	public List<Agendamento> findByNomecliAndDataagendamento(String nomecli, Date dataagendamento);
	
	public List<Agendamento> findByAgenciaIdAndNomecliAndDataagendamento(int id, String nomecli,Date dataagendamento);
	
	public List<Agendamento> findByHoraagendamento(String horaagendamento);
	

}
