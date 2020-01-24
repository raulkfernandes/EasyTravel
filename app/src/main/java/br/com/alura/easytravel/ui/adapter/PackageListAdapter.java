package br.com.alura.easytravel.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.alura.easytravel.R;
import br.com.alura.easytravel.model.PackageItem;
import br.com.alura.easytravel.util.ResourcesUtil;
import br.com.alura.easytravel.util.TextsUtil;

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

        bindImageToLayout(mView, packageItem);
        bindDestinationToLayout(mView, packageItem);
        bindStayingTimeToLayout(mView, packageItem);
        bindPriceToLayout(mView, packageItem);

        return mView;
    }

    private void bindPriceToLayout(View mView, PackageItem packageItem) {
        TextView price = mView.findViewById(R.id.item_package_list_price);
        String priceTextFormat = TextsUtil.formatPriceText(packageItem.getPrice());
        price.setText(priceTextFormat);
    }

    private void bindStayingTimeToLayout(View mView, PackageItem packageItem) {
        TextView stay = mView.findViewById(R.id.item_package_list_stay);
        String stayTextFormat = TextsUtil.formatStayingTimeText(packageItem.getStay());
        stay.setText(stayTextFormat);
    }

    private void bindDestinationToLayout(View mView, PackageItem packageItem) {
        TextView destination = mView.findViewById(R.id.item_package_list_destination);
        destination.setText(packageItem.getDestination());
    }

    private void bindImageToLayout(View mView, PackageItem packageItem) {
        ImageView image = mView.findViewById(R.id.item_package_list_image);
        Drawable imageDrawable = ResourcesUtil.getImageDrawable(mContext, packageItem.getImage());
        image.setImageDrawable(imageDrawable);
    }
}
