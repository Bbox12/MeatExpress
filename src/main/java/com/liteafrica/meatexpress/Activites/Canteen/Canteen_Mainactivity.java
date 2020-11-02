package com.liteafrica.meatexpress.Activites.Canteen;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.liteafrica.meatexpress.Activites.Main_Page.GooglemapApp;
import com.liteafrica.meatexpress.Activites.Main_Page.UserSuccess;
import com.liteafrica.meatexpress.Activites.Main_Page.Wb1_access;
import com.liteafrica.meatexpress.Activites.Refer_and_Earn_page;
import com.liteafrica.meatexpress.Activites.Ride_Later.ContactUs;
import com.liteafrica.meatexpress.Activites.Ride_Later.PastRides;
import com.liteafrica.meatexpress.Activites.Ride_Later.Ride_later_tabs;
import com.liteafrica.meatexpress.Activites.Splash_screen;
import com.liteafrica.meatexpress.Activites.Update_profile;
import com.liteafrica.meatexpress.Adapters.AdvertiseAdapter;
import com.liteafrica.meatexpress.Adapters.CanteenAdapter;
import com.liteafrica.meatexpress.Adapters.Image_Adapter;
import com.liteafrica.meatexpress.Adapters.RecyclerTouchListener;
import com.liteafrica.meatexpress.Adapters.SelfieAdapter;
import com.liteafrica.meatexpress.AppController;
import com.liteafrica.meatexpress.Config_URL;
import com.liteafrica.meatexpress.FCM.NotificationUtils;
import com.liteafrica.meatexpress.Login.ServiceOffer;
import com.liteafrica.meatexpress.LruBitmapCache;
import com.liteafrica.meatexpress.Model.Eats;
import com.liteafrica.meatexpress.PrefManager;
import com.liteafrica.meatexpress.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Canteen_Mainactivity extends AppCompatActivity implements View.OnClickListener {

    private static final LatLngBounds BOUNDS_MOUNTAIN_VIEW = new LatLngBounds(
            new LatLng(25.00000, 91.00000), new LatLng(27.99999, 91.99999));
    private static final int REQUEST_PICK_FROM = 10016;
    private static final int RECOVERY_DIALOG_REQUEST = 203;
    private PrefManager pref;
    private boolean mResolvingError = false;
    private double My_lat = 0, My_long = 0;
    private String _phoneNo;
    private CoordinatorLayout coordinatorLayout;
    private RecyclerView viewPager;
    private ArrayList<Eats> ImagesArray = new ArrayList<Eats>();
    private ArrayList<Eats> CanteenArray = new ArrayList<Eats>();
    private ArrayList<Eats> MenuArray = new ArrayList<Eats>();
    private int currentPage = 0;
    private TextView[] dots;
    private int _palce = 0;
    private RecyclerView _moreRv, _imageRV;
    private NestedScrollView Nscroll;
    private boolean _time = false;
    private ArrayList<String> AdArray = new ArrayList<String>();
    private WebView webView;
    private Handler handler1;
    private Runnable p;
    private ShimmerFrameLayout mShimmerViewContainer;
    private AdvertiseAdapter sAdapter2;
    private LinearLayout L1;
    private TextView orders, _address;
    private ImageView _i4;
    private NestedScrollView scroller;
    private ImageView youtubeCard, whatsappCard, _facebookfeed, twitterfeeds, instagramFeed;
    private ImageView _drawer;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private View navHeader;
    private TextView txtName;
    private NetworkImageView profile_image;
    private Toolbar toolbar;
    private String con;
    private DatabaseReference mDatabase;
    private boolean drawn = false;
    private boolean drawn1 = false;
    private boolean drawn2 = false;
    private boolean drawn3 = false;
    private boolean drawn4 = false;
    private String _name;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RelativeLayout _C1, _C2, _C3, _C4;
    private NetworkImageView _sc1, _sc2, _sc3, _sc4;
    private ImageLoader imageLoader;
    private TextView _nc1, _nc2, _nc3, _nc4;
    private int _dealMobile1, _dealMobile2, _dealMobile3, _dealMobile4;
    private ImageView _arrow;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Image_Adapter sAdapter1;
    private boolean drawn5;

    public static boolean isTV(Context context) {
        return ((UiModeManager) context
                .getSystemService(Context.UI_MODE_SERVICE))
                .getCurrentModeType() == Configuration.UI_MODE_TYPE_TELEVISION;
    }

    public static int getScreenOrientation(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels <
                context.getResources().getDisplayMetrics().heightPixels ?
                Configuration.ORIENTATION_PORTRAIT : Configuration.ORIENTATION_LANDSCAPE;
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.tez_eats_main_layout);
        drawer = findViewById(R.id.drawer_layout_main);
        navigationView = findViewById(R.id.nav_view);
        navHeader = navigationView.getHeaderView(0);
        txtName = navHeader.findViewById(R.id.name_profile);
        profile_image = navHeader.findViewById(R.id.img_profile);
        mSwipeRefreshLayout = findViewById(R.id.swipeToRefresh);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);

        toolbar = findViewById(R.id.toolbardd);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpNavigationView();
        pref = new PrefManager(getApplicationContext());
        HashMap<String, String> user = pref.getUserDetails();
        _phoneNo = user.get(PrefManager.KEY_MOBILE);
        _name = user.get(PrefManager.KEY_NAME);
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        mShimmerViewContainer.setVisibility(View.VISIBLE);
        mShimmerViewContainer.startShimmerAnimation();
        L1 = findViewById(R.id._l1);
        L1.setVisibility(View.GONE);
        _moreRv = findViewById(R.id.moreRv);
        _moreRv.setNestedScrollingEnabled(false);

        _imageRV = findViewById(R.id.imageRV);
        _imageRV.setNestedScrollingEnabled(false);
        coordinatorLayout = findViewById(R.id
                .cor_home_eats);

        _i4 = findViewById(R.id._i4);
        _i4.setOnClickListener(this);
        orders = findViewById(R.id.orders);
        _address = findViewById(R.id.address);
        if (pref.getDropAt() != null) {
            _address.setText(pref.getDropAt());
        }

        Nscroll = findViewById(R.id.Nscroll);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setVisibility(View.VISIBLE);
        Nscroll.setSmoothScrollingEnabled(true);

        _C1 = findViewById(R.id._c1);
        _C2 = findViewById(R.id._c2);
        _C3 = findViewById(R.id._c3);
        _C4 = findViewById(R.id._c4);

        _C1.setOnClickListener(this);
        _C2.setOnClickListener(this);
        _C3.setOnClickListener(this);
        _C4.setOnClickListener(this);

        _sc1 = findViewById(R.id.image_1);
        _sc2 = findViewById(R.id.image_2);
        _sc3 = findViewById(R.id.image_3);
        _sc4 = findViewById(R.id.image_4);

        _nc1 = findViewById(R.id.name_1);
        _nc2 = findViewById(R.id.name_2);
        _nc3 = findViewById(R.id.name_3);
        _nc4 = findViewById(R.id.name_4);

        youtubeCard = findViewById(R.id.youtube1);
        whatsappCard = findViewById(R.id.whatsapp1);
        youtubeCard.setOnClickListener(this);
        whatsappCard.setOnClickListener(this);
        _facebookfeed = findViewById(R.id.facebook1);
        twitterfeeds = findViewById(R.id.twitter1);
        instagramFeed = findViewById(R.id.instagram1);
        instagramFeed.setOnClickListener(this);
        _facebookfeed.setOnClickListener(this);
        twitterfeeds.setOnClickListener(this);


        if (_phoneNo == null) {
            hideItem();
        } else {
            showItem();
        }


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getEats();
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });


    }

    private void hideItem() {
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.logout).setVisible(false);
        nav_Menu.findItem(R.id.login).setVisible(true);
    }

    private void showItem() {
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.logout).setVisible(true);
        nav_Menu.findItem(R.id.login).setVisible(false);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.arrow:
                if (drawer != null) {
                    drawer.openDrawer(Gravity.LEFT);
                }
                break;
            case R.id._c1:
                if (_dealMobile1 != 0) {
                    Intent o = new Intent(Canteen_Mainactivity.this, ProductDetailsPage.class);
                    pref.setPref1(2);
                    pref.setID1(1);
                    pref.setID3(_dealMobile1);
                    startActivity(o);
                    pref.setcName(_nc1.getText().toString());
                    overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                }
                break;
            case R.id._c2:
                if (_dealMobile2 != 0) {
                    Intent o = new Intent(Canteen_Mainactivity.this, ProductDetailsPage.class);
                    pref.setPref1(2);
                    pref.setID1(1);
                    pref.setID3(_dealMobile2);
                    startActivity(o);
                    pref.setcName(_nc2.getText().toString());
                    overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                }
                break;

            case R.id._c3:
                if (_dealMobile3 != 0) {
                    Intent o = new Intent(Canteen_Mainactivity.this, ProductDetailsPage.class);
                    pref.setPref1(2);
                    pref.setID1(1);
                    pref.setID3(_dealMobile3);
                    startActivity(o);
                    pref.setcName(_nc3.getText().toString());
                    overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                }
                break;
            case R.id._c4:
                if (_dealMobile4 != 0) {
                    Intent o = new Intent(Canteen_Mainactivity.this, ProductDetailsPage.class);
                    pref.setPref1(2);
                    pref.setID1(1);
                    pref.setID3(_dealMobile4);
                    startActivity(o);
                    pref.setcName(_nc4.getText().toString());
                    overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                }
                break;
            case R.id.facebook1:
                if (pref.getFacebook() != null) {
                    Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                    String facebookUrl = getFacebookPageURL(this);
                    facebookIntent.setData(Uri.parse(facebookUrl));
                    startActivity(facebookIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "No facebook account found", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.twitter1:
                open_social_network("com.twitter.android", "https://twitter.com/Official_MissSA");
                break;


            case R.id.whatsapp1:
                open_whatsapp();
                break;

            case R.id.instagram1:
                if (pref.getInstagram() != null) {
                    Uri uri = Uri.parse(pref.getInstagram());
                    Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                    likeIng.setPackage("com.instagram.android");

                    try {
                        startActivity(likeIng);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse(pref.getInstagram())));
                    }
                }


                break;

            case R.id._i4: {
                if (_phoneNo != null) {
                    if (pref.get_food_items() != 0) {
                        pref.set_cID1(1);
                        Intent o = new Intent(Canteen_Mainactivity.this, GooglemapApp.class);
                        pref.set_ride(3);
                        startActivity(o);
                        overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                    } else {
                        if (!Canteen_Mainactivity.this.isFinishing()) {
                            new AlertDialog.Builder(Canteen_Mainactivity.this, R.style.AlertDialogTheme)
                                    .setTitle("Your cart is empty")
                                    .setMessage("Please add items to your cart.")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
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
                    }
                } else {
                    if (!Canteen_Mainactivity.this.isFinishing()) {
                        new AlertDialog.Builder(Canteen_Mainactivity.this, R.style.AlertDialogTheme)
                                .setTitle("Please login.")
                                .setMessage("You need to login to complete your order.")
                                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                        Intent o = new Intent(Canteen_Mainactivity.this, ServiceOffer.class);
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
            break;

        }
    }

    public String getFacebookPageURL(Context context) {
        final String url1 = pref.getFacebook();
        String FACEBOOK_PAGE_ID = "MeatExpress";
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + url1;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return url1; //normal web url
        }
    }

    private void open_social_network(String _package, String _handle) {
        Intent intent4 = new Intent();
        intent4.setType("text/plain");
        intent4.setAction(Intent.ACTION_SEND);
        final PackageManager packageManager = getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent4, PackageManager.MATCH_DEFAULT_ONLY);

        for (ResolveInfo resolveInfo : list) {
            String packageName = resolveInfo.activityInfo.packageName;

            //In case that the app is installed, lunch it.
            if (packageName != null && packageName.equals(_package)) {
                try {
                    Intent browseTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse(_handle));
                    startActivity(browseTwitter);

                    return;
                } catch (Exception ignored) {

                }
            }
        }

        //If it gets here it means that the twitter app is not installed. Therefor, lunch the browser.
        try {
            Intent browseTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse(_handle));
            startActivity(browseTwitter);
        } catch (Exception ignored) {

        }
    }

    private void open_whatsapp() {
        PackageManager packageManager = getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);

        try {
            String url = "https://api.whatsapp.com/send?phone=" + pref.getWhatsApp() + "&text=" + URLEncoder.encode("HI MeatExpress", "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                startActivity(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        viewPager.invalidate();
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        mShimmerViewContainer.stopShimmerAnimation();
        viewPager.invalidate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mShimmerViewContainer.stopShimmerAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getEats();


        orders.setText(String.valueOf(pref.get_food_items()));

        if (pref.getProfile() != null) {
            if (_name != null) {
                txtName.setText(_name);
            }

            String url = pref.getProfile().replaceAll(" ", "%20");
            ImageLoader imageLoader = LruBitmapCache.getInstance(Canteen_Mainactivity.this)
                    .getImageLoader();
            imageLoader.get(url, ImageLoader.getImageListener(profile_image,
                    R.drawable.com_facebook_profile_picture_blank_portrait, R.drawable
                            .com_facebook_profile_picture_blank_portrait));
            profile_image.setImageUrl(url, imageLoader);
        } else {
            String url = "http://139.59.38.160/Meat/logo.png".replaceAll(" ", "%20");
            ImageLoader imageLoader = LruBitmapCache.getInstance(Canteen_Mainactivity.this)
                    .getImageLoader();
            imageLoader.get(url, ImageLoader.getImageListener(profile_image,
                    R.drawable.com_facebook_profile_picture_blank_portrait, R.drawable
                            .com_facebook_profile_picture_blank_portrait));
            profile_image.setImageUrl(url, imageLoader);
        }

        if (pref.getUniqueRide() != null) {
            if (pref.getPayment() == 0) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Payment not select. Please select payment option.", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Checkout", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i = new Intent(Canteen_Mainactivity.this, SelectePaymentOption.class);
                                startActivity(i);
                                finish();
                                overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                            }
                        });
                snackbar.setActionTextColor(Color.RED);
                snackbar.show();
            } else {
                String[] pars = pref.getUniqueRide().split("\\.");
                con = TextUtils.join("", pars);
                mDatabase.child("Meat").child(con).addValueEventListener(new FirebaseDataListener_after_ride());

            }
        }

    }

    private void CustomNotification2(String congratulations, String s) {
        if (pref.getResposibility() == 1) {
            String[] pars = pref.getUniqueRide().split("\\.");
            con = TextUtils.join("", pars);
            mDatabase.child("Meat").child(con).child("pchanged").removeValue();
            NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
            notificationUtils.playNotificationSound();
            Intent resultIntent = new Intent(getApplicationContext(), GooglemapApp.class);
            pref.set_ride(3);
            resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            showNotificationMessage(getApplicationContext(), congratulations, s, "00:00:00", resultIntent);
        }
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

    private void CustomNotification3(String congratulations, String s) {
        if (pref.getResposibility() == 1) {
            String[] pars = pref.getUniqueRide().split("\\.");
            con = TextUtils.join("", pars);
            NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
            notificationUtils.playNotificationSound();
            Intent resultIntent = new Intent(getApplicationContext(), PastRides.class);
            resultIntent.putExtra("unique", pref.getOrder());
            resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            showNotificationMessage(getApplicationContext(), congratulations, s, "00:00:00", resultIntent);
            launchHomeScreen();
        }
    }

    private void CustomNotification4(String congratulations, String s) {
        if (pref.getResposibility() == 1) {
            String[] pars = pref.getUniqueRide().split("\\.");
            con = TextUtils.join("", pars);
            mDatabase.child("Meat").child(con).child("Verify").setValue(String.valueOf(4));
            NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
            notificationUtils.playNotificationSound();
            Intent resultIntent = new Intent(getApplicationContext(), GooglemapApp.class);
            resultIntent.putExtra("unique", pref.getOrder());
            resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            showNotificationMessage(getApplicationContext(), congratulations, s, "00:00:00", resultIntent);
            launchHomeScreen();
        }
    }

    private void CustomNotification5(String congratulations, String s) {
        if (pref.getResposibility() == 1) {
            NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
            notificationUtils.playNotificationSound();
            Intent resultIntent = new Intent(getApplicationContext(), GooglemapApp.class);
            resultIntent.putExtra("unique", pref.getOrder());
            resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            showNotificationMessage(getApplicationContext(), congratulations, s, "00:00:00", resultIntent);
            launchHomeScreen();
        }
    }

    private void launchHomeScreen() {
        final ArrayList<String> mOrder = new ArrayList<>();
        StringRequest eventoReq = new StringRequest(com.android.volley.Request.Method.POST, Config_URL.GET_DETAILS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        JSONObject jsonObj = null;
                        try {
                            jsonObj = new JSONObject(response);
                            JSONArray Book_Ride_Now = jsonObj.getJSONArray("order");
                            if (Book_Ride_Now.length() != 0) {
                                for (int i = 0; i < Book_Ride_Now.length(); i++) {
                                    JSONObject c = Book_Ride_Now.getJSONObject(i);
                                    if (!c.isNull("order")) {
                                        mOrder.add(c.getString("order"));
                                    }
                                }
                            }
                            if (mOrder.size() > 0) {
                                pref.packagesharedPreferences(mOrder);
                                String order = android.text.TextUtils.join("_", mOrder);
                                String[] pars = pref.getUniqueRide().split("\\.");
                                con = TextUtils.join("", pars);
                                mDatabase.child("Meat").child(con).child("Order").setValue(order);
                                mDatabase.child("Meat").child(con).child("changed").removeValue();
                                pref.set_food_items(mOrder.size());
                            }
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLogerr(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("_mId", _phoneNo);
                params.put("order", pref.getOrder());
                return params;
            }

        };
        eventoReq.setRetryPolicy(new DefaultRetryPolicy(
                3000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(eventoReq);


    }

    private void openEditor(String reason) {
        if (!Canteen_Mainactivity.this.isFinishing()) {
            AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
            alertbox.setCancelable(false);
            LinearLayout ll_alert_layout = new LinearLayout(this);
            ll_alert_layout.setOrientation(LinearLayout.VERTICAL);
            final EditText ed_input = new EditText(this);
            ll_alert_layout.addView(ed_input);

            alertbox.setTitle("Your order is cancelled");

            //setting linear layout to alert dialog

            alertbox.setView(ll_alert_layout);

            if (reason != null) {
                ed_input.setText(reason);
                ed_input.setFocusableInTouchMode(false);
                CustomNotification("Order Cancelled", reason);
            } else {
                ed_input.setText("Inconvinience regretted.");
                ed_input.setFocusableInTouchMode(false);
                CustomNotification("Order Cancelled", "Inconvinience regretted.");
            }


            alertbox.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {

                        public void onClick(final DialogInterface arg0, int arg1) {
                            pref.set_food_items(0);
                            pref.set_food_money(0);
                            pref.packagesharedPreferences(null);
                            pref.setDelivery(0);
                            pref.setTotal(null);
                            pref.setTotal2(null);
                            String[] pars = pref.getUniqueRide().split("\\.");
                            con = TextUtils.join("", pars);
                            pref.setUniqueRide(null);
                            mDatabase.child("Meat").child(con).removeValue();
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());

                        }
                    });
            alertbox.show();
        }
    }

    public void CustomNotification(String title, String durationo) {
        if (pref.getResposibility() == 1) {
            NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
            notificationUtils.playNotificationSound();
            Intent resultIntent = new Intent(getApplicationContext(), GooglemapApp.class);
            pref.set_ride(3);
            resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            showNotificationMessage(getApplicationContext(), title, durationo, "00:00:00", resultIntent);
        }
    }

    private void showNotificationMessage(Context context, String title, String message, String timeStamp, Intent intent) {
        NotificationUtils notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, timeStamp, intent);
    }

    private void getEats() {
        ImagesArray.clear();
        CanteenArray.clear();


        final ArrayList<Eats> mSelfie = new ArrayList<Eats>();
        StringRequest eventoReq = new StringRequest(com.android.volley.Request.Method.POST, Config_URL.GET_MENU,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.w("volley", response);
                        MenuArray.clear();

                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray ads = jsonObj.getJSONArray("ads");
                            JSONArray menu = jsonObj.getJSONArray("menu");
                            JSONArray submenu = jsonObj.getJSONArray("submenu");
                            JSONArray tezads = jsonObj.getJSONArray("tezads");
                            if (ads.length() != 0) {
                                viewPager.setVisibility(View.VISIBLE);
                                for (int i = 0; i < ads.length(); i++) {
                                    JSONObject c = ads.getJSONObject(i);
                                    if (!c.isNull("Photo")) {
                                        Eats item = new Eats();
                                        item.setID(c.getInt("ID"));
                                        item.setName(c.getString("Name"));
                                        item.setDescription(c.getString("Description"));
                                        item.setMRP(c.getDouble("MRP"));
                                        item.setDiscount(c.getDouble("Discount"));
                                        item.setPhoto(c.getString("Photo"));
                                        item.setStock(c.getInt("Unit"));
                                        item.setIsOutOfStock(c.getInt("isOutOfStock"));
                                        item.setPrice(c.getDouble("MRP") - c.getDouble("Discount"));
                                        ImagesArray.add(item);
                                    }

                                }
                            } else {
                                viewPager.setVisibility(View.GONE);
                            }

                            JSONArray selfie = jsonObj.getJSONArray("images");
                            for (int i = 0; i < selfie.length(); i++) {
                                JSONObject c = selfie.getJSONObject(i);
                                if (!c.isNull("Photo")) {
                                    Eats item = new Eats();
                                    item.setPhoto(c.getString("Photo"));
                                    item.setTitle(c.getString("Title"));
                                    item.setDescription(c.getString("Description"));
                                    mSelfie.add(item);
                                }
                            }


                            if (tezads.length() != 0) {
                                for (int i = 0; i < tezads.length(); i++) {
                                    JSONObject c = tezads.getJSONObject(i);
                                    if (!c.isNull("Photo")) {
                                        AdArray.add(c.getString("Photo"));
                                    }

                                }
                            }

                            if (menu.length() != 0) {
                                for (int i = 0; i < menu.length(); i++) {
                                    JSONObject c = menu.getJSONObject(i);
                                    if (!c.isNull("Name")) {
                                        Eats item = new Eats();
                                        item.setID(c.getInt("ID"));
                                        item.setName(c.getString("Name"));
                                        item.setPhoto(c.getString("Photo"));
                                        item.setColors(c.getString("Colors"));
                                        MenuArray.add(item);
                                    }
                                }
                            }

                            if (submenu.length() != 0) {
                                for (int i = 0; i < submenu.length(); i++) {
                                    JSONObject c = submenu.getJSONObject(i);
                                    if (!c.isNull("Name")) {
                                        Eats item = new Eats();
                                        item.setID(c.getInt("ID"));
                                        item.setName(c.getString("Name"));
                                        item.setPhoto(c.getString("Photo"));
                                        CanteenArray.add(item);
                                    }

                                }
                            }

                        } catch (final JSONException e) {
                            Log.e("HI", "Json parsing error: " + e.getMessage());


                        }
                        if (ImagesArray.size() > 0) {
                            viewPager.setVisibility(View.VISIBLE);
                            sAdapter1 = new Image_Adapter(Canteen_Mainactivity.this, ImagesArray);
                            sAdapter1.notifyDataSetChanged();
                            sAdapter1.setPref(pref);
                            sAdapter1.setNos(orders);
                            viewPager.setAdapter(sAdapter1);
                            LinearLayoutManager mLayoutManager = new LinearLayoutManager(Canteen_Mainactivity.this, LinearLayoutManager.HORIZONTAL, false);
                            viewPager.setLayoutManager(mLayoutManager);
                            viewPager.smoothScrollToPosition(sAdapter1.getItemCount());
                            viewPager.setHasFixedSize(true);

                            final Handler handler = new Handler();
                            final Runnable Update = new Runnable() {
                                public void run() {
                                    if (currentPage == ImagesArray.size()) {
                                        currentPage = 0;
                                        viewPager.smoothScrollToPosition(0);
                                    } else {
                                        if (currentPage < ImagesArray.size()) {
                                            viewPager.smoothScrollToPosition(currentPage++);
                                        }
                                    }
                                }
                            };
                            Timer swipeTimer = new Timer();
                            swipeTimer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    handler.post(Update);
                                }
                            }, 3000, 10000);
                        }


                        if (MenuArray.size() >= 2) {

                            if (MenuArray.get(0).getPhoto(0) != null) {
                                String url = MenuArray.get(0).getPhoto(0).replaceAll(" ", "%20");
                                imageLoader = LruBitmapCache.getInstance(Canteen_Mainactivity.this)
                                        .getImageLoader();
                                imageLoader.get(url, ImageLoader.getImageListener(_sc1,
                                        R.mipmap.ic_launcher, R.mipmap
                                                .ic_launcher));
                                _sc1.setImageUrl(url, imageLoader);
                                _nc1.setText(MenuArray.get(0).getName(0));
                                //  _nc1.startAnimation(anim);
                                _nc1.setVisibility(View.VISIBLE);
                                _dealMobile1 = MenuArray.get(0).getID(0);
                                // _nc1.setTextColor(Color.parseColor(MenuArray.get(0).getColors(0)));
                            }

                            if (MenuArray.get(1).getPhoto(1) != null) {
                                String url = MenuArray.get(1).getPhoto(1).replaceAll(" ", "%20");
                                imageLoader = LruBitmapCache.getInstance(Canteen_Mainactivity.this)
                                        .getImageLoader();
                                imageLoader.get(url, ImageLoader.getImageListener(_sc2,
                                        R.mipmap.ic_launcher, R.mipmap
                                                .ic_launcher));
                                _sc2.setImageUrl(url, imageLoader);
                                _nc2.setText(MenuArray.get(1).getName(1));
                                //  _nc2.startAnimation(anim);
                                _nc2.setVisibility(View.VISIBLE);
                                _dealMobile2 = MenuArray.get(1).getID(1);
                                //  _nc2.setTextColor(Color.parseColor(MenuArray.get(1).getColors(1)));
                            }
                        }
                        if (MenuArray.size() >= 3) {
                            if (MenuArray.get(2).getPhoto(2) != null) {
                                String url = MenuArray.get(2).getPhoto(2).replaceAll(" ", "%20");
                                imageLoader = LruBitmapCache.getInstance(Canteen_Mainactivity.this)
                                        .getImageLoader();
                                imageLoader.get(url, ImageLoader.getImageListener(_sc3,
                                        R.mipmap.ic_launcher, R.mipmap
                                                .ic_launcher));
                                _sc3.setImageUrl(url, imageLoader);
                                _nc3.setText(MenuArray.get(2).getName(2));
                                //   _nc3.startAnimation(anim);
                                _nc3.setVisibility(View.VISIBLE);
                                _dealMobile3 = MenuArray.get(2).getID(2);
                                // _nc3.setTextColor(Color.parseColor(MenuArray.get(2).getColors(2)));
                            }
                        } else {
                            _C3.setVisibility(View.GONE);
                            _C4.setVisibility(View.GONE);
                        }
                        if (MenuArray.size() == 4) {
                            _C4.setVisibility(View.VISIBLE);
                            if (MenuArray.get(3).getPhoto(3) != null) {
                                String url = MenuArray.get(3).getPhoto(3).replaceAll(" ", "%20");
                                imageLoader = LruBitmapCache.getInstance(Canteen_Mainactivity.this)
                                        .getImageLoader();
                                imageLoader.get(url, ImageLoader.getImageListener(_sc4,
                                        R.mipmap.ic_launcher, R.mipmap
                                                .ic_launcher));
                                _sc4.setImageUrl(url, imageLoader);
                                _nc4.setText(MenuArray.get(3).getName(3));
                                //  _nc4.startAnimation(anim);
                                _nc4.setVisibility(View.VISIBLE);
                                _dealMobile4 = MenuArray.get(3).getID(3);
                                _nc4.setTextColor(Color.parseColor(MenuArray.get(3).getColors(3)));
                            }
                        } else {
                            _C4.setVisibility(View.GONE);

                        }

                        if (CanteenArray.size() > 0) {
                            L1.setVisibility(View.VISIBLE);
                            CanteenAdapter sAdapter = new CanteenAdapter(Canteen_Mainactivity.this, CanteenArray);
                            sAdapter.notifyDataSetChanged();
                            sAdapter.setPref(pref);
                            sAdapter.setPhoneNo(_phoneNo);
                            _moreRv.setAdapter(sAdapter);
                            _moreRv.setHasFixedSize(true);
                            StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(getSpan(), StaggeredGridLayoutManager.VERTICAL);
                            _moreRv.setLayoutManager(mLayoutManager);
                            _moreRv.setItemAnimator(new DefaultItemAnimator());
                            _moreRv.addOnItemTouchListener(
                                    new RecyclerTouchListener(Canteen_Mainactivity.this, _moreRv,
                                            new RecyclerTouchListener.OnTouchActionListener() {


                                                @Override
                                                public void onClick(View view, final int position) {
                                                    Log.w("gallery", String.valueOf(position));
                                                    if (position >= 0) {
                                                        if (CanteenArray.size() != 0 && CanteenArray.get(position).getName(position) != null) {
                                                            Intent o = new Intent(Canteen_Mainactivity.this, Canteen_Details.class);
                                                            pref.setFrom1(2);
                                                            pref.setFrom2(CanteenArray.get(position).getID(position));
                                                            pref.setID1(2);
                                                            pref.setID3(CanteenArray.get(position).getID(position));
                                                            pref.setID2(CanteenArray.get(position).getID(position));
                                                            pref.setcName(null);
                                                            pref.setcName(CanteenArray.get(position).getName(position));
                                                            pref.setCancel1(CanteenArray.get(position).getPhoto(position));
                                                            startActivity(o);
                                                            finish();
                                                            overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                                                        }
                                                    }
                                                }

                                                @Override
                                                public void onRightSwipe(View view, int position) {

                                                }

                                                @Override
                                                public void onLeftSwipe(View view, int position) {

                                                }
                                            }));
                        }

                        mShimmerViewContainer.stopShimmerAnimation();
                        mShimmerViewContainer.setVisibility(View.GONE);

                        mSwipeRefreshLayout.setRefreshing(false);
                        if (mSelfie.size() != 0) {
                            Collections.shuffle(mSelfie);
                            SelfieAdapter sAdapter4 = new SelfieAdapter(Canteen_Mainactivity.this, mSelfie);
                            sAdapter4.notifyDataSetChanged();
                            sAdapter4.setHasStableIds(true);
                            _imageRV.setAdapter(sAdapter4);
                            _imageRV.setHasFixedSize(true);
                            LinearLayoutManager horizontalLayoutManagae = new LinearLayoutManager(Canteen_Mainactivity.this, RecyclerView.HORIZONTAL, false);
                            _imageRV.setLayoutManager(horizontalLayoutManagae);
                            _imageRV.setItemAnimator(new DefaultItemAnimator());

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLogerr(error);


            }

        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("_mId", "_phoneNo");
                return params;
            }

        };
        eventoReq.setRetryPolicy(new DefaultRetryPolicy(
                3000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(eventoReq);

    }

    private void VolleyLogerr(VolleyError error) {
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

    public int getSpan() {
        int orientation = getScreenOrientation(getApplicationContext());
        if (isTV(getApplicationContext())) return 2;
        if (isTablet(getApplicationContext()))
            return orientation == Configuration.ORIENTATION_PORTRAIT ? 2 : 2;
        return orientation == Configuration.ORIENTATION_PORTRAIT ? 2 : 2;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //replaces the default 'Back' button action
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (pref.get_food_money() != 0) {
                if (pref.getUniqueRide() == null) {
                    if (!Canteen_Mainactivity.this.isFinishing()) {
                        new AlertDialog.Builder(Canteen_Mainactivity.this, R.style.AlertDialogTheme)
                                .setTitle("Are you Sure?")
                                .setMessage("You have items on the cart. Please complete your order.")
                                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                        pref.set_food_items(0);
                                        pref.set_food_money(0);
                                        pref.packagesharedPreferences(null);
                                        pref.setTotal(null);
                                        pref.setCost(null);
                                        overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                                        finishAffinity();
                                        finish();
                                    }
                                })
                                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                })
                                .show();
                    }
                } else {
                    if (!Canteen_Mainactivity.this.isFinishing()) {
                        new AlertDialog.Builder(Canteen_Mainactivity.this, R.style.AlertDialogTheme)
                                .setTitle("Are you Sure?")
                                .setMessage("You have an order to be deliver by meat express. Keep track of your order. ")
                                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                        overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                                        finishAffinity();
                                        finish();
                                    }
                                })
                                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                })
                                .show();
                    }
                }
            } else {
                if (!Canteen_Mainactivity.this.isFinishing()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Canteen_Mainactivity.this, R.style.AlertDialogTheme)
                            .setIcon(R.mipmap.ic_launcher)
                            .setTitle("Are you sure to exit?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                                    finishAffinity();
                                    finish();
                                    dialog.cancel();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }
            }
        }
        return true;
    }

    private void setUpNavigationView() {

        //Setting Navigation View Item Selected Listener to handle the bean click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            // This method will trigger on bean Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which bean was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_home:
                        drawer.closeDrawers();
                        if (_phoneNo == null) {
                            Intent o = new Intent(Canteen_Mainactivity.this, ServiceOffer.class);
                            startActivity(o);
                            finish();
                            overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                        } else {
                            Intent o1 = new Intent(Canteen_Mainactivity.this, Update_profile.class);
                            startActivity(o1);
                            finish();
                            overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                        }
                        break;


                    case R.id.nav_about:
                        drawer.closeDrawers();
                        Intent o1 = new Intent(Canteen_Mainactivity.this, Wb1_access.class);
                        o1.putExtra("url", "http://139.59.38.160/Meat/Website/about.html");
                        startActivity(o1);
                        overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                        finish();


                        break;

                    case R.id.nav_contact:
                        drawer.closeDrawers();

                        Intent ouc = new Intent(Canteen_Mainactivity.this, ContactUs.class);
                        startActivity(ouc);
                        overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);

                        break;

                    case R.id.nav_reminder:
                        drawer.closeDrawers();
                        if (_phoneNo != null) {
                            Intent o = new Intent(Canteen_Mainactivity.this, Ride_later_tabs.class);
                            startActivity(o);
                            finish();
                            overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);


                        } else {
                            Intent o = new Intent(Canteen_Mainactivity.this, ServiceOffer.class);
                            startActivity(o);
                            finish();
                            overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                        }
                        break;
                    case R.id.nav_notification:
                        drawer.closeDrawers();
                        if (_phoneNo != null) {
                            Intent o = new Intent(Canteen_Mainactivity.this, NotificationAll.class);
                            startActivity(o);
                            finish();
                            overridePendingTransition(R.anim.slide_up1, R.anim.slide_down1);


                        } else {
                            Intent o = new Intent(Canteen_Mainactivity.this, ServiceOffer.class);
                            startActivity(o);
                            finish();
                            overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                        }
                        break;
                    case R.id.nav_refer:
                        drawer.closeDrawers();
                        if (_phoneNo != null) {
                            Intent o2 = new Intent(Canteen_Mainactivity.this, Refer_and_Earn_page.class);
                            o2.putExtra("mylat", My_lat);
                            o2.putExtra("mylong", My_long);
                            startActivity(o2);
                            finish();
                            overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                        } else {
                            Intent o = new Intent(Canteen_Mainactivity.this, ServiceOffer.class);
                            startActivity(o);
                            finish();
                            overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                        }
                        break;


                    case R.id.logout:
                        drawer.closeDrawers();
                        if (_phoneNo != null) {
                            if (pref.get_food_money() != 0) {
                                if (pref.getUniqueRide() == null) {
                                    if (!Canteen_Mainactivity.this.isFinishing()) {
                                        new AlertDialog.Builder(Canteen_Mainactivity.this, R.style.AlertDialogTheme)
                                                .setTitle("Are you Sure?")
                                                .setMessage("You have items on the cart. Your cart will be empty if you logout.")
                                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.cancel();
                                                        logout();
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
                                } else {
                                    if (!Canteen_Mainactivity.this.isFinishing()) {
                                        new AlertDialog.Builder(Canteen_Mainactivity.this, R.style.AlertDialogTheme)
                                                .setTitle("Are you Sure?")
                                                .setMessage("You have an order to deliver by meat express. ")
                                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.cancel();
                                                        logout();
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
                            } else {
                                Snackbar snackbar1 = Snackbar
                                        .make(coordinatorLayout, "Are you Sure?", Snackbar.LENGTH_LONG)
                                        .setAction("Logout", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                logout();

                                            }
                                        });
                                snackbar1.setActionTextColor(Color.RED);
                                snackbar1.show();
                            }
                        }
                        break;

                    case R.id.login:
                        drawer.closeDrawers();
                        Intent i3 = new Intent(Canteen_Mainactivity.this, ServiceOffer.class);
                        startActivity(i3);
                        finish();
                        overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                        break;


                    default:
                        drawer.openDrawer(Gravity.LEFT);
                        break;
                }

                //Checking if the bean is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                return true;
            }
        });


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer,
                R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    private void logout() {
        StringRequest eventoReq = new StringRequest(com.android.volley.Request.Method.POST, Config_URL.URL_LOGOUT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.w("kk", response);


                        String[] par = response.split("error");
                        if (par[1].contains("false")) {
                            pref.clearSession();
                            pref.createLogin(null, null);
                            pref.setResponsibility(0);
                            pref.packagesharedPreferences(null);
                            pref.set_food_money(0);
                            pref.setTotal(null);
                            pref.setTotal2(null);
                            Intent i3 = new Intent(Canteen_Mainactivity.this, Splash_screen.class);
                            startActivity(i3);
                            finish();
                            overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
                        } else {
                            ViewDialogFailed alert = new ViewDialogFailed();
                            alert.showDialog(Canteen_Mainactivity.this, "Please check the information provided!", true);
                        }


                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLogerr(error);
            }

        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("mobile", _phoneNo);
                return params;
            }

        };

        // Añade la peticion a la cola
        AppController.getInstance().addToRequestQueue(eventoReq);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    private class FirebaseDataListener_after_ride implements ValueEventListener {

        private String _ask;
        private String ETR;
        private String _verify;

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            int count = (int) dataSnapshot.getChildrenCount();
            if (count != 0) {
                if (pref.getUniqueRide() != null) {
                    _ask = (String) dataSnapshot.child("ask").getValue();

                    if (dataSnapshot.child("changed").getValue() != null) {
                        CustomNotification3("Order changed!", "Your order has been changed due to availibility. Inconvinience regretted. ");
                    }
                    if (dataSnapshot.child("ETR").getValue() != null) {
                        ETR = (String) dataSnapshot.child("ETR").getValue();
                        ETR = parseDateToETR(ETR);
                    }


                    if (dataSnapshot.child("Verify").getValue() != null) {
                        _verify = (String) dataSnapshot.child("Verify").getValue();
                        if (_verify.contains("3")) {
                            CustomNotification4("Payment  verified!", "Your have choosen EFT for payment. Your payment has been veridied. Thank you! " + ETR);

                        }
                    }

                    if (dataSnapshot.child("OTP").getValue() != null) {
                        pref.setOrder((String) dataSnapshot.child("OTP").getValue());
                    }

                    if (_ask != null) {
                        if (_ask.contains("2") && !drawn) {
                            drawn = true;
                            if (dataSnapshot.child("message").getValue() != null) {
                                String _message = (String) dataSnapshot.child("message").getValue();
                                CustomNotification("Order Accepted", _message);
                                String[] pars = pref.getUniqueRide().split("\\.");
                                con = TextUtils.join("", pars);
                                mDatabase.child("Meat").child(con).child("message").removeValue();
                            } else {
                                CustomNotification("Thank You. Your order has been accepted", "Watch out for further updates coming your way");
                            }
                        } else if (_ask.contains("3") && !drawn1) {
                            drawn1 = true;
                            if (dataSnapshot.child("message").getValue() != null) {
                                String _message = (String) dataSnapshot.child("message").getValue();
                                CustomNotification("Order Confirmed", _message);
                                String[] pars = pref.getUniqueRide().split("\\.");
                                con = TextUtils.join("", pars);
                                mDatabase.child("Meat").child(con).child("message").removeValue();
                            } else {
                                CustomNotification("Your order has beem confirmed",
                                        "Your next update will confirm your expected delivery date");
                            }

                        } else if (_ask.contains("4") && !drawn2) {
                            drawn2 = true;
                            if (dataSnapshot.child("pchanged").getValue() != null) {
                                pref.setTotal2((String) dataSnapshot.child("Cost").getValue());
                                CustomNotification2("Congratulations!", "Meat express has given you a discount on your order. ");
                            } else {
                                if (dataSnapshot.child("message").getValue() != null) {
                                    String _message = (String) dataSnapshot.child("message").getValue();
                                    CustomNotification("Woohoo", "look forward to seeing you on " + ETR);
                                    String[] pars = pref.getUniqueRide().split("\\.");
                                    con = TextUtils.join("", pars);
                                    mDatabase.child("Meat").child(con).child("message").removeValue();
                                } else {
                                    CustomNotification("Woohoo", "look forward to seeing you on " + ETR);
                                }
                            }


                        } else if (_ask.contains("5") && !drawn3) {
                            drawn3 = true;
                            if (dataSnapshot.child("message").getValue() != null) {
                                String _message = (String) dataSnapshot.child("message").getValue();
                                CustomNotification("Order dispatched", _message);
                                String[] pars = pref.getUniqueRide().split("\\.");
                                con = TextUtils.join("", pars);
                                mDatabase.child("Meat").child(con).child("message").removeValue();
                            } else {
                                CustomNotification("Today is the day, see you soon", "Your order is put for delivery");
                            }


                        } else if (_ask.contains("6") && !drawn4) {
                            drawn4 = true;
                            CustomNotification("Your order has been delivered", "Thank you for your order.  We look forward to meating soon");
                            Intent i = new Intent(Canteen_Mainactivity.this, UserSuccess.class);
                            startActivity(i);
                            finish();
                            overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);

                        } else if (_ask.contains("7") && !drawn5) {
                            drawn5 = true;
                            String _reason = (String) dataSnapshot.child("reason").getValue();
                            openEditor(_reason);

                        }
                    }
                }
            } else {
                if (pref.getUniqueRide() != null) {
                    pref.setUniqueRide(null);
                    pref.setDriverPhone(null);
                    pref.packagesharedPreferences(null);
                    pref.set_food_items(0);
                    pref.set_food_money(0);
                    pref.setTotal(null);
                    pref.setTotal2(null);
                }
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    }

    public class ViewDialogFailed {

        public void showDialog(Activity activity, String msg, Boolean noDate) {
            if (!activity.isFinishing()) {
                final Dialog dialog1 = new Dialog(activity);
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setCancelable(false);

                dialog1.setContentView(R.layout.custom_dialog_failed);
                dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog1.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                TextView text = dialog1.findViewById(R.id.text_dialog);
                text.setText(msg);

                Button dialogButton = dialog1.findViewById(R.id.btn_dialog);

                dialogButton.setText("Ok");
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog1.dismiss();
                    }
                });

                dialog1.show();
            }
        }
    }

}






