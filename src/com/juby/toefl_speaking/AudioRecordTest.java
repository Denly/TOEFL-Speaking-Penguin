package com.juby.toefl_speaking;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.util.Log;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.util.Log;
import java.io.IOException;

//import com.google.ads.*;

public class AudioRecordTest extends Activity {
	private static final String LOG_TAG = "AudioRecordTest";
	private static String mFileName = null;
	private MediaRecorder mRecorder = null;
	private MediaPlayer mPlayer = null;
	// private MediaPlayer mSpeak = null;
	// private MediaPlayer mSpeak60 = null;

	TextView topic, status, topicn, text, text2;
	boolean model45 = true;
	ProgressBar bar;
	CheckBox box_pre, box1;

	ToneGenerator toneG;
	private boolean mStartRecording, mPlaying = false, mprep, timeRunning;
	TOEFLCountDownTimer timer;
	public Topics topics;

	void ini() {
		timer = new TOEFLCountDownTimer(46000, 1000);

	};

	void speak(Context context, int i) {
		if (mPlaying) {
			mPlayer.stop();
			mPlaying = false;
		}

		if (i == 0) {
			mPlayer = MediaPlayer.create(context, R.raw.speak45);
			mPlayer.start();
			mPlaying = true;
		} else if (i == 1) {
			mPlayer = MediaPlayer.create(context, R.raw.speak60);
			mPlayer.start();
			mPlaying = true;
		} else {

		}

	};

	void startAct() {
		if (timeRunning)
			timer.stop();
		if (mPlaying) {
			mPlayer.stop();
			mPlaying = false;
		}

		if (model45) {
			timer = new TOEFLCountDownTimer(46000, 1000);
			bar.setMax(45);
		} else {
			timer = new TOEFLCountDownTimer(61000, 1000);
			bar.setMax(60);
		}

		if (mStartRecording) {
			onRecord(mStartRecording);

			timer.start();
		} else {
			onRecord(mStartRecording);
			mStartRecording = true;
			timer.stop();
			onRecord(mStartRecording);

			timer.start();
		}
		mStartRecording = false;

		if (!mStartRecording)
			status.setText("Recoding...");
		else
			status.setText("No Rec.");

		toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
	}

	void stopAct() {
		if (timeRunning)
			timer.stop();
		if (mPlaying) {
			mPlayer.stop();
			mPlaying = false;
			status.setText("Stoped");
		}

		if (!mStartRecording) {
			onRecord(mStartRecording);
			mStartRecording = true;
			// timer.stop();

			if (!mStartRecording)
				status.setText("Recoding...");
			else
				status.setText("No Rec.");

			toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
		}

	};

	private void onRecord(boolean start) {
		if (start) {
			startRecording();
		} else {
			stopRecording();
		}
	}

	private void onPlay(boolean playing) {
		if (playing)
			mPlayer.stop();

		startPlaying();
		status.setText("Playing...");
		mPlaying = true;// if playing =true??

	}

