package com.raman.conwaysgameoflife;

import android.renderscript.Int2;

import java.util.Arrays;

/**
 * Created by Ramandeep on 2017-09-22.
 */

public class ConwayObject {
    public byte[] data;
    public Int2 dimensions;
    public ConwayObject(byte[] data,Int2 dimensions){
        this.data = data;
        this.dimensions = dimensions;
    }


    @Override
    public String toString(){
        //print as 2d

        return "dimensions => ("+ dimensions.x + "," + dimensions.y +") \n"+ Arrays.toString(data);
    }
}
