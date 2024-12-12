package br.edu.ufrn.tads2024.poo.lista3.dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Game {
	private List<Player> jogadores;
    private Dado dado1;
    private Dado dado2;

    public Game() {
        this.jogadores = new ArrayList<>();
        this.dado1 = new Dado();
        this.dado2 = new Dado();
    }

    public boolean adicionarJogador(String nome, int aposta) {
        if (jogadores.size() >= 11 || aposta < 1 || aposta > 12 || apostaDuplicada(aposta)) {
            return false;
        }
        jogadores.add(new Player(nome, aposta));
        return true;
    }

    private boolean apostaDuplicada(int aposta) {
        for (Player jogador : jogadores) {
            if (jogador.getAposta() == aposta) {
                return true;
            }
        }
        return false;
    }

    public int lancarDados() {
        return dado1.lancar() + dado2.lancar();
    }

    public Player verificarVencedor(int resultado) {
        for (Player jogador : jogadores) {
            if (jogador.getAposta() == resultado) {
                jogador.incrementarVitorias();
                return jogador;
            }
        }
        return null;
    }

    public List<Player> getRanking() {
    	List<Player> ranking = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader("ranking.txt"))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(" - Vitórias: ");
	            if (parts.length == 2) {
	                String nome = parts[0];
	                int vitorias = Integer.parseInt(parts[1]);
	                ranking.add(new Player(nome, 0)); 
	                ranking.get(ranking.size() - 1).setVitorias(vitorias); 
	            }
	        }
	    } catch (IOException e) {

	    }

	    ranking.sort(Comparator.comparingInt(Player::getVitorias).reversed());

	    return ranking.subList(0, Math.min(5, ranking.size()));
    }

    public void salvarRankingEmArquivo() {
	 	List<Player> ranking = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader("ranking.txt"))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(" - Vitórias: ");
	            if (parts.length == 2) {
	                String nome = parts[0];
	                int vitorias = Integer.parseInt(parts[1]);
	                ranking.add(new Player(nome, 0));
	                ranking.get(ranking.size() - 1).setVitorias(vitorias);
	            }
	        }
	    } catch (IOException e) {

	    }


	    for (Player jogadorAtual : jogadores) {
	        boolean jogadorExistente = false;
	        for (Player jogadorRanking : ranking) {
	            if (jogadorRanking.getNome().equals(jogadorAtual.getNome())) {
	                jogadorRanking.setVitorias(jogadorRanking.getVitorias() + jogadorAtual.getVitorias());
	                jogadorExistente = true;
	                break;
	            }
	        }
	        if (!jogadorExistente) {
	            ranking.add(jogadorAtual);
	        }
	    }

	    ranking.sort(Comparator.comparingInt(Player::getVitorias).reversed());

	    if (ranking.size() > 5) {
	        ranking = ranking.subList(0, 5);
	    }

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("ranking.txt"))) {
	        for (Player player : ranking) {
	            writer.write(player.getNome() + " - Vitórias: " + player.getVitorias());
	            writer.newLine();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
    }
}
