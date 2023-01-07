package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.*;

public class Main {
	public static void main (String args[]) {
		
		//Criando a janela
		JanelaInicial janela1 = new JanelaInicial();
		
		//Botao para criar album novo
		JButton botao1 = new JButton();
		botao1.setBounds(80, 250, 180, 30);
		janela1.add(botao1);
		
		//Texto do botao
		JLabel criar = new JLabel("Criar novo album");
		botao1.add(criar);
		criar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
		
		//Botao para gerenciar album
		JButton botao2 = new JButton();
		botao2.setBounds(1020, 250, 180, 30);
		janela1.add(botao2);
		
		//Texto do botao
		JLabel gerenciar = new JLabel("Gerenciar album");
		botao2.add(gerenciar);
		gerenciar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
		
	
		
		//Acao tomada quando selecionado a opcao de criar album
		botao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Criando a nova janela para criar albuns
				JanelaCriar janela2 = new JanelaCriar();
				
				//Botao para finalizar a criacao
				JButton btnCriar = new JButton("Criar");
				janela2.add(btnCriar);
				btnCriar.setBounds(350, 400, 100, 30);
				
				btnCriar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if("".equals(janela2.campotxt.getText()) ) {
							JOptionPane.showMessageDialog(null, "Digite um nome para o album");
						} else {
							JOptionPane.showMessageDialog(null, "Album criado com sucesso");
						}
						
					}
				
				});
				
				
				
			}
		});
		//Acao tomada quando selecionado a opcao de gerenciar album
		botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaGerenciar janela3 = new JanelaGerenciar();
                
				//Botao para excluir album novo
                JButton delete= new JButton();
                janela3.add(delete);
                delete.setBounds(220, 400, 130, 30);

                //Texto do botao
                JLabel text = new JLabel("Excluir album ");
                delete.add(text);
                criar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
                
				delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//janela de pergunta
						JaneladePergunta janela6 = new JaneladePergunta();
						// Botao do sim
						JButton sim = new JButton("Sim");
						sim.setBounds(25, 70, 90, 30);
						janela6.add(sim);
						
						//Botao do não
						JButton nao = new JButton("Não");
						nao.setBounds(170, 70, 90, 30);
						janela6.add(nao);
				sim.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == sim) {
						JOptionPane.showMessageDialog(null, "Excluido com sucesso");}
				nao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 if(e.getSource() == nao) {
								JOptionPane.showMessageDialog(null, "Tenha mais cuidado");

						 }
					}
				});		
					
					
					}});
					
}});
                //Botao para edicao
				JButton btnEdit = new JButton("Editar");
				janela3.add(btnEdit);
				btnEdit.setBounds(60, 400, 100, 30);
				
				//Acao do botão editar
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Janela de editar
						JanelaEditar janela4 = new JanelaEditar();
						//botao para salvar as alterações
						JButton btnsave = new JButton("Salvar");
						janela4.add(btnsave);
						btnsave.setBounds(130, 400, 100, 30);
				btnsave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(e.getSource() == btnsave) {
						JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso");}
					}
				});
						//botao para adicionar figruinha
						JButton btnadd = new JButton("Adicionar figurinha");
						janela4.add(btnadd);
						btnadd.setBounds(110, 100, 150, 30);
						//botao para excluir figruinha
						JButton btnexc = new JButton("Excluir figurinha");
						janela4.add(btnexc);
						btnexc.setBounds(110, 160, 150, 30);
						
						//botao para listar figruinha
						JButton btnlist = new JButton("Listar figurinha");
						janela4.add(btnlist);
						btnlist.setBounds(110, 220, 150, 30);
						
						//botao para editar figruinha
						JButton btneditar = new JButton("Editar figurinha");
						janela4.add(btneditar);
						btneditar.setBounds(110, 280, 150, 30);
						//Açao do botao editar
				btneditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						{if("Pokemon".equals(janela3.albuns.getSelectedItem())) {
							Janelapokemon janela5 = new Janelapokemon();
							//botão de criar figurinha
							JButton figuraCriar = new JButton("Criar Figurinha");
							figuraCriar.setBounds(80, 400, 200, 30);
							janela5.add(figuraCriar);
							figuraCriar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									if("".equals(janela5.campname.getText())) {
										JOptionPane.showMessageDialog(null, "Prencha todos os campos");
									} else {
										JOptionPane.showMessageDialog(null, "Figurinha criado com sucesso");
									}
									
								}
							});
						}
						if("Yu-Gi-Oh!".equals(janela3.albuns.getSelectedItem())) {
							JanelaYugioh janela6 = new JanelaYugioh();
							//botão de criar figurinha
							JButton figuraCriar = new JButton("Criar Figurinha");
							figuraCriar.setBounds(80, 400, 200, 30);
							janela6.add(figuraCriar);
							figuraCriar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									if("".equals(janela6.campnameyu.getText())) {
										JOptionPane.showMessageDialog(null, "Prencha todos os campos");
									} else {
										JOptionPane.showMessageDialog(null, "Figurinha criado com sucesso");
									}
									
								}
							});
							
						}}
					}
				});
						



						
						
						
						
						
					}

				});
			}
		});
				
	}
}