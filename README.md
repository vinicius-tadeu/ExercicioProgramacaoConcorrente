# Sistema Bancário Multithread em Java

Este é um sistema bancário desenvolvido em Java que simula o funcionamento de um banco com múltiplas lojas, funcionários e clientes, utilizando threads para representar cada entidade do sistema.

## Funcionalidades

O sistema contém as seguintes funcionalidades:

- **Banco**: Gerencia as transações entre contas de forma síncrona e coordenada, garantindo a consistência dos saldos das contas.
- **Loja**: Recebe os pagamentos dos clientes e paga os salários dos funcionários quando necessário.
- **Funcionário**: Possui contas para receber salários da loja e fazer investimentos.
- **Cliente**: Realiza compras em diferentes lojas até que o saldo de sua conta seja zero.
- **Conta**: Representa a conta de um cliente ou loja, com métodos para depositar, sacar e verificar o saldo.

## Como usar

1. Compile todos os arquivos Java.
2. Execute o arquivo Main para iniciar o programa.

## Funcionamento

Ao executar o programa, ele cria um banco, duas lojas e quatro funcionários. Em seguida, inicia várias threads para representar clientes que realizam compras em diferentes lojas. Os clientes alternam entre as lojas e gastam seu saldo até que seja zero.

Depois que todos os clientes terminam suas compras, o sistema verifica se as lojas têm saldo suficiente para pagar os salários dos funcionários. Se houver saldo suficiente, os salários são pagos e as transações são registradas, exibindo o valor das transferências e o saldo final de cada conta.

O sistema continua até que todas as transações sejam concluídas e os saldos finais estejam consistentes.
