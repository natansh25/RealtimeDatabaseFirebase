package com.example.natan.firebaserealtimedatabasetake1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.natan.firebaserealtimedatabasetake1.adapter.Input;
import com.example.natan.firebaserealtimedatabasetake1.adapter.InputAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final String ANONYMOUS = "anonymous";
    public static final int DEFAULT_MSG_LENGTH_LIMIT = 1000;

    private ListView mMessageListView;

    private EditText mMessageEditText;
    private Button mSendButton;
    private InputAdapter mInputAdapter;

    private String mUsername;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the firebase components

        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference().child("messages");

        mMessageEditText=findViewById(R.id.editText);
        mSendButton=findViewById(R.id.button);
        mMessageListView=findViewById(R.id.listview);

        // setting up the listview

        List<Input> list=new ArrayList<>();
        mInputAdapter=new InputAdapter(this,R.layout.msgstyle,list);
        mMessageListView.setAdapter(mInputAdapter);





        mMessageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().trim().length() > 0) {
                    mSendButton.setEnabled(true);
                } else {
                    mSendButton.setEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Input input=new Input(mMessageEditText.getText().toString(),mUsername);
                mDatabaseReference.push().setValue(input);
                mMessageEditText.setText("");



            }
        });




    }
}
