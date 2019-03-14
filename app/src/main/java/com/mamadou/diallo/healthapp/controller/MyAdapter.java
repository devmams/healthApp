package com.mamadou.diallo.healthapp.controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
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
import com.mamadou.diallo.healthapp.model.DisponibiliteHelper;
import com.mamadou.diallo.healthapp.model.Utilisateur;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {



   // private final List<Pair<String, String>> characters = Arrays.asList(


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




//    public List<String> list = new ArrayList<>();

    public List<Disponibilite> list;
    final DisponibiliteHelper disponibiliteHelper;
    public Context context;

    public MyAdapter(Context cont){
        context = cont;
        disponibiliteHelper = new DisponibiliteHelper(cont);
        list = disponibiliteHelper.getNextUserDisponibilite(LoginActivity.getUserConnecter().getId());
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
        final Disponibilite item = list.get(position);
        holder.mMedecin.setText(item.getMedecin().getNomMedecin()+ " " +item.getMedecin().getPrenomMedecin());
        //holder.mSpecialite.setText("ma specialité");
        holder.mSpecialite.setText(item.getMedecin().getSpecialiteMedecin().getLibelleSpecialite());
        Calendar cal = Calendar.getInstance();
        cal.setTime(item.getDate());
        cal.add(Calendar.MONTH,-1);

        long d = cal.getTime().getTime();


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String strDate = dateFormat.format(d);
        holder.mMotif.setText("Pas precisé");
        holder.mDate.setText(strDate);
    }

    public void removeItem(int position) {
        notifyItemRangeChanged(position, list.size());
        Disponibilite d = list.get(position);
        Utilisateur.annulerRdv(context,d.getId());
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

        }

    }

}