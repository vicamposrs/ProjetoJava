class ContaPoupanca extends Conta {
    // Atributos
    private double taxaDeRendimento = 0.005; // Rendimento de 0.5% por mês

    // Construtor
    public ContaPoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    // Métodos
    public void aplicarRendimentoMensal() {
        double rendimento = getSaldo() * taxaDeRendimento;
        setSaldo(getSaldo() + rendimento);
        System.out.println("Rendimento de R$ " + rendimento + " aplicado.");
    }

    @Override
    public void sacar(double valor) {
        if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
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
