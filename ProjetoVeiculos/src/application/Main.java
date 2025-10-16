package application;

import model.entites.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Throwable {

        Scanner sc = new Scanner(System.in);
        Concessionaria concessionaria = new Concessionaria();
        int opcao;

        do {
            System.out.println("\n1. Cadastrar veículo");
            System.out.println("2. Cadastrar cliente");
            System.out.println("3. Exibir veículos");
            System.out.println("4. Exibir clientes");
            System.out.println("5. Deletar cliente por nome");
            System.out.println("6. Deletar veículo por modelo"); // NOVA OPÇÃO
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Tipo (carro/moto): ");
                    String tipo = sc.nextLine().toLowerCase();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Fabricante: ");
                    String fabricante = sc.nextLine();
                    System.out.print("Ano de fabricação: ");
                    int ano = sc.nextInt();
                    sc.nextLine();
                    concessionaria.cadastrarVeiculo(tipo, modelo, fabricante, ano);
                    break;
                case 2:
                    System.out.print("Tipo (pf/pj): ");
                    String tipoCliente = sc.nextLine().toLowerCase();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Contato: ");
                    String contato = sc.nextLine();
                    System.out.print("Documento: ");
                    String documento = sc.nextLine();
                    concessionaria.cadastrarCliente(tipoCliente, nome, contato, documento);
                    break;
                case 3:
                    concessionaria.exibirVeiculos();
                    break;
                case 4:
                    concessionaria.exibirClientes();
                    break;
                case 5:
                    System.out.print("Digite o nome do cliente que deseja deletar: ");
                    nome = sc.nextLine();
                    concessionaria.deletarClientePorNome(nome);
                    break;
                case 6:
                    System.out.print("Digite o modelo do veículo que deseja deletar: ");
                    modelo = sc.nextLine();
                    concessionaria.deletarPorModelo(modelo);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}

