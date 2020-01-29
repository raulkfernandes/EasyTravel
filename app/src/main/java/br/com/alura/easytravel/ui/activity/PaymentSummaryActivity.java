package br.com.alura.easytravel.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.easytravel.R;
import br.com.alura.easytravel.model.PackageItem;
import br.com.alura.easytravel.util.ResourcesUtil;
import br.com.alura.easytravel.util.TextsUtil;

import static br.com.alura.easytravel.ui.activity.ActivitiesConstants.PACKAGE_ITEM_KEY;

public class PaymentSummaryActivity extends AppCompatActivity {

    private static final String APPBAR_TITLE = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_summary);
        setTitle(APPBAR_TITLE);
        loadPackageItem();
    }

    private void loadPackageItem() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACKAGE_ITEM_KEY)) {
            PackageItem packageItem = intent.getParcelableExtra(PACKAGE_ITEM_KEY);
            initializeFields(packageItem);
        }
    }

    private void initializeFields(PackageItem packageItem) {
        showImage(packageItem);
        showDestination(packageItem);
        showDate(packageItem);
        showPrice(packageItem);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(PaymentSummaryActivity.this, PackageListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void showImage(PackageItem packageItem) {
        ImageView paymentImage = findViewById(R.id.activity_payment_summary_image);
        Drawable imageDrawable = ResourcesUtil.getImageDrawable(this, packageItem.getImage());
        paymentImage.setImageDrawable(imageDrawable);
    }

    private void showPrice(PackageItem packageItem) {
        TextView paymentPrice = findViewById(R.id.activity_payment_summary_price);
        String paymentPriceText = TextsUtil.formatPriceText(packageItem.getPrice());
        paymentPrice.setText(paymentPriceText);
    }

    private void showDate(PackageItem packageItem) {
        TextView paymentDate = findViewById(R.id.activity_payment_summary_date);
        String paymentDateText = TextsUtil.formatStayingDateText(packageItem.getStay());
        paymentDate.setText(paymentDateText);
    }

    private void showDestination(PackageItem packageItem) {
        TextView paymentDestination = findViewById(R.id.activity_payment_summary_destination);
        paymentDestination.setText(packageItem.getDestination());
    }
}
