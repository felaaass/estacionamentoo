import java.time.LocalDateTime;

public class Veiculo {
    private String placa;
    private String modelo;
    private String tamanho;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private double valorPago;

    public Veiculo(String placa, String modelo, String tamanho) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void registrarEntrada() {
        this.horaEntrada = LocalDateTime.now();
    }

    public void registrarSaida() {
        this.horaSaida = LocalDateTime.now();
    }

    public long calcularTempoPermanencia() {
        return java.time.Duration.between(horaEntrada, horaSaida).toHours();
    }

    public void setValorPago(double valor) {
        this.valorPago = valor;
    }

    public double getValorPago() {
        return valorPago;
    }
}
