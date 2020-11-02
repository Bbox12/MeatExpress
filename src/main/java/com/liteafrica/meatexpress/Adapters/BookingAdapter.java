package com.liteafrica.meatexpress.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.liteafrica.meatexpress.Activites.Canteen.Canteen_Mainactivity;
import com.liteafrica.meatexpress.Model.Foods;
import com.liteafrica.meatexpress.PrefManager;
import com.liteafrica.meatexpress.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Set;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.MyViewHolder> {

    public String Op_time, Cl_time;
    private Context mContext;
    private ArrayList<Foods> albumList;
    private String Mn_order;
    private PrefManager pref;
    private DecimalFormat df = new DecimalFormat("0.00");
    private int _from = 0;
    private double _orderValue = 0;
    private ArrayList<String> _foods = new ArrayList<String>();
    private ArrayList<String> noOfitems = new ArrayList<String>();

    public BookingAdapter(Context mContext, ArrayList<Foods> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    public void setPref(PrefManager pref1) {
        pref = pref1;
    }

    public void setFrom(int j) {
        _from = j;
    }

    @Override
    public BookingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bookingadapter, parent, false);

        return new BookingAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BookingAdapter.MyViewHolder holder, final int position) {
        final Foods album = albumList.get(position);
        holder._name.setText(album.getMenu_Name(position));
        holder._price.setText("R" + df.format(album.geteTEZ_Price(position)));
        holder._noItem.setText(String.valueOf(album.getNoofItems(position)));
        holder._slNo.setText(String.valueOf(position + 1));


        if (_from != 0) {
            holder._add.setBackgroundColor(Color.WHITE);
            holder._minus.setBackgroundColor(Color.WHITE);
            holder._delete.setBackgroundColor(Color.WHITE);
        }


        if (pref.get_packagesharedPreferences() != null) {
            Set<String> set = pref.get_packagesharedPreferences();
            _foods.clear();
            _foods.addAll(set);
        }
        holder._delete.setOnClickListener(new View.OnClickListener() {
            private int food = 0;

            @Override
            public void onClick(View v) {

                if (_from == 0) {
                    ArrayList<String> _foods = new ArrayList<String>();
                    Set<String> set = pref.get_packagesharedPreferences();
                    _foods.addAll(set);
                    for (int i = 0; i < _foods.size(); i++) {
                        String[] pars = _foods.get(i).split("\\_");
                        if (albumList.get(position).getID(position) == Integer.parseInt(pars[0])) {
                            _foods.remove(i);
                            food = pref.get_food_items() - 1;
                            pref.set_food_items(food);
                            double _orderValue = pref.get_food_money() - Double.parseDouble(pars[1]) * albumList.get(position).geteTEZ_Price(position);
                            pref.set_food_money((float) _orderValue);

                            break;
                        }

                    }
                    pref.packagesharedPreferences(_foods);
                    removeAt(position);

                    if (food != 0) {
                        ((Activity) mContext).recreate();
                    } else {
                        if (!((Activity) mContext).isFinishing()) {
                            new AlertDialog.Builder(mContext, R.style.AlertDialogTheme)
                                    .setIcon(R.mipmap.ic_launcher)
                                    .setTitle("Are you sure?")
                                    .setMessage("Your order is about to empty ")
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            pref.set_food_items(0);
                                            pref.set_food_money(0);
                                            pref.packagesharedPreferences(null);
                                            pref.setTotal(null);
                                            pref.setTotal2(null);
                                            Intent o = new Intent(mContext, Canteen_Mainactivity.class);
                                            mContext.startActivity(o);
                                            ((Activity) mContext).finish();
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
                    Toast.makeText(mContext, "Order is placed! You can not modify the order.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder._add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (_from == 0) {
                    int Rate_ = Integer.parseInt(holder._noItem.getText().toString());
                    double single = albumList.get(position).geteTEZ_Price(position) / Rate_;
                    if (Rate_ >= 0) {
                        Rate_ = 1 + Rate_;
                        _orderValue = pref.get_food_money() + single;
                        pref.set_food_money((float) _orderValue);
                        pref.setTotal(String.valueOf(_orderValue));
                        holder._noItem.setText(String.valueOf(Rate_));
                        holder._price.setText("R" + df.format(Rate_ * single));
                        for (int i = 0; i < _foods.size(); i++) {
                            String[] pars = _foods.get(i).split("\\_");
                            if (albumList.get(position).getID(position) == Integer.parseInt(pars[0])) {
                                String s = pars[0];
                                _foods.remove(i);
                                _foods.add(s + "_" + Rate_ + "_" + Rate_ * single + "_" + albumList.get(position).getMenu_Name(position) + "_" + position);
                            }

                        }
                        pref.packagesharedPreferences(_foods);
                        ((Activity) mContext).recreate();
                    }
                }

            }
        });

        holder._minus.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (_from == 0) {
                    int Rate_ = Integer.parseInt(holder._noItem.getText().toString());
                    double single = albumList.get(position).geteTEZ_Price(position) / Rate_;
                    if (Rate_ > 1) {
                        Rate_ = Rate_ - 1;
                        holder._noItem.setText(String.valueOf(Rate_));
                        _orderValue = pref.get_food_money() - single;
                        pref.set_food_money((float) _orderValue);
                        pref.setTotal(String.valueOf(_orderValue));
                        for (int i = 0; i < _foods.size(); i++) {
                            String[] pars = _foods.get(i).split("\\_");
                            if (albumList.get(position).getID(position) == Integer.parseInt(pars[0])) {
                                String s = pars[0];
                                _foods.remove(i);
                                holder._price.setText("R" + df.format(albumList.get(position).geteTEZ_Price(position) - single));
                                _foods.add(s + "_" + Rate_ + "_" + Rate_ * single + "_" + albumList.get(position).getMenu_Name(position) + "_" + position);

                            }

                        }
                        pref.packagesharedPreferences(_foods);
                        ((Activity) mContext).recreate();
                    }
                }

            }
        });

    }

    private void removeAt(int p1) {

        if (albumList != null && albumList.size() != 0 && albumList.get(p1) != null) {
            albumList.remove(p1);
            notifyItemRemoved(p1);
            notifyItemRangeChanged(p1, albumList.size());
        }

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView _name, _price, _slNo, _noItem;
        public ImageButton _minus, _add, _delete;


        public MyViewHolder(View view) {
            super(view);
            _name = view.findViewById(R.id._Name);
            _price = view.findViewById(R.id.price_);
            _slNo = view.findViewById(R.id._slNo);
            _noItem = view.findViewById(R.id.rate_km);
            _minus = view.findViewById(R.id.button2_minus);
            _add = view.findViewById(R.id.button2_add);
            _delete = view.findViewById(R.id.button2_plus);
        }
    }
}