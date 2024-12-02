
package model;

public class Contas {
    private int numero;  // Agora o numero é a chave principal
    private String nome;
    private String tipo;
    private double saldo;
    private double limite;
    private double rendimento;
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double getLimite() {
        return limite;
    }
    
    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    public double getRendimento() {
        return rendimento;
    }
    
    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}
