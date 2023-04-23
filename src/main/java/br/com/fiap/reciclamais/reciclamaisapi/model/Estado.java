package br.com.fiap.reciclamais.reciclamaisapi.model;

import javax.persistence.*;

@Entity
@Table(name = "t_estado")
public class Estado {
	
	@Id
    @Column(name = "cd_estado")
    private String uf;

	@Column(name = "nm_estado")
    private String nome;

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
