public abstract class Conta implements IConta{

    protected static final String AGENCIA_PADRAO = "0001";
    protected static int SEQUENCIAL = 0001;

    private String agencia;
    private int numero;
    private double saldoCorrente;
    private double saldoPoupanca;

    public Conta() {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.SEQUENCIAL++;
    }

    //Getters
    public int getNumeroConta() {
        return numero;
    }

    public double getSaldo() {
        return saldoCorrente;
    }

    public int getNumero() {
        return numero;
    }

    //Setters
    public void setSaldoCorrente(double saldoCorrente) {
        this.saldoCorrente = saldoCorrente;
    }

    public void setSaldoPoupanca(double saldoPoupanca) {
        this.saldoPoupanca = saldoPoupanca;
    }

    public void setNumeroConta(int numero) {
        this.numero = numero;
    }

    //Métodos
    @Override
    public void sacar(double valor) {
        saldoCorrente -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldoCorrente += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        sacar(valor);
        contaDestino.depositar(valor);

    }
}
