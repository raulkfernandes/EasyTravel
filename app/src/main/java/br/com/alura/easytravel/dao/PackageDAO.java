package br.com.alura.easytravel.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.easytravel.model.PackageItem;

public class PackageDAO {

    public List<PackageItem> samplePackageList() {
        List<PackageItem> packages = new ArrayList<>(Arrays.asList(
                new PackageItem("sao_paulo_sp", "São Paulo", 2, new BigDecimal(243.99)),
                new PackageItem("belo_horizonte_mg", "Belo Horizonte", 3, new BigDecimal(421.50)),
                new PackageItem("recife_pe", "Recife", 4, new BigDecimal(754.20)),
                new PackageItem("rio_de_janeiro_rj", "Rio de Janeiro", 6, new BigDecimal(532.55)),
                new PackageItem("salvador_ba", "Salvador", 5, new BigDecimal(899.99)),
                new PackageItem("foz_do_iguacu_pr", "Foz do Iguaçu", 1, new BigDecimal(289.90)))
        );
        return packages;
    }
}
