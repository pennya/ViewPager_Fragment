package com.example.kjh.viewpager_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by KJH on 2017-05-15.
 * Fragment Life Style
 * 1. Fragment is added
 * 2. onAttach()                    Fragment가 Activty에 붙을때 호출
 * 3. onCreate()                    Activty에서의 onCreate()와 비슷하나, ui 관련 작업은 할 수 없다.
 * 4. onCreateView()                Layout을 inflater을 하여 View 작업을 하는 곳
 * 5. onActivityCreated()           Activity에서 Fragment를 모두 생성하고난 다음에 호출됨. Activty의 onCreate()에서 setContentView()한 다음과 같다
 * 6. onStart()                     Fragment가 화면에 표시될때 호출, 사용자의 Action과 상호 작용이 불가능함
 * 7. onResume()                    Fragment가 화면에 완전히 그렸으며, 사용자의 Action과 상호 작용이 가능함
 * 8. Fragment is active
 * 9. User navigates backward or fragment is removed/replaced  or Fragment is added to the back stack, then removed/replaced
 * 10. onPause()
 * 11. onStop()                     Fragment가 화면에서 더이상 보여지지 않게됬을때
 * 12. onDestroy()                  View 리소스를 해제할수있도록 호출. backstack을 사용했다면 Fragment를 다시 돌아갈때 onCreateView()가 호출됨
 * 13. onDetached()
 * 14. Fragment is destroyed
 */


/**
 * Google Map CallStack
 * 1. onCreate()
 * 2. onCreateView()
 * 3. onActivityCreated()
 * 4. onStart();
 * 5. onResume();
 * 5-2. onMapReady();
 * 6. onPause();
 * 7. onSaveInstanceState();
 * 8. onMapReady();
 */

public class Fragment1 extends Fragment implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private MapView mapView;

    public Fragment1()
    {
        // required
    }

    // Alt + Insert , Override method click  = ctrl + o
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View layout = inflater.inflate(R.layout.fragment_fragment1, container, false);

        mapView = (MapView)layout.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);

        return layout;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onLowMemory();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //액티비티가 처음 생성될 때 실행되는 함수
        MapsInitializer.initialize(getActivity().getApplicationContext());

        if(mapView != null)
        {
            mapView.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // OnMapReadyCallback implements 해야 mapView.getMapAsync(this); 사용가능
        // this 가 OnMapReadyCallback
        initialMap();
    }

    private void initialMap()
    {

    }
}
