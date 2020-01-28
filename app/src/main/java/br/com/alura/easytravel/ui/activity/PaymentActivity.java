package br.com.alura.easytravel.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.alura.easytravel.R;
import br.com.alura.easytravel.model.PackageItem;
import br.com.alura.easytravel.util.TextsUtil;

public class PaymentActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle(APPBAR_TITLE);

        PackageItem packageSP = new PackageItem("sao_paulo_sp", "São Paulo", 2, new BigDecimal(243.99));

        showPrice(packageSP);
    }

    private void showPrice(PackageItem packageSP) {
        TextView price = findViewById(R.id.activity_payment_value_price);
        String priceText = TextsUtil.formatPriceText(packageSP.getPrice());
        price.setText(priceText);
    }
}
