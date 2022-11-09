package br.ucsal.cadastro;

import br.ucsal.cadastro.exception.CadastroException;

public class CadastroBs {	
	
		private static CadastroBs instancia;
		
		public void Cadastrar(String nome, String usuario, String senha) throws CadastroException {
			Cadastro cad= new Cadastro(usuario,nome,senha);
			persistir(cad);	
		}
		public void validar(Cadastro cadastro)throws CadastroException{
			if (cadastro.getNome()==null||cadastro.getUsuario()==null||
					cadastro.getSenha()==null) {
				throw new CadastroException("Preencha todos os campos");
			}
		}
		public static CadastroBs getInstancia() {
			if(instancia==null) {
				instancia= new CadastroBs();
			}
			return instancia;
		}
		public void persistir(Cadastro cad)throws CadastroException {
			validar(cad);
			CadastroDao.Cadastros.add(cad);
		}
		



}
