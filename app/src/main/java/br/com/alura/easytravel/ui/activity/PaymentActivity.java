package br.com.alura.easytravel.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.easytravel.R;
import br.com.alura.easytravel.model.PackageItem;
import br.com.alura.easytravel.util.TextsUtil;

import static br.com.alura.easytravel.ui.activity.ActivitiesConstants.PACKAGE_ITEM_KEY;

public class PaymentActivity extends AppCompatActivity {

    private static final String APPBAR_TITLE = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle(APPBAR_TITLE);
        loadPackageItem();
    }

    private void loadPackageItem() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACKAGE_ITEM_KEY)) {
            PackageItem packageItem = (PackageItem) intent.getSerializableExtra(PACKAGE_ITEM_KEY);
            initializeFields(packageItem);
            setupPaymentButton(packageItem);
        }
    }

    private void initializeFields(PackageItem packageItem) {
        showPrice(packageItem);
    }

    private void setupPaymentButton(final PackageItem packageItem) {
        Button paymentButton = findViewById(R.id.activity_payment_button);
        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPaymentSummaryActivity(packageItem);
            }
        });
    }

    private void startPaymentSummaryActivity(PackageItem packageItem) {
        Intent intent = new Intent(PaymentActivity.this, PaymentSummaryActivity.class);
        intent.putExtra(PACKAGE_ITEM_KEY, packageItem);
        startActivity(intent);
    }

    private void showPrice(PackageItem packageSP) {
        TextView paymentPrice = findViewById(R.id.activity_payment_price);
        String priceText = TextsUtil.formatPriceText(packageSP.getPrice());
        paymentPrice.setText(priceText);
    }
}
