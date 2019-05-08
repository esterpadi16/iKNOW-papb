package diratama.komsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    Button next;
    Button getStartedBtn;
    int position =0;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        tabIndicator = findViewById(R.id.tab_indicator);
        next = findViewById(R.id.next_btn);
        getStartedBtn = findViewById(R.id.get_started);

        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Login Cepat","Terintegrasi dengan google single sign on. Pengguna dapat menikmati pelayanan integrasi dengan goole calendar",R.drawable.tiga));
        mList.add(new ScreenItem("Tampilan Jadwal yang Keren","Tampilan yang keren, cocok buat kamu anak milenial",R.drawable.img1));
        mList.add(new ScreenItem("Layanan Pengingat","Gak usah risau! iKnow bakal ngingetin kamu",R.drawable.img2));

        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);
        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Home = new Intent(getApplicationContext(),MainActivity.class);
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            position = screenPager.getCurrentItem();
            if(position<mList.size()){
                position++;
                screenPager.setCurrentItem(position);
                getStartedBtn.setVisibility(View.INVISIBLE);
             }
            if (position == mList.size()-1){
                loadLastScreen();
            }
            }
        });

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabIndicator.setupWithViewPager(screenPager);
    }

    private void loadLastScreen() {
        next.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        getStartedBtn.setVisibility(View.VISIBLE);
    }

}
