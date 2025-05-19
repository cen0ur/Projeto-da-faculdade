import java.util.ArrayList;
import java.util.List;

public class SistemaVeiculos {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        for (Veiculo v : veiculos) {
            v.exibirInfo();
        }
    }

    public boolean deletarPorModelo(String modelo) {
        for (Veiculo v : veiculos) {
            if (v.getModelo().equalsIgnoreCase(modelo)) {
                veiculos.remove(v);
                return true;
            }
        }
        return false;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}
