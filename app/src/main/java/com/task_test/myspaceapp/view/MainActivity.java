package com.task_test.myspaceapp.view;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.SphericalUtil;
import com.google.maps.android.clustering.ClusterManager;
import com.task_test.myspaceapp.R;
import com.task_test.myspaceapp.model.LocationData;
import com.task_test.myspaceapp.model.MyItem;
 import com.task_test.myspaceapp.viewModel.CompaniesViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseDemoActivity implements GoogleMap.OnMarkerDragListener {
    private TextView mTextView;
    private Marker mMarkerA;
    private List<Marker> companyMarkers;
    private Marker mMarkerB;
    private Polyline mPolyline;
    private  List<LocationData> companiesArrayList = new ArrayList<>();

    CompaniesViewModel companiesViewModel;
    private ClusterManager<MyItem> mClusterManager;
 //    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(ClusteringViewModel.class);
//        if (savedInstanceState == null) {
//            try {
//                mViewModel.readItems(getResources());
//            } catch (JSONException e) {
//                Toast.makeText(this, "Problem reading list of markers.", Toast.LENGTH_LONG).show();
//            }
//        }
//    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;

    }

    @SuppressLint("PotentialBehaviorOverride")
    @Override
    protected void startDemo(boolean isRestore) {

        initialization();
        getCompanyMarker();
        setUpClusterer();
        if (!isRestore) {
            companiesViewModel.getCompanyResponseLiveData().observe(this, companiesResponse -> {
                if (companiesResponse != null) {
                    List<LocationData> locationData = companiesResponse.getLocationData();
                    companiesArrayList.addAll(locationData);
                    Log.d(TAG,"OOOOOOKAY"+locationData);
                    Log.d(TAG,"SIZZEE : "+companiesArrayList.size());

                    for (int i=0;i<companiesArrayList.size();i++) {
                        getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(companiesArrayList.get(i).getLatitude(), companiesArrayList.get(i).getLongitude()), 10));
                        mMarkerA = getMap().addMarker(new MarkerOptions().position(new LatLng(companiesArrayList.get(i).getLatitude(), companiesArrayList.get(i).getLongitude())).icon(BitmapDescriptorFactory
                                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).draggable(true));
                    }
                }
            });

        }
        getMap().setOnMarkerDragListener(this);


        mMarkerA = getMap().addMarker(new MarkerOptions().position(new LatLng(51.038523, 2.372952)).draggable(true));
        mMarkerB = getMap().addMarker(new MarkerOptions().position(new LatLng(31.225439, 121.535876)).draggable(true));
        mPolyline = getMap().addPolyline(new PolylineOptions().geodesic(true));

         showDistance();
    }
    private void initialization() {
        companiesViewModel = new ViewModelProvider(this).get(CompaniesViewModel.class);
      }
    private void getCompanyMarker() {
    }
    private void setUpClusterer() {
        // Position the map.
        getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.503186, -0.126446), 10));

        // Initialize the manager with the context and the map.
        // (Activity extends context, so we can pass 'this' in the constructor.)
        mClusterManager = new ClusterManager<MyItem>(this, getMap());

        // Point the map's listeners at the listeners implemented by the cluster
        // manager.
        getMap().setOnCameraIdleListener(mClusterManager);
        getMap().setOnMarkerClickListener(mClusterManager);

        // Add cluster items (markers) to the cluster manager.
        addItems();
    }

    private void addItems() {
        // Set some lat/lng coordinates to start with.


        // Add ten cluster items in close proximity, for purposes of this example.
        for (int i = 0; i < companiesArrayList.size(); i++) {
            double lat =  companiesArrayList.get(i).getLatitude();
            double lng =  companiesArrayList.get(i).getLongitude();
            double offset = i / 60d;
            lat = lat + offset;
            lng = lng + offset;
            MyItem offsetItem = new MyItem(lat, lng, companiesArrayList.get(i).getTitle(), companiesArrayList.get(i).getImage());
            mClusterManager.addItem(offsetItem);
        }
    }
    private void showDistance() {
        double distance = SphericalUtil.computeDistanceBetween(mMarkerA.getPosition(), mMarkerB.getPosition());
     }

    private void updatePolyline() {
        mPolyline.setPoints(Arrays.asList(mMarkerA.getPosition(), mMarkerB.getPosition()));
    }



    @Override
    public void onMarkerDragEnd(@NonNull Marker marker) {
        showDistance();
        updatePolyline();
    }

    @Override
    public void onMarkerDragStart(@NonNull Marker marker) {

    }

    @Override
    public void onMarkerDrag(@NonNull Marker marker) {
        showDistance();
        updatePolyline();
    }
}