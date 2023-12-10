import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine();
		String tmp = t + "0000";
		int upper = 0;
		for (int tl = t.length() - 1, tml = tmp.length()-1; tl >= 0; tl--,tml--) {
			int c = (int) (t.charAt(tl) - '0') + (int) (tmp.charAt(tml) - '0') + upper;
			if (c == 1) {
				tmp = tmp.substring(0, tml) + "1" + tmp.substring(tml + 1);
				upper = 0;
			} else if (c == 2) {
				tmp = tmp.substring(0, tml) + "0" + tmp.substring(tml + 1);
				upper = 1;
			} else if(c==3){
				tmp = tmp.substring(0, tml) + "1" + tmp.substring(tml + 1);
				upper = 1;
			}else {
				upper=0;
			}
		}
		if (upper == 1) {
			for (int i = 0, le = tmp.length() - t.length() - 1; le >= 0; i++, le--) {
				int c = (int) (tmp.charAt(le) - '0') + upper;
				if (c == 2) {
					tmp = tmp.substring(0, le) + "0" + tmp.substring(le + 1);
				} else if(c==1) {
					tmp = tmp.substring(0, le) + "1" + tmp.substring(le + 1);
					break;
				}else {
					break;
				}

			}
		}
		if(tmp.charAt(0)=='0') tmp = "1"+tmp;
		sb.append(tmp);
		System.out.println(sb.toString());
	}
}