package settings.suraj.info.customisedsetting;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by suraj on 1/2/18.
 */

public abstract class AppCompatPreferenceActivity extends PreferenceActivity{

    private AppCompatDelegate mDelegate;

    @Override
    protected void onCreate(Bundle od){
        getDelegate().installViewFactory();
        getDelegate().onCreate(od);
        super.onCreate(od);
    }
        @Override

}
