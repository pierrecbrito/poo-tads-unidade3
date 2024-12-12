package br.edu.ufrn.tads2024.poo.lista3.OO;

class C3 extends C1 implements I1, I2 {
    protected String atributoC3;

    public C3(String atributoC1, String atributoC3) {
        super(atributoC1);
        this.atributoC3 = atributoC3;
    }

    @Override
    public void metodoC1() {
        System.out.println("Método C1 em C3");
    }

    @Override
    public void metodoI1() {
        System.out.println("Método I1 em C3");
    }

    @Override
    public void metodoI2A() {
        System.out.println("Método I2A em C3");
    }

    @Override
    public void metodoI2B() {
        System.out.println("Método I2B em C3");
    }

    public void metodoC3() {
        System.out.println("Método C3 em C3");
    }
}
