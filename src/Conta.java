public abstract class Conta implements IConta {
    
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;

    }

    public Conta() { //Construtor vazio
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++

    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);//saque
        contaDestino.depositar(valor);//deposito
    
    }
    //Método Getter SEQUENCIAL
    public static int getSEQUENCIAL() {
        return SEQUENCIAL;
    //Método Getter agencia
    public int getAgencia() {
        return agencia;
    }
    //Método Getter numero
    public int getNumero() {
        return numero;
    }
    //Método Getter saldo
    public double getSaldo() {
        return saldo;
    }
    //Método Getter cliente
    public Cliente getCliente(){
        return cliente;
    }

	@Override
	public String toString() {
		return String.format("Conta{agencia=%d, numero=%d, saldo=%.2f, cliente=%s}",
            agencia, numero, saldo, cliente);
	}

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

 }

