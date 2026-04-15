package com.example.gestyzadanie2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;

    public CustomPagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ModelObject modelObject=ModelObject.values()[position];
        LayoutInflater inflater=LayoutInflater.from(mContext);
        ViewGroup layout=(ViewGroup) inflater.inflate(modelObject.getLayoutID(),container,false);
        container.addView(layout);


        if (position==getCount()-1){
            if (mContext instanceof MainActivity){
                ((MainActivity) mContext).stayAtLast();
            }
            View przycsik = layout.findViewById(R.id.start);
            przycsik.setOnClickListener(v -> {
                if (mContext instanceof MainActivity){
                    ((MainActivity) mContext).goToFirst();
                }
            });
        }


        return layout;
    }

    @Override
    public int getCount() {
        return ModelObject.values().length;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        ModelObject customPagerEnum=ModelObject.values()[position];
        return mContext.getString(customPagerEnum.getTitleID());
    }
}
