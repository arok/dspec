package org.lucasr.dspec;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 08.09.14
 * Time: 23:30
 */
public class DesignSpecActivity extends Activity {

    private DesignSpecFrameLayout mDesignSpecFrameLayout;

    @Override
    public void onContentChanged() {
        super.onContentChanged();

        ViewGroup rootView = (ViewGroup) findViewById(android.R.id.content);

        DesignSpecFrameLayout designSpecFrameLayout = new DesignSpecFrameLayout(this);

        mDesignSpecFrameLayout = designSpecFrameLayout;

        int childCount = rootView.getChildCount();

        View child;
        for (int i = childCount - 1; i >= 0; i--) {
            child = rootView.getChildAt(i);
            rootView.removeView(child);
            designSpecFrameLayout.addView(child);
        }

        rootView.addView(designSpecFrameLayout,
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
    }

    public DesignSpec getDesignSpec() {
        return mDesignSpecFrameLayout.getDesignSpec();
    }

}
