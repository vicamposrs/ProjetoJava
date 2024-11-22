

public class ContaPoupanca extends Conta {
    // Atributos
    private double taxaDeRendimento = 0.005; // Rendimento de 0.5% por mês

    // Construtor
    public ContaPoupanca(Cliente titular,String numeroConta, double saldoInicial,String senha) {
        super(titular, numeroConta,saldoInicial,senha);
    }

    // Métodos
    public void aplicarRendimentoMensal() {
        double rendimento = getSaldo() * taxaDeRendimento;
        setSaldo(getSaldo() + rendimento);
        System.out.println("Rendimento de R$ " + rendimento + " aplicado.");
        extrato.add(new Transacao(TipoTransacao.RENDIMENTO,rendimento,this));
    }

    @Override
    public void sacar(double valor) {
        if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
            extrato.add(new Transacao(TipoTransacao.SAQUE_POUPANCA,valor,this));
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void depositar(double valor) {
        setSaldo(getSaldo() + valor);
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        extrato.add(new Transacao(TipoTransacao.DEPOSITO,valor,this));
    }
}
