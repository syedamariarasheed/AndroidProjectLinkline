package com.example.user.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public String ch;
    MaterialEditText edtNewcompanyid;
    MaterialEditText edtNewusername,edtemaill,edtdesignationn,edtdepartmentt,edtphonee,edtpasswordd; //sign Up
   MaterialEditText  companyid,password; //sign in
    Button btnSignup,btnSignin;
    FirebaseDatabase database;
    DatabaseReference users;

    String count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        users=database.getReference("Employees");


        companyid=(MaterialEditText)findViewById(R.id.edtCompanyId);
        password=(MaterialEditText)findViewById(R.id.edtpassword1);
        btnSignin=(Button)findViewById(R.id.btn_signIn);
      //  btnSignup=(Button)findViewById(R.id.btn_signUp);
      /*  btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSignUpDialog();
            }
        }); */

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    signin(companyid.getText().toString(), password.getText().toString());

            }
        });
    }
     private void signin(final String cid,final String pwd){
        users.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                 if (dataSnapshot.child(cid).exists()) {
                        if (!cid.isEmpty()) {
                            UserInfoD login = dataSnapshot.child(cid).getValue(UserInfoD.class);
                            if (login.getPassword().equals(pwd)) {

                                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                // startActivity(new Intent(MainActivity.this,newtab.class));
                                //Intent intent=new Intent(MainActivity.this,newtab.class);


                                Intent intent = new Intent(MainActivity.this, newtab.class);
                                intent.putExtra("id", companyid.getText().toString());
                                startActivity(intent);

                            } else {
                                Toast.makeText(MainActivity.this, "Please enter the correct password", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter Company ID", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "User not found Click Register Button", Toast.LENGTH_SHORT).show();
                    }

                }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

     }
   /* public void showSignUpDialog(){

        AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Sign Up");
        alert.setMessage("Please fill full information");

        LayoutInflater inflater=this.getLayoutInflater();
        View sign_up=inflater.inflate(R.layout.sign_up,null);

        edtNewcompanyid=(MaterialEditText)sign_up.findViewById(R.id.edtNewCompanyId);
        edtNewusername=(MaterialEditText)sign_up.findViewById(R.id.edtNewUserName);
        edtemaill=(MaterialEditText)sign_up.findViewById(R.id.edtEmail);
        edtdesignationn=(MaterialEditText)sign_up.findViewById(R.id.edtDesignation);
        edtdepartmentt=(MaterialEditText)sign_up.findViewById(R.id.edtDepartment);
        edtphonee=(MaterialEditText)sign_up.findViewById(R.id.edtPhone);
        edtpasswordd=(MaterialEditText)sign_up.findViewById(R.id.edtPassword);

        alert.setView(sign_up);
        alert.setIcon(R.drawable.ic_account_circle_black_24dp);
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

  alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialogInterface, int i) {
                    final UserInfoD userInfoD=new UserInfoD(edtNewcompanyid.getText().toString(),
                            edtNewusername.getText().toString(),
                            edtemaill.getText().toString(),
                            edtdesignationn.getText().toString(),
                            edtdepartmentt.getText().toString(),
                            edtphonee.getText().toString(),
                            edtpasswordd.getText().toString());


                       users.addListenerForSingleValueEvent(new ValueEventListener() {
                           @Override
                           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                               if (dataSnapshot.child(userInfoD.getCompanyId().toString()).exists()) {
                                   Toast.makeText(MainActivity.this, "User already exist", Toast.LENGTH_SHORT).show();
                               }
                               else { //validation
                                   String ab = edtemaill.toString();
                                   if (!Patterns.EMAIL_ADDRESS.matcher(ab).matches()) {
                                       Toast.makeText(MainActivity.this, "Enter valid email id", Toast.LENGTH_SHORT).show();
                                        count="000";
                                   }
                                   else
                                       {
                                       users.child(userInfoD.getCompanyId().toString())
                                               .setValue(userInfoD);
                                       Toast.makeText(MainActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                                       count="111";
                                   }
                               }
                           }

                           @Override
                           public void onCancelled(@NonNull DatabaseError databaseError) {

                           }
                       });
                    dialogInterface.dismiss();
            }
        });
        alert.show();

    }*/


}