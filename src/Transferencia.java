public class Transferencia {
    public static void transferir(Conta origem, Conta destino, double quantia) {
        if (Validador.validarQuantiaTransferencia(quantia, origem.getSaldo())) {
            origem.transferir(quantia, destino);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Transferência não realizada. Tente novamente.");
        }
    }
}