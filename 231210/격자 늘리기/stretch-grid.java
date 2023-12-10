import java.io.*;
import java.util.*;

public class Main {

	static int N,M,K;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String temp="";
			for (int j = 0; j < M; j++) {
				char tmp = str.charAt(j);
				for (int k = 0; k < K; k++) {
					temp += tmp;
				}
			}
			for (int k = 0; k < K; k++) {
				sb.append(temp+"\n");
			}
		}
		System.out.println(sb.toString());
	}

}