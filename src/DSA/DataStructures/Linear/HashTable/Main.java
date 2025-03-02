package DSA.DataStructures.Linear.HashTable;


import javax.sound.midi.SysexMessage;

public class Main {
    public static void main(String [] args){
HashTable table;
        table = new HashTable();
//table.put(1,"Lavesh");
        table.put(1,"Lavesh");
        table.put(2,"Gaurav");
        table.put(3,"Lavesh");
        table.put(11, "Amoli");
//        table.put(2,"Gaurav");
//        table.put(3,"Arya");
//        table.put(3,"Amoli");
//        System.out.println(CharFinder.findFirstNonRepeatingChar("lavesh chutiya ahe"));
//
//        System.out.println(CharFinder.findFirstRepeatingChar("lavesh chuitya ahe"));
        System.out.println(table.get(11));
        System.out.println("Laesh");
    }
}
