Nas classes `ContaEspecial` e `ContaUniversitaria`, as diferenças comportamentais estão principalmente nas regras de saque e na forma de consultar os dados da conta. A classe filha herda os comportamentos da classe pai, mas pode modificar alguns deles por meio da sobrescrita de métodos.

## 1. Comparação dos comportamentos

| Comportamento              | `ContaEspecial` (pai)                               | `ContaUniversitaria` (filha)                                         |
| -------------------------- | --------------------------------------------------- | -------------------------------------------------------------------- |
| Depositar                  | Permite depósito de valores positivos.              | Herda o mesmo comportamento.                                         |
| Sacar                      | Permite sacar até o saldo mais o limite disponível. | Aplica uma regra adicional antes de permitir o saque.                |
| Consultar conta            | Exibe titular e saldo.                              | Exibe titular, saldo e semestre universitário.                       |
| Consultar semestre         | Não possui esse comportamento.                      | Possui o método `getSemestre()`.                                     |
| Acessar atributos da conta | Mantém os atributos privados.                       | Utiliza os métodos públicos herdados para consultar esses atributos. |

## 2. Diferença no método `sacar()`

Na classe pai, o saque é permitido quando o valor é positivo e não ultrapassa o saldo somado ao limite:

```java
public boolean sacar(double valor) {
    if (valor > 0 && valor <= saldo + limite) {
        saldo -= valor;
        return true;
    }
    return false;
}
```

Na classe filha, existe uma regra adicional: o saldo restante não pode ficar abaixo de metade do limite negativo permitido.

```java
@Override
public boolean sacar(double valor) {
    if (valor > 0 && valor <= getSaldo() + getLimite()) {
        if (getSaldo() - valor < -getLimite() / 2) return false;
        return super.sacar(valor);
    }
    return false;
}
```

Por exemplo, considerando saldo de R$ 1.000 e limite de R$ 600:

| Valor do saque | ContaEspecial | ContaUniversitaria |
| -------------- | ------------- | ------------------ |
| R$ 800         | Permitido     | Permitido          |
| R$ 1.200       | Permitido     | Permitido          |
| R$ 1.400       | Permitido     | Negado             |
| R$ 1.601       | Negado        | Negado             |

A conta universitária tem uma restrição adicional, pois não pode deixar o saldo abaixo de `-R$ 300`, enquanto a conta especial pode chegar até `-R$ 600`.

## 3. Diferença no método `consultar()`

Na classe pai:

```java
public String consultar() {
    return "Titular: " + titular + " | Saldo: R$ " + saldo;
}
```

Na classe filha:

```java
@Override
public String consultar() {
    return super.consultar() + " | Semestre: " + semestre;
}
```

A filha reaproveita a consulta da classe pai e acrescenta uma informação específica.

Por exemplo, para uma conta universitária, a saída será semelhante a:

```
Titular: Ana | Saldo: R$ 1000.0 | Semestre: 3
```

## 4. O que isso demonstra sobre POO?

- Herança: a classe universitária reaproveita os métodos da conta especial.
- Sobrescrita: a classe universitária redefine `sacar()` e `consultar()`.
- Polimorfismo: uma referência do tipo `ContaEspecial` pode apontar para um objeto `ContaUniversitaria`, e os métodos sobrescritos executam o comportamento específico da filha.
- Encapsulamento: os atributos `titular`, `saldo` e `limite` são privados, e a filha utiliza métodos públicos para consultar seus valores.

A principal ideia é que a classe filha não precisa reimplementar tudo. Ela herda o comportamento comum e especializa apenas aquilo que precisa funcionar de maneira diferente.