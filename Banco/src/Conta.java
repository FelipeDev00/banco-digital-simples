public abstract class Conta implements IConta{

    private int numeroConta;
    private double saldo;

    //Getters

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    //Métodos

    @Override
    public void sacar(double valor) {

    }

    @Override
    public void depositar(double valor) {

    }

    @Override
    public void transferir(double valor, Conta contaDestino) {

    }
}
