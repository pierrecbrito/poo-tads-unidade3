package br.edu.ufrn.tads2024.poo.lista3.dados;

import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static Game game = new Game();
	
	public static void main(String[] args) {
		exibirRanking();
        coletarDadosJogadores();
        iniciarJogo();
        game.salvarRankingEmArquivo();
	}
	

    private static void exibirRanking() {
        List<Player> ranking = game.getRanking();
        System.out.println("TOP FIVE:");
        for (Player player : ranking) {
            System.out.println(player.getNome() + " - Vitórias: " + player.getVitorias());
        }
        System.out.println("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
    }

    private static void coletarDadosJogadores() {
        System.out.println("Digite o número de jogadores (até 11):");
        int numJogadores = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numJogadores; i++) {
            System.out.println("Digite o nome do jogador " + (i + 1) + ":");
            String nome = scanner.nextLine();
            System.out.println("Digite a aposta do jogador " + (i + 1) + " (entre 1 e 12):");
            int aposta = scanner.nextInt();
            scanner.nextLine();

            if (!game.adicionarJogador(nome, aposta)) {
                System.out.println("Aposta inválida ou duplicada. Tente novamente.");
                i--;
            }
        }
    }

    private static void iniciarJogo() {
        int resultado = game.lancarDados();
        System.out.println("Resultado dos dados: " + resultado);

        Player vencedor = game.verificarVencedor(resultado);
        if (vencedor != null) {
            System.out.println("Vencedor: " + vencedor.getNome());
        } else {
            System.out.println("A máquina venceu!");
        }
    }

}
