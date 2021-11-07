package MODEL;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;


public class Doador {
    
    private String nome, nascimento;
    private double peso;
    private boolean doencas;
    private int idade;

    public Doador(String nome, String nascimento, double peso, String doencas, int idade) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.peso = peso;
        this.setDoencas(doencas);
        this.idade = idade;
    }

    public Doador() {
    }

    public String getNome() {
        return nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public double getPeso() {
        return peso;
    }

    public boolean isDoencas() {
        return doencas;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setDoencas(String doencas) {
        
        if(doencas.equalsIgnoreCase("não") || doencas.equalsIgnoreCase("nao")){
            this.doencas = false;
        }else{
            this.doencas = true;
        }
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    
    
    
}
