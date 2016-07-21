/*Passos para criar uma aplica��o web com maven
 * 1-adicionar o build com o plugin para configurar o maven para rodar na vers�o 1.8 do java
 * 2-pesquisar no site mvnrepository as depend�ncias do driver jdbc do banco em uso
 * 3-criar uma classe ConexaoFactory para disponibilizar uma conex�o para cada Dao que solicitar
 * 4-criar uma classe para a entidade
 * 5-criar uma classe main para fazer os testes dos metodos do Dao
 * */

package br.com.willian2.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnetion() {
			try {
				return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb","postgres","210100");
			} catch (SQLException e) {
				//Relan�ando exception
				throw new RuntimeException(e);
			}
	}

}