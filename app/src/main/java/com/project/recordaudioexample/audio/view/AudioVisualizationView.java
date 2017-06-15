package com.project.recordaudioexample.audio.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.project.recordaudioexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gleb on 6/15/17.
 */

public class AudioVisualizationView extends LinearLayout {

    @BindView(R.id.progressBar1)
    ProgressBar progressBar1;
    @BindView(R.id.progressBar2)
    ProgressBar progressBar2;

    public AudioVisualizationView(Context context) {
        super(context);
        init(context);
    }

    public AudioVisualizationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AudioVisualizationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.view_audio_visualization, this);
        setOrientation(VERTICAL);
        ButterKnife.bind(this);
    }

    public void updateProgress(int amplitude) {
        progressBar1.setProgress(amplitude);
        progressBar2.setProgress(amplitude);
    }
}