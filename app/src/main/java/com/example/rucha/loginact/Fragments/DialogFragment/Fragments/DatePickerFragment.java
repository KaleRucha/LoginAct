package com.example.rucha.loginact.Fragments.DialogFragment.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by rucha on 09-03-2018.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private OnDatePicked lclHandler;

    public interface OnDatePicked {
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        lclHandler = (OnDatePicked) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

//        Use the current date as default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

//         Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        lclHandler.onDateSet(datePicker, i, i1, i2);
    }
}
