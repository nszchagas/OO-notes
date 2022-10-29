package dados;

public class Pessoa {
    private StringBuilder nome;
    private Integer numero;
    private Character situacaoSaude;

    public StringBuilder getNome() {
        return nome;
    }

    public void setNome(StringBuilder nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Character getSituacaoSaude() {
        return situacaoSaude;
    }

    public void setSituacaoSaude(Character situacaoSaude) {
        this.situacaoSaude = situacaoSaude;
    }

    @Override
    public String toString() {
        return String.format("%15s %25s %30s %10s %10s", getNumero(), getNome(), nomeToExtenso(getSituacaoSaude()), "-", "-");
    }

    public String nomeToExtenso(char c) {
        String s;

        if(c == 't')
            s = "Contaminada em tratamento";
        else if (c == 'f')
            s = "Contaminada falecida";
        else if (c == 'c')
            s = "Contaminada curada";
        else
            s = "Sem contaminacao";

        return s;
    }
}
