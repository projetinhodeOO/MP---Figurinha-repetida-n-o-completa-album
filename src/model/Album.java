package model;

public class Album {
	private String nome;
	private int ano;
	private int qtd_figurinha;
	private int qtd_figurinha_total;
	private Figurinha[] figurinha;
	
	public Album() {
		qtd_figurinha = 0;
		figurinha = new Figurinha[600];
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	public String getFigurinha(int i) {
		return figurinha[i].toString();
	}
	
	public int getQtd_figurinha_total() {
		return qtd_figurinha_total;
	}

	public void setQtd_figurinha_total(int qtd_figurinha_total) {
		this.qtd_figurinha_total = qtd_figurinha_total;
	}
	
	public boolean addFigurinha(Figurinha f) {
		if(qtd_figurinha < qtd_figurinha_total) {	
			figurinha[qtd_figurinha] = f;
			qtd_figurinha++;
			return true;
		} else {
			return false;
		}
	}
	
	public void removerFigurinha(String nome) {
		int confere = 0;
		
		for(int i = 0; i < qtd_figurinha; i++) {
			if(figurinha[i].getNome() == nome) {
				confere = 1;
			}
			if(confere == 1 && i != qtd_figurinha-1) {
				figurinha[i] = figurinha[i+1];
			}
		}
		if(confere == 0) {
			
		} else {
			qtd_figurinha--;
		}
	}
	
	public String listarFigurinhas() {
		if(qtd_figurinha == 0) {
			return "Não há figurinhas cadastradas nesse album";
		} else {
			String lista = figurinha[0].getNome();
			for(int i = 1; i < qtd_figurinha; i++) {
				lista = lista + "\n" + figurinha[i].getNome();
			}
		
			return "Figurinhas:\n" + lista;
		}
	}
	
	public String toString() {
		return "Nome do album: " + nome + "\nAno de publicação: " + ano + "\nQuantidade de figurinhas: " + qtd_figurinha + " do total de " + qtd_figurinha_total;
	}
	
}
