package servicos;

import dados.Grupo;
import dados.Homem;
import dados.Mulher;
import dados.Pessoa;

public class Servicos {
	public static int[] identificaSituacao(Grupo grupo) {
		int casos[] = new int[5];
		
		for (Pessoa pessoa : grupo.getGrupo()) {
			switch(pessoa.getSituacao()) {
			case 'C':{
				casos[0]++;
				break;
			}
			case 'T':{
				casos[1]++;
				break;
			}
			case 'F':{
				casos[2]++;
				break;
			}
			case 'S':{
				if(pessoa instanceof Homem)
					casos[3]++;
				if (pessoa instanceof Mulher)
					casos[4]++;
			}
			}
		}
		return casos;
	}
}
