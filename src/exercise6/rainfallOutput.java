package exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class rainfallOutput {

	 public static void main(String[] args) {
		 
		 try {
			 
			 DataInputStream input = new DataInputStream(new FileInputStream("rainfall_input.bin"));

			 int stationCount = 0;
			 int districtCount = 0;

			 // Variables for average rainfall calculation
			 int[] totalRainfall = new int[6];
			 int[] stationRainfallCount = new int[6];

			 // Reading data for each station
			 while (input.available() > 0) {
				 
				 String stationId = input.readUTF();
				 String stationName = input.readUTF();
				 String districtName = input.readUTF();

				 System.out.println("Station ID: " + stationId);
				 System.out.println("Station Name: " + stationName);
				 System.out.println("District Name: " + districtName);

				 // Reading rainfall readings
				 System.out.println("Rainfall Readings:");
				 int stationTotalRainfall = 0;
				 for (int i = 0; i < 6; i++) {
					 
					 int data = input.readInt();
					 stationTotalRainfall += data;
					 totalRainfall[i] += data;
					 stationRainfallCount[i]++;

					 System.out.println("Day " + (i + 1) + ": " + data);
				 }

				 double stationAverageRainfall = stationTotalRainfall / 6.0;
				 System.out.println("Average Rainfall: " + stationAverageRainfall);
				 System.out.println();
				 stationCount++;
				 districtCount++;
			 }

			 input.close();

			 System.out.println("Number of Stations: " + stationCount);
			 System.out.println("Number of Districts: " + districtCount);
			 System.out.println("Average Rainfall for Each Day:");
			 for (int i = 0; i < 6; i++) {
				 double averageRainfall = totalRainfall[i] / (double) stationRainfallCount[i];
				 System.out.println("Day " + (i + 1) + ": " + averageRainfall);
			 }
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
}
