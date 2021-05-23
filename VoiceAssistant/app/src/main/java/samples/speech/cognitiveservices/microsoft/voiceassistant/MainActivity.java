package samples.speech.cognitiveservices.microsoft.voiceassistant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    TextView text;
    TextView speechText;
    ImageButton searchVoice;
    String s;
    private TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToSpeech = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS){
                int result = textToSpeech.setLanguage(Locale.ENGLISH);

                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                    Log.e("TTS", "Язык не поддерживается");
                }else {
                    searchVoice.setEnabled(true);
                }
            } else {
                Log.e("TTS", "Инициализация провалена");
            }
        });

        Animation start = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.secondstart);
        text = findViewById(R.id.TextTv);
        speechText = findViewById(R.id.speechText);
        searchVoice = findViewById(R.id.VoiceButton);

        text.startAnimation(start);
        searchVoice.startAnimation(start);

        searchVoice.setOnClickListener(v -> speak());

    }

    private void speak(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Здравствуйте, скажите что-нибудь");

        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        } catch (Exception e){
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SPEECH_INPUT) {
            if (null != data) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                speechText.setText(result.get(0));
                s = speechText.getText().toString();
                switch (s) {
                    case "Google":
                    case "Открой Google":
                    case "Открой страницу Google":
                        textToSpeech.speak("Open Google", TextToSpeech.QUEUE_FLUSH, null);
                        WebIntent("https://www.google.com");
                        break;
                    case "Какая сейчас погода":
                    case "Какая погода сейчас":
                        textToSpeech.speak("Let's see weather", TextToSpeech.QUEUE_FLUSH, null);
                        WebIntent("https://yandex.ru/pogoda/moscow");
                        break;
                    case "Покажи карту метро":
                        textToSpeech.speak("Open the metro map", TextToSpeech.QUEUE_FLUSH, null);
                        PackageManager packageManager = getPackageManager();
                        Intent intent = packageManager.getLaunchIntentForPackage("ru.yandex.metro");
                        intent.addCategory(Intent.CATEGORY_LAUNCHER);
                        try {
                            startActivity(intent);
                        }catch (ActivityNotFoundException e){
                            WebIntent("https://yandex.ru/pogoda/moscow");
                        }
                        break;
                    default:
                        textToSpeech.speak("This command i don't know", TextToSpeech.QUEUE_FLUSH, null);
                        break;
                }
            }
        }
    }

    private void WebIntent(String path){
        Uri web_page = Uri.parse(path);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, web_page);
        startActivity(webIntent);
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }

        super.onDestroy();
    }
}


