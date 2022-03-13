package com.example.myrecylerview.views.detailcontact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myrecylerview.R;
import com.example.myrecylerview.model.Contact;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailContactActivity extends AppCompatActivity {

    public static final String EXTRA_CONTACT = "extra_contact";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        //supportactionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CircleImageView iv_Contact_Detail = findViewById(R.id.iv_contact_detail);
        TextView tv_Contact_Detail = findViewById(R.id.tv_name_detail);
        TextView tv_Contact_number = findViewById(R.id.tv_mobile_number);
        Button btn_call = findViewById(R.id.button_call);

        Contact contact = null;

        if (getIntent() !=  null){
            contact =  getIntent().getParcelableExtra(EXTRA_CONTACT);
        }

        if (contact != null){
            iv_Contact_Detail.setImageResource(contact.getGambar());
            tv_Contact_Detail.setText(contact.getNama());
            tv_Contact_number.setText(contact.getTelp());
            String phonenumber = contact.getTelp();


            //Onclick
            btn_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =  new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+ phonenumber));
                    startActivity(intent);
                }
            });


        }




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}


