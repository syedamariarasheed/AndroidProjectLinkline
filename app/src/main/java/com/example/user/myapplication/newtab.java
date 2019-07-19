package com.example.user.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class newtab extends AppCompatActivity {

    Dialog dialog;
    FloatingActionButton floatingActionButton;
    CardView event,Message;
    CardView Account;
    TextView Ch;
    public String ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtab);
        Ch=(TextView)findViewById(R.id.ch);
        floatingActionButton =(FloatingActionButton)findViewById(R.id.floating);
        MainActivity mainActivity=new MainActivity();
     Ch.setText(getIntent().getExtras().getString("id"));
     ab=Ch.getText().toString();
       // Ch2.setText(ab);
        dialog =new Dialog(this);
        Message=(CardView)findViewById(R.id.cdMessage);
        event = (CardView)findViewById(R.id.cdEvent);
        Account=(CardView)findViewById(R.id.cdAccount);
         Message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageAct();
            }
        });

//Remaining
         floatingActionButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });
    }
    public void eventact(View view){
        startActivity(new Intent(newtab.this,event.class));

    }


    private void MessageAct(){
       /* AlertDialog.Builder alert=new AlertDialog.Builder(newtab.this);
        alert.setTitle("Message portal");
        alert.setMessage("Hello ! you can send your relevent message and recieve messages from your company as well Have a good day.");
        LayoutInflater inflater=this.getLayoutInflater();
        View sign_upp=inflater.inflate(R.layout.sign_up,null);
        alert.setView(sign_upp);
        alert.setIcon(R.drawable.ic_message_black_24dp);*/
       dialog.setContentView(R.layout.sign_up);

    }


    public void Accountact(View view){
      // startActivity(new Intent(newtab.this,Account.class));

        Intent intent=new Intent(newtab.this,Account.class);
        intent.putExtra("id",ab);
        startActivity(intent);


    }
}
