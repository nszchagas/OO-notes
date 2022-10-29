package dados;

import java.util.ArrayList;

public class Registros {
    ArrayList<Pessoa> registro = new ArrayList<>();

    public ArrayList<Pessoa> getRegistro() {
        return registro;
    }

    public void addRegistro(Pessoa pessoa) {
        this.registro.add(pessoa);
    }
}
