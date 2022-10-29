package servicos;

import dados.Homem;
import dados.Mulher;
import dados.Pessoa;
import dados.Registros;
import saida.Saida;
import validacao.Validacao;

public class Servicos {
    public static void cadastraHomem(Registros registros){
        Homem homem = new Homem();
        int numero;

        do{

            numero = Validacao.validaNumero();

        }while(Validacao.checaRepeticaoNumero(numero, registros));

        homem.setNumero(numero);
        homem.setNome(Validacao.validaNome());
        homem.setSituacaoSaude(Validacao.validaSituacaoSaude());
        homem.setIdade(Validacao.validaIdade());

        registros.addRegistro(homem);
    }

    public static void cadastraMulher(Registros registros){
        Mulher mulher = new Mulher();
        int numero;

        do{

            numero = Validacao.validaNumero();

        }while(Validacao.checaRepeticaoNumero(numero, registros));

        mulher.setNumero(numero);
        mulher.setNome(Validacao.validaNome());
        mulher.setSituacaoSaude(Validacao.validaSituacaoSaude());
        mulher.setFoiGestante(Validacao.validaGestacao());

        registros.addRegistro(mulher);
    }

    public static int quantidadeContaminacoes(char condicao, Registros registros) {
        int aux = 0;

        for (Pessoa pessoa : registros.getRegistro()) {
            if (pessoa.getSituacaoSaude() == condicao) {
                aux++;
            }
        }

        return aux;

    }

    public static int quantidadeSaudaveis(char sexo, Registros registros) {
        int aux = 0;

        if(sexo == 'm'){
            for (Pessoa pessoa : registros.getRegistro()) {
                if(pessoa instanceof Homem){
                    if(pessoa.getSituacaoSaude() == 's'){
                        aux++;
                    }
                }
            }
        }else
            for (Pessoa pessoa : registros.getRegistro()) {
                if(pessoa instanceof Mulher){
                    if(pessoa.getSituacaoSaude() == 's'){
                        aux++;
                    }
                }
            }

        return aux;

    }
}
