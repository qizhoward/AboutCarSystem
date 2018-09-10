package com.example.q.myjavacarsystem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView;

import com.example.q.myjavacarsystem.tabtest.Tab01;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class mainActivity extends AppCompatActivity {

        private TextView mTextMessage;
        FloatingActionMenu menu2;
        private static final int REQUEST_IMAGE = 2;
        private static long lastBackTime = 0;
        private final int BACK_INTERVAL = 1000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.acitvity_main);

             initView();

             mTextMessage = (TextView) findViewById(R.id.message);
             BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
             navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        }
        private void initView() {

            findViewById(R.id.menu21).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            findViewById(R.id.menu22).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    }
            });
            findViewById(R.id.menu23).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
            findViewById(R.id.menu24).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mainActivity.this.getApplication(), maptest.class);
                    startActivity(intent);
                }
            });
            findViewById(R.id.menu25).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
            findViewById(R.id.menu26).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
            findViewById(R.id.menu27).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
            findViewById(R.id.menu28).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mainActivity.this.getApplication(), Tab01.class);
                    startActivity(intent);
                }
            });
            findViewById(R.id.menu29).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mainActivity.this.getApplication(), drawmapedit.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public void onBackPressed() {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastBackTime < BACK_INTERVAL) {
                super.onBackPressed();
            } else {
            showToast("双击 back 退出");
            }
            lastBackTime = currentTime;
        }
        private void showToast(String str) { Toast.makeText(this, str, Toast.LENGTH_SHORT).show(); }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add("I writing some Setting");
        MenuItem actionItem = menu.add("Action Button");
        actionItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        actionItem.setIcon(android.R.drawable.ic_menu_share);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            super.onOptionsItemSelected(item);
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "分享到..."));

            switch(item.getItemId()) //得到被点击的item的itemId
            {

                //TODO: the menu title and setting
                case R.id.SDK :
                    Uri sdk = Uri.parse("https://github.com/qizhoward/AboutCarSystem/edit/master/README.md");
                    Intent sd = new Intent(Intent.ACTION_VIEW, sdk);
                    startActivity(sd);
                    break;

                case R.id.aboutme :
                    Uri uri = Uri.parse("https://github.com/qizhoward");
                    Intent it = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(it);
                    break;

                case R.id.aboutfriends :
                    Uri az = Uri.parse("https://user.qzone.qq.com/1152629941/main");
                     Intent Zone = new Intent(Intent.ACTION_VIEW,az);
                    startActivity(Zone);
                    break;

                case R.id.myotherapps:
                    Uri ap = Uri.parse("https://github.com/qizhoward?tab=repositories");
                    Intent i = new Intent(Intent.ACTION_VIEW, ap);
                    startActivity(i);
                    break;

                case R.id.AOV:
                    Uri aov = Uri.parse("https://github.com/qizhoward?tab=repositories");
                    Intent o = new Intent(Intent.ACTION_VIEW, aov);
                    startActivity(o);
                break;

                case R.id.ATV:
                    Uri atv = Uri.parse("https://github.com/qizhoward?tab=repositories");
                    Intent t = new Intent(Intent.ACTION_VIEW, atv);
                    startActivity(t);
                    break;

                case R.id.ANV:
                    Uri anv = Uri.parse("https://github.com/qizhoward?tab=repositories");
                    Intent n = new Intent(Intent.ACTION_VIEW, anv);
                    startActivity(n);
                    break;

            }
            return true;

        }

        private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        mTextMessage.setText(R.string.title_home);
                        return true;
                    case R.id.navigation_dashboard:
                        mTextMessage.setText(R.string.title_dashboard);
                        return true;
                    case R.id.navigation_notifications:
                        mTextMessage.setText(R.string.title_notifications);
                        return true;
                }
                return false;
            }
        };


}


