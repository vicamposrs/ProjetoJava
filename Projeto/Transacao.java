
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
	private TipoTransacao tipo;
	private Double valor;
	private LocalDateTime dataHora;
	private Conta contaOrigem;
	private Conta contaDestino;
	
	public Transacao(TipoTransacao tipo,Double valor,Conta origem)
	{
		this.tipo = tipo;
		this.valor = valor;
		this.dataHora = LocalDateTime.now();
		this.contaOrigem = origem;
		this.contaDestino = null;
	}
	
	public Transacao(TipoTransacao tipo,Double valor,Conta origem, Conta destino)
	{
		this.tipo = tipo;
		this.valor = valor;
		this.dataHora = LocalDateTime.now();
		this.contaOrigem = origem;
		this.contaDestino = destino;
	}
	
	public String exibirDetalhes()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = dataHora.format(formatter);
		
		switch(tipo)
		{
		case DEPOSITO:
			return dataFormatada + " - " + contaOrigem.getTitular().getNome() + " depositou R$%.2f".formatted(valor);
		case SAQUE:
			return dataFormatada + " - " + contaOrigem.getTitular().getNome() + " sacou R$%.2f".formatted(valor);
		case TRANSFERENCIA_ORIGEM:
			return dataFormatada + " - " + contaOrigem.getTitular().getNome() + " transferiu R$%.2f".formatted(valor) + " para " + contaDestino.getTitular().getNome() ;
		case TRANSFERENCIA_DESTINO:
			return dataFormatada + " - " + contaDestino.getTitular().getNome() + " recebeu R$%.2f".formatted(valor) + " para " + contaOrigem.getTitular().getNome() ;
		case RENDIMENTO:
			return dataFormatada + " - " + "Rendimento de R$%.2f".formatted(valor) + " aplicado";
		default:
			return "Transação desconhecida.";
			
		}
	}
	
}
