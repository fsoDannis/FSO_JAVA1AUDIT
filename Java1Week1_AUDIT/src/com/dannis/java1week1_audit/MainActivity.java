/*
 * Dan Annis
 * Java 1 Week 1 - Audit
 * June 6 2013
 */
package com.dannis.java1week1_audit;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	TextView results;
	TextView pricePerAppResult;
	EditText companyField;
	EditText amtdownloadedField;
	int totalAppsNeeded;
	int pricePerApp;
	boolean groupRate;
	

	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    
    //Not used at this point in the class
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
