package com.example.second;

import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Location extends Activity {

	TextView address;
	TextView title;
	TextView description;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location);

		// Connects the elements from the Location layout
		address = (TextView)findViewById(R.id.editText1);
		title = (TextView)findViewById(R.id.editText2);
		description = (TextView)findViewById(R.id.editText3);
	}

	public void passToActivity(View v)
	{

	   Intent i = new Intent(this, MainActivity.class);
	   // Fetches user's input of address, title, and description
	   String addrString = address.getText().toString();
	   String titleString = title.getText().toString();
	   String descriptionString = description.getText().toString();
	   // Add the location data
	   i.putExtra("location", addrString);
	   i.putExtra("title", titleString);
	   i.putExtra("description", descriptionString);
	   startActivity(i);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

}
