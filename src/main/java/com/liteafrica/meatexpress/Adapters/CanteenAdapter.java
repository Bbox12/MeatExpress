package com.liteafrica.meatexpress.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.liteafrica.meatexpress.LruBitmapCache;
import com.liteafrica.meatexpress.Model.Eats;
import com.liteafrica.meatexpress.PrefManager;
import com.liteafrica.meatexpress.R;

import java.util.ArrayList;
import java.util.Date;

public class CanteenAdapter extends RecyclerView.Adapter<CanteenAdapter.MyViewHolder> {

    public String Op_time, Cl_time;
    private Context mContext;
    private ArrayList<Eats> albumList;
    private String Mn_order;
    private PrefManager pref;
    private Date timeToCompare;
    private boolean _closed = false;
    private Date beforeTime;
    private int _time = 0;
    private String Mn_time;
    private String _phoneNo;
    private ImageLoader imageLoader;

    public CanteenAdapter(Context mContext, ArrayList<Eats> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    public void setPref(PrefManager pref1) {
        pref = pref1;
    }

    public void setTime(int i) {
        _time = i;
    }

    public void setPhoneNo(String phoneNo) {
        _phoneNo = phoneNo;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.secondcard, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        _closed = false;
        final Eats album = albumList.get(position);
        holder._homeservice.setText(album.getName(position));
        String url = album.getPhoto(position).replaceAll(" ", "%20");
        ImageLoader imageLoader = LruBitmapCache.getInstance(mContext)
                .getImageLoader();
        imageLoader.get(url, ImageLoader.getImageListener(holder._serviceImage,
                R.mipmap.ic_launcher_web, R.mipmap
                        .ic_launcher_web));
        holder._serviceImage.setImageUrl(url, imageLoader);


    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView _homeservice;
        private NetworkImageView _serviceImage;
        private RelativeLayout layoutBottom;


        public MyViewHolder(View view) {
            super(view);
            _homeservice = view.findViewById(R.id.primary_text);
            _serviceImage = view.findViewById(R.id.service_pic);
            layoutBottom = view.findViewById(R.id.layoutBottom);
        }
    }


}