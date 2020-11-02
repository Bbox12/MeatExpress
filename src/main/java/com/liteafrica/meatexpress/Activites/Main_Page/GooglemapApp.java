package com.liteafrica.meatexpress.Activites.Main_Page;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.SquareCap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.maps.android.SphericalUtil;
import com.liteafrica.meatexpress.Activites.Canteen.Canteen_Mainactivity;
import com.liteafrica.meatexpress.Activites.Canteen.SelectePaymentOption;
import com.liteafrica.meatexpress.Adapters.BookingAdapter;
import com.liteafrica.meatexpress.AppController;
import com.liteafrica.meatexpress.BuildConfig;
import com.liteafrica.meatexpress.Config_URL;
import com.liteafrica.meatexpress.FCM.NotificationUtils;
import com.liteafrica.meatexpress.Login.ServiceOffer;
import com.liteafrica.meatexpress.Model.Foods;
import com.liteafrica.meatexpress.Model.Promo;
import com.liteafrica.meatexpress.PrefManager;
import com.liteafrica.meatexpress.R;
import com.liteafrica.meatexpress.Utils.DirectionsJSONParser;
import com.liteafrica.meatexpress.Utils.Marker_custom_infowindow;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import static com.google.android.gms.maps.model.JointType.ROUND;

/**
 * Created by parag on 31/12/16.
 */
public class GooglemapApp extends AppCompatActivity implements
        OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener, Animation.AnimationListener {
    private static final String TAG = GooglemapApp.class.getSimpleName();
    private static final int REQUEST_RESOLVE_ERROR = 1001;
    // Unique tag for the error dialog fragment
    private static final String DIALOG_ERROR = "dialog_error";
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
    private static final int REQUEST_CHECK_SETTINGS = 0x1;
    private static final LatLngBounds BOUNDS_MOUNTAIN_VIEW = new LatLngBounds(
            new LatLng(25.00000, 91.00000), new LatLng(27.99999, 91.99999));
    private static final float POLYLINE_WIDTH = 8;
    private static final int REQUEST_PICK_FROM = 10016;
    private static DecimalFormat df2 = new DecimalFormat(".00");
    private final int REQUEST_LOCATION = 200;
    double My_lat, My_long;
    DecimalFormat dft = new DecimalFormat("0.00");
    DecimalFormat dfto = new DecimalFormat("0.000000");
    BottomSheetBehavior sheetBehavior;
    BottomSheetBehavior sheetBehaviornear;
    SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("yyy-MM-dd");
    private RecyclerView _moreRv;
    private GoogleApiClient mGoogleApiClient;
    private CoordinatorLayout coordinatorLayout;
    private Toolbar toolbar;
    private String User_image;
    private String User_name;
    private GoogleMap googleMap;
    private String regId;
    private ProgressBar progressBar;
    private PendingResult<LocationSettingsResult> result;
    private LocationSettingsRequest.Builder builder;
    // Bool to track whether the app is already resolving an error
    private boolean mResolvingError = false;
    private String strAdd;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest mLocationRequest;
    private LocationCallback mLocationCallback;
    private Location mCurrentLocation;
    private Boolean mRequestingLocationUpdates;
    private ImageView myLocationButton;
    private boolean clicK = false;
    private Marker marker;
    private DatabaseReference mDatabase;
    private double User_From_lat = 0, User_From_long = 0, User_To_lat = 0, User_To_long = 0;
    private ScrollView L1;
    private Marker markerd;
    private LinearLayout SearchingLL;
    private Marker[] markers = new Marker[500];
    private ArrayList<Promo> mPromos = new ArrayList<Promo>();
    private Animation expandIn;
    private LatLng midLatLng;
    private AppBarLayout AppBar;
    private RelativeLayout AllRl;
    private String OTP;
    private TextView Ride_otp, Ride_driver_name, Ride_car_no, Ride_car_no1;
    private SupportMapFragment mapFragment;
    private PrefManager pref;
    private String _phoneNo;
    private String Driver_phone;
    private String Driver_name, Driver_image, Vehicle_no, Vehicle_image, Vehicle_type = "Van";
    private boolean isInternetPresent = false;
    private ArrayList<LatLng> markerPoints = new ArrayList<LatLng>();
    private Button Call_driver, cancelorder;
    private String User_accept;
    private double Driver_lat = 0, Driver_long = 0;
    private ImageView CenterMarker;
    private boolean first = false;
    private String Pick_up, Drop_at;
    private Boolean ask = false;
    private Boolean wait = false;
    private Boolean go = false;
    private String con;
    private boolean drop = false;
    private Marker markerCar;
    private Polyline polylineFinal;
    private LinearLayout _diver_car_image_rl, _etr;
    private HorizontalScrollView _call_track_ll;
    private LinearLayout _again_cancel_confirm_ll;
    private boolean animate = false;
    private boolean drawn = false;
    private double KM = 0;
    private Animation animslideD;
    private Animation animslideU;
    private int User_ID = 0;
    private String mobileIp;
    private String mobileno;
    private String Discount_value;
    private double Distance = 0;
    private double COST = 0;
    private boolean got = false;
    private boolean _reached = false;
    private boolean _userRef = false;
    private LinearLayout layoutBottomSheet;
    private boolean drawn1 = false;
    private boolean drawn2 = false;
    private boolean drawn3 = false;
    private boolean drawn4 = false;
    private boolean drawn5 = false;
    private boolean get1 = false;
    private boolean get2 = false;
    private boolean get3 = false;
    private boolean get4 = false;
    private boolean get5 = false;
    private int Rate_ = 0;
    private Dialog dialog1;
    private TextView rideCost;
    private boolean cancl_again = false;
    private ImageView i2;
    private boolean _delete = false;
    private double pick_lat, pick_long;
    private boolean car = false;
    private String _Rate;
    private boolean _clear = false;
    private int _noVehicle = 0;
    private RelativeLayout rMap;
    private boolean first1 = false;
    private boolean _Track = false;
    private boolean _newRide = false;
    private boolean drag = false;
    private boolean _seen = false;
    private boolean stoped = false;
    private Runnable r;
    private Handler handler;
    private Animation animBlink, animRotate;
    private ImageView _callImage, _cancelImage;
    private String _rate;
    private String Favourite;
    private boolean success;
    private LinearLayout layoutBottomSheetnear;
    private TextView _moneyValue, _itemValue, _discount, _moneyValue1, _itemValue1;
    private TextView _estimate;
    private String ETR = "10";
    private boolean _second = false;
    private EditText place_zip;
    private ProgressDialog mProgressDialog;
    private TextView discount, _moreValue, _servicable, _reason, minimum_order, minimum_person, canteen_time, canteen_time1;
    private DecimalFormat df = new DecimalFormat("0.00");
    private ArrayList<Foods> mItems = new ArrayList<Foods>();
    private Button _cancel, _confirm;
    private LinearLayoutManager mLayoutManager;
    private boolean isLoading = false;
    private int _last = 0;
    private int myID = 0;
    private NestedScrollView _nsScroll;
    private boolean _end = false;
    private int hour;
    private TextView _tAmount, _dAmount, _delAmount, _payAmount, _cAmount;
    private String _total;
    private double _less, _more;
    private int j = 0;
    private String commaSeparatedValues;
    private RelativeLayout _can;

    private Button Ride_now, Ride_cancel;
    private AutoCompleteTextView My_address;
    private ImageView Heart_t1, Heart_t2;
    private TextView Drop, Pick, _searchText;
    private RelativeLayout rideButtons;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private int _palce;
    private EditText Home, Work, Other;
    private PlacesClient placesClient;
    private SwitchCompat placeswitch;
    private RadioButton athome, atwork, savedhome, savedwork;
    private int _homechecked = 0;
    private EditText place_home_saved, place_work_saved, place_other_saved, place_zip_saved;
    private Button ride_now_saved, ride_cancel_saved;
    private String _address, _houseno, _landmark, _zip;
    private RadioButton orderaccepted, ontheway, comming, confirmorder, Order_in_Progress;
    private View _v1;
    private RelativeLayout _totals;
    private LinearLayout _L2;
    private ImageView Ride_driver_image;
    private FirebaseDataListener_after_ride _firebaseLogs;
    private String _Locality = "";
    private String _verify;


    public static String getMobileIPAddress() {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        return addr.getHostAddress();
                    }
                }
            }
        } catch (Exception ignored) {
        } // for now eat exceptions
        return null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = new PrefManager(getApplicationContext());
        HashMap<String, String> user = pref.getUserDetails();
        _phoneNo = user.get(PrefManager.KEY_MOBILE);
        setContentView(R.layout.dialogmap);
        layoutBottomSheetnear = findViewById(R.id.near);
        sheetBehaviornear = BottomSheetBehavior.from(layoutBottomSheetnear);
        savedhome = findViewById(R.id.savedhome);
        savedwork = findViewById(R.id.savedwork);
        place_home_saved = findViewById(R.id.place_home_saved);
        place_work_saved = findViewById(R.id.place_work_saved);
        place_other_saved = findViewById(R.id.place_other_saved);
        place_zip_saved = findViewById(R.id.place_zip_saved);
        ride_now_saved = findViewById(R.id.ride_now_saved);
        ride_now_saved.setOnClickListener(this);
        ride_cancel_saved = findViewById(R.id.ride_cancel_saved);
        ride_cancel_saved.setOnClickListener(this);
        _totals = findViewById(R.id._total);
        layoutBottomSheet = findViewById(R.id.bottom_sheet_2);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        viewPager = findViewById(R.id.viewPagerVertical);
        adapter = new ViewPagerAdapter();
        viewPager.setAdapter(adapter);
        rideButtons = findViewById(R.id.linearLayout);
        _can = findViewById(R.id.cans);
        _cancel = findViewById(R.id._cancel_book);
        _confirm = findViewById(R.id._confirm_book);
        placeswitch = findViewById(R.id.placeswitch);
        place_zip = findViewById(R.id.place_zip);
        athome = findViewById(R.id.athome);
        atwork = findViewById(R.id.atwork);
        Home = findViewById(R.id.place_home1);
        Work = findViewById(R.id.place_work1);
        Other = findViewById(R.id.place_other1);
        _confirm.setEnabled(false);
        _cancel.setEnabled(false);
        _moreRv = findViewById(R.id.moreRvs);
        _moreRv.setNestedScrollingEnabled(false);
        _moneyValue = findViewById(R.id.canteen_amounts);
        _itemValue = findViewById(R.id._noofItemss);
        _moneyValue1 = findViewById(R.id.canteen_amounts1);
        _itemValue1 = findViewById(R.id._noofItemss1);
        _discount = findViewById(R.id.discounts);
        _tAmount = findViewById(R.id._tamounts);
        _dAmount = findViewById(R.id._damounts);
        _cAmount = findViewById(R.id._camounts);
        _delAmount = findViewById(R.id._delamounts);
        _payAmount = findViewById(R.id._payamounts);
        My_address = findViewById(R.id.del_address);
        My_address.setOnClickListener(this);
        Ride_now = findViewById(R.id.ride_now);
        Ride_now.setOnClickListener(this);
        Ride_cancel = findViewById(R.id.ride_cancel);
        Ride_cancel.setOnClickListener(this);
        rMap = findViewById(R.id.rmap);
        _callImage = findViewById(R.id._callImage);
        _callImage = findViewById(R.id._cancelImage);
        AllRl = findViewById(R.id.ride_detail);
        Ride_otp = findViewById(R.id.textotp);
        _diver_car_image_rl = findViewById(R.id.relativeLayout2);
        _call_track_ll = findViewById(R.id.lov1);
        Ride_driver_name = findViewById(R.id.driver_name);
        //Ride_car_image = findViewById(R.id.driver_car);
        Ride_car_no1 = findViewById(R.id.driver_car_no1);
        Ride_car_no = findViewById(R.id.driver_car_no);
        CenterMarker = findViewById(R.id.it);
        Call_driver = findViewById(R.id.call_driver);
        cancelorder = findViewById(R.id.cancelorder);
        cancelorder.setOnClickListener(this);
        AppBar = findViewById(R.id.app_bar_main);
        coordinatorLayout = findViewById(R.id
                .cor_home_main);
        SearchingLL = findViewById(R.id._holding);
        toolbar = findViewById(R.id.toolbar_main);
        rideCost = findViewById(R.id.ride_cost);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        orderaccepted = findViewById(R.id.orderaccepted);
        ontheway = findViewById(R.id.ontheway);
        comming = findViewById(R.id.comming);
        confirmorder = findViewById(R.id.confirmorder);
        Order_in_Progress = findViewById(R.id.Order_in_Progress);


        progressBar = findViewById(R.id.progressBar3_map);
        myLocationButton = findViewById(R.id.myLocationCustomButton);
        expandIn = AnimationUtils.loadAnimation(this, R.anim.expand_in);
        expandIn = AnimationUtils.loadAnimation(this, R.anim.expand_in);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);


        mapFragment.getMapAsync(GooglemapApp.this);
        createLocationCallback();
        buildLocationSettingsRequest();
        rebuildGoogleApiClient();
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            onConnected(null);
        }


        mDatabase = FirebaseDatabase.getInstance().getReference();
        myLocationButton.setOnClickListener(this);
        Call_driver.setOnClickListener(this);


        animslideD = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down1);
        animslideU = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up1);

        animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);

        _callImage.setAnimation(animBlink);
        _callImage.setAnimation(animBlink);
        myLocationButton.setAnimation(expandIn);
        mRequestingLocationUpdates = false;
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(GooglemapApp.this);


        mobileIp = getMobileIPAddress();
        if (TextUtils.isEmpty(mobileIp)) {
            mobileIp = getWifiIPAddress();
        }


        sheetBehavior.setHideable(true);
        layoutBottomSheet.setVisibility(View.GONE);

        sheetBehaviornear.setHideable(false);
        _estimate = findViewById(R.id._estimate);
        _etr = findViewById(R.id._etr);


        pref.set_cID1(0);

        _L2 = findViewById(R.id._L2);

        Ride_driver_image = findViewById(R.id.driver_image);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_out2, R.anim.slide_in2);
            }
        });

        if (!com.google.android.libraries.places.api.Places.isInitialized()) {
            com.google.android.libraries.places.api.Places.initialize(getApplicationContext(), Config_URL.APIKEY);
        }

        _searchText = findViewById(R.id._searchText);
   /*     paymentverified=findViewById(R.id.paymentverified);
        _v1=findViewById(R.id._v1);
        if(pref.getPayment()==2){
            paymentverified.setVisibility(View.VISIBLE);
            _v1.setVisibility(View.VISIBLE);
        }else{
            paymentverified.setVisibility(View.GONE);
            _v1.setVisibility(View.GONE);
        }*/

        _firebaseLogs = new FirebaseDataListener_after_ride();
    }

    public String getWifiIPAddress() {
        WifiManager wifiMgr = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
        int ip = wifiInfo.getIpAddress();
        return Formatter.formatIpAddress(ip);
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        if (map == null) {
            //Ride_now.setEnabled(false);
            if (!GooglemapApp.this.isFinishing()) {
                new AlertDialog.Builder(GooglemapApp.this, R.style.AlertDialogTheme)
                        .setIcon(R.mipmap.ic_launcher)
                        .setTitle("Cannot load Google Map")
                        .setMessage("May be poor network!Contact customer care for booking offline")
                        .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        })
                        .show();
            }
        } else {

            googleMap = map;


            Marker_custom_infowindow adapter = new Marker_custom_infowindow(GooglemapApp.this);
            googleMap.setInfoWindowAdapter(adapter);
            marker = googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(Double.parseDouble(pref.getPickLat()), Double.parseDouble(pref.getPickLong())))
                    .icon(BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            marker.setAnchor(0.5f, 0.5f);
            marker.setTitle("MeatExpress");
            marker.showInfoWindow();


            markerd = googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(0, 0))
                    .icon(BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            markerd.setAnchor(0.5f, 0.5f);


            googleMap.getUiSettings().setZoomControlsEnabled(false);
            googleMap.getUiSettings().setAllGesturesEnabled(true);
            googleMap.getUiSettings().setMyLocationButtonEnabled(false);

            googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker arg0) {
                    arg0.hideInfoWindow();
                    return false;
                }
            });


            googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {

                @Override
                public void onMapLoaded() {

                    startLocationUpdat();
                }
            });


        }
    }

    private void startLocationUpdat() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        if (mFusedLocationClient != null) {
            mFusedLocationClient.requestLocationUpdates(createLocationRequest(), new LocationCallback() {
                        @Override
                        public void onLocationResult(LocationResult locationResult) {
                            if (!stoped) {
                                List<Location> locationList = locationResult.getLocations();
                                if (locationList.size() > 0) {
                                    Location location = locationList.get(locationList.size() - 1);
                                    Log.i("MapsActivity", "Location: " + location);
                                    updateLocationUI(location);
                                }
                            }
                        }
                    },
                    Looper.myLooper());
        }
    }

    private void updateLocationUI(Location location) {

        My_lat = location.getLatitude();
        My_long = location.getLongitude();

        if (!first && googleMap != null) {
            first = true;
            markerd.setPosition(new LatLng(My_lat, My_long));
            if (pref.getUniqueRide() != null) {
                String[] pars = pref.getUniqueRide().split("\\.");
                con = TextUtils.join("", pars);
                mDatabase.child("Meat").child(con).addValueEventListener(_firebaseLogs);
            }
            markerPoints.add(marker.getPosition());
            markerPoints.add(markerd.getPosition());
            if (markerPoints.size() == 2) {
                LatLng origin = markerPoints.get(0);
                LatLng dest = markerPoints.get(1);
                String url = getDirectionsUrl(origin, dest);
                new Get_distance_draw_polyiline().execute(url);
            }

            if (strAdd == null) {
                getCompleteAddressString(My_lat, My_long);
            }

        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (_phoneNo != null) {
            car = false;

            stoped = false;

            _confirm.setVisibility(View.VISIBLE);
            _cancel.setVisibility(View.VISIBLE);
            _confirm.setEnabled(true);
            _cancel.setEnabled(true);
            _cancel.setOnClickListener(this);
            _confirm.setOnClickListener(this);


            if (mGoogleApiClient != null) {
                mGoogleApiClient.connect();
                if (checkPermissions()) {
                    startLocationUpdat();
                } else {
                    requestPermissions();
                }
            }


            atwork.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        _homechecked = 1;
                    }
                }
            });

            athome.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        _homechecked = 2;
                    }
                }
            });

            savedwork.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        checkAddress(1);
                    }
                }
            });

            savedhome.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        checkAddress(2);
                    }
                }
            });

            if (!GooglemapApp.this.isFinishing()) {
                if (mProgressDialog == null) {
                    mProgressDialog = new ProgressDialog(GooglemapApp.this, R.style.Theme_AppCompat_Light_Dialog_MinWidth);
                    mProgressDialog.setIcon(R.mipmap.ic_launcher);
                    mProgressDialog.setTitle("Getting details of your order");
                    mProgressDialog.setMessage("please wait...");
                    mProgressDialog.setIndeterminate(false);
                    mProgressDialog.show();
                }
            }

            if (pref.getCharge() == 0) {
                _can.setVisibility(View.GONE);
            } else {
                _can.setVisibility(View.VISIBLE);
                _cAmount.setText("R " + df.format(pref.getCharge()));
            }
            myID = 1;


            int Rate = 0;
            if (pref.get_packagesharedPreferences() != null) {
                mItems.clear();
                Set<String> set = pref.get_packagesharedPreferences();

                for (String s : set) {
                    String[] pars = s.split("\\_");
                    Foods items = new Foods();
                    items.setID(Integer.parseInt(pars[0]));
                    items.setNoofItems((int) Double.parseDouble(pars[1]));
                    items.seteTEZ_Price((int) Double.parseDouble(pars[2]));
                    Rate = (int) (Double.parseDouble(pars[2]) + Rate);
                    items.setMenu_Name((pars[3]));
                    mItems.add(items);
                    pref.set_food_money(Rate);
                }
                if (mItems.size() > 0) {
                    _moreRv.setVisibility(View.VISIBLE);
                    BookingAdapter sAdapter1 = new BookingAdapter(GooglemapApp.this, mItems);
                    sAdapter1.notifyDataSetChanged();
                    sAdapter1.setPref(pref);
                    sAdapter1.setFrom(j);
                    mLayoutManager = new LinearLayoutManager(GooglemapApp.this, LinearLayoutManager.VERTICAL, false);
                    _moreRv.setLayoutManager(mLayoutManager);
                    _moreRv.setItemAnimator(new DefaultItemAnimator());
                    _moreRv.setAdapter(sAdapter1);
                    _moreRv.setHasFixedSize(true);
                    _tAmount.setText("R " + df.format(Rate));
                } else {
                    Intent o = new Intent(GooglemapApp
                            .this, Canteen_Mainactivity.class);
                    startActivity(o);
                    finish();
                    overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                }

            }


            if (pref.getisDel() != 0) {
                _delAmount.setText(df.format(pref.getDcharge()));
            } else {
                _delAmount.setText("TBC");
            }
            _total = df.format(Rate);
            Log.w("Dis", _total);

            _payAmount.setText("R " + _total);
            //  _moneyValue.setText(_total);
            if (pref.getTotal2() == null) {
                if (Rate != 0) {
                    pref.setTotal(_total);
                    _moneyValue1.setText(pref.getTotal());
                    _moneyValue.setText(pref.getTotal());
                }
            } else {
                _moneyValue1.setText(pref.getTotal2());
                _moneyValue.setText(pref.getTotal2());
            }
            _confirm.setEnabled(true);
            _cancel.setEnabled(true);

            _itemValue.setText("No of items " + pref.get_food_items());

            _itemValue1.setText("No of items " + pref.get_food_items());
            if (pref.getcDiscount() != 0) {
                _discount.setVisibility(View.VISIBLE);
                _discount.setText(dft.format(pref.getcDiscount()) + "% discount on all orders");
                double tot = Rate * .01 * pref.getcDiscount();
                _dAmount.setText("R " + df.format(tot));
            } else {
                _discount.setVisibility(View.GONE);
            }
            int height = getResources().getDisplayMetrics().heightPixels;
            if (pref.getUniqueRide() == null) {
                sheetBehaviornear.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
                layoutBottomSheetnear.setVisibility(View.VISIBLE);
                sheetBehaviornear.setPeekHeight(height / 2);
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
                layoutBottomSheet.setVisibility(View.VISIBLE);
                sheetBehavior.setPeekHeight(height / 2);
            }

        } else {
            if (!GooglemapApp.this.isFinishing()) {
                new AlertDialog.Builder(GooglemapApp.this, R.style.AlertDialogTheme)
                        .setTitle("Please login.")
                        .setMessage("You need to login to complete your order.")
                        .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Intent o = new Intent(GooglemapApp
                                        .this, ServiceOffer.class);
                                startActivity(o);
                                finish();
                                overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        }
    }

    private void checkAddress(final int from) {
        StringRequest eventoReq = new StringRequest(com.android.volley.Request.Method.POST, Config_URL.GET_SAVED_ADDRESS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.w("kk", response);
                        JSONObject jsonObj = null;
                        try {
                            jsonObj = new JSONObject(response);
                            JSONArray login = jsonObj.getJSONArray("saved");
                            for (int i = 0; i < login.length(); i++) {
                                JSONObject c = login.getJSONObject(i);
                                if (!c.isNull("Address")) {
                                    _houseno = c.getString("HouseNo");
                                    _landmark = c.getString("LandMark");
                                    _zip = c.getString("Zip");
                                    place_home_saved.setText(c.getString("Address"));
                                    place_work_saved.setText(_houseno);
                                    place_other_saved.setText(_landmark);
                                    place_zip_saved.setText(_zip);
                                    _address = c.getString("Address") + "| " + _houseno + "| " + _landmark + "| " + _zip;

                                } else {
                                    viewPager.setCurrentItem(2);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                vollyError(error);
            }

        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("mobile", _phoneNo);
                params.put("from", String.valueOf(from));
                return params;
            }

        };

        // Añade la peticion a la cola
        AppController.getInstance().addToRequestQueue(eventoReq);

    }

    private void vollyError(VolleyError error) {
        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Network is unreachable. Please try another time", Snackbar.LENGTH_LONG)
                    .setAction("Refresh", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());
                        }
                    });
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        } else if (error instanceof AuthFailureError) {
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Network is unreachable. Please try another time", Snackbar.LENGTH_LONG)
                    .setAction("Refresh", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());
                        }
                    });
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        } else if (error instanceof ServerError) {
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Server Error.Please try another time", Snackbar.LENGTH_LONG)
                    .setAction("Refresh", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());
                        }
                    });
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        } else if (error instanceof NetworkError) {
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Network Error. Please try another time", Snackbar.LENGTH_LONG)
                    .setAction("Refresh", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());
                        }
                    });
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        } else if (error instanceof ParseError) {
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Data Error. Please try another time", Snackbar.LENGTH_LONG)
                    .setAction("Refresh", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());
                        }
                    });
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        }


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {


            case R.id.myLocationCustomButton:
                drag = false;
                clicK = false;
                first = false;
                startLocationUpdat();
                Myloc(My_lat, My_long);
                break;

            case R.id.call_driver:
                if (pref.getDriverPhone() != null) {
                    String phn = getLastTen(pref.getDriverPhone());
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phn));
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                break;


            case R.id.ride_cancel_saved:

                if (viewPager.getCurrentItem() == 1) {
                    viewPager.setCurrentItem(0);
                }
                break;

            case R.id.ride_cancel:

                if (viewPager.getCurrentItem() == 2) {
                    viewPager.setCurrentItem(0);
                }
                break;

            case R.id.ride_now:

                if (_phoneNo != null) {
                    if (!TextUtils.isEmpty(Home.getText().toString())) {
                        Ride_now.setEnabled(false);

                        go(Home.getText().toString(), Work.getText().toString(),
                                Other.getText().toString(), place_zip.getText().toString());
                    } else {
                        if (TextUtils.isEmpty(Home.getText().toString())) {
                            //  My_address.setError("Address Missing");
                            Home.setError("Address Missing");
                        } else {
                            if (TextUtils.isEmpty(Work.getText().toString())) {
                                Work.setError("Please input House.Flat No");
                            } else {
                                if (TextUtils.isEmpty(Work.getText().toString())) {
                                    Other.setError("Please input a Landmark");
                                } else {
                                    go(Home.getText().toString(), Work.getText().toString(),
                                            Other.getText().toString(), place_zip.getText().toString());
                                }
                            }

                        }
                    }
                } else {
                    Intent o = new Intent(GooglemapApp.this, ServiceOffer.class);
                    startActivity(o);
                    finish();
                    overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                }


                break;


            case R.id.ride_now_saved:

                if (!TextUtils.isEmpty(Home.getText().toString())) {
                    ride_now_saved.setEnabled(false);
                    go(Home.getText().toString(), Work.getText().toString(),
                            Other.getText().toString(), place_zip_saved.getText().toString());
                } else {
                    if (TextUtils.isEmpty(Home.getText().toString())) {
                        // My_address.setError("Address Missing");
                        Home.setError("Address Missing");
                    } else {
                        if (TextUtils.isEmpty(Work.getText().toString())) {
                            Work.setError("Please input House.Flat No");
                        } else {
                            if (TextUtils.isEmpty(Work.getText().toString())) {
                                Other.setError("Please input a Landmark");
                            } else {
                                go(Home.getText().toString(), Work.getText().toString(),
                                        Other.getText().toString(), place_zip_saved.getText().toString());
                            }
                        }

                    }
                }


                break;

            case R.id.del_address:
                List<com.google.android.libraries.places.api.model.Place.Field> placeFields = Arrays.asList(com.google.android.libraries.places.api.model.Place.Field.ID, com.google.android.libraries.places.api.model.Place.Field.NAME, com.google.android.libraries.places.api.model.Place.Field.ADDRESS
                        , com.google.android.libraries.places.api.model.Place.Field.LAT_LNG);

