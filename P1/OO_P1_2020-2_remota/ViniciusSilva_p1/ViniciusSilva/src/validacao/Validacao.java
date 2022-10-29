package validacao;


import dados.Registros;
import leitura.Leitura;
import saida.Saida;
import java.util.InputMismatchException;


public class Validacao {
    public static int validaContinua(){
        int check = -1;
        boolean erro;

        do{

            try{
                check = Leitura.leInt();
            }catch(InputMismatchException e){
                System.err.println("Tipo de dado invalido.\n");
                erro = true;
            }

            if(check != 1 && check != 0 && check != 2){
                System.err.println("Digite uma opcao valida.");
                erro = true;
            }else
                erro = false;

        }while(erro);

        Saida.limpaTela(1);

        return check;
    }

    public static boolean validaOpcao(Registros registros){
        boolean continua = true;

        Saida.menuCadastros();

        switch (Validacao.validaContinua()){
            case 1:
                continua = true;
                break;
            case 2:
                Saida.mostraRegistros(registros);
                return validaOpcao(registros);
            case 0:
                Saida.mostraDados(registros);
                continua =  false;
                break;
        }

        return continua;
    }

    public static StringBuilder validaNome(){
        String nome;
        StringBuilder nomecompleto = new StringBuilder();
        Saida.limpaTela(1);
        System.out.println("Digite o nome a ser cadastrado: ");

        do {

            nome = Leitura.leString();

            if(!nome.trim().contains(" ") || nome.isEmpty() || nome.length() < 2) {
                System.err.println("\nDigite o nome completo.\n");
            }

        }while(!nome.trim().contains(" ") || nome.isEmpty() || nome.length() < 2);

        return nomecompleto.append(nome);

    }

    public static int validaNumero(){
        int numero = 0;
        final int MAIOR = 100;
        System.out.println("\nInforme o numero de identificacao a ser cadastrado: ");

        try{
            numero = Leitura.leInt();
        }catch(InputMismatchException e){
            System.err.println("O numero deve conter apenas numeros.");
        }
        if(numero < MAIOR){
            System.err.println("O numero deve ser maior que " + MAIOR);
        }

        return (numero < MAIOR ? validaNumero() : numero);
    }

    public static char validaSituacaoSaude(){
        char situacao;

        Saida.menuContaminacao();

        do{
            situacao = Leitura.leChar();

            if(situacao != 't' && situacao != 's' && situacao != 'c' && situacao != 'f'){
                System.err.println("Digite uma opcao valida.");
            }

        }while(situacao != 't' && situacao != 's' && situacao != 'c' && situacao != 'f');

        Saida.limpaTela(1);

        return situacao;
    }

    public static char validaSexo(){
        char sexo;

        System.out.println("Informe o sexo (M ou F): ");

        do{
            sexo = Leitura.leChar();

            if(sexo != 'm' && sexo != 'f'){
                System.err.println("Digite uma opcao valida.");
            }

        }while(sexo != 'm' && sexo != 'f');

        return sexo;
    }

    public static int validaIdade(){
        int idade = -1;

        System.out.println("Digite a idade a ser cadastrada: ");
        do {
            try{
                idade = Leitura.leInt();
            }catch(InputMismatchException e){
                System.err.println("Tipo de dado invalido.");
            }

            if(idade < 0 || idade > 150){
                System.err.println("Informe uma idade entre 0 e 150.\n");
            }

        }while(idade < 0 || idade > 150);

        return idade;

    }

    public static char validaGestacao(){
        char gestacao;

        do{
            gestacao = Leitura.leChar();

            if(gestacao != 't' && gestacao != 's' && gestacao != 'n'){
                System.err.println("Digite uma opcao valida.");
            }

        }while(gestacao != 't' && gestacao != 's' && gestacao != 'n');

        return gestacao;
    }

    public static boolean checaRepeticaoNumero(int check, Registros registros){
        int i=0;

        while(i<registros.getRegistro().size()){
            if(check == registros.getRegistro().get(i).getNumero()){
                System.err.println("Numero ja cadastrado.");
                return true;
            }
            i++;
        }

        return false;
    }
}
