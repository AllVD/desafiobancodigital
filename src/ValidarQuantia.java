
public class ValidarQuantia {
    public static boolean validarQuantiaInicial(double quantia) {
        return quantia >= 50;
    }

    public static boolean validarQuantiaTransferencia(double quantia, double saldo) {
        if (quantia < 0) {
            System.out.println("A quantia de transferência não pode ser negativa.");
            return false;
        } else if (quantia > saldo) {
            System.out.println("Saldo insuficiente. Seu saldo atual é: R$" + saldo);
            return false;
        }
        return true;
    }
}