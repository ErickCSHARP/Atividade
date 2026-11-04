# Gabarito comentado - Questionário de Java

O gabarito não deve servir apenas para conferir se o aluno acertou ou errou. A intenção é apresentar o raciocínio esperado, explicar o motivo da resposta e reforçar os conceitos fundamentais.

As respostas abaixo são referências. O aluno poderá utilizar outras palavras e exemplos, desde que demonstre compreender corretamente o conceito.

### Capítulo 1 - Fundamentos da programação e introdução à POO

**Questão 1 - Variáveis e tipos de dados**

**Resposta esperada\:**

Uma variável é um espaço identificado na memória utilizado para armazenar um valor durante a execução do programa. O tipo de dado determina quais valores podem ser armazenados e quais operações podem ser realizadas.

| Informação | Tipo Java | Exemplo |
|--------|--------|--------|
| Idade | `int` | `int idade = 25;` |
| Preço | `double` | `double preco = 99.90;` |
| Nome | `String` | `String nome = "Carlos";` |
| Verdadeiro ou falso | `boolean` | `boolean ativo = true;` |
| Quantidade | `int` | `int estoque = 50;` |

**Justificativa\:** A definição correta dos tipos ajuda a garantir a consistência dos dados, evita operações incompatíveis e permite que o compilador identifique determinados erros.

**Questão 2 - Operadores**

**Resposta esperada\:**

a) Resultados\:

| Expressão | Resultado |
|--------|--------|
| `a + b` | 13 |
| `a / b` | 3 |
| `a % b` | 1 |
| `a > b` | `true` |

b) O operador `/` realiza a divisão, enquanto `%` retorna o resto da divisão.

c) Porque a comparação verifica se uma condição é verdadeira ou falsa. Portanto, seu resultado é do tipo `boolean`\.

**Justificativa\:** Como `a` e `b` são variáveis inteiras, a divisão inteira descarta a parte decimal. Assim, 10 dividido por 3 resulta em 3, com resto 1.

**Questão 3 - Estruturas de controle**

**Resposta esperada\:**

As estruturas de controle determinam o fluxo de execução de um programa.

\- `if/else`\: permite executar diferentes blocos de código conforme uma condição.

```java
if (idade >= 18) System.out.println("Maior de idade");
else System.out.println("Menor de idade");
```

\- `for`\: utilizado quando geralmente sabemos quantas vezes determinada operação deverá ser repetida.

```java
for (int i = 0; i < 5; i++) System.out.println(i);
```

\- `while`\: executa repetidamente um bloco enquanto determinada condição for verdadeira.

```java
while (saldo > 0) saldo--;
```

**Justificativa\:** As estruturas condicionais permitem tomar decisões, enquanto os laços de repetição permitem automatizar tarefas que precisam ser executadas várias vezes.

**Questão 4 - Métodos**

**Resposta esperada\:**

a) Método é um bloco de código responsável por executar uma tarefa específica.

b) O nome é `somar`\.

c) São parâmetros que recebem os dois valores inteiros utilizados na operação.

d) `return` devolve o resultado da execução do método para quem realizou a chamada.

e) O tipo de retorno é `int`\.

**Justificativa\:** Os métodos permitem dividir um programa em partes menores e organizadas, favorecendo a reutilização de código e a modularidade.

**Questão 5 - Classes e objetos**

**Resposta esperada\:**

Uma classe é um modelo ou molde que define as características e os comportamentos de determinados elementos.

Um objeto é uma instância concreta dessa classe, criada durante a execução do programa.

No exemplo\:

- Classe: `Carro`\.
- Atributos: `modelo`, `cor` e `ano`\.
- Métodos: `ligar()` e `acelerar()`\.
- Objetos: um Gol vermelho de 2022, um Onix branco de 2024 etc.

**Justificativa\:** A classe define a estrutura que os objetos terão. Cada objeto possui seus próprios valores para os atributos, embora compartilhe a estrutura e os comportamentos definidos pela classe.

