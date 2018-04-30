package model;
public class ClienteBEAN {
    private int id;
    private String nome;
    private String nascimento;
    private String nomeMae;
    private String cpf;

    public ClienteBEAN(int id, String nome, String nascimento, String nomeMae, String cpf) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.nomeMae = nomeMae;
        this.cpf = cpf;
    }

    public ClienteBEAN() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
