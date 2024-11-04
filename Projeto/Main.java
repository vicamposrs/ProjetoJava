public class Main {
    public static void main(String[] args) {
        // -- Testes de Contas correntes e Poupança -- //

        Conta contaCorrente = new ContaCorrente("João Silva", 1000.0);
        Conta contaPoupanca = new ContaPoupanca("Maria Oliveira", 2000.0);

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
    }
}
