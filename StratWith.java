public class StratWith {
    static class Node{
        Node child[]=new Node[26];
        boolean eow=false;
        Node(){
            for(int i=0;i<26;i++){
                child[i]=null;
            }
        }
    }
    public static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx] =new Node();
            }
            else{
                curr=curr.child[idx];
            }
        }
        curr.eow=true;
    }
    public static boolean search(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
        }
        // if(curr.eow!=true){
        //     return false;
        // }
        // return true;
        return true;
    }
    public static void main(String[] args) {
        String[] word={"the","there","their","a","any","thee"};
        for(int i=0;i<word.length;i++){
            insert(word[i]);
        }
        System.out.println(search("the"));
        System.out.println(search("hy"));
    }
}
