package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.FuncionarioDAO;//IMPORTAÇÃO DA CLASSE DENTRO DO PACOTE DAO
import DTO.FuncionarioDTO;//IMPORTAÇÃO DA CLASSE DENTRO DO PACOTE DTO

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;

public class frmFuncionarioVIEW extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTable table;
	private JTable tabelaFuncionario;
	private JTextField txtCodigo;
	private JButton btnAlterar;
	private JButton btnDeletar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFuncionarioVIEW frame = new frmFuncionarioVIEW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmFuncionarioVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//CÓDIGO TXT
				JLabel lblNewLabel = new JLabel("Código");
				lblNewLabel.setBounds(34, 11, 62, 14);
				contentPane.add(lblNewLabel);
				
				txtCodigo = new JTextField();
				txtCodigo.setEnabled(false);
				txtCodigo.setBounds(34, 32, 132, 20);
				contentPane.add(txtCodigo);
				txtCodigo.setColumns(10);
		//NOME TXT		
				JLabel lblNewLabel_1 = new JLabel("Nome");
				lblNewLabel_1.setBounds(37, 59, 62, 17);
				contentPane.add(lblNewLabel_1);
		
				txtNome = new JTextField();
				txtNome.setBounds(37, 74, 129, 20);
				contentPane.add(txtNome);
				txtNome.setColumns(10);
		//ENDEREÇO TXT		
				JLabel lblNewLabel_2 = new JLabel("Endereço");
				lblNewLabel_2.setBounds(37, 101, 83, 14);
				contentPane.add(lblNewLabel_2);
		
				txtEndereco = new JTextField();
				txtEndereco.setBounds(37, 117, 129, 20);
				contentPane.add(txtEndereco);
				txtEndereco.setColumns(10);
		
		//BOTÕES---------------		
				
		//BOTÃO CADASTRAR
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBounds(257, 31, 111, 23);
		btnCadastrar.addActionListener(new ActionListener() {//FUNÇÃO DE AÇÃO DO BOTÃO
		public void actionPerformed(ActionEvent e) {
			cadastrarFuncionario();
		}
		});
		contentPane.add(btnCadastrar);
		table = new JTable();
		table.setBounds(398, 21, 0, 0);
		contentPane.add(table);
		
		//BOTÃO PESQUISAR
		JButton btnPesquisar = new JButton("ATUALIZAR");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabela();
			}
		});
		btnPesquisar.setBounds(257, 73, 111, 23);
		contentPane.add(btnPesquisar);
	
		
		//BOTÃO CARREGAR
		JButton btnCarregar = new JButton("CARREGAR");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarFuncionarios();
			}
		});
		btnCarregar.setBounds(257, 116, 111, 23);
		contentPane.add(btnCarregar);
		
		//BOTÃO ALTERAR
		btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarFuncionario();
				atualizarTabela();
			}
		});
		btnAlterar.setBounds(257, 155, 111, 23);
		contentPane.add(btnAlterar);
		
		//BOTÃO DELETAR
		btnDeletar = new JButton("DELETAR");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFuncionario();
				atualizarTabela();
				limparCampos();
			}
		});
		btnDeletar.setBounds(257, 198, 111, 23);
		contentPane.add(btnDeletar);
		
		//TABELA
		tabelaFuncionario = new JTable();
		tabelaFuncionario.setBackground(new Color(192, 192, 192));
		tabelaFuncionario.setBounds(37, 159, 194, 139);
		contentPane.add(tabelaFuncionario);
		
		
		

		
	}
	
	//FUNÇÕES------------
	
	//FUNÇÃO DE CADASTRAR
			private void cadastrarFuncionario() {
				String nome, endereco;//CRIAÇÃO DE DUAS VARIÁVEIS DO TIPO STRING
			
				nome = txtNome.getText();//PASSA O VALOR ESCRITO NA CAIXA "txtNome" PARA A VÁRIAVEL "nome";
				endereco = txtEndereco.getText();//PASSA O VALOR ESCRITO NA CAIXA "txtEndereco" PARA A VÁRIAVEL "endereco";
			
				FuncionarioDTO objfuncionariodto = new FuncionarioDTO();//CRIAÇÃO DA INSTÂNCIA
				objfuncionariodto.setNome_funcionario(nome);//SETANDO DENTRO DO METODO "setNome_funcionario" QUE ESTA NA OUTRA CLASSE, O VALOR OBTIDO EM "nome"
				objfuncionariodto.setEndereco_funcionario(endereco);//SETANDO DENTRO DO METODO "setEndereco_funcionario" QUE ESTA NA OUTRA CLASSE, O VALOR OBTIDO EM "endereco"
			
			
				FuncionarioDAO objfuncionariodao = new FuncionarioDAO();//CRIAÇÃO DA INSTÂNCIA
				objfuncionariodao.cadastrarFuncionario(objfuncionariodto);//EXECUTA O MÉTODO DENTRO DE "FuncionarioDAO"
				atualizarTabela();//EXIBIR A TABELA APÓS CADASTRAR
				limparCampos();//LIMPAR A TABELA APÓS CADASTRAR
			}
	
	
	//FUNÇÃO DE ATUALIZAR
		private void atualizarTabela(){
			try {
				FuncionarioDAO objfuncionariodao = new FuncionarioDAO();//INSTÂNCIA 
				DefaultTableModel model = (DefaultTableModel) tabelaFuncionario.getModel();//UTILIZANDO O DTM ATRAVÉS DA TABELA CRIADA NO JFRAME
				model.setColumnIdentifiers(new Object[] {"ID", "Nome", "Endereço"});
				model.setNumRows(0);
			
				ArrayList<FuncionarioDTO> lista = objfuncionariodao.ListarFuncionario();
			
				for(int num = 0;num < lista.size();num++){//CRIAÇÃO DE LOOPING PARA EXIBIR A QUANTIDADE DE LINHAS DENTRO DA TABELA
					model.addRow(new Object[] {
						lista.get(num).getId_funcionario(),//TRAZENDO O VALOR ARMAZENADO NO FuncionarioDTO
						lista.get(num).getNome_funcionario(),//TRAZENDO O VALOR ARMAZENADO NO FuncionarioDTO
						lista.get(num).getEndereco_funcionario()//TRAZENDO O VALOR ARMAZENADO NO FuncionarioDTO
					});
				}
			}
			catch(Exception erro){
				JOptionPane.showMessageDialog(null,"Listar Funcionarios" + erro);
			}
		}
	
	//FUNÇÃO DE CARREGAR
		private void carregarFuncionarios() {
			int setar = tabelaFuncionario.getSelectedRow();//SELECIONA A LINHA A SER CARREGADA
			txtCodigo.setText(tabelaFuncionario.getModel().getValueAt(setar, 0).toString());//PEGA O VALOR DA TABELA NA LINHA E COLUNA
			txtNome.setText(tabelaFuncionario.getModel().getValueAt(setar, 1).toString());//O "setar" SELECIONA SEMPRE A LINHA QUE O USUARIO SELECIONAR 
			txtEndereco.setText(tabelaFuncionario.getModel().getValueAt(setar, 2).toString());
		}
	
	//FUNÇÃO DE ALTERAR 	
		private void alterarFuncionario() {
			int id_funcionario;
			String nome_funcionario;
			String endereco_funcionario;
			FuncionarioDTO objfuncionariodto = new FuncionarioDTO();//INSTÂNCIA
			
			id_funcionario = Integer.parseInt(txtCodigo.getText());//CONVERTE O VALOR PARA INTEIRO E ASSIM SER ARMAZENADO
			nome_funcionario = txtNome.getText();//RECEBENDO O VALOR DAS VARIAVEIS
			endereco_funcionario = txtEndereco.getText();//RECEBENDO O VALOR DAS VARIAVEIS
			
			objfuncionariodto.setId_funcionario(id_funcionario);//SETANDO VALORES NO DTO
			objfuncionariodto.setNome_funcionario(nome_funcionario);
			objfuncionariodto.setEndereco_funcionario(endereco_funcionario);
			
			FuncionarioDAO objfuncionariodao = new FuncionarioDAO();//INSTÂNCIA
			objfuncionariodao.alterarFuncionario(objfuncionariodto);
		}
		
	//FUNÇÃO PRA EXCLUIR
		private void excluirFuncionario() {
			int id_funcionario;
			id_funcionario = Integer.parseInt(txtCodigo.getText());//CONVERTE O VALOR PARA INTEIRO E ASSIM SER ARMAZENADO

			FuncionarioDTO objfuncionariodto = new FuncionarioDTO();//INSTÂNCIA
			objfuncionariodto.setId_funcionario(id_funcionario);//SETANDO VALORES NO DTO
			
			FuncionarioDAO objfuncionariodao = new FuncionarioDAO();//INSTÂNCIA
			objfuncionariodao.alterarFuncionario(objfuncionariodto);
		}
	
	//FUNÇÃO PRA LIMPAR APÓS CADASTRAR
		private void limparCampos() {
		txtCodigo.setText("");
		txtNome.setText("");
		txtEndereco.setText("");
		txtNome.requestFocus();
		}
}
