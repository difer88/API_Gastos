package br.com.gastosapi.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.gastosapi.util.ConversorLocalDate;
import br.com.gastosapi.util.DeserializadorLocalDate;
import br.com.gastosapi.util.SerializadorLocalDate;

@Entity
@Table(name = "gasto")
@NamedQuery(name = "Gasto.gastosPorDataGasto",
        query = "SELECT g FROM Gasto g WHERE g.dataGasto =:data_gasto AND g.codigoUsuario =:codigo_usuario"
)
public class Gasto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_gasto")
	private Long idGasto;

	@Column(name="descricao")
	private String descricao;
	
	@Column(name = "valor", nullable = false)
	private double valor;

	@Column(name="codigo_usuario")
	private Long codigoUsuario;

	@Convert(converter = ConversorLocalDate.class)
	@JsonSerialize(using = SerializadorLocalDate.class)
	@JsonDeserialize(using = DeserializadorLocalDate.class)
	@Column(name= "data_gasto", columnDefinition = "DATETIME" ,nullable = true)
	private LocalDate dataGasto;

	public Long getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(Long idGasto) {
		this.idGasto = idGasto;
	}

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}
	
	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public LocalDate getDataGasto() {
		return dataGasto;
	}
	
	public void setDataGasto(LocalDate dataGasto) {
		this.dataGasto = dataGasto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}