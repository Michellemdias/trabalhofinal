package br.com.gama.projetofinal.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ITMN032_AGENDAMENTO")
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numSeq")
	private int numSeq;
	
	@Column(name="nomecli", length=50)
	private String nomecli;
	
	@Column(name="emailcli", length=80)
	private String emailcli;
	
	@Column(name="celularcli", length=15)
	private String celularcli;
	
	@Column(name="dataagendamento")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date dataagendamento;
	
	@Column(name="horaagendamento", length=5)
	private String horaagendamento;
	
	@ManyToOne
	@JsonIgnoreProperties("agendamento")
	private Agencia agencia;

	public Agendamento() {
		super();
	}

	public Agendamento(int numSeq, String nomecli, String emailcli, String celularcli, Date dataagendamento,
			String horaagendamento, Agencia agencia) {
		super();
		this.numSeq = numSeq;
		this.nomecli = nomecli;
		this.emailcli = emailcli;
		this.celularcli = celularcli;
		this.dataagendamento = dataagendamento;
		this.horaagendamento = horaagendamento;
		this.agencia = agencia;
	}

	public int getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}

	public String getNomecli() {
		return nomecli;
	}

	public void setNomecli(String nomecli) {
		this.nomecli = nomecli;
	}

	public String getEmailcli() {
		return emailcli;
	}

	public void setEmailcli(String emailcli) {
		this.emailcli = emailcli;
	}

	public String getCelularcli() {
		return celularcli;
	}

	public void setCelularcli(String celularcli) {
		this.celularcli = celularcli;
	}

	public Date getDataagendamento() {
		return dataagendamento;
	}

	public void setData_agendamento(Date dataagendamento) {
		this.dataagendamento = dataagendamento;
	}

	public String getHoraagendamento() {
		return horaagendamento;
	}

	public void setHoraagendamento(String horaagendamento) {
		this.horaagendamento = horaagendamento;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

}
