
package Exercicios.E01;

public class ContaUniversitaria extends ContaEspecial 
{
    private int semestre;

    public ContaUniversitaria(String titular, double saldo, double limite, int semestre) 
    {

        super(titular, saldo, limite);
        this.semestre = semestre;
        
    }

    public int getSemestre() { return semestre; }

    
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= getSaldo() + getLimite()) {
            if (getSaldo() - valor < -getLimite() / 2) return false;
            return super.sacar(valor);
        }
        return false;
    }

   
    public String consultar() {
        return super.consultar() + " | Semestre: " + semestre;
    }
}


