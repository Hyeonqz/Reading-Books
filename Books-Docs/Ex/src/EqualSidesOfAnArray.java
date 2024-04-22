import java.util.Arrays;

public class EqualSidesOfAnArray {
	public static int findEvenIndex (int[] arr) {

		int[] leftSums = new int[arr.length];
		int[] rightSums = new int[arr.length];
		
		// { 1 2 3 (4) 3 2 1 

		// 왼쪽 부분합 구하기
		leftSums[0] = arr[0]; // 1
		for (int i = 1; i < arr.length ; i++) {
			leftSums[i] = leftSums[i-1] + arr[i];
		}

		// [0] = 1
		// [1] = 1 + 2 = 3
		// [2] = 3 + 3 = 6
		// [3] = 6 + 4 = 10
		// [4] = 10 + 3 = 13
		// [5] = 10 + 2 = 15
		// [6] = 15 + 1 = 16

		// 오른쪽 부분합 구하기
		rightSums[arr.length-1] = arr[arr.length-1]; // 1
		for (int i = arr.length-2; i >=0 ; i--) {
			rightSums[i] = rightSums[i+1] + arr[i];
		}
		// [6] = 1
		// [5] = 1+2 = 3
		// [4] = 3 + 3 = 6
		// [3] = 6 + 4 = 10
		// [2] = 10 + 3 = 13
		// [1] = 13 + 2 = 15
		// [0] = 15 + 1 = 16

		// 왼쪽, 오른쪽 비교
		for (int i = 0; i < arr.length; i++) {
			if(leftSums[i] == rightSums[i]) {
				return i;
			}
		}

		return -1;
	}

}

// 배열에서 왼쪽 부분의 합과 오른쪽 부분의 합이 동일한 지점의 인덱스를 찾는다.
// 123(6) 4 321(6)