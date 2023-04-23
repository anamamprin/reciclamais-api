package br.com.fiap.reciclamais.reciclamaisapi.model;


import javax.persistence.*;

@Entity
@Table(name = "t_cidade")
public class Cidade {
	
	@Id
	@SequenceGenerator(name="cidade",sequenceName="sq_tbl_cidade",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cidade")
    @Column(name = "cd_cidade")
    private long codigo;

	@Column(name = "nm_cidade", nullable = false)
    private String nome;
	
	@ManyToOne
	@JoinColumn(name = "cd_estado")
	private Estado estado;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
