package exercise6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This program demonstrate writing data as byte using FileOutputStream.
 * 
 * 
 * @author wafirdzihni
 *
 */
//test
public class rainfallInput {
	
	public static void main(String[] args) {

		//1. declaration of file name.
		String fileName = "rainfall_input.bin";
		
		//2. list the data in array
		 String[][] rainfallDatas = {
	                {"2421003", "Simpang Ampat", "Alor Gajah", "0", "0", "4", "1", "0", "6"},
	                {"2322006", "Melaka Pindah", "Alor Gajah", "0", "0", "0", "0", "0", "2"},
	                {"2225044", "Chohong", "Jasin", "6", "0", "0", "21", "0", "39"},
	                {"2125002", "Telok Rimba", "Jasin", "13", "0", "0", "1", "1", "69"},
	                {"2223023", "Sg. Duyong", "Melaka Tengah", "37", "0", "0", "3", "0", "43"},
	                {"2222006", "Cheng (Taman Merdeka)", "Melaka Tengah", "20", "0", "0", "3", "0", "42"}};
		

		try (
			
			//3. create an output stream between this program and the target file
			DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName))) {
			
			//4. insert the data into the file
			for (String[] rainfallData : rainfallDatas) {
				
				 String stationId = rainfallData[0];
	                String stationName = rainfallData[1];
	                String districtName = rainfallData[2];
	                String[] rainfalls = {rainfallData[3], rainfallData[4], rainfallData[5],rainfallData[6], rainfallData[7], rainfallData[8]};
				
	                output.writeUTF(stationId);
	                output.writeUTF(stationName);
	                output.writeUTF(districtName);
			
			
			// Writing rainfall readings
	            for (String rainfall : rainfalls) {
	            	output.writeInt(Integer.parseInt(rainfall));
	            }
			}
				
			//5. Clear the stream
			output.flush();
			
			//6. close the stream
			output.close();
			
			// indicate end of the program - if success
			System.out.println("Rainfall data has been written to the file: " + fileName);

		} catch (IOException e) {
			
			// if there an error, it will display this message
			System.out.println("An error occurred while writing the rainfall data to the file: " + e.getMessage());
		}

	}
}
