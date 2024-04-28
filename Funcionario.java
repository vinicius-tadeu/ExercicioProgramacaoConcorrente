public class Funcionario implements Runnable {
    private String nome;
    private double salario;
    private Conta salarioConta;
    private Conta investimentosConta;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.salarioConta = new Conta(0); // Conta para receber o salário da loja
        this.investimentosConta = new Conta(0); // Conta de investimentos
    }

    @Override
    public void run() {
        while (true) {
            receberSalario();
            investir();
            try {
                Thread.sleep(1000); // Esperar um segundo antes de receber o próximo salário
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void receberSalario() {
        Banco banco = Banco.getInstance();
        Conta lojaConta = banco.getLojaConta(); // Obter conta da loja
        banco.transferir(lojaConta, salarioConta, salario); // Receber salário
    }

    private void investir() {
        double valorInvestimento = salario * 0.20;
        Banco banco = Banco.getInstance();
        banco.transferir(salarioConta, investimentosConta, valorInvestimento); // Transferir 20% do salário para
                                                                               // investimentos
    }
}
