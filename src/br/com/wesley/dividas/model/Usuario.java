package br.com.wesley.dividas.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String login;
	
	@Column
	private String email;
	
	@Column
	private String senha;
	
	@Column
	private String foto;

	@OneToMany(cascade= CascadeType.ALL)
	@JoinTable(name="usuario_renda",
			joinColumns={@JoinColumn(name="id_usuario",
					referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="id_renda",
					referencedColumnName="id")})
	private List<Renda> rendas;

	@OneToMany(cascade= CascadeType.ALL)
	@JoinTable(name="usuario_divida",
			joinColumns={@JoinColumn(name="id_usuario",
					referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="id_divida",
					referencedColumnName="id")})
	private List<Divida> dividas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Renda> getRendas() {
		return rendas;
	}

	public void setRendas(List<Renda> rendas) {
		this.rendas = rendas;
	}

	public List<Divida> getDividas() {
		return dividas;
	}

	public void setDividas(List<Divida> dividas) {
		this.dividas = dividas;
	}
}
