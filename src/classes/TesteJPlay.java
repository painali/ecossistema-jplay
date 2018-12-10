package classes;
import jplay.*;

import javax.swing.*;


public class TesteJPlay {
    private Scene cena;
    private Window janela;
    Ambiente amb;
    
        public TesteJPlay(Window window){
            janela = window;
            cena = new Scene();
            cena.loadFromFile(URL.scenario("cenario.scn"));
            Keyboard teclado = janela.getKeyboard();
            amb = new Ambiente();
            Gerador.addAtores(amb);
            run();
        }
    private void run(){
        while(true){
            cena.draw();
            Gerador.gerarAmbiente(amb,cena);
            janela.update();
            System.out.println(amb.atorList.get(0).x + " " + amb.atorList.get(0).y);
            amb.atorList.get(0).s.andar(amb.atorList.get(0),amb);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        }


    public static void main(String[] args) {
            Window janela = new Window(800,800);
        TesteJPlay teste = new TesteJPlay(janela);
    }

}
