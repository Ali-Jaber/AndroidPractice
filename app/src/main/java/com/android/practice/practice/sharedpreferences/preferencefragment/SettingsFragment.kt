package com.android.practice.practice.sharedpreferences.preferencefragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import com.android.practice.practice.R

class SettingsFragment : PreferenceFragmentCompat(), Preference.OnPreferenceChangeListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDivider(ColorDrawable(Color.TRANSPARENT))
        setDividerHeight(0)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref_settings)

        bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_key_zipcode)))
        bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_key_unit)))
    }

    override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
        val value = newValue.toString()

        if (preference is ListPreference) {
            val prefIndex = preference.findIndexOfValue(value)
            if (prefIndex >= 0) {
                preference.setSummary(preference.entries[prefIndex])
            }
        } else {
            preference?.summary = value
        }
        return true
    }

    override fun onPreferenceTreeClick(preference: Preference?): Boolean {
        return when (preference?.key) {
            getString(R.string.pref_key_allow_notification) -> true
            getString(R.string.pref_key_zipcode) -> true
            getString(R.string.pref_key_unit) -> true
            else -> super.onPreferenceTreeClick(preference)
        }

    }

    private fun bindPreferenceSummaryToValue(preference: Preference?) {
        preference?.onPreferenceChangeListener = this
        onPreferenceChange(
            preference,
            PreferenceManager.getDefaultSharedPreferences(preference?.context)
                .getString(preference?.key, "")
        )
    }
}