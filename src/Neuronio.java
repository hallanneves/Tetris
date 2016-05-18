import java.util.Random;

public class Neuronio {
    double[] pesos;

    public Neuronio(int tamanho) {
        pesos = new double[tamanho];
        Random r = new Random();
        for(int i=0;i<pesos.length;i++){
            pesos[i] = r.nextDouble();
        }
    }
}
