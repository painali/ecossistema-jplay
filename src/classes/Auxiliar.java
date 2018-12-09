package classes;

/**
 *
 * @author x0n4d0
 */

import java.util.Random;


public class Auxiliar {

    private static void pauseScript(int tSeg) {
        try {
           Thread.sleep(tSeg * 1000);
        }catch(InterruptedException e) {
            
        }
    }

    private static Random rand = new Random();
	
    public static char getLetraRand() {
	String ALFABETO="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	return (ALFABETO.charAt(rand.nextInt(ALFABETO.length())));
    }
	
    public static boolean isNumNegativo(int valor) {
	return (valor < 0);
    }  
		
    public static boolean isLetra(char ch) {
    	return (Character.isLetter(ch));
    }

    public static byte getMaior(int x, int y) {
    	if(x > y)	return (byte)0;
    	else if(x < y)	return (byte)1;
    	else	return (byte)-1;
    }
    
    public static byte getRandPos() {
    	return (byte)(rand.nextInt(Ambiente.TAB_SIZE_MAX));
    }
   
}
