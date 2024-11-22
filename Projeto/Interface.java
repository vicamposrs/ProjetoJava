import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InterfaceATM {
	private Scanner sc;
	
	public InterfaceATM() {
		this.sc = new Scanner(System.in);
	}
	
	public static void exibirMensagem(String texto)
	{
		System.out.print(texto);
	}

	public String lerEntradaTexto() {
		// TODO Auto-generated method stub
		return sc.nextLine();
	}

	public int lerEntradaInteira() {
		while(true)
		{
			try {
				return Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {
				exibirMensagem("Entrada inválida, insira um valor válido: ");
			}
		}
	}

	public Double lerEntradaDouble() {
		while(true)
		{
			try {
				return Double.parseDouble(sc.nextLine());
			} catch(NumberFormatException e) {
				exibirMensagem("Entrada inválida, insira um valor válido: ");
			}
		}
	}

	public void fechar() {
		sc.close();
	}

	public Date lerEntradaData() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		formato.setLenient(false);
		
		while(true)
		{
			try {
				String entrada = sc.nextLine();
				return formato.parse(entrada);
			} catch(ParseException e) {
				exibirMensagem("Entrada inválida, insira a data no formato dd/MM/yyyy: ");
			}
		}
	}
	
	

}
