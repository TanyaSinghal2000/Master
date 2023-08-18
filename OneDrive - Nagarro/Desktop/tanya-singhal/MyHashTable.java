public class MyHashTable<K, V> {

    private Entry<K,V>[] table;
    private int capacity= 1000000;
    private int size = 0;

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashTable(){
        table = new Entry[capacity];
    }

    public void insert(K newKey, V data){
        if(newKey==null)
            return;

        int hash=hash(newKey);
        Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);
        size++;
        if(table[hash] == null){
            table[hash] = newEntry;
        }else{
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];

            while(current != null){
                if(current.key.equals(newKey)){
                    if(previous==null){
                        newEntry.next=current.next;
                        table[hash]=newEntry;
                        return;
                    }
                    else{
                        newEntry.next=current.next;
                        previous.next=newEntry;
                        return;
                    }
                }
                previous=current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    public V get(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return null;
        }else{
            Entry<K,V> temp = table[hash];
            while(temp!= null){
                if(temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }

    public boolean contains(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return false;
        }else{
            Entry<K,V> temp = table[hash];
            while(temp!= null){
                if(temp.key.equals(key))
                    return true;
                temp = temp.next;
            }
            return false;
        }
    }

    public boolean delete(K deleteKey){

        int hash=hash(deleteKey);

        if(table[hash] == null){
            return false;
        }else{
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];
            size--;
            while(current != null){
                if(current.key.equals(deleteKey)){
                    if(previous==null){
                        table[hash]=table[hash].next;
                        return true;
                    }
                    else{
                        previous.next=current.next;
                        return true;
                    }
                }
                previous=current;
                current = current.next;
            }
            return false;
        }

    }

    public void display(){

        for(int i=0;i<capacity;i++){
            if(table[i]!=null){
                Entry<K, V> entry=table[i];
                while(entry!=null){
                    System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
                    entry=entry.next;
                }
            }
        }

    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        MyHashTable<Integer, Integer> hashMapCustom = new MyHashTable<>();
        hashMapCustom.insert(21, 12);
        hashMapCustom.insert(25, 121);
        hashMapCustom.insert(30, 151);
        hashMapCustom.insert(33, 15);
        hashMapCustom.insert(35, 89);

        System.out.println("value corresponding to key 21="
                + hashMapCustom.get(21));
        System.out.println("value corresponding to key 51="
                + hashMapCustom.get(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();

        System.out.println("\n\nvalue corresponding to key 21 deleted: "
                + hashMapCustom.delete(21));
        System.out.println("value corresponding to key 51 deleted: "
                + hashMapCustom.delete(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();
        System.out.println();
        System.out.println(hashMapCustom.size());

    }

}


