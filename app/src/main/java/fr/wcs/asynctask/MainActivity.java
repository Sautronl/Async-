package fr.wcs.asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private boolean isLiftMoving = false;
    private int currentFloor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button zero = (Button) findViewById(R.id.zero);
        Button un = (Button) findViewById(R.id.un);
        Button deux = (Button) findViewById(R.id.deux);
        Button trois = (Button) findViewById(R.id.trois);
        Button quatre = (Button) findViewById(R.id.quatre);
        Button cinq = (Button) findViewById(R.id.cinq);
        Button six = (Button) findViewById(R.id.six);
        Button sept = (Button) findViewById(R.id.sept);
        Button huit = (Button) findViewById(R.id.huit);
        Button neuf = (Button) findViewById(R.id.neuf);


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFloor(0);
            }
        });
        un.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFloor(1);
            }
        });
        deux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFloor(2);
            }
        });
        trois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFloor(3);
            }
        });
        quatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFloor(4);
            }
        });
        cinq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFloor(5);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFloor(6);
            }
        });
        sept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFloor(7);
            }
        });
        huit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFloor(8);
            }
        });
        neuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFloor(9);
            }
        });
    }

    private void goToFloor(int floor) {
        if (!isLiftMoving && floor != currentFloor) {
            moveNextFloor(floor);
            isLiftMoving = false;

        }
    }

    private void moveNextFloor(int floor) {
        if (floor != currentFloor) {
            new MoveLift().execute(floor);
        }
    }


    private class MoveLift extends AsyncTask<Integer, Void,Integer> {

        @Override
        protected Integer doInBackground(Integer... integers) {
            Integer floor = integers[0];
            SystemClock.sleep(3000);
            return floor;
        }

        @Override
        protected void onPostExecute(Integer floor) {
            isLiftMoving = true;
            currentFloor = (floor > currentFloor) ? currentFloor + 1 : currentFloor - 1;
            TextView floorCount = (TextView) findViewById(R.id.floor_count);
            floorCount.setText(String.valueOf(currentFloor));
            moveNextFloor(floor);
            isLiftMoving = false;
        }
    }
}

