import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    // Atributos
    protected Cliente titular; // Criar uma classe cliente que será o Titular
    private double saldo;
    protected List<Transacao> extrato;
    
    

    // Construtor
    public Conta(Cliente titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.extrato = new ArrayList<>();
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
    
    public void exibirExtrato()
    {
    	System.out.println("Extrato:");
    	for(Transacao t : extrato)
    	{
    		System.out.println(t.exibirDetalhes());
    	}
    	System.out.printf("Saldo: %.2f",saldo);
    }
}
