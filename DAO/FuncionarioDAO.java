package DAO;

import java.sql.Connection;//IMPORTAÇÃO DA CLASSE "Connection" PARA USO
import java.sql.PreparedStatement;//IMPORTAÇÃO DA CLASSE "PreparedStatement" PARA USO
import java.sql.ResultSet;//IMPORTAÇÃO PARA RESULTADO DO BANCO DE DADOS
import java.util.ArrayList;//IMPORTAÇÃO PARA ORDENAR AS INFORMAÇÕES EM LISTAS

import javax.swing.JOptionPane;//IMPORTAÇÃO DO "JOptionPane" PARA EXIBIR MENSAGEM DE ERRO

import DTO.FuncionarioDTO;//IMPORTAÇÃO DA CLASSE "FuncionarioDTO" PARA TRABALHAR COM SEUS OBJETOS

public class FuncionarioDAO {
	
	Connection conn;//CRIAÇÃO DE UMA VARIÁVEL DO TIPO "Connection"
	PreparedStatement pstm;//CRIAÇÃO DE UMA VARIÁVEL DO TIPO "PreparedStatement"
	
	ResultSet rs;//TRABALHAR COM AS VARIÁVEIS DO MYSQL ARMAZENANDO DENTRO DA VARIÁVEL "rs" O "ResultSet"
	ArrayList<FuncionarioDTO> lista = new ArrayList<>();//CRIAÇÃO DA VARIÁVEL PARA ARMAZENAR EM "lista" OS VALORES A SEREM EXIBIDOS
	
	public void cadastrarFuncionario(FuncionarioDTO objfuncionariodto) {//MÉTODO CRIADO PARA RECEBER OBJETOS DA DTO // ESSE MÉTODO ESPERA UM VALOR DE "FuncionarioDTO" E SEU OBJETO
		String sql = "insert into funcionario (nome_funcionario, endereco_funcionario) values (?, ?)";//LIGAÇÃO DO CAMINHO ATÉ A TABELA ATRAVÉS DA VARIÁVL SQL // É USADA INTERROGRAÇÃO POIS NÃO SE SABE QUAL VALOR SERÁ INSERIDO
		
		conn = new ConexaoDAO().conectaBD();//ACESSA A CLASSE DE CONEXÃO "ConexaoDAO()" E ACESSA O MÉTODO CRIADO NA CLASSE PARA FAZER A CONEXÃO, O "conectaBD()"
												//A VARIÁVEL "conn" AGORA É RESPONSÁVEL PELA CONEXÃO ⬆⬆⬆
		
		try {
			pstm = conn.prepareStatement(sql);//O VALOR ARMAZENADO EM "sql" É PASSADO PARA "pstm" PARA FAZER A CONEXÃO
			
			pstm.setString(1, objfuncionariodto.getNome_funcionario());//SETA UMA STRING NO PRIMEIRO PARÂMETRO, QUE NO CASO É A PRIMEIRA INTERROGAÇÃO LÁ EM CIMA
																		//UTILIZA O OBJETO "objfuncionariodto" PARA PEGAR O VALOR ARMAZENADO EM NOME LÁ NO MÉTODO DE "FuncionarioDTO"
			pstm.setString(2, objfuncionariodto.getEndereco_funcionario());//SETA UMA STRING NO SEGUNDO PARÂMETRO, QUE NO CASO É A SEGUNDA INTERROGAÇÃO LÁ EM CIMA
																			//UTILIZA O OBJETO "objfuncionariodto" PARA PEGAR O VALOR ARMAZENADO EM ENDERECO LÁ NO MÉTODO DE "FuncionarioDTO"
			
			pstm.execute();//EXECUTAR A VÁRIVAEL
			pstm.close();//FECHAR A CONEXÃO
		} catch (Exception erro) {											
			JOptionPane.showMessageDialog(null, "Cadastrar FuncionarioDAO" + erro);//CRIAÇÃO ENTRE ASPAS PARA LOCALIZAR ONDE FOI O ERRO CASO OCORRA
		}
	}
	
	public ArrayList<FuncionarioDTO> ListarFuncionario(){
		String sql = "select*from funcionario"; //ARMAZENA O COMANDO DENTRO DA VARIÁVEL "sql"
		conn = new ConexaoDAO().conectaBD();
		try {
			pstm = conn.prepareStatement(sql); // PREPARA A CONEXÃO USANDO O COMANDO EM "sql"
			rs = pstm.executeQuery();//EXECUTA O RESULTADO DA QUERY PARA DENTRO DO "rs"
			
			while(rs.next()){//VERIFICA SE AINDA HÁ VALORES NAS LINHAS DO BANCO E PERMANECE DENTRO DO WHILE
				FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
				objFuncionarioDTO.setId_funcionario(rs.getInt("id"));//PEGA A INFORMAÇÃO DO BANCO E ARMAZENA NO METODO DO DTO
				objFuncionarioDTO.setNome_funcionario(rs.getString("nome_funcionario"));//PEGA A INFORMAÇÃO DO BANCO E ARMAZENA NO METODO DO DTO
				objFuncionarioDTO.setEndereco_funcionario(rs.getString("endereco_funcionario"));//PEGA A INFORMAÇÃO DO BANCO E ARMAZENA NO METODO DO DTO
				
				lista.add(objFuncionarioDTO);//MONTAGEM DA LISTA DENTRO DO WHILE PARA ARMAZENAR SEMPRE QUE HOUVER UM VALOR
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar FuncionarioDAO" + erro);
		}
		return lista;
	}
	
	public void alterarFuncionario(FuncionarioDTO objfuncionariodto){
		String sql = "update funcionario set nome_funcionario = ?, endereco_funcionario = ? where id = ?";//COMANDO DE UPDATE NA TABELA
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);//O VALOR ARMAZENADO EM "sql" É PASSADO PARA "pstm" PARA FAZER A CONEXÃO
			
			pstm.setString(1, objfuncionariodto.getNome_funcionario());//SETA UMA STRING NO PRIMEIRO PARÂMETRO, QUE NO CASO É A PRIMEIRA INTERROGAÇÃO LÁ EM CIMA
																		//UTILIZA O OBJETO "objfuncionariodto" PARA PEGAR O VALOR ARMAZENADO EM NOME LÁ NO MÉTODO DE "FuncionarioDTO"
			pstm.setString(2, objfuncionariodto.getEndereco_funcionario());//SETA UMA STRING NO SEGUNDO PARÂMETRO, QUE NO CASO É A SEGUNDA INTERROGAÇÃO LÁ EM CIMA
																			//UTILIZA O OBJETO "objfuncionariodto" PARA PEGAR O VALOR ARMAZENADO EM ENDERECO LÁ NO MÉTODO DE "FuncionarioDTO"
			pstm.setInt(3, objfuncionariodto.getId_funcionario());//SEM ISSO AQUI MUDA A TABELA INTEIRA (PERIGO)
			
			pstm.execute();//EXECUTAR A VÁRIVAEL
			pstm.close();//FECHAR A CONEXÃO
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null,"Alterar Funcionario "+ erro);
		}
		
	}
	
	public void excluirFuncionario(FuncionarioDTO objfuncionariodto) {
		String sql = "delete from funcionario where id = ?";//COMANDO DE UPDATE NA TABELA
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);//O VALOR ARMAZENADO EM "sql" É PASSADO PARA "pstm" PARA FAZER A CONEXÃO
			
			pstm.setInt(1, objfuncionariodto.getId_funcionario());//EXCLUI ATRAVES DO ID
			
			pstm.execute();//EXECUTAR A VÁRIVAEL
			pstm.close();//FECHAR A CONEXÃO
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null,"Excluir Funcionario "+ erro);
		}
		
		
	}
}
