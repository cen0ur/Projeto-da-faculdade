import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Veiculo> veiculos = new ArrayList<>();
    static List<Cliente> clientes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n1. Cadastrar veículo");
            System.out.println("2. Cadastrar cliente");
            System.out.println("3. Exibir veículos");
            System.out.println("4. Exibir clientes");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1 -> cadastrarVeiculo();
                case 2 -> cadastrarCliente();
                case 3 -> exibirVeiculos();
                case 4 -> exibirClientes();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarVeiculo() {
        try {
            System.out.print("Tipo (carro/moto): ");
            String tipo = scanner.nextLine().toLowerCase();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Fabricante: ");
            String fabricante = scanner.nextLine();
            System.out.print("Ano de fabricação: ");
            int ano = scanner.nextInt();
            scanner.nextLine();

            Veiculo v = switch (tipo) {
                case "carro" -> new Carro(modelo, fabricante, ano);
                case "moto" -> new Moto(modelo, fabricante, ano);
                default -> throw new Exception("Tipo inválido.");
            };

            veiculos.add(v);
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void cadastrarCliente() {
        System.out.print("Tipo (pf/pj): ");
        String tipo = scanner.nextLine().toLowerCase();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Contato: ");
        String contato = scanner.nextLine();

        Cliente c;
        if (tipo.equals("pf")) {
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            c = new PessoaFisica(nome, contato, cpf);
        } else if (tipo.equals("pj")) {
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            c = new PessoaJuridica(nome, contato, cnpj);
        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        clientes.add(c);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void exibirVeiculos() {
        for (Veiculo v : veiculos) {
            v.exibirInfo();
        }
    }

    private static void exibirClientes() {
        for (Cliente c : clientes) {
            c.exibirInfo();
        }
    }
}
