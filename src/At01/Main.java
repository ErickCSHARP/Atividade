

package At01;

public class Main {
     public static void main(String[] args) throws Exception {

        // Array que armazena objetos de diferentes subclasses de Veiculo.
        Veiculo[] veiculos = {
            new Caminhao("ABC1D23", 2022, 6),       // na posicao 0
            new Onibus("DEF4G56", 2023, 42),     // na posicao 1
            new Caminhao("GHI7J89", 2024, 8),       // na posicao 2   
            new Onibus("KLM1N23", 2025, 50)      // na posicao 3
        };

         System.out.println("------------------------------");
         veiculos[0].exibirDados();

         System.out.println("------------------------------");
         veiculos[1].exibirDados();

         System.out.println("------------------------------");
         veiculos[2].exibirDados();

         System.out.println("------------------------------");
         veiculos[3].exibirDados();




        int total_veiculos = veiculos.length;
        // Percorre o array e exibe os dados de cada veículo.
        for (
            int posicao_elemento = 0;               // inicializa a posição do elemento atual do array em 0
            posicao_elemento < total_veiculos;      // repetir enquanto a posição do elemento  for menor que o total de veículos
            posicao_elemento++                      // incrementa a posição do elemento em 1 a cada iteração do loop
            )
        {
            System.out.println("------------------------------");
            veiculos[posicao_elemento].exibirDados();
        }

        System.out.println("------------------------------");
        System.out.println("Total de veículos: " + veiculos.length);
    }

    // public static void main(String[] args) throws Exception {

    //     // Array que armazena objetos de diferentes subclasses de Veiculo.
    //     Veiculo[] veiculos = {
    //         new Caminhao("ABC1D23", 2022, 6),
    //         new Onibus("DEF4G56", 2023, 42),
    //         new Caminhao("GHI7J89", 2024, 8),
    //         new Onibus("KLM1N23", 2025, 50)
    //     };

    //     // Percorre o array e exibe os dados de cada veículo.
    //     for (Veiculo veiculo : veiculos) {
    //         System.out.println("------------------------------");
    //         veiculo.exibirDados();
    //     }

    //     System.out.println("------------------------------");
    //     System.out.println("Total de veículos: " + veiculos.length);
    // }
}

/**
 * Registro de tela do console da sua IDE após a execução da classe "Main"
 *
 
    PS C:\Users\Usuario\Documents\programacao\ADS-Curt\Atividade1\Java\Atividade>  & 'C:\Program Files\Java\jdk-17\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\Usuario\Documents\programacao\ADS-Curt\Atividade1\Java\Atividade\bin' 'Main' 
    ------------------------------
    Tipo: Caminhão
    Placa: ABC1D23
    Ano: 2022
    Eixos: 6
    ------------------------------
    Tipo: Ônibus
    Placa: DEF4G56
    Ano: 2023
    Assentos: 42
    ------------------------------
    Tipo: Caminhão
    Placa: GHI7J89
    Ano: 2024
    Eixos: 8
    ------------------------------
    Tipo: Ônibus
    Placa: KLM1N23
    Ano: 2025
    Assentos: 50
    ------------------------------
    Total de veículos: 4

*/
