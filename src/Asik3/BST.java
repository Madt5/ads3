package Asik3;

import java.util.Iterator;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST<K,V>.Node> {
    private Node root;
    private int size;
    public class Node{
        private K key;
        private V value;
        private Node left, right;
        private Node(K key,V val){
            this.key= key;
            this.value = val;
        }


        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    public BST(){
        size = 0;
    }
    public void put(K key, V val) {
        Node newNode = new Node(key, val);
        if(root==null) {
            root = newNode;
            size++;
            return;
        }
        Node current = root;
        while(true){
            int raz = key.compareTo(current.key);
            if(raz<0){
                if(current.left==null){
                    current.left = newNode;
                    size++;
                    return;
                }
                current = current.left;
            } else if (raz>0) {
                if(current.right==null){
                    current.right = newNode;
                    size++;
                    return;
                }
                current = current.right;
            }else{
                current.value = newNode.value;
                return;
            }
        }
    }
    public  V get(K key){
        Node current = root;
        while(current!=null){
            int raz = key.compareTo(current.key);
            if(raz<0){
                current= current.left;
            }else if(raz>0){
                current = current.right;
            } else{
                return current.value;
            }
        }
        return null;
    }
    public  void delete (K key){
        Node current = root;
        Node parent = null;
        while(current!=null){
            int raz = key.compareTo(current.key);
            if(raz<0){
                parent = current;
                current = current.left;
            }else if(raz>0){
                parent = current;
                current = current.right;
            }else{
                if(current.left==null && current.right==null){
                    if(current==root){
                        root=null;
                    }
                    else if(parent.left==current){
                        parent.left=null;
                    }else{
                        parent.right = null;
                    }
                    size--;
                    return;
                }
                else if(current.right==null){
                    if(current==root){
                        root = root.left;
                    }
                    else if(parent.left==current){
                        parent.left = current.left;
                    }else{
                        parent.right =current.left;
                    }
                    size--;
                    return;
                }
                else if(current.left==null){
                    if(current==root){
                        root = root.right;
                    }else if(parent.left==current){
                        parent.left = current.right;
                    }else{
                        parent.right = current.right;
                    }
                    size--;
                    return;
                }
                else{
                    Node successorParent = current;
                    Node successor = current.right;
                    while (successor.left != null){
                        successorParent = successor;
                        successor = successor.left;
                    }
                    if(successorParent!=current){
                        successorParent.left = successor.right;
                        successor.right = current.right;
                    }
                    successor.left = current.left;
                    if(current == root){
                        root = successor;
                    }else if(parent.left ==current){
                        parent.left = successor;
                    }else{
                        parent.right = successor;
                    }
                    size--;
                    return;
                }
            }
        }
    }
    @Override
    public Iterator<Node> iterator() {
        return new BSTIterator(root);
    }

    private class BSTIterator implements Iterator<Node> {
        private Stack<Node> stack = new Stack<>();
        public BSTIterator(Node root) {
            pushLeft(root);
        }
        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        @Override
        public Node next() {
            Node node = stack.pop();
            if (node.right != null) {
                pushLeft(node.right);
            }
            return node;
        }
    }

    public int size(){
        return size;
    }
}
