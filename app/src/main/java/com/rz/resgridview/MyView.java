package com.rz.resgridview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    public static Bitmap HairBitmap;
    public static float bottom1;
    public static float left1;
    public static Bitmap myBitmap;
    public static Bitmap resultBmp;
    public static float right1;
    public static float top1;
    private int NUMBER_OF_FACES;
    int NUMBER_OF_FACE_DETECTED;
    private int bm_ox;
    private int bm_oy;
    private boolean bm_touched;
    private int bm_x;
    private int bm_y;
    private Face[] detectedFaces;
    private float eyeDistance;
    public Face face1;
    private FaceDetector faceDetector;
    private int f3h;
    private int h1;
    private float mAspectQuotient;
    public PointF midPoint1;
    public Paint myPaint;
    private int f4w;
    private int w1;
    float f5x;
    float f6y;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.NUMBER_OF_FACES = 10;
        this.bm_touched = false;
        new Options().inPreferredConfig = Config.RGB_565;
    }

    private void calculateAspectQuotient() {
        if (myBitmap != null) {
            this.mAspectQuotient = (((float) myBitmap.getWidth()) / ((float) myBitmap.getHeight())) / (((float) getWidth()) / ((float) getHeight()));
        }
    }

    protected void onDraw(Canvas canvas) {
        if (myBitmap != null) {
            this.f4w = myBitmap.getWidth();
            this.f3h = myBitmap.getHeight();
            if (!(resultBmp == null || resultBmp.isRecycled())) {
                resultBmp.recycle();
                resultBmp = null;
                System.gc();
            }
            //int heightofBitMap = (this.f3h * HomePageActivity.screenWidth) / this.f4w;
            int heightofBitMap = (this.f3h * 500) / this.f4w;
            canvas.drawBitmap(resultBmp, 0.0f, 0.0f, null);
        }
    }
}
