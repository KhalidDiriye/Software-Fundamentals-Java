import queuepackage.*;

public class Radix {
	public static void main(String[] args) {
		int[] array = {143,934,782,687,555,222,111,213,842,2000};
		printArray(array);
		System.out.println();
		radixSort(array,1000);
		printArray(array);
	}	
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i < array.length - 1) {
				System.out.print(array[i] + ",");
			} else {
				System.out.print(array[i]);
			}
		}
	}	
	
	public static void radixSort(int[] array, int maxPowerOf10) {
		Queue[] queueArray = new Queue[10];
		
		for (int queueNum = 0; queueNum < 10; queueNum++) {
			queueArray[queueNum] = new Queue();
		}

		for (int powerOf10 = 1; powerOf10 <= maxPowerOf10; powerOf10 = powerOf10 * 10) {
			for (int item = 0; item < array.length; item++) {
				int digit = getDigit(array[item], powerOf10);
				queueArray[digit].enqueue(new Integer(array[item]));
			}
			
			int item = 0;
			
			for (int queueNum = 0; queueNum < 10; queueNum++) {
				while(!queueArray[queueNum].isEmpty()) {
					array[item] = ((Integer) queueArray[queueNum].dequeue()).intValue();
					item++;
				}	
			}	
		}
	}	
	
	public static int getDigit(int number, int powerOf10) {
		return (number/powerOf10)%10;
	}	
}	