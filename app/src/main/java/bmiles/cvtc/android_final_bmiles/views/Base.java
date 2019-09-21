package bmiles.cvtc.android_final_bmiles.views;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class Base extends View {


    protected ViewGroup container;

    public Base(Context context) {
        super(context);
    }


    public ViewGroup getContainer() {

        return this.container;
    }

    public void setContainer(ViewGroup container) { this.container = container;}


    public void initListeners() {}

    public void render() {
        this.initListeners();
        ((Activity)this.getContext()).setContentView(this.getContainer());

    }

}
