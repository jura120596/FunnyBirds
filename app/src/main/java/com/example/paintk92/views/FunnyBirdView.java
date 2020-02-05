package com.example.paintk92.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.View;

import com.example.paintk92.R;
import com.example.paintk92.Sprite;

public class FunnyBirdView extends View {
    private int viewWidth;
    private int viewHeight;
    private int points = 0;
    private Sprite playerBird;
    private final int timerInterval = 30;
    public FunnyBirdView(Context context) {
        super(context);
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.birds);
        int w = b.getWidth()/5;
        int h = b.getHeight()/3;
        Rect firstFrame = new Rect(0, 0, w, h);
        playerBird = new Sprite(10, 0, 0, 100, firstFrame, b);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 2 && j == 3) {
                    continue;
                }
                playerBird.addFrame(new Rect(j * w, i * h, j * w + w, i * w + w));
            }
        }


        Timer t = new Timer();
        t.start();
    }
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(127, 0, 0, 255); // заливаем цветом
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setTextSize(55.0f);
        p.setColor(Color.WHITE);
        canvas.drawText(points+"", viewWidth - 100, 70, p);
        playerBird.draw(canvas);


    }
    protected void update () {
        playerBird.update(timerInterval);
        this.invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }

    class Timer extends CountDownTimer {
        public Timer() {
            super(Integer.MAX_VALUE, timerInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            update();
        }

        @Override
        public void onFinish() {
        }
    }
}
