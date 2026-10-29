package Documentação;

// Classe base que representa um veículo genérico
public class Veiculo 
{
    public String marca;
    public String modelo;

    // Construtor da classe Veiculo
    public Veiculo(String marca, String modelo) 
    {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }

    public void exibirInformacoes() 
    {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);



    }
}






