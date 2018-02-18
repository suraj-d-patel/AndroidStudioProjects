package com.vamediabox.suraj.practice3;

import android.content.ClipData;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity{
    LinearLayout area1, area2;
    TextView prompt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        area1= (LinearLayout)findViewById(R.id.area1);
        area2= (LinearLayout)findViewById(R.id.area2);

        prompt=(TextView) findViewById(R.id.prompt);
        prompt.setMovementMethod(new ScrollingMovementMethod());
        prompt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                prompt.setText("");
                return true;
            }
        });

        TypedArray arrayResources = getResources().obtainTypedArray(R.array.resource_icon);
        for(int i=0;i<arrayResources.length();i++){
            ImageView imageview = new ImageView(this);
            ImageView.setImageDrawable(arrayResources.getDrawable(i));
            ImageView.setOnLongClickListener(myOnLongClickListener);
            area1.addView(imageview);
        }
        arrayResources.recycle();

        area1.setOnDragListener(myOnDragListener);
        area1.setOnDragListener(myOnDragListener);

    }
    View.OnLongClickListener myOnLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder shadowbuilder = new View.DragShadowBuilder(view);
            view.startDragAndDrop(data,shadowbuilder,view,0);
            view.setVisibility(View.INVISIBLE);
            return true;
        }
    };
    View.OnDragListener myOnDragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragevent) {

            String area;
            if (view == area1) {
                area="area1";
            }else if (view==area2){
                area="area2";
            }else{
                area = "unknown";
            }

            switch(dragevent.getAction()){
                case DragEvent.ACTION_DRAG_STARTED:
                    prompt.append("ACTION_DRAG_STARTED: "+ area + "\n");
                    break;

                case DragEvent.ACTION_DRAG_ENTERED:
                    prompt.append("ACTION_DRAG_ENTERED: "+ area + "\n");
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    prompt.append("ACTION_DRAG_STARTED: "+ area + "\n");
                    break;
            }







        }
    }
}

























