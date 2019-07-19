package com.example.user.myapplication;

import android.content.DialogInterface;
import android.net.wifi.aware.PublishConfig;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Account extends AppCompatActivity {

    TextView tv,FN,DEP,DES,PH,Pass,HD,Add,City,Coun;
    public String ab2;
    String Enter,Reenter;
    CardView Emailcard,Phonecard,Passwordcard,Addresscard;
    DatabaseReference databaseRef2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        tv=(TextView)findViewById(R.id.textViewEm) ;
        Emailcard=(CardView)findViewById(R.id.Emailcard);
        Phonecard=(CardView)findViewById(R.id.Phonecard);
        Passwordcard=(CardView)findViewById(R.id.Passwordcard);
        Addresscard=(CardView)findViewById(R.id.Addresscard);
       FN=(TextView)findViewById(R.id.textViewFN);
        DEP=(TextView)findViewById(R.id.textViewDep);
        DES=(TextView)findViewById(R.id.textViewDes);
        PH=(TextView)findViewById(R.id.textViewPh);
        Add=(TextView)findViewById(R.id.textViewAddress);
        City=(TextView)findViewById(R.id.textViewCity);
        Coun=(TextView)findViewById(R.id.textViewCountry);
        Pass=(TextView)findViewById(R.id.textViewPassword);
        HD=(TextView)findViewById(R.id.textViewHD);

        newtab newtab=new newtab();
        tv.setText(getIntent().getExtras().getString("id"));
        ab2=tv.getText().toString();
        databaseRef2= FirebaseDatabase.getInstance().getReference("Employees").child(ab2);
        databaseRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserInfoD ud=dataSnapshot.getValue(UserInfoD.class);
                FN.setText(ud.getFullname());
                DEP.setText(ud.getDepartment());
                DES.setText(ud.getDesignation());
                PH.setText(ud.getPhone());
                Pass.setText(ud.getPassword());
                tv.setText(ud.getEmail());
                Add.setText(ud.getAddress());
                City.setText(ud.getCity());
                Coun.setText(ud.getCountry());
                HD.setText(ud.getHireDate());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //EditInDatbase

        Phonecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert=new AlertDialog.Builder(Account.this);
                LayoutInflater layoutInflater=getLayoutInflater();
                View v =layoutInflater.inflate(R.layout.infoedit,null);
                alert.setView(v);
                alert.setTitle("Save your new contact no");
                alert.setIcon(R.drawable.ic_call_end_black_24dp);

                Enter=v.findViewById(R.id.Enter).toString();
                Reenter=v.findViewById(R.id.Reenter).toString();
                alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(Enter == Reenter){
                            Toast.makeText(Account.this,"testing",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Account.this,"testing fail",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                alert.show();
            }
        });

        Emailcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert=new AlertDialog.Builder(Account.this);
                LayoutInflater layoutInflater=getLayoutInflater();
                View v =layoutInflater.inflate(R.layout.infoedit,null);
                alert.setView(v);
                alert.setTitle("Edit your Email id");
                alert.setIcon(R.drawable.ic_email_black_24dp);

                Enter=v.findViewById(R.id.Enter).toString();
                Reenter=v.findViewById(R.id.Reenter).toString();
                alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(Enter == Reenter){

                        }
                        else {

                        }
                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                alert.show();

            }
        });
                Passwordcard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder alert=new AlertDialog.Builder(Account.this);
                        LayoutInflater layoutInflater=getLayoutInflater();
                        View v =layoutInflater.inflate(R.layout.infoedit,null);
                        alert.setView(v);
                        alert.setTitle("Edit your Password here");
                        alert.setIcon(R.drawable.ic_https_black_24dp);

                        Enter=v.findViewById(R.id.Enter).toString();
                        Reenter=v.findViewById(R.id.Reenter).toString();
                        alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(Enter == Reenter){

                                }
                                else {

                                }
                            }
                        });
                        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                        alert.show();

                    }
                });

                Addresscard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder alert=new AlertDialog.Builder(Account.this);
                        LayoutInflater layoutInflater=getLayoutInflater();
                        View v =layoutInflater.inflate(R.layout.infoedit,null);
                        alert.setView(v);
                        alert.setTitle("Edit your Address");
                        alert.setIcon(R.drawable.ic_home_black_24dp);
                        Enter=v.findViewById(R.id.Enter).toString();
                        Reenter=v.findViewById(R.id.Reenter).toString();
                        alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(Enter == Reenter){

                                }
                                else {

                                }
                            }
                        });
                        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                        alert.show();

                    }
                });
    }



}
