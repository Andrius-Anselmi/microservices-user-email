# Comunicação Assíncrona com RabbitMQ e Microsserviços

🚧 Projeto em desenvolvimento

Este projeto tem como objetivo estudar comunicação assíncrona entre microsserviços utilizando Java, Spring Boot e RabbitMQ.

A aplicação simula o fluxo de cadastro de usuários, onde um microsserviço publica um evento no RabbitMQ e outro serviço consome essa mensagem para realizar o envio de um e-mail de boas-vindas.

## Conceitos estudados

- Producers e Consumers
- Exchanges
- Routing Keys
- Filas (Queues)
- Comunicação assíncrona
- Desacoplamento entre microsserviços

## Demonstração

Vídeo mostrando o funcionamento da arquitetura:

🔗 Link do vídeo: [https://www.linkedin.com/posts/andrius-anselmi_java-springboot-rabbitmq-ugcPost-7483593188683833344-X1FI/?utm_source=share&utm_medium=member_desktop&rcm=ACoAADDOeXwB7XbJPp6DogDxIXBbY35oNW8uI0o]

## Próximos passos

- [ ] Finalizar implementação dos serviços
- [ ] Adicionar testes automatizados
- [ ] Melhorar tratamento de erros
- [ ] Adicionar Docker Compose para subir o ambiente completo
