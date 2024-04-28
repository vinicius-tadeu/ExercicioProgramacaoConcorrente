public class Main {
    public static void main(String[] args) {
        Banco banco = Banco.getInstance();

        // Criando as lojas
        Loja loja1 = new Loja(0);
        Loja loja2 = new Loja(0);

        // Criando os funcionários
        Funcionario funcionario1Loja1 = new Funcionario("Funcionário 1 da Loja 1", 1400);
        Funcionario funcionario2Loja1 = new Funcionario("Funcionário 2 da Loja 1", 1400);
        Funcionario funcionario1Loja2 = new Funcionario("Funcionário 1 da Loja 2", 1400);
        Funcionario funcionario2Loja2 = new Funcionario("Funcionário 2 da Loja 2", 1400);

        // Iniciando funcionários
        Thread threadFuncionario1Loja1 = new Thread(funcionario1Loja1);
        Thread threadFuncionario2Loja1 = new Thread(funcionario2Loja1);
        Thread threadFuncionario1Loja2 = new Thread(funcionario1Loja2);
        Thread threadFuncionario2Loja2 = new Thread(funcionario2Loja2);

        threadFuncionario1Loja1.start();
        threadFuncionario2Loja1.start();
        threadFuncionario1Loja2.start();
        threadFuncionario2Loja2.start();

        // Criando os clientes
        Cliente[] clientes = {
                new Cliente("Cliente 1", 1000),
                new Cliente("Cliente 2", 1000),
                new Cliente("Cliente 3", 1000),
                new Cliente("Cliente 4", 1000),
                new Cliente("Cliente 5", 1000)
        };

        // Iniciando clientes
        for (Cliente cliente : clientes) {
            Thread thread = new Thread(cliente);
            thread.start();
        }

        // Realizando as operações até que todos os clientes tenham feito suas compras
        boolean clientesAtivos = true;
        while (clientesAtivos) {
            clientesAtivos = false;
            for (Cliente cliente : clientes) {
                if (cliente.getConta().getSaldo() > 0) {
                    clientesAtivos = true;
                    break;
                }
            }
        }

        // Pagar salários às lojas
        banco.pagarSalarios(loja1);
        banco.pagarSalarios(loja2);
    }
}
