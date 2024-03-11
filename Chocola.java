import java.util.Arrays;
import java.util.Comparator;

public class Chocola {
    public static void main(String[] args) {
        //Integer horPrice[] = { 2, 1, 3, 1, 4 };
        Integer horPrice[] = {3};
        //Integer verPrice[] = { 4, 1, 2 };
        Integer verPrice[] = {2};

        Arrays.sort(horPrice, Comparator.reverseOrder());
        Arrays.sort(verPrice, Comparator.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost=0;

        while (h<horPrice.length && v<verPrice.length) {
            if(horPrice[h]>=verPrice[v]){
                cost+=vp*horPrice[h];
                hp++;
                h++;
            }
            else{
                cost += hp * verPrice[v];
                vp++;
                v++;
            }
        }
        while (h < horPrice.length) {
            cost += vp * horPrice[h];
            hp++;
            h++;
        }
        while (v < verPrice.length) {
            cost += hp * verPrice[v];
            vp++;
            v++;
        }
        System.out.println(cost);

    }
}
