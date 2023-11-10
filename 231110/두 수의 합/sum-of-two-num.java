// n개의 정수가 입력으로 주어지고, 이 중 서로 다른 위치에 있는 두 개의 수를 뽑아 더했을 때 k가 되는 가짓수를 구하는 프로그램을 작성해보세요.

// 입력 형식
// 첫 번째 줄에는 원소의 개수 n과 두 수의 합이 될 k가 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 n개의 정수가 공백을 사이에 두고 주어집니다. 수가 중복되어 주어질 수 있습니다.

// −10^9≤ 정수 ≤ 10^9
// 1 ≤ n ≤ 100,000

// −2^31≤ k ≤ 2^31−1

// 출력 형식
// 입력으로 주어진 수들 중 서로 다른 위치에 있는 두 개의 수를 골랐을 때 두 수의 합이 k가 되는 가짓수를 출력합니다.

// 입출력 예제
// 예제1
// 입력:
// 5 9
// 4 6 5 3 7
// 출력:
// 2

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
