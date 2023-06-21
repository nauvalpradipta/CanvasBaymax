package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    private int mCountNumber;

    private static final int OFFSET = 120;
    private int mOffset = OFFSET;
    private static final int MULTIPLIER = 100;

    private int mColorBackground;



    private int mColorYellow;


    private int mColorBlack;
    private int mColorWhite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColorBackground = ResourcesCompat.getColor(getResources(),
                R.color.colorBackground, null);
        mColorWhite = ResourcesCompat.getColor(getResources(),
                R.color.colorWhite, null);
        mColorYellow = ResourcesCompat.getColor(getResources(),
                R.color.colorYellow, null);
        mColorBlack = ResourcesCompat.getColor(getResources(),
                R.color.colorBlack, null);

        mPaintText.setColor(ResourcesCompat.getColor(getResources(),
                R.color.black, null));
        mPaintText.setTextSize(70);

        mImageView = findViewById(R.id.myimageview);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawSomething(view);
            }
        });
    }

    public void drawSomething(View view) {
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        int halfWidth = vWidth/2;
        int halfHeight = vHeight/2;

        Point a = new Point(halfWidth, halfHeight);
        Point b = new Point(halfWidth, halfHeight);
        Point c = new Point(halfWidth, halfHeight);

        if (mOffset == OFFSET) {
            mBitmap = Bitmap.createBitmap(vWidth, vHeight,
                    Bitmap.Config.ARGB_8888);
            mImageView.setImageBitmap(mBitmap);
            mCanvas = new Canvas(mBitmap);
            mCanvas.drawColor(mColorBackground);
            mOffset += OFFSET;
        }
        else {
            switch (mCountNumber) {
                case 1:
                    //oval
                    mPaint.setColor(mColorWhite);
                    mCanvas.drawOval(new RectF(a.x-280, a.x+220, a.x+270, a.x+620), mPaint);
                    break;
                case 2:
                    //dua bulat
                    Point leftNose = new Point(a.x-100, a.y+100);
                    Point rightNose = new Point(b.x+100, b.y+100);
                    mPaint.setColor(mColorBlack);
                    mCanvas.drawCircle(leftNose.x, leftNose.y, 50, mPaint);
                    mCanvas.drawCircle(rightNose.x, rightNose.y, 50, mPaint);
                    break;
                case 3:
                    //kotak tengah
                    mPaint.setColor(mColorBlack);
                    mCanvas.drawRect(new RectF(a.x-100, a.x+410, a.x+100, a.x+440), mPaint);
            }

        }

        mCountNumber++;
        view.invalidate();
    }
}