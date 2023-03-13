package com.example.q.myjavacarsystem.opengl;

import android.opengl.GLES30;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES30.glClearColor(0.0f,0f,0f,1f);

    }

    @Override
    public void onSurfaceChanged(GL10 gl , int width, int height) {
        GLES30.glViewport(0,0,width,height);

    }
    @Override
    public void onDrawFrame(GL10 gl10){
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT);
    }

}
