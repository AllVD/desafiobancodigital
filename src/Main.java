//import java.text.NumberFormat;
//import java.util.Scanner;
public class Main {
    public static void main(String[] args){ 
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        /*ContaCorrente*/ /*IConta*/ 
        Conta cc = new ContaCorrente();
        cc.depositar(100);
        /*ContaPoupanca*/ /*IConta*/ 
        Conta poupanca = new ContaPoupanca();
        cc.transferir(100, poupanca);
        
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}