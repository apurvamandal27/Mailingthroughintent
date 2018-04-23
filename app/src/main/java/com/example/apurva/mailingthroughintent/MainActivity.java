package com.example.apurva.mailingthroughintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText to,subject,msg;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to=findViewById(R.id.to);
        subject=findViewById(R.id.subject);
        msg=findViewById(R.id.message);
        send=findViewById(R.id.send);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e1=to.getText().toString();
                String e2=subject.getText().toString();
                String e3=msg.getText().toString();


                String toMail[]={e1};
                sendMessage(toMail,e2,e3);
            }
        });
    }

    public void sendMessage(String[] to,String sub,String msg){

        Intent intent=new Intent(Intent.ACTION_SEND);

        intent.setData(Uri.parse("mailto:"));

        intent.putExtra(Intent.EXTRA_EMAIL,to);
        intent.putExtra(Intent.EXTRA_SUBJECT,sub);
        intent.putExtra(Intent.EXTRA_TEXT,msg);

        intent.setType("message/utf-8");

        startActivity(Intent.createChooser(intent,"Email"));
    }
}
