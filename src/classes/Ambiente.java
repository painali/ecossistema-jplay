package classes;

import java.util.ArrayList;
import java.util.Random;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Ambiente {

    private Window janela;
    private Scene cena;     
    public ArrayList<Ator> atorList = new ArrayList();
    private Ator ator;
    public char tab[][];
    protected int numAtores;
    protected byte idRodada;
    private final Random rand = new Random();

    public static final int TAB_SIZE_MAX = 16;
    public static final int TAB_SIZE_MIN = 0;

    
    public Ambiente(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile(URL.scenario("cenario.scn"));
        ator = new Ator(650,450,"ator.png",20);
        ator.update();
        run();
    }
    
    public Ambiente() {
        
        this.tab = new char[TAB_SIZE_MAX][TAB_SIZE_MAX];
    
        for (int i = 0; i < TAB_SIZE_MAX; i++) 
            for (int j = 0; j < TAB_SIZE_MAX; j++) 
                this.tab[i][j] = ID.SOLO.getCharID();
    }    

    private void run() {
        while(true) {
            /* Fazer a cena movimentar com o ator */
            //cena.moveScene(ator);
            //ator.x += cena.getXOffset();
            //ator.y += cena.getYOffset();

            /* Cena fixa, é o que eu preciso.. */
            cena.draw();                  
            ator.caminho(cena);
            ator.draw();
            ator.mover(janela);
            janela.update();        
        }
    }
    
    public void exibir() {
        for (int i = 0; i < TAB_SIZE_MAX; i++) {
            for (int j = 0; j < TAB_SIZE_MAX; j++) {
                System.out.printf("|"+tab[i][j]);
            }
            System.out.println("|");
        }
    }
    
    public void addAtor(Ator ator, byte i, byte j) {
        atorList.add(ator);
        this.tab[i][j] = ator.getNome();
        this.numAtores++;
    }
    
    public void addAtor(Ator ator) {
        atorList.add(ator);
    	this.numAtores++;
    }

    public void removeAtor(Ator ator) {
        atorList.remove(ator);
        this.numAtores--;
    }
    
    public void gerarAmbiente() {  

        /* Gerar junto com atores */
        char tipoAmbiente[] = {ID.SOLO.getCharID(),ID.FOOD.getCharID()};
    	
    	for(int i = 0; i < TAB_SIZE_MAX; i++) { 
    		for(int j = 0; j < TAB_SIZE_MAX; j++) {
                    this.setChar(tipoAmbiente[rand.nextInt(tipoAmbiente.length - 1)], (byte)i, (byte)j);
                    // cena.changeTile(x,y,(int) parametroIntImg);
                    
                }
        }
    }
    
    public byte batalha(Ator a, Ator b) {
    	byte retorno;
    	int indexA = 0;
    	int indexB = 1;
    	
    	retorno = Auxiliar.getMaior(a.getEnergia(),b.getEnergia());
    	
        switch (retorno) {
            case -1:
                retorno = (rand.nextInt(indexB + 1) == indexA) ? (retorno = (byte)indexB) : (retorno = (byte)indexA);
                if(retorno == indexB)	this.removeAtor(a);
                else    			this.removeAtor(b);
                break;
            case 0:
                this.removeAtor(b);
                retorno = (byte)indexA;
                break;
            case 1:
                this.removeAtor(a);
                retorno = (byte)indexB;
                break;
            
            default:
                return -1;
        }

    	return retorno;
    }
    
    public void setChar(char charEntrada, byte x, byte y) {
        this.tab[x][y] = charEntrada;
    }
    public char getChar(byte x, byte y) {
    	return (this.tab[x][y]);     	
    }      
    public int getNumAtores() {
        return numAtores;
    }
    public void setNumAtores(int numAtores) {
        this.numAtores = numAtores;
    }
    public byte getIdRodada() {
        return idRodada;
    }
    public void setIdRodada(byte idRodada) {
        this.idRodada = idRodada;
    }
    
}
