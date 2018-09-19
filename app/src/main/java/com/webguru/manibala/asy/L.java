package com.webguru.manibala.asy;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import static android.R.id.message;

/**
 * Created by Manibala on 2016-12-25.
 */

public class L {
    public static void m(String message)
    {
        Log.d("VIVZ", message);
    }
    public static void s(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
