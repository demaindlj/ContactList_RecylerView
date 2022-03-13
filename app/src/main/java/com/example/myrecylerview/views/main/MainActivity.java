package com.example.myrecylerview.views.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myrecylerview.R;
import com.example.myrecylerview.adapter.contactAdapter;
import com.example.myrecylerview.model.Contact;
import com.example.myrecylerview.views.detailcontact.DetailContactActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int[] contactImg = {

            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,
            R.drawable.ic_baseline_person_24,


    };


    private final String[] contactName = {

            "Jono",
            "Joni",
            "Jona",
            "Tono",
            "tino",
            "jean",
            "pol",
            "ayaka",
            "ayato",
            "pipel",
            "rudi",
            "qwerty",
            "Loke",

    };


    private final String[]phonenumber = {

            "2342342",
            "63456346",
            "342q35",
            "34737463",
            "2342336",
            "676246",
            "2342365",
            "76547567",
            "3456346",
            "536636",
            "356356",
            "3453453",
            "3463463",


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //list constact
        ArrayList<Contact> Contacts = new ArrayList<Contact>();
        //init copntact adapter
        contactAdapter adapter =  new contactAdapter();

        RecyclerView rvcontact = findViewById(R.id.rv_contact);

        getSupportActionBar().setTitle("My ContactList");
        for (int i = 0; i < contactName.length; i++) {

            Contact contact =  new Contact(
                    contactName[i],
                    phonenumber[i],
                    contactImg[i]
            );

            Contacts.add(contact);
        }
        //set data contact adapter
        adapter.setData(Contacts);


        rvcontact.setAdapter(adapter);


        //onclick
        adapter.onClick(new contactAdapter.ItemClickListener() {
            @Override
            public void onClick(Contact contact) {
                Intent intent =  new Intent(MainActivity.this , DetailContactActivity.class);
                intent.putExtra(DetailContactActivity.EXTRA_CONTACT , contact);
                startActivity(intent);
            }
        });

    }
}