abstract class Conta {
    // Atributos
    private Cliente titular; // Criar uma classe cliente que será o Titular
    private double saldo;

    // Construtor
    public Conta(Cliente titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Getters e Setters 
    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Métodos
    public abstract void sacar(double valor);
    public abstract void depositar(double valor);

    public void exibirInformacoes() {
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Saldo: " + saldo);
    }
}
