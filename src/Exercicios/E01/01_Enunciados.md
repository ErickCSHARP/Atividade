# Exercício de POO em Java — Herança, Sobrescrita e Encapsulamento

Objetivo: analisar duas classes e identificar a superclasse, a subclasse, o método sobrescrito e os métodos utilizados para acessar atributos protegidos por encapsulamento.

O exercício foi elaborado para exigir interpretação. Não presuma que a classe mais genérica pelo nome seja necessariamente a classe pai. Analise os atributos, os métodos e o relacionamento entre as classes.

## 1. Código para análise

Considere as seguintes classes Java:

```java

public class ContaEspecial 
{
    private String titular;
    private double saldo;
    private double limite;

    public ContaEspecial(String titular, double saldo, double limite) 
    {
        this.titular = titular;
        this.saldo = saldo;
        this.limite = limite;
    }

    public String getTitular() 
    { 
        return titular; 
    }
    public double getSaldo() 
    { 
        return saldo; 
    }
    public double getLimite() 
    { 
        return limite; 
    }

    public void depositar(double valor) 
    {
        if (valor > 0) saldo += valor;
    }

    public boolean sacar(double valor) 
    {
        if (valor > 0 && valor <= saldo + limite) 
        {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public String consultar() 
    {
        return "Titular: " + titular + " | Saldo: R$ " + saldo;
    }
}

```

```java

public class ContaUniversitaria extends ContaEspecial 
{
    private int semestre;

    public ContaUniversitaria(String titular, double saldo, double limite, int semestre) 
    {
        super(titular, saldo, limite);
        this.semestre = semestre;
    }

    public int getSemestre() 
    { 
        return semestre; 
    }

    public boolean sacar(double valor) 
    {
        if (valor > 0 && valor <= getSaldo() + getLimite()) 
        {
            if (getSaldo() - valor < -getLimite() / 2) return false;
            return super.sacar(valor);
        }
        return false;
    }

    public String consultar() 
    {
        return super.consultar() + " | Semestre: " + semestre;
    }
}

```

## 2. Questões para o aluno

1\. Qual das duas classes é a superclasse? Justifique sua resposta com base no código.
<details>
  <summary>Resposta</summary>

**Superclasse** \
`ContaEspecial`, pois é a classe estendida pela classe `ContaUniversitaria` e fornece atributos e métodos que ela pode herdar.

</details>
<br><br>

2\. Qual das duas classes é a subclasse (classe filha)? Qual elemento do código comprova isso?
<details>
  <summary>Resposta</summary>

**Subclasse** \
`ContaUniversitaria`, pois a declaração `extends ContaEspecial` indica que ela herda de `ContaEspecial`.
</details>
<br><br>

3\. Quais métodos da classe filha sobrescrevem métodos da classe pai? Explique como você identificou cada um.
<details>
  <summary>Resposta</summary>

**Métodos sobrescritos** \

- `sacar(double valor)`
- `consultar()`

Ambos possuem a mesma assinatura dos métodos herdados e são marcados com `@Override`.
</details>
<br><br>

4\. Quais métodos permitem consultar os atributos privados da superclasse sem acessá-los diretamente?
<details>
  <summary>Resposta</summary>

**
Os métodos `getTitular()`, `getSaldo()` e `getLimite()` permitem acessar os atributos privados da superclasse de forma indireta.

- `getTitular()`
- `getSaldo()`
- `getLimite()`

São métodos getters, que permitem consultar os valores dos atributos privados.

</details>  
<br><br>

5\. Os atributos titular, saldo e limite são protected? Explique qual é o modificador de acesso utilizado e por que isso importa.
<details>
  <summary>Resposta</summary>

**Encapsulamento** \
Os atributos são `private`, e não `protected`. Isso significa que não podem ser acessados diretamente pela subclasse. O modificador `protected` permitiria acesso direto pela subclasse.
</details>
<br><br>

6\. A classe ContaUniversitaria pode acessar diretamente o atributo saldo? Por que ela utiliza getSaldo() em vez de acessar saldo diretamente?
<details>
  <summary>Resposta</summary>

