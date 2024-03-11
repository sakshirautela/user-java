import java.util.LinkedList;


public class HashMapImplement {
    static class HashMap<K,V>{
         class Node{
            public K idx;
            public V val;
            Node(K key,V val){
                this.idx=key;
                this.val=val;
            }
        }
        //@SuppressWarning("unchecked")
         LinkedList<Node> bucket[];
        int n;
        public HashMap(){
            this.n=0;
            this.bucket=new LinkedList[4];
            for(int i=0;i<n;i++){
                this.bucket[i]=new LinkedList();
            }
        }

        public int HashFunction(K key){
            int a=key.hashCode();
            return Math.abs(a)%bucket.length;
        }
        void put(K key,V value){
            int bi=HashFunction(key);//
            int di=searching(key,bi);//

            if(di!=-1){
                Node node =bucket[di].get(di);
                node.val=value;
            }
            else{
                bucket[di].add(new Node(key,value));
            }
        }

        private int searching(K key, int bi) {
            LinkedList<Node> ll=bucket[bi];
            int di=0;
            for(int i=0;i<ll.size();i++){
                Node node=bucket[i].get(di);
                if(node.val==key){
                    return di;
                }
                di++;
            }
            return -1;
        }
    }

    

    public static void main(String[] args) {
        
    }
}
