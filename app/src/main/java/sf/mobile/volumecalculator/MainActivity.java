package sf.mobile.volumecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private EditText etPanjang, etLebar, etTinggi;
    private Button btnHitung;
    private TextView tvHasil;
    private VolumeViewModel volumeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi View
        etPanjang = findViewById(R.id.etPanjang);
        etLebar = findViewById(R.id.etLebar);
        etTinggi = findViewById(R.id.etTinggi);
        btnHitung = findViewById(R.id.btnHitung);
        tvHasil = findViewById(R.id.tvHasil);

        // Inisialisasi ViewModel
        volumeViewModel = new ViewModelProvider(this).get(VolumeViewModel.class);

        // Observe LiveData untuk hasil volume dalam Integer
        volumeViewModel.getVolume().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer volume) {
                tvHasil.setText(String.valueOf(volume));
            }
        });

        // Event Listener untuk Button Hitung
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungVolume();
            }
        });
    }

    private void hitungVolume() {
        String panjangStr = etPanjang.getText().toString();
        String lebarStr = etLebar.getText().toString();
        String tinggiStr = etTinggi.getText().toString();

        if (!panjangStr.isEmpty() && !lebarStr.isEmpty() && !tinggiStr.isEmpty()) {
            try {
                double panjang = Double.parseDouble(panjangStr);
                double lebar = Double.parseDouble(lebarStr);
                double tinggi = Double.parseDouble(tinggiStr);
                volumeViewModel.hitungVolume(panjang, lebar, tinggi);
            } catch (NumberFormatException e) {
                tvHasil.setText("Input tidak valid");
            }
        } else {
            tvHasil.setText("Semua bidang harus diisi!");
        }
    }
}
