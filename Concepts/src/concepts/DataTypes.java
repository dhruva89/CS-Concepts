package concepts;

public class DataTypes {
	public static void main(String args[]) {
		byte testByte1 = (byte) 0b10101010;
		System.out.println(testByte1);
		
		Integer testInt = -2;
		System.out.println(Integer.toBinaryString(testInt));
		System.out.println(testInt << 1);
		System.out.println((-2 << 1) >>> 1);
	}
}
