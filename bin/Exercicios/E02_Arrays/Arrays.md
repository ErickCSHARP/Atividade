# Exemplos de arrays Java

# Tutorial Java - Arrays (Vetores)

Um **array** é uma estrutura utilizada para armazenar vários valores do mesmo tipo em uma única variável. Cada elemento ocupa uma posição identificada por um índice numérico, que começa sempre em **zero**\.

Em Java, os arrays possuem tamanho fixo, definido no momento da instanciação.

Vamos estudar desde a criação até as diferentes formas de percorrer e manipular arrays.

## 1\. Declarando e instanciando arrays

Existem diferentes maneiras de declarar e criar arrays em Java.

### 1.1. Declarando e instanciando separadamente

Primeiro declaramos a variável e depois criamos o array utilizando `new`\.

```java
int[] numeros;
numeros = new int[5];
```

Nesse exemplo\:

- `int[]` indica que a variável armazenará um array de inteiros.
- `new int[5]` instancia um array com cinco posições.
- As posições são numeradas de 0 até 4.

Podemos visualizar assim\:

**Array numeros**

Valores iniciais: 0, 0, 0, 0, 0

Os elementos de um array numérico recebem zero como valor inicial automaticamente.

### 1.2. Declarando e instanciando na mesma linha

É a forma mais comum\:

```java
int[] numeros = new int[5];
```

Também podemos criar arrays de outros tipos\:

```java
double[] precos = new double[3];
String[] nomes = new String[4];
boolean[] respostas = new boolean[2];
```

Valores iniciais\:

| Tipo | Valor padrão |
|--------|--------|
| `int` | `0` |
| `double` | `0.0` |
| `float` | `0.0` |
| `boolean` | `false` |
| `char` | `\u0000` |
| `String` | `null` |

### 1.3. Instanciando e atribuindo valores diretamente

Podemos criar o array e informar seus elementos imediatamente\:

```java
int[] numeros = {10, 20, 30, 40, 50};
```

Essa é uma maneira prática de inicializar arrays quando já conhecemos os valores.

Também podemos utilizar `new` com inicializador\:

```java
int[] numeros = new int[]{10, 20, 30, 40, 50};
```

As duas formas produzem o mesmo resultado.

**Atenção\:** quando utilizamos a sintaxe simplificada `{}`, ela precisa estar associada à declaração ou a uma atribuição de array.

```java
int[] numeros;
numeros = new int[]{10, 20, 30};
```

---

## 2\. Atribuindo valores aos elementos

Depois de instanciar um array, podemos atribuir valores individualmente através dos índices.

```java
int[] numeros = new int[5];

numeros[0] = 10;
numeros[1] = 20;
numeros[2] = 30;
numeros[3] = 40;
numeros[4] = 50;
```

Cada atribuição modifica uma posição específica.

Visualização\:

Podemos também alterar um valor já existente\:

```java
int[] numeros = {10, 20, 30, 40, 50};

numeros[2] = 99;

System.out.println(numeros[2]);
```

**Saída\:**

```text
99
```

Observe que o valor 30 foi substituído por 99.

### 2.1. Acessando os elementos individualmente

Para ler um elemento, utilizamos seu índice\:

```java
int[] numeros = {10, 20, 30, 40, 50};

System.out.println(numeros[0]);
System.out.println(numeros[1]);
System.out.println(numeros[2]);
System.out.println(numeros[3]);
System.out.println(numeros[4]);
```

**Saída\:**

```text
10
20
30
40
50
```

### 2.2. Descobrindo o tamanho do array

Todo array possui a propriedade `length`, que informa quantos elementos ele contém.

```java
int[] numeros = {10, 20, 30, 40, 50};

System.out.println(numeros.length);
```

**Saída\:**

```text
5
```

Importante: `length` é uma propriedade, não um método. Portanto, não utilizamos parênteses.

---

## 3\. Percorrendo arrays

Uma das operações mais comuns é percorrer todos os elementos de um array.

Existem várias maneiras de fazer isso em Java.

### 3.1. Utilizando o `for` tradicional

O `for` é uma das formas mais utilizadas, pois permite controlar o índice e acessar cada elemento.

