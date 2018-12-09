package classes;

import java.awt.Point;
import java.util.Vector;
import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;
import jplay.URL;

/**
 *
 * @author x0n4d0
 */

public class Ator extends Sprite {

    protected int direcao = 3;
    double velocidade = 1;
    boolean movendo = false;
    boolean vivo = false;
    protected Sistema sistema;
    protected int id;
    protected char nome;
    protected int energia;
   
    Controle controle = new Controle();
    
    public Ator(String fileName, int numFrames) {
        super(fileName, numFrames);
    }
    
    public Ator(int x, int y, String fileName, int numFrames) {
        //super(fileName,numFrames);
        super(URL.sprite(fileName), numFrames);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
    }    

    /**
     * Controle de Caminho que não irá permitir que o personagem 
     * ultrapasse os bloqueios
     * @param cena 
     */
    public void caminho(Scene cena) {
        Point min = new Point((int)this.x,(int)this.y);
        Point max = new Point((int)this.x + this.width,(int)this.y + this.height);
    
        Vector<?>tiles = cena.getTilesFromPosition(min, max);
        
        for(int i=0; i<tiles.size(); i++) {
            TileInfo tile = (TileInfo) tiles.elementAt(i);
        
            if(controle.colisao(this, tile) == true) {
                if(colisaoVertical(this, tile)) {
                
                    if(tile.y + tile.height - 2 < this.y) {
                        this.y = tile.y + tile.height;

                    } else if(tile.y > this.y + this.height - 2 ) {
                        this.y = tile.y - tile.height;
                    }
                }
                if(colisaoHorizontal(this,tile)) {
                    if(tile.x > this.x + this.width - 2) {
                        this.x = tile.x - this.width;
                    } else {
                        this.x = tile.x + tile.width;
                    }
                }
            }
        }
    }
    
    private boolean colisaoVertical(GameObject obj, GameObject obj2) {
        if(obj.x + obj.width <= obj2.x)
            return false;
        return true;
    }

    private boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
        if(obj2.y + obj2.height <= obj.y)
            return false;
        return true;        
    }

    public void exibir() {
	System.out.println("--------------------------");
	System.out.println("Id: " + this.getId());		
	System.out.println("Nome: " + this.getNome());
	System.out.println("Energia: "+ this.getEnergia());
	//System.out.println("PosX: "+ this.x());
	//System.out.println("PosY: "+ this.y());
	System.out.println("--------------------------");
    }    

    public void setPosX(double x) {
        this.x = x;
    }
    public double getPosX() {
        return this.x;
    }    
    public void setPosY(double y) {
        this.y = y;
    }
    public double getPosY() {    
        return this.y;
    }
    public char getNome() {
        return nome;
    }
    public void setNome(char nome) {
        this.nome = nome;
    }
    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isVivo() {
        return vivo;
    }
    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    public Sistema getSistema() {
        return sistema;
    }
    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
}

   /*
   
    public void mover(Window janela) {
        if(teclado == null) {
            teclado = janela.getKeyboard();           
        }
        
        if(teclado.keyDown(Keyboard.LEFT_KEY)) {
            if(this.x > 0)
                this.x -= velocidade;
            if(direcao != 1) {
                setSequence(4,8);   // pega os quadros do 4 ao 8
                direcao = 1;
            }movendo = true;
        }else if(teclado.keyDown(Keyboard.RIGHT_KEY)) {
            if(this.x < janela.getWidth() - 60)
                this.x += velocidade;
            if(direcao != 2) {
                setSequence(8,12);   // pega os quadros do 4 ao 8
                direcao = 2;
            }movendo = true;                
        }else if(teclado.keyDown(Keyboard.UP_KEY)) {
            if(this.y > 0)
                this.y -= velocidade;
            if(direcao != 4) {
                setSequence(12,16);   // pega os quadros do 4 ao 8
                direcao = 4;
            }movendo = true;            
        } else if(teclado.keyDown(Keyboard.DOWN_KEY)) {
            if(this.y < janela.getHeight() - 60)
                this.y += velocidade;
            if(direcao != 5) {
                setSequence(0,4);   // pega os quadros do 4 ao 8
                direcao = 5;
            }movendo = true;        
        }
        
       // update();  // esse update faz o ator mover sozinho, sem o if
        if(movendo) {
            update();
            movendo = false;
        }
            
        //moveX(0.3);   // move automaticamente para o lado
        //moveY(0.3);   // move automaticamente na vertical         
    }
    
    */