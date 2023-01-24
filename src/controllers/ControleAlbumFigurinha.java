package controllers;

import dao.AlbumDAO;
import model.*;

/**
 * Classe ControleAlbumFigurinha eh a classe onde se encontram todos os metodos para armazenar,
 * atualizar, ler e deletar os albuns e as figurinhas criadas.
 * @author Vinicius Eduardo Muniz da Silva
 * @since 2023
 */
public class ControleAlbumFigurinha {
	private Album[] albuns;
	private int qtd_albuns;
	
	public ControleAlbumFigurinha() {
		qtd_albuns = 0;
		
		albuns = new Album[10];	
	}
	
	public int getQtd_albuns(){
		carregaAlbum();
		return qtd_albuns;
	}
	
	/**
	 * O metodo getAlbum tem a funcao de resgatar o nome do album armazenado por meio de seu indice no vetor.
	 * Retornara entao uma String com o nome do album.
	 * @param i
	 * @return String
	 */
	public String getAlbum(int i){
		carregaAlbum();
		return albuns[i].getNome();
	}
	
	/**
	 * O metodo toString tem a funcao de retornar uma String contendo os atributos de uma determinada figurinha.
	 * @param album que esta presente aquela figurinha
	 * @param nome da figurinha
	 * @return String
	 */
	public String toString(Album album, String nome) {
		if(album.getTipo().equals("copa")) {
			AlbumDAO albumDao = new AlbumDAO();
			CopaDoMundoQatar fig = new CopaDoMundoQatar();
			fig.setNome(nome);
			for(CopaDoMundoQatar c : albumDao.getFigurinha(album, fig)) {
				if(c.getNome().equals(nome)) {
					fig.setRaridade(c.getRaridade());
					fig.setAltura(c.getAltura());
					fig.setNascimento(c.getNascimento());
					fig.setSelecao(c.getSelecao());
					fig.setPeso(c.getPeso());
				}

			}
			return "Nome: "+fig.getNome()+"\n\nRaridade: "+fig.getRaridade()+"\n\nAltura: "+fig.getAltura()+"\n\nNascimento: "
			+fig.getNascimento()+"\n\nSelecao: "+fig.getSelecao()+"\n\nPeso: "+fig.getPeso();
		} else if(album.getTipo().equals("pokemon")) {
			AlbumDAO albumDao = new AlbumDAO();
			Pokemon fig = new Pokemon();
			fig.setNome(nome);
			for(Pokemon c : albumDao.getFigurinha(album, fig)) {
				if(c.getNome().equals(nome)) {
					fig.setRaridade(c.getRaridade());
					fig.setTipo(c.getTipo());
				}

			}
			return "Nome: "+fig.getNome()+"\n\nRaridade: "+fig.getRaridade()+"\n\nTipo: "+fig.getTipo();
		} else if(album.getTipo().equals("yugioh")){
			AlbumDAO albumDao = new AlbumDAO();
			Yugioh fig = new Yugioh();
			fig.setNome(nome);
			for(Yugioh c : albumDao.getFigurinha(album, fig)) {
				if(c.getNome().equals(nome)) {
					fig.setRaridade(c.getRaridade());
					fig.setTipo(c.getTipo());
					fig.setAtk(c.getAtk());
					fig.setDef(c.getDef());
					fig.setNivel(c.getNivel());
				}

			}
			return "Nome: "+fig.getNome()+"\n\nRaridade: "+fig.getRaridade()+"\n\nTipo: "+fig.getTipo()+"\n\nATK: "
			+fig.getAtk()+"\n\nDEF: "+fig.getDef()+"\n\nNivel: "+fig.getNivel();
		} else {
			return "Nenhuma figurinha selecionada";
		}
	}
	
	/**
	 * O metodo carregaAlbum tem a funcao de resgatar os albuns armazenados no banco de dados
	 * e deixalos prontos para o uso. Esse metodo sera chamado automaticamente pelos outros
	 * metodos que dependem dele, ou seja, nao eh para uso do usuario.
	 */
	public void carregaAlbum(){
		//Armazenando no vetor os albuns ja presentes no banco de dados
		qtd_albuns = 0;
		AlbumDAO albumDao = new AlbumDAO();
		for(Album c: albumDao.getAlbum()) {
			albuns[qtd_albuns] = c;
			qtd_albuns++;
		}
	}
	
	/**
	 * O metodo confereNomeAlbum tem a funcao de conferir se ja existem um album armazenado na aplicacao.
	 * Retorna TRUE para um nome nao presente e FALSE para um nome presente.
	 * com o mesmo nome passado no parametro
	 * @param nome o nome que deseja conferir
	 * @return boolean
	 */
	public boolean confereNomeAlbum(String nome){
		carregaAlbum();
		boolean confere = true;
		for(int i = 0; i < qtd_albuns; i++) {
			if(albuns[i].getNome().equals(nome)) {
				confere = false;
			}
		}
		return confere;
	}
	
	/**
	 * O metodo resgataAlbum tem a funcao de resgatar os dados de um certo album a partir de seu nome.
	 * Retornara entao um objeto da classe Album com todos os seus dados.
	 * @param nome o nome do album que deseja resgatar
	 * @return Album
	 */
	public Album resgataAlbum(String nome){
		carregaAlbum();
		int i;
		for(i = 0; i < qtd_albuns; i++) {
			if(albuns[i].getNome().equals(nome)) {
				break;
			}
		}
		return albuns[i];
	}
	
	/**
	 * O metodo addAlbum tem a funcao de adicionar um novo album na aplicacao, levando em conta que o limite 
	 * de albuns armazenados eh 10. Retorna TRUE quando consegue armazenar um novo album e FALSE quando nao consegue.
	 * @param a que seria o album a ser adicionado
	 * @return boolean
	 */
	public boolean addAlbum(Album a) {
		carregaAlbum();
		if(qtd_albuns < 10 && confereNomeAlbum(a.getNome()) == true) {	
			albuns[qtd_albuns] = a;
			qtd_albuns++;
			//Salvando o album no banco de dados
			AlbumDAO albumDao = new AlbumDAO();
			albumDao.saveAlbum(a);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * O metodo attAlbum tem a funcao de atualizar as informacoes presentes em um album. Retorna TRUE caso
	 * tenha conseguido atualizar as informacoes e FALSE caso nao tenha conseguido.
	 * @param album com as novas informacoes
	 * @param nome antigo do album
	 * @return boolean
	 */
	public boolean attAlbum(Album album, String nome){
		carregaAlbum();
		int confere = 0;
		//Conferindo se o nome esta no array
		for(int i = 0; i < qtd_albuns; i++) {
			//Caso esteja, os dados antigos serao substituidos por novos
			if(albuns[i].getNome().equals(nome) == true) {
				albuns[i] = album;
				AlbumDAO albumDao = new AlbumDAO();
				albumDao.updateAlbum(album, nome);
				confere = 1;
				break;
			}
		}
		if(confere == 1) {
			return true; //Se tiver atualizado com sucesso o retorno do metodo sera true
		} else {
			return false;
		}
	}
	
	/**
	 * O metodo apagarAlbum tem a funcao de apagar um album da aplicacao. Retorna TRUE caso
	 * tenha conseguido apagar o album e FALSE caso nao tenha conseguido.
	 * @param album o qual deseja apagar
	 * @return boolean
	 */
	public boolean apagarAlbum(Album album) {
		carregaAlbum();
		int confere = 0;
		String nome = album.getNome();
		
		//Conferimos se o nome do album esta presente no array, caso esteja, confere recebera 1
		for(int i = 0; i < qtd_albuns; i++) {
			if(albuns[i].getNome().equals(nome) == true) {
				confere = 1;
			}
			if(confere == 1 && i != qtd_albuns-1) {
				albuns[i] = albuns[i+1];
			}
		}	
		
		//Caso confere seja 1, o album sera apagado do banco de dados e seu numero decrementado do array
		if(confere == 1) {
			qtd_albuns--;
			AlbumDAO albumDao = new AlbumDAO();
			albumDao.deleteAlbum(album);
			return true; //Deletado com sucesso
		} else {
			return false; //Album nao presente no array
		}
	}
	
	/**
	 * O metodo carregaFigurinha tem a funcao de resgatar as figurinhas que estao armazenadas no banco
	 * de dados e carregalas dentro do album passado como parametro. Parametro da classe CopaDoMundoQatar
	 * significa que as figurinhas a serem resgatadas sao do tipo "copa".
	 * @param album do qual deseja resgatar as figurinhas
	 * @param figurinha do tipo que deseja resgatar
	 */
	public void carregaFigurinha(Album album, CopaDoMundoQatar figurinha){
		AlbumDAO albumDao = new AlbumDAO();
		int qtd_fig = 0;
		for(CopaDoMundoQatar c: albumDao.getFigurinha(album, figurinha)) {
			album.setFigurinha(c);
			qtd_fig++;
		}
		album.setQtd_figurinha(qtd_fig);
	}
	
	/**
	 * O metodo carregaFigurinha tem a funcao de resgatar as figurinhas que estao armazenadas no banco
	 * de dados e carregalas dentro do album passado como parametro. Parametro da classe Pokemon
	 * significa que as figurinhas a serem resgatadas sao do tipo "pokemon".
	 * @param album do qual deseja resgatar as figurinhas
	 * @param figurinha do tipo que deseja resgatar
	 */
	public void carregaFigurinha(Album album, Pokemon figurinha){
		AlbumDAO albumDao = new AlbumDAO();
		int qtd_fig = 0;
		for(Pokemon c: albumDao.getFigurinha(album, figurinha)) {
			album.setFigurinha(c);
			qtd_fig++;
		}
		album.setQtd_figurinha(qtd_fig);
	}
	
	/**
	 * O metodo carregaFigurinha tem a funcao de resgatar as figurinhas que estao armazenadas no banco
	 * de dados e carregalas dentro do album passado como parametro. Parametro da classe Yugioh
	 * significa que as figurinhas a serem resgatadas sao do tipo "yugioh".
	 * @param album do qual deseja resgatar as figurinhas
	 * @param figurinha do tipo que deseja resgatar
	 */
	public void carregaFigurinha(Album album, Yugioh figurinha){
		AlbumDAO albumDao = new AlbumDAO();
		int qtd_fig = 0;
		for(Yugioh c: albumDao.getFigurinha(album, figurinha)) {
			album.setFigurinha(c);
			qtd_fig++;
		}
		album.setQtd_figurinha(qtd_fig);
	}

	/**
	 * O metodo addFigurinha tem a funcao de adicionar uma determinada figurinha ao album desejado.
	 * Retorna TRUE quando consegue adicionar e FALSE quando nao consegue.
	 * @param album o qual deseja adicionar a figurinha de seu tipo
	 * @param figurinha da clase CopaDoMundoQatar
	 * @return boolean
	 */
	public boolean addFigurinha(Album album, CopaDoMundoQatar figurinha) {
		AlbumDAO albumDao = new AlbumDAO();
		
		carregaFigurinha(album, figurinha);
		
		if(album.getQtd_figurinha() < album.getQtd_figurinha_total() && confereFigNome(album, figurinha.getNome()) == true) {	
			album.setFigurinha(figurinha);
			albumDao.saveFigurinha(album, figurinha);
			String name = album.getNome();
			albumDao.updateAlbum(album, name);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * O metodo addFigurinha tem a funcao de adicionar uma determinada figurinha ao album desejado.
	 * Retorna TRUE quando consegue adicionar e FALSE quando nao consegue.
	 * @param album o qual deseja adicionar a figurinha de seu tipo
	 * @param figurinha da clase Pokemon
	 * @return boolean
	 */
	public boolean addFigurinha(Album album, Pokemon figurinha) {
		AlbumDAO albumDao = new AlbumDAO();
		
		carregaFigurinha(album, figurinha);
		
		if(album.getQtd_figurinha() < album.getQtd_figurinha_total() && confereFigNome(album, figurinha.getNome()) == true) {	
			album.setFigurinha(figurinha);
			albumDao.saveFigurinha(album, figurinha);
			String name = album.getNome();
			albumDao.updateAlbum(album, name);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * O metodo addFigurinha tem a funcao de adicionar uma determinada figurinha ao album desejado.
	 * Retorna TRUE caso consega adicionar e FALSE caso nao consega.
	 * @param album o qual deseja adicionar a figurinha de seu tipo
	 * @param figurinha da clase Yugioh
	 * @return boolean
	 */
	public boolean addFigurinha(Album album, Yugioh figurinha) {
		AlbumDAO albumDao = new AlbumDAO();
		
		carregaFigurinha(album, figurinha);
		
		if(album.getQtd_figurinha() < album.getQtd_figurinha_total() && confereFigNome(album, figurinha.getNome()) == true) {	
			album.setFigurinha(figurinha);
			albumDao.saveFigurinha(album, figurinha);
			String name = album.getNome();
			albumDao.updateAlbum(album, name);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * O metodo attFigurinha tem a funcao de atualizar os dados de uma figurinha ja cadastrada em um
	 * determinado album. Retorna TRUE caso tenha conseguido atualizar a figurinha e FALSE caso nao
	 * tenha conseguido.
	 * @param album do qual a figurinha pertence
	 * @param figurinha da classe CopaDoMundoQatar com os novos dados
	 * @param nome da antiga figurinha
	 * @return boolean
	 */
	public boolean attFigurinha(Album album, CopaDoMundoQatar figurinha, String nome) {
		//Primeiramente eh necessario carregar as figurinhas nos vetores
		carregaFigurinha(album, figurinha);
		int confere = 0;
		AlbumDAO albumDao = new AlbumDAO();
		for(int i = 0; i < album.getQtd_figurinha(); i++) {
			if(album.getFigurinha(i).getNome().equals(nome) && confereFigNome(album, figurinha.getNome()) == true) {
				confere = 1;
			}
		}
		
		if(confere == 1) {
			albumDao.updateFigurinha(figurinha, nome);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * O metodo attFigurinha tem a funcao de atualizar os dados de uma figurinha ja cadastrada em um
	 * determinado album. Retorna TRUE caso tenha conseguido atualizar a figurinha e FALSE caso nao
	 * tenha conseguido.
	 * @param album do qual a figurinha pertence
	 * @param figurinha da classe Pokemon com os novos dados
	 * @param nome da antiga figurinha
	 * @return boolean
	 */
	public boolean attFigurinha(Album album, Pokemon figurinha, String nome) {
		//Primeiramente eh necessario carregar as figurinhas nos vetores
		carregaFigurinha(album, figurinha);
		int confere = 0;
		AlbumDAO albumDao = new AlbumDAO();
		for(int i = 0; i < album.getQtd_figurinha(); i++) {
			if(album.getFigurinha(i).getNome().equals(nome) && confereFigNome(album, figurinha.getNome()) == true) {
				confere = 1;
			}
		}
		
		if(confere == 1) {
			albumDao.updateFigurinha(figurinha, nome);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * O metodo attFigurinha tem a funcao de atualizar os dados de uma figurinha ja cadastrada em um
	 * determinado album. Retorna TRUE caso tenha conseguido atualizar a figurinha e FALSE caso nao
	 * tenha conseguido.
	 * @param album do qual a figurinha pertence
	 * @param figurinha da classe Yugioh com os novos dados
	 * @param nome da antiga figurinha
	 * @return boolean
	 */
	public boolean attFigurinha(Album album, Yugioh figurinha, String nome) {
		//Primeiramente eh necessario carregar as figurinhas nos vetores
		carregaFigurinha(album, figurinha);
		int confere = 0;
		AlbumDAO albumDao = new AlbumDAO();
		for(int i = 0; i < album.getQtd_figurinha(); i++) {
			if(album.getFigurinha(i).getNome().equals(nome) && confereFigNome(album, figurinha.getNome()) == true) {
				confere = 1;
			}
		}
		
		if(confere == 1) {
			albumDao.updateFigurinha(figurinha, nome);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * O metodo deletarFigurinha tem a funcao de deletar uma figurinha armazenada em determinado album.
	 * Retorna TRUE caso consiga deletar e FALSE caso nao consiga.
	 * @param album que armazena aquela figurinha
	 * @param figurinha da classe CopaDoMundoQatar que deseja deletar
	 * @return boolean
	 */
	public boolean deletarFigurinha(Album album, CopaDoMundoQatar figurinha) {
		//Carregando as figurinhas nos vetores
		carregaFigurinha(album, figurinha);
		
		int confere = 0;
		int qtd_fig = album.getQtd_figurinha();
		String name = album.getNome();
		//Conferindo se a figurinha esta presente na lista
		for(int i = 0; i < qtd_fig; i++) {
			if(album.getFigurinha(i).getNome().equals(figurinha.getNome())) {
				confere = 1;
			}
		}
		//se estiver a figurinha sera deletada
		if(confere == 1) {
			AlbumDAO albumDao = new AlbumDAO();
			albumDao.deleteFigurinha(album, figurinha);
			qtd_fig--;
			album.setQtd_figurinha(qtd_fig);
			//Atualizando a qtd de figurinhas no banco de dados
			albumDao.updateAlbum(album, name);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * O metodo deletarFigurinha tem a funcao de deletar uma figurinha armazenada em determinado album.
	 * Retorna TRUE caso consiga deletar e FALSE caso nao consiga.
	 * @param album que armazena aquela figurinha
	 * @param figurinha da classe Pokemon que deseja deletar
	 * @return boolean
	 */
	public boolean deletarFigurinha(Album album, Pokemon figurinha) {
		//Carregando as figurinhas nos vetores
		carregaFigurinha(album, figurinha);
		
		int confere = 0;
		int qtd_fig = album.getQtd_figurinha();
		String name = album.getNome();
		//Conferindo se a figurinha esta presente na lista
		for(int i = 0; i < qtd_fig; i++) {
			if(album.getFigurinha(i).getNome().equals(figurinha.getNome())) {
				confere = 1;
			}
		}
		//se estiver a figurinha sera deletada
		if(confere == 1) {
			AlbumDAO albumDao = new AlbumDAO();
			albumDao.deleteFigurinha(album, figurinha);
			qtd_fig--;
			album.setQtd_figurinha(qtd_fig);
			//Atualizando a qtd de figurinhas no banco de dados
			albumDao.updateAlbum(album, name);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * O metodo deletarFigurinha tem a funcao de deletar uma figurinha armazenada em determinado album.
	 * Retorna TRUE caso consiga deletar e FALSE caso nao consiga.
	 * @param album que armazena aquela figurinha
	 * @param figurinha da classe Yugioh que deseja deletar
	 * @return boolean
	 */
	public boolean deletarFigurinha(Album album, Yugioh figurinha) {
		//Carregando as figurinhas nos vetores
		carregaFigurinha(album, figurinha);
		
		int confere = 0;
		int qtd_fig = album.getQtd_figurinha();
		String name = album.getNome();
		//Conferindo se a figurinha esta presente na lista
		for(int i = 0; i < qtd_fig; i++) {
			if(album.getFigurinha(i).getNome().equals(figurinha.getNome())) {
				confere = 1;
			}
		}
		//se estiver a figurinha sera deletada
		if(confere == 1) {
			AlbumDAO albumDao = new AlbumDAO();
			albumDao.deleteFigurinha(album, figurinha);
			qtd_fig--;
			album.setQtd_figurinha(qtd_fig);
			//Atualizando a qtd de figurinhas no banco de dados
			albumDao.updateAlbum(album, name);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * O metodo listarFigurinhas tem a funcao de retornar o nome das figurinhas presentes em 
	 * um determinado album. Retorna o nome da figurinha correspondente ao indice do vetor.
	 * @param album que armazena as figurinhas
	 * @param i que eh o indice de acesso a figurinha
	 * @return String
	 */
	public String listarFigurinhas(Album album, int i) {
		//Dependendo do tipo do album uma classe sera criada para auxiliar na listagem das figurinhas
		if(album.getTipo().equals("copa")) {
			CopaDoMundoQatar figurinha = new CopaDoMundoQatar();
			carregaFigurinha(album, figurinha);
			return album.getFigurinha(i).getNome();
		} else if(album.getTipo().equals("pokemon")) {
			Pokemon figurinha = new Pokemon();
			carregaFigurinha(album, figurinha);
			return album.getFigurinha(i).getNome();
		} else if(album.getTipo().equals("yugioh")) {
			Yugioh figurinha = new Yugioh();
			carregaFigurinha(album, figurinha);
			return album.getFigurinha(i).getNome();
		}
		return "Nao ha figurinhas para esse album";
	}
	
	/**
	 * O metodo confereFigNome tem a funcao de conferir se uma figurinha com um determinado nome
	 * esta presente em determinado album. Retorna TRUE caso nao esteja presente e FALSE caso esteja.
	 * @param album que contem a figurinha
	 * @param nome da figurinha
	 * @return boolean
	 */
	public boolean confereFigNome(Album album, String nome){
		int qtd = album.getQtd_figurinha();
		boolean confere = true;
		album.setQtd_figurinha(0);
		for(int i = 0; i < qtd; i++) {
			if(nome.equals(listarFigurinhas(album, i))) {
				confere = false;
			}
		}
		return confere;
	}
}
