import java.util.ArrayList;

import java.util.HashMap;

class distributeCookie {
    public static int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int sum = 0;
        HashMap<Integer, Integer> rest = new HashMap();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            sum += cookies[i];
        }
        int per = sum / k;
        while (k > 1) {
            int perChiled=per;
            for (int i = 0; i < n; i++) {
                if (cookies[i] <= perChiled && !rest.containsKey(i)) {
                    perChiled -= cookies[i];
                    rest.put(i, cookies[i]);
                }
            }
            k--;
            temp.add(per-perChiled);
        }
        int maxCandy=Integer.MIN_VALUE;
        int a=0;
        for(int i = 0; i < temp.size(); i++) {
            maxCandy=(maxCandy<temp.get(i))?temp.get(i):maxCandy;
        }
        for(int i = 0; i < n; i++) {
            if(!rest.containsKey(i)){
                a+=cookies[i];
            }
        }
        return Math.max(maxCandy,a);
    }

    public static void main(String[] args) {
        int[] cookies = { 8,15,10,20,8 };
        System.out.println(distributeCookies(cookies, 2));
    }
}