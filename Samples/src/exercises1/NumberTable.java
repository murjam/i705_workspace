package exercises1;

public class NumberTable {

	public static void main(String[] args) {
		
		int size = 15;
		int base = 10;
		
		for (int i = 0; i < size ; i++) {
			for (int j = 0; j < size; j++) {
				int value = Math.min(size - i - 1, size - j - 1);
				System.out.format("%2d", value % base);
			}
			System.out.println();
		}
		
	}
	
}
