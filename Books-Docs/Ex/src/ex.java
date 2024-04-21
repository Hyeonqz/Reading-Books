public class ex {

	static int add (int a, int b) {
		return a + b;
	}

	static double add (double a, double b) {
		return a+b;
	}

	public static void main (String[] args) {
		int sum=0;
		double j = 1.0;

		for (int i = 0; i < 5; i++) {
			sum += add(i, i+1);
			j++;
		}
		System.out.println(sum+add(j,j+1));
	}

}
