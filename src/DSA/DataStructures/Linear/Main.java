package DSA.DataStructures.Linear;

import DSA.DataStructures.Linear.Stack.StackuArray;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//

//        O(n)  3 9 7 5 1
//
//        O()  5 1 7 3 9
//              0 1 2 3 4
//
//        3%5 = 3
//        9%5 = 4
//        7%5 = 2
//        5%5 = 0
//        1%5 = 1



//
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.remove(1);
//        list.contains(1);
//        list.size();
//
////        FILO
//        Stack<Integer> st = new Stack<>();
//        st.push(1);
//        st.push(2);
//        st.pop();
//        st.peek();
//        st.isEmpty();
//        st.size();
//
////        FIFO
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(1);
//        q.offer(2);
//        q.offer(3);
//        q.poll();
//        q.size();
//        q.isEmpty();
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        System.out.println('a');
//        3 4
        StackuArray<Integer> intSt = new StackuArray<>();
        StackuArray<String> strSt = new StackuArray<>();

        intSt.push(4);
        intSt.push(3);
        intSt.push(2);
        intSt.push(1);

        strSt.push("Lavesh");
        strSt.push("Unmani");
        strSt.push("Dhannu");

        System.out.println(intSt);
        System.out.println(strSt);



    }
}
