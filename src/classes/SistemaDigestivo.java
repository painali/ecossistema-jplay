package classes;

public class SistemaDigestivo extends Sistema {
    protected void comer(Ambiente amb,Ator a,byte posx,byte posy){
        amb.atorList.remove(amb.tab[posx][posy]); // Remove o ator devorado da posição x e y dada
        a.addEnergia(50);
    }
}