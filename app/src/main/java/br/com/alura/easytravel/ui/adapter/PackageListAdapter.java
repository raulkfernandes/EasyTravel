package br.com.alura.easytravel.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

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

        return mView;
    }
}