	private void startPlaying() {
		mPlayer = new MediaPlayer();
		try {
			mPlayer.setDataSource(mFileName);
			mPlayer.prepare();
			mPlayer.start();
		} catch (IOException e) {
			Log.e(LOG_TAG, "prepare() failed");
		}
		// Act when playing completed
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub

				mPlaying = false;
				status.setText("Stop Play");
			}
		});
	}

	private void stopPlaying() {
		mPlayer.release();
		mPlayer = null;
	}

	private void startRecording() {
		mRecorder = new MediaRecorder();
		mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		mRecorder.setOutputFile(mFileName);
		mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

		try {
			mRecorder.prepare();
		} catch (IOException e) {
			Log.e(LOG_TAG, "prepare() failed");
		}

		mRecorder.start();
	}

	private void stopRecording() {
		mRecorder.stop();
		mRecorder.release();
		mRecorder = null;
	}

	// ===vvvv
	public void Buttons() {

		mStartRecording = true;
		// mPlaying = true;
		topic = (TextView) findViewById(R.id.topic);
		status = (TextView) findViewById(R.id.status);
		topicn = (TextView) findViewById(R.id.ntopic);
		text = (TextView) findViewById(R.id.textview1);
		text2 = (TextView) findViewById(R.id.textView2);

		ImageButton recordButton = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton stopButton = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton playButton = (ImageButton) findViewById(R.id.imageButton3);
		ImageButton changeTopic = (ImageButton) findViewById(R.id.imageButton5);
		ImageButton changeTopicL = (ImageButton) findViewById(R.id.imageButton4);
		ImageButton shift = (ImageButton) findViewById(R.id.imageButton_shift);
		box1 = (CheckBox) findViewById(R.id.checkBox1);
		box_pre = (CheckBox) findViewById(R.id.checkBox2);

		bar = (ProgressBar) findViewById(R.id.progressbar);
		toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 50);

		topics = new Topics();

		recordButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (timeRunning)
					timer.stop();
				if (mPlaying) {
					mPlayer.stop();
					mPlaying = false;
					status.setText("Stoped");
				}
				prepare();
				if (!mprep) {
					startAct();

				}

			}
		});

		stopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				stopAct();
			}
		});

		playButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stopAct();
				onPlay(mPlaying);
			}

		});

		changeTopic.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				topic.setText(topics.shiftTopic(1));
				topicn.setText("#" + (topics.n + 1));

			}

		});
		changeTopicL.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				topic.setText(topics.shiftTopic(-1));
				topicn.setText("#" + (topics.n + 1));
			}

		});

		shift.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				stopAct();
				model45 = !model45;
				if (model45) {
					text.setText("TOEFL speaking task 1~2\nYou have 45 second to speak.\n15 second to prepare.");
					bar.setMax(45);

				} else {
					text.setText("TOEFL speaking task 3~6\nYou have 60 second to speak.\n30 second to prepare.");
					bar.setMax(60);

				}

			}
		});

	}

	// ===^^^^
	void prepare() {
		if (box_pre.isChecked()) {
			mprep = true;
			if (model45) {
				timer = new TOEFLCountDownTimer(15000, 1000);
				bar.setMax(15);
			} else {
				timer = new TOEFLCountDownTimer(30000, 1000);
				bar.setMax(30);
			}
			timer.start();
			if (box1.isChecked())
				if (model45) {
					speak(AudioRecordTest.this, 0);
					// Log.e("I did","really");
				} else {
					speak(AudioRecordTest.this, 1);

				}
		} else {
			if (mprep)
				mprep = false;
		}
	}

	public AudioRecordTest() {
		mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
		mFileName += "/audiorecordtest.3gp";
	}

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_audio_record_test);
		ini();
		Buttons();

	}

	@Override
	public void onPause() {
		super.onPause();
		if (mRecorder != null) {
			mRecorder.release();
			mRecorder = null;
		}

		if (mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
	}

	public class TOEFLCountDownTimer extends CountDownTimer {
		// public boolean timeRunning;
		public long timel;

		public TOEFLCountDownTimer(long startTime, long interval) {
			super(startTime, interval);
			timeRunning = false;
			// OMG! don't forget to to run it by start();
		}

		public void stop() {
			if (timeRunning) {
				timer.cancel();
				timeRunning = false;
				mprep = false;
				// mStartRecording =false;
			}
		}

		@Override
		public void onFinish() {
			if (mprep) {
				mprep = false;
				timer.stop();
				startAct();
			} else {

				timeRunning = false;
				text.setText("Time's up!");

				onRecord(mStartRecording);
				mStartRecording = true;
				timer.stop();

				if (!mStartRecording)
					status.setText("Recoding...");
				else
					status.setText("No Rec.");
				toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
			}
		}

		@Override
		public void onTick(long millisUntilFinished) {
			timel = millisUntilFinished / 1000;
			timeRunning = true;
			if (mprep) {
				text.setText("prepare time remain: " + millisUntilFinished
						/ 1000);
				text2.setText("prepare your response recording: " + millisUntilFinished //text appears: prepare your response/Recording...
						/ 1000);
			} else {
				text.setText("Speaking time remain: " + millisUntilFinished
						/ 1000);
				text2.setText("prepare time remain: " + millisUntilFinished
						/ 1000);
			}

			bar.setProgress((int) (bar.getMax() + 1 - millisUntilFinished / 1000));
			if (!mStartRecording)
				status.setText("Recoding...");
			else
				status.setText("No Rec.");

		}
	}

}