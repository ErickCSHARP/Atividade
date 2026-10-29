package Documentação;
// Classe que representa um ônibus, herdando da classe Veiculo. 
// Veiculo é a superclasse de onibus
public class Onibus extends Veiculo 
{



    // Construtor da classe Onibus
    public Onibus(String marca, String modelo) 
    {
        // Chama o construtor da superclasse Veiculo para inicializar os 
        // atributos marca e modelo
        super(marca, modelo);
    }






    @Override
    public void exibirInformacoes() 
    {
        // Chama o método da superclasse para exibir as informações 
        // básicas do veículo
        super.exibirInformacoes();
        
        System.out.println("Tipo: Carro");
    }
}





