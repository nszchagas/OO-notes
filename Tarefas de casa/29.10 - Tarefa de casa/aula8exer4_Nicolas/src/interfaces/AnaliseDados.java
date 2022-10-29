package interfaces;

import java.util.Vector;

public interface AnaliseDados {

	float[] getMaiorEMenor();

	Vector<Object> getDuplicados(int valor);

	float getSoma(char tipo);

	float getMedia(char tipo);

}
