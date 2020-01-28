package br.com.alura.easytravel.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

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

        showImage(packageSP);
        showDestination(packageSP);
        showStayingTime(packageSP);
        showStayingDate(packageSP);
        showPrice(packageSP);

        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }

    private void showStayingDate(PackageItem packageItem) {
        TextView summaryDate = findViewById(R.id.activity_package_summary_date);
        String summaryDateFormatted = TextsUtil.formatStayingDateText(packageItem.getStay());
        summaryDate.setText(summaryDateFormatted);
    }

    private void showPrice(PackageItem packageItem) {
        TextView summaryPrice = findViewById(R.id.activity_package_summary_price);
        String priceText = TextsUtil.formatPriceText(packageItem.getPrice());
        summaryPrice.setText(priceText);
    }

    private void showStayingTime(PackageItem packageItem) {
        TextView summaryStay = findViewById(R.id.activity_package_summary_stay);
        String stayText = TextsUtil.formatStayingTimeText(packageItem.getStay());
        summaryStay.setText(stayText);
    }

    private void showDestination(PackageItem packageItem) {
        TextView summaryDestination = findViewById(R.id.activity_package_summary_destination);
        summaryDestination.setText(packageItem.getDestination());
    }

    private void showImage(PackageItem packageItem) {
        ImageView summaryImage = findViewById(R.id.activity_package_summary_image);
        Drawable imageDrawable = ResourcesUtil.getImageDrawable(this, packageItem.getImage());
        summaryImage.setImageDrawable(imageDrawable);
    }
}
