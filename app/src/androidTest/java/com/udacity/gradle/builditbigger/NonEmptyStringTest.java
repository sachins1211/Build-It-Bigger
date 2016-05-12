package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

/**
 * Created by sachin on 12/5/16.
 */
public class NonEmptyStringTest extends AndroidTestCase {

    @Override
    protected void runTest() throws Throwable {
        super.runTest();

        try {
            String string = new EndpointsAsyncTask().execute(getContext()).get();
            assertNotNull(string);
            assertTrue(string.length() > 0);
            Log.v("NonEmpty:: ",string);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
