package br.com.willian2;

import br.com.willian2.entidade.Usuario;
import br.com.willian2.persistencia.UsuarioDao;

public class TesteUsuarioDao {

	public static void main(String[] args) {
		 testeExcluir();
		
	
	}
	
	
	public static void testeCadastrar(){
		Usuario usu = new Usuario();
		usu.setNome("Valdinei");
		usu.setLogin("nei");
		usu.setSenha("12345");
		
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.cadastrar(usu);
		
		System.out.println("Inserido com sucesso!!!!!");
	}
	
	public static void testeAlterar(){
		Usuario usu = new Usuario();
		usu.setId(4);
		usu.setNome("Willian");
		usu.setLogin("w");
		usu.setSenha("21010032");
		
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.alterar(usu);
		
		System.out.println("Alterado com sucesso!!!!!!!");
	}
	
	public static void testeExcluir(){
		Usuario usu = new Usuario();
		usu.setId(2);
		
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.excluir(usu);
		
		System.out.println("Excluido com sucesso!!!!!!");
	}
	//Parei na aula 2 tempo 2:14:20....
}
