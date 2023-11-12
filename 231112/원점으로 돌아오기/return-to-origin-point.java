import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, ans = 0;
	static int[][] nums;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N][2];
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = i;
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i][0] = Integer.parseInt(st.nextToken()) + 1000;
			nums[i][1] = Integer.parseInt(st.nextToken()) + 1000;
		}
        
		do {
			solve(data);
		} while (np(data));
		sb.append(ans);
		System.out.println(sb.toString());

	}

	private static void solve(int[] p) {
		int x = 1000;
		int y = 1000;
		for (int i = 0; i < N; i++) {
			int t = p[i];
			if ((nums[t][0] == x) || nums[t][1] == y) {
				x = nums[t][0];
				y = nums[t][1];
			} else {
				return;
			}
		}
		if((x==1000)||(y==1000))
			ans++;
		return;
	}

	private static boolean np(int[] p) {
		int i = N - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;
		if (i == 0)
			return false;
		int j = N - 1;
		while (p[i - 1] >= p[j])
			--j;
		swap(p, i - 1, j);
		int k = N - 1;
		while (i < k)
			swap(p, i++, k--);
		return true;
	}

	static void swap(int[] p, int i, int j) {
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}

}