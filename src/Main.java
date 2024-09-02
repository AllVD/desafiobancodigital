import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        // Validação do CPF
        if (!validarCPF(cpf)) {
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

    public static boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");
        
        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        
        // Verifica se todos os dígitos são iguais (ex: 111.111.111-11)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        
        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            // Multiplica cada dígito por um peso decrescente de 10 a 2
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        // Calcula o primeiro dígito verificador
        int primeiroDigitoVerificador = 11 - (soma % 11);
        if (primeiroDigitoVerificador >= 10) {
            primeiroDigitoVerificador = 0;
        }
        
        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            // Multiplica cada dígito por um peso decrescente de 11 a 2
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        // Calcula o segundo dígito verificador
        int segundoDigitoVerificador = 11 - (soma % 11);
        if (segundoDigitoVerificador >= 10) {
            segundoDigitoVerificador = 0;
        }
        
        // Verifica se os dígitos verificadores são iguais aos calculados
        return (cpf.charAt(9) - '0' == primeiroDigitoVerificador) && 
               (cpf.charAt(10) - '0' == segundoDigitoVerificador);
    }
}