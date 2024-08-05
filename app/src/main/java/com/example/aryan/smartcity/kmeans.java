package com.example.aryan.smartcity;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Instances;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;



public class kmeans {
    public static BufferedReader readDataFile(String filename) {
        BufferedReader inputReader = null;

        try {
            inputReader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + filename);
        }

        return inputReader;

}
    public static void main(String[] args) throws Exception {
        SimpleKMeans kmeans = new SimpleKMeans();

        kmeans.setSeed(10);

        //important parameter to set: preserver order, number of cluster.
        kmeans.setPreserveInstancesOrder(true);
        kmeans.setNumClusters(2);

        BufferedReader datafile = readDataFile("C:/Users/ryan/workspace/data.arff");
        String data = "new Instances(datafile)";


          kmeans.buildClusterer(data);

        // This array returns the cluster number (starting with 0) for each instance
        // The array has as many elements as the number of instances
        int[] assignments = kmeans.getAssignments();

        int i=0;
        for(int clusterNum : assignments) {
            System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
            i++;
        }
    }
}
