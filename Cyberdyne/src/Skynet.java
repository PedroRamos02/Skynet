import java.util.Scanner;
import java.util.Locale;
public class Skynet {

    private Scanner entrada;
    private Enxame enxame;

    public Skynet() {
        entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);
        enxame = new Enxame();
    }

    public void executar() {
        int opcao = 0;
        do {
            menu();
            System.out.print("Qual opção deseja?");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    cadastrarRobo();
                    break;
                case 2:
                    consultarRobo();
                    break;
                default:
                    System.out.println("Selecione uma opção valida!");
            }
        } while (opcao !=0);
    }
    private void menu() {
        System.out.println("=====================================");
        System.out.println("Menu de opcoes: ");
        System.out.println("[0] Sair do sistema");
        System.out.println("[1] Adicionar um novo robo");
        System.out.println("[2] Consultar robo");
        System.out.println("=====================================");
    }

    private void cadastrarRobo() {
        System.out.println("=====================================");
        System.out.println("Cadastrar um robo");
        System.out.print("Digite o modelo do robo: ");
        String modelo = entrada.nextLine();
        System.out.print("Digite o valor do robo: ");
        double valor = entrada.nextInt();
        Robo r = new Robo(modelo, valor);
        if(enxame.adicionaRobo(r))
            System.out.println("Robo cadastrado com sucesso.");
        else
            System.out.println("Erro: robo não cadastrado.");
    }

    private void consultarRobo() {
        System.out.println("=====================================");
        System.out.println("Consultar um robo pelo modelo");
        System.out.print("Digite o modelo do robo: ");
        String modelo = entrada.nextLine();
        Robo r = enxame.consultaRobo(modelo);
        if(r == null)
            System.out.println("Erro: modelo não encontrado.");
        else {
            System.out.println("Modelo do robo: " + r.getModelo());
            System.out.println("Valor: " + r.getValor());
        }
    }
}
