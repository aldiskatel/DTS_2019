package kominfo.go.id.direction;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.util.List;

import kominfo.go.id.direction.network.ApiServices;
import kominfo.go.id.direction.network.InitLibrary;
import kominfo.go.id.direction.response.Distance;
import kominfo.go.id.direction.response.Duration;
import kominfo.go.id.direction.response.LegsItem;
import kominfo.go.id.direction.response.ResponseRoute;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DirectionActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    private String API_KEY = "AIzaSyBe9P-itehQgH5BG7ox5vizpv5E1iGLMhg";

    private LatLng pickUpLatLng = new LatLng(-3.2956939, 114.5797416);
    private LatLng locationLatLng = new LatLng(-3.4375018, 114.8542852);

    private TextView tvStartAddress, tvEndAddress, tvDuration, tvDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getSupportActionBar().setTitle("Direction Maps API");

        widgetInit();
        actionRoute();
    }

    private void widgetInit() {
        tvStartAddress = findViewById(R.id.tvStartAddress);
        tvEndAddress = findViewById(R.id.tvEndAddress);
        tvDuration = findViewById(R.id.tvDuration);
        tvDistance = findViewById(R.id.tvDistance);
    }

    private void actionRoute() {
        String lokasiAwal = "-3.2956939,114.5797416";
        String lokasiAkhir = "-3.4375018,114.8542852";

        // Panggil Retrofit
        ApiServices api = InitLibrary.getInstance();
        // Siapkan request
        Call<ResponseRoute> routeRequest = api.request_route(lokasiAwal, lokasiAkhir, API_KEY);
        // kirim request
        routeRequest.enqueue(new Callback<ResponseRoute>() {
            @Override
            public void onResponse(Call<ResponseRoute> call, Response<ResponseRoute> response) {

                if (response.isSuccessful()) {
                    ResponseRoute dataDirection = response.body();

                    LegsItem dataLegs = dataDirection.getRoutes().get(0).getLegs().get(0);

                    String polylinePoint = dataDirection.getRoutes().get(0).getOverviewPolyline().getPoints();

                    List<LatLng> decodePath = PolyUtil.decode(polylinePoint);

                    mMap.addPolyline(new PolylineOptions().addAll(decodePath)
                            .width(8f).color(Color.argb(255, 56, 167, 252)))
                            .setGeodesic(true);


                    mMap.addMarker(new MarkerOptions().position(pickUpLatLng).title("Lokasi Awal"));
                    mMap.addMarker(new MarkerOptions().position(locationLatLng).title("Lokasi Akhir"));

                    Distance dataDistance = dataLegs.getDistance();
                    Duration dataDuration = dataLegs.getDuration();


                    tvStartAddress.setText("start location : " + dataLegs.getStartAddress().toString());
                    tvEndAddress.setText("end location : " + dataLegs.getEndAddress().toString());

                    tvDistance.setText("distance : " + dataDistance.getText() + " (" + dataDistance.getValue() + ")");
                    tvDuration.setText("duration : " + dataDuration.getText() + " (" + dataDuration.getValue() + ")");

                    LatLngBounds.Builder latLongBuilder = new LatLngBounds.Builder();
                    latLongBuilder.include(pickUpLatLng);
                    latLongBuilder.include(locationLatLng);

                    LatLngBounds bounds = latLongBuilder.build();

                    int width = getResources().getDisplayMetrics().widthPixels;
                    int height = getResources().getDisplayMetrics().heightPixels;
                    int paddingMap = (int) (width * 0.2); //jarak dari
                    CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, paddingMap);
                    mMap.animateCamera(cu);

                }
            }

            @Override
            public void onFailure(Call<ResponseRoute> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
}
