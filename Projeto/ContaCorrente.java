public class ContaCorrente extends Conta {
    // Atributos
    private double taxaDeOperacao = 1.50; // Taxa fixa para sacar

    // Construtor
    public ContaCorrente(Cliente titular,String numeroConta, double saldoInicial,String senha) {
        super(titular, numeroConta,saldoInicial,senha);
    }

    // Métodos
    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor + taxaDeOperacao;
        if (getSaldo() >= valorComTaxa) {
            setSaldo(getSaldo() - valorComTaxa);
            System.out.println("Saque de R$ " + valor + " realizado com sucesso! Taxa: R$ " + taxaDeOperacao);
            extrato.add(new Transacao(TipoTransacao.SAQUE_CORRENTE,valor,this));
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


    public double getTaxa()
    {
    	return taxaDeOperacao;
    }
}
