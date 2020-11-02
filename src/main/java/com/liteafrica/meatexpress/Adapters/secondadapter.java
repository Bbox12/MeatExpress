package com.liteafrica.meatexpress.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.liteafrica.meatexpress.Activites.Canteen.SingleProduct;
import com.liteafrica.meatexpress.Activites.Main_Page.GooglemapApp;
import com.liteafrica.meatexpress.LruBitmapCache;
import com.liteafrica.meatexpress.Model._menu;
import com.liteafrica.meatexpress.PrefManager;
import com.liteafrica.meatexpress.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Set;

public class secondadapter extends RecyclerView.Adapter<secondadapter.ViewHolder> {

    private ArrayList<_menu> mPostItems;
    private Context mContext;
    private PrefManager pref;
    private TextView _iValue;
    private int itemSelected = 0;
    private double _orderValue = 0;
    private DecimalFormat df = new DecimalFormat("0.00");
    private ArrayList<String> _foods = new ArrayList<String>();


    public secondadapter(Context mContext, ArrayList<_menu> postItems) {
        this.mContext = mContext;
        this.mPostItems = postItems;

    }


    @Override
    public secondadapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        //More to come
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.new_horizontal_recyle, viewGroup, false);
        ViewHolder viewHolder = new secondadapter.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final _menu album = mPostItems.get(position);
        holder.Name.setText(album.getName(position));
        holder.rl51.setBackgroundColor(Color.parseColor(album.getColors(position)));

        if (album.getClosing_time(position) != null && !TextUtils.isEmpty(album.getClosing_time(position))) {
            if (album.getClosing_time(position).toLowerCase().contains("fresh")) {
                holder._fresh.setBackground(mContext.getResources().getDrawable(R.drawable.fresh));
                holder._fresh.setText(album.getClosing_time(position));
            } else {
                holder._fresh.setBackground(mContext.getResources().getDrawable(R.drawable.notfresh));
                holder._fresh.setText(album.getClosing_time(position));
            }
        } else {
            holder._fresh.setVisibility(View.GONE);
        }


      /*  if(album.getIsOutOfStock(position)==0) {
            if (album.getStock(position) == 0) {
                holder.rrr.setVisibility(View.GONE);
                holder.outofstock.setVisibility(View.VISIBLE);
            } else {
                holder.rrr.setVisibility(View.VISIBLE);
                holder.outofstock.setVisibility(View.GONE);
            }
        }else{
            holder.rrr.setVisibility(View.GONE);
            holder.outofstock.setVisibility(View.VISIBLE);
        }*/

        holder.rrr.setVisibility(View.VISIBLE);
        holder.outofstock.setVisibility(View.GONE);

        String url = album.getPhoto(position).replaceAll(" ", "%20");
        ImageLoader imageLoader = LruBitmapCache.getInstance(mContext)
                .getImageLoader();
        imageLoader.get(url, ImageLoader.getImageListener(holder._Photo,
                R.mipmap.ic_launcher, R.mipmap
                        .ic_launcher));
        holder._Photo.setImageUrl(url, imageLoader);
        holder._Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(mContext, SingleProduct.class);
                pref.setPref2(1);
                pref.setID5(album.getID(position));
                mContext.startActivity(o);
                ((Activity) mContext).overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
            }
        });
        // holder.button2_plus.setVisibility(View.GONE);

        if (pref.get_packagesharedPreferences() != null) {
            Set<String> set = pref.get_packagesharedPreferences();
            _foods.clear();
            _foods.addAll(set);
            for (String s : set) {
                String[] pars = s.split("\\_");
                if (Integer.parseInt(pars[0]) == mPostItems.get(position).getID(position)) {
                    holder.rrr.setAnimation(AnimationUtils.loadAnimation(mContext,
                            R.anim.slide_up1));
                    holder.rrr.setVisibility(View.VISIBLE);
                    holder._noItem.setText(pars[1]);
                    break;
                }
            }
        }

        if (pref.get_food_items() != 0) {
            _iValue.setText(String.valueOf(pref.get_food_items()));
            _orderValue = pref.get_food_money();
            pref.set_food_money((float) _orderValue);
            pref.setTotal(String.valueOf(_orderValue));
            //  _mValue.setText("R" + df.format(pref.get_food_money()));

        } else {
            pref.set_food_money(0);
        }


        //progressBar.setVisibility(View.GONE);

        if (mPostItems.get(position).getDiscount(position) != 0) {
            holder.Discount.setText("R" + df.format(album.getDiscount(position)) + " off");
            double dis = album.geteTEZ_Price(position);
            holder.DiscountP.setText("R" + df.format((dis)));
        } else {
            holder.Discount.setVisibility(View.GONE);

        }


        if (album.getDetails(position) != null) {
            holder._details.setText(album.getDetails(position));
        } else {
            holder._details.setVisibility(View.GONE);

        }

        if (album.getPrice(position) != 0) {
            holder.Price.setText("R" + df.format(album.getPrice(position)));

        } else {
            holder.Price.setVisibility(View.GONE);

        }


     /*   holder.button2_plus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (pref.getUniqueRide() == null) {


                    holder.button2_plus.setChecked(true);
                    if (pref.get_packagesharedPreferences() != null) {
                        Set<String> set = pref.get_packagesharedPreferences();
                        _foods.clear();
                        _foods.addAll(set);
                    }
                    _foods.add(String.valueOf(mPostItems.get(position).getID(position) + "_" + 1 + "_" + String.valueOf(mPostItems.get(position).getPrice(position)) + "_" + mPostItems.get(position).getName(position)) + "_" + String.valueOf(position));
                    pref.packagesharedPreferences(_foods);
                    pref.setnoOfItems(_foods);
                    setPrice(mPostItems.get(position).getPrice(position));
                    holder.button2_plus.setAnimation(AnimationUtils.loadAnimation(mContext,
                            R.anim.fade_out));
                    holder.button2_plus.setVisibility(View.GONE);
                    holder.rrr.setAnimation(AnimationUtils.loadAnimation(mContext,
                            R.anim.slide_up1));
                    holder.rrr.setVisibility(View.VISIBLE);
                    holder._noItem.setText("1");
                }else {
                    if (!((Activity) mContext).isFinishing()) {
                        new AlertDialog.Builder(mContext, R.style.AlertDialogTheme)
                                .setTitle("Your order is already in process")
                                .setMessage("Please check the status of your order")
                                .setPositiveButton("Check", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                        Intent o = new Intent(mContext, GooglemapApp.class);

                                        ((Activity) mContext).startActivity(o);
                                        ((Activity) mContext).overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
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
            }
        });*/


        holder._add.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (pref.getUniqueRide() == null) {
                    boolean _again = false;
                    int Rate_ = Integer.parseInt(holder._noItem.getText().toString());
                    Rate_ = 1 + Rate_;
                    _orderValue = pref.get_food_money() + mPostItems.get(position).getPrice(position);
                    pref.set_food_money((float) _orderValue);
                    pref.setTotal(String.valueOf(_orderValue));
                    holder._noItem.setText(String.valueOf(Rate_));
                    if (pref.get_packagesharedPreferences() != null) {
                        Set<String> set = pref.get_packagesharedPreferences();
                        _foods.clear();
                        _foods.addAll(set);
                    }
                    for (int i = 0; i < _foods.size(); i++) {
                        String[] pars = _foods.get(i).split("\\_");
                        if (mPostItems.get(position).getID(position) == Integer.parseInt(pars[0])) {
                            String s = pars[0];
                            _foods.remove(i);
                            _again = true;
                            _foods.add(s + "_" + Rate_ + "_" + Rate_ * mPostItems.get(position).getPrice(position) + "_" + mPostItems.get(position).getName(position) + "_" + position);
                        }

                    }
                    if (!_again) {
                        itemSelected = pref.get_food_items();
                        itemSelected = itemSelected + 1;
                        pref.set_food_items(itemSelected);
                        _foods.add(mPostItems.get(position).getID(position) + "_" + 1 + "_" + mPostItems.get(position).getPrice(position) + "_" + mPostItems.get(position).getName(position) + "_" + position);
                    }
                    pref.packagesharedPreferences(_foods);
                    _iValue.setText(String.valueOf(pref.get_food_items()));


                } else {
                    if (!((Activity) mContext).isFinishing()) {
                        new AlertDialog.Builder(mContext, R.style.AlertDialogTheme)
                                .setTitle("Your order is already in process")
                                .setMessage("Please check the status of your order")
                                .setPositiveButton("Check", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                        Intent o = new Intent(mContext, GooglemapApp.class);

                                        mContext.startActivity(o);
                                        ((Activity) mContext).overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
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
        });
        holder._minus.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (pref.getUniqueRide() == null) {
                    int Rate_ = Integer.parseInt(holder._noItem.getText().toString());
                    if (Rate_ > 0) {
                        Rate_ = Rate_ - 1;
                        holder._noItem.setText(String.valueOf(Rate_));
                        _orderValue = pref.get_food_money() - mPostItems.get(position).getPrice(position);
                        pref.set_food_money((float) _orderValue);
                        pref.setTotal(String.valueOf(_orderValue));
                        if (pref.get_packagesharedPreferences() != null) {
                            Set<String> set = pref.get_packagesharedPreferences();
                            _foods.clear();
                            _foods.addAll(set);
                        }
                        for (int i = 0; i < _foods.size(); i++) {
                            String[] pars = _foods.get(i).split("\\_");
                            if (mPostItems.get(position).getID(position) == Integer.parseInt(pars[0])) {
                                String s = pars[0];
                                _foods.remove(i);
                                _foods.add(s + "_" + Rate_ + "_" + Rate_ * mPostItems.get(position).getPrice(position) + "_" + mPostItems.get(position).getName(position) + "_" + position);

                            }

                        }
                        pref.packagesharedPreferences(_foods);
                    }

                    if (Rate_ == 0) {
                        holder._noItem.setText("0");
                        for (int i = 0; i < _foods.size(); i++) {
                            String[] pars = _foods.get(i).split("\\_");
                            if (mPostItems.get(position).getID(position) == Integer.parseInt(pars[0])) {
                                _foods.remove(i);

                                itemSelected = pref.get_food_items();
                                itemSelected = itemSelected - 1;
                                pref.set_food_items(itemSelected);
                                _iValue.setText(String.valueOf(pref.get_food_items()));
                            }

                        }
                        pref.packagesharedPreferences(_foods);
                        if (itemSelected == 0) {
                            pref.packagesharedPreferences(null);
                            pref.set_food_money(0);
                            pref.set_food_items(0);
                            pref.setTotal(null);
                            pref.setTotal2(null);
                        }
                    }

                } else {
                    if (!((Activity) mContext).isFinishing()) {
                        new AlertDialog.Builder(mContext, R.style.AlertDialogTheme)
                                .setTitle("Your order is already in process")
                                .setMessage("Please check the status of your order")
                                .setPositiveButton("Check", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                        Intent o = new Intent(mContext, GooglemapApp.class);

                                        mContext.startActivity(o);
                                        ((Activity) mContext).overridePendingTransition(R.anim.slide_up1, R.anim.rbounce);
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
        });

        holder._noItem.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                TranslateAnimation animObj = new TranslateAnimation(0, 0, 0, holder._noItem.getHeight());
                animObj.setDuration(1000);
                holder._noItem.startAnimation(animObj);

            }
        });


    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        return mPostItems.size();
    }

    public void setPref(PrefManager pref1) {
        pref = pref1;
    }

    public void setValues(TextView itemValue) {
        _iValue = itemValue;
    }

    private void setNon(double v) {
        itemSelected = pref.get_food_items();
        itemSelected = itemSelected - 1;
        pref.set_food_items(itemSelected);
        _iValue.setText(String.valueOf(pref.get_food_items()));
        _orderValue = pref.get_food_money() - v;
        pref.set_food_money((float) _orderValue);
        //  _mValue.setText("R" + df.format(pref.get_food_money()));

    }

    private void setPrice(double v) {
        itemSelected = pref.get_food_items();
        itemSelected = itemSelected + 1;
        pref.set_food_items(itemSelected);
        _iValue.setText(String.valueOf(pref.get_food_items()));
        _orderValue = pref.get_food_money() + v;
        pref.set_food_money((float) _orderValue);
        // _mValue.setText("R" + df.format(pref.get_food_money()));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final NetworkImageView _Photo;
        private TextView Count, Name;
        private TextView Price, Discount, DiscountP, _details, _fresh, outofstock;
        private RelativeLayout rl51;
        private LinearLayout rrr;
        private ImageButton _minus, _add;
        private EditText _noItem;

        public ViewHolder(View itemView) {
            super(itemView);
            Discount = itemView.findViewById(R.id.discount_1);
            DiscountP = itemView.findViewById(R.id.discountprice_1);
            Name = itemView.findViewById(R.id._name1);
            Price = itemView.findViewById(R.id.price_1);
            _Photo = itemView.findViewById(R.id.service_pic);
            rrr = itemView.findViewById(R.id._rrr1);
            _minus = itemView.findViewById(R.id.button2_minus1);
            _add = itemView.findViewById(R.id.button2_add1);
            _noItem = itemView.findViewById(R.id.rate_km1);
            rl51 = itemView.findViewById(R.id.rl51);
            _details = itemView.findViewById(R.id._details1);
            _fresh = itemView.findViewById(R.id.fresh);
            outofstock = itemView.findViewById(R.id.outofstock);
        }

    }

}
