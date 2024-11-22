public class SistemaCaixaEletronico {
	private Banco banco;
	private InterfaceATM interfac;
	
	public SistemaCaixaEletronico(Banco banco,InterfaceATM interfac) {
		this.banco = banco;
		this.interfac = interfac;
	}
	
	public void iniciarCaixaEletronico() {
		InterfaceATM.exibirMensagem("Número da conta: ");
		String numeroConta = interfac.lerEntradaTexto();
		
		InterfaceATM.exibirMensagem("Digite sua senha: ");
		String senha= interfac.lerEntradaTexto();
		
		Conta conta = banco.buscarConta(numeroConta);
		
		if(conta != null && conta.verificarSenha(senha))
		{
			InterfaceATM.exibirMensagem("\nLogin realizado com sucesso!");
			menuConta(conta);
		}
		else
		{
			InterfaceATM.exibirMensagem("\nNúmero da conra ou senha incorretos.");
		}
	}
	
	public void menuConta(Conta conta) {
		boolean cont = true;
		while(cont) {
			String menu = """
					\nMenu da Conta
					nº:%s Titular: %s
					Saldo: R$%.2f
					1. Depositar
					2. Sacar
					3. Transferir
					4. Ver Extrato
					""".formatted(conta.getNumeroConta(),conta.getTitular().getNome(),conta.getSaldo());
			
			
			if(conta instanceof ContaPoupanca)
			{
				menu += "5. Aplicar Rendimento mensal"; 
			}
			menu += "\n0. Sair\nDigite ama opção: ";
			
			InterfaceATM.exibirMensagem(menu);
			
			int opcao = interfac.lerEntradaInteira();
			
			switch(opcao) {
			case 1: realizarDeposito(conta); break;
			case 2: realizarSaque(conta); break;
			case 3: realizarTransferencia(conta); break;
			case 4: conta.exibirExtrato(); break;
			case 5:
				if(conta instanceof ContaPoupanca)
				{
					realizarAplicacao((ContaPoupanca) conta);
				}
				break;
			case 0: 
				InterfaceATM.exibirMensagem("\nSaindo...\n"); 
				cont = false;
			default: InterfaceATM.exibirMensagem("\nOpção inválida\n");
			}
		}
	}
	
	private void realizarDeposito(Conta conta) {
		InterfaceATM.exibirMensagem("\nDEPÓSITO");
		InterfaceATM.exibirMensagem("\nValor do depósito: ");
		Double valor = interfac.lerEntradaDouble();
		conta.depositar(valor);
	}

	private void realizarSaque(Conta conta) {
		InterfaceATM.exibirMensagem("\nSAQUE");
		InterfaceATM.exibirMensagem("\nValor do saque: ");
		Double valor = interfac.lerEntradaDouble();
		conta.sacar(valor);
	}
	
	private void realizarTransferencia(Conta contaOrigem)
	{
		InterfaceATM.exibirMensagem("\nNúmero da conta destino: ");
		String numeroContaDestino = interfac.lerEntradaTexto();
		Conta contaDestino = banco.buscarConta(numeroContaDestino);
		
		if(contaDestino !=null)
		{
			InterfaceATM.exibirMensagem("\nValor da transderência: ");
			Double valor = interfac.lerEntradaDouble();
			contaOrigem.transferir(valor,contaDestino);
		}
		else
		{
			InterfaceATM.exibirMensagem("\nConta de destino não encontrada");
		}
	}
	
	private void realizarAplicacao(ContaPoupanca conta) {
		conta.aplicarRendimentoMensal();
	}
}
