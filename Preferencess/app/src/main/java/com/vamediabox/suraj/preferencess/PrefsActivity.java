package com.vamediabox.suraj.preferencess;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

/**
 * Created by suraj on 1/2/18.
 */

public class PrefsActivity extends PreferenceActivity{
        @Override
        protected void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
        }

        public static class MyPreferenceFragment extends PreferenceFragment
        {
            @Override
            public void onCreate(final Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                addPreferencesFromResource(R.xml.prefs);
            }
        }

}
