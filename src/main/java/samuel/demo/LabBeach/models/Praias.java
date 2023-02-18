package samuel.demo.LabBeach.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="TB_praias")
public class Praias implements Serializable{
	private static final long serialVersionUID = 2l;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private Boolean acessibilidade;
	private String status;
	
	@ManyToOne
    @JoinColumn(name = "id_bairro")
    private Bairros bairro;
	 
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
	public Boolean getAcessibilidade() {
		return acessibilidade;
	}
	public void setAcessibilidade(Boolean acessibilidade) {
		this.acessibilidade = acessibilidade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Bairros getBairro() {
        return bairro;
    }

    public void setBairro(Bairros bairro) {
        this.bairro = bairro;
    }
}
