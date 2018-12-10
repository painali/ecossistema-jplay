package classes;
import java.util.Random;

public class random {
    public static int getRandom(Ator a) {
        int aux[] = {1, 2, 3, 4, 6, 7, 8, 9};
        if (a.x == 0 && a.y == 0) {
            int[] aux2 = {2, 3, 6};
            return aux2[new Random().nextInt(aux2.length)];

        }
        if (a.x == 0 && a.y == 15) {
            int[] aux2 = {8, 9, 6};
            return aux2[new Random().nextInt(aux2.length)];
        }

        if (a.x == 15 && a.y == 0) {
            int[] aux2 = {1, 4, 2};
            return aux2[new Random().nextInt(aux2.length)];
        }
        if (a.x == 15 && a.y == 15) {
            int[] aux2 = {7, 8, 4};
            return aux2[new Random().nextInt(aux2.length)];
        } else if (a.x == 0) {
            int[] aux2 = {8, 9, 6, 3, 2};
            return aux2[new Random().nextInt(aux2.length)];

        } else if (a.y == 0) {
            int[] aux2 = {4, 1, 6, 3, 2};
            return aux2[new Random().nextInt(aux2.length)];
        } else if (a.x == 15) {
            int[] aux2 = {4, 1, 7, 8, 2};
            return aux2[new Random().nextInt(aux2.length)];
        } else if (a.y == 15) {
            int[] aux2 = {4, 6, 7, 8, 9};
            return aux2[new Random().nextInt(aux2.length)];
        } else return aux[new Random().nextInt(aux.length)];
    }


}
