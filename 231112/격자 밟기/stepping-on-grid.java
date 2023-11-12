import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int K, cnt, ans, map[][];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		if (K % 2 == 1)
			sb.append(0);
		else {
			ans =0;
			cnt = (25 - K) / 2 + 1;
			map[0][0] = 1;
			dfs(0, 0, 1);
			sb.append(ans);
		}
		System.out.println(sb.toString());

	}

	private static void dfs(int x, int y, int dep) {
		if (dep == cnt) {
			dfs2(x,y,1);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx > 4 || ny > 4 || map[nx][ny] == 1 || (nx==4 && ny==4)) 
				continue;
			map[nx][ny] = 1;
			dfs(nx, ny, dep + 1);
			map[nx][ny] = 0;
		}
	}

	private static void dfs2(int x, int y, int dep) {
		if(dep==cnt) {
			if(x==4 && y==4)
				ans++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx > 4 || ny > 4 || map[nx][ny] == 1) 
				continue;
			map[nx][ny] = 1;
			dfs2(nx, ny, dep + 1);
			map[nx][ny] = 0;
		}
	}

}