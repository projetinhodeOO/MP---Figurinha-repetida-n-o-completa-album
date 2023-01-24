package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Album;
import model.CopaDoMundoQatar;
import model.Pokemon;
import model.Yugioh;
import sql.factory.ConnectionFactory;

public class AlbumDAO {
	//Metodo para add figurinhas da copa
	public void saveFigurinha(Album album, CopaDoMundoQatar figurinha) {
		String sql = "INSERT INTO figurinha_copa(nome_album, nome, raridade, altura, nascimento, selecao, peso) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			//Criando uma coneccao com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			//PrepareStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionando valores esperados pela query
			pstm.setString(1, album.getNome());
			pstm.setString(2, figurinha.getNome());
			pstm.setString(3, figurinha.getRaridade());
			pstm.setDouble(4, figurinha.getAltura());
			pstm.setString(5, figurinha.getNascimento());
			pstm.setString(6, figurinha.getSelecao());
			pstm.setDouble(7, figurinha.getPeso());
			
			//Executando a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Fechando as coneccoes
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
	}
	
	//Metodo para add figurinhas de Pokemon
	public void saveFigurinha(Album album, Pokemon figurinha) {
		String sql = "INSERT INTO figurinha_pokemon(nome_album, nome, raridade, tipo) VALUES (?, ?, ?, ?)";
			
		Connection conn = null;
			
		PreparedStatement pstm = null;
			
		try {
			//Criando uma coneccao com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			//PrepareStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionando valores esperados pela query
			pstm.setString(1, album.getNome());
			pstm.setString(2, figurinha.getNome());
			pstm.setString(3, figurinha.getRaridade());
			pstm.setString(4, figurinha.getTipo());
				
			//Executando a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Fechando as coneccoes
			try {
				if(pstm != null) {
					pstm.close();
				}
					
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	//Metodo para add figurinhas de Yu-Gi-Oh!
	public void saveFigurinha(Album album, Yugioh figurinha) {
		String sql = "INSERT INTO figurinha_yugioh(nome_album, nome, raridade, tipo, atk, def, nivel) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
		Connection conn = null;
			
		PreparedStatement pstm = null;
			
		try {
			//Criando uma coneccao com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			//PrepareStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionando valores esperados pela query
			pstm.setString(1, album.getNome());
			pstm.setString(2, figurinha.getNome());
			pstm.setString(3, figurinha.getRaridade());
			pstm.setString(4, figurinha.getTipo());
			pstm.setInt(5, figurinha.getAtk());
			pstm.setInt(6, figurinha.getDef());
			pstm.setInt(7, figurinha.getNivel());
				
			//Executando a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Fechando as coneccoes
			try {
				if(pstm != null) {
					pstm.close();
				}
					
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
	}

	//Metodo para atualizar figurinha da Copa
	public void updateFigurinha(CopaDoMundoQatar figurinha, String nome) {
		String sql = "UPDATE figurinha_copa SET nome = ?, raridade = ?, altura = ?, nascimento = ?, selecao = ?, peso = ?" + "WHERE nome = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setString(1, figurinha.getNome());
			pstm.setString(2, figurinha.getRaridade());
			pstm.setDouble(3, figurinha.getAltura());
			pstm.setString(4, figurinha.getNascimento());
			pstm.setString(5, figurinha.getSelecao());
			pstm.setDouble(6, figurinha.getPeso());
			pstm.setString(7, nome);
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Metodo para atualizar figurinha do Pokemon
	public void updateFigurinha(Pokemon figurinha, String nome) {
		String sql = "UPDATE figurinha_pokemon SET nome = ?, raridade = ?, tipo = ?" + "WHERE nome = ?";
			
		Connection conn = null;
		PreparedStatement pstm = null;
			
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
				
			//Adicionar os valores para atualizar
			pstm.setString(1, figurinha.getNome());
			pstm.setString(2, figurinha.getRaridade());
			pstm.setString(3, figurinha.getTipo());
			pstm.setString(4, nome);
				
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
					
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Metodo para atualizar figurinha do Yu-Gi-Oh!
	public void updateFigurinha(Yugioh figurinha, String nome) {
		String sql = "UPDATE figurinha_yugioh SET nome = ?, raridade = ?, tipo = ?, atk = ?, def = ?, nivel = ? WHERE nome = ?";
				
		Connection conn = null;
		PreparedStatement pstm = null;
				
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
				
			//Adicionar os valores para atualizar
			pstm.setString(1, figurinha.getNome());
			pstm.setString(2, figurinha.getRaridade());
			pstm.setString(3, figurinha.getTipo());
			pstm.setInt(4, figurinha.getAtk());
			pstm.setInt(5, figurinha.getDef());
			pstm.setInt(6, figurinha.getNivel());
			pstm.setString(7, nome);
					
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
						
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Metodo para deletar figurinhas da copa
	public void deleteFigurinha(Album album, CopaDoMundoQatar figurinha) {
		String sql = "DELETE FROM figurinha_copa WHERE nome_album = ? AND nome = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, album.getNome());
			pstm.setString(2, figurinha.getNome());
			
			pstm.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	//Metodo para deletar figurinhas de pokemon
	public void deleteFigurinha(Album album, Pokemon figurinha) {
		String sql = "DELETE FROM figurinha_pokemon WHERE nome_album = ? AND nome = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, album.getNome());
			pstm.setString(2, figurinha.getNome());
			
			pstm.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Metodo para deletar figurinhas do Yu-Gi-Oh!
	public void deleteFigurinha(Album album, Yugioh figurinha) {
		String sql = "DELETE FROM figurinha_yugioh WHERE nome_album = ? AND nome = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, album.getNome());
			pstm.setString(2, figurinha.getNome());
			
			pstm.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	//Metodo para listar as figurinhas da Copa
	public List<CopaDoMundoQatar> getFigurinha(Album album, CopaDoMundoQatar f) {
		String nome = album.getNome();
		String sql = "SELECT * FROM figurinha_copa WHERE nome_album = '"+nome+"'";
		
		List<CopaDoMundoQatar> figurinhas = new ArrayList<CopaDoMundoQatar>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que vai recuperar os dados do banco
		ResultSet rst = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rst = pstm.executeQuery();
			
			while(rst.next()) {
				CopaDoMundoQatar figurinha = new CopaDoMundoQatar();
				
				//pstm.setString(1, album.getNome());
				
				//Recuperar os dados
				figurinha.setNome(rst.getString("nome"));
				figurinha.setRaridade(rst.getString("raridade"));
				figurinha.setAltura(rst.getDouble("altura"));
				figurinha.setNascimento(rst.getString("nascimento"));
				figurinha.setSelecao(rst.getString("selecao"));
				figurinha.setPeso(rst.getDouble("peso"));
				
				figurinhas.add(figurinha);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return figurinhas;
	}
	
	//Metodo para listar as figurinhas do Pokemon
	public List<Pokemon> getFigurinha(Album album, Pokemon f) {
		String nome = album.getNome();
		String sql = "SELECT * FROM figurinha_pokemon WHERE nome_album = '"+nome+"'";
		
		List<Pokemon> figurinhas = new ArrayList<Pokemon>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que vai recuperar os dados do banco
		ResultSet rst = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rst = pstm.executeQuery();
			
			while(rst.next()) {
				Pokemon figurinha = new Pokemon();
				
				//Recuperar os dados
				figurinha.setNome(rst.getString("nome"));
				figurinha.setRaridade(rst.getString("raridade"));
				figurinha.setTipo(rst.getString("tipo"));
				
				figurinhas.add(figurinha);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return figurinhas;
	}
	
	//Metodo para listar as figurinhas do Yu-Gi-Oh!
	public List<Yugioh> getFigurinha(Album album, Yugioh f) {
		String nome = album.getNome();
		String sql = "SELECT * FROM figurinha_yugioh WHERE nome_album = '"+nome+"'";
		
		List<Yugioh> figurinhas = new ArrayList<Yugioh>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que vai recuperar os dados do banco
		ResultSet rst = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rst = pstm.executeQuery();
			
			while(rst.next()) {
				Yugioh figurinha = new Yugioh();
				
				//Recuperar os dados
				figurinha.setNome(rst.getString("nome"));
				figurinha.setRaridade(rst.getString("raridade"));
				figurinha.setTipo(rst.getString("tipo"));
				figurinha.setAtk(rst.getInt("atk"));
				figurinha.setDef(rst.getInt("def"));
				figurinha.setNivel(rst.getInt("nivel"));
				
				figurinhas.add(figurinha);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return figurinhas;
	}

	//Metodo para adicionar o album
	public void saveAlbum(Album album) {
		String sql = "INSERT INTO albuns(nome, tipo, ano, qtd_fig, qtd_fig_total) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			//Criando uma coneccao com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			//PrepareStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionando valores esperados pela query
			pstm.setString(1, album.getNome());
			pstm.setString(2, album.getTipo());
			pstm.setInt(3, album.getAno());
			pstm.setInt(4, album.getQtd_figurinha());
			pstm.setInt(5, album.getQtd_figurinha_total());
			
			//Executando a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Fechando as coneccoes
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Metodo para atualizar o album
	public void updateAlbum(Album album, String nome) {
		String sql = "UPDATE albuns SET nome = ?, ano = ?, qtd_fig = ?, qtd_fig_total = ? WHERE nome = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setString(1, album.getNome());
			pstm.setInt(2, album.getAno());
			pstm.setInt(3, album.getQtd_figurinha());
			pstm.setInt(4, album.getQtd_figurinha_total());
			pstm.setString(5, nome);
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Caso tenha sido trocado o nome do album, deveremos trocar tambem nas figurinhas
		String tipo = album.getTipo();
		sql = "UPDATE figurinha_"+tipo+" SET nome_album = ?" + " WHERE nome_album = ?";
			
		try {	
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
				
			//Atualizando o nome
			pstm.setString(1, album.getNome());
			pstm.setString(2, nome);
				
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
					
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	//Metodo para deletar o album
	public void deleteAlbum(Album album) {
		String tipo = album.getTipo();
		
		//Apagando o album
		String sql = "DELETE FROM albuns WHERE nome = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, album.getNome());
			
			pstm.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//Deletando as figurinhas que estavam naquele album
		sql = "DELETE FROM figurinha_"+tipo+" WHERE nome_album = ?";
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, album.getNome());
			
			pstm.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	//Metodo para listar os albuns
	public List <Album> getAlbum(){
		String sql = "SELECT * FROM albuns";
		
		List<Album> albuns = new ArrayList<Album>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que vai recuperar os dados do banco
		ResultSet rst = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rst = pstm.executeQuery();
			
			while(rst.next()) {
				Album album = new Album();
				
				//Recuperar os dados
				album.setNome(rst.getString("nome"));
				album.setTipo(rst.getString("tipo"));
				album.setAno(rst.getInt("ano"));
				album.setQtd_figurinha(rst.getInt("qtd_fig"));
				album.setQtd_figurinha_total(rst.getInt("qtd_fig_total"));
				
				albuns.add(album);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return albuns;
	}
}
