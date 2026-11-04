package At01;


/**
 * Representa um caminhão.
 * Herda os atributos e métodos comuns de Veiculo.
 */
public class Caminhao extends Veiculo {

    // Quantidade de eixos do caminhão.
    private int eixos;

    // Inicializa os dados herdados e a quantidade de eixos.
    public Caminhao(String placa, int ano, int eixos) {
        super(placa, ano);
        this.eixos = eixos;
    }

    // Define a quantidade de eixos.
    public void setEixos(int eixos) { 
        this.eixos = eixos; 
    }

    // Retorna a quantidade de eixos.
    public int getEixos() { 
        return eixos; 
    }

    // Sobrescreve o método para exibir os dados específicos.
    @Override
    public void exibirDados() {
        System.out.println("Tipo: Caminhão");
        super.exibirDados();
        System.out.println("Eixos: " + eixos);
    }
}

