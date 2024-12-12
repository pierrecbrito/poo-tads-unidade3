package br.edu.ufrn.tads2024.poo.lista3.dados;


public class Player {
    private String nome;
    private int aposta;
    private int vitorias;

    public Player(String nome, int aposta) {
        this.nome = nome;
        this.aposta = aposta;
        this.vitorias = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getAposta() {
        return aposta;
    }

    public int getVitorias() {
        return vitorias;
    }
    
    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public void incrementarVitorias() {
        this.vitorias++;
    }
}