```java
int[] numeros = {10, 20, 30, 40, 50};

for (int i = 0; i < numeros.length; i++) {
    System.out.println(numeros[i]);
}
```

**Saída\:**

```text
10
20
30
40
50
```

Entendendo o funcionamento\:

| Instrução | Função |
|--------|--------|
| `int i = 0` | Inicia o índice em zero |
| `i < numeros.length` | Continua enquanto houver elementos |
| `i++` | Incrementa o índice |
| `numeros[i]` | Acessa o elemento atual |

O `for` executa cinco vezes, percorrendo os índices de 0 até 4.

### 3.2. Utilizando o `for-each`

O `for-each` é uma forma simplificada de percorrer arrays quando não precisamos trabalhar diretamente com os índices.

```java
int[] numeros = {10, 20, 30, 40, 50};

for (int numero : numeros) {
    System.out.println(numero);
}
```

**Saída\:**

```text
10
20
30
40
50
```

Entendendo a declaração\:

```java
for (int numero : numeros)
```

- `int`\: tipo dos elementos.
- `numero`\: variável que recebe o elemento atual.
- `numeros`\: array que será percorrido.

A cada repetição, a variável `numero` recebe o próximo elemento.

**Quando utilizar?**

- `for`\: quando precisamos do índice ou queremos modificar posições do array.
- `for-each`\: quando queremos apenas ler e processar os elementos.

Atenção: atribuir um novo valor à variável local do `for-each` não modifica o elemento original do array.

### 3.3. Utilizando o `while`

Também podemos percorrer arrays utilizando o comando `while`\.

```java
int[] numeros = {10, 20, 30, 40, 50};

int i = 0;

while (i < numeros.length) {
    System.out.println(numeros[i]);
    i++;
}
```

**Saída\:**

```text
10
20
30
40
50
```

O funcionamento é semelhante ao `for` tradicional, mas a inicialização e o incremento ficam separados da condição.

### 3.4. Utilizando o `do-while`

O `do-while` executa o bloco pelo menos uma vez, antes de verificar a condição.

```java
int[] numeros = {10, 20, 30, 40, 50};

int i = 0;

do {
    System.out.println(numeros[i]);
    i++;
} while (i < numeros.length);
```

**Saída\:**

```text
10
20
30
40
50
```

Essa estrutura é útil quando precisamos executar uma operação pelo menos uma vez.

---

## 4\. Percorrendo arrays em ordem inversa

Podemos percorrer um array do último elemento até o primeiro utilizando o `for`\.

```java
int[] numeros = {10, 20, 30, 40, 50};

for (int i = numeros.length - 1; i >= 0; i--) {
    System.out.println(numeros[i]);
}
```

**Saída\:**

```text
50
40
30
20
10
```

Observe que começamos em `numeros.length - 1`, porque os índices começam em zero.

---

## 5\. Percorrendo e exibindo índice e valor

Podemos utilizar o `for` tradicional para exibir tanto o índice quanto o conteúdo de cada posição.

```java
String[] nomes = {"Ana", "Carlos", "Maria", "João"};

for (int i = 0; i < nomes.length; i++) {
    System.out.println("Índice: " + i + " - Nome: " + nomes[i]);
}
```

**Saída\:**

```text
Índice: 0 - Nome: Ana
Índice: 1 - Nome: Carlos
Índice: 2 - Nome: Maria
Índice: 3 - Nome: João
```

Essa abordagem é bastante utilizada quando trabalhamos com listas de alunos, produtos, funcionários e outros registros.

---

## 6\. Utilizando a classe Arrays

Java possui a classe `Arrays`, localizada no pacote `java.util`, que disponibiliza métodos prontos para manipular arrays.

Para utilizá-la\:

```java
import java.util.Arrays;
```

Vamos conhecer alguns dos métodos mais importantes.

### 6.1. Exibindo todo o array com `Arrays.toString()`

Sem precisar utilizar um laço de repetição, podemos imprimir todo o conteúdo do array.

```java
import java.util.Arrays;

int[] numeros = {10, 20, 30, 40, 50};

System.out.println(Arrays.toString(numeros));
```

**Saída\:**

```text
[10, 20, 30, 40, 50]
```

Essa é uma das maneiras mais práticas de visualizar o conteúdo de um array durante o desenvolvimento.

