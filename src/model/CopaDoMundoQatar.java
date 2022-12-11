package model;

public class CopaDoMundoQatar extends Figurinha {
	private double altura;
	private String nascimento;
	private String selecao;
	private double peso;

	public CopaDoMundoQatar(String nome, String raridade, double altura, String nascimento, String selecao, double peso) {
		super(nome, raridade);
		this.altura = altura;
		this.nascimento = nascimento;
		this.selecao = selecao;
		this.peso = peso;
	}

	public CopaDoMundoQatar() {
		super();
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getSelecao() {
		return selecao;
	}

	public void setSelecao(String selecao) {
		this.selecao = selecao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	public String toString() {
		return "Nome: " + nome + "\nSeleção: " + selecao + "\nNascimento: " + nascimento + "\nPeso: " + peso + "\nAltura: " + altura + "\nRaridade: " + raridade;
	}

}
