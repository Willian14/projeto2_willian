/*Passos para criar uma aplicação web com maven
 * 1-adicionar o build com o plugin para configurar o maven para rodar na versão 1.8 do java
 * 2-pesquisar no site mvnrepository as dependências do driver jdbc do banco em uso
 * 3-criar uma classe ConexaoFactory para disponibilizar uma conexão para cada Dao que solicitar
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
				//Relançando exception
				throw new RuntimeException(e);
			}
	}

}