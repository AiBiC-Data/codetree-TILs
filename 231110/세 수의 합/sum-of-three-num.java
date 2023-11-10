// n개의 정수가 입력으로 주어지고, 이 중 서로 다른 세 개의 위치를 골라 각 위치에 있는 세 수를 더했을 때 k가 되는 서로 다른 조합의 개수를 출력하는 코드를 작성해보세요.

// 입력 형식
// 첫 번째 줄에는 원소의 개수 n과 세 수의 합이 될 k가 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 n개의 정수가 공백을 사이에 두고 주어집니다. 숫자가 중복되어 주어질 수 있습니다.

// −5×10^8≤ 원소 값, k ≤ 5×10^8
// 1 ≤ n ≤ 1,000

// 출력 형식
// 서로 다른 세 개의 위치를 골라 해당 위치에 있는 세 수를 더했을 때 k가 되는 조합의 개수를 출력합니다.
// 입출력 예제
// 예제1
// 입력:
// 5 4
// 1 2 1 4 -1
// 출력:
// 3

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static HashMap<Long, Integer> hmap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static final int Max_N = 1000;
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
        for (int i = 0; i < N-1; i++) {
        	for (int j = i+1; j < N; j++) {
				
			long diff = K-nums[i]-nums[j];
			if(hmap.containsKey(diff)) ans +=hmap.get(diff);
			if(!hmap.containsKey(nums[i]+nums[j])) hmap.put(nums[i]+nums[j], 1);
			else hmap.put(nums[i]+nums[j], hmap.get(nums[i]+nums[j])+1);
        	}
		}
        System.out.println(ans);
    }
}