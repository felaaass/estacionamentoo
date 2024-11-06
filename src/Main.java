import java.util.Scanner;

public class Main {
    private Estacionamento estacionamento;

    public Main() {
        this.estacionamento = new Estacionamento();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        estacionamento.cadastrarVaga(1, "pequeno");
        estacionamento.cadastrarVaga(2, "médio");
        estacionamento.cadastrarVaga(3, "grande");

        while (executando) {
            System.out.println("\n1. Registrar entrada\n2. Registrar saída\n3. Exibir vagas ocupadas\n4. Exibir histórico\n5. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Placa: ");
                    String placa = scanner.next();
                    System.out.print("Modelo: ");
                    String modelo = scanner.next();
                    System.out.print("Tamanho (pequeno, médio, grande): ");
                    String tamanho = scanner.next();
                    Veiculo veiculo = new Veiculo(placa, modelo, tamanho);
                    estacionamento.registrarEntrada(veiculo);
                    break;

                case 2:
                    System.out.print("Placa: ");
                    placa = scanner.next();
                    estacionamento.registrarSaida(placa);
                    break;

                case 3:
                    estacionamento.exibirVagasOcupadas();
                    break;

                case 4:
                    estacionamento.exibirHistorico();
                    break;

                case 5:
                    System.out.println("Encerrando sistema.");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.iniciar();
    }
}
