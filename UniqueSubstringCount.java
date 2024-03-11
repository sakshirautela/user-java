public class UniqueSubstringCount {
    static class Node{
        Node[] children=new Node[26];
        boolean eow=false;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    static Node root =new Node();
    public static void insert(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if(curr.children[i]==null){
               curr.children[i]=new Node(); 
            }
            else{
                curr=curr.children[i];
            }
        }
        curr.eow=true;
    }
    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNode(root.children[i]);
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        String s="ababa";
        for(int i=0;i<s.length();i++){
            String sub=s.substring(i);
            insert(sub);
        }
        System.out.println(countNode(root));
    }
}
