package samuel.demo.LabBeach.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_bairros")

public class Bairros implements Serializable {
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private String descrincao;

	private Integer populacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrincao() {
		return descrincao;
	}

	public void setDescrincao(String descrincao) {
		this.descrincao = descrincao;
	}

	public Integer getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}

}
