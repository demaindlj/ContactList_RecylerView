package com.example.myrecylerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecylerview.R;
import com.example.myrecylerview.model.Contact;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class contactAdapter extends RecyclerView.Adapter<contactAdapter.ViewHolder> {

    private ArrayList<Contact> Contacts =  new ArrayList<>();
    private ItemClickListener itemClickListener;








    public interface ItemClickListener {

        void onClick(Contact contact);

    }

    public void onClick(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bindItem(Contacts.get(position), itemClickListener);

    }

    @Override
    public int getItemCount() {
        return Contacts.size();
    }

    public void setData(ArrayList<Contact> Contacts){

        this.Contacts = Contacts;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final CircleImageView ivContact;
        private final TextView tvContact;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivContact = itemView.findViewById(R.id.iv_contact);
            tvContact = itemView.findViewById(R.id.tv_name_contact);

        }

        public void bindItem(Contact contact, ItemClickListener itemClickListener) {

            ivContact.setImageResource(contact.getGambar());
            tvContact.setText(contact.getNama());



            if (itemClickListener != null ){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemClickListener.onClick(contact);
                    }
                });
            }


        }
    }
}
