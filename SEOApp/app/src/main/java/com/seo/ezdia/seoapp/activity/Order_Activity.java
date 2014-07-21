package com.seo.ezdia.seoapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seo.ezdia.seoapp.R;
import com.seo.ezdia.seoapp.utils.OnSwipeTouchListener;

public class Order_Activity extends Activity implements View.OnClickListener{

    TextView tv_primary_status;
    TextView tv_primary_targeted_status;
    TextView tv_secondary_status;
    TextView tv_title;
    TextView tv_campaign_name;
    ImageView iv_campaign_status;
    ImageView iv_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_);

        //Implement a swipe listener
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl_order);
        rl.setOnTouchListener(new OnSwipeTouchListener(){
            public void onSwipeLeft(){/*Do left action*/}
            public void onSwipeRight(){/*Do right action*/}
        });

        //Normally get data and THEN set the values of all the views
        iv_icon = (ImageView) findViewById(R.id.iv_order_icon);
        iv_campaign_status = (ImageView) findViewById(R.id.iv_order_campaign_status);
        tv_campaign_name = (TextView) findViewById(R.id.tv_order_campaign_name);
        tv_title = (TextView) findViewById(R.id.tv_order_item);
        tv_primary_status = (TextView) findViewById(R.id.tv_order_primary_status);
        tv_primary_targeted_status = (TextView) findViewById(R.id.tv_order_primary_targeted_status);
        tv_secondary_status = (TextView) findViewById(R.id.tv_order_secondary_status);

        iv_icon.setOnClickListener(this);

        //TODO
        //Set an on swipe listener to detect when the user swipes, and switch the campaign if available.
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.iv_order_icon:
                Intent i = new Intent(Order_Activity.this, Submit_Activity.class);
                startActivity(i);
                this.finish();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.order_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
