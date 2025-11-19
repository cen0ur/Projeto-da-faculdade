# 🚗 Concessionária

Projeto em **Java** que simula o funcionamento de uma **concessionária**, permitindo gerenciar **clientes e veículos** (carros e motos) de forma simples e organizada, utilizando **Java, JDBC e PostgreSQL hospedado no NeonDB.**.

---

## 📋 Sumário
- [Sobre o Projeto](#-sobre-o-projeto)
- [Pré-Requisitos](#-funcionalidades)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Descrição das Classes](#-estrutura-do-projeto)
- [Conceitos Utilizados](#-conceitos-utilizados)

---

## 📘 Sobre o Projeto

O sistema permite:
- Cadastrar clientes PF ou PJ;
- Cadastrar veículos (carros e motos);
- Listar clientes e veículos;
- Remover clientes e veículos;
- Criar tabelas automaticamente ao iniciar

---

## 📌 Pré-Requisitos

Antes de rodar o projeto, certifique-se de ter:

| Requisito | Obrigatório | Observação |
|----------|------------|------------|
| Java JDK 17+ | ✔ | Pode usar 21, 22, 23, 24 |
| Conexão com internet | ✔ | Banco é remoto |
| Conta no NeonDB | ✔ | Banco já configurado |
| IntelliJ | Opcional | Pode rodar pelo terminal |

---
## 🏗️ Estrutura do Projeto

```bash
src/
├── application/
│   └── Main.java
├── db/
│   └── ConexaoDb.java
│   └── DatabaseSetup.java
├── model/
│ └── dao/
│   └── impl/
│       ├── ClienteDAOImpl.java
│       ├── VeiculoDAOImpl.java
│     ├── ClienteDAO.java
│     ├── VeiculoDAO.java
│ └── entities/
│     ├── Carro.java
│     ├── Cliente.java
│     ├── Moto.java
│     ├── PessoaFisica.java
│     ├── PessoaJuridica.java
│     ├── Veiculo.java
├── services/
│   └── Concessionaria.java

```

## 📌 Descrição das Classes

### **👥 Clientes**
| Classe | Função |
|--------|--------|
| `Cliente` | Classe base com atributos comuns a todos os clientes |
| `PessoaFisica` | Subclasse de `Cliente`, representa clientes com CPF |
| `PessoaJuridica` | Subclasse de `Cliente`, representa clientes com CNPJ |

---

### **🚗 Veículos**
| Classe | Função |
|--------|--------|
| `Veiculo` | Classe abstrata base para qualquer tipo de veículo |
| `Carro` | Subclasse de `Veiculo`, representa automóveis |
| `Moto` | Subclasse de `Veiculo`, representa motocicletas |

---

### **🗄 Banco de Dados**
| Classe | Função |
|--------|--------|
| `ConexaoDb` | Gerencia a conexão com o PostgreSQL usando JDBC |
| `DatabaseSetup` | Cria tabelas e inicializa o banco ao iniciar a aplicação |
| `ClienteDAO`, `VeiculoDAO` | Interfaces responsáveis por operações CRUD |
| `ClienteDAOImpl`, `VeiculoDAOImpl` | Implementação concreta das queries SQL |

---

### **🔧 Regras de Negócio**
| Classe | Função |
|--------|--------|
| `Concessionaria` | Centraliza as operações de negócio (cadastro, listagem, remoção etc.) |

---

### **📍 Execução**
| Classe | Função |
|--------|--------|
| `Main` | Ponto de entrada com menu interativo no terminal |

---


## 🧠 Conceitos Utilizados

- **Programação Orientada a Objetos (POO)**
  - Herança
  - Polimorfismo
  - Encapsulamento
  - Classes abstratas
- **Arquitetura em Camadas**
  - Camada de entidades
  - Camada de serviços
  - Camada de persistência (DAO)
- **JDBC + SQL**
  - Prepared Statements
  - CRUD no banco
- **Coleções (`ArrayList`)**
- **Interação via Terminal (`Scanner`)**
- **Boas práticas de modularização e organização de pacotes**