package com.rz.resgridview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

/**
 * Created by Rz Rasel on 2016-11-13.
 */

public class AdapterImage extends ArrayAdapter<Object> {
    String TAG;
    private Context context;
    private Integer[] mImgGrid;
    private Integer[] mThumbIds;
    private String[] mTitleText;
    private int resource;
    Bitmap localBitmap;

    public AdapterImage(Context paramContext, int paramInt, Integer[] paramArrayOfInteger) {
        super(paramContext, paramInt, paramArrayOfInteger);
        this.TAG = "ImageAdapter";
        context = paramContext;
        this.resource = paramInt;
        this.mImgGrid = paramArrayOfInteger;
        mThumbIds = paramArrayOfInteger;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        ViewHolder localViewHolder;
        Log.d("paramView", paramView + BuildConfig.FLAVOR);
        if (paramView == null) {
            paramView = LayoutInflater.from(getContext()).inflate(this.resource, paramViewGroup, false);
            localViewHolder = new ViewHolder();
            localViewHolder.imgGrid = (ImageView) paramView.findViewById(R.id.imageView1);
            paramView.setTag(localViewHolder);
        } else {
            localViewHolder = (ViewHolder) paramView.getTag();
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;
            localBitmap = BitmapFactory.decodeResource(context.getResources(), mThumbIds[paramInt].intValue(), options);
            localBitmap.compress(Bitmap.CompressFormat.PNG, 100, new ByteArrayOutputStream());
            Log.d("Width", localBitmap.getWidth() + BuildConfig.FLAVOR);
            Log.d("Height", localBitmap.getHeight() + BuildConfig.FLAVOR);
            localViewHolder.imgGrid.setImageBitmap(localBitmap);
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return paramView;
    }

    public class ViewHolder {
        private ImageView imgGrid;
        private ImageView imgGrid1;
        private TextView txtTitle;
    }
}