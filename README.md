# Pré-requisitos
Antes de iniciar, verifique se você possui os seguintes requisitos instalados:

JDK 17 ou superior
Maven 3.6 ou superior
MySQL 8.0 ou superior
Conta na AWS com acesso ao serviço S3
IDE de sua preferência (recomendado: IntelliJ IDEA, Eclipse)
Configuração do Banco de Dados
Criação do Banco de Dados:

Execute o script SQL fornecido (script.sql) para criar o banco de dados ms_customer e a tabela customer.
Configure o acesso ao banco de dados MySQL no arquivo application.properties.

## Configuração do arquivo application.properties:
 Configurações do banco de dados MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/payment_db
spring.datasource.username=root
spring.datasource.password=luana123

# Configurações do Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Configuração do RabbitMQ
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest


# Logging
logging.level.org.springframework=INFO
logging.level.com.bancoamericano=DEBUG


## Como Acessar o Projeto:

Para acessar e executar o projeto localmente, siga estas etapas:
# Clone o repositório:
git clone https://github.com/seu_usuario/ms-customer.git
cd ms-customer

# Importe o projeto na sua IDE:
Abra o projeto na sua IDE escolhida (por exemplo, IntelliJ IDEA).
Aguarde a IDE baixar as dependências do Maven.
Configure as variáveis de ambiente AWS:

# Configure as variáveis de ambiente AWS_ACCESS_KEY_ID e AWS_SECRET_ACCESS_KEY com suas credenciais da AWS. (deixei só o exemplo porquê o acesso não pode ser vazado).

## Execute o projeto:
Execute a classe principal CustomerApplication.java como uma aplicação Spring Boot.

## Teste a funcionalidade de upload de imagem:
# Utilize ferramentas como Postman para enviar uma requisição POST para http://localhost:8080/v1/customers com um corpo JSON contendo os dados do cliente e a imagem em base64.

## Verifique o armazenamento da imagem no Amazon S3:
# Após o upload, verifique no console da AWS se a imagem foi armazenada com sucesso no bucket configurado.
