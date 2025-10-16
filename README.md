# 🚗 Concessionária

Projeto em **Java** que simula o funcionamento de uma **concessionária**, permitindo gerenciar **clientes e veículos** (carros e motos) de forma simples e organizada, utilizando **Programação Orientada a Objetos (POO)**.

---

## 📋 Sumário
- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Conceitos Utilizados](#-conceitos-utilizados)
- [Como Executar](#-como-executar)

---

## 📘 Sobre o Projeto

O sistema permite:
- Cadastrar clientes PF ou PJ;
- Cadastrar veículos (carros e motos);
- Listar clientes e veículos;
- Remover clientes e veículos;
- Toda lógica está organizada em **classes específicas** e **delegada à Concessionaria**, mantendo o `Main` apenas como interface com o usuário.

---

## ⚙️ Funcionalidades
| Funcionalidade | Status |
|----------------|--------|
| Cadastro de clientes (PF/PJ) | ✅ Implementado |
| Cadastro de veículos (Carro/Moto) | ✅ Implementado |
| Listagem de clientes | ✅ Implementado |
| Listagem de veículos | ✅ Implementado |
| Remoção de clientes por nome | ✅ Implementado |
| Remoção de veículos por modelo | ✅ Implementado |

---

## 🏗️ Estrutura do Projeto

```bash
src/
├── application/
│ └── Main.java
├── model/
│ └── entites/
│ ├── Cliente.java
│ ├── PessoaFisica.java
│ ├── PessoaJuridica.java
│ ├── Veiculo.java
│ ├── Carro.java
│ ├── Moto.java
│ └── Concessionaria.java


**Descrição das classes:**
- `Cliente`: classe base para clientes.  
- `PessoaFisica` / `PessoaJuridica`: subclasses de `Cliente` com CPF ou CNPJ.  
- `Veiculo`: classe base para veículos.  
- `Carro` / `Moto`: subclasses de `Veiculo`.  
- `Concessionaria`: gerencia listas de clientes e veículos.  
- `Main`: ponto de entrada e interface via terminal.

```

## 🧠 Conceitos Utilizados
- Programação Orientada a Objetos (POO)
  - Herança
  - Polimorfismo
  - Encapsulamento
- Coleções (`ArrayList`)  
- Entrada de dados via `Scanner`  
- Boas práticas de organização de código