package com.keremturker.imagepicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.keremturker.multiimagepicker.ImageConfig;
import com.keremturker.multiimagepicker.ImageSelector;
import com.keremturker.multiimagepicker.ImageSelectorActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnselect;
    LinearLayout llContainer;

    ImageConfig imageConfig;
    private ArrayList<String> path = new ArrayList<>();

    public static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnselect = findViewById(R.id.btnselect);
        llContainer = findViewById(R.id.llContainer);

        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageConfig = new ImageConfig.Builder(
                        new GlideLoader())
                        .steepToolBarColor(getResources().getColor(R.color.titleBlue))
                        .titleBgColor(getResources().getColor(R.color.titleBlue))
                        .titleSubmitTextColor(getResources().getColor(R.color.white))
                        .titleTextColor(getResources().getColor(R.color.white))
                        .mutiSelect()
                        .pathList(path)
                        .mutiSelectMaxSize(5)
                        .setContainer(llContainer, 4, true)

                        .filePath("/temp")
                        //.showCamera()
                        .requestCode(REQUEST_CODE)
                        .build();


                ImageSelector.open(MainActivity.this, imageConfig);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);



            path.clear();
            path.addAll(pathList);
        }
    }
}
