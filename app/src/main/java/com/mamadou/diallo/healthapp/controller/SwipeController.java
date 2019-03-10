package com.mamadou.diallo.healthapp.controller;

import android.app.AlertDialog;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.mamadou.diallo.healthapp.R;

import static android.support.v7.widget.helper.ItemTouchHelper.*;

class SwipeController extends Callback {


    private RecyclerView.ViewHolder currentItemViewHolder = null;
    private MyAdapter myAdapter;

    RectF buttonInstance;
    private boolean swipeBack = false;
    private static final float buttonWidth = 300;

    public SwipeController(MyAdapter myAdapter){
        this.myAdapter = myAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, LEFT );
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        if (swipeBack) {
            swipeBack = false;
            return 0;
        }
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    @Override
    public void onChildDraw(Canvas c,
                            RecyclerView recyclerView,
                            RecyclerView.ViewHolder viewHolder,
                            float dX, float dY,
                            int actionState, boolean isCurrentlyActive) {

        if (actionState == ACTION_STATE_SWIPE) {
            setTouchListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

        super.onChildDraw(c, recyclerView, viewHolder, dX/4, dY/3, actionState, isCurrentlyActive);
        drawButtons(c, viewHolder);
    }


    private void drawButtons(Canvas c, RecyclerView.ViewHolder viewHolder) {
        float buttonWidthWithoutPadding = buttonWidth - 20;

        View itemView = viewHolder.itemView;

        Paint p = new Paint();

        RectF rightButton = new RectF(itemView.getRight() - buttonWidthWithoutPadding, itemView.getTop(), itemView.getRight(), itemView.getBottom());
        p.setColor(Color.RED);

        Drawable d = viewHolder.itemView.getResources().getDrawable(R.drawable.ic_delete_black_24dp, null);
        d.setBounds((int) (itemView.getRight() - buttonWidthWithoutPadding), itemView.getTop(), itemView.getRight(), itemView.getBottom());

        c.drawRect(rightButton, p);
        d.setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        d.draw(c);

    }


    private void setTouchListener(Canvas c,
                                  final RecyclerView recyclerView,
                                  final RecyclerView.ViewHolder viewHolder,
                                  float dX, float dY,
                                  int actionState, boolean isCurrentlyActive) {


        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float buttonWidthWithoutPadding = buttonWidth - 20;
                View itemView = viewHolder.itemView;
                long i = viewHolder.getAdapterPosition();

                float x = event.getX();
                float y = event.getY();


                switch(event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
//                        Toast.makeText(v.getContext(), "("+i+")", Toast.LENGTH_SHORT).show();

                        if (x > (itemView.getRight() - buttonWidthWithoutPadding) && x < itemView.getRight() &&
                                y >  itemView.getTop() && y < itemView.getBottom()) {
                            int p = viewHolder.getAdapterPosition();
                            myAdapter.removeItem(p);
                        }
                        return false;
                }

                return false;

            }

        });

    }

}

