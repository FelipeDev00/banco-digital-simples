public class Cliente extends Conta{

    private String nome;
    private String cpf;
    private String dataNascimento;
    private int conta;
    private String agencia;

    public Cliente(String nome, String cpf, String dataNascimento, int conta, String agencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.conta = Conta.SEQUENCIAL;
        this.agencia = Conta.AGENCIA_PADRAO;
    }
    //Getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getAgencia() {
        return agencia;
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Clientes: " + nome + " /" + cpf + " /" + dataNascimento + "\n";

    }
}
