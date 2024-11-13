import java.util.Date;

public class Cliente {
	private String nome;
	private String cpf;
	private Date dataNasc;
	private String endereco;
	
	public Cliente(String nome, String cpf , Date dataNasc, String endereco) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setDataNasc(dataNasc);
		this.setEndereco(endereco); 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
