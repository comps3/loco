package com.example.second;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

 
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.content.Context;
import android.content.Intent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
 
import android.os.AsyncTask;
import java.lang.Iterable;
import java.util.List;
import java.util.Locale;



public class MainActivity extends Activity implements OnInfoWindowClickListener{
	
	private int userIcon, foodIcon, drinkIcon, shopIcon, otherIcon;
	private String address;
	private GoogleMap theMap;
	private LocationManager locMan;
	private Marker userMarker;
	String addr;
	String title;
	String description;
	double latitude;
	double longtitude;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent iin= getIntent();
		Bundle b = iin.getExtras();
		Geocoder geoCoder = new Geocoder(this);
		
		if(b!=null)
		{
			addr = (String) b.get("location");
			title = (String) b.getString("title");
			description = (String) b.getString("description");
		}
		
		 try {
             List<Address> addresses =
         geoCoder.getFromLocationName(addr, 1); 
             if (addresses.size() >  0) {
                latitude = addresses.get(0).getLatitude(); 
                longtitude = addresses.get(0).getLongitude(); 
                }

         } catch (IOException e) { // TODO Auto-generated catch block
         e.printStackTrace(); }
		
		userIcon = R.drawable.yellow_point;
		foodIcon = R.drawable.red_point;
		drinkIcon = R.drawable.blue_point;
		shopIcon = R.drawable.green_point;
		otherIcon = R.drawable.purple_point;
		
		if(theMap==null){
		    //map not instantiated yet
			theMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.the_map)).getMap();
		}
		if(theMap != null){
		    //ok - proceed
		}
		
		theMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		updatePlace();
	}
	
	
	private void updatePlace() {
		locMan = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		Location lastLoc = locMan.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		
	 //	double lat = lastLoc.getLatitude();
	//	double lng = lastLoc.getLongitude();
		LatLng lastLatLng = new LatLng(latitude, longtitude);
		
		if(userMarker!=null) {
			userMarker.remove();
		}
		
	
		userMarker = theMap.addMarker(new MarkerOptions()
	    .position(lastLatLng)
	    .title(title)
	    .icon(BitmapDescriptorFactory.fromResource(userIcon))
	    .snippet(description)
		.draggable(true));
		
		theMap.animateCamera(CameraUpdateFactory.newLatLng(lastLatLng), 3000, null);
		
		}


	@Override
	public void onInfoWindowClick(Marker arg0) {
		// TODO Auto-generated method stub
		
	}
	

	
	
		
		}
	


