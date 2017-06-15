package com.project.recordaudioexample;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.github.republicofgavin.pauseresumeaudiorecorder.PauseResumeAudioRecorder;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private PauseResumeAudioRecorder mediaRecorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaRecorder = new PauseResumeAudioRecorder();
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

    @OnClick(R.id.recordButton)
    public void onPauseClick() {
        mediaRecorder.pauseRecording();
    }

    @OnClick(R.id.recordButton)
    public void onStopClick() {
        mediaRecorder.stopRecording();
    }

    @OnClick(R.id.recordButton)
    public void onResumeClick() {
        mediaRecorder.resumeRecording();
    }
}
