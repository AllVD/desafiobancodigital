import java.util.List;
class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Banco banco;

    // Construtor que inicializa nome, cpf, e endereco
    public Cliente(String nome, String cpf, String endereco) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }
        if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser nulo ou vazio");
        }

        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // Construtor que inicializa nome e banco
    public Cliente(String nome, Banco banco) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }

        this.nome = nome;
        this.banco = banco;
        if (banco != null) {
            banco.addCliente(this);
        }
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return String.format("Cliente{nome='%s', cpf='%s', endereco='%s', email='%s', telefone='%s', banco=%s}",
            nome, cpf, endereco, email, telefone, banco);

}