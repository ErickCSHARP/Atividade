## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

---

Tutorial de Java para iniciantes - 1
1. Entendendo a estrutura inicial de um programa Java
Neste primeiro tutorial, vamos aprender como um programa Java é organizado, onde sua execução começa e quais são as regras básicas que precisamos conhecer para escrever nossos primeiros códigos.

Não se preocupe se você nunca programou antes. Vamos explicar cada parte do código com calma, começando pelos conceitos mais fundamentais.

1.1 Estrutura básica de um programa Java
Um programa Java é composto por classes, e cada classe pode conter métodos e atributos. A execução de um programa Java tradicional começa pelo método main, que deve estar contido em uma dessas classes. A estrutura mínima de um programa Java é, portanto, ao menos uma classe com um método main.

Exemplo de estrutura mínima de um programa Java:

public class ClasseExemplo
{
    public static void main(String[] args) 
    {
        // Instruções iniciais do programa.
    }
}

Vamos analisar cada parte dessa estrutura mínima para entender melhor como ela funciona.

1.2 Componentes da estrutura mínima
Classe: Toda aplicação Java precisa ter pelo menos uma classe. No exemplo acima, ClasseExemplo é a classe que contém o método main.
Método main: É o ponto de entrada da aplicação. Ele deve ser declarado dentro de uma classe e possui a assinatura public static void main(String[] args).
Bloco de código: O corpo do método main é delimitado por chaves {} e é onde colocamos as instruções que desejamos executar quando o programa iniciar.
Essa estrutura mínima é suficiente para que o programa seja executado, mesmo que ainda não faça nada visível.

As barras // indicam comentários em Java. Comentários são trechos de código que não são executados pelo programa e servem para explicar ou documentar o código. No exemplo acima, // Instruções iniciais do programa. é um comentário que indica onde podemos colocar nossas instruções.

1.3 Imprimindo uma mensagem na tela
Para tornar nosso programa um pouco mais interessante, podemos fazer com que ele exiba uma mensagem na tela. Em Java, utilizamos o método System.out.println para imprimir mensagens no console.

Exemplo:

public class ClasseExemplo
{
    public static void main(String[] args) 
    {
        System.out.println("Olá, mundo!");
        System.out.println("Fim do programa.");
    }
}

na tela, será exibida a mensagem:

Olá, mundo!
Fim do programa.

Uma outra forma de exibir mensagens no console é utilizando o método System.out.print, que funciona de maneira semelhante ao System.out.println, mas não adiciona uma nova linha após a mensagem.

Exemplo:

public class ClasseExemplo
{
    public static void main(String[] args) 
    {
        System.out.print("Olá, mundo!");
        System.out.print(" Fim do programa.");
    }
}

na tela, será exibida a mensagem:

Olá, mundo! Fim do programa.

1.3 Resumo
A estrutura mínima de um programa Java consiste em uma classe que contém o método main. Esse método é o ponto de entrada da aplicação, e seu corpo é onde colocamos as instruções que desejamos executar quando o programa iniciar.

As instruções dentro do método main são executadas sequencialmente. Isso significa que o programa seguirá a ordem em que as instruções foram escritas, executando uma após a outra até o final do método.

Essas instruções podem incluir chamadas a métodos, operações matemáticas, manipulação de variáveis, entre outras ações que compõem a lógica do programa.

Geralmente, dentro do método main podemos inicializar variáveis, chamar outros métodos, instanciar(Criar) objetos de classes, e realizar outras operações necessárias para o funcionamento do programa.

Em resumo, a estrutura mínima de um programa Java garante que o código tenha um ponto de entrada definido e que as instruções sejam organizadas de forma clara dentro de uma classe. Isso permite que o programa seja executado corretamente pelo ambiente de execução Java (JVM).

