package br.edu.ufrn.tads2024.poo.lista3.OO;

public class Principal {

	public static void main(String[] args) {
		C2 c2 = new C2("AtributoC1 em C2", "AtributoC2 em C2");
        C3 c3 = new C3("AtributoC1 em C3", "AtributoC3 em C3");
        C4 c4 = new C4("AtributoC1 em C4", "AtributoC2 em C4", "AtributoC4 em C4");
        C5 c5 = new C5("AtributoC1 em C5", "AtributoC2 em C5", "AtributoC5 em C5");

        // Testando métodos de C2
        c2.metodoC1();
        c2.metodoC2();

        // Testando métodos de C3
        c3.metodoC1();
        c3.metodoI1();
        c3.metodoI2A();
        c3.metodoI2B();
        c3.metodoC3();

        // Testando métodos de C4
        c4.metodoC1();
        c4.metodoC2();
        c4.metodoC4();

        // Testando métodos de C5
        c5.metodoC1();
        c5.metodoC2();
        c5.metodoI1();
        c5.metodoC5();

	}

}
