package br.com.alura.easytravel.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.alura.easytravel.R;
import br.com.alura.easytravel.dao.PackageDAO;
import br.com.alura.easytravel.model.PackageItem;
import br.com.alura.easytravel.ui.adapter.PackageListAdapter;

public class PackageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_list);
        setTitle("Pacotes");

        ListView packageList = findViewById(R.id.activity_package_list_listview);
        List<PackageItem> packages = new PackageDAO().samplePackageList();
        packageList.setAdapter(new PackageListAdapter(this, packages));
    }
}
