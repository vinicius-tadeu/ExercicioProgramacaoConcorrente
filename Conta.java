public class Conta {
    private static int nextId = 1;
    private int id;
    private double saldo;

    public Conta(double saldoInicial) {
        this.id = nextId++;
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(double valor) {
        saldo += valor;
    }

    public synchronized void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public int getId() {
        return id;
    }
}
