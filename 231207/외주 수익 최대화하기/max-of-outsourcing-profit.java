import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, max;
	static ArrayList<Work> times;
	static ArrayList<Integer> profits;
	static ArrayList<Integer> selectedJobs;
	static StringBuilder sb = new StringBuilder();
	
	static class Work{
		int start, end;
		
		public Work(int start,int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		times = new ArrayList<>();
		profits = new ArrayList<>();
		selectedJobs = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int profit = Integer.parseInt(st.nextToken());
			times.add(new Work(i, i+time-1));
			profits.add(profit);
		}
		
		find(0);
		sb.append(max);
		System.out.println(sb.toString());
	}

	private static void find(int idx) {
		if(idx==N) {
			if(isOk()) max=Math.max(max, getProfit());
			return;
		}
		find(idx+1);
		selectedJobs.add(idx);
		find(idx+1);
		selectedJobs.remove(selectedJobs.size()-1);
	}

	private static int getProfit() {
		int profit =0;
		for (int i = 0,size = selectedJobs.size(); i < size; i++) {
			profit +=profits.get(selectedJobs.get(i));
		}
		return profit;
	}

	private static boolean isOk() {
		for (int i = 0, size = selectedJobs.size(); i < size-1; i++) {
			if(times.get(selectedJobs.get(i)).end >=times.get(selectedJobs.get(i+1)).start) return false;
		}
		for (int i = 0, size = selectedJobs.size(); i < size; i++) {
			if(times.get(selectedJobs.get(i)).end >N) return false;
		}
		return true;
	}

	

}