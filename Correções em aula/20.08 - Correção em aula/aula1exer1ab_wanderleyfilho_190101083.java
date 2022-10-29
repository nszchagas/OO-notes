/*
#include <stdio.h>

int main(void) {
  
    const int MAX = 3;
    float alturaA = 1.58;
    float alturaB = 2.07;
    float alturaC = 0.55;
    float media;

    media = (alturaA + alturaB + alturaC) / MAX;

    printf("Media das alturas: %.3f\n", media);

    return 0;
}
*/

class Main {

    public static void main(String[] args) {

      final int MAX = 3;
      float alturaA = 1.58F;
      float alturaB = 2.07F;
      float alturaC = 0.55F;
      float media;

      media = (alturaA + alturaB + alturaC) / MAX;

      System.out.printf("Media das alturas: %.3f\n", media);
    }
}
