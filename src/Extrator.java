import java.io.*;
import java.util.HashMap;

/**
 * Created by douglas on 5/17/16.
 */
public class Extrator {
    public static void printInfo(TileType tipoPeca, int coluna, int rotacao, TileType[][] tiles) {
        /*System.out.println("tiles = ");
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[0].length; x++) {
                System.out.print(tiles[y][x] == null ? 0 : 1);
            }
            System.out.println();
        }*/
        PrintWriter writer;
        try {
            writer =new PrintWriter(new FileOutputStream(new File("jaderson.txt"), true ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }


        writer.print(codificaPeca(tipoPeca)+"/"+codificaTabuleiro(tiles));
        writer.print("\n");
        writer.println(codificaColuna(coluna)+"/"+codificaRotacao(rotacao));
        writer.close();


    }

    private static String codificaPeca(TileType tipo) {
        HashMap<TileType, String> codificados = new HashMap<TileType, String>();
        codificados.put(TileType.TypeL, "1000000");
        codificados.put(TileType.TypeS, "0100000");
        codificados.put(TileType.TypeI, "0010000");
        codificados.put(TileType.TypeZ, "0001000");
        codificados.put(TileType.TypeO, "0000100");
        codificados.put(TileType.TypeT, "0000010");
        codificados.put(TileType.TypeJ, "0000001");
        return codificados.get(tipo);
    }

    private static String codificaTabuleiro(TileType[][] tiles) {
        int x, y;

        for (y = 0; y < tiles.length; y++) {
            boolean fim = false;
            for (x = 0; x < tiles[0].length; x++) {
                if (!(tiles[y][x] == null)){
                    fim = true;
                    break;
                }
            }
            if(fim) break;
        }
        //System.out.println("encontrou linha inicial = "+y);
        if (y > tiles.length - 4) {
            y = tiles.length - 4;
        }
        int linhaInicial = y;

        String saida = "";

        for (x = 0; x < tiles[0].length; x++) {
            for (y = linhaInicial; y <= linhaInicial + 4; y++) {
                if (y == linhaInicial + 4 || tiles[y][x] != null) {
                    saida += codificaLinha(y - linhaInicial);
                    break;
                }
            }
        }
        return saida;
    }

    private static String codificaLinha(int linha) {
        HashMap<Integer, String> codificacao = new HashMap<Integer, String>();
        codificacao.put(0, "1000000000000000000000");
        codificacao.put(1, "0100000000000000000000");
        codificacao.put(2, "0010000000000000000000");
        codificacao.put(3, "0001000000000000000000");
        codificacao.put(4, "0000100000000000000000");
        codificacao.put(5, "0000010000000000000000");
        codificacao.put(6, "0000001000000000000000");
        codificacao.put(7, "0000000100000000000000");
        codificacao.put(8, "0000000010000000000000");
        codificacao.put(9, "0000000001000000000000");
        codificacao.put(10, "0000000000100000000000");
        codificacao.put(11, "0000000000010000000000");
        codificacao.put(12, "0000000000001000000000");
        codificacao.put(13, "0000000000000100000000");
        codificacao.put(14, "0000000000000010000000");
        codificacao.put(15, "0000000000000001000000");
        codificacao.put(16, "0000000000000000100000");
        codificacao.put(17, "0000000000000000010000");
        codificacao.put(18, "0000000000000000001000");
        codificacao.put(19, "0000000000000000000100");
        codificacao.put(20, "0000000000000000000010");
        codificacao.put(21, "0000000000000000000001");
        return codificacao.get(linha);
    }

    private static String codificaRotacao(int rot) {
        HashMap<Integer, String> codificacao = new HashMap<Integer, String>();
        codificacao.put(0, "1000");
        codificacao.put(1, "0100");
        codificacao.put(2, "0010");
        codificacao.put(3, "0001");
        return codificacao.get(rot);
    }

    private static String codificaColuna(int coluna){
        HashMap<Integer, String> codificacao = new HashMap<Integer, String>();
        codificacao.put(0, "1000000000");
        codificacao.put(1, "0100000000");
        codificacao.put(2, "0010000000");
        codificacao.put(3, "0001000000");
        codificacao.put(4, "0000100000");
        codificacao.put(5, "0000010000");
        codificacao.put(6, "0000001000");
        codificacao.put(7, "0000000100");
        codificacao.put(8, "0000000010");
        codificacao.put(9, "0000000001");
        return codificacao.get(coluna);
    }
}
