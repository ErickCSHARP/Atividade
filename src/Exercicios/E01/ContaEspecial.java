package Exercicios.E01;

public class ContaEspecial 
{
    private String titular;
    private double saldo;
    private double limite;

    public ContaEspecial(String titular, double saldo, double limite) 
    {
        this.titular = titular;
        this.saldo = saldo;
        this.limite = limite;
    }

    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    public double getLimite() { return limite; }

    public void depositar(double valor) {
        if (valor > 0) saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo + limite) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public String consultar() {
        return "Titular: " + titular + " | Saldo: R$ " + saldo;
    }
}

