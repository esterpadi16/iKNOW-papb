package diratama.komsi;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class IntroActivity extends AppCompatActivity {
    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        tabIndicator = findViewById(R.id.tab_indicator);



        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Login Cepat","Terintegrasi dengan google single sign on. Pengguna dapat menikmati pelayanan integrasi dengan goole calendar",R.drawable.tiga));
        mList.add(new ScreenItem("Tampilan Jadwal yang Keren","Tampilan yang keren, cocok buat kamu anak milenial",R.drawable.img1));
        mList.add(new ScreenItem("Layanan Pengingat","Gak usah risau! iKnow bakal ngingetin kamu",R.drawable.img2));

        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);

        tabIndicator.setupWithViewPager(screenPager);
    }
}
