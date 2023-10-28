package br.com.wesley.dividas.model;


import br.com.wesley.dividas.model.carnaval.Camarote;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
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

	@OneToMany(cascade= CascadeType.ALL)
	@JoinTable(name="usuario_desejo",
			joinColumns={@JoinColumn(name="id_usuario",
					referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="id_desejo",
					referencedColumnName="id")})
	private List<Desejo> desejos;

}
