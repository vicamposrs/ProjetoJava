
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
    	
    	Locale.setDefault(Locale.US);
        // -- Testes de Contas correntes e Poupança -- //
    	Cliente clienteA = new Cliente("João Silva", "11111111111111",new Date(10/10/1999),"aa");
    	Cliente clienteB = new Cliente("Maria Oliveira","23154679842563", new Date(12/9/2000),"Rua aaaa");
    	
    	
        Conta contaCorrente = new ContaCorrente(clienteA, 1000.0);
        Conta contaPoupanca = new ContaPoupanca(clienteB, 2000.0);

        System.out.println("Informações da Conta Corrente:");
        contaCorrente.exibirInformacoes();
        contaCorrente.depositar(200.0);
        contaCorrente.sacar(300.0);
        contaCorrente.exibirInformacoes();

        System.out.println("\nInformações da Conta Poupança:");
        contaPoupanca.exibirInformacoes();
        contaPoupanca.depositar(500.0);
        contaPoupanca.sacar(100.0);

        // Casting necessário para acessar método específico da ContaPoupanca
        ((ContaPoupanca) contaPoupanca).aplicarRendimentoMensal();
        contaPoupanca.exibirInformacoes();
        
        System.out.println();
        contaCorrente.exibirExtrato();
        
        System.out.println();
        contaPoupanca.exibirExtrato();
    }
}
