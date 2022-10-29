package saida;

import dados.Pessoa;
import dados.Registros;
import servicos.Servicos;

public class Saida {
    public static void limpaTela(int n){
        for(int i=0; i<n ; i++ ){
            System.out.println();
        }
    }

    public static void menuContaminacao(){
        limpaTela(1);
        System.out.println("Informe a situacao de saude: ");
        System.out.println("T - Contaminada em tratamento");
        System.out.println("F - Contaminada falecida");
        System.out.println("C - Contaminada curada");
        System.out.println("S - Sem contaminacao");
    }

    public static void menuGestacao(){
        limpaTela(1);
        System.out.println("Informe se a pessoa ja foi gestante: ");
        System.out.println("S - Sim");
        System.out.println("N - Nao");
        System.out.println("T - Nao tem certeza");
    }

    public static void menuCadastros(){
        limpaTela(1);
        System.out.println("Informe o que deseja: ");
        System.out.println("1 - Registro novo");
        System.out.println("2 - Relatorio de todos os registros");
        System.out.println("0 - Sair");
    }

    public static void mostraRegistros(Registros registros){
        System.out.format("%15s %25s %30s %10s %10s", "Identificador", "Nome", "Situacao de saude", "Idade", "Gestante");
        limpaTela(2);
        for(Pessoa pessoa : registros.getRegistro()){
            System.out.println(pessoa);
        }
        limpaTela(2);

    }

    public static void mostraDados(Registros registros){
        limpaTela(40);
        System.out.println(Servicos.quantidadeContaminacoes('c', registros) + " = CONTAMINADOS CURADOS");
        System.out.println(Servicos.quantidadeContaminacoes('t', registros) + " = CONTAMINADOS EM TRATAMENTO");
        System.out.println(Servicos.quantidadeContaminacoes('f', registros) + " = CONTAMINADOS FALECIDOS");
        System.out.println(Servicos.quantidadeSaudaveis('m', registros) + " = HOMENS SEM CONTAMINACAO");
        System.out.println(Servicos.quantidadeSaudaveis('f', registros) + " = MULHERES SEM CONTAMINACAO");
        System.out.println(registros.getRegistro().size() + " = TOTAL DE REGISTROS DE PESSOAS");

    }

}
