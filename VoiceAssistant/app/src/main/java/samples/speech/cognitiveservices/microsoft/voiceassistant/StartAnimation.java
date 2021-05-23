package samples.speech.cognitiveservices.microsoft.voiceassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Objects;

public class StartAnimation extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_animation);

        Objects.requireNonNull(getSupportActionBar()).hide();

        lottieAnimationView = findViewById(R.id.lottie);
        textView = findViewById(R.id.startText);
        Animation startName = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.startname);

        textView.startAnimation(startName);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(2100).withEndAction(() -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}