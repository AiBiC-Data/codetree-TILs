import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int captain = Integer.parseInt(st.nextToken());
		int teamone = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			int res = arr[i] - captain;
			if (res <= 0) {
				ans++;
				continue;
			}
			ans++;
			if(res / teamone ==0) {
				ans ++;
				continue;
			}
			ans += (res / teamone == 0 ? res / teamone : res / teamone + 1);

		}
		sb.append(ans);
		System.out.println(sb.toString());
	}
}