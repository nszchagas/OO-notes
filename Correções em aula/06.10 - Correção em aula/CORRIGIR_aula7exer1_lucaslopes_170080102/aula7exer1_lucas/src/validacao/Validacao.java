package validacao;

import leitura.Leitor;
import saida.*;
import java.util.InputMismatchException;

public class Validacao {
	public static String validaEvento() {
		String evento;
		
		Saida.apresentaMensagem("Descreva um evento no espaço:");
		do {
			evento = Leitor.leString();
			if(evento.isEmpty() || evento == null)
				Saida.apresentaMensagem("Invalido! Campo nao pode ser vazio:");
		}while(evento.isEmpty() || evento == null);
		return evento;
	}
	
	public static String validaPresidente() {
		String presidente;
		
		Saida.apresentaMensagem("Digite o nome completo do presidente brasileiro no ano do evento:");
		do {
			presidente = Leitor.leString();
			if(presidente.split(" ").length < 2 || presidente == null)
				Saida.apresentaMensagem("Invalido! Nome e sobrenome nao podem ser vazios:");
		}while(presidente.split(" ").length < 2 || presidente == null);
		return presidente;
	}
	
	public static int validaAno() {
		final int ANOMINIMO = 1900;
		final int ATUAL = 2020;
		int ano;

		Saida.apresentaMensagem("Digite o ano (Maior do que " + ANOMINIMO + " e menor do que " + ATUAL + "):");
		do {
			while(true) {
				try {
					ano = Leitor.leInteiro();
					break;
				}catch(InputMismatchException e) {
					Saida.apresentaMensagem("Invalido! Digite APENAS numeros:");
				}
			}
			if(ano <= ANOMINIMO || ano >= ATUAL)
				Saida.apresentaMensagem("Invalido! Ano deve ser maior do que " + ANOMINIMO + " e menor do que " + ATUAL + ":");
		}while(ano <= ANOMINIMO || ano >= ATUAL);
		
		return ano;
	}
	
	public static boolean validaContinua() {
		char continua;
		
		Saida.limpaTela(20);
		Saida.apresentaMensagem("Deseja realizar outro cadastro? (S = sim e N = nao)");
		do {
			continua = Leitor.leChar();
			if(continua != 's' && continua != 'n')
				Saida.apresentaMensagem("Invalido! Digite S ou N:");
		}while(continua != 's' && continua != 'n');
		return (continua == 's');
	}
	
	

}
