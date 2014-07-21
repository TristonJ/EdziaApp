package com.seo.ezdia.seoapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.seo.ezdia.seoapp.R;

public class Submit_Activity extends Activity implements View.OnClickListener{

    long upperBounds = 0;
    long lowerBounds = 0;

    String name, terms;

    EditText et_campaign;
    EditText et_terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_);


        et_campaign = (EditText) findViewById(R.id.et_submit_campaign_name);
        et_terms = (EditText) findViewById(R.id.et_submit_research_term);

        TextView tv_attachment = (TextView) findViewById(R.id.tv_submit_attatchment);
        TextView tv_more_info = (TextView) findViewById(R.id.tv_submit_more_info);
        tv_attachment.setOnClickListener(this);
        tv_more_info.setOnClickListener(this);

        Button bt_submit = (Button) findViewById(R.id.bt_submit_submit);
        bt_submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.tv_submit_attatchment:
                //Add an attachment to the terms
                break;
            case R.id.tv_submit_more_info:
                //Takes the user to the add more info screen
                addInfo();
                break;
            case R.id.bt_submit_submit:
                //Submit the info and go to order screen
                Intent i = new Intent(Submit_Activity.this, Order_Activity.class);
                startActivity(i);
                this.finish();
                break;

            //Add Info Screen
            case R.id.tv_add_info_cancel:
                upperBounds = 0; lowerBounds = 0;
                setContentView(R.layout.activity_submit_);
                break;
            case R.id.bt_add_info_done:
                EditText et_upper = (EditText) findViewById(R.id.et_add_info_ams_upper);
                EditText et_lower = (EditText) findViewById(R.id.et_add_info_ams_lower);
                upperBounds = Long.valueOf(et_upper.getText().toString());
                lowerBounds = Long.valueOf(et_lower.getText().toString());

                setContentView(R.layout.activity_submit_);

                et_campaign.setText(name);
                et_terms.setText(terms);
                break;
        }
    }

    private void addInfo(){
        name = et_campaign.getText().toString();
        terms = et_terms.getText().toString();

        setContentView(R.layout.add_info_);

        TextView tv_cancel = (TextView) findViewById(R.id.tv_add_info_cancel);
        Button done = (Button) findViewById(R.id.bt_add_info_done);

        tv_cancel.setOnClickListener(this);
        done.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.submit_, menu);
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
