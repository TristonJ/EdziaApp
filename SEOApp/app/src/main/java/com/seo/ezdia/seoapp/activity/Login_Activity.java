package com.seo.ezdia.seoapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.seo.ezdia.seoapp.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Login_Activity extends Activity implements View.OnClickListener {

    EditText et_name;
    EditText et_email;
    EditText et_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        et_name = (EditText) findViewById(R.id.et_login_name);
        et_email = (EditText) findViewById(R.id.et_login_email);
        et_phone = (EditText) findViewById(R.id.et_login_phone_number);

        Button next = (Button) findViewById(R.id.bt_login_next);
        next.setOnClickListener(this);

        TextView tv_contact = (TextView) findViewById(R.id.tv_login_contact_us);
        TextView tv_share = (TextView) findViewById(R.id.tv_login_share);
        tv_contact.setOnClickListener(this);
        tv_share.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bt_login_next:
                try{
                    String link = "http://asdasd.thesqlserver.com/phpscript.php?name="+
                            et_name.getText().toString() + "&email="+et_email.getText().toString() +
                            "&phone="+et_phone.getText().toString();
                    URL url = new URL(link);
                    HttpClient client = new DefaultHttpClient();
                    HttpGet request = new HttpGet();
                    request.setURI(new URI(link));
                    HttpResponse response = client.execute(request);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(response.getEntity().getContent()));
                    StringBuffer sb = new StringBuffer("");
                    String line = "";
                    while ((line = in.readLine()) != null){
                        sb.append(line);
                        break;
                    }
                    in.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                //Proceed to next screen and maybe submit data??
                Intent submitScreen = new Intent(Login_Activity.this, Submit_Activity.class);
                //If needed  use "putExtra" to pass over whatever data necessary
                startActivity(submitScreen);
                this.finish();
                break;

            case R.id.tv_login_contact_us:
                //Open the users default email app with a pre-populated email
                Intent i = new Intent(Intent.ACTION_SEND);

                i.setType("plain/text");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{
                        getString(R.string.contact_us_recipient_)});
                i.putExtra(Intent.EXTRA_SUBJECT, new String[]{
                        getString(R.string.contact_us_subject_ )});
                i.putExtra(Intent.EXTRA_TEXT, getString(R.string.contact_us_prepopulated_message_));
                startActivity(Intent.createChooser(i, "Send mail..."));
                break;

            case R.id.tv_login_share:
                //Open the users default email app with an email for sharing
                Intent j = new Intent(Intent.ACTION_SEND);

                j.setType("plain/text");
                j.putExtra(Intent.EXTRA_SUBJECT, new String[]{
                        getString(R.string.share_app_subject_)});
                j.putExtra(Intent.EXTRA_TEXT, new String[]{
                        getString(R.string.share_app_message_)});

                startActivity(Intent.createChooser(j, "Send mail..."));
                break;
        }
    }

}
