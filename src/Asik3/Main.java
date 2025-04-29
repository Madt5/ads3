package Asik3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass,Integer> table = new MyHashTable<>(100);
        Random rn = new Random();

        for(int i=0;i<10000;i++){
            int id = rn.nextInt(10000);
            table.put(new MyTestingClass(id),i);
        }

        int[] arr = new int[100];
        for(int i = 0;i<100;i++){
            int count = 0;
            MyHashTable<MyTestingClass,Integer>.HashNode<MyTestingClass,Integer> head = table.getChainArray()[i];
            while(head!=null){
                head = head.getNext();
                count++;
            }
            arr[i] = count;
        }

        for(int i = 0;i<100;i++){
            /*System.out.printf("arr[%d] = %d elements",i,arr[i]);
            System.out.println();*/
        }

        BST<Integer,String> BinaryTree = new BST<>();
        BinaryTree.put(5, "ads");
        BinaryTree.put(3, "123");
        BinaryTree.put(7, "$3n");
        BinaryTree.put(2, "70f");
        BinaryTree.put(4, "poe");
        BinaryTree.put(6, "67k");
        BinaryTree.put(8, "even");
        BinaryTree.put(9,"44&");
        BinaryTree.put(1,"34F");

        BinaryTree.delete(7);
        BinaryTree.delete(9);

        System.out.println("Sorted Keys (in-order!)");
        for (var elem : BinaryTree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}
