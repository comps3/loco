package com.example.second;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Login extends Activity {

	Button loginButton;
	TextView firstName;
	TextView password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		loginButton = (Button)findViewById(R.id.button1);
		firstName = (TextView)findViewById(R.id.editText1);
		password = (TextView)findViewById(R.id.editText2);
		firstName.setText("First Name");
		password.setText("Password");
	}

	public void verify(View v)
	{
		if(firstName.equals("brett"));
		{
			Intent intent = new Intent(this, Location.class);
		    startActivity(intent);
		} 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

}
