package co.edu.unipiloto.laboratoriointendsgooglemaps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    private LocationManager ubicacion;
    TextView longitud;
    TextView latitud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        localizacion();
    }
    private void localizacion(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            },1000);
        }
        longitud=(TextView) findViewById(R.id.txtLongitud);
        latitud=(TextView) findViewById(R.id.txtLatitud);
        ubicacion = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location localizacion = ubicacion.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if(ubicacion!=null){
            Log.d("Latitud", String.valueOf(localizacion.getLatitude()));
            Log.d("Longitud", String.valueOf(localizacion.getLongitude()));
            longitud.setText(String.valueOf(localizacion.getLongitude()));
            latitud.setText(String.valueOf(localizacion.getLatitude()));
        }
    }
}