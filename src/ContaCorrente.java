public class ContaCorrente extends Conta {

public ContaCorrente(Cliente cliente) {
    super(cliente);
}

public ContaCorrente() {  //construtor sugerido pela IDE
    super();
}

@Override
public void imprimirExtrato() {
    System.out.println("=*=*= Extrato Conta Corrente =*=*=");
    super.imprimirInfosComuns();
  
}

}
