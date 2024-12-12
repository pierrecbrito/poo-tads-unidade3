package br.edu.ufrn.tads2024.poo.lista3.OO;

class C5 extends C2 implements I1 {
    private String atributoC5;

    public C5(String atributoC1, String atributoC2, String atributoC5) {
        super(atributoC1, atributoC2);
        this.atributoC5 = atributoC5;
    }

    @Override
    public void metodoC1() {
        System.out.println("Método C1 em C5");
    }

    @Override
    public void metodoI1() {
        System.out.println("Método I1 em C5");
    }

    public void metodoC5() {
        System.out.println("Método C5 em C5");
    }
}
