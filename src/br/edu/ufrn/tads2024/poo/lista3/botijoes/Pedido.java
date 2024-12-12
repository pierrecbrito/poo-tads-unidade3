package br.edu.ufrn.tads2024.poo.lista3.botijoes;
/*
 *  Elabore um sistema no paradigma OO que implemente as responsabilidades de uma
 *	empresa que entrega botijões de gás (suponha funcionar 24 horas). 
 *
 *	Crie a classe Pedido, descubra seus atributos e métodos
 * */

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

class Pedido {
    private static int contador = 0;
    private int codigo;
    private LocalDateTime horaCompra;
    private String enderecoEntrega;
    private int quantidadeBotijoes;
    private double totalCompra;
    private LocalDateTime horaEntrega;
    private String numeroCartao;
    private String status;

    public Pedido(LocalDateTime horaCompra, String enderecoEntrega) {
        this.codigo = ++contador;
        this.horaCompra = horaCompra;
        this.enderecoEntrega = enderecoEntrega;
        this.status = "pendente";
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDateTime getHoraCompra() {
        return horaCompra;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public int getQuantidadeBotijoes() {
        return quantidadeBotijoes;
    }

    public void setQuantidadeBotijoes(int quantidadeBotijoes) {
        this.quantidadeBotijoes = quantidadeBotijoes;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void calcularTotalCompra(double precoUnitario) {
        this.totalCompra = this.quantidadeBotijoes * precoUnitario;
    }

    public LocalDateTime getHoraEntrega() {
        return horaEntrega;
    }

    public void calcularHoraEntrega() {
        this.horaEntrega = this.horaCompra.plusHours(6);
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        return 
				"Código: " + codigo +
				"\nCompra feita em: " + horaCompra.format(formatter) +
				"\nEndereço: " + enderecoEntrega + '\'' +
				"\nBotijões: " + quantidadeBotijoes +
				"\nTotal: R$" + totalCompra +
				"\nEntrega feita em " + (horaEntrega != null ? horaEntrega.format(formatter) : "Sem registro") +
				"\nPagamento no cartão: " + (numeroCartao != null ? numeroCartao : "Sem registro") +
				"\nStatus: " + status;
                
        
    }

    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final double PRECO_UNITARIO = 100.0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Fazer pedido");
            System.out.println("2. Confirmar entrega");
            System.out.println("3. Ver pedidos confirmados");
            System.out.println("4. Ver pedidos entregues");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    fazerPedido();
                    break;
                case 2:
                    confirmarEntrega();
                    break;
                case 3:
                    verPedidos("confirmado");
                    break;
                case 4:
                    verPedidos("entregue");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void fazerPedido() {
        LocalDateTime horaCompra = LocalDateTime.now();
        System.out.print("Digite o endereço de entrega: ");
        String enderecoEntrega = scanner.nextLine();
        Pedido pedido = new Pedido(horaCompra, enderecoEntrega);
        System.out.println("============================================");
        System.out.println("Dados do pedido:");
        System.out.println(pedido.getEnderecoEntrega());
        System.out.println("============================================");
        System.out.print("Deseja confirmar o endereço do pedido? (s/n): ");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("n")) {
            System.out.print("Digite o novo endereço de entrega: ");
            enderecoEntrega = scanner.nextLine();
            pedido.setEnderecoEntrega(enderecoEntrega);
        }

        System.out.print("Digite a quantidade de botijões: ");
        int quantidadeBotijoes = scanner.nextInt();
        scanner.nextLine(); 
        pedido.setQuantidadeBotijoes(quantidadeBotijoes);
        pedido.calcularTotalCompra(PRECO_UNITARIO);
        pedido.calcularHoraEntrega();

        System.out.println("Total da compra: R$" + pedido.getTotalCompra());
        System.out.println("Hora de entrega: " + pedido.getHoraEntrega().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

        System.out.print("Digite o número do cartão de crédito: ");
        String numeroCartao = scanner.nextLine();
        pedido.setNumeroCartao(numeroCartao);
        pedido.setStatus("confirmado");

        pedidos.add(pedido);
        System.out.println("Pedido confirmado! Código do pedido: " + pedido.getCodigo());
    }

    private static void confirmarEntrega() {
        System.out.print("Digite o código do pedido: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        for (Pedido pedido : pedidos) {
            if (pedido.getCodigo() == codigo) {
                if (pedido.getStatus().equals("confirmado")) {
                    pedido.setStatus("entregue");
                    System.out.println("Pedido entregue com sucesso!");
                } else {
                    System.out.println("Pedido já foi entregue ou está pendente.");
                }
                return;
            }
        }
        System.out.println("Pedido não localizado.");
    }

    private static void verPedidos(String status) {
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus().equals(status)) {
            	System.out.println("============================================");
                System.out.println(pedido);
                System.out.println("============================================");
            }
        }
    }
}
