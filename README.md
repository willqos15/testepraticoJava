# Teste Técnico — Desenvolvedor Full Stack Jr

Projeto desenvolvido para o teste prático de programação da **Prothera**.

O projeto foi desenvolvido em **Java**, utilizando orientação a objetos e as classes e estruturas solicitadas no enunciado.

## Dados fornecidos no teste

A tabela abaixo contém os funcionários fornecidos no enunciado do teste:

![Tabela de funcionários](https://bucket-custom-test-images-prod.gupy.io/production/companies/17494/images/custom-test-102943-question-eee278f5-a195-4265-956e-dcfcef31bafb.png)

## Tecnologias utilizadas

* Java
* `LocalDate` para manipulação de datas
* `BigDecimal` para valores monetários
* `List` para armazenamento dos funcionários
* `Map` para agrupamento por função
* `DateTimeFormatter` para formatação de datas
* `NumberFormat` para formatação de valores

## Estrutura do projeto

```text
src/
├── Main.java
├── Pessoa.java
├── Funcionario.java
└── DadosFuncionarios.java
```

### Pessoa

Classe responsável pelos dados básicos de uma pessoa:

* Nome
* Data de nascimento

### Funcionario

Estende a classe `Pessoa` e adiciona:

* Salário
* Função

### DadosFuncionarios

Contém os dados iniciais dos funcionários utilizados no teste.

Os dados foram mantidos em uma classe separada para facilitar a organização, manutenção e atualização das informações, evitando misturar os dados com a lógica principal da aplicação.

### Main

Classe principal responsável pela execução das operações solicitadas.

## Requisitos implementados

### 3.1 — Inserir funcionários

Os funcionários são carregados a partir da classe `DadosFuncionarios` e transformados em objetos `Funcionario`.

### 3.2 — Remover João

O funcionário **João** é removido da lista utilizando `removeIf()`.

### 3.3 — Imprimir funcionários

Todos os funcionários são exibidos com:

* Nome
* Data de nascimento no formato `dd/MM/yyyy`
* Salário com separador de milhar e decimal no padrão brasileiro
* Função

Exemplo:

```text
Nome: Maria | Data de nascimento: 18/10/2000 | Salário: R$ 2.009,44 | Função: Operador
```

### 3.4 — Aumento salarial

Todos os funcionários recebem um aumento de **10%**, com os novos valores sendo atualizados na lista.

### 3.5 — Agrupar por função

Os funcionários são agrupados em um:

```java
Map<String, List<Funcionario>>
```

A função é utilizada como chave e a lista de funcionários como valor.

### 3.6 — Imprimir funcionários agrupados

Os funcionários são exibidos separados de acordo com suas respectivas funções.

### 3.8 — Aniversariantes

São exibidos os funcionários que fazem aniversário nos meses:

* Outubro
* Dezembro

### 3.9 — Funcionário mais velho

É identificado o funcionário com a maior idade, sendo exibidos:

* Nome
* Idade

A idade é calculada utilizando `Period` e `LocalDate`.

### 3.10 — Ordem alfabética

A lista de funcionários é ordenada alfabeticamente pelo nome.

### 3.11 — Total dos salários

É calculado o valor total dos salários dos funcionários após a remoção de João e a aplicação do aumento de 10%.

### 3.12 — Salários mínimos

É calculada a quantidade de salários mínimos recebida por cada funcionário, considerando:

```text
Salário mínimo = R$ 1.212,00
```

O resultado é apresentado com duas casas decimais.

## Como executar

É necessário ter o **Java JDK** instalado na máquina.

Pelo terminal, entre na pasta que contém os arquivos `.java` e compile:

```bash
javac *.java
```

Depois execute:

```bash
java Main
```

Também é possível abrir o projeto em uma IDE como:

* IntelliJ IDEA
* Eclipse
* Apache NetBeans
* Visual Studio Code com suporte ao Java

## Observações

O projeto foi desenvolvido mantendo a implementação próxima aos requisitos apresentados no teste, utilizando recursos nativos do Java e sem dependências externas.

Foi decidido manter os dados iniciais dos funcionários na classe `DadosFuncionarios.java`, separada da classe `Main`, para ter maior controle sobre as informações e facilitar a manutenção do projeto. Dessa forma, alterações nos dados dos funcionários podem ser realizadas sem modificar diretamente a lógica principal responsável pela execução das operações.

A execução do programa apresenta no console cada etapa do teste, identificada conforme os itens do enunciado.

---

# Enunciado original do teste

> **TESTE PRÁTICO PROGRAMAÇÃO**
>
> Considerando que uma indústria possui as pessoas/funcionários abaixo:
>
> Diante disso, você deve desenvolver um projeto java, com os seguintes requisitos:
>
> **1 – Classe Pessoa** com os atributos: nome (`String`) e data nascimento (`LocalDate`).
>
> **2 – Classe Funcionário** que estenda a classe Pessoa, com os atributos: salário (`BigDecimal`) e função (`String`).
>
> **3 – Deve conter uma classe Principal** para executar as seguintes ações:
>
> **3.1** – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
>
> **3.2** – Remover o funcionário “João” da lista.
>
> **3.3** – Imprimir todos os funcionários com todas suas informações, sendo que:
>
> * informação de data deve ser exibida no formato `dd/mm/aaaa`;
> * informação de valor numérico deve ser exibida formatada com separador de milhar como ponto e decimal como vírgula.
>
> **3.4** – Os funcionários receberam 10% de aumento de salário. Atualizar a lista de funcionários com novo valor.
>
> **3.5** – Agrupar os funcionários por função em um `MAP`, sendo a chave a “função” e o valor a “lista de funcionários”.
>
> **3.6** – Imprimir os funcionários, agrupados por função.
>
> **3.8** – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
>
> **3.9** – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
>
> **3.10** – Imprimir a lista de funcionários por ordem alfabética.
>
> **3.11** – Imprimir o total dos salários dos funcionários.
>
> **3.12** – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é `R$ 1.212,00`.
>
> ## Orientações gerais
>
> * Você poderá utilizar a ferramenta que tem maior domínio (exemplos: Eclipse, NetBeans etc.).
> * Após finalizado o desenvolvimento, exportar o projeto e encaminhar o link do seu teste aqui mesmo na etapa **Mão na Massa 🖐**.
> * Basta colar o link ainda aqui nessa etapa.
> * Assim que recebermos seu projeto desenvolvido, será agendada uma entrevista com nosso time técnico para avaliação.
>
> Esperamos que você use todo seu conhecimento e criatividade nesse teste.
>
> Caso você não souber resolver determinado requisito, comente no código que aquele item você não sabe como desenvolver, e vá para o próximo. Avaliaremos o que você conseguiu desenvolver e como foi desenvolvido.
>
> **Boa sorte!**