Não, a classe `ContaUniversitaria` não pode acessar diretamente o atributo `saldo`, pois ele é `private` na superclasse. Por isso, utiliza o método `getSaldo()` para obter o valor de forma indireta.
</details>
<br><br>

7\. Qual é a função da palavra-chave super no construtor e nos métodos sobrescritos?
<details>
  <summary>Resposta</summary>

A palavra-chave `super` é usada para chamar o construtor da superclasse e para acessar métodos da superclasse que foram sobrescritos na subclasse.
</details>
<br><br>

8\. O método depositar() foi sobrescrito na classe filha? Justifique sua resposta.
<details>
  <summary>Resposta</summary>

Não, o método `depositar()` não foi sobrescrito na classe `ContaUniversitaria`. Ele é herdado da superclasse `ContaEspecial` sem alterações.
</details>
<br><br>

9\. Uma ContaUniversitaria também pode utilizar o método depositar(), embora ele não esteja declarado em sua classe? Explique.
<details>
  <summary>Resposta</summary>

Sim, uma `ContaUniversitaria` pode utilizar o método `depositar()` porque ele é herdado da superclasse `ContaEspecial`.
</details>
<br><br>

10\. Qual é a regra adicional de saque implementada pela classe ContaUniversitaria em relação à classe ContaEspecial?
<details>
  <summary>Resposta</summary>

A classe `ContaUniversitaria` adiciona a regra de que o saque não pode resultar em um saldo menor que metade do limite negativo.
</details>
<br><br>

&#x20;Copiar respostas

## 3. Desafio extra

Sem executar o programa, responda:

1. Se o objeto for uma `ContaUniversitaria`, qual implementação de `consultar()` será executada?
2. O método `sacar()` da classe filha substitui completamente o comportamento do método da classe pai ou também aproveita parte dele?
3. Por que o uso de `@Override` ajuda a evitar erros de programação?

## Gabarito do professor

Consulte após o aluno concluir o exercício.

1\. Superclasse

`ContaEspecial`, pois é a classe estendida pela classe `ContaUniversitaria` e fornece atributos e métodos que ela pode herdar.

2\. Subclasse

`ContaUniversitaria`. A declaração `extends ContaEspecial` estabelece explicitamente a herança.

3\. Métodos sobrescritos

- `sacar(double valor)`
- `consultar()`

Ambos possuem a mesma assinatura dos métodos herdados e são marcados com `@Override`.

4\. Métodos de acesso aos atributos

- `getTitular()`
- `getSaldo()`
- `getLimite()`

São métodos getters, que permitem consultar os valores dos atributos privados.

5\. Encapsulamento

Os atributos são `private`, e não `protected`. Portanto, não podem ser acessados diretamente pela subclasse. Acesso `protected` permitiria acesso direto pela subclasse, conforme as regras de visibilidade do Java.

6\. Acesso ao saldo

A classe filha utiliza `getSaldo()` porque `saldo` é privado na superclasse.

7\. Palavra-chave `super`

- `super(...)` chama o construtor da superclasse.
- `super.sacar(valor)` chama a implementação de saque da superclasse.
- `super.consultar()` reutiliza a consulta da superclasse.

8\. Método `depositar()`

Não. Ele é herdado, pois a classe filha não declara uma nova implementação desse método.

9\. Herança de métodos

Sim. A classe `ContaUniversitaria` herda `depositar()` de `ContaEspecial` e pode utilizá-lo.

10\. Regra adicional de saque

A classe universitária impede determinados saques que ultrapassariam metade do limite negativo permitido, além das verificações realizadas pela superclasse.

Desafio extra

1. Executa-se `consultar()` de `ContaUniversitaria`, devido à sobrescrita.
2. O método `sacar()` acrescenta uma regra e depois chama `super.sacar(valor)` para aproveitar a implementação da classe pai.
3. `@Override` permite ao compilador verificar se existe um método herdado compatível para sobrescrever.

Observação didática: este exemplo também permite discutir uma distinção importante: encapsulamento não é sinônimo de `protected`. Neste código, os atributos são privados e o acesso controlado ocorre por métodos públicos.