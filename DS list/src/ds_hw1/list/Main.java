package ds_hw1.list;

import java.time.*;

public class Main {
   public static void main(String[] args) {
        LinkedList<Integer> withFreelist = new LinkedList<>();
        LocalDateTime start1 = java.time.LocalDateTime.now();
        for(int i=0; i<1000000000; i++) withFreelist.append((i));
        LocalDateTime end1 = java.time.LocalDateTime.now();
        System.out.println(Duration.between(start1, end1).getNano());
   } 
}
