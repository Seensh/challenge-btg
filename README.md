# challenge-btg

## Exemplo de payloads:
O Cadastro do pedido e do cliente serão previamente criados antes de publicar e consumir as mensagens pela fila:
```
// Cadastro Cliente
POST:
http://localhost:8080/api/clientes
Body:
{
    "nome": "Felipe Barbosa dos Santos",
    "email": "felipe.barbosa@gmail.com",
    "telefone": "11983211234"
}

// Cadastro de Pedidos
POST:
http://localhost:8080/api/pedidos
Body:
{
    "codigoCliente":"1"
}

// Busca Pedido por ID
GET:
http://localhost:8080/api/pedidos/1

// Lista Pedidos por ID Cliente
GET:
http://localhost:8080/api/clientes/1

// Quantidade de Pedidos por Cliente
GET:
http://localhost:8080/api/clientes/1/quantidade/pedidos

// Valor total do pedido
GET:
http://localhost:8080/api/pedidos/valorTotal/1


// Exemplo de mensagem para ser postada:
{ 
    "codigoPedido": 1, 
    "codigoCliente":1, 
    "itens": [ 
        { 
            "produto": "lápis", 
            "quantidade": 100, 
            "preco": 1.10 
        }, 
        { 
            "produto": "caderno", 
            "quantidade": 10, 
            "preco": 1.00 
        } 
    ] 
}

```

Nome da fila:
pedidos-request-queue

Nome do banco de dados:
banco_btg

Collection postman: [ChallengeBTG.postman_collection.json](ChallengeBTG.postman_collection.json)

Script banco de dados:
[script-banco-btg.sql](script-banco-btg.sql)
