package br.com.gama.projetofinal.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.gama.projetofinal.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer>{
	
	public List<Agendamento> findByAgencia(int numSeq);
	
	public List<Agendamento> findByDataagendamento(Date dataagendamento);
	
	public List<Agendamento> findByNomecli(String nomecli);
	
	public List<Agendamento> findByAgenciaAndDataagendamento(int numSeq, Date dataagendamento);
	
	public List<Agendamento> findByAgenciaAndNomecli(int numSeq, String nomecli);
	
	public List<Agendamento> findByNomecliAndDataagendamento(String nomecli, Date dataagendamento);
	
	public List<Agendamento> findByAgenciaAndNomecliAndDataagendamento(int numSeq, String nomecli,Date dataagendamento);
	
	public List<Agendamento> findByHoraagendamento(String horaagendamento);

}
