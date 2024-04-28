public class Loja {
    private Conta conta;
    private double salarioFuncionario = 1400; // Salário dos funcionários

    public Loja(double saldoInicial) {
        this.conta = new Conta(saldoInicial);
    }

    public Conta getConta() {
        return conta;
    }

    public void processarCompra(double valor) {
        conta.depositar(valor); // Receber pagamento dos clientes
        pagarSalarios(); // Verificar se é possível pagar salários
    }

    private void pagarSalarios() {
        Banco banco = Banco.getInstance();
        if (conta.getSaldo() >= salarioFuncionario * 2) { // Verificar se a loja possui saldo suficiente para pagar os
                                                          // salários dos funcionários
            for (Conta funcionarioConta : banco.getFuncionarioContas()) {
                banco.transferir(conta, funcionarioConta, salarioFuncionario); // Pagar salário aos funcionários
            }
        }
    }
}
