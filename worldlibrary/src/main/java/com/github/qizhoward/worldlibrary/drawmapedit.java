package com.github.qizhoward.worldlibrary;

import android.app.Activity;
import android.os.Bundle;

class drawmapedit extends Activity{

    private OpenGLView openGLView;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        openGLView = (OpenGLView) findViewById(R.id.openGLView);
    }

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
