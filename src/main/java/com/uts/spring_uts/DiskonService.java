package com.uts.spring_uts;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("diskonService")
public class DiskonService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // Mengambil variabel "totalBelanja" yang dikirimkan dari proses atau web controller
        Double totalBelanja = (Double) execution.getVariable("totalBelanja");

        if (totalBelanja == null) {
            totalBelanja = 0.0;
        }

        double diskon = 0;
        // Logika kondisi: jika belanja >= 100.000, dapat diskon 10%
        if (totalBelanja >= 100000) {
            diskon = totalBelanja * 0.10;
        }
        double totalBayar = totalBelanja - diskon;

        // Menyimpan kembali hasil perhitungan ke variabel proses Camunda
        execution.setVariable("diskon", diskon);
        execution.setVariable("totalBayar", totalBayar);

        // Cetak log di konsol IntelliJ untuk memastikan kode berjalan
        System.out.println("==================================================");
        System.out.println(" PROSES DISKON BERHASIL DIEKSEKUSI");
        System.out.println(" Total Belanja : " + totalBelanja);
        System.out.println(" Diskon        : " + diskon);
        System.out.println(" Total Bayar   : " + totalBayar);
        System.out.println("==================================================");
    }
}