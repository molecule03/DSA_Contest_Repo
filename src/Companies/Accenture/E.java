package Companies.Accenture;

import java.util.Scanner;

public class E {

   static class Garage{
         public int bikes;
         public int cars;
         public int trucks;
    }

    static int MaxRevnue(Garage[] garages){

        int sum = 0;
        int max = 0;
        for(int i=0; i< garages.length; i++){
            Garage g = garages[i];

            sum = (g.bikes*100 + g.cars*250 + g.trucks*500);
            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {

        Garage g[] = new Garage[4];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<4; i++){
            Garage gg = new Garage();
            gg.bikes = sc.nextInt();
            gg.cars = sc.nextInt();
            gg.trucks = sc.nextInt();
            g[i] = gg;
        }

        System.out.println(MaxRevnue(g));
    }
}
