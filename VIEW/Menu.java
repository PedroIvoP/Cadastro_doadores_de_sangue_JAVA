package VIEW;

import MODEL.Doador;
import CONTROLLER.Controller_Doador;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void Principal(ArrayList<Doador> doadores) {

        while (0 == 0) {

            try {

                Scanner get = new Scanner(System.in);
                int opcao;

                System.out.println("\n--------------------------------");
                System.out.println("        MENU PRINCIPAL          ");
                System.out.println("--------------------------------");
                System.out.println("1 - CADASTRAR");
                System.out.println("2 - CONSULTAR");
                System.out.println("3 - **SAIR**");
                System.out.print("Opção selecionada: ");
                opcao = get.nextInt();

                switch (opcao) {

                    case 1:
                        Cadastro(doadores);
                        break;

                    case 2:
                        Imprime(doadores);
                        break;

                    case 3:
                        System.out.println("\nSaindo do sistema...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("\nOpção inválida! Tente novamente!\n");
                        break;
                }

            } catch (InputMismatchException e) {

                System.out.println("\nDigite um numeral correspondente às opções disponíveis.\n");

            } catch (Exception e) {

                System.out.println("\n" + e);
            }

        }
    }

    private static void Cadastro(ArrayList<Doador> doadores) {

        try {

            Scanner recebe = new Scanner(System.in);

            System.out.print("\nNome: ");
            String nome = recebe.nextLine();

            System.out.print("Data de nascimento (dd/mm/aaaa): ");
            String nascimento = recebe.nextLine();

            int idade = Controller_Doador.idade(nascimento);

            if (idade < 18 || idade > 60) {

                throw new idadeInvalida();
            }

            System.out.print("Peso (Kg): ");
            double peso = recebe.nextDouble();

            if (peso < 50) {

                throw new pesoBaixo();
            }

            //limpando do buffer
            recebe.nextLine();

            System.out.print("Possui histórico de doenças hepáticas (Sim/Não): ");
            String doencas = recebe.nextLine();
            
            if(doencas.equalsIgnoreCase("sim")){
                
                throw new historicoDoenca();
            }

            if (!(doencas.equalsIgnoreCase("sim") || doencas.equalsIgnoreCase("nao") || doencas.equalsIgnoreCase("não"))) {

                throw new opcaoDoencaIncorreta();
            }

            doadores.add(new Doador(nome, nascimento, peso, doencas, idade));
            System.out.println("\nDoador cadastrado com sucesso!\n");

        } catch (opcaoDoencaIncorreta e) {

            System.out.println(e);

        } catch (idadeInvalida e) {

            System.out.println(e);

        } catch (pesoBaixo e) {

            System.out.println(e);

        } catch (historicoDoenca e){
            
            System.out.println(e);
            
        } catch (InputMismatchException e) {

            System.out.println("\n ###ERRO, DOADOR NÃO CADASTRADO###: Valores inválidos\n");

        } catch (NumberFormatException e) {

            System.out.println("\n ###ERRO, DOADOR NÃO CADASTRADO###: Data de nascimento inválida\n");

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("\n ###ERRO, DOADOR NÃO CADASTRADO###: Data de nascimento inválida\n");

        } catch (DateTimeException e) {

            System.out.println("\n ###ERRO, DOADOR NÃO CADASTRADO###: Data de nascimento inválida\n");

        } catch (Exception e) {

            System.out.println(e);
        }

    }

    private static void Imprime(ArrayList<Doador> doadores) {

        try {

            if (doadores.isEmpty()) {

                throw new nenhumCadastro();
            }

            System.out.println("\n---Doadores cadastrados---\n");
            for (Doador d : doadores) {

                System.out.println("\nNome: " + d.getNome());
                System.out.println("Idade: " + d.getIdade());
                System.out.println("Data de Nascimento: " + d.getNascimento());
                System.out.println("Peso: " + d.getPeso() + "Kg");

                String doencas;

                if (d.isDoencas()) {
                    doencas = "Sim";
                } else {
                    doencas = "Não";
                }
                System.out.println("Doenças Hepáticas? " + doencas);

                System.out.println("************************");
            }

            System.out.println("\n------------------------\n");

        } catch (nenhumCadastro e) {

            System.out.println(e);
            
        } catch (Exception e){
            
            System.out.println(e);
        }

    }
}

/*ERROS*/
class opcaoDoencaIncorreta extends Exception {

    @Override
    public String getMessage() {

        return "\n ###ERRO, DOADOR NÃO CADASTRADO###: A resposta sobre o histórico de doenças hepáticas deve ser \"Sim\" ou \"Não\" \n";
    }
}

class idadeInvalida extends Exception {

    @Override
    public String getMessage() {

        return "\n ###ERRO, DOADOR NÃO CADASTRADO###: Idade fora do padrão permitido";
    }
}

class pesoBaixo extends Exception {

    @Override
    public String getMessage() {

        return "\n ###ERRO, DOADOR NÃO CADASTRADO###: Peso abaixo do permitido";
    }
}

class historicoDoenca extends Exception{
    
    @Override
    public String getMessage(){
        
        return "\n ###ERRO, DOADOR NÃO CADASTRADO###: O doador não pode possuir nenhum histórico de doença hepática";
    }
}

class nenhumCadastro extends Exception {

    @Override
    public String getMessage() {

        return "\n Nenhum doador cadastrado!";
    }
}
