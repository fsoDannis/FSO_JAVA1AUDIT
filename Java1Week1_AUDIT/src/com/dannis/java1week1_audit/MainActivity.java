/*
 * Dan Annis
 * Java 1 Week 1 - Audit
 * June 6 2013
 */
package com.dannis.java1week1_audit;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends Activity {

	
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	TextView results;
	TextView pricePerAppResult;
	TextView error;
	EditText companyField;
	EditText amtdownloadedField;
	int totalPrice;
	int totalDiscoPrice;
	int pricePerApp;
	int pricePerDiscoApp;
	int groupSavings;
	boolean groupRate;
	String discount = "Serious savings are coming your way!\r\n\r\n";
	String scompanyField;
	String samtdownloadedField;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     // setting up the linear layout cause this is what we do
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        
     // setting up the layout params which tells the layout to match both the width and the height of the entire screen
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
     // setting up Edit text boxes for user entry
        companyField = new EditText(this);
        scompanyField = companyField.getText().toString();
        companyField.setHint("Company Name");
        amtdownloadedField = new EditText(this);
        samtdownloadedField = amtdownloadedField.getText().toString();
        amtdownloadedField.setHint("QTY of Apps needed");
        
     //by default the groupRate will be false
        groupRate = false;
     
     // Calculation Button
        Button compute = new Button(this);
        compute.setText("Compute!");
        compute.setOnClickListener(new View.OnClickListener() {

        	@Override
        	public void onClick(View v) {
        		
        		boolean fieldsOK=validate(new EditText[]{companyField, amtdownloadedField});
        		
        		if(fieldsOK){
        				
        		//Convert the number entered(a string) to an integer that I can work with to mathmatize! 
        		int amountNeeded = Integer.parseInt(amtdownloadedField.getText().toString());	
        		//Grab the cost for the app
        		int costPerDownload = getResources().getInteger(R.integer.appPrice);
        		//Do the Math
        		totalPrice = amountNeeded*costPerDownload;
        		//In case I want to call the price of the app
        		pricePerApp = costPerDownload;
        		
        		// Needed to add some sort of welcome message after the compute was hit
        		results.setText("Attached you will find the quote for "+ companyField.getText().toString()  + ".\r\n\r\n");
        		
        		//Need to do some conditional thingy	
        		if(amountNeeded>200){
        				groupRate = true;
    			if (groupRate){
    				results.append(discount);
    				}
        			int costPerDiscount = getResources().getInteger(R.integer.discoPrice);
        			pricePerDiscoApp = costPerDiscount;
        			totalDiscoPrice = amountNeeded*costPerDiscount;
        			results.append("Normally the Price per app would be $"+pricePerApp+" dollars, but because you get a discounted rate due to the quantity ordered, " +
        					"the total price will be $" + totalDiscoPrice + " at $" + pricePerDiscoApp + " per download.");
        			groupSavings = totalPrice-totalDiscoPrice;
        			results.append("\r\n\r\nA savings of $" +groupSavings+"!!!");
					        			}
        			else{
        				//Show the Results of the Calculation
                		results.append("The total price will be $" + totalPrice + " at $" + pricePerApp + " per download.");
        		    }
        		//If the Fields Fail the Check, Throw an Error
        		}else{
        			error.append("Enter a Company Name and Quantity first please...");
        			error.setTextColor(Color.RED);
        		}
        	}
        });
        
        
        
     // Create the Layout for the app
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        form.setLayoutParams(lp);
        
     // Adding fields to the layout
        error = new TextView(this);
        ll.addView(error);
        form.addView(companyField);
        form.addView(amtdownloadedField);
        form.addView(compute);
        ll.addView(form);
        
        
     //Display the result Text
        results = new TextView(this);
        ll.addView(results);
        
        
     //Setting the ll to show
        setContentView(ll);
    }

    
    //Loop that checks the fields to see if they are blank or not. 
    public boolean validate(EditText[] fields){
        for(int i=0; i<fields.length; i++){
            EditText currentField=fields[i];
            if(currentField.getText().toString().length()<=0){
                return false;
            }
        }
        return true;
}
    //Not used at this point in the class
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
