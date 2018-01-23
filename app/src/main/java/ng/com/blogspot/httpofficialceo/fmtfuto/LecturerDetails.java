package ng.com.blogspot.httpofficialceo.fmtfuto;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LecturerDetails extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lecturer_details);


        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);


        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        String[] places = resources.getStringArray(R.array.names);
        collapsingToolbar.setTitle(places[postion % places.length]);

        String[] lecturer_info = resources.getStringArray(R.array.lecturer_informations);
       TextView placeDetail = (TextView) findViewById(R.id.lecturer_info);
        placeDetail.setText(lecturer_info[postion % lecturer_info.length]);


        TypedArray placePictures = resources.obtainTypedArray(R.array.places_picture);
        ImageView placePicutre = (ImageView) findViewById(R.id.image);
        placePicutre.setImageDrawable(placePictures.getDrawable(postion % placePictures.length()));

        placePictures.recycle();
    }
}
