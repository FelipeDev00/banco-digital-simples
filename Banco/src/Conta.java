public abstract class Conta implements IConta{

    protected static final String AGENCIA_PADRAO = "0001";
    protected static int SEQUENCIAL = 0001;

    protected Cliente titular;
    protected String agencia;
    protected int numeroConta;
    protected double saldoCorrente = 0;
    protected double saldoPoupanca = 0;

    public Conta(Cliente titular) {
        this.titular = titular;
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.saldoCorrente = saldoCorrente;
        this.saldoPoupanca = saldoPoupanca;
    }

    //Getters
    public double getSaldoCorrente() {
        return saldoCorrente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldoPoupanca() {
        return saldoPoupanca;
    }

    public String getAgencia() {
        return agencia;
    }

    public Cliente getTitular() {
        return titular;
    }

    //Setters
    public void setSaldoCorrente(double saldoCorrente) {
        this.saldoCorrente = saldoCorrente;
    }

    public void setSaldoPoupanca(double saldoPoupanca) {
        this.saldoPoupanca = saldoPoupanca;
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
    public void mostrarInfos() {
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + numeroConta);
        System.out.println("Saldo: " + saldoCorrente);
    }
}
