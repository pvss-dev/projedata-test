# Teste Prático - Projedata Informática

Projeto desenvolvido em Java para atender aos requisitos do teste técnico.

## Estrutura do Projeto

```
src/
├── model/
│   ├── Pessoa.java
│   └── Funcionario.java
├── service/
│   └── FuncionarioService.java
├── util/
│   └── Formatador.java
└── Principal.java
```

## Como executar

### 1. Compilar

```bash
javac -d out src/model/*.java src/service/*.java src/util/*.java src/Principal.java
````

### 2. Executar

```bash
java -cp out Principal
```