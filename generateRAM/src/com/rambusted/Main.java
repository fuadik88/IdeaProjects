package com.rambusted;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<Bulk> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Press ENTER to start");
        sc.nextLine();
        for(;;){
            generate(set);
        }

    }

    private static void generate(HashSet<Bulk> set){
        for(int i=0; i<11111; i++){
            Bulk b1 = new Bulk();
            SubBulk s1 = new SubBulk();
            set.add(b1);
            set.add(s1);
            System.out.println(set.size());
        }
    }
}

class Bulk{
    String shit="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ5479632108.!@%#$*^&)(+=-|?<>";
    String tit="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ5479632108.!@%#$*^&)(+=-|?<>";
    String pulpit="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ5479632108.!@%#$*^&)(+=-|?<>";
    public Bulk(){
        shit = shuffle(shit);
        tit = shuffle(tit);
        pulpit = shuffle(pulpit);
    }

    public String shuffle(String s){
        List<String> characters = Arrays.asList(s.split(""));
        Collections.shuffle(characters);
        String afterShuffle = "";
        for (String r : characters)
        {
            afterShuffle += r;
        }
        return afterShuffle;
    }

    @Override
    public String toString() {
        return shit + " | " + tit + " | " + pulpit;
    }
}

class SubBulk extends Bulk{
    String tick = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ5479632108.!@%#$*^&)(+=-|?<>";
    String peek = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ5479632108.!@%#$*^&)(+=-|?<>";
    String vick = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ5479632108.!@%#$*^&)(+=-|?<>";

    public SubBulk(){
        shit = shuffle(shit);
        tit = shuffle(shit);
        pulpit = shuffle(pulpit);
        tick = shuffle(tick);
        peek = shuffle(peek);
        vick = shuffle(vick);
    }

    @Override
    public String toString() {
        return shit + " | " + tit + " | " + pulpit + " | " + tick + " | " + peek + " | " + vick;
    }
}