### 6.2. Preenchendo todas as posições com `Arrays.fill()`

Podemos atribuir o mesmo valor para todas as posições.

```java
import java.util.Arrays;

int[] numeros = new int[5];

Arrays.fill(numeros, 10);

System.out.println(Arrays.toString(numeros));
```

**Saída\:**

```text
[10, 10, 10, 10, 10]
```

Também podemos preencher apenas um intervalo\:

```java
int[] numeros = new int[5];

Arrays.fill(numeros, 1, 4, 99);

System.out.println(Arrays.toString(numeros));
```

**Saída\:**

```text
[0, 99, 99, 99, 0]
```

O intervalo começa no índice 1 e termina antes do índice 4.

### 6.3. Ordenando com `Arrays.sort()`

Podemos ordenar os elementos em ordem crescente.

```java
import java.util.Arrays;

int[] numeros = {50, 10, 40, 20, 30};

Arrays.sort(numeros);

System.out.println(Arrays.toString(numeros));
```

**Saída\:**

```text
[10, 20, 30, 40, 50]
```

### 6.4. Pesquisando com `Arrays.binarySearch()`

Podemos pesquisar um elemento utilizando busca binária.

```java
import java.util.Arrays;

int[] numeros = {10, 20, 30, 40, 50};

int posicao = Arrays.binarySearch(numeros, 30);

System.out.println("Posição: " + posicao);
```

**Saída\:**

```text
Posição: 2
```

Importante: o array precisa estar ordenado para que a busca binária funcione corretamente.

### 6.5. Copiando arrays com `Arrays.copyOf()`

Podemos criar uma cópia de um array.

```java
import java.util.Arrays;

int[] original = {10, 20, 30};

int[] copia = Arrays.copyOf(original, original.length);

System.out.println(Arrays.toString(copia));
```

**Saída\:**

```text
[10, 20, 30]
```

A cópia é um novo array, independente do original.

### 6.6. Comparando arrays com `Arrays.equals()`

Podemos verificar se dois arrays possuem os mesmos elementos nas mesmas posições.

```java
import java.util.Arrays;

int[] a = {10, 20, 30};
int[] b = {10, 20, 30};
int[] c = {30, 20, 10};

System.out.println(Arrays.equals(a, b));
System.out.println(Arrays.equals(a, c));
```

**Saída\:**

```text
true
false
```

---

## 7\. Arrays de outros tipos

Até agora utilizamos principalmente arrays de inteiros, mas podemos armazenar diferentes tipos de dados.

### 7.1. Array de String

```java
String[] alunos = {"Ana", "Carlos", "Maria"};

for (String aluno : alunos) {
    System.out.println(aluno);
}
```

**Saída\:**

```text
Ana
Carlos
Maria
```

### 7.2. Array de double

```java
double[] notas = {8.5, 7.0, 9.5, 6.0};

double soma = 0;

for (double nota : notas) {
    soma += nota;
}

double media = soma / notas.length;

System.out.println("Média: " + media);
```

**Saída\:**

```text
Média: 7.75
```

### 7.3. Array de boolean

```java
boolean[] respostas = {true, false, true};

for (boolean resposta : respostas) {
    System.out.println(resposta);
}
```

**Saída\:**

```text
true
false
true
```

### 7.4. Array de objetos

Também podemos armazenar objetos em arrays.

```java
class Aluno {
    String nome;
    Aluno(String nome) { this.nome = nome; }
}

Aluno[] alunos = {
    new Aluno("Ana"),
    new Aluno("Carlos"),
    new Aluno("Maria")
};

for (Aluno aluno : alunos) {
    System.out.println(aluno.nome);
}
```

**Saída\:**

```text
Ana
Carlos
Maria
```

---

## 8\. Arrays multidimensionais (matrizes)

Além dos arrays convencionais, Java permite criar arrays com duas ou mais dimensões.

Uma matriz bidimensional pode ser entendida como uma tabela, com linhas e colunas.

### 8.1. Instanciando uma matriz

```java
int[][] matriz = new int[2][3];
```

Nesse exemplo, temos duas linhas e três colunas.

Podemos visualizar assim\:

**Matriz 2 × 3**

### 8.2. Atribuindo valores à matriz

