/**
 * Created by douglas on 5/17/16.
 */
public class Camada {
    Neuronio[] neuronios;

    public Camada(int quantidade,int numeroLigacoes) {
        neuronios = new Neuronio[quantidade];
        for(int i=0;i<quantidade;i++){
            neuronios[i] = new Neuronio(numeroLigacoes);
        }
    }
}
