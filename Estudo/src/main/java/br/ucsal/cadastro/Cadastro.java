package br.ucsal.cadastro;

public class Cadastro {
	private String usuario;
	private String nome;
	private String senha;
	public Cadastro(String usuario, String nome,String senha) {
		this.nome=nome;
		this.usuario=usuario;
		this.senha=senha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
