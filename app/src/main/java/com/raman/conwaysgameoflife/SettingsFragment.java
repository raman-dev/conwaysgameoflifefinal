package com.raman.conwaysgameoflife;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import androidx.annotation.Nullable;

/**
 * Created by Ramandeep on 2017-09-29.
 */

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }


}
