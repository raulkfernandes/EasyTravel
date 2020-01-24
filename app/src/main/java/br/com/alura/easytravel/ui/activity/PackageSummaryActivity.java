package br.com.alura.easytravel.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.easytravel.R;
import br.com.alura.easytravel.model.PackageItem;
import br.com.alura.easytravel.util.ResourcesUtil;
import br.com.alura.easytravel.util.TextsUtil;

public class PackageSummaryActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_summary);
        setTitle(APPBAR_TITLE);

        PackageItem packageSP = new PackageItem("sao_paulo_sp", "São Paulo", 2, new BigDecimal(243.99));

        ImageView summaryImage = findViewById(R.id.activity_package_summary_image);
        Drawable imageDrawable = ResourcesUtil.getImageDrawable(this, packageSP.getImage());
        summaryImage.setImageDrawable(imageDrawable);

        TextView summaryDestination = findViewById(R.id.activity_package_summary_destination);
        summaryDestination.setText(packageSP.getDestination());

        TextView summaryStay = findViewById(R.id.activity_package_summary_stay);
        String stayText = TextsUtil.formatStayText(packageSP.getStay());
        summaryStay.setText(stayText);

        TextView summaryPrice = findViewById(R.id.activity_package_summary_price);
        String priceText = TextsUtil.formatPriceText(packageSP.getPrice());
        summaryPrice.setText(priceText);

        TextView summaryDate = findViewById(R.id.activity_package_summary_date);
        Calendar startDate = Calendar.getInstance();
        Calendar returnDate = Calendar.getInstance();
        returnDate.add(Calendar.DATE, packageSP.getStay());
        SimpleDateFormat summaryDateFormat = new SimpleDateFormat("dd/MM/yy");
        String startDateFormatted = summaryDateFormat.format(startDate.getTime());
        String returnDateFormatted = summaryDateFormat.format(returnDate.getTime());
        String summaryDateFormatted = startDateFormatted + " - " + returnDateFormatted;
        summaryDate.setText(summaryDateFormatted);

    }
}
