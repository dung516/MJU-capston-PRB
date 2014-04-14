package com.example.prb.ImageShow;

import com.example.prb.R;
import com.example.prb.ImageShow.GridViewImageAdapter;
import com.example.prb.ImageShow.AppConstant;
import com.example.prb.ImageShow.Utils;
 
import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.GridView;
 
public class GridViewActivity extends Activity {
 
    private Utils utils;
    private ArrayList<String> imagePaths = new ArrayList<String>();
    private GridViewImageAdapter adapter;
    private GridView gridView;
    private int columnWidth;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);
        gridView = (GridView) findViewById(R.id.grid_view);
        utils = new Utils(this);
        InitilizeGridLayout();
        imagePaths = utils.getFilePaths();
        adapter = new GridViewImageAdapter(GridViewActivity.this, imagePaths, columnWidth);
        gridView.setAdapter(adapter);
    }
 
    private void InitilizeGridLayout() {
        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, AppConstant.GRID_PADDING, r.getDisplayMetrics());
        columnWidth = (int) ((utils.getScreenWidth() - ((AppConstant.NUM_OF_COLUMNS + 1) * padding)) / AppConstant.NUM_OF_COLUMNS);
 
        gridView.setNumColumns(AppConstant.NUM_OF_COLUMNS);
        gridView.setColumnWidth(columnWidth);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setPadding((int) padding, (int) padding, (int) padding, (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);
    }
}
