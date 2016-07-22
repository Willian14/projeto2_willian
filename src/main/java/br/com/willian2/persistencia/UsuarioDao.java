package br.com.willian2.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.willian2.entidade.Usuario;
import br.com.willian2.persistencia.jdbc.ConexaoFactory;

public class UsuarioDao {
	private Connection con = ConexaoFactory.getConnetion();

	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario (nome,login,senha) values (?,?,?)";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());

			preparador.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void alterar(Usuario usu) {

		String sql = "update usuario set nome=?,login=?,senha=? where id = ?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());

			preparador.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/*
	 * observação: para exucutar comados de inserção, update e delete programar
	 * o preparador para setar na propriedade do objeto desejado. E para fazer
	 * uma consulta (select) setar nas propriedades do objeto os gets do
	 * resultado(ResultSet) das querys
	 * 
	 */
	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id = ?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, usu.getId());

			preparador.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void salvar(Usuario usuario) {
		if (usuario.getId() != null) {
			alterar(usuario);
		} else {
			cadastrar(usuario);
		}
	}

	/**
	 * Busca de um registro por id no banco de dados
	 * 
	 * @param id
	 *            é um inteiro que representa o número do id do usuário no banco
	 *            de dados
	 * @return null quando não encontra o registro e um objeto de usuario quando
	 *         o registro é encontrado
	 */
	public Usuario buscarPorId(Integer id) {
		String sql = "select * from usuario where id = ?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));

				return usu;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Realiza a busca de todos os registros da tabela usuario no banco de dados
	 * 
	 * @returnRetorna uma lista de objetos de Usuario contendo 0 elementos
	 *                quando encontrado e n elementos quando encontrado
	 */
	public List<Usuario> buscarTodos() {
		String sql = "select * from usuario";
		List<Usuario> lista = new ArrayList<Usuario>();
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));

				lista.add(usu);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return lista;

	}

	public Usuario autenticar(Usuario usuConsulta) {
		String sql = "select * from Usuario where login = ? and senha = ?";
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usuConsulta.getLogin());
			preparador.setString(2, usuConsulta.getSenha());

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));

				return usu;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
