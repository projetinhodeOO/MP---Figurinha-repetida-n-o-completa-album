package model;

/**
 * Classe Album nada mais eh do que um album de figurinhas. Ela armazena um nome, 
 * um tipo (podendo ser 3: copa, pokemon, yugioh), um ano de publicacao no modelo
 * XX/XX/XXXX, quantidade de figurinhas armazenadas, quantidade total de figurinhas
 * e as figurinhas em si.
 * @author Vinicius Eduardo Muniz da Silva
 * @since 2023
 */
public class Album {
	private String nome;
	private String tipo;
	private int ano;
	private int qtd_figurinha;
	private int qtd_figurinha_total;
	private Figurinha[] figurinha;
	
	public Album() {
		qtd_figurinha = 0;
		figurinha = new Figurinha[900];
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getQtd_figurinha() {
		return qtd_figurinha;
	}

	public void setQtd_figurinha(int qtd_figurinha) {
		this.qtd_figurinha = qtd_figurinha;
	}
	
	public Figurinha getFigurinha(int i) {
		return figurinha[i];
	}
	
	public void setFigurinha(Figurinha figurinha) {
		if(qtd_figurinha < qtd_figurinha_total) {
			this.figurinha[qtd_figurinha] = figurinha;
			this.qtd_figurinha++;
		} 
	}
	
	public int getQtd_figurinha_total() {
		return qtd_figurinha_total;
	}

	public void setQtd_figurinha_total(int qtd_figurinha_total) {
		this.qtd_figurinha_total = qtd_figurinha_total;
	}
	
	public String toString() {
		return "Nome do album: " + nome + "\nAno de publicação: " + ano + "\nQuantidade de figurinhas: " + qtd_figurinha + " do total de " + qtd_figurinha_total;
	}
	
}
