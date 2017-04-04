package Utilities;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by BALE on 22/03/2017.
 */

public class TextHighlighterOnTouchListener  implements View.OnTouchListener {
    //This
    final TextView text;

    public TextHighlighterOnTouchListener(final TextView text) {
        super();
        this.text = text;
    }

    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            //grey color filter, you can change the color as you like
            text.setAlpha((float)0.6);
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            text.setAlpha((float) 1.0);
        }
        return false;
    }

}