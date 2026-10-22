public class Main {
    public static void main(String[] args) throws Exception {

        // Array que armazena objetos de diferentes subclasses de Veiculo.
        Veiculo[] veiculos = {
            new Caminhao("ABC1D23", 2022, 6),
            new Onibus("DEF4G56", 2023, 42),
            new Caminhao("GHI7J89", 2024, 8),
            new Onibus("KLM1N23", 2025, 50)
        };

        // Percorre o array e exibe os dados de cada veículo.
        for (Veiculo veiculo : veiculos) {
            System.out.println("------------------------------");
            veiculo.exibirDados();
        }

        System.out.println("------------------------------");
        System.out.println("Total de veículos: " + veiculos.length);
    }
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
