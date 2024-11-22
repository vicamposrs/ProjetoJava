import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
    	
    	Locale.setDefault(Locale.US);
    	Banco banco = new Banco();
    	InterfaceATM interfac = new InterfaceATM();
    	SistemaCaixaEletronico sistema = new SistemaCaixaEletronico(banco,interfac);
    	
    	boolean cont = true;
    	while(cont) {
    		String menuPrincipal = """
    				Menu Principal
    				1. Criar Conta
    				2. Acessar Conta
    				3. Exibir Todas Contas
    				0. Sair
    				
    				Escolhauma opção: """;
    		
    		InterfaceATM.exibirMensagem(menuPrincipal);
    		
    		int opcao = interfac.lerEntradaInteira();
    		switch(opcao)
    		{
    		case 1: criarConta(banco,interfac); break;
    		case 2: sistema.iniciarCaixaEletronico(); break;
    		case 3: banco.listarContas(); break;
    		case 0: 
    			InterfaceATM.exibirMensagem("\nFechando o sistema");
    			interfac.fechar();
    			cont = false;
    		}
    	}
    }
    
    public static void criarConta(Banco banco,InterfaceATM interfac)
    {
    	InterfaceATM.exibirMensagem("\nDigite o nome do cliente: ");
    	String nome = interfac.lerEntradaTexto();
    	
    	InterfaceATM.exibirMensagem("\nDigite o cpf: ");
    	String cpf = interfac.lerEntradaTexto();
    	
    	InterfaceATM.exibirMensagem("\nDigite a data de nascimento: ");
    	Date dataNasc = interfac.lerEntradaData();
    	
    	InterfaceATM.exibirMensagem("\nDigite o endereço: ");
    	String endereco = interfac.lerEntradaTexto();
    	
    	int tipo = 0;
    	while(tipo != 1 && tipo != 2) {
    		InterfaceATM.exibirMensagem("\nEscolha o tipo de conta(1: Corrente,2: Poupanca): ");
    		tipo = interfac.lerEntradaInteira();
    	}
    	
    	InterfaceATM.exibirMensagem("\nDigite a senha: ");
    	String senha = interfac.lerEntradaTexto();
    	
    	InterfaceATM.exibirMensagem("\nSaldo inicial: ");
    	double saldoInicial = interfac.lerEntradaDouble();
    	
    	Cliente cliente = new Cliente(nome,cpf,dataNasc,endereco);
    	Conta novaConta = null;
    	
    	if(tipo == 1) {
    		novaConta = new ContaCorrente(cliente,banco.gerarNumeroConta(),saldoInicial,senha);
    	}else if(tipo == 2) {
    		novaConta = new ContaPoupanca(cliente,banco.gerarNumeroConta(),saldoInicial,senha);
    	}else {
    		InterfaceATM.exibirMensagem("\nTipo de conta inválido");
    	}
    	
    	banco.adicionarConta(novaConta);
    	InterfaceATM.exibirMensagem("\nConta criada. nº da conta:" + novaConta.getNumeroConta() + "\n\n");
    }
    

}
