import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private static Banco instance = new Banco();
    private Lock lock;
    private Conta lojaConta;
    private Conta[] funcionarioContas;

    private Banco() {
        this.lock = new ReentrantLock();
        this.lojaConta = new Conta(0); // Conta da loja para receber pagamentos dos clientes
        this.funcionarioContas = new Conta[4]; // Contas dos funcionários
        for (int i = 0; i < 4; i++) {
            this.funcionarioContas[i] = new Conta(0);
        }
    }

    public static Banco getInstance() {
        return instance;
    }

    public Conta getLojaConta() {
        return lojaConta;
    }

    public Conta[] getFuncionarioContas() {
        return funcionarioContas;
    }

    public void transferir(Conta origem, Conta destino, double valor) {
        lock.lock();
        try {
            if (origem.getSaldo() >= valor) {
                origem.sacar(valor);
                destino.depositar(valor);
                System.out.println("Transferência de " + valor + " da conta " + origem.getId() + " para a conta "
                        + destino.getId());
            } else {
                System.out.println("Transferência não autorizada: saldo insuficiente.");
            }
        } finally {
            lock.unlock();
        }
    }

    public synchronized void pagarSalarios(Loja loja) {
        if (lojaConta.getSaldo() >= 1400 * 4) { // Verificar se a loja possui saldo suficiente para pagar os salários
                                                // dos funcionários
            for (Conta funcionarioConta : funcionarioContas) {
                transferir(lojaConta, funcionarioConta, 1400); // Pagar salário aos funcionários
            }
            System.out.println("Salários pagos.");
        }
    }
}
