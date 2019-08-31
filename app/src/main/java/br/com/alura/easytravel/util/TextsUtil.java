package br.com.alura.easytravel.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class TextsUtil {

    private static final String DAYS_SINGULAR = " dia";
    private static final String DAYS_PLURAL = " dias";
    private static final String LANGUAGE_PT = "pt";
    private static final String COUNTRY_BR = "br";
    private static final String CURRENCY_FORMAT_BR_STANDARD = "R$";
    private static final String CURRENCY_FORMAT_BR_FINAL = "R$ ";

    public static String formatStayText(int daysOfStay) {
        return (daysOfStay == 1) ?  daysOfStay + DAYS_SINGULAR : daysOfStay + DAYS_PLURAL;
    }

    public static String formatPriceText(BigDecimal priceValue) {
        NumberFormat currencyFormat = DecimalFormat.getCurrencyInstance(new Locale(LANGUAGE_PT, COUNTRY_BR));
        return currencyFormat.format(priceValue).replace(CURRENCY_FORMAT_BR_STANDARD, CURRENCY_FORMAT_BR_FINAL);
    }
}
