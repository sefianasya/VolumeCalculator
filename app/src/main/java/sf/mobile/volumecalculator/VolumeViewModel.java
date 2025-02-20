package sf.mobile.volumecalculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel untuk menghitung volume berdasarkan panjang, lebar, dan tinggi.
 * Menggunakan MutableLiveData untuk menyimpan hasil perhitungan
 * agar tetap dipertahankan meskipun layar diputar (configuration change).
 */

public class VolumeViewModel extends ViewModel {

    // MutableLiveData untuk menyimpan hasil perhitungan volume dalam bentuk Integer
    private final MutableLiveData<Integer> volume = new MutableLiveData<>();

    /**
     * Mengembalikan LiveData dari hasil perhitungan volume.
     * LiveData digunakan agar UI dapat mengamati perubahan nilai secara otomatis.
     *
     * @return LiveData berisi nilai volume
     */
    public LiveData<Integer> getVolume() {
        return volume;
    }

    /**
     * Menghitung volume berdasarkan panjang, lebar, dan tinggi yang diberikan.
     * Hasil dikonversi ke Integer dengan pembulatan sebelum disimpan ke LiveData.
     *
     * @param panjang nilai panjang dari input user
     * @param lebar   nilai lebar dari input user
     * @param tinggi  nilai tinggi dari input user
     */
    public void hitungVolume(double panjang, double lebar, double tinggi) {
        int hasil = (int) Math.round(panjang * lebar * tinggi); // Dibulatkan ke integer
        volume.setValue(hasil);
    }
}
