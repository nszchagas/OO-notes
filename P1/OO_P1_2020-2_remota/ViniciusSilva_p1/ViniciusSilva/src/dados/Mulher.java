package dados;

public class Mulher extends Pessoa{
    private Character foiGestante;

    public Character getFoiGestante() {
        return foiGestante;
    }

    public void setFoiGestante(Character foiGestante) {
        this.foiGestante = foiGestante;
    }

    @Override
    public String toString() {
        return String.format("%15s %25s %30s %10s %10s", getNumero(), getNome(), nomeToExtenso(getSituacaoSaude()), "-", gestacaoToExtenso(getFoiGestante()));
    }

    public String gestacaoToExtenso(char c) {
        String s;

        if (c == 's')
            s = "Sim";
        else if (c == 'n')
            s = "Nao";
        else
            s = "Incerto";

        return s;
    }
}
