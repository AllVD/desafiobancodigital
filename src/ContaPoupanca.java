public class ContaPoupanca extends Conta {
    
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public ContaPoupanca() { //construtor vazio
        super();
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=*=*= Extrato Conta Poupanca =*=*=");
        super.imprimirInfosComuns();

    }

}

