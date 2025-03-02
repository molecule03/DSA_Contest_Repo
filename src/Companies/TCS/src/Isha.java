package Companies.TCS.src;

import java.util.Scanner;

public class Isha {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        int pos = 0;
        int neg = 0;
        boolean flag = true;
        if(arr[0] < 0) {
            neg = arr[0];
            flag = true;
        }
        else{
            pos = arr[0];
            flag = false;
        }
        int sum = arr[0];
        int lastAdd = arr[0];
        for(int i=1; i<n; i++){
            if(flag || arr[i] > 0){
                if(lastAdd < 0 && arr[i] > 0){
                    sum += arr[i];
                    pos = arr[i];
                    lastAdd = arr[i];
                    flag = false;
                }
                else if(lastAdd > 0 && arr[i] > pos){
                    sum -= pos;
                    sum += arr[i];
                    pos = arr[i];
                    lastAdd = arr[i];
                    flag = false;
                }
            }
            if( (!flag) || arr[i] < 0) {
                if (lastAdd > 0 && arr[i] < 0) {
                    sum += arr[i];
                    neg = arr[i];
                    lastAdd = arr[i];
                    flag = true;
                } else if (lastAdd < 0 && arr[i] > neg) {
                    sum -= neg;
                    sum += arr[i];
                    neg = arr[i];
                    lastAdd = arr[i];
                    flag = true;
                }
            }
            System.out.println(sum +"   last = "+ lastAdd);
        }

        System.out.println(sum);

    }
}
