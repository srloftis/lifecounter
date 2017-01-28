package edu.washington.srloftis.lifecounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends Activity {

    public TextView Player1;
    public TextView Player2;
    public TextView Player3;
    public TextView Player4;
    public TextView Loser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Player1 = (TextView) findViewById(R.id.Player1);
        Player2 = (TextView) findViewById(R.id.Player2);
        Player3 = (TextView) findViewById(R.id.Player3);
        Player4 = (TextView) findViewById(R.id.Player4);
        Loser = (TextView) findViewById(R.id.loser);

        findViewById(R.id.btn11).setOnClickListener(new MyListener(5, Player1, "minus"));
        findViewById(R.id.btn12).setOnClickListener(new MyListener(1, Player1, "minus"));
        findViewById(R.id.btn13).setOnClickListener(new MyListener(1, Player1, "add"));
        findViewById(R.id.btn14).setOnClickListener(new MyListener(5, Player1, "add"));

        findViewById(R.id.btn21).setOnClickListener(new MyListener(5, Player2, "minus"));
        findViewById(R.id.btn22).setOnClickListener(new MyListener(1, Player2, "minus"));
        findViewById(R.id.btn23).setOnClickListener(new MyListener(1, Player2, "add"));
        findViewById(R.id.btn24).setOnClickListener(new MyListener(5, Player2, "add"));

        findViewById(R.id.btn31).setOnClickListener(new MyListener(5, Player3, "minus"));
        findViewById(R.id.btn32).setOnClickListener(new MyListener(1, Player3, "minus"));
        findViewById(R.id.btn33).setOnClickListener(new MyListener(1, Player3, "add"));
        findViewById(R.id.btn34).setOnClickListener(new MyListener(5, Player3, "add"));

        findViewById(R.id.btn41).setOnClickListener(new MyListener(5, Player4, "minus"));
        findViewById(R.id.btn42).setOnClickListener(new MyListener(1, Player4, "minus"));
        findViewById(R.id.btn43).setOnClickListener(new MyListener(1, Player4, "add"));
        findViewById(R.id.btn44).setOnClickListener(new MyListener(5, Player4, "add"));

    }

    public class MyListener implements View.OnClickListener {
        public int lifeChange;
        public TextView playerNum;
        public String increment;

        public MyListener(int num, TextView player, String incr) {
            lifeChange = num;
            playerNum = player;
            increment = incr;
        }

        @Override
        public void onClick(View v) {
            int current = Integer.parseInt(playerNum.getText().toString());
            if (increment.equals("add"))
                playerNum.setText((current + lifeChange) + "");
            else
                playerNum.setText((current - lifeChange) + "");
            if (Integer.parseInt(Player1.getText().toString()) <= 0) {
                Loser.setText("Player 1 LOSES!");
            }
            if (Integer.parseInt(Player2.getText().toString()) <= 0) {
                Loser.setText("Player 2 LOSES!");
            }
            if (Integer.parseInt(Player3.getText().toString()) <= 0) {
                Loser.setText("Player 3 LOSES!");
            }
            if (Integer.parseInt(Player4.getText().toString()) <= 0) {
                Loser.setText("Player 4 LOSES!");
            }
        }

    }
}

