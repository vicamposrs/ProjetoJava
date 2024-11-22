import java.util.ArrayList;
import java.util.List;


public abstract class Conta {
    // Atributos
    protected Cliente titular; // Criar uma classe cliente que será o Titular
    private String numeroConta;
    private double saldo;
    private String senha;
    protected List<Transacao> extrato;
    
    

    // Construtor
    public Conta(Cliente titular,String numeroConta, double saldoInicial,String senha) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.senha = senha;
        this.extrato = new ArrayList<>();
        
        if(saldo > 0) extrato.add(new Transacao(TipoTransacao.DEPOSITO,saldoInicial,this));
    }

    // Getters e Setters 
    public Cliente getTitular() {
        return titular;
    }
    
    public String getNumeroConta()
    {
    	return numeroConta;
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
    
    	
  

    public String exibirInformacoes() {
        return "nº:" + numeroConta + " Cliente: " + titular.getNome() + " Saldo: R$%.2f".formatted(saldo);
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

	public boolean verificarSenha(String senha) {
		if(this.senha.equals(senha)) return true;
		else return false;
	}

	public void transferir(Double valor, Conta contaDestino) {
		if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo()+valor);
            InterfaceATM.exibirMensagem("Transferencia de R$ " + valor + " realizado com sucesso!\n");
            extrato.add(new Transacao(TipoTransacao.TRANSFERENCIA_ORIGEM,valor,this,contaDestino));
            contaDestino.extrato.add(new Transacao(TipoTransacao.TRANSFERENCIA_DESTINO,valor,this,contaDestino));
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
		
	}
}
