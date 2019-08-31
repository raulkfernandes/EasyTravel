package br.com.alura.easytravel.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.alura.easytravel.R;
import br.com.alura.easytravel.model.PackageItem;

public class PackageListAdapter extends BaseAdapter {

    private final List<PackageItem> packageList;
    private final Context mContext;

    public PackageListAdapter(Context context, List<PackageItem> packageList) {
        this.mContext = context;
        this.packageList = packageList;
    }

    @Override
    public int getCount() {
        return packageList.size();
    }

    @Override
    public Object getItem(int index) {
        return packageList.get(index);
    }

    @Override
    public long getItemId(int index) {
        return 0;
    }

    @Override
    public View getView(int index, View convertView, ViewGroup parentView) {

        View mView;

        if(convertView != null) {
            mView = convertView;
        }
        else {
            mView = LayoutInflater.from(mContext).inflate(R.layout.item_package_list, parentView, false);
        }

        PackageItem packageItem = packageList.get(index);

        ImageView image = mView.findViewById(R.id.item_package_list_image);
        Resources contextResources = mContext.getResources();
        int drawableId = contextResources.getIdentifier(packageItem.getImage(), "drawable", mContext.getPackageName());
        Drawable imageDrawable = contextResources.getDrawable(drawableId);
        image.setImageDrawable(imageDrawable);

        TextView destination = mView.findViewById(R.id.item_package_list_destination);
        destination.setText(packageItem.getDestination());

        TextView stay = mView.findViewById(R.id.item_package_list_stay);
        String stayFormat;
        int daysOfStay = packageItem.getStay();
        if(daysOfStay > 1) {
            stayFormat = daysOfStay + " dias";
        }
        else {
            stayFormat = daysOfStay + " dia";
        }
        stay.setText(stayFormat);

        TextView price = mView.findViewById(R.id.item_package_list_price);
        BigDecimal priceValue = packageItem.getPrice();
        NumberFormat currencyFormat = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String priceFormat = currencyFormat.format(priceValue).replace("R$", "R$ ");
        price.setText(priceFormat);

        return mView;
    }
}
