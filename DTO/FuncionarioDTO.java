package DTO;
//ENCAPSULAMENTO
public class FuncionarioDTO {//NESSA CLASSE IREI USAR OS ATRIBUTOS PRIVADOS E OS MÉTODOS ACESSORES
	
	private String nome_funcionario, endereco_funcionario;
	private int id_funcionario;//REPRESENTA A PRIMARY KEY LA DO BANCO DE DADOS
	//GET E SET DE NOME DO FUNCIONARIO
	public String getNome_funcionario() {//GET PARA RETORNAR O VALOR DA VARIÁVEL
		return nome_funcionario;
	}
	
	public void setNome_funcionario(String nome_funcionario) {//SET PARA RECEBER O VALOR E ATRIBUIR NA VARIÁVEL
		this.nome_funcionario = nome_funcionario;//"this.nome_funcionario" É UMA VARIÁVEL LOCAL E RECEBE O VALOR DÁ VARIÁVEL ARMAZENADA NO VIEW
	}
	

	//--------------------------------------------------------------//
	
	//GET E SET DE ENDEREÇO DO FUNCIONARIO
	public String getEndereco_funcionario() {//GET PARA RETORNAR O VALOR DA VARIÁVEL
		return endereco_funcionario;
	}
	
	public void setEndereco_funcionario(String endereco_funcionario) {//SET PARA RECEBER O VALOR E ATRIBUIR NA VARIÁVEL
		this.endereco_funcionario = endereco_funcionario;
	}

	public int getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	
}
