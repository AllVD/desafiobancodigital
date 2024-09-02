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

        Conta cc = new ContaCorrente(cliente);
        cc.depositar(100);

        Conta poupanca = new ContaPoupanca(cliente);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        scanner.close();
    }
}