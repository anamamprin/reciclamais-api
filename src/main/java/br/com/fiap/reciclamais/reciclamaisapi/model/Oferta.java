package br.com.fiap.reciclamais.reciclamaisapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_oferta")
public class Oferta {
	
	@Id
	@SequenceGenerator(name="oferta",sequenceName="sq_tbl_oferta",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="oferta")
    @Column(name = "cd_oferta")
    private long codigo;
	
	@Column(name= "dt_oferta", nullable = false)
	private LocalDateTime data;
	
	@Column(name = "tp_oferta", nullable = false)
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "cd_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "cd_reciclavel")
	private Reciclavel reciclavel;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Reciclavel getReciclavel() {
		return reciclavel;
	}

	public void setReciclavel(Reciclavel reciclavel) {
		this.reciclavel = reciclavel;
	}
}
