O ideal é fazer a pessoa prever qual método será executado, diferenciar o tipo da variável(declarado) do tipo do objeto e analisar o comportamento do programa.

## Código para análise

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

## 1. Polimorfismo na prática

Considere o seguinte código:

```java
ContaEspecial conta = new ContaUniversitaria("Ana", 1000, 500, 3);
System.out.println(conta.consultar());
```

Questão 1 — Qual método será executado?

<details>
  <summary>Resposta</summary>
O método `consultar()` de `ContaEspecial` ou o de `ContaUniversitaria`? Justifique.

Resposta esperada: será executado o método `consultar()` de `ContaUniversitaria`, porque o objeto criado é dessa classe e o método foi sobrescrito. A variável ser do tipo `ContaEspecial` não muda o comportamento dinâmico do método.
</details>


## 2. Tipo da variável versus tipo do objeto

```java
ContaEspecial a = new ContaEspecial("João", 1000, 500);
ContaEspecial b = new ContaUniversitaria("Maria", 1000, 500, 2);

System.out.println(a.consultar());
System.out.println(b.consultar());
```

Questão 2 — As duas variáveis são do mesmo tipo. Os resultados serão iguais? Por quê?

<details>
  <summary>Resposta</summary>
Resposta esperada: não necessariamente. A primeira referência aponta para um objeto `ContaEspecial`; a segunda aponta para um objeto `ContaUniversitaria`. O método sobrescrito executado depende do tipo real do objeto.
</details>  


## 3. Sobrescrita versus herança

```java
ContaEspecial conta = new ContaUniversitaria("Pedro", 800, 400, 4);
conta.depositar(200);
System.out.println(conta.getSaldo());
```

Questão 3 — O método `depositar()` executado pertence a qual classe? Existe polimorfismo nesse método?

<details>
  <summary>Resposta</summary>
Resposta esperada: é executado o método herdado de `ContaEspecial`. Embora a chamada seja feita por uma referência que aponta para um objeto da subclasse, não existe sobrescrita de `depositar()` na classe filha. A herança, por si só, não significa que houve sobrescrita.
</details>

## 4. Pegadinha: quais métodos podem ser chamados?

```java
ContaEspecial conta = new ContaUniversitaria("Ana", 1000, 500, 3);
System.out.println(conta.getSemestre());
```

Questão 4 — Esse código compila? Se o objeto é uma `ContaUniversitaria`, por que a chamada pode apresentar um problema?

<details>
  <summary>Resposta</summary>
Resposta esperada: não compila. O compilador verifica os métodos disponíveis pelo tipo declarado da referência, `ContaEspecial`. Como `getSemestre()` só foi declarado em `ContaUniversitaria`, ele não pode ser chamado diretamente por essa referência.

Essa questão testa a diferença entre o tipo de referência, que limita as chamadas disponíveis, e o tipo real do objeto, que determina a implementação dos métodos sobrescritos.
</details>

## 5. Polimorfismo e retorno de métodos

Considere o método:

```java
public String consultar() {
    return super.consultar() + " | Semestre: " + semestre;
}
```

Questão 5 — O método da classe filha substitui completamente o método da classe pai? Explique o papel de `super.consultar()`.

<details>
  <summary>Resposta</summary>
Resposta esperada: a implementação da filha sobrescreve a da pai, mas reutiliza explicitamente o comportamento original por meio de `super.consultar()`, acrescentando a informação do semestre.
</details>

## 6. Polimorfismo com parâmetros

Considere:

```java
public static void exibirConta(ContaEspecial conta) {
    System.out.println(conta.consultar());
}
```

E as chamadas:

```
exibirConta(new ContaEspecial("João", 500, 200));
exibirConta(new ContaUniversitaria("Ana", 800, 300, 2));
```

Questão 6 — Por que o mesmo método `exibirConta()` aceita objetos de duas classes diferentes? O resultado será idêntico em estrutura?

<details>
  <summary>Resposta</summary>
Resposta esperada: porque `ContaUniversitaria` é uma subclasse de `ContaEspecial` e pode ser utilizada onde se espera uma `ContaEspecial`. O método `consultar()` executado depende do objeto recebido. O primeiro resultado não inclui o semestre; o segundo inclui.
</details>

## 7. Polimorfismo e regras de saque

```java
ContaEspecial conta = new ContaUniversitaria("Lucas", 1000, 600, 1);
boolean resultado = conta.sacar(1200);
System.out.println(resultado);
```

Questão 7 — Qual implementação de `sacar()` será executada primeiro? E qual será o resultado?

<details>
  <summary>Resposta</summary>
Resposta esperada: a implementação de `ContaUniversitaria` será executada primeiro. Ela verifica a regra adicional e, se permitido, chama `super.sacar(valor)` para aproveitar as regras da superclasse.

Neste exemplo, o saldo inicial é R$ 1.000, o saque é de R$ 1.200 e o limite é R$ 600. Como o saldo restante seria de R$ -200, e isso não ultrapassa metade do limite negativo de R$ -300, o saque é permitido e o resultado é `true`.
</details>

## 8. Questão conceitual: existe polimorfismo sem herança?

Questão 8 — Se a classe `ContaUniversitaria` não estendesse `ContaEspecial`, ainda seria possível usar `ContaUniversitaria` como argumento de `exibirConta(ContaEspecial conta)`?

<details>
  <summary>Resposta</summary>
Resposta esperada: não, não com essa declaração e sem outro relacionamento de tipos compatível. Em Java, isso exigiria herança ou outro tipo compatível, como uma interface implementada por ambas as classes, com a assinatura do método adaptada para esse tipo.
</details>

## 9. Desafio final — analise sem executar

A) A variável é do tipo ContaEspecial, mas o objeto é ContaUniversitaria. Qual informação determina a implementação de consultar() executada?

B) Se ContaUniversitaria não sobrescrever depositar(), qual implementação será usada?

C) Se criarmos ContaEspecial c = new ContaUniversitaria(...), por que c.getSemestre() não compila, mas c.consultar() funciona?

D) Qual é a diferença entre sobrescrita (override) e sobrecarga (overload) de métodos?

E) Se uma lista armazenar várias referências do tipo ContaEspecial, algumas apontando para objetos ContaEspecial e outras para ContaUniversitaria, como podemos chamar consultar() em todas e obter o comportamento correto de cada objeto?

&#x20;Copiar respostas

## Sugestão para avaliar o aluno

| Habilidade                            | Questões      |
| ------------------------------------- | ------------- |
| Identificar a implementação executada | 1, 2 e 7      |
| Diferenciar herança de sobrescrita    | 3 e 5         |
| Entender o tipo da referência         | 4 e 6         |
| Compreender a relação entre classes   | 8             |
| Aplicar o conceito em situações reais | Desafio final |

A pergunta mais importante para verificar se o aluno realmente compreendeu o polimorfismo é a questão 4, combinada com a questão 1. Se ele entender por que `conta.consultar()` funciona com despacho dinâmico, mas `conta.getSemestre()` não compila, provavelmente compreendeu a diferença entre o tipo declarado da referência e o tipo real do objeto.