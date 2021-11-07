package CONTROLLER;

import java.time.LocalDate;
import java.time.Period;


public class Controller_Doador {
    
    
    public static int idade (String nascimento){
        
        String [] data = nascimento.split("/");
        
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);
        
        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
        
        Period idade = Period.between(dataNascimento, LocalDate.now());
        
        return idade.getYears();
    }
}
