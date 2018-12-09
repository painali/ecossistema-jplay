package game;

import classes.Ambiente;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

/**
 *
 * @author x0n4d0
 */

public class Main {

    private static Window janela;
    private static GameImage plano;
    private static Keyboard teclado;
    
    
    public static void main(String[] args) {
        janela = new Window(800,600);
        plano = new GameImage(URL.sprite("menu.png"));
        
        teclado = janela.getKeyboard();

        while(true) {
            plano.draw();
            janela.update();
 
            if(teclado.keyDown(Keyboard.ENTER_KEY)) {
                new Ambiente(janela);
                //JOptionPane.showMessageDialog(null, "Funcionando");
            }
                
            
        }      
        
        
    }
    
}
