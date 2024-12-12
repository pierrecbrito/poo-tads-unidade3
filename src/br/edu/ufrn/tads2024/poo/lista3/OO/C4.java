package br.edu.ufrn.tads2024.poo.lista3.OO;

class C4 extends C2 {
    private String atributoC4;

    public C4(String atributoC1, String atributoC2, String atributoC4) {
        super(atributoC1, atributoC2);
        this.atributoC4 = atributoC4;
    }

    @Override
    public void metodoC1() {
        System.out.println("Método C1 em C4");
    }

    public void metodoC4() {
        System.out.println("Método C4 em C4");
    }
}
