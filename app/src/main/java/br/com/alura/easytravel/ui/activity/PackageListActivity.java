package br.com.alura.easytravel.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.alura.easytravel.R;
import br.com.alura.easytravel.dao.PackageDAO;
import br.com.alura.easytravel.model.PackageItem;
import br.com.alura.easytravel.ui.adapter.PackageListAdapter;

import static br.com.alura.easytravel.ui.activity.ActivitiesConstants.PACKAGE_ITEM_KEY;

public class PackageListActivity extends AppCompatActivity {

    private static final String APPBAR_TITLE = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_list);
        setTitle(APPBAR_TITLE);
        setupListView();
    }

    private void setupListView() {
        ListView packageList = findViewById(R.id.activity_package_list_listview);
        List<PackageItem> packages = new PackageDAO().samplePackageList();
        packageList.setAdapter(new PackageListAdapter(this, packages));
        packageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
                PackageItem packageItem = (PackageItem) adapterView.getItemAtPosition(index);
                startPackageSummaryActivity(packageItem);
            }
        });
    }

    private void startPackageSummaryActivity(PackageItem packageItem) {
        Intent intent = new Intent(PackageListActivity.this, PackageSummaryActivity.class);
        intent.putExtra(PACKAGE_ITEM_KEY, packageItem);
        startActivity(intent);
    }
}
