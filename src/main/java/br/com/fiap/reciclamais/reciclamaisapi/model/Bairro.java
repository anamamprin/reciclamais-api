package br.com.fiap.reciclamais.reciclamaisapi.model;


import javax.persistence.*;

@Entity
@Table(name = "t_bairro")
public class Bairro {
	
	@Id
	@SequenceGenerator(name="bairro",sequenceName="sq_tbl_bairro",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bairro")
    @Column(name = "cd_bairro")
    private long codigo;

	@Column(name = "nm_bairro", nullable = false)
    private String nome;
	
	@ManyToOne
	@JoinColumn(name = "cd_cidade")
	private Cidade cidade;

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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
