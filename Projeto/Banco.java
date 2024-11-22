import java.util.ArrayList;
import java.util.List;

public class Banco {
	private List<Conta> contas;
	private int contadorDeContas;
	
	
	public Banco() {
		this.contas = new ArrayList<>();
		contadorDeContas = 1;
	}
	
	public void adicionarConta(Conta conta)
	{
		contas.add(conta);
	}
	
	public Conta buscarConta(String numeroConta)
	{
		for(Conta conta : contas)
		{
			if(conta.getNumeroConta().equals(numeroConta))
			{
				return conta;
			}
		}
		return null;
	}
	
	public void listarContas() {
		InterfaceATM.exibirMensagem("\nLista de contas\n");
		for(Conta conta : contas)
		{
			InterfaceATM.exibirMensagem(conta.exibirInformacoes() + "\n");
		}
	}
	 public String gerarNumeroConta() {
	    	return String.format("%06d", contadorDeContas++);
	    }

}
