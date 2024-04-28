import java.util.Random;

public class Cliente implements Runnable {
    private String nome;
    private Conta conta;

    public Cliente(String nome, double saldoInicial) {
        this.nome = nome;
        this.conta = new Conta(saldoInicial);
    }

    @Override
    public void run() {
        Loja[] lojas = { new Loja(0), new Loja(0) };
        Random random = new Random();

        while (conta.getSaldo() > 0) {
            Loja loja = lojas[random.nextInt(lojas.length)]; // Selecionar uma loja aleatória
            double valorCompra = conta.getSaldo() >= 200 ? 200 : 100; // Se o saldo for suficiente para R$200,00,
                                                                      // comprar R$200,00, caso contrário, comprar
                                                                      // R$100,00
            Banco banco = Banco.getInstance();
            banco.transferir(conta, loja.getConta(), valorCompra);
        }
    }

    public Conta getConta() {
        return conta;
    }
}
