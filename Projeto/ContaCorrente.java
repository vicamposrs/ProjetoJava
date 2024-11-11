class ContaCorrente extends Conta {
    // Atributos
    private double taxaDeOperacao = 1.50; // Taxa fixa para sacar

    // Construtor
    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    // Métodos
    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor + taxaDeOperacao;
        if (getSaldo() >= valorComTaxa) {
            setSaldo(getSaldo() - valorComTaxa);
            System.out.println("Saque de R$ " + valor + " realizado com sucesso! Taxa: R$ " + taxaDeOperacao);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void depositar(double valor) {
        setSaldo(getSaldo() + valor);
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
    }
}