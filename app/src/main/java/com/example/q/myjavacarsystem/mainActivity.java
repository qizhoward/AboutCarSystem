package com.example.q.myjavacarsystem;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.q.myjavacarsystem.opengl.OpenGLView;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class mainActivity extends AppCompatActivity {

        private TextView mTextMessage;
        FloatingActionMenu menu2;
        private GLSurfaceView mGLView;
        private FloatingActionButton fab1;
        private FloatingActionButton fab2;
        private FloatingActionButton fab3;
        private static final int REQUEST_IMAGE = 2;
        private static long lastBackTime = 0;
        private final int BACK_INTERVAL = 1000;
        private Context mContext;
        private OpenGLView openGLView;


        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.acitvity_main);
             mContext = this;



             openGLView = (OpenGLView)findViewById(R.id.openGLView3);


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

            findViewById(R.id.fab1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            findViewById(R.id.fab2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    fab2.setVisibility(View.GONE);
                }
            });
            findViewById(R.id.fab3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fab3.setVisibility(View.VISIBLE);
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


        @Override
        protected void onResume(){
            super.onResume();
            openGLView.onResume();
        }
        @Override
        protected void onPause(){
            super.onPause();
            openGLView.onPause();
        }
}


