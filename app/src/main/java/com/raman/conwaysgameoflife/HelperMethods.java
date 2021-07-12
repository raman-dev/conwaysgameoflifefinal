package com.raman.conwaysgameoflife;

import android.content.Context;
import android.renderscript.Int2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Ramandeep on 2017-09-11.
 */

public class HelperMethods {

    //reads conwayObjects from a resource and returns them in a list of byte arrays and dimensions in a list of int2's
    public static void getConwayObjects(ArrayList<ConwayObject> conwayObjects, int resourceId, Context context){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(resourceId)));
        String line = getLine(bufferedReader);
        //first line of entire file
        //all objects start with a dimensions specification
        //followed by lines of 0's and 1's
        //should be dimensions of an object
        //this is first line of file must be dimensions
        while(line != null){
            String[] dimenStrings = line.split("=")[1].split("x");
            Int2 dimensions = new Int2();

            dimensions.x = Integer.parseInt(dimenStrings[0]);
            dimensions.y = Integer.parseInt(dimenStrings[1]);
            //then next x lines are the grid
            int i = 0;
            String gridLine = "";
            byte[] data = new byte[dimensions.x * dimensions.y];
            while(i < dimensions.x){
                gridLine = getLine(bufferedReader);
                int k = 0;
                for(char c : gridLine.toCharArray()){
                    data[i * dimensions.y +  k] = (byte)(c - '0');
                    k++;
                }
                i++;
            }
            conwayObjects.add(new ConwayObject(data,dimensions));
            //find next object
             line = getLine(bufferedReader);
            //skip over empty white lines
            while(line != null && !line.startsWith("size")){
                line = getLine(bufferedReader);
            }
        }

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getLine(BufferedReader bufferedReader) {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
