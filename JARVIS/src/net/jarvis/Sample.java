package net.jarvis;


public class Sample {
	
	public static int getSample(byte[] arr){ // Should add more support for 32 and 64 bit 
		
		if(arr.length == 2){
			return Combine16Bit(arr);
		}else{
			return -1;
		}
		
	}
	private static int Combine16Bit(byte[] arr){
		int combine = 0;
		 combine |= arr[0] & 0xFF;
         combine |= arr[1] << 8;
//		System.out.println(Integer.toBinaryString(combine));
		return combine;
	}
	private static int Combine32Bit(byte[] arr){
		return -1;
	}
	
	

}
