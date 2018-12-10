package classes
public class SistemaLocomotor extends Sistema{

    protected void andar(Ator a,Ambiente amb){
        int i = random.getRandom(a);

        switch(i){
            case 4:
                a.setPosX((byte) (a.x-1),amb);
                break;
            case 7:
                a.setPosXY((int) a.x-1,(int) a.y-1,amb);
                break;
            case 8 :
                a.setPosY((byte) (a.y-1),amb);
                break;
            case 9:
                a.setPosXY((int) a.x+1,(int) a.y-1,amb);
                break;
            case 6:
                a.setPosX((byte) (a.x+1),amb);
                break;
            case 3:
                a.setPosXY((int) a.x+1,(int) a.y+1,amb);
                break;
            case 2:
                a.setPosY((byte) (a.y+1),amb);
                break;
            case 1:
                a.setPosXY((int) a.x-1,(int) a.y+1,amb);
                break;
        }
        a.retiraEnergia(10);
    }
}
