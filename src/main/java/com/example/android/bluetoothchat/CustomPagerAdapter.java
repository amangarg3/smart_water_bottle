package com.example.android.bluetoothchat;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static java.security.AccessController.getContext;

/**
 * Created by Nitish on 31-Dec-16.
 */

class CustomPagerAdapter extends PagerAdapter {

    //this adapter is for the main page
    //shows the water and juice bottles

    Context mContext;
    LayoutInflater mLayoutInflater;

    int[] mResources = {
            R.drawable.bottle25,
            R.drawable.bottle50,
            R.drawable.bottle75,
            R.drawable.bottle100,
            R.drawable.jbottle,
            R.drawable.jbottle,
            R.drawable.jbottle,
            R.drawable.jbottle,
    };

    String [] Bottles = {
      "Bottle 1", "Bottle 2"
    };

    String [] Cquan = {
            "40", "60"
    };

    String [] LD = {
            "12 litres", "5 litres"
    };

    String [] Stat = {
            "Good", "Need to improve"
    };

    public CustomPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Stat.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);

        TextView CQuality = (TextView)itemView.findViewById(R.id.editText);
        TextView LDAYQ = (TextView)itemView.findViewById(R.id.editText2);
        TextView SQ = (TextView)itemView.findViewById(R.id.editText3);
        TextView CQualityA = (TextView)itemView.findViewById(R.id.editText4);
        TextView LDAYA = (TextView)itemView.findViewById(R.id.editText5);
        TextView SA = (TextView)itemView.findViewById(R.id.editText6);
        TextView bottle = (TextView)itemView.findViewById(R.id.textView);
        Button button = (Button) itemView.findViewById(R.id.b2);

        Typeface typeface= Typeface.createFromAsset(CQuality.getContext().getAssets(), "fonts/OpenSansRegular.ttf");
        CQuality.setTypeface(typeface);
        LDAYQ.setTypeface(typeface);
        LDAYA.setTypeface(typeface);
        SQ.setTypeface(typeface);
        SA.setTypeface(typeface);
        bottle.setTypeface(typeface);
        CQualityA.setTypeface(typeface);
        button.setTypeface(typeface);

        if (position == 2)
            position --;
        int a[] = new int[2];
        int i[] = new int[2];
        CQuality.setText("Current Quantity");
        LDAYQ.setText("Last Day Cons.");
        SQ.setText("Status");
        CQualityA.setText(Cquan[position]+"%");
        a[position] = Integer.parseInt(Cquan[position]);

      if(a[position] <=33)
            i[position] = 0;
        else if(a[position]<=63)
            i[position] = 1;
        else if(a[position]<=88)
            i[position] = 2;
        else
            i[position] = 3;

        LDAYA.setText(LD[position]);
        SA.setText(Stat[position]);
        bottle.setText(Bottles[position]);
        button.setText("SEND DATA TO ARDUINO");
        imageView.setImageResource(mResources[position*4 + i[position]]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }



}