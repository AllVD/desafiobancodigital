import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

    // Validação do CPF usando a classe ValidarCPF
    if (!ValidarCPF.validarCPF(cpf)) {
        System.out.println("CPF inválido!");
        return;
    }

        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, endereco);

        System.out.print("Digite a quantia inicial para abertura da conta, valor mínimo R$50: ");
        double quantiaInicial = scanner.nextDouble();
        if (quantiaInicial < 50) {
            System.out.println("A quantia inicial deve ser de pelo menos R$50.");
            return;
        }

        Conta cc = new ContaCorrente(cliente);
        cc.depositar(quantiaInicial);

        System.out.print("Deseja transferir uma quantia para a conta poupança? (sim/não): ");
        scanner.nextLine(); // Consumir a nova linha
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("sim")) {
            System.out.print("Digite a quantia para transferir: ");
            double quantiaTransferir = scanner.nextDouble();
            Conta poupanca = new ContaPoupanca(cliente);
            cc.transferir(quantiaTransferir, poupanca);
     
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    } else {
        cc.imprimirExtrato();
    }    

        scanner.close();
    }
}