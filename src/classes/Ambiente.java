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

    
    public Ambiente(Window window, int numAtores) {
       
        carregarAtores();
        carregarAmbiente(this.atorList);
        carregarCenario(window);
        run();
    }
    
    public Ambiente() {
        
    }
    
    private void run() {
        while(true) {
            /* Cena fixa */
            cena.draw();                  
            ator.caminho(cena);
            ator.draw();
            ator.mover(janela);
            janela.update();        
        }
    }
    
    private void carregarCenario(Window window) {
        this.janela = window;
        this.cena = new Scene();
        cena.loadFromFile(URL.scenario("cenario.scn"));        
    }
    
    private void carregarAtores() {
   
        //ator = new Ator(650,450,"ator.png",20);
        //ator.update();
        
        String filename[] = {"ator.png",};
        int numFrames[] = {20};
        int xRand,yRand;
                
        for(int i=0; i < numAtores; i++) {
            
            xRand = rand.nextInt(TAB_SIZE_MAX);
            yRand = rand.nextInt(TAB_SIZE_MAX);
            /* Fazer a verificação de não gerar na mesma posição, antes do construtor... */ 
            atorList.add(i, new Ator(i,Auxiliar.getLetraRand(),xRand,yRand,filename[i],numFrames[i]));
            this.numAtores++;
        }
   
    }
    
    private void carregarAmbiente(ArrayList<Ator> atores) {
        
        this.tab = new char[TAB_SIZE_MAX][TAB_SIZE_MAX];
        char ambiente[] = new char[8];
        int i = 3, posVetorCharRand;
        
        /* Cria vetor de id para char ambiente */
        ambiente[0] = ID.SOLO.getCharID();
        ambiente[1] = ID.FOOD.getCharID();
        ambiente[2] = ID.TREE.getCharID();
        
        for(Ator ator: atores) {
            ambiente[i] = ator.getNome();
            i++;
        }
        /* Insere os charIDs no ambiente */
    	for(i = 0; i < TAB_SIZE_MAX; i++) { 
            for(int j = 0; j < TAB_SIZE_MAX; j++) {
                posVetorCharRand = rand.nextInt(ambiente.length);
                this.setChar(ambiente[posVetorCharRand], (byte)i, (byte)j);
                // cena.changeTile(x,y,(int) parametroIntImg);
            }
        }
    }

    //@Override
    public void removeAtor(Ator ator) {
        atorList.remove(ator);
        this.numAtores--;
    }
    
    //@Override
    public void exibirNoConsole() {
        for (int i = 0; i < TAB_SIZE_MAX; i++) {
            for (int j = 0; j < TAB_SIZE_MAX; j++) {
                System.out.printf("|"+tab[i][j]);
            }
            System.out.println("|");
        }
    }
    
    //@Override
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
