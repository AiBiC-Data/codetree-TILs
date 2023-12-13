import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int N, R, ans = Integer.MAX_VALUE;
	static int[] data, nums;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		R = N / 2;
		nums = new int[R];
		data = new int[N];
		for (int i = 1; i < N + 1; i++) {
			data[i - 1] = i;
		}
		comb(0, 0);
		sb.append(ans);
		System.out.println(sb.toString());
	}

	private static void comb(int dep, int flag) {
		if (dep == R) {
			ans = Math.min(ans, compare());
			return;
		}
		for (int i = flag; i < N; i++) {
			nums[dep] = data[i];
			comb(dep + 1, i + 1);
		}
	}

	private static int compare() {
		int sum = 0;
		HashSet<Integer> hset = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			hset.add(i);
		}
		for (int i = 0; i < R - 1; i++) {
			int a = nums[i] - 1;
			if (hset.contains(a+1))
				hset.remove(a+1);
			
			for (int j = i+1; j < R; j++) {
				int b = nums[j] - 1;
				if (hset.contains(b+1))
					hset.remove(b+1);
				sum += map[a][b] + map[b][a];
			}
		}
		int[] tmp = new int[R];
		int cnt=0;
		for (int i = 1; i <= N; i++) {
			if (hset.contains(i)) {
				tmp[cnt++] = i-1;
			}
		}
		for (int i = 0; i < R - 1; i++) {
			int a = tmp[i];
			for (int j = i+1; j < R; j++) {
				int b = tmp[j];
				sum -= (map[a][b] + map[b][a]);
			}
		}
		return Math.abs(sum);
	}
}