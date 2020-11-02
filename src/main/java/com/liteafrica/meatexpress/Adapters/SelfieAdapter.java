package com.liteafrica.meatexpress.Adapters;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.github.andreilisun.swipedismissdialog.OnSwipeDismissListener;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDirection;
import com.liteafrica.meatexpress.LruBitmapCache;
import com.liteafrica.meatexpress.Model.Eats;
import com.liteafrica.meatexpress.R;

import java.util.ArrayList;
import java.util.List;


public class SelfieAdapter extends RecyclerView.Adapter<SelfieAdapter.ViewHolder> {

    protected List<Eats> list;
    // The items to display in your RecyclerView
    private ArrayList<Eats> mItems;
    private LayoutInflater mshit;

    private Context mContext;
    private String Name_p;
    private String User;
    private String rView;
    private ArrayList<Eats> mModel;


    public SelfieAdapter(Context acontext, ArrayList<Eats> mItems) {
        //mshit = LayoutInflater.from(acontext);
        this.mItems = mItems;
        this.mContext = acontext;


    }


    public ArrayList<Eats> getmItems() {
        return mItems;
    }

    @Override
    public long getItemId(int position) {

        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void setName(String name) {

        Name_p = name;

    }

    public void User(String user) {
        User = user;
    }

    public void Service_name(String s) {

        rView = s;
    }

    @Override
    public SelfieAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        //More to come
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.selfierv, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final SelfieAdapter.ViewHolder viewHolder, final int position) {
        final Eats movie = mItems.get(position);

        if (movie.getPhoto(position) != null) {

            String url = movie.getPhoto(position).replaceAll(" ", "%20");
            ImageLoader imageLoader = LruBitmapCache.getInstance(mContext)
                    .getImageLoader();
            imageLoader.get(url, ImageLoader.getImageListener(viewHolder.images_p,
                    R.mipmap.ic_launcher, R.mipmap
                            .ic_launcher));
            viewHolder.images_p.setImageUrl(url, imageLoader);

        }

        if (!TextUtils.isEmpty(movie.getDescription(position))) {
            viewHolder._name.setText(movie.getDescription(position));
        } else {
            viewHolder._name.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(movie.getTitle(position))) {
            viewHolder._text1.setText(movie.getTitle(position));
        } else {
            viewHolder._text1.setVisibility(View.GONE);
        }
        viewHolder.images_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_logout(movie.getPhoto(position));
            }
        });
    }

    private void open_logout(String _filePath) {

        if (!((Activity) mContext).isFinishing()) {

            SwipeDismissDialog.Builder builder = new SwipeDismissDialog.Builder(mContext);

            LayoutInflater inflater = LayoutInflater.from(mContext);
            View dialogView = inflater.inflate(R.layout.full_image, null);

            // Set the custom layout as alert dialog view
            builder.setView(dialogView);


            NetworkImageView _Profile = dialogView.findViewById(R.id.full_image_view);
            ImageLoader imageLoader = LruBitmapCache.getInstance(mContext)
                    .getImageLoader();
            imageLoader.get(_filePath, ImageLoader.getImageListener(_Profile,
                    R.mipmap.ic_launcher, R.mipmap
                            .ic_launcher));
            _Profile.setImageUrl(_filePath, imageLoader);
            // Create the alert dialog
            final SwipeDismissDialog dialog = builder.setOnSwipeDismissListener(new OnSwipeDismissListener() {
                @Override
                public void onSwipeDismiss(View view, SwipeDismissDirection direction) {

                }
            })
                    .build();


            dialog.show();
        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private NetworkImageView images_p;
        private TextView _name, _address, _text1;


        public ViewHolder(View itemView) {
            super(itemView);
            _name = itemView.findViewById(R.id.description);
            images_p = itemView.findViewById(R.id.service_pic);
            _text1 = itemView.findViewById(R.id._text1);
        }


    }


}