```java
int[][] matriz = new int[2][3];

matriz[0][0] = 10;
matriz[0][1] = 20;
matriz[0][2] = 30;

matriz[1][0] = 40;
matriz[1][1] = 50;
matriz[1][2] = 60;
```

### 8.3. Instanciando com valores diretamente

Também podemos inicializar a matriz diretamente\:

```java
int[][] matriz = {
    {10, 20, 30},
    {40, 50, 60}
};
```

### 8.4. Percorrendo uma matriz com dois `for`

Para percorrer uma matriz, normalmente utilizamos dois laços de repetição.

```java
int[][] matriz = {
    {10, 20, 30},
    {40, 50, 60}
};

for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j] + " ");
    }
    System.out.println();
}
```

**Saída\:**

```text
10 20 30
40 50 60
```

Entendendo\:

- `matriz.length`\: quantidade de linhas.
- `matriz[i].length`\: quantidade de colunas da linha atual.
- `matriz[i][j]`\: elemento localizado na linha `i` e coluna `j`\.

### 8.5. Percorrendo uma matriz com for-each

Também podemos utilizar dois `for-each`\:

```java
int[][] matriz = {
    {10, 20, 30},
    {40, 50, 60}
};

for (int[] linha : matriz) {
    for (int valor : linha) {
        System.out.print(valor + " ");
    }
    System.out.println();
}
```

**Saída\:**

```text
10 20 30
40 50 60
```

---

## 9\. Cuidados importantes ao trabalhar com arrays

### 9.1. Índice fora dos limites

Um erro muito comum é tentar acessar uma posição que não existe.

```java
int[] numeros = {10, 20, 30};

System.out.println(numeros[3]);
```

**Resultado\:**

```text
ArrayIndexOutOfBoundsException
```

O array possui três posições, mas seus índices são 0, 1 e 2.

### 9.2. O tamanho do array é fixo

Depois de instanciado, o array não pode aumentar ou diminuir de tamanho.

```java
int[] numeros = new int[3];
```

Esse array continuará tendo três posições.

Se precisarmos de uma estrutura que aumente ou diminua dinamicamente, podemos utilizar `ArrayList`\.

### 9.3. Cuidado ao copiar arrays

Observe este exemplo\:

```java
int[] a = {10, 20, 30};
int[] b = a;

b[0] = 99;

System.out.println(Arrays.toString(a));
```

**Saída\:**

```text
[99, 20, 30]
```

Por quê?

Porque `b = a` não cria uma cópia. As duas variáveis apontam para o mesmo array na memória.

Para criar uma cópia independente, utilize\:

```java
int[] b = Arrays.copyOf(a, a.length);
```

---

## 10\. Resumo das principais formas de trabalhar com arrays

| Operação | Exemplo |
|--------|--------|
| Declarar | `int[] a;` |
| Instanciar | `a = new int[5];` |
| Declarar e instanciar | `int[] a = new int[5];` |
| Inicializar diretamente | `int[] a = {1, 2, 3};` |
| Atribuir elemento | `a[0] = 10;` |
| Ler elemento | `int x = a[0];` |
| Descobrir tamanho | `a.length` |
| Percorrer | `for` |
| Percorrer simplificado | `for-each` |
| Percorrer com condição | `while` |
| Percorrer pelo menos uma vez | `do-while` |
| Exibir conteúdo | `Arrays.toString(a)` |
| Preencher | `Arrays.fill(a, 10)` |
| Ordenar | `Arrays.sort(a)` |
| Pesquisar | `Arrays.binarySearch(a, 10)` |
| Copiar | `Arrays.copyOf(a, a.length)` |
| Comparar | `Arrays.equals(a, b)` |

---

## 11\. Exercícios práticos para fixação

Os exercícios abaixo permitem praticar as diferentes operações apresentadas.

**Lista de exercícios** (de 5 respostas abertas)

**Conclusão\:** dominar arrays é fundamental para aprender estruturas de dados, algoritmos, ordenação, pesquisa, matrizes e posteriormente coleções como `ArrayList`, `List` e `Map`\.

A principal diferença que você precisa guardar é: o `for` tradicional trabalha diretamente com os índices, enquanto o `for-each` percorre diretamente os elementos.

