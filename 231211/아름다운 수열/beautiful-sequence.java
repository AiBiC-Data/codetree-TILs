import java.io.*;
import java.util.*;

public class Main {
	static int N,M, ans, res[];
	static ArrayList<Integer> alist = new ArrayList<>();
	static HashMap<String, Integer> hmap;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		int minA=100;
		int maxA =1;
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(br.readLine().trim());
			minA = Math.min(minA, a[i]);
			maxA = Math.max(maxA, a[i]);
		}
		
		M = Integer.parseInt(br.readLine());
		int[] b = new int[M];
		for (int i = 0; i < M; i++) {
			b[i] = Integer.parseInt(br.readLine().trim());
		}
		
		// M이 더 클 경우 예외 처리
		if(N<M) {
			sb.append(0);
			System.exit(0);
		}
		// 조회 시간 줄이이 위해 HashMap사용 & a의 원소들을 String 값으로 넣기
		hmap = new HashMap<>();
		for (int i = 0; i <= N-M; i++) {
			String tmp="";
			for (int j = 0; j < M; j++) {
				tmp+=a[i+j];
			}
			hmap.put(tmp, i);
		}
		
		// 빼기
		boolean flag = true;
		int cnt=0;
//		while(flag) {
//			int[] tmpB = new int[M];
//			for (int i = 0; i < M; i++) {
//				tmpB[i] = b[i]-cnt;
//				if(tmpB[i]==minA) flag=false;
//			}
//			cnt++;
//			comb(tmpB, 0, 0, new int[M]);
//		}
		
		// 더하기
		flag = true;
		cnt=1;
		while(flag) {
			int[] tmpB = new int[M];
			for (int i = 0; i < M; i++) {
				tmpB[i] = b[i]+cnt;
				if(tmpB[i]==maxA) flag=false;
			}
			cnt++;
			res =new int[M];
			perm(tmpB, 0, 0);
		}
		sb.append(ans+"\n");
		alist.sort((o1,o2)->{return o1-o2;});
		for (int i = 0; i < ans; i++) {
			sb.append(alist.get(i)+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void perm(int[] p, int dep, int flag) {
		if(dep==M) {
			String str = "";
			for (int i = 0; i < M; i++) {
				str+=res[i];
			}
			if(hmap.containsKey(str)) {
				ans ++;
				alist.add(hmap.get(str)+1);
			}
			return;
		}
		
		for (int i = 0; i < M; i++) {
			if((flag&1<<i)!=0) continue;
			res[dep] = p[i];
			perm(p, dep+1, flag|1<<i);
		}
	}
}