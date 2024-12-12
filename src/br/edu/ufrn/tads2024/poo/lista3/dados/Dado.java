package br.edu.ufrn.tads2024.poo.lista3.dados;

import java.util.Random;

public class Dado {
	private Random random;

    public Dado() {
        this.random = new Random();
    }

    public int lancar() {
        return random.nextInt(6) + 1;
    }
}
