package Asik3;

public class MyHashTable<K,V> {
    public class HashNode<K,V> {
        private K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public HashNode<K, V> getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "{"+key+" "+value+"}";
        }
    }

    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M) {
        this.M=M;
        chainArray = new HashNode[M];
        size = 0;
    }
    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        String keyStr = key.toString();
        int hash = 0;
        for (int i = 0; i < keyStr.length(); i++) {
            hash+= (int)keyStr.charAt(i);
        }
        return hash % M;
    }

    public HashNode<K,V>[] getChainArray() {
        return chainArray;
    }
    public void put(K key, V value) {
        int idx = hash(key);
        HashNode<K,V> node = chainArray[idx];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode<K,V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[idx];
        chainArray[idx] = newNode;
        size++;
    }
    public V get(K key) {
        int idx = hash(key);
        HashNode<K,V> node = chainArray[idx];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public V remove(K key) {
        int idx = hash(key);
        HashNode<K,V> node = chainArray[idx];
        if(node==null){
            return null;
        }
        if(node.key.equals(key)){
            V res = node.value;
            chainArray[idx] = node.next;
            size--;
            return res;
        }
        while(node!=null && node.next!=null){
            if(node.next.key.equals(key)){
                V res = node.next.value;
                node.next = node.next.next;
                size--;
                return res;
            }
            node = node.next;
        }
        return null;
    }

    public boolean contains(V value){
        for(int i=0;i< chainArray.length;i++){
            HashNode<K,V> head = chainArray[i];
            while(head!=null){
                if(head.value.equals(value)){
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        for(int i=0;i< chainArray.length;i++){
            HashNode<K,V> node = chainArray[i];
            while(node!=null){
                if(node.value.equals(value)){
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    public void PrintTable(){
        for(int i = 0;i< chainArray.length;i++){
            System.out.print("["+i+"] ");
            HashNode<K,V> head = chainArray[i];
            while(head!=null){
                System.out.print("{"+head.key+" : "+head.value+"} -->");
                head = head.next;
            }
            System.out.println();
        }


    }
}
