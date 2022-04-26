package samples.speech.cognitiveservices.microsoft.voiceassistant;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.File;


public class WorkWithFiles extends AppCompatActivity {
    private final File file = new File(getExternalFilesDir(null),"VoiceAssistant");

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_file);

        LinearLayout layout = (LinearLayout) findViewById(R.id.linear_layout);
        Button addNewFile = findViewById(R.id.addNewFile);
        TextView numberOfFiles = findViewById(R.id.howMuch);

        File[] files = file.listFiles();

        assert files != null;
        numberOfFiles.setText(numberOfFiles.getText()+String.valueOf(files.length));
        if (files.length != 0){
            for (File f:files){
                createNewFile(layout, f);
            }
        }

        addNewFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void createNewFile(LinearLayout layout, File file){
        Button button = new Button(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        button.setText((CharSequence) file);
        layout.addView(button);
    }
}
