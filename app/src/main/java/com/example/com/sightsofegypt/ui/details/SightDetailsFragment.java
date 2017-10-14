package com.example.com.sightsofegypt.ui.details;

import android.Manifest;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.com.sightsofegypt.R;
import com.example.com.sightsofegypt.data.model.Sight;
import com.example.com.sightsofegypt.ui.base.BaseFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SightDetailsFragment extends BaseFragment {

    final static String SIGHT_KEY = "sight";

    @BindView(R.id.sightIV)
    ImageView sightIV;
    @BindView(R.id.priceTV)
    TextView priceTV;
    @BindView(R.id.descriptionTV)
    TextView descriptionTV;

    Sight sight;

    public SightDetailsFragment() {}

    public static SightDetailsFragment newInstance(Sight sight) {
        SightDetailsFragment fragment = new SightDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(SIGHT_KEY, sight);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sight = getArguments().getParcelable(SIGHT_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sight_details, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        return view;
    }

    @Override
    protected void setUp(View view) {
        if (sight.getImageUrl() != null) {
            String url = sight.getImageUrl().replaceFirst("http", "https");
            Glide.with(getActivity())
                    .load(url)
                    .asBitmap()
                    .into(sightIV);
        }

        priceTV.setText(String.format("%1$,.0f$", sight.getPrice()));

        if (sight.getPlaceDescription() != null) {
            descriptionTV.setText(sight.getPlaceDescription());
        }
    }

    @SuppressLint("StaticFieldLeak")
    @OnClick(R.id.downloadIV)
    public void downloadImage() {
        try {
            getBaseActivity().requestPermissionsSafely(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

            if (getBaseActivity().hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                Bitmap bitmap = ((BitmapDrawable) sightIV.getDrawable()).getBitmap();

                Bitmap result = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());

                Canvas canvas = new Canvas(result);
                canvas.drawBitmap(bitmap, 0, 0, null);

                Bitmap waterMark = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.logo);
                waterMark = Bitmap.createScaledBitmap(waterMark, 150, 150, false);

                Paint alphaPaint = new Paint();
                alphaPaint.setAlpha(100);

                int centreX = (canvas.getWidth() - waterMark.getWidth()) / 2;
                int centreY = (canvas.getHeight() - waterMark.getHeight()) / 2;

                canvas.drawBitmap(waterMark, centreX, centreY, alphaPaint);

                File file;
                File path = Environment.getExternalStorageDirectory();
//                File dir = new File(path + "/Sights of egypt/");
//                dir.mkdir();

                file = new File(path, "Sight of egypt " + sight.hashCode() + ".jpg");

                OutputStream stream = null;
                stream = new FileOutputStream(file);

                result.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                stream.flush();
                stream.close();
                showMessage(R.string.message_image_added);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
