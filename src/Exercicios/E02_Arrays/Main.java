package Exercicios.E02_Arrays;

import At01.Caminhao;
import At01.Onibus;
import At01.Veiculo;

public class Main 
{

    public static void main(String[] args) 
    {
        // Declarar	int[] a;
        // Instanciar	a = new int[5];
        // Declarar e instanciar	int[] a = new int[5];
        // Inicializar diretamente	int[] a = {1, 2, 3};
        // Atribuir elemento	a[0] = 10;
        // Ler elemento	int x = a[0];
        // Descobrir tamanho	a.length     

        // Array de Strings
        String[] nomes;                        // Declarar 
        nomes = new String[3];                 // Instanciar 
        nomes[0] = "Alice";                    // Atribuir elemento a posição 0
        nomes[1] = "Bob";                      // Atribuir elemento a posição 1
        nomes[2] = "Charlie";                  // Atribuir elemento a posição 2
        // Ler elemento
        String item0 = nomes[0];                // Ler elemento da posição 0
        String item1 = nomes[1];                // Ler elemento da posição 1
        String item2 = nomes[2];                // Ler elemento da posição 2
        // Mostrar elementos 
        System.out.println("Elemento 0: " + item0);
        System.out.println("Elemento 1: " + item1);
        System.out.println("Elemento 2: " + item2);

       

        // Declarando e inicializando o array nomes com 3 elementos
        String[] nomess = {"amadeu", "janja", "charles"};

        int total_itens = nomess.length;  // igual a 3, pois o array nomess tem 3 elementos
        // Usar o for para percorrer cada elmento do array imprimindo cada nome na tela
        for (
            int contador_repeticao = 0;            // inicializa o contador de repetição em 0
            contador_repeticao < total_itens;      // repetir enquanto o contador de repetição for menor que o total de itens do array 
            contador_repeticao += 1                // incrementa o contador de repetição em 1 a cada iteração do loop
        )  
        {
            // contador_repeticao é o índice do elemento atual do array, começando em 0
            System.out.println("Elemento " + contador_repeticao + ": " + nomess[contador_repeticao]);

        }
        // na primeira repetição do for, i será 0 e o elemento acessado será nomess[0] que é "amadeu"
        // na segunda repetição do for, i será 1 e o elemento acessado será nomess[1] que é "janja"
        // na terceira repetição do for, i será 2 e o elemento acessado será nomess[2] que é "charles"








        Veiculo[] veiculos = {
            new Caminhao("ABC1234", 2020, 4), 
            new Caminhao("DEF5678", 2021, 6), 
            new Onibus("GHI9012", 2019, 40)
        };

        // Usar o for para percorrer cada elmento do array imprimindo cada nome na tela
        for (int i = 0; i < veiculos.length; i++)  
        {
            System.out.println("\nlendo veículo no índice " + i + " do array");

            // Chama o método exibirDados para mostrar os detalhes do veículo no indice i do array
            veiculos[i].exibirDados(); 
        }   











        // nomess.length é o tamanho ou quantidade de elementos do array, nesse caso é 3 pois tem 3 nomes
        // for (i começa em 0; i < 3; contar mais um em i)
        // nomess.length é o tamanho ou quantidade de elementos do array, nesse caso é 3 pois tem 3 nomes
        // o for ficaria assim for(int i = 0; i < 3; i++)
        // na primeira repeticao do bloco 
        // i será 0 
        

        
    }
}
