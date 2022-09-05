package com.example.projectjavaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;

public class GeolocActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    private EditText lat;
    private EditText lon;
    private Button obtener;
   // private ProgressBar progressBar;
    FusedLocationProviderClient fusedLocationProviderClient;
    private View viewi;
    private String urlMapaGo = "https://www.google.com.ec/maps/@";

/*
    public static final int REQUEST_CODE = 1;


    EditText lat;
    EditText lon;

    Button btnCoordenadas;

 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geoloc);
/*
        lat = findViewById(R.id.edtlatitud);
        lon = findViewById(R.id.edtlongitud);

        obtener = findViewById(R.id.btnObtenerCoordenda);
        progressBar = findViewById(R.id.progressBar);

 */

        lat = findViewById(R.id.txtLatit);
        lon = findViewById(R.id.txtLong);


        obtener = findViewById(R.id.button4);

        ObtenerCoordendasActual(viewi);
    }




    public void ObtenerCoordendasActual(View view) {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(GeolocActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
        } else {
            getCoordenada();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCoordenada();
            } else {
                Toast.makeText(this, "Permiso Denegado ..", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getCoordenada() {

        try {
            LocationRequest locationRequest = LocationRequest.create()
                    .setInterval(100)
                    .setFastestInterval(3000)
                    .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
                    .setMaxWaitTime(200);


            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            LocationServices.getFusedLocationProviderClient(this).requestLocationUpdates(locationRequest, new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    super.onLocationResult(locationResult);
                    LocationServices.getFusedLocationProviderClient(GeolocActivity.this).removeLocationUpdates(this);
                    if (locationResult != null && locationResult.getLocations().size() > 0) {
                        int latestLocationIndex = locationResult.getLocations().size() - 1;
                        double latitud = locationResult.getLocations().get(latestLocationIndex).getLatitude();
                        double longitude = locationResult.getLocations().get(latestLocationIndex).getLongitude();
                        lat.setText(String.valueOf(latitud));
                        lon.setText(String.valueOf(longitude));
                        urlMapaGo=urlMapaGo+latitud+","+longitude+",15z";
                    }
                }

            }, Looper.myLooper());

        }catch (Exception ex){
            System.out.println("Error es :" + ex);
        }

    }

    
    //metodo para ir a la aplicacion de mapas
    public void irMapa(View v){
        //String url= "https://www.google.com.ec/maps/@-0.2843745,-78.5092769,15z";
        Uri _link = Uri.parse(urlMapaGo);
        Intent i = new Intent(Intent.ACTION_VIEW, _link);
        startActivity(i);


    }

}