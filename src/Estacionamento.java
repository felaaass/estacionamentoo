import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<Veiculo> historico;

    public Estacionamento() {
        this.vagas = new ArrayList<>();
        this.historico = new ArrayList<>();
    }

    public void cadastrarVaga(int numero, String tamanho) {
        vagas.add(new Vaga(numero, tamanho));
    }

    public boolean registrarEntrada(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equals(veiculo.getTamanho())) {
                vaga.ocuparVaga();
                veiculo.registrarEntrada();
                historico.add(veiculo);
                System.out.println("Veículo estacionado na vaga " + vaga.getNumero());
                return true;
            }
        }
        System.out.println("Nenhuma vaga disponível para o tamanho do veículo.");
        return false;
    }

    public void registrarSaida(String placa) {
        for (Veiculo veiculo : historico) {
            if (veiculo.getPlaca().equals(placa) && veiculo.getValorPago() == 0) {
                veiculo.registrarSaida();
                long duracao = veiculo.calcularTempoPermanencia();
                double valor = calcularValor(duracao);
                veiculo.setValorPago(valor);
                liberarVaga(veiculo.getTamanho());
                System.out.println("Veículo saiu. Tempo: " + duracao + " horas, Valor: R$" + valor);
                return;
            }
        }
        System.out.println("Veículo não encontrado.");
    }

    private void liberarVaga(String tamanho) {
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel() && vaga.getTamanho().equals(tamanho)) {
                vaga.liberarVaga();
                break;
            }
        }
    }

    private double calcularValor(long duracao) {
        if (duracao <= 1) return 5.0;
        if (duracao <= 3) return 10.0;
        return 15.0;
    }

    public void exibirVagasOcupadas() {
        System.out.println("Vagas ocupadas:");
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel()) {
                System.out.println("Vaga " + vaga.getNumero() + " | Tamanho: " + vaga.getTamanho());
            }
        }
    }

    public void exibirHistorico() {
        System.out.println("Histórico de permanência:");
        for (Veiculo veiculo : historico) {
            if (veiculo.getValorPago() > 0) {
                System.out.println("Placa: " + veiculo.getPlaca() +
                        " | Tempo: " + veiculo.calcularTempoPermanencia() + " horas" +
                        " | Valor Pago: R$" + veiculo.getValorPago());
            }
        }
    }
}
