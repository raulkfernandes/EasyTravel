package br.com.alura.easytravel.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.easytravel.R;
import br.com.alura.easytravel.model.PackageItem;
import br.com.alura.easytravel.util.ResourcesUtil;
import br.com.alura.easytravel.util.TextsUtil;

import static br.com.alura.easytravel.ui.activity.ActivitiesConstants.PACKAGE_ITEM_KEY;

public class PackageSummaryActivity extends AppCompatActivity {

    private static final String APPBAR_TITLE = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_summary);
        setTitle(APPBAR_TITLE);
        loadPackageItem();
    }

    private void loadPackageItem() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACKAGE_ITEM_KEY)) {
            PackageItem packageItem = intent.getParcelableExtra(PACKAGE_ITEM_KEY);
            initializeFields(packageItem);
            setupPackageSummaryButton(packageItem);
        }
    }

    private void setupPackageSummaryButton(final PackageItem packageItem) {
        Button packageSummaryButton = findViewById(R.id.activity_package_summary_button);
        packageSummaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPaymentActivity(packageItem);
            }
        });
    }

    private void startPaymentActivity(PackageItem packageItem) {
        Intent intent = new Intent(PackageSummaryActivity.this, PaymentActivity.class);
        intent.putExtra(PACKAGE_ITEM_KEY, packageItem);
        startActivity(intent);
    }

    private void initializeFields(PackageItem packageItem) {
        showImage(packageItem);
        showDestination(packageItem);
        showStayingTime(packageItem);
        showStayingDate(packageItem);
        showPrice(packageItem);
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
