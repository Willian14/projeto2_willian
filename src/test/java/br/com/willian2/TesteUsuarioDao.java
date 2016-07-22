package br.com.willian2;

import java.util.List;

import br.com.willian2.entidade.Usuario;
import br.com.willian2.persistencia.UsuarioDao;

public class TesteUsuarioDao {

	public static void main(String[] args) {
		//testeSalvar();
		//testeBuscarPorId();
		//testeBuscarTodos();
		testeAutenticar();
	
	}
	
	
	private static void testeAutenticar() {
		UsuarioDao usuDao = new UsuarioDao();
		Usuario usu = new Usuario();
		usu.setLogin("jjj");
		usu.setSenha("123");
		
		Usuario usuRetorno = usuDao.autenticar(usu);
		
		System.out.println(usuRetorno);
		
	}


	private static void testeBuscarTodos() {
		UsuarioDao usuDao = new UsuarioDao();//instanciando um objeto de usuarioDao para poder usar o metodo buscar todos
		List<Usuario> lista = usuDao.buscarTodos();// adicionando a lista de objeto que veio da Dao e inserindo em outra lista 
		
		for(Usuario u: lista){// Criando uma variável do tipo Usuario de nome u para percorre a lista e imprimir os objetos
			System.out.println(u);
		}
		
	}


	private static void testeBuscarPorId() {
		UsuarioDao usuDao = new UsuarioDao();
		Usuario usu =	usuDao.buscarPorId(1);
		
		System.out.println(usu);
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
	
	public static void testeSalvar(){
		Usuario usuario = new Usuario();
		//usuario.setId(4);
		usuario.setNome("ciclano");
		usuario.setLogin("full");
		usuario.setSenha("123");
		
		UsuarioDao usuDao = new UsuarioDao();
		
		usuDao.salvar(usuario);
		
		System.out.println("Salvo com sucesso!!!!!");
		
	}
	// parei na aula 3 --tempo:42:29
}
