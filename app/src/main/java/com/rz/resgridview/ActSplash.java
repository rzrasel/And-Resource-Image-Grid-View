package com.rz.resgridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class ActSplash extends AppCompatActivity {
    private Integer[] mThumbIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);

        mThumbIds = new Integer[]{Integer.valueOf(R.drawable.lion_photo),Integer.valueOf(R.drawable.lion_photo),Integer.valueOf(R.drawable.lion_photo),Integer.valueOf(R.drawable.lion_photo)};
        GridView localGridView = (GridView) findViewById(R.id.gridview);
        localGridView.setAdapter(new AdapterImage(this, R.layout.grid_item, mThumbIds));
        //localGridView.setOnItemClickListener(new C03341());
    }
}