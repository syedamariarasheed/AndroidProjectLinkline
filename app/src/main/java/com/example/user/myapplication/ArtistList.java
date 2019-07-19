package com.example.user.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.List;

public class ArtistList extends ArrayAdapter<Artist> {
    private Activity context;
    private List<Artist> artistList;
    Button open;
    ExpandableRelativeLayout mycontent;

    public ArtistList(Activity context,List<Artist> artistList){
        super(context,R.layout.list_layout,artistList);
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.list_layout,null,true);
        this.context=context;
        this.artistList=artistList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.list_layout,null,true);
        open=(Button)listViewItem.findViewById(R.id.btninfo);
        TextView textViewevent=(TextView)listViewItem.findViewById(R.id.textViewName);
        TextView textViewDate=(TextView)listViewItem.findViewById(R.id.textViewDate);
        TextView textViewLoc=(TextView)listViewItem.findViewById(R.id.textViewLoc);
        TextView textViewOrg=(TextView)listViewItem.findViewById(R.id.textViewOr);
        TextView textViewCat=(TextView)listViewItem.findViewById(R.id.textViewCat);
        TextView textViewMin=(TextView)listViewItem.findViewById(R.id.textViewMin);
        TextView textViewRes=(TextView)listViewItem.findViewById(R.id.textViewRes);
        TextView textViewPh=(TextView)listViewItem.findViewById(R.id.textViewPh);
        final TextView textViewEmail=(TextView)listViewItem.findViewById(R.id.textViewEmail);
        TextView textViewMsg=(TextView)listViewItem.findViewById(R.id.textViewMes);
        mycontent=(ExpandableRelativeLayout)listViewItem.findViewById(R.id.myContent);

        Artist artist=artistList.get(position);

        textViewevent.setText(artist.getEN());
        textViewDate.setText(artist.getdT());
        textViewLoc.setText(artist.getLoc());
        textViewOrg.setText(artist.getOr());
        textViewCat.setText(artist.getCat());
        textViewMin.setText(artist.getMin());
        textViewRes.setText(artist.getRes());
        textViewPh.setText(artist.getPh());
        textViewEmail.setText(artist.getEmail());
        textViewMsg.setText(artist.getMes());

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mycontent.toggle();
            }
        });


        return listViewItem;


    }

}
