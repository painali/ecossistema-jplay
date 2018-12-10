import jplay.Scene;
import jplay.URL;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Gerador {
    public static void gerarAmbiente(Ambiente amb, Scene cena){
        for(int x=0;x<16;x++) {
            for (int y = 0; y < 16; y++) {
                if(amb.tab[x][y]==ID.SOLO.getcharID())
                cena.changeTile(x,y, ID.SOLO.getByteId());
                else if(amb.tab[x][y]=='a')
                    cena.changeTile(x,y,2);
            }
        }

    }
    public static void addAtores(Ambiente amb){
        Ator a = new Ator(1,1,amb);
        Ator b = new Ator(0,0,amb);
        Ator c = new Ator(2,2,amb);
        Ator d = new Ator(3,3,amb);

    }

}
