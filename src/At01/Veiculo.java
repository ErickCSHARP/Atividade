package At01;

/**
 * Classe base que representa um veículo.
 * Armazena os dados comuns a caminhões e ônibus.
 */
public class Veiculo {

    // Atributos privados para proteger os dados do objeto.
    private String placa;
    private int ano;

    // Construtor padrão.
    public Veiculo() {}

    // Construtor que inicializa os atributos do veículo.
    public Veiculo(String placa, int ano) {
        this.placa = placa;
        this.ano = ano;
    }

    // Define a placa do veículo.
    public void setPlaca(String placa) {
         this.placa = placa;
    }

    // Define o ano de fabricação.
    public void setAno(int ano) { 
        this.ano = ano; 
    }

    // Sobrecarga do método para receber o ano como texto.
    public void setAno(String ano) { 
        this.ano = Integer.parseInt(ano); 
    }

    // Retorna a placa do veículo.
    public String getPlaca() { 
        return placa; 
    }

    // Retorna o ano de fabricação.
    public int getAno() { 
        return ano; 
    }

    // Exibe os dados comuns do veículo.
    public void exibirDados() {
        System.out.println("Placa: " + placa);
        System.out.println("Ano: " + ano);
    }
}
