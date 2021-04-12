package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>();

        long time = System.nanoTime();
        fillStep(tree);
        System.out.println("Час заповннення послідовними - " + (System.nanoTime() - time));

        BTree<Integer> tree1 = new BTree<>();
        time = System.nanoTime();
        fillRandom(tree1);
        System.out.println("Час заповнення випадковими - " + (System.nanoTime() - time));

        time = System.nanoTime();
        tree.contains(9293);
        System.out.println("Час пошуку елемента - " + (System.nanoTime() - time));

        time = System.nanoTime();
        tree.remove(9293);
        System.out.println("Час видалення елемента - " + (System.nanoTime() - time));

        System.out.println("Час балансування послідовних - " + tree.getTime());


        tree1.remove(9293);
        System.out.println("Час балансування випадкових - " + tree1.getTime());

    }

    public static void fillStep(BTree<Integer> tree){
        for(int i = 0; i < 1000; i++){
            tree.add(i);
        }
    }

    public static void fillRandom(BTree<Integer> tree){
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            tree.add(rand.nextInt(100000));
        }
    }
}
