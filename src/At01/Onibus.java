package At01;



/**
 * Representa um ônibus.
 * Herda os atributos e métodos comuns de Veiculo.
 */
public class Onibus extends Veiculo {
    // Quantidade de assentos do ônibus.
    private int assentos;

    // Inicializa os dados herdados e a quantidade de assentos.
    public Onibus(String placa, int ano, int assentos) {
        super(placa, ano);
        this.assentos = assentos;
    }

    // Define a quantidade de assentos.
    public void setAssentos(int assentos) { 
        this.assentos = assentos; 
    }

    // Retorna a quantidade de assentos.
    public int getAssentos() { 
        return assentos;
    }

    // Sobrescreve o método para exibir os dados específicos.
    @Override
    public void exibirDados() {
        System.out.println("Tipo: Ônibus");
        super.exibirDados();
        System.out.println("Assentos: " + assentos);
    }
}


