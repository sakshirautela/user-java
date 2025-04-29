
public class AlternatingGroupsI {
    public static int numberOfAlternatingGroups(int[] colors) {
        int n=colors.length;
        int res=(colors[n-1]==colors[1] && colors[1]!=colors[0])?1:0;
        int i=0;
        while(i+2<n){
            if(colors[i]==colors[i+2] && colors[i]!=colors[i+1]){
                res++;
            }
            i++;
        }
        res+=(colors[n-2]==colors[0] && colors[n-1]!=colors[0])?1:0;

        return res;
    }
    public static void main(String[] args){
        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,0,1}));
    }
}