**Questão 6 - Instanciação de objetos**

**Resposta esperada\:**

a) Foram criados dois objetos.

b) Sim. Ambos são instâncias da classe `Carro`\.

c) Não. Cada objeto possui seu próprio estado. Alterar o atributo de um objeto não altera automaticamente o atributo do outro.

d) A palavra-chave `new` cria uma nova instância da classe, alocando memória para o objeto e executando seu construtor.

**Justificativa\:** Uma classe pode originar diversos objetos independentes. Embora compartilhem a mesma estrutura, cada instância mantém seus próprios valores de atributos.

**Questão 7 - Construtores**

**Resposta esperada\:**

O construtor é um recurso especial da classe utilizado para inicializar um objeto no momento de sua criação.

a) Porque o construtor não é um método convencional e não possui tipo de retorno, nem mesmo `void`\. Seu nome deve ser igual ao nome da classe.

b) `this` representa a instância atual do objeto. Nesse exemplo, permite diferenciar os atributos dos parâmetros que possuem os mesmos nomes.

c) É criada uma instância de `Pessoa`, cujo atributo `nome` recebe `"Carlos"` e o atributo `idade` recebe `25`\.

**Justificativa\:** Os construtores permitem que os objetos sejam criados com seus atributos inicializados, evitando que precisem ser configurados separadamente após a instanciação.

**Questão 8 - Aplicação prática de classes e objetos**

**Resposta esperada\:**

Uma implementação possível\:

```java
public class Livro {
    String titulo, autor;
    int paginas;
    public Livro(String titulo, String autor, int paginas) { this.titulo = titulo; this.autor = autor; this.paginas = paginas; }
    public void exibirInformacoes() { System.out.println(titulo + " - " + autor + " - " + paginas + " páginas"); }
    public boolean possuiMaisDeCemPaginas() { return paginas > 100; }
}
```

Características\:

- `titulo`\: nome do livro.
- `autor`\: responsável pela obra.
- `paginas`\: quantidade de páginas.

Comportamentos\:

- `exibirInformacoes()`\: apresenta os dados do livro.
- `possuiMaisDeCemPaginas()`\: verifica uma condição relacionada ao livro.

**Justificativa\:** Os atributos representam o estado ou as características do objeto, enquanto os métodos representam as ações ou comportamentos que ele pode executar.

**Questão 9 - Os quatro pilares da POO**

**Resposta esperada\:**

| Pilar | Explicação | Exemplo |
|--------|--------|--------|
| Encapsulamento | Protege os dados internos e controla o acesso a eles. | Saldo privado de uma conta. |
| Herança | Permite que uma classe herde características de outra. | `Carro` herda de `Veiculo`\. |
| Polimorfismo | Permite que objetos diferentes respondam de maneiras distintas à mesma chamada. | Cada veículo implementa seu próprio `acelerar()`\. |
| Abstração | Representa os aspectos essenciais de algo, ocultando detalhes desnecessários. | Classe genérica `Funcionario`\. |

**Justificativa\:** Os quatro pilares são fundamentos da POO. Trabalhando em conjunto, permitem criar sistemas organizados, reutilizáveis, flexíveis e mais fáceis de manter.

**Questão 10 - Aplicação dos conceitos de POO**

**Resposta esperada\:**

Uma possível estrutura seria criar uma classe `Funcionario`, contendo atributos como nome, salário e cargo, além de métodos para consultar e atualizar informações.

Os quatro pilares seriam aplicados da seguinte maneira\:

- Classes e objetos: `Funcionario` seria o modelo, e cada funcionário cadastrado seria um objeto.
- Encapsulamento: os atributos seriam privados e acessados por métodos controlados.
- Herança: classes como `Gerente` e `Vendedor` poderiam herdar características de `Funcionario`\.
- Polimorfismo: cada categoria poderia implementar métodos específicos, como `calcularBonus()`\.
- Abstração: a classe `Funcionario` poderia definir características e comportamentos comuns aos funcionários.

**Justificativa\:** A POO permite representar entidades do mundo real por meio de estruturas de código, separando características e comportamentos e facilitando a evolução do sistema.

---

### Capítulo 2 - Encapsulamento, herança, polimorfismo e abstração

**Questão 11 - Modificadores de acesso**

**Resposta esperada\:**

| Modificador | Acesso |
|--------|--------|
| `public` | Permite acesso de qualquer classe. |
| `private` | Permite acesso somente dentro da própria classe. |
| `protected` | Permite acesso dentro do próprio pacote e também em subclasses, inclusive em outros pacotes, respeitadas as regras de acesso de Java. |

Exemplos de utilização\:

- `public`\: métodos que precisam ser utilizados por outras classes.
- `private`\: atributos que precisam ser protegidos.
- `protected`\: membros que precisam ser acessíveis por subclasses e classes do mesmo pacote.

**Justificativa\:** Os modificadores de acesso permitem controlar a visibilidade dos membros, contribuindo para o encapsulamento, a segurança e a organização do código.

**Questão 12 - Encapsulamento**

**Resposta esperada\:**

a) Porque o atributo `saldo` não deve ser acessado e modificado livremente por outras classes.

b) Porque uma alteração direta poderia comprometer a integridade dos dados, permitindo operações inválidas.

c) O método `depositar()` permite adicionar valores ao saldo, desde que sejam positivos.

d) O método `getSaldo()` permite consultar o saldo sem conceder acesso direto ao atributo.

e) O princípio aplicado é o encapsulamento.

**Justificativa\:** O encapsulamento protege o estado interno do objeto e estabelece mecanismos controlados de acesso e modificação. Nesse exemplo, o próprio objeto controla as condições para realizar depósitos.

**Questão 13 - Getters e Setters**

**Resposta esperada\:**

a) `getPreco()` consulta e retorna o preço. `setPreco()` permite modificar o preço.

b) A validação impede que valores negativos sejam atribuídos ao produto.

c) Se o atributo fosse público, qualquer classe poderia alterar seu valor diretamente, inclusive atribuindo valores inválidos.

**Justificativa\:** Getters e Setters são métodos de acesso que permitem controlar a leitura e a modificação dos atributos privados. Eles também podem realizar validações antes de aceitar alterações.

**Questão 14 - Herança**

**Resposta esperada\:**

a) `extends` indica que uma classe está herdando de outra.

b) `Animal` é a classe pai, também chamada de superclasse.

c) `Cachorro` é a classe filha, também chamada de subclasse.

d) Sim. Como `Cachorro` herda de `Animal`, pode utilizar o método público `emitirSom()`\.

e) A principal vantagem é a reutilização de código, evitando a repetição de atributos e métodos comuns entre classes relacionadas.

**Justificativa\:** A herança estabelece uma relação hierárquica entre classes e permite especializar comportamentos sem precisar reimplementar tudo que já existe na classe pai.

**Questão 15 - Reutilização de código**

**Resposta esperada\:**

A empresa poderia criar uma classe `Funcionario`, contendo os atributos comuns `nome`, `cpf` e `salario`\.

As classes `Gerente` e `Vendedor` herdariam de `Funcionario` utilizando `extends` e acrescentariam seus próprios atributos e métodos específicos.

Exemplo\:

```java
public class Funcionario {
    protected String nome, cpf;
    protected double salario;
}
public class Gerente extends Funcionario {
    public void aprovarDespesas() { }
}
public class Vendedor extends Funcionario {
    public void registrarVenda() { }
}
```

**Justificativa\:** A herança evita duplicação de código porque as características comuns ficam centralizadas na classe pai. As subclasses aproveitam essas características e acrescentam suas especializações.

**Questão 16 - Sobrescrita de métodos (Override)**

**Resposta esperada\:**

a) Sobrescrever significa fornecer uma nova implementação para um método herdado da classe pai.

b) `@Override` indica que o método está sobrescrevendo uma implementação herdada. Também permite ao compilador verificar se a sobrescrita está correta.

c) Será exibida a mensagem\:

```text
Au au!
```

d) A sobrescrita permite que cada subclasse implemente um comportamento específico, mesmo mantendo o nome e a assinatura do método da classe pai.

**Justificativa\:** A sobrescrita é um mecanismo importante para o polimorfismo, pois permite que diferentes classes respondam de maneiras distintas à mesma chamada de método.

**Questão 17 - Polimorfismo**

**Resposta esperada\:**

a) O tipo da variável é `Animal`\.

b) O tipo real do objeto é `Cachorro`\.

c) Será executado o método `emitirSom()` sobrescrito na classe `Cachorro`\.

d) Porque uma variável de referência do tipo da classe pai está sendo utilizada para armazenar um objeto de uma classe filha, e o comportamento executado corresponde ao tipo real do objeto.

**Justificativa\:** Esse é um exemplo de polimorfismo por meio de herança e sobrescrita. O tipo da referência determina quais membros podem ser acessados em tempo de compilação, mas a implementação sobrescrita é escolhida de acordo com o tipo real do objeto durante a execução.

**Questão 18 - Polimorfismo na prática**

**Resposta esperada\:**

A classe `Jogador` pode definir um método `chutar()`, que será sobrescrito pelas classes `Atacante`, `MeioCampista` e `Defensor`\.

Exemplo\:

```java
public class Jogador {
    public void chutar() { System.out.println("Chute genérico"); }
}
public class Atacante extends Jogador {
    @Override public void chutar() { System.out.println("Chute forte e preciso"); }
}
public class MeioCampista extends Jogador {
    @Override public void chutar() { System.out.println("Chute com efeito"); }
}
public class Defensor extends Jogador {
    @Override public void chutar() { System.out.println("Chute para afastar o perigo"); }
}
```

Assim, podemos armazenar diferentes tipos de jogadores em referências do tipo `Jogador` e chamar o método `chutar()`\.

**Justificativa\:** O polimorfismo permite tratar objetos de diferentes classes de maneira uniforme, preservando seus comportamentos específicos. Esse exemplo segue a abordagem apresentada no livro com a hierarquia de jogadores de futebol.

**Questão 19 - Classes abstratas**

**Resposta esperada\:**

Uma classe abstrata é uma classe declarada com a palavra-chave `abstract`, utilizada como modelo para outras classes.

a) Não pode ser instanciada diretamente porque representa uma estrutura incompleta ou genérica, destinada a ser especializada por subclasses.

b) Um método abstrato define uma assinatura de comportamento que deverá ser implementada pelas subclasses concretas.

c) Sim. Pode possuir atributos, construtores, métodos concretos e métodos abstratos.

d) Uma classe filha herda a estrutura da classe abstrata e deve implementar seus métodos abstratos, caso também não seja abstrata.

Exemplo\:

```java
public abstract class Veiculo {
    protected String modelo;
    public abstract void acelerar();
}
public class Carro extends Veiculo {
    @Override public void acelerar() { System.out.println("Carro acelerando"); }
}
```

**Justificativa\:** A abstração permite definir características e comportamentos comuns sem exigir que a classe genérica represente um objeto concreto. As subclasses fornecem as implementações específicas.

**Questão 20 - Integração dos pilares da POO**

**Resposta esperada\:**

a) Abstração: criar uma estrutura genérica `Veiculo`, representando características comuns, como modelo e velocidade.

b) Encapsulamento: declarar os atributos como `private` e controlar seu acesso por meio de métodos.

c) Herança: fazer `Carro` e `Moto` herdarem de `Veiculo`\.

d) Polimorfismo: definir `acelerar()` na classe base abstrata e implementar comportamentos diferentes nas subclasses.

Exemplo\:

```java
public abstract class Veiculo {
    private String modelo;
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public abstract void acelerar();
}
public class Carro extends Veiculo {
    @Override public void acelerar() { System.out.println("Carro acelerando"); }
}
public class Moto extends Veiculo {
    @Override public void acelerar() { System.out.println("Moto acelerando"); }
}
```

**Justificativa\:** Os quatro pilares podem trabalhar juntos para organizar o sistema. A abstração define a estrutura genérica, o encapsulamento protege os dados, a herança compartilha características e o polimorfismo permite comportamentos especializados.

---

### Capítulo 3 - Pacotes, interfaces gráficas, Design Patterns e SOLID

**Questão 21 - Organização com pacotes**

**Resposta esperada\:**

Pacotes (`packages`\) são mecanismos utilizados para organizar classes e interfaces relacionadas dentro de uma estrutura lógica.

Uma possível organização seria\:

```text
sistema/
    clientes/
        Cliente.java
    produtos/
        Produto.java
    vendas/
        Venda.java
    pagamentos/
        Pagamento.java
```

**Justificativa\:** Os pacotes facilitam a localização das classes, evitam conflitos de nomes, ajudam a controlar o acesso e tornam os projetos mais organizados e fáceis de manter.

**Questão 22 - Importação de classes**

**Resposta esperada\:**

a) `package` declara a qual pacote a classe pertence.

b) `import` permite utilizar classes de outros pacotes sem precisar escrever seus nomes totalmente qualificados em cada utilização.

c) A organização em pacotes separa responsabilidades, facilita a localização das classes e permite estruturar projetos maiores.

**Justificativa\:** O uso de pacotes favorece a modularidade e a manutenção do software, evitando que todas as classes fiquem concentradas em uma única estrutura.

**Questão 23 - Interfaces gráficas com Swing**

**Resposta esperada\:**

a) GUI (*Graphical User Interface*\) é uma interface gráfica que permite ao usuário interagir com o programa por meio de elementos visuais.

b) Swing é uma biblioteca Java utilizada para desenvolver interfaces gráficas.

c) Os componentes representam elementos visuais e interativos\:

- Botões: permitem executar ações.
- Caixas de texto: permitem inserir informações.
- Rótulos: apresentam textos e informações.

d) `JFrame` representa uma janela principal, funcionando como contêiner para organizar os componentes da interface.

**Justificativa\:** O Swing disponibiliza componentes que permitem construir aplicações gráficas sem depender exclusivamente de interações por meio do console.

**Questão 24 - Eventos em interfaces gráficas**

**Resposta esperada\:**

Um evento é uma ocorrência que pode ser identificada pelo programa, como um clique de botão, uma alteração de campo ou uma ação do usuário.

No Swing, podemos utilizar um `ActionListener` para identificar o clique de um botão.

Exemplo\:

```java
JButton btnSalvar = new JButton("Salvar");
btnSalvar.addActionListener(e -> System.out.println("Dados salvos!"));
```

Quando o usuário clicar no botão, o código associado ao evento será executado.

**Justificativa\:** O tratamento de eventos permite que a interface responda às ações do usuário, tornando a aplicação interativa.

**Questão 25 - Separação entre interface e lógica de negócio**

**Resposta esperada\:**

A interface gráfica deve ser responsável pela interação com o usuário, enquanto a lógica de negócio deve concentrar as regras e operações do sistema.

Em um cadastro de clientes\:

- A interface recebe nome, CPF e endereço.
- A classe responsável pelo negócio valida as informações.
- A lógica de negócio realiza o cadastro.
- A interface apresenta o resultado ao usuário.

**Justificativa\:** Essa separação evita misturar responsabilidades, facilita a manutenção, permite reutilizar as regras de negócio em diferentes interfaces e torna os testes mais simples.

**Questão 26 - Design Patterns**

**Resposta esperada\:**

Design Patterns são padrões de projeto que apresentam soluções reutilizáveis para problemas recorrentes no desenvolvimento de software.

Eles não são códigos prontos que devem ser copiados, mas modelos de organização e estruturação de soluções.

Exemplos\:

- Singleton: controla a criação de uma única instância de uma classe.
- Factory Method: organiza a criação de objetos por meio de métodos de fábrica.

**Justificativa\:** Os padrões de projeto ajudam a desenvolver sistemas mais organizados, flexíveis, reutilizáveis e fáceis de manter, evitando soluções improvisadas para problemas que já são conhecidos.

**Questão 27 - Padrão Singleton**

**Resposta esperada\:**

a) Sua finalidade é garantir que uma classe possua apenas uma instância controlada e disponibilize um ponto de acesso a ela.

b) O construtor é declarado `private` para impedir que outras classes criem instâncias diretamente utilizando `new`\.

c) O acesso é realizado por um método público e estático que fornece a instância controlada.

d) Pode ser utilizado em situações nas quais se deseja centralizar um recurso compartilhado, como uma configuração global da aplicação.

Exemplo\:

```java
public class Configuracao {
    private static final Configuracao instancia = new Configuracao();
    private Configuracao() { }
    public static Configuracao getInstancia() { return instancia; }
}
```

Utilização\:

```java
Configuracao config = Configuracao.getInstancia();
```

**Justificativa\:** O Singleton controla a criação da instância e centraliza o acesso a ela. O construtor privado impede instanciações externas, enquanto o método estático disponibiliza a instância existente.

**Questão 28 - Padrão Factory Method**

**Resposta esperada\:**

O Factory Method é um padrão de projeto que organiza a criação de objetos, permitindo que subclasses ou implementações específicas determinem qual produto concreto será criado.

Por exemplo, podemos possuir\:

- Uma interface `Produto`\.
- Uma implementação `ProdutoA`\.
- Uma implementação `ProdutoB`\.
- Uma fábrica responsável pela criação dos produtos.

Assim, o código principal utiliza a abstração `Produto`, sem precisar conhecer todos os detalhes de construção de cada implementação.

**Justificativa\:** O padrão reduz o acoplamento entre o código que utiliza os objetos e o código responsável por criá-los. Também facilita a inclusão de novos tipos de produtos sem precisar alterar toda a lógica cliente.

**Questão 29 - Princípios SOLID**

**Resposta esperada\:**

Os cinco princípios são\:

| Sigla | Princípio | Explicação |
|--------|--------|--------|
| S | Single Responsibility Principle | Uma classe deve ter uma única responsabilidade ou motivo principal para mudar. |
| O | Open/Closed Principle | O software deve estar aberto para extensão, mas fechado para modificações. |
| L | Liskov Substitution Principle | Objetos de uma classe derivada devem poder substituir objetos da classe base sem comprometer o comportamento esperado. |
| I | Interface Segregation Principle | É melhor possuir interfaces específicas do que obrigar classes a implementar métodos que não utilizam. |
| D | Dependency Inversion Principle | Módulos de alto nível não devem depender diretamente de implementações de baixo nível; ambos devem depender de abstrações. |

**Exemplos práticos\:**

- **SRP\:** separar a classe responsável pelo cadastro daquela responsável por enviar e-mails.
- **OCP\:** permitir adicionar novos tipos de pagamento sem modificar o código que já funciona.
- **LSP\:** uma classe `Carro` deve poder substituir `Veiculo` sem quebrar as operações esperadas.
- **ISP\:** separar uma interface grande em interfaces menores, como `Imprimivel` e `Digitalizavel`\.
- **DIP\:** fazer uma classe de vendas depender de uma interface `Pagamento`, e não diretamente de `PagamentoPix` ou `PagamentoCartao`\.

**Justificativa\:** Os princípios SOLID fornecem diretrizes para desenvolver sistemas com menor acoplamento, melhor organização, maior flexibilidade e facilidade de manutenção.

**Questão 30 - Análise de projeto e aplicação integrada**

**Resposta esperada\:**

Uma possível arquitetura para o sistema de vendas seria\:

```text
sistema/
    clientes/
        Cliente.java
    produtos/
        Produto.java
    vendas/
        Venda.java
        VendaService.java
    pagamentos/
        Pagamento.java
        PagamentoPix.java
        PagamentoCartao.java
    interfacegrafica/
        TelaVendas.java
    infraestrutura/
        BancoDados.java
```

Aplicação dos conceitos\:

**a) Organização das classes e pacotes**

Separar as classes por responsabilidade, agrupando clientes, produtos, vendas, pagamentos e interface gráfica em pacotes distintos.

**b) Encapsulamento**

Declarar os atributos como privados e utilizar métodos para consultar e modificar os dados, aplicando validações quando necessário.

**c) Herança e polimorfismo**

Uma possibilidade é criar uma estrutura comum para os meios de pagamento, permitindo que `PagamentoPix` e `PagamentoCartao` implementem suas próprias operações.

Exemplo\:

```java
public interface Pagamento {
    void pagar(double valor);
}
public class PagamentoPix implements Pagamento {
    @Override public void pagar(double valor) { System.out.println("Pagamento via Pix: " + valor); }
}
public class PagamentoCartao implements Pagamento {
    @Override public void pagar(double valor) { System.out.println("Pagamento via cartão: " + valor); }
}
```

**d) Separação entre interface e regras de negócio**

A classe `TelaVendas` deve receber os dados do usuário e encaminhá-los para `VendaService`, responsável pelas validações e pelo processamento da venda.

**e) Padrão de projeto**

O Factory Method poderia ser utilizado para criar diferentes meios de pagamento, evitando que a lógica principal conheça todos os detalhes de instanciação.

**f) Princípios SOLID**

- SRP: separar a responsabilidade de cadastrar clientes, processar vendas e realizar pagamentos.
- OCP: permitir adicionar novas formas de pagamento sem modificar a estrutura principal do sistema.
- DIP: fazer o serviço de vendas depender da abstração `Pagamento`, em vez de depender diretamente de uma implementação específica.

**Justificativa\:** A aplicação integrada dos conceitos permite construir um sistema modular, organizado e preparado para receber novas funcionalidades. Cada classe possui uma responsabilidade definida, enquanto as abstrações e os padrões de projeto ajudam a reduzir o acoplamento e facilitar a evolução do software.

---

## Parte 3 - Orientações para utilização da atividade

Sugiro utilizar a atividade como uma revisão completa do livro, e não apenas como uma prova de memorização.

Uma boa forma de aplicação seria\:

| Etapa | Atividade | Objetivo |
|--------|--------|--------|
| 1 | Responder às questões 1 a 10 | Consolidar fundamentos de Java e POO. |
| 2 | Responder às questões 11 a 20 | Compreender os pilares da POO na prática. |
| 3 | Responder às questões 21 a 30 | Conhecer organização, interfaces e boas práticas. |
| 4 | Corrigir utilizando o gabarito | Identificar erros e compreender os conceitos. |
| 5 | Reimplementar os exemplos em Java | Transformar conhecimento teórico em habilidade prática. |

### Critério de avaliação sugerido

**Distribuição de pontos**

Questões 1 a 10 **3,0 pontos**

Questões 11 a 20 **3,0 pontos**

Questões 21 a 30 **4,0 pontos**

---

**Total**

# 10,0

**Minha recomendação pedagógica\:** não exija que o aluno apenas reproduza definições. Principalmente nas questões sobre herança, polimorfismo, abstração e SOLID, valorize a capacidade de explicar o funcionamento e justificar as escolhas de implementação.

O aluno que consegue explicar por que utilizaria `private`, por que criaria uma classe abstrata ou por que utilizaria uma interface para representar diferentes formas de pagamento está realmente começando a compreender Programação Orientada a Objetos.

*Material elaborado com base na organização e nos conteúdos dos três capítulos do livro fornecido.* fileciteturn0file0



---
Powered by [ChatGPT Exporter](https://www.chatgptexporter.com)