import java.util.*;

import java.util.PriorityQueue;

public class scheduleCourseIII {
    static class Info implements Comparable<Info>{
        int days;
        int lastday;
        Info(int d,int ld){
            this.days=d;
            this.lastday=ld;
        }
        @Override
        public int compareTo(Info f){
            if(this.lastday!=f.lastday){
                return this.lastday-f.lastday;
            }
            return this.days-f.days;
        }

    }
    public static int scheduleCourse(int[][] courses) {
        PriorityQueue<Info> q=new PriorityQueue();
        for(int i=0;i<courses.length;i++){
            q.add(new Info(courses[i][0],courses[i][1]));
        }
        int temp=0;
        int ans = 0;
        int finalans=0;
        while(!q.isEmpty()){
            Info curr=q.remove();
            temp+=curr.days;
            if(temp<=curr.lastday){
                ans++;
            }
            else{
                temp=curr.days;
                if( temp<=curr.lastday){
                    ans=1;
                }
                else{
                    ans=0;
                }
            }
            finalans=Math.max(finalans,ans);
        }
        return finalans;
    }
    public static void main(String[] args) {
        int[][] courses= { { 7, 16} , {2 , 3}, {3 , 12},{3 ,14},{10,19},{10,16},{6,8},{6,11},{3,13},{6,16}}; //{{5,5},{4,6},{2,6}}; //{{100,200},{200,1300},{1000,1250},{2000,3000}};
        System.out.println(scheduleCourse(courses));
        
    }
    
}
