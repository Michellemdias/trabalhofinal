package br.com.gama.projetofinal.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ITMN032_AGENCIA")
public class Agencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nomeagencia", length=80)
	private String nomeAgencia;
	
	@Column(name="horainicio", length=5)
	private String horainicio;
	
	@Column(name="horafim", length=5)
	private String horafim;
	
	@OneToMany(mappedBy="agencia", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("agencia")
	private List<Agendamento> agendamento;

	public Agencia() {
		super();
	}

	public Agencia(int id, String nomeAgencia, String horainicio, String horafim, List<Agendamento> agendamento) {
		super();
		this.id = id;
		this.nomeAgencia = nomeAgencia;
		this.horainicio = horainicio;
		this.horafim = horafim;
		this.agendamento = agendamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeAgencia() {
		return nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	public String getHorainicio() {
		return horainicio;
	}

	public void setHora_inicio(String horainicio) {
		this.horainicio = horainicio;
	}

	public String getHorafim() {
		return horafim;
	}

	public void setHorafim(String horafim) {
		this.horafim = horafim;
	}

	public List<Agendamento> getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(List<Agendamento> agendamento) {
		this.agendamento = agendamento;
	}	


	
}
