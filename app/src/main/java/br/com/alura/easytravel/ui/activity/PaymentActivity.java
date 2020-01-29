package br.com.alura.easytravel.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
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
            PackageItem packageItem = intent.getParcelableExtra(PACKAGE_ITEM_KEY);
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
                new AlertDialog
                        .Builder(PaymentActivity.this)
                        .setTitle("Confirmação de compra")
                        .setMessage("Tem certeza que quer confirmar a compra?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startPaymentSummaryActivity(packageItem);
                            }
                        })
                        .setNegativeButton("Não", null)
                        .show();
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
