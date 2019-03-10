package com.mamadou.diallo.healthapp.controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mamadou.diallo.healthapp.R;
import com.mamadou.diallo.healthapp.model.Disponibilite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {



//    public static List<Pair<String, String>> characters = Arrays.asList(
//            Pair.create("Lyra Belacqua", "Brave, curious, and crafty, she has been prophesied by the witches to help the balance of life"),
//            Pair.create("Pantalaimon", "Lyra's daemon, nicknamed Pan."),
//            Pair.create("Roger Parslow", "Lyra's friends"),
//            Pair.create("Lord Asriel", "Lyra's uncle"),
//            Pair.create("Marisa Coulter", "Intelligent and beautiful, but extremely ruthless and callous."),
//            Pair.create("Iorek Byrnison", "Armoured bear, Rightful king of the panserbjørne. Reduced to a slave of the human village Trollesund."),
//            Pair.create("Serafina Pekkala", "Witch who closely follows Lyra on her travels."),
//            Pair.create("Lee Scoresby", "Texan aeronaut who transports Lyra in his balloon. Good friend with Iorek Byrnison."),
//            Pair.create("Ma Costa", "Gyptian woman whose son, Billy Costa is abducted by the \"Gobblers\"."),
//            Pair.create("John Faa", "The King of all gyptian people.")
//    );

    public ArrayList<String> list = new ArrayList<>();

    public MyAdapter(){
        list.add("DIALLO");
        list.add("MAMADOU");
        list.add("OUSMANE");
        list.add("OLIVE");
        list.add("YASSINE");
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final String item = list.get(position);

        holder.mMedecin.setText(item);
    }

    public void removeItem(int position) {

        notifyItemRangeChanged(position, list.size());
        list.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout relativeLayout;
        public ImageView editImage;
        public ImageView deleteImage;

        public TextView mMedecin;
        public TextView mSpecialite;
        public TextView mMotif;
        public TextView mDate;

        private Pair<String, String> currentPair;

        public MyViewHolder(final View itemView) {
            super(itemView);

            mMedecin = (TextView) itemView.findViewById(R.id.medecin);
            mSpecialite = (TextView) itemView.findViewById(R.id.specialite);
            mMotif = (TextView) itemView.findViewById(R.id.motif);
            mDate = (TextView) itemView.findViewById(R.id.date);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle("ddff")
                            .setMessage("ddd")
                            .show();
                }
            });

        }

    }

}