import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = null;
        Conta contaCorrente = null;
        Conta contaPoupanca = null;

        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu Principal:");
            System.out.println("1. Gerenciar Contas");
            System.out.println("2. Outras Operações");
            System.out.println("3. Sair");

            int opcaoMenuPrincipal = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcaoMenuPrincipal) {
                case 1:
                    boolean gerenciarContas = true;
                    while (gerenciarContas) {
                        System.out.println("Gerenciar Contas:");
                        System.out.println("1. Criar Conta");
                        System.out.println("2. Fechar Conta");
                        System.out.println("3. Voltar ao Menu Principal");

                        int opcaoGerenciarContas = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha

                        switch (opcaoGerenciarContas) {
                            case 1:
                                System.out.println("Qual tipo de conta deseja criar? (1: Corrente, 2: Poupança)");
                                int tipoContaCriar = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha

                                System.out.println("Digite o nome do cliente:");
                                String nome = scanner.nextLine();
                                System.out.println("Digite o CPF do cliente:");
                                String cpf = scanner.nextLine();
                                boolean validarcpf = ValidarCPF.validarCPF(cpf);
        
                                if (validarcpf) {
                                    System.out.println("CPF válido!");
                                } else {
                                    System.out.println("CPF inválido!");
                                }
                                
                                System.out.println("Digite o endereço do cliente:");
                                String endereco = scanner.nextLine();

                                cliente = new Cliente(nome, cpf, endereco);

                                if (tipoContaCriar == 1) {
                                    contaCorrente = new ContaCorrente(cliente);
                                    System.out.println("Conta Corrente criada. Número: " + contaCorrente.getNumero() + ", Agência: " + contaCorrente.getAgencia());
                                    System.out.println("Saldo: " + contaCorrente.getSaldo());
                                } else if (tipoContaCriar == 2) {
                                    contaPoupanca = new ContaPoupanca(cliente);
                                    System.out.println("Conta Poupança criada. Número: " + contaPoupanca.getNumero() + ", Agência: " + contaPoupanca.getAgencia());
                                    System.out.println("Saldo: " + contaPoupanca.getSaldo());
                                }
                                break;
                            case 2:
                                System.out.println("Qual tipo de conta deseja fechar? (1: Corrente, 2: Poupança)");
                                int tipoContaFechar = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha

                                if (tipoContaFechar == 1 && contaCorrente != null && contaCorrente.getSaldo() == 0) {
                                    contaCorrente = null;
                                    System.out.println("Conta Corrente fechada.");
                                } else if (tipoContaFechar == 2 && contaPoupanca != null && contaPoupanca.getSaldo() == 0) {
                                    contaPoupanca = null;
                                    System.out.println("Conta Poupança fechada.");
                                } else {
                                    System.out.println("Não é possível fechar a conta. Certifique-se de que a conta existe e está vazia.");
                                }
                                break;
                            case 3:
                                gerenciarContas = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean outrasOperacoes = true;
                    while (outrasOperacoes) {
                        System.out.println("Outras Operações:");
                        System.out.println("1. Depositar");
                        System.out.println("2. Sacar");
                        System.out.println("3. Transferir para Conta Poupança");
                        System.out.println("4. Transferir da Poupança para Conta Corrente");
                        System.out.println("5. Imprimir Extrato");
                        System.out.println("6. Voltar ao Menu Principal");

                        int opcaoOutrasOperacoes = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha

                        switch (opcaoOutrasOperacoes) {
                            case 1:
                                System.out.println("Em qual conta deseja depositar? (1: Corrente, 2: Poupança)");
                                int tipoContaDepositar = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha

                                System.out.println("Digite o valor do depósito:");
                                double valorDeposito = scanner.nextDouble();
                                scanner.nextLine(); // Consumir a nova linha

                                if (tipoContaDepositar == 1 && contaCorrente != null) {
                                    contaCorrente.depositar(valorDeposito);
                                    System.out.println("Depósito realizado na Conta Corrente. Saldo: " + contaCorrente.getSaldo());
                                } else if (tipoContaDepositar == 2 && contaPoupanca != null) {
                                    contaPoupanca.depositar(valorDeposito);
                                    System.out.println("Depósito realizado na Conta Poupança. Saldo: " + contaPoupanca.getSaldo());
                                } else {
                                    System.out.println("Conta não encontrada.");
                                }
                                break;
                            case 2:
                                System.out.println("De qual conta deseja sacar? (1: Corrente, 2: Poupança)");
                                int tipoContaSacar = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha

                                System.out.println("Digite o valor do saque:");
                                double valorSaque = scanner.nextDouble();
                                scanner.nextLine(); // Consumir a nova linha

                                if (tipoContaSacar == 1 && contaCorrente != null) {
                                    contaCorrente.sacar(valorSaque);
                                    System.out.println("Saque realizado da Conta Corrente. Saldo: " + contaCorrente.getSaldo());
                                } else if (tipoContaSacar == 2 && contaPoupanca != null) {
                                    contaPoupanca.sacar(valorSaque);
                                    System.out.println("Saque realizado da Conta Poupança. Saldo: " + contaPoupanca.getSaldo());
                                } else {
                                    System.out.println("Conta não encontrada ou saldo insuficiente.");
                                }
                                break;
                            case 3:
                                if (contaCorrente != null) {
                                    if (contaPoupanca == null) {
                                        System.out.println("Conta Poupança não encontrada. Deseja criar uma nova conta poupança? (1: Sim, 2: Não)");
                                        int criarContaPoupanca = scanner.nextInt();
                                        scanner.nextLine(); // Consumir a nova linha

                                        if (criarContaPoupanca == 1) {
                                            contaPoupanca = new ContaPoupanca(cliente);
                                            System.out.println("Conta Poupança criada. Número: " + contaPoupanca.getNumero() + ", Agência: " + contaPoupanca.getAgencia());
                                            System.out.println("Saldo: " + contaPoupanca.getSaldo());
                                        } else {
                                            System.out.println("Operação cancelada.");
                                            break;
                                        }
                                    }

                                    System.out.println("Digite o valor a transferir para a Conta Poupança:");
                                    double valorTransferencia = scanner.nextDouble();
                                    scanner.nextLine(); // Consumir a nova linha

                                    if (contaCorrente.getSaldo() >= valorTransferencia) {
                                        contaCorrente.sacar(valorTransferencia);
                                        contaPoupanca.depositar(valorTransferencia);
                                        System.out.println("Transferência realizada. Saldo Conta Corrente: " + contaCorrente.getSaldo() + ", Saldo Conta Poupança: " + contaPoupanca.getSaldo());
                                    } else {
                                        System.out.println("Saldo insuficiente na Conta Corrente.");
                                    }
                                } else {
                                    System.out.println("Conta Corrente não encontrada.");
                                }
                                break;
                            case 4:
                                if (contaPoupanca != null && contaCorrente != null) {
                                    System.out.println("Digite o valor a transferir para a Conta Corrente:");
                                    double valorTransferencia = scanner.nextDouble();
                                    scanner.nextLine(); // Consumir a nova linha

                                    if (contaPoupanca.getSaldo() >= valorTransferencia) {
                                        contaPoupanca.sacar(valorTransferencia);
                                        contaCorrente.depositar(valorTransferencia);
                                        System.out.println("Transferência realizada. Saldo Conta Poupança: " + contaPoupanca.getSaldo() + ", Saldo Conta Corrente: " + contaCorrente.getSaldo());
                                    } else {
                                        System.out.println("Saldo insuficiente na Conta Poupança.");
                                    }
                                } else {
                                    System.out.println("Contas não encontradas.");
                                }
                                break;
                            case 5:
                                System.out.println("De qual conta deseja ver o extrato? (1: Corrente, 2: Poupança, 3: Ambas)");
                                int tipoContaExtrato = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha

                                if (tipoContaExtrato == 1 && contaCorrente != null) {
                                    contaCorrente.imprimirExtrato();
                                } else if (tipoContaExtrato == 2 && contaPoupanca != null) {
                                    contaPoupanca.imprimirExtrato();
                                } else if (tipoContaExtrato == 3) {
								if (contaCorrente != null) contaCorrente.imprimirExtrato();
                                if (contaPoupanca != null) contaPoupanca.imprimirExtrato();
                            } else {
                                System.out.println("Conta não encontrada.");
                            }
                            break;
                        case 6:
                            outrasOperacoes = false;
                            break;
                    }
                }
                break;
            case 3:
                continuar = false;
                break;
        }
    }
    scanner.close();
    }
}