package com.example.cyclapp_1_1;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class Home extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		
		// Listeners for Buttons
		View satNat = findViewById(R.id.sat_nav_button);
		satNat.setOnClickListener(Home.this);
		View pastRides = findViewById(R.id.view_past_rides_button);
		pastRides.setOnClickListener(Home.this);
		View about = findViewById(R.id.about_button);
		about.setOnClickListener(Home.this);
		View exit = findViewById(R.id.exit_button);
		exit.setOnClickListener(Home.this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.sat_nav_button:
			Intent i = new Intent(this, SatNav.class);
			startActivity(i);
			break;
		case R.id.view_past_rides_button:
			Toast.makeText(
					Home.this,
					"Display past rides!",
					Toast.LENGTH_LONG).show();
			break;
		case R.id.about_button:
			Intent in = new Intent(this, About.class);
			startActivity(in);
			break;
		case R.id.exit_button:
			new AlertDialog.Builder(this)
			.setMessage("Are you sure you want to exit?")
			.setCancelable(false)
			.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					//CustomTabActivity.this.finish();
					Home.this.finish();
				}
			})
			.setNegativeButton("No", null)
			.show();
			break;
		}
		
	}
}


