package Utilities;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by BALE on 22/03/2017.
 */

public class ImageHighlighterOnTouchListener implements View.OnTouchListener {
    //This
    final ImageView image;

    public ImageHighlighterOnTouchListener(final ImageView image) {
        super();
        this.image = image;
    }

    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            //grey color filter, you can change the color as you like
            image.setAlpha((float)0.6);
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            image.setAlpha((float) 1.0);
        }
        return false;
    }

}