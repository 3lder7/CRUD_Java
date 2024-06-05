//DAO = PACOTE DE SEPARAÇÃO QUE DÁ ACESSO AOS OBJETOS
package DAO;

import java.sql.Connection;//IMPORTAÇÃO DA CLASSE Connection
import java.sql.DriverManager;//IMPORTAÇÃO DA CLASSE DriveManager
import java.sql.SQLException;//IMPORTAÇÃO DA CLASS SQLException PARA QUE TODA A EXCEÇÃO SEJA DE SQL

import javax.swing.JOptionPane;//IMPORTAÇÃO DAS CLASSES JOptionPane

public class ConexaoDAO {//CRIAÇÃO DA CLASSE "DAO"
	public Connection conectaBD(){//MODO DE VISIBILIDADE = PÚBLICO, TIPO = CONNECTION, E MÉTODO CHAMADO = CONECTABD 
		Connection conn = null; // CRIAÇÃO DE UMA VARIÁVEL CHAMADA CONN DO TIPO CONNECTION COM O VALOR NULL
		
		try {//FAZER VERIFICAÇÃO
			String url = "jdbc:mysql://localhost:3306/bancoteste?user=root&password=";//JDBC:MYSQL = DRIVER DE CONEXÃO //LOCALHOST = POIS É NA PRÓPRIA MÁQUINA // 3306 = PORTA DE CONEXÃO // bancoteste = NOME DA BASE DE DADOS // ?user:root&password=  = USUÁRIO E SENHA PARA A ENTRADA
			
			conn = DriverManager.getConnection(url);//O CONTEÚDO ARMAZENADO NA VARIÁVEL "url" PASSA PARA A VARÁVEL "conn" A QUAL FAZ A CONEXÃO COM O DriverMannager
			
		} catch (SQLException erro) {//SE HOUVER ALGUEM ERRO, IRÁ CAIR NO CATCH // TRAZENDO A CLASSE DE "EXCEÇÃO" E O OBJETO "erro" PARA O SISTEMA GERAR MENSAGEM DE ERRO
			
			JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage());//PUXANDO A CLASSE JOptionPane E EXIBIR MENSAGEM DE ERRO NA TELA COM "showMessageDialog" E O "getMessage()" PARA PUXAR O MÉTODO DE EXIBIR MENSAGEM
			
		}//COLOCA-SE O "ConexaoDAO" POIS DESSA FORMA SE OCORRER ALGUM ERRO AQUI, IREI SABER QUE FOI NESTA CLASSE
		
		return conn; //RETORNA A VARIÁVEL POIS SE FAZ NECESSÁRIO UM RETORNO DOO TIPO CONNECTION PARA O MÉTODO, JÁ QUE ELE É DO TIPO CONNECTION 
	}
}
