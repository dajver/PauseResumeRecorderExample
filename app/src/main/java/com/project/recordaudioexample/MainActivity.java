package com.project.recordaudioexample;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.project.recordaudioexample.audio.PauseResumeAudioRecorder;
import com.project.recordaudioexample.audio.view.AudioVisualizationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements PauseResumeAudioRecorder.OnAmplitudeRunning {

    @BindView(R.id.audioVisualizationView)
    AudioVisualizationView audioVisualizationView;

    private PauseResumeAudioRecorder mediaRecorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mediaRecorder = new PauseResumeAudioRecorder();
        mediaRecorder.setOnAmplitudeRunning(this);
        mediaRecorder.setAudioFile(Environment.getExternalStorageDirectory() + "/Record");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if (mediaRecorder.getCurrentState() == PauseResumeAudioRecorder.RECORDING_STATE || mediaRecorder.getCurrentState()==PauseResumeAudioRecorder.PAUSED_STATE) {
            mediaRecorder.stopRecording();
        }
    }

    @OnClick(R.id.recordButton)
    public void onRecordClick() {
        mediaRecorder.startRecording();
    }

    @OnClick(R.id.pauseButton)
    public void onPauseClick() {
        mediaRecorder.pauseRecording();
    }

    @OnClick(R.id.stopButton)
    public void onStopClick() {
        mediaRecorder.stopRecording();
    }

    @OnClick(R.id.resumeButton)
    public void onResumeClick() {
        mediaRecorder.resumeRecording();
    }

    @Override
    public void getAmplitude(double amplitude, int currentState) {
        audioVisualizationView.updateProgress((int) amplitude);
    }
}
