package br.com.alura.easytravel.util;

import android.annotation.SuppressLint;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TextsUtil {

    private static final String DAYS_SINGULAR = " dia";
    private static final String DAYS_PLURAL = " dias";
    private static final String LANGUAGE_PT = "pt";
    private static final String COUNTRY_BR = "br";
    private static final String CURRENCY_FORMAT_BR_STANDARD = "R$";
    private static final String CURRENCY_FORMAT_BR_FINAL = "R$ ";
    private static final String STAYING_DATE_FORMAT = "dd/MM/yy";

    public static String formatStayingTimeText(int daysOfStay) {
        return (daysOfStay == 1) ?  daysOfStay + DAYS_SINGULAR : daysOfStay + DAYS_PLURAL;
    }

    public static String formatPriceText(BigDecimal priceValue) {
        NumberFormat currencyFormat = DecimalFormat.getCurrencyInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
        return currencyFormat.format(priceValue).replace(CURRENCY_FORMAT_BR_STANDARD, CURRENCY_FORMAT_BR_FINAL);
    }

    public static String formatStayingDateText(int stay) {
        Calendar startDate = Calendar.getInstance();
        Calendar returnDate = Calendar.getInstance();
        returnDate.add(Calendar.DATE, stay);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat summaryDateFormat = new SimpleDateFormat(STAYING_DATE_FORMAT);
        String startDateFormatted = summaryDateFormat.format(startDate.getTime());
        String returnDateFormatted = summaryDateFormat.format(returnDate.getTime());
        return startDateFormatted + " - " + returnDateFormatted;
    }
}
