package com.zkbl.toutiaojava.ui.customerView.spinner;

import android.text.Spannable;

public interface SpinnerTextFormatter<T> {

    Spannable format(T item);
}