// Start the autocomplete intent.
                Intent intent = new Autocomplete.IntentBuilder(
                        AutocompleteActivityMode.OVERLAY, placeFields)
                        .build(this);
                startActivityForResult(intent, REQUEST_PICK_FROM);

                break;


            case R.id._cancel_book:
                if (!GooglemapApp.this.isFinishing()) {
                    new AlertDialog.Builder(GooglemapApp.this, R.style.AlertDialogTheme)
                            .setIcon(R.mipmap.ic_launcher)
                            .setTitle("Are you sure?")
                            .setMessage("Press Ok to cancel your order")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    pref.set_food_items(0);
                                    pref.set_food_money(0);
                                    pref.setPref1(0);
                                    pref.setPref2(0);
                                    pref.setPref3(null);
                                    pref.setPref4(null);
                                    pref.setTotal(null);
                                    pref.setTotal2(null);
                                    pref.packagesharedPreferences(null);
                                    pref.setDelivery(0);
                                    if (j == 0) {
                                        Intent i = new Intent(GooglemapApp.this, Canteen_Mainactivity.class);
                                        i.putExtra("my_lat", My_lat);
                                        i.putExtra("my_long", My_long);
                                        startActivity(i);
                                        finish();
                                        overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                                    } else {
                                        Intent i = new Intent(GooglemapApp.this, GooglemapApp.class);
                                        i.putExtra("my_lat", My_lat);
                                        i.putExtra("my_long", My_long);
                                        startActivity(i);
                                        overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                                    }
                                    dialog.cancel();
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }


                break;


            case R.id._confirm_book:
                if (pref.get_food_money() > pref.getMinimumOrder()) {
                    if (pref.getSavedAddress() == 0) {
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(1);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Order value is less than minimum value of R " + pref.getMinimumOrder(), Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.cancelorder:
                openEditor();
                break;
            default:
                break;
        }


    }

    private void openEditor() {
        if (!GooglemapApp.this.isFinishing()) {
            AlertDialog.Builder alertbox = new AlertDialog.Builder(this);

            LinearLayout ll_alert_layout = new LinearLayout(this);
            ll_alert_layout.setOrientation(LinearLayout.VERTICAL);
            final EditText ed_input = new EditText(this);
            ll_alert_layout.addView(ed_input);

            alertbox.setTitle("Reason for cancellation");

            ed_input.setHint("Type here....");
            //setting linear layout to alert dialog

            alertbox.setView(ll_alert_layout);

            alertbox.setNegativeButton("CANCEL",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface arg0, int arg1) {

                            arg0.cancel();

                        }
                    });


            alertbox.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {

                        public void onClick(final DialogInterface arg0, int arg1) {
                            new Delete_Ride_Completely().execute(ed_input.getText().toString());
                        }
                    });
            alertbox.show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PICK_FROM) {
            if (resultCode == RESULT_OK) {

                Place place = Autocomplete.getPlaceFromIntent(data);

                if (!TextUtils.isEmpty(place.getAddress())) {
                    My_address.setText(place.getAddress());
                    LatLng queriedLocation = place.getLatLng();
                    if (queriedLocation != null) {
                        My_lat = queriedLocation.latitude;
                        My_long = queriedLocation.longitude;
                        pref.setDropLat(String.valueOf(My_lat));
                        pref.setDropLong(String.valueOf(My_long));
                    }

                    pref.setDropAt1(My_address.getText().toString());
                    pref.setDropLat1(String.valueOf(My_lat));
                    pref.setDropLong1(String.valueOf(My_long));
                    getCompleteAddressString(My_lat, My_long);
                }
                Log.i("TAG", "Place: " + place.getName() + ", " + place.getId());
            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                // TODO: Handle the error.
                Status status = Autocomplete.getStatusFromIntent(data);
            }  // The user canceled the operation.

        }
    }

    private void go(String s1, String s2, String s3, String s4) {
        if (s3 == null) {
            s3 = "";
        }
        pref.setDropAt1("House No: " + s2 + "| " + s1 + "| " + "| " + s3 + "| " + s4);
        _address = "House No: " + s2 + "| " + s1 + "| " + "| " + s3 + "| " + s4;
        upload();
    }

    private void upload() {
        if (OTP == null) {
            List<String> TotalDays = new ArrayList<String>();
            if (pref.get_packagesharedPreferences() != null) {
                Set<String> set = pref.get_packagesharedPreferences();
                TotalDays.addAll(set);
            }
            commaSeparatedValues = TextUtils.join(",", TotalDays);
            progressBar.setVisibility(View.VISIBLE);

            if (_houseno == null) {

                _houseno = "";
            }
            if (_landmark == null) {
                _landmark = "";
            }

            StringRequest eventoReq = new StringRequest(com.android.volley.Request.Method.POST, Config_URL.URL_FOOD_BOOKING,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Log.e("volley", "volley");


                            String[] pars = response.split("error");
                            if (pars[1].contains("false")) {
                                StringRequest eventoReq = new StringRequest(com.android.volley.Request.Method.POST, Config_URL.USER_BOOKING_RIDE,
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {

                                                Log.e("volley", response);


                                                try {
                                                    String[] pars = response.split("error");
                                                    if (pars[1].contains("false")) {
                                                        String[] pars_ = pars[1].split("false,");
                                                        JSONObject jObj = new JSONObject("{".concat(pars_[1]));
                                                        JSONObject user = jObj.getJSONObject("user");
                                                        pref.setUniqueRide(user.getString("unique_id"));
                                                        OTP = String.valueOf(user.getInt("OTP"));
                                                        progressBar.setVisibility(View.GONE);
                                                        if (_homechecked != 0) {
                                                            pref.setSavedAddress(_homechecked);
                                                        }
                                                        if (pref.getUniqueRide() != null) {
                                                            String[] pars1 = pref.getUniqueRide().split("\\.");
                                                            String con = TextUtils.join("", pars1);
                                                            pref.setCon(con);

                                                            if (OTP != null) {
                                                                pref.set_ride(0);
                                                                pref.setOrder(String.valueOf(OTP));
                                                                mDatabase = FirebaseDatabase.getInstance().getReference();
                                                                mDatabase.child("Meat").child(con).child("con").setValue(pref.getCon());
                                                                mDatabase.child("Meat").child(con).child("UserMobile").setValue(_phoneNo);
                                                                mDatabase.child("Meat").child(con).child("OTP").setValue(OTP);
                                                                mDatabase.child("Meat").child(con).child("From_Address").setValue(_address);
                                                                mDatabase.child("Meat").child(con).child("Book_To_Latitude").setValue(pref.getDropLat());
                                                                mDatabase.child("Meat").child(con).child("Book_To_Longitude").setValue(pref.getDropLong());
                                                                mDatabase.child("Meat").child(con).child("Cost").setValue(_total);
                                                                mDatabase.child("Meat").child(con).child("Order").setValue(commaSeparatedValues);
                                                                pref.setDelivery(1);
                                                                Intent i = new Intent(GooglemapApp.this, SelectePaymentOption.class);
                                                                startActivity(i);
                                                                finish();
                                                                overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                                                            }
                                                        }
                                                    } else {
                                                        pref.setUniqueRide(null);
                                                        if (!GooglemapApp.this.isFinishing()) {
                                                            new AlertDialog.Builder(GooglemapApp.this, R.style.AlertDialogTheme)
                                                                    .setTitle("Failed to create request!")
                                                                    .setIcon(R.mipmap.ic_launcher)
                                                                    .setMessage("Please order another time")
                                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            recreate();
                                                                            dialog.cancel();
                                                                        }
                                                                    })
                                                                    .show();
                                                        }
                                                    }
                                                } catch (final JSONException e) {
                                                    Log.e("HI", "Json parsing error: " + e.getMessage());


                                                }

                                            }
                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        vollyerror(error);


                                    }

                                }) {
                                    @Override
                                    protected Map<String, String> getParams() {
                                        Map<String, String> params = new HashMap<String, String>();
                                        params.put("mobile", _phoneNo);
                                        params.put("total", _total);
                                        params.put("address", _address);
                                        params.put("houseno", _houseno);
                                        params.put("landmark", _landmark);
                                        params.put("area", _Locality);
                                        params.put("zip", _zip);
                                        params.put("from_lat", String.valueOf(My_lat));
                                        params.put("from_long", String.valueOf(My_long));
                                        params.put("distance", String.valueOf(Distance));
                                        params.put("checked", String.valueOf(_homechecked));
                                        params.put("IP", mobileIp);
                                        return params;
                                    }

                                };
                                AppController.getInstance().addToRequestQueue(eventoReq);


                            } else {
                                progressBar.setVisibility(View.GONE);
                                Snackbar.make(getWindow().getDecorView().getRootView(), "Update failed!Please try again.", Snackbar.LENGTH_LONG).show();

                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    vollyerror(error);

                }

            }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("mobile", _phoneNo);
                    params.put("ID", String.valueOf(myID));
                    params.put("data", commaSeparatedValues);
                    params.put("total", _total);
                    params.put("gross", _tAmount.getText().toString());
                    params.put("del", _delAmount.getText().toString());
                    params.put("package", "");
                    params.put("discount", _discount.getText().toString());
                    return params;
                }

            };
            AppController.getInstance().addToRequestQueue(eventoReq);
        }

    }

    private void vollyerror(VolleyError error) {
        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            Ride_now.setEnabled(true);
            ride_now_saved.setEnabled(true);
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Network is unreachable. Please try another time", Snackbar.LENGTH_LONG)
                    .setAction("Refresh", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            recreate();
                        }
                    });
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        } else if (error instanceof AuthFailureError) {
            Ride_now.setEnabled(true);
            ride_now_saved.setEnabled(true);
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Network is unreachable. Please try another time", Snackbar.LENGTH_LONG)
                    .setAction("Refresh", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            recreate();
                        }
                    });
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        } else if (error instanceof ServerError) {
            Ride_now.setEnabled(true);
            ride_now_saved.setEnabled(true);
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Server Error.Please try another time", Snackbar.LENGTH_LONG)
                    .setAction("Refresh", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            recreate();
                        }
                    });
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        } else if (error instanceof NetworkError) {
            Ride_now.setEnabled(true);
            ride_now_saved.setEnabled(true);
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Network Error. Please try another time", Snackbar.LENGTH_LONG)
                    .setAction("Refresh", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            recreate();
                        }
                    });
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        } else if (error instanceof ParseError) {
            Ride_now.setEnabled(true);
            ride_now_saved.setEnabled(true);
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Data Error. Please try another time", Snackbar.LENGTH_LONG)
                    .setAction("Refresh", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            recreate();
                        }
                    });
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        }
    }

    public String getLastTen(String str) {

        return str.length() <= 10 ? str : str.substring(str.length() - 10);
    }

    @Override
    public void onConnectionSuspended(int cause) {
        googleApiClientConnectionStateChange(false);
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        if (mResolvingError) {

        } else if (result.hasResolution()) {
            try {
                mResolvingError = true;
                result.startResolutionForResult(this, REQUEST_RESOLVE_ERROR);
            } catch (IntentSender.SendIntentException e) {
                mGoogleApiClient.connect();
            }
        } else {
            // showErrorDialog(result.getErrorCode());
            mResolvingError = true;
        }
    }

    public void onDialogDismissed() {
        mResolvingError = false;
    }

    private void stopLocationUpdates() {
        if (!mRequestingLocationUpdates) {
            Log.d(TAG, "stopLocationUpdates: updates never requested, no-op.");
            return;
        }

        mFusedLocationClient.removeLocationUpdates(mLocationCallback)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        mRequestingLocationUpdates = false;

                    }
                });
    }

    private void buildLocationSettingsRequest() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);

    }

    protected synchronized void rebuildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, 0, this)
                .addConnectionCallbacks(this /* ConnectionCallbacks */)
                .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(ConnectionResult connectionResult) {
                        googleApiClientConnectionStateChange(true);
                    }
                })


                .addApi(LocationServices.API)
                .build();

    }

    private void googleApiClientConnectionStateChange(final boolean connected) {
        final Context appContext = this.getApplicationContext();

    }

    @Override
    protected void onStart() {
        super.onStart();
        stoped = false;

    }

    @Override
    protected void onStop() {
        super.onStop();
        stoped = true;
        stopLocationUpdates();

        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        if (pref.getUniqueRide() != null && _firebaseLogs != null) {
            String[] pars = pref.getUniqueRide().split("\\.");
            con = TextUtils.join("", pars);
            mDatabase.child("Meat").child(con).removeEventListener(_firebaseLogs);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stoped = true;
        stopLocationUpdates();
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }

        if (pref.getUniqueRide() != null && _firebaseLogs != null) {
            String[] pars = pref.getUniqueRide().split("\\.");
            con = TextUtils.join("", pars);
            mDatabase.child("Meat").child(con).removeEventListener(_firebaseLogs);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stoped = true;
        stopLocationUpdates();
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        if (pref.getUniqueRide() != null && _firebaseLogs != null) {
            String[] pars = pref.getUniqueRide().split("\\.");
            con = TextUtils.join("", pars);
            mDatabase.child("Meat").child(con).removeEventListener(_firebaseLogs);
        }
    }

    public String getLastTwo(String str) {

        return str.length() < 4 ? str : str.substring(0, 4);
    }

    public String getLastThree(String myString) {

        if (myString.length() >= 4)
            return myString.substring(myString.length() - 4);
        else
            return myString;
    }

    private String getCompleteAddressString(double LATITUDE, double LONGITUDE) {

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        String strAdd = "";
        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null && addresses.size() != 0) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder();

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getSubLocality());
                    My_address.setText(returnedAddress.getAddressLine(0));
                    Home.setText(returnedAddress.getAddressLine(0));
                    place_zip.setText(String.valueOf(returnedAddress.getPostalCode()));
                    _address = Home.getText().toString();
                    _zip = place_zip.getText().toString();
                    if (String.valueOf(returnedAddress.getSubThoroughfare()) != null && !TextUtils.isEmpty(String.valueOf(returnedAddress.getSubThoroughfare()))) {
                        Work.setText(String.valueOf(returnedAddress.getSubThoroughfare()));
                        _houseno = String.valueOf(returnedAddress.getSubThoroughfare());
                    }
                    if (String.valueOf(returnedAddress.getThoroughfare()) != null && !TextUtils.isEmpty(String.valueOf(returnedAddress.getThoroughfare()))) {
                        Other.setText(String.valueOf(returnedAddress.getThoroughfare()));
                        _landmark = String.valueOf(returnedAddress.getThoroughfare());
                    }
                    if (String.valueOf(returnedAddress.getLocality()) != null && !TextUtils.isEmpty(String.valueOf(returnedAddress.getLocality()))) {
                        _Locality = String.valueOf(returnedAddress.getLocality());
                    } else if (String.valueOf(returnedAddress.getSubLocality()) != null && !TextUtils.isEmpty(String.valueOf(returnedAddress.getSubLocality()))) {
                        _Locality = String.valueOf(returnedAddress.getSubLocality());
                    } else if (String.valueOf(returnedAddress.getAdminArea()) != null && !TextUtils.isEmpty(String.valueOf(returnedAddress.getAdminArea()))) {
                        _Locality = String.valueOf(returnedAddress.getAdminArea());
                    }

                }
                strAdd = strReturnedAddress.toString();
                Log.w(" address", strReturnedAddress.toString());
            } else {
                strAdd = "Location not identified";
                Log.w(" address", "No Address returned!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            strAdd = "Location not identified";
            Log.w(" loction address", "Canont get Address!");
        }
        return strAdd;
    }

    private boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions() {
        boolean shouldProvideRationale =
                ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.ACCESS_FINE_LOCATION);

        if (shouldProvideRationale) {
            Log.i(TAG, "Displaying permission rationale to provide additional context.");
            showSnackbar(R.string.permission_rationale,
                    android.R.string.ok, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Request permission
                            ActivityCompat.requestPermissions(GooglemapApp.this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    REQUEST_PERMISSIONS_REQUEST_CODE);
                        }
                    });
        } else {
            Log.i(TAG, "Requesting permission");
            ActivityCompat.requestPermissions(GooglemapApp.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    private void showSnackbar(final int mainTextStringId, final int actionStringId,
                              View.OnClickListener listener) {
        Snackbar.make(
                findViewById(android.R.id.content),
                getString(mainTextStringId),
                Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(actionStringId), listener).show();
    }

    @Override
    public void onConnected(Bundle bundle) {
        builder = new LocationSettingsRequest.Builder().addLocationRequest(createLocationRequest());
        Task<LocationSettingsResponse> task = LocationServices.getSettingsClient(this).checkLocationSettings(builder.build());
        task.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
                try {
                    LocationSettingsResponse response = task.getResult(ApiException.class);
                    // All location settings are satisfied. The client can initialize location
                    // requests here.
                    startLocationUpdat();
                } catch (ApiException exception) {
                    switch (exception.getStatusCode()) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            // Location settings are not satisfied. But could be fixed by showing the
                            // user a dialog.
                            try {
                                // Cast to a resolvable exception.
                                ResolvableApiException resolvable = (ResolvableApiException) exception;
                                // Show the dialog by calling startResolutionForResult(),
                                // and check the result in onActivityResult().
                                resolvable.startResolutionForResult(GooglemapApp.this, REQUEST_CHECK_SETTINGS);
                                break;
                            } catch (IntentSender.SendIntentException e) {
                                // Ignore the error.
                            } catch (ClassCastException e) {
                                // Ignore, should be an impossible error.
                                Log.w(" ClassCastException", "Canont get Address!" + e.getLocalizedMessage());
                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            // Location settings are not satisfied. However, we have no way to fix the
                            // settings so we won't show the dialog.

                            break;
                    }
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    startLocationUpdat();

                }
            }
            break;
            case REQUEST_PERMISSIONS_REQUEST_CODE: {
                if (grantResults.length <= 0) {
                    // If user interaction was interrupted, the permission request is cancelled and you
                    // receive empty arrays.
                    Log.i(TAG, "User interaction was cancelled.");
                } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    startLocationUpdat();


                } else {
                    showSnackbar(R.string.permission_denied_explanation,
                            R.string.settings, new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    // Build intent that displays the App settings screen.
                                    Intent intent = new Intent();
                                    intent.setAction(
                                            Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri = Uri.fromParts("package",
                                            BuildConfig.APPLICATION_ID, null);
                                    intent.setData(uri);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                }
                            });
                }
            }
            break;
        }


    }

    protected LocationRequest createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(2000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return mLocationRequest;
    }

    private void createLocationCallback() {
        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                mCurrentLocation = locationResult.getLastLocation();
                updateLocationUI(mCurrentLocation);
            }
        };
    }

    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            layoutBottomSheet.setVisibility(View.VISIBLE);
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            sheetBehavior.setHideable(false);
            CenterMarker.setVisibility(View.GONE);

        }
        if (get1 && !drawn1) {
            drawn1 = true;
            AllRl.setVisibility(View.GONE);
            _L2.setVisibility(View.GONE);
            orderaccepted.setChecked(true);
            _searchText.setText("Your order has been accepted.");

        }

        if (get2 && !drawn2) {
            drawn2 = true;
            AllRl.setVisibility(View.GONE);
            _L2.setVisibility(View.GONE);
            orderaccepted.setChecked(true);
            confirmorder.setChecked(true);
            _searchText.setText("Your order has been confirmed.");
        }

        if (get3 && !drawn3) {
            drawn2 = true;
            AllRl.setVisibility(View.GONE);
            _L2.setVisibility(View.GONE);
            orderaccepted.setChecked(true);
            confirmorder.setChecked(true);
            Order_in_Progress.setChecked(true);
            _searchText.setText("Estimated delivery time updated.");
        }

        if (get4 && !drawn4) {
            drawn4 = true;
            ontheway.setChecked(true);
            comming.setChecked(false);
            orderaccepted.setChecked(true);
            confirmorder.setChecked(true);
            Order_in_Progress.setChecked(true);
            _searchText.setText("Your order has been dispatched!");
            _L2.setVisibility(View.GONE);
            AllRl.setVisibility(View.VISIBLE);
        }


        if (get5 && !drawn5) {
            drawn5 = true;
            // CustomNotification("Order Accepted", "Estimated time of delivery "+ ETR);
            CustomNotification("Order arriving", "Your order is at doorstep ");
            _searchText.setText("Knock knock! Order is at doorstep.");
            SearchingLL.setAnimation(animslideU);
            SearchingLL.setVisibility(View.VISIBLE);
            _call_track_ll.setVisibility(View.VISIBLE);
            AllRl.setAnimation(animslideU);
            AllRl.setVisibility(View.VISIBLE);
            Ride_otp.setVisibility(View.VISIBLE);
            rideCost.setVisibility(View.VISIBLE);
            _diver_car_image_rl.setVisibility(View.VISIBLE);
            CenterMarker.setVisibility(View.GONE);
            comming.setChecked(true);
            ontheway.setChecked(true);
            orderaccepted.setChecked(true);
            confirmorder.setChecked(true);
            Order_in_Progress.setChecked(true);
            _L2.setVisibility(View.GONE);
        }

        if (go && !drawn2) {
            CustomNotification("Order moving ", "Your order is On the way ");
            orderaccepted.setChecked(false);
            comming.setChecked(false);
            ontheway.setChecked(true);
            _searchText.setText("Your order is on the way.");
            drawn2 = true;
            _call_track_ll.setVisibility(View.VISIBLE);
            AllRl.setAnimation(animslideU);
            AllRl.setVisibility(View.VISIBLE);
            Ride_otp.setVisibility(View.VISIBLE);
            rideCost.setVisibility(View.VISIBLE);
            _diver_car_image_rl.setVisibility(View.VISIBLE);
            CenterMarker.setVisibility(View.GONE);
            _L2.setVisibility(View.GONE);
        }

    }

    public void CustomNotification(String title, String durationo) {
        NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
        notificationUtils.playNotificationSound();
        Intent resultIntent = new Intent(getApplicationContext(), GooglemapApp.class);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        showNotificationMessage(getApplicationContext(), title, durationo, "00:00:00", resultIntent);
    }

    private void showNotificationMessage(Context context, String title, String message, String timeStamp, Intent intent) {
        NotificationUtils notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, timeStamp, intent);
    }

    protected Marker createMarker(LatLng latitude, String mobile) {
        Marker Marker_;
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latitude);
        Marker_ = googleMap.addMarker(markerOptions);
        Marker_.setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_rikshaw));

        Marker_.setDraggable(false);
        Marker_.setTag(mobile);
        Marker_.hideInfoWindow();
        Marker_.setVisible(false);
        return Marker_;
    }

    public String parseDateToETR(String time) {
        String inputPattern = "MM-dd-yyyyhh:mm aa";
        String outputPattern = "dd MMM yy hh:mm aa";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            //e.printStackTrace();
            String inputPattern1 = "MM-dd-yyyy";
            String outputPattern1 = "dd MMM yy";
            SimpleDateFormat inputFormat1 = new SimpleDateFormat(inputPattern1);
            SimpleDateFormat outputFormat1 = new SimpleDateFormat(outputPattern1);

            Date date1 = null;

            try {
                date1 = inputFormat1.parse(time);
                str = outputFormat1.format(date1);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
        return str;
    }

    private void animateCarMove(final Marker anmarker, final LatLng beginLatLng, final LatLng endLatLng) {
        final Handler handler = new Handler();
        final long startTime = SystemClock.uptimeMillis();
        final Interpolator interpolator = new LinearInterpolator();
        float angleDeg1 = (float) (com.google.maps.android.SphericalUtil.computeHeading(beginLatLng, endLatLng));
        anmarker.setRotation(angleDeg1);
        if (pref.getUniqueRide() != null) {
            CameraPosition googlePlex;
            googlePlex = CameraPosition.builder()
                    .target(endLatLng)
                    .zoom(14)
                    .build(); // Crea
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex));
        }
        handler.post(new Runnable() {


            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - startTime;
                float t = interpolator.getInterpolation((float) elapsed / 3000);
                double lat = (endLatLng.latitude - beginLatLng.latitude) * t + beginLatLng.latitude;
                double lngDelta = endLatLng.longitude - beginLatLng.longitude;

                if (Math.abs(lngDelta) > 180) {
                    lngDelta -= Math.signum(lngDelta) * 360;
                }
                double lng = lngDelta * t + beginLatLng.longitude;
                anmarker.setPosition(new LatLng(lat, lng));
                anmarker.setAnchor(0.5f, 0.5f);

                if (t < 1.0) {
                    handler.postDelayed(this, 16);
                } else {
                    animate = false;
                }

            }
        });
    }

    public void sendEmail(String s) {

        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setType("text/plain");
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"inow.ani@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Order cancelled " + s);
        try {
            startActivity(Intent.createChooser(i, "Email us.."));
            finish();
            overridePendingTransition(0, 0);
            startActivity(getIntent());
            overridePendingTransition(0, 0);
        } catch (android.content.ActivityNotFoundException ex) {

            Snackbar snackbar = Snackbar
                    .make(getWindow().getDecorView().getRootView(), "There are no email clients installed.", Snackbar.LENGTH_LONG);
            View sbView = snackbar.getView();
            TextView textView = sbView.findViewById(R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();
        }

    }

    private void Myloc(double mylat, double mylong) {
        if (googleMap != null) {
            CameraPosition googlePlex;
            googlePlex = CameraPosition.builder()
                    .target(new LatLng(mylat, mylong))
                    .zoom(18) // Sets the zoom
                    .build(); // Crea
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(googlePlex));
        }
    }

    private String getDirectionsUrl(LatLng origin, LatLng dest) {

        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        String sensor = "sensor=false";
        String parameters = str_origin + "&" + str_dest + "&" + sensor;
        String output = "json";
        return "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + Config_URL.APIKEY;
    }

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception ", e.toString());
        } finally {
            if (iStream != null) {
                iStream.close();
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return data;
    }

    @Override
    public void onAnimationEnd(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // Animation is repeating
    }

    @Override
    public void onAnimationStart(Animation animation) {
        // Animation started
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean jk = false;
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            overridePendingTransition(R.anim.slide_out2, R.anim.slide_in2);
            jk = true;
        }
        return jk;
    }

    public static class ErrorDialogFragment extends DialogFragment {
        public ErrorDialogFragment() {
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Get the error code and retrieve the appropriate dialog
            int errorCode = this.getArguments().getInt(DIALOG_ERROR);
            return GoogleApiAvailability.getInstance().getErrorDialog(
                    this.getActivity(), errorCode, REQUEST_RESOLVE_ERROR);
        }

        @Override
        public void onDismiss(DialogInterface dialog) {
            dialog.cancel();
        }
    }

    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        public Object instantiateItem(View collection, int position) {

            int resId = 0;
            switch (position) {
                case 0:
                    resId = R.id.LFuck;
                    break;
                case 1:
                    resId = R.id.savedlocation;
                    break;

                case 2:
                    resId = R.id.MFuck;
                    break;

            }
            return findViewById(resId);
        }
    }

    private class Delete_Ride_Completely extends AsyncTask<String, Integer, String> {


        private boolean success;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            return uploadFile(args[0]);
        }

        private String uploadFile(String reason) {
            // TODO Auto-generated method stub
            String res = null;

            try {

                RequestBody requestBody = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("mobile", _phoneNo)
                        .addFormDataPart("unique_id", pref.getUniqueRide())
                        .addFormDataPart("reason", reason)
                        .build();

                Request request = new Request.Builder()
                        .url(Config_URL.DELETE_RIDE_ALL)
                        .post(requestBody)
                        .build();
                OkHttpClient client = new OkHttpClient();
                okhttp3.Response response = client.newCall(request).execute();
                res = response.body().string();
                String[] pars = res.split("error");
                success = pars[1].contains("false");

                Log.e("TAG", "Response : " + res);

                return res;

            } catch (UnknownHostException | UnsupportedEncodingException e) {
                Log.e("TAG", "Error: " + e.getLocalizedMessage());
            } catch (Exception e) {
                Log.e("TAG", "Other Error: " + e.getLocalizedMessage());
            }


            return res;

        }

        protected void onPostExecute(String file_url) {
            if (success) {
                if (pref.getUniqueRide() != null) {
                    ask = false;
                    wait = false;
                    go = false;
                    animate = false;
                    Drop_at = null;
                    String[] pars = pref.getUniqueRide().split("\\.");
                    String con = TextUtils.join("", pars);
                    mDatabase.child(con).removeValue();
                    mDatabase.child("Meat").child(con).removeValue();
                    if (Driver_phone != null) {
                        mDatabase.child("Driver_Online").child(Driver_phone).child("OnRide").setValue("NO");
                        mDatabase.child("Driver_Online").child(Driver_phone).child("Ride").removeValue();

                    }

                    pref.setDelivery(0);
                    mDatabase.child(con).child("ask").removeValue();
                    pref.setDropAt1(null);
                    pref.setPickAt1(null);
                    pref.setPickLat1(null);
                    pref.setPickLong1(null);
                    pref.set_cID(0);
                    pref.set_food_money(0);
                    pref.set_food_items(0);
                    pref.packagesharedPreferences(null);
                    pref.setUniqueRide(null);
                    pref.setCon(null);
                    pref.setTotal(null);
                    pref.setTotal2(null);
                    Intent op = new Intent(GooglemapApp.this, Canteen_Mainactivity.class);
                    op.putExtra("from", 1);
                    startActivity(op);
                    finish();
                    overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                }
            } else {
                Snackbar.make(GooglemapApp.this.getWindow().getDecorView().getRootView(), "Update failed", Snackbar.LENGTH_LONG).show();

            }

        }

    }

    private class FirebaseDataListener_after_ride implements ValueEventListener {

        private String _ask;

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {


            if (pref.getUniqueRide() != null && googleMap != null && !stoped) {
                String[] pars = pref.getUniqueRide().split("\\.");
                con = TextUtils.join("", pars);
                int count = (int) dataSnapshot.getChildrenCount();
                if (count != 0) {
                    User_accept = (String) dataSnapshot.child("UserAccept").getValue();
                    Driver_phone = (String) dataSnapshot.child("UserAccept").getValue();
                    Driver_image = (String) dataSnapshot.child("image").getValue();
                    if (Driver_image != null && pref.getDriverimage() == null) {
                        pref.setDriverimage(Driver_image);
                        Picasso
                                .with(GooglemapApp.this)
                                .load(pref.getDriverimage())
                                .resize(72, 72)
                                .centerInside() // resizes the image to these dimensions (in pixel). does not respect aspect ratio
                                .into(Ride_driver_image);
                    }


                    _ask = (String) dataSnapshot.child("ask").getValue();
                    if (Driver_phone == null && dataSnapshot.child("OTP").getValue() != null && dataSnapshot.child("Cost").getValue() != null) {
                        _rate = (String) dataSnapshot.child("Cost").getValue();
                        OTP = (String) dataSnapshot.child("OTP").getValue();
                        Driver_name = (String) dataSnapshot.child("driverName").getValue();
                        pref.setOrder(OTP);

                        Driver_phone = (String) dataSnapshot.child("DriverMobile").getValue();
                        pref.setDriverPhone(Driver_phone);
                        Vehicle_no = (String) dataSnapshot.child("driverVehicle").getValue();
                        if (dataSnapshot.child("ETR").getValue() != null) {
                            _etr.setVisibility(View.VISIBLE);
                            ETR = (String) dataSnapshot.child("ETR").getValue();
                            ETR = parseDateToETR(ETR);
                            _estimate.setText(ETR);
                        }
                        ask = true;
                        if (Vehicle_no != null) {
                            Ride_car_no1.setText(getLastTwo(Vehicle_no) + "-");
                            Ride_car_no.setText(getLastThree(Vehicle_no));
                        }
                        Ride_driver_name.setText(Driver_name);
                        pref.setDriverName(Driver_name);
                        Ride_otp.setText("ORDER ID: " + OTP);
                        rideCost.setVisibility(View.VISIBLE);
                        rideCost.setText("R" + _rate);


                    }
                    if (_ask == null) {
                        toggleBottomSheet();
                        _L2.setVisibility(View.VISIBLE);
                    } else if (_ask.contains("2") && !get1) {
                        get1 = true;
                        toggleBottomSheet();

                    } else if (_ask.contains("3") && !get2) {
                        get2 = true;
                        toggleBottomSheet();

                    } else if (_ask.contains("4") && !get3) {
                        get3 = true;
                        toggleBottomSheet();
                    } else if (_ask.contains("5") && !get4) {
                        get4 = true;
                        toggleBottomSheet();
                        if (dataSnapshot.child("Driver_First_Latitude").getValue() != null &&
                                dataSnapshot.child("Driver_First_Longitude").getValue() != null) {
                            Driver_lat = Double.parseDouble((String) dataSnapshot.child("Driver_First_Latitude").getValue());
                            Driver_long = Double.parseDouble((String) dataSnapshot.child("Driver_First_Longitude").getValue());
                            if (markerCar != null) {
                                if (markerCar.getPosition() != null && SphericalUtil.computeDistanceBetween(markerCar.getPosition(), new LatLng(Driver_lat, Driver_long)) > 10) {
                                    markerCar.showInfoWindow();
                                    animateCarMove(markerCar, markerCar.getPosition(), new LatLng(Driver_lat, Driver_long));
                                } else {
                                    markerCar.setPosition(new LatLng(Driver_lat, Driver_long));
                                    markerCar.setAnchor(0.5f, 0.5f);
                                }
                                markerCar.setVisible(true);
                            }

                        }

                    } else if (_ask.contains("6") && !get5) {
                        mDatabase.child(con).removeEventListener(_firebaseLogs);
                        get5 = true;
                        Intent i = new Intent(GooglemapApp.this, UserSuccess.class);
                        i.putExtra("my_lat", My_lat);
                        i.putExtra("my_long", My_long);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(i);
                        finish();
                        overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);

                    } else if (_ask.contains("7") && !_second) {
                        _second = true;
                        mDatabase.child(con).removeEventListener(_firebaseLogs);
                        pref.setDropAt(null);
                        pref.setDropLong(null);
                        pref.setDropLat(null);
                        pref.setUniqueRide(null);
                        ask = false;
                        wait = false;
                        got = false;
                        go = false;
                        if (!GooglemapApp.this.isFinishing()) {
                            new AlertDialog.Builder(GooglemapApp.this)
                                    .setTitle("Order Cancelled")
                                    .setMessage("Mail to MeatExpress")
                                    .setCancelable(false)
                                    .setPositiveButton("Mail us", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            sendEmail(pref.getCon());
                                            dialog.cancel();
                                        }
                                    })
                                    .setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                            Intent op = new Intent(GooglemapApp.this, Canteen_Mainactivity.class);
                                            op.putExtra("from", 1);
                                            startActivity(op);
                                            finish();
                                            overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                                        }
                                    })
                                    .show();
                        }
                    }
                }
            }

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    }

    private class Get_distance_draw_polyiline extends AsyncTask<String, Void, String> {


        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.e("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            stopLocationUpdates();
            ParserTask parserTask = new ParserTask();
            parserTask.execute(result);
        }
    }

    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        private String duration;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            if (result != null) {
                ArrayList<LatLng> points = new ArrayList<LatLng>();

                Random rand = new Random();


                for (int i = 0; i < result.size(); i++) {
                    points.clear();

                    List<HashMap<String, String>> path = result.get(i);
                    for (int j = 0; j < path.size(); j++) {
                        HashMap<String, String> point = path.get(j);

                        if (j == 0) {
                            String pars = point.get("distance");
                            Log.w("Distance", pars);
                            String[] pars1 = pars.split(" ");
                            if (pref.getDropAt() != null) {
                                String[] pars2 = new String[0];
                                if (pars1[0].contains(".")) {
                                    pars2 = pars1[0].split("\\.");
                                    Distance = Double.parseDouble(pars2[0]);
                                } else if (pars1[0].contains(",")) {
                                    pars2 = pars1[0].split(",");
                                    Distance = Double.parseDouble(pars2[0]);
                                } else {
                                    Distance = Double.parseDouble(pars1[0]);
                                }

                            }
                            continue;
                        } else if (j == 1) {
                            duration = point.get("duration");
                            if (markerCar != null) {
                                markerCar.setTitle(duration);
                                markerCar.showInfoWindow();
                            }

                            continue;
                        }

                        double lat = Double.parseDouble(point.get("lat"));
                        double lng = Double.parseDouble(point.get("lng"));
                        LatLng position = new LatLng(lat, lng);
                        points.add(position);


                    }


                }

                if (!GooglemapApp.this.isFinishing() && (mProgressDialog != null)) {
                    if (mProgressDialog.isShowing()) {
                        mProgressDialog.dismiss();
                    }
                }
                if (points != null && points.size() != 0) {
                    PolylineOptions lineOptions = new PolylineOptions();
                    lineOptions.addAll(points);
                    lineOptions.width(18);
                    lineOptions.startCap(new SquareCap());
                    lineOptions.endCap(new SquareCap());
                    lineOptions.jointType(ROUND);
                    lineOptions.color(Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                    if (googleMap != null) {
                        polylineFinal = googleMap.addPolyline(lineOptions);
                        LatLngBounds.Builder builder1 = new LatLngBounds.Builder();
                        builder1.include(marker.getPosition());
                        builder1.include(markerd.getPosition());
                        LatLngBounds bounds = builder1.build();
                        int width = getResources().getDisplayMetrics().widthPixels;
                        int height = getResources().getDisplayMetrics().heightPixels;

                        int padding = (int) (width * 0.20); // offset from edges of the map 10% of screen
                        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);
                        googleMap.moveCamera(cu);
                        viewPager.setCurrentItem(0);
                    }
                }


            }
        }
    }

}
