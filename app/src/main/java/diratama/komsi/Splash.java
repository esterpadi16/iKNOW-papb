package diratama.komsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        tv = (TextView)findViewById(R.id.sub);
        iv = (ImageView)findViewById(R.id.logo);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);
        final Intent i = new Intent(this,IntroActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                startActivity(i);
                finish();
                }
            }
        };
        timer.start();
    }
}
