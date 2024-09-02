import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    //Método Getter
    public String getNome() {
        return nome;
    }
    //Método Setter
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Conta> getContas() {
        return new ArrayList<>(contas);
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
    // Método Getter para os clientes
    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }
    // Método Setter para os clientes
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    // Método para adicionar um cliente
     public void addCliente(Cliente cliente) {
        if (cliente != null) {
            clientes.add(cliente);
        } else {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
    }

    public void mostrarClientes() {
        for (Cliente cliente : clientes){
            System.out.println(cliente);
        }
        
    }


}
