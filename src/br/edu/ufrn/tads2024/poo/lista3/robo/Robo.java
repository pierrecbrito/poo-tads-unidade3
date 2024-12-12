package br.edu.ufrn.tads2024.poo.lista3.robo;

import java.util.Scanner;

public class Robo {
	private int linha;
	private int coluna;
	private int passo;
	private int arenaLargura;
	private int arenaAltura;
	
	public Robo(int passo, int arenaLargura, int arenaAltura) {
		this.linha = 0;
		this.coluna = 0;
		this.passo = passo;
		this.arenaLargura = arenaLargura;
		this.arenaAltura = arenaAltura;
	}
	
	public void mostrarPosicaoAtual() {
		System.out.println("Linha: " + linha + ", Coluna: " + coluna);
	}
	
	public void andarFrente() {
		if(linha + passo < arenaAltura)
			linha += passo;
	}
	
	public void andarTras() {
		if (linha - passo >= 0)
			linha -= passo;
	}
	
	public void andarDireita() {
		if (coluna + passo < arenaLargura)
			coluna += passo;
	}
	
	public void andarEsquerda() {
		if (coluna - passo >= 0)
			coluna -= passo;
	}
	
	public void mostrarRobo() {
		System.out.print(" ");
		for (int j = 0; j < arenaLargura; j++) {         
			System.out.print("-");
	    }
		System.out.println();
		 
		for (int i = 0; i < arenaAltura; i++) {
            for (int j = 0; j < arenaLargura; j++) {   
            	
            	if (j == 0) {
 					System.out.print("|");
 				}
 				
				
                if (i == linha && j == coluna) {
                    System.out.print("1");
                } else {
                    System.out.print(" ");
                }
                
                if(j == arenaLargura - 1) {
 					System.out.print("|");
 				}
               
            }
            System.out.println();
		}
		
		System.out.print(" ");
		for (int j = 0; j < arenaLargura; j++) {
			System.out.print("-");
		}
		System.out.println();
	}
	private static Scanner scanner = new Scanner(System.in);
	 
	public static void main(String[] args) {
		Robo robo = new Robo(1, 40, 20);
		
		int entrada = -1;
		
		do {
			System.out.println("Menu:");
			System.out.println("1. Andar para frente");
			System.out.println("2. Andar para trás");
			System.out.println("3. Andar para direita");
			System.out.println("4. Andar para esquerda");
			System.out.println("5. Sair");
			entrada = scanner.nextInt();
			
			switch(entrada) {
				case 1:
                    robo.andarFrente();
                    break;
                case 2:
                    robo.andarTras();
                    break;
                case 3:
                    robo.andarDireita();
                    break;
                case 4:
                    robo.andarEsquerda();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
			}
                robo.mostrarRobo();
		} while (entrada != 5);
		
	}
	
}
