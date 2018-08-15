package com.example.vedantgote.simpledice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;
import android.os.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    Random r = new Random();
    Handler h = new Handler();
    public int p1s=0;
    public int p2s=0;
    public int fl=1;
    EditText ed1,ed2;
    String s1,s2;
    Button b1,b2;
    final Integer img[] = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six};
    final String s[]={"one!","two!","three!","four!","five!","six!"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        iv.setImageResource(R.drawable.dice3droll);
        ed1= (EditText)findViewById(R.id.ed1);
        ed2= (EditText)findViewById(R.id.ed2);
        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);

        }

        //assuming player 1 starts
        public void onroll(View v)
        {
            int i = r.nextInt(6);
            iv.setImageResource(img[i]);
            if(i==0)
            {
                if(fl==1)
                {   fl=2;
                    p1s=0;
                    s1=Integer.toString(p1s);
                    ed1.setText(s1);
                }
                else
                {   fl=1;
                    p2s=0;
                    s2=Integer.toString(p2s);
                    ed2.setText(s2);}

            }
            else
            {
                if(fl==1)
                {
                p1s=p1s+(i+1);
                    s1=Integer.toString(p1s);
                    ed1.setText(s1);
                }
                if(fl==2)
                {
                    p2s=p2s + (i+1);
                    s2=Integer.toString(p2s);
                    ed2.setText(s2);
                }
            }
            if(p1s>=100)
            {
                Toast.makeText(MainActivity.this,"PLAYER 1 WINS!!!",Toast.LENGTH_LONG).show();
                ed1.setText("0");
                ed2.setText("0");
                Toast.makeText(MainActivity.this,"NEW GAME!!",Toast.LENGTH_LONG).show();
            }
            if(p2s>=100)
            {
                Toast.makeText(MainActivity.this,"PLAYER 2 WINS!!!",Toast.LENGTH_LONG).show();
                ed1.setText("0");
                ed2.setText("0");
                Toast.makeText(MainActivity.this,"NEW GAME!!",Toast.LENGTH_LONG).show();
            }


        }
        public void onhold(View v)
        {
            if(fl==1)
            {
                fl=2;
            }
            else
            {
                fl=1;
            }
        }
        /*iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = r.nextInt(6);
                /*for(int j=0;j<=i;j++)
                {
                    final int k=j;
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageResource(img[k]);
                            h.postDelayed(this,2000);
                        }
                    };
                    h.postDelayed(r,2000);
                }
                String ss = s[i];
                Toast.makeText(MainActivity.this,ss,Toast.LENGTH_LONG).show();

            }
        });*/

    }





