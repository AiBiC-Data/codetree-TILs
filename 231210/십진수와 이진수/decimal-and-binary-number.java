import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine();
		N = 17 * Integer.parseInt(t, 2);
		sb.append(Integer.toString(N, 2));	
		
		
		System.out.println(sb.toString());
	}

}