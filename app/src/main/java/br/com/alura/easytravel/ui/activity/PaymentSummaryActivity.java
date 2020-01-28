package br.com.alura.easytravel.ui.activity;

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

public class PaymentSummaryActivity extends AppCompatActivity {

    private static final String APPBAR_TITLE = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_summary);
        setTitle(APPBAR_TITLE);

        PackageItem packageSP = new PackageItem("sao_paulo_sp", "São Paulo", 2, new BigDecimal(243.99));

        showImage(packageSP);
        showDestination(packageSP);
        showDate(packageSP);
        showPrice(packageSP);

    }

    private void showImage(PackageItem packageSP) {
        ImageView paymentImage = findViewById(R.id.activity_payment_summary_image);
        Drawable imageDrawable = ResourcesUtil.getImageDrawable(this, packageSP.getImage());
        paymentImage.setImageDrawable(imageDrawable);
    }

    private void showPrice(PackageItem packageSP) {
        TextView paymentPrice = findViewById(R.id.activity_payment_summary_price);
        String paymentPriceText = TextsUtil.formatPriceText(packageSP.getPrice());
        paymentPrice.setText(paymentPriceText);
    }

    private void showDate(PackageItem packageSP) {
        TextView paymentDate = findViewById(R.id.activity_payment_summary_date);
        String paymentDateText = TextsUtil.formatStayingDateText(packageSP.getStay());
        paymentDate.setText(paymentDateText);
    }

    private void showDestination(PackageItem packageSP) {
        TextView paymentDestination = findViewById(R.id.activity_payment_summary_destination);
        paymentDestination.setText(packageSP.getDestination());
    }
}
