import java.util.ArrayList;

public class SistemaClientes {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            cliente.exibirInfo();
        }
    }

    public boolean deletarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                clientes.remove(cliente);
                return true;
            }
        }
        return false;
    }
}