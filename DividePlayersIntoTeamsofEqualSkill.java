import java.util.Arrays;
public class DividePlayersIntoTeamsofEqualSkill {
    public static long dividePlayers(int[] skill) {
        int i=0;
        int j=skill.length;
        Arrays.sort(skill);
        int prevSum=-1;
        int res=0;
        while (i<j) {
            if(prevSum!=-1 && skill[i]+skill[j]!=prevSum){
                return -1;
            }
            prevSum=skill[i]+skill[j];
            res+=skill[i]*skill[j];
            i++;
            j--;
        }
        return res;
    }public static void main(String args[]){
        System.out.println(dividePlayers(new int[]{}));
    }
}