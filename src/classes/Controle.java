package classes;

import jplay.GameObject;
import jplay.TileInfo;

/**
 *
 * @author x0n4d0
 */
public class Controle {

    /**
     * O 7 representa os 7 primeiro "tiles" que nós passamos no 
     * arquivo .scn. Esses 7 serão bloqueios e acusarão colisão.
     * Podemos inserir nas posições os arquivos que serão atores
     * e comida, para fazer a colisão e "batalha";
     * @param obj
     * @param tile
     * @return 
     */
    public boolean colisao(GameObject obj, TileInfo tile) {
        if((tile.id >= 7) && obj.collided(tile)) {
            return true;
        }
        return false;
    }
    
}
