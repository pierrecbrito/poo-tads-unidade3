package br.edu.ufrn.tads2024.poo.lista3.OO;

class C2 extends C1 {
    protected String atributoC2;

    public C2(String atributoC1, String atributoC2) {
        super(atributoC1);
        this.atributoC2 = atributoC2;
    }

    @Override
    public void metodoC1() {
        System.out.println("Método C1 em C2");
    }

    public void metodoC2() {
        System.out.println("Método C2 em C2");
    }
}