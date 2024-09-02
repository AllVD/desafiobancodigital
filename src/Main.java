public class Main {
    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        cc.depositar(100);
        

        Conta poupanca = new ContaPoupanca(venilton);
        
        cc.transferir(100, poupanca);

       cc.imprimirExtrato();
       poupanca.imprimirExtrato();
    }
}
