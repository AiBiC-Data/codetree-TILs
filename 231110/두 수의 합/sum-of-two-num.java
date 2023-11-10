import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static HashMap<Long, Integer> hmap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static final int Max_N = 100000;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] nums = new long[Max_N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        long ans =0;
        for (int i = 0; i < N; i++) {
			long diff = K-nums[i];
			if(hmap.containsKey(diff)) ans +=hmap.get(diff);
			if(!hmap.containsKey(nums[i])) hmap.put(nums[i], 1);
			else hmap.put(nums[i], hmap.get(nums[i])+1);
		}
        System.out.println(ans);
    }
}