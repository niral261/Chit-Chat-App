package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.myapplication.utils.AndroidUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class loginOTP extends AppCompatActivity {
    String phoneNumber;
    Long timeoutSeconds = 60L;
    String verificationCode;
    PhoneAuthProvider.ForceResendingToken resendingToken;

    EditText enterOtp;
    Button nextBtn;
    ProgressBar progressBar;
    TextView resendOtpTextView;
    Button resendBtn;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_otp);

        enterOtp = findViewById(R.id.enterOtp);
        nextBtn = findViewById(R.id.nextBtn);
        progressBar = findViewById(R.id.progressBar);
        resendOtpTextView = findViewById(R.id.resendOtpTextView);
        resendBtn = findViewById(R.id.resendBtn);

        nextBtn.setEnabled(false);

        phoneNumber = Objects.requireNonNull(getIntent().getExtras()).getString("phone");
        sendOtp(phoneNumber,false);

        nextBtn.setOnClickListener(v -> {
            String enteredOneTimePassword = enterOtp.getText().toString();
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode,enteredOneTimePassword);
            signIn(credential);
        });

        resendBtn.setOnClickListener((v)->{
            sendOtp(phoneNumber,true);
        });
    }

    void sendOtp(String phoneNumber, boolean isResend) {
        startResendTimer();
        setInProgress(true);
        PhoneAuthOptions.Builder builder = PhoneAuthOptions.newBuilder(mAuth).setPhoneNumber(phoneNumber).setTimeout(timeoutSeconds, TimeUnit.SECONDS).setActivity(this).setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signIn(phoneAuthCredential);
                setInProgress(false);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                AndroidUtil.showToast(getApplicationContext(),"OTP verification failed");
                setInProgress(false);
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationCode = s;
                resendingToken = forceResendingToken;
                AndroidUtil.showToast(getApplicationContext(),"OTP sent successfully");
                setInProgress(false);
            }
        });
        if(isResend){
            PhoneAuthProvider.verifyPhoneNumber(builder.setForceResendingToken(resendingToken).build());
        }
        else{
            PhoneAuthProvider.verifyPhoneNumber(builder.build());
        }

    }

    @SuppressLint("UseCompatLoadingForColorStateLists")
    void setInProgress(boolean inProgress) {
        if(inProgress){
            progressBar.setVisibility(View.VISIBLE);
            nextBtn.setVisibility(View.GONE);
        }
        else {
            progressBar.setVisibility(View.GONE);
            nextBtn.setVisibility(View.VISIBLE);
            resendBtn.setVisibility(View.VISIBLE);
            nextBtn.setEnabled(true);
            nextBtn.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.colorSectionName));
            nextBtn.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite));
        }
    }

    void signIn(PhoneAuthCredential phoneAuthCredential){
        setInProgress(true);
        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                setInProgress(false);
                if(task.isSuccessful()){
                    Intent intent = new Intent(loginOTP.this,loginUserName.class);
                    intent.putExtra("phone",phoneNumber);
                    startActivity(intent);
                }
                else{
                    AndroidUtil.showToast(getApplicationContext(),"Otp Verification failed");
                }
            }
        });
    }

    void startResendTimer(){
        resendBtn.setEnabled(false);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @SuppressLint({"UseCompatLoadingForColorStateLists", "SetTextI18n"})
            @Override
            public void run() {
                timeoutSeconds--;
                resendOtpTextView.setText("Resend otp in "+timeoutSeconds+" seconds");
                if(timeoutSeconds<=0){
                    timeoutSeconds = 60L;
                    timer.cancel();
                    runOnUiThread(()-> {
                       resendBtn.setEnabled(true);
                       resendBtn.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.colorSectionName));
                       resendBtn.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite));
                    });
                }
            }
        },0,1000);
    }
}
