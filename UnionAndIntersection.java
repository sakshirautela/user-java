import java.util.HashSet;
public class UnionAndIntersection {
    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};
        HashSet<Integer> nhs=new HashSet();
        for(int i=0;i<arr1.length ;i++){
            nhs.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            nhs.add(arr2[i]);
        }
        System.out.println(nhs.size());
        HashSet<Integer> hs=new HashSet();
        for(int i=0;i<arr2.length;i++){
            hs.add(arr2[i]);
        }
        int count=0;
        for (int i = 0; i < arr1.length; i++) {
            if(hs.contains(arr1[i])){
                count++;
                hs.remove(arr1[i]);
            }
        }
        System.out.println(count);

    }
}
