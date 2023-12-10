import java.io.*;
import java.util.*;

public class Main {

	static String A, B;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine();
		B = br.readLine();
		int ans = 0;
		if (A.charAt(0) == '0') {
			A = "1" + A.substring(1, A.length());
			ans = Integer.parseInt(A, 2);
		} else if (B.charAt(0) == '0') {
			String tmp1 = "1" + B.substring(1, B.length());
			int comp1 = Integer.parseInt(tmp1, 3);
			tmp1 = Integer.toString(comp1, 2);
			if (tmp1.length() == B.length()) {
				int cnt = 0;
				for (int i = 0, leng = tmp1.length(); i < leng; i++) {
					if (tmp1.charAt(i) != B.charAt(i))
						cnt++;
					if (cnt == 2) {
						B = "2" + B.substring(1, B.length());
						ans = Integer.parseInt(B, 3);
						break;
					}
				}
				if (cnt == 1)
					ans = comp1;
			} else {
				B = "2" + B.substring(1, B.length());
				ans = Integer.parseInt(B, 3);
			}
		} else {
			HashMap<Integer, Integer> hmap = new HashMap<>();
			int two = Integer.parseInt(A, 2);
			for (int i = 0, leng = A.length(), idx = A.length()-1; i < leng; i++, idx--) {
				if (A.charAt(idx) == '0') {
					hmap.put((int) (two + Math.pow(2, i)), 1);
				}else {
					hmap.put((int) (two - Math.pow(2, i)), 1);
				}
			}
			int three = Integer.parseInt(B, 3);
			int tmp=0;
			for (int i = 0, leng = B.length(), idx = B.length()-1; i < leng; i++, idx--) {
				if (B.charAt(idx) == '0') {
					tmp=(int) (three + Math.pow(3, i));
					if(hmap.containsKey(tmp)) {
						ans = tmp;
						break;
					}
					tmp=(int) (three + 2* Math.pow(3, i));
					if(hmap.containsKey(tmp)) {
						ans = tmp;
						break;
					}
				}else if(B.charAt(idx) == '1'){
					tmp=(int) (three - Math.pow(3, i));
					if(hmap.containsKey(tmp)) {
						ans = tmp;
						break;
					}
					tmp=(int) (three + Math.pow(3, i));
					if(hmap.containsKey(tmp)) {
						ans = tmp;
						break;
					}
				}else {
					tmp=(int) (three - Math.pow(3, i));
					if(hmap.containsKey(tmp)) {
						ans = tmp;
						break;
					}
					tmp=(int) (three - 2*Math.pow(3, i));
					if(hmap.containsKey(tmp)) {
						ans = tmp;
						break;
					}
				}
			}
		}

		sb.append(ans);
		System.out.println(sb.toString());
	}

}