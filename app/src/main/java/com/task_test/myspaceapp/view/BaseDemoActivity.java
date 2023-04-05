

package com.task_test.myspaceapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.task_test.myspaceapp.R;

public abstract class BaseDemoActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private boolean mIsRestore;

    protected int getLayoutId() {
        return R.layout.map;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIsRestore = savedInstanceState != null;
        setContentView(getLayoutId());
        setUpMap();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        if (mMap != null) {
            return;
        }
        mMap = map;
        startDemo(mIsRestore);
    }

    private void setUpMap() {
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }

    /**
     * Run the demo-specific code.
     */
    protected abstract void startDemo(boolean isRestore);

    protected GoogleMap getMap() {
        return mMap;
    }
}
