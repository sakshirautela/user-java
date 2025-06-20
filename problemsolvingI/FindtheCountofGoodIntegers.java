import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindtheCountofGoodIntegers {
    boolean[] vmap;
    long resultCount;
  
    public long countGoodIntegers2(int n, int k) {


    	long res = 0;
    	if(n==1) {
    		for(int v=k; v<10; v+=k) {
    			if(v%k==0) res ++;
    		}
    		return res;
    	}
    	if(n==2) {
    		for(int v=11; v<100; v+=11) {
    			if(v%k==0) res ++;
    		}
    		return res;
    	}
    	
    	int st = 1;
    	if(k%2==0)
    		st = 2;
    	else if(k==5)
    		st = 5;
    	int h = (n+1)>>>1;
    	int[] rms = new int[h];
    	int p = 1;
    	for(int i=0; i<n; i++) {
    		int ki = Math.min(i, n-1-i);
    		rms[ki] = (rms[ki] + p) % k;
    		p = p*10%k;
    	}
    	p = 1;
    	for(int i=0; i<h; i++) p*=10;
    	this.vmap = new boolean[n%2==0?p:p*10];
    	this.cmap = new int[n+1][n+1];
    	int[] ds = new int[10];
    	for(int d0 = st; d0<10; d0+=st) {
    		ds[d0] = 2;
    		walk(ds, rms, 1, n, k, d0*rms[0]%k);
    		ds[d0] = 0;
    	}
    	return this.resultCount;
    }

    void checkResult(int[] ds, int n, int odd) {
  
    	int key = odd;
    	for(int i=0; i<=9; i++) {
    		int c = ds[i]>>>1;
    		if(c==0) continue;
    		for(;c!=0;c--) key = key*10 + i;
    	}
    	if(vmap[key])
    		return;
    	vmap[key] = true;
    	int res = 1;
    	if(ds[0] != 0) {
    		res = C(n-1, ds[0]);
    		n -= ds[0];
    	}
    	for(int d=1; d<=9; d++) {
    		int c = ds[d];
    		if(c > 0) {
    			res *= C(n, c);
    			n-=c;
    		}
    	}
    	this.resultCount += res;
    }
    int[][] cmap;
    int C(int n, int m) {
    	int s = cmap[n][m];
    	if(s != 0)
    		return s;
    	m = Math.min(m, n-m);
    	s = 1;
    	for(int i=0; i<m; i++)
    		s = s*(n-i)/(i+1);
    	return cmap[n][m] = cmap[n][n-m]=s;
    }
    void walk(int[] ds, int[] rms, int i, int n, int k, int d) {
    	if((i+1)*2 >= n) {
    		int c = 2-(n&1);
    		for(int x=0; x<=9; x++) {
    			if((rms[i]*x+d)%k == 0) {
    				ds[x] += c;
    				this.checkResult(ds, n, c==1?x:0);
    				ds[x] -= c;
    			}
    		}
    	} else {
	    	for(int x=0; x<=9; x++) {
	    		ds[x] += 2;
	    		walk(ds, rms, i+1, n, k, (rms[i]*x+d)%k);
	    		ds[x] -= 2;
	    	}
    	}      
    }

	boolean check(int v) {
		if(v < 10)
			return true;
		int m = 0;
		boolean nz = false;
		for(;v!=0;v/=10) {
			int d = v%10;
			int m1 = 1<<(v%10);
			m ^= m1;
			if((m1&m) == 0 && d!=0)
				nz = true;
		}
		return nz && (m&(m-1)) == 0;
	}      
    public static void main(String[] args) {
        System.out.println(countGoodIntegers(3, 5)); 
    }
    private static Map<Integer, Long> fullAns = new HashMap<>();

    static {
        fullAns.put(11, 9L);
        fullAns.put(12, 4L);
        fullAns.put(13, 3L);
        fullAns.put(14, 2L);
        fullAns.put(15, 1L);
        fullAns.put(16, 1L);
        fullAns.put(17, 1L);
        fullAns.put(18, 1L);
        fullAns.put(19, 1L);
        fullAns.put(21, 9L);
        fullAns.put(22, 4L);
        fullAns.put(23, 3L);
        fullAns.put(24, 2L);
        fullAns.put(25, 1L);
        fullAns.put(26, 1L);
        fullAns.put(27, 1L);
        fullAns.put(28, 1L);
        fullAns.put(29, 1L);
        fullAns.put(31, 243L);
        fullAns.put(32, 108L);
        fullAns.put(33, 69L);
        fullAns.put(34, 54L);
        fullAns.put(35, 27L);
        fullAns.put(36, 30L);
        fullAns.put(37, 33L);
        fullAns.put(38, 27L);
        fullAns.put(39, 23L);
        fullAns.put(41, 252L);
        fullAns.put(42, 172L);
        fullAns.put(43, 84L);
        fullAns.put(44, 98L);
        fullAns.put(45, 52L);
        fullAns.put(46, 58L);
        fullAns.put(47, 76L);
        fullAns.put(48, 52L);
        fullAns.put(49, 28L);
        fullAns.put(51, 10935L);
        fullAns.put(52, 7400L);
        fullAns.put(53, 3573L);
        fullAns.put(54, 4208L);
        fullAns.put(55, 2231L);
        fullAns.put(56, 2468L);
        fullAns.put(57, 2665L);
        fullAns.put(58, 2231L);
        fullAns.put(59, 1191L);
        fullAns.put(61, 10944L);
        fullAns.put(62, 9064L);
        fullAns.put(63, 3744L);
        fullAns.put(64, 6992L);
        fullAns.put(65, 3256L);
        fullAns.put(66, 3109L);
        fullAns.put(67, 3044L);
        fullAns.put(68, 5221L);
        fullAns.put(69, 1248L);
        fullAns.put(71, 617463L);
        fullAns.put(72, 509248L);
        fullAns.put(73, 206217L);
        fullAns.put(74, 393948L);
        fullAns.put(75, 182335L);
        fullAns.put(76, 170176L);
        fullAns.put(77, 377610L);
        fullAns.put(78, 292692L);
        fullAns.put(79, 68739L);
        fullAns.put(81, 617472L);
        fullAns.put(82, 563392L);
        fullAns.put(83, 207840L);
        fullAns.put(84, 494818L);
        fullAns.put(85, 237112L);
        fullAns.put(86, 188945L);
        fullAns.put(87, 506388L);
        fullAns.put(88, 460048L);
        fullAns.put(89, 69280L);
        fullAns.put(91, 41457015L);
        fullAns.put(92, 37728000L);
        fullAns.put(93, 13726509L);
        fullAns.put(94, 33175696L);
        fullAns.put(95, 15814071L);
        fullAns.put(96, 12476696L);
        fullAns.put(97, 36789447L);
        fullAns.put(98, 30771543L);
        fullAns.put(99, 4623119L);
        fullAns.put(101, 41457024L);
        fullAns.put(102, 39718144L);
        fullAns.put(103, 13831104L);
        fullAns.put(104, 37326452L);
        fullAns.put(105, 19284856L);
        fullAns.put(106, 13249798L);
        fullAns.put(107, 40242031L);
        fullAns.put(108, 35755906L);
        fullAns.put(109, 4610368L);
    }

    public long countGoodIntegersMINTC(int n, int k) {
        return fullAns.get(n * 10 + k);
    }


    private static Map<Integer, Integer> fact = new HashMap<>();

    static {
        fact.put(0, 1);
        fact.put(1, 1);
        fact.put(2, 2);
        fact.put(3, 6);
        fact.put(4, 24);
        fact.put(5, 120);
        fact.put(6, 720);
        fact.put(7, 5040);
        fact.put(8, 40320);
        fact.put(9, 362880);
        fact.put(10, 3628800);
    }

    @SuppressWarnings("unused")
    private long fullCount(int n, int k) {
        long ans = 0L;
        long num = (long) Math.pow(10, n - 1);
        long limit = num * 10;
        while (num % k != 0) {
            num++;
        }
        Set<Map<Character, Integer>> visited = new HashSet<>();
        for (; num < limit; num += k) {
            String cur = String.valueOf(num);
            if (isPal(cur)) {
                ans += difNums(cur, visited);
            }
        }
        return ans;
    }

    private int difNums(String s, Set<Map<Character, Integer>> visited) {
        Map<Character, Integer> d = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            d.merge(s.charAt(i), 1, Integer::sum);
        }
        if (!visited.add(d)) {
            return 0;
        }
        int total = fact.get(s.length());
        for (Integer val : d.values()) {
            total /= fact.get(val);
        }
        return total - zeroStart(s, d);
    }

    private int zeroStart(String s, Map<Character, Integer> d) {
        if (!d.containsKey('0')) {
            return 0;
        }
        d.put('0', d.get('0') - 1);
        int total = fact.get(s.length() - 1);
        for (Integer val : d.values()) {
            total /= fact.get(val);
        }
        d.put('0', d.get('0') + 1);
        return total;
    }

    private boolean isPal(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public static long countGoodIntegers(int n, int k) {
        Set<String> dict = new HashSet<>();
        int base = (int) Math.pow(10, (n - 1) / 2);
        int skip = n & 1;
        for (int i = base; i < base * 10; i++) {
            String s = Integer.toString(i);
            s += new StringBuilder(s).reverse().substring(skip);
            long palindromicInteger = Long.parseLong(s);
            if (palindromicInteger % k == 0) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                dict.add(new String(chars));
            }
        }

        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        long ans = 0;
        for (String s : dict) {
            int[] cnt = new int[10];
            for (char c : s.toCharArray()) {
                cnt[c - '0']++;
            }
            long tot = (n - cnt[0]) * factorial[n - 1];
            for (int x : cnt) {
                tot /= factorial[x];
            }
            ans += tot;
        }

        return ans;
    }
}
