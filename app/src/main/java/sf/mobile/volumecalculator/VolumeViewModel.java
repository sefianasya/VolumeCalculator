package sf.mobile.volumecalculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VolumeViewModel extends ViewModel {

    private final MutableLiveData<Integer> volume = new MutableLiveData<>();

    public LiveData<Integer> getVolume() {
        return volume;
    }

    public void hitungVolume(double panjang, double lebar, double tinggi) {
        int hasil = (int) Math.round(panjang * lebar * tinggi); // Dibulatkan ke integer
        volume.setValue(hasil);
    }
}
