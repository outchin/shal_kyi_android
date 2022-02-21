package com.oxoo.spagreen;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.oxoo.spagreen.models.home_content.checkCodeModel;
import com.oxoo.spagreen.network.RetrofitClient;
import com.oxoo.spagreen.network.apis.CheckCode1;
import com.oxoo.spagreen.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.oxoo.spagreen.utils.MyAppClass.getContext;

public class VerificationActivity extends AppCompatActivity {

    public static Button getCodeButton;
    public static Button checkCodeBtn,skipBtn;
    public static TextInputEditText accCodeText;
    public static SwitchCompat changeLanguage;
    public static TextView language,need_help;

    private String android_id = Settings.Secure.getString(getContext().getContentResolver(),
            Settings.Secure.ANDROID_ID);
    static Boolean isTouched = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        getCodeButton = (Button) findViewById(R.id.getCode);
        checkCodeBtn = (Button) findViewById(R.id.checkCodeBtn);
        skipBtn = (Button) findViewById(R.id.btnSkip);
        language = (TextView) findViewById(R.id.language);
        need_help = (TextView) findViewById(R.id.need_help);
        changeLanguage = (SwitchCompat) findViewById(R.id.change_language);
        changeLanguage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isTouched = true;
                return false;
            }


        });

        changeLanguage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isTouched) {
                    isTouched = false;
                    if (isChecked) {
                        language.setText("MY");
                        accCodeText.setHint("Code ရိုက်ထည့်ပါ");
                        getCodeButton.setText("Code ၀ယ်ရန်");
                        skipBtn.setText("၁၀ ရက် Free ကြည့်ရန်");
                        need_help.setText("အကူအညီရယူနိုင်ရန် Page Messenger တွင် လာရောက် မေးမြန်းနိုင်ပါတယ်ခင်ဗျာ");
                    }
                    else {
                        language.setText("EN");
                        accCodeText.setHint("Enter your code");
                        getCodeButton.setText("Buy Code");
                        skipBtn.setText("10 Days Free Trial");
                        need_help.setText("Contact us in Page Message box if you need an assistant");
                    }
                }
            }
        });



        checkCodeBtn.setEnabled(false);
        accCodeText = (TextInputEditText) findViewById(R.id.accCodeText);
        getCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.messenger.com/t/110454794083749"));
                startActivity(browse);
            }
        });
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // showSuccessDialog("","");
                Intent intent = new Intent(VerificationActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        });
        accCodeText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String code = accCodeText.getText().toString();
                if (code.length() > 3) {
                    checkCodeBtn.setEnabled(true);
                    checkCodeBtn.setBackgroundResource(R.drawable.btn_rounded_amber_primary);
                    checkCodeBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showSuccessDialog("aabbcc","02-04-2020","allpackage");
//                            String userCode = accCodeText.getText().toString();
//                            ProgressDialog progressDialog= showLoadingDialog();
//                            Retrofit retrofit = RetrofitClient.getRetrofitInstance();
//                            CheckCode1 api = retrofit.create(CheckCode1.class);
//                            Call<List<checkCodeModel>> call = api.checkCode(Config.API_KEY, userCode, android_id);
//                            call.enqueue(new Callback<List<checkCodeModel>>() {
//                                @Override
//                                public void onResponse(Call<List<checkCodeModel>> call, Response<List<checkCodeModel>> response) {
//                                    progressDialog.dismiss();
//                                    if(response.code()==200)
//                                    {
//
//                                        checkCodeModel codeModel = (checkCodeModel) response.body().get(0);
//                                        showSuccessDialog(userCode,codeModel.getRegistration_end_at(),codeModel.getType());
//                                        Toast.makeText(getApplicationContext(),codeModel.getType(),Toast.LENGTH_SHORT).show();
//
//
//                                    }else
//                                    {
//                                        //Toast.makeText(getApplicationContext(),response.code()+"",Toast.LENGTH_SHORT).show();
//                                        checkCodeModel codeModel = (checkCodeModel) response.body().get(0);
//                                        showErrorDialog(codeModel.getDevice_id(),codeModel.getCode(),codeModel.getRegistration_end_at(),response.code()+"");
//                                    }
//
//                                }
//
//                                @Override
//                                public void onFailure(Call<List<checkCodeModel>> call, Throwable t) {
//                                    Toast.makeText(getApplicationContext(),call+"err1" + t,Toast.LENGTH_LONG).show();
//                                }
//                            });
                        }
                    });
                } else {
                    checkCodeBtn.setEnabled(false);
                    checkCodeBtn.setBackgroundResource(R.drawable.btn_rounded_amber);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });


    }


    /**
     * Returns the consumer friendly device name
     */





//    private void getPublicIP5(String installation_id,String user_code) {
//        ArrayList<String> urls = new ArrayList<String>(); //to read each line
//
//        new Thread(new Runnable() {
//            public void run() {
//                //TextView t; //to show the result, please declare and find it inside onCreate()
//
//                try {
//                    // Create a URL for the desired page
//                    URL url = new URL("https://api.ipify.org/"); //My text file location
//                    //First open the connection
//                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                    conn.setConnectTimeout(60000); // timing out in a minute
//
//                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//                    //t=(TextView)findViewById(R.id.TextView1); // ideally do this in onCreate()
//                    String str;
//                    while ((str = in.readLine()) != null) {
//                        urls.add(str);
//                    }
//                    in.close();
//                } catch (Exception e) {
//                    Log.d("MyTag", e.toString());
//                }
//
//                //since we are in background thread, to post results we have to go back to ui thread. do the following for that
//
//                VerificationActivity.this.runOnUiThread(new Runnable() {
//                    public void run() {
//                        try {
//                            Toast.makeText(VerificationActivity.this, "Public IP:" + urls.get(0), Toast.LENGTH_SHORT).show();
//                            Retrofit retrofit = RetrofitClient.getRetrofitInstance();
//                            chechCode api =  retrofit.create(chechCode.class);
//                            Call<List<checkCodeModel>> call = api.check_code(Config.API_KEY,);
//                            call.enqueue(new Callback<List<checkCodeModel>>() {
//
//                                @Override
//                                public void onResponse(Call<List<checkCodeModel>> call, Response<List<checkCodeModel>> response) {
//
//                                    if (response.code() == 200){
//
//                                    }
//                                }
//
//                                @Override
//                                public void onFailure(Call<List<checkCodeModel>> call, Throwable t) {
//
//                                }
//                            });
//
//
//
//
//
//                        } catch (Exception e) {
//                            Toast.makeText(VerificationActivity.this, "TurnOn wiffi to get public ip", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//            }
//        }).start();
//
//    }




    /** Returns the consumer friendly device name */
    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }

        return phrase.toString();
    }

    private void showSuccessDialog(String userCode, String registration_end_at, String subscription_type) {
        SharedPreferences.Editor editor = getSharedPreferences(Constants.USER_CODE, MODE_PRIVATE).edit();
        SharedPreferences.Editor editor1 = getSharedPreferences(Constants.REG_END_DATE, MODE_PRIVATE).edit();
        SharedPreferences.Editor editor2 = getSharedPreferences(Constants.SUBSCRIPTION_TYPE, MODE_PRIVATE).edit();

        editor.putString(Constants.USER_CODE, userCode);
        editor.apply();
        editor.commit();

        editor1.putString(Constants.REG_END_DATE, registration_end_at);
        editor1.apply();
        editor1.commit();

        editor2.putString(Constants.SUBSCRIPTION_TYPE, subscription_type);
        editor2.apply();
        editor2.commit();

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_info);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;


        ((AppCompatButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(VerificationActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();

                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }
    private void showErrorDialog( String myanmar_text, String english_text,String status,String statusCode) {
        boolean status1 = true;
        if(status.equals("false"))
        {
            status1 = false;
        }else
        {
            status1 = true;
        }

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_info);
        TextView mm_text= dialog.findViewById(R.id.mm_text);
        TextView eng_text= dialog.findViewById(R.id.eng_text);

        mm_text.setText(myanmar_text);
        eng_text.setText(english_text + " " + statusCode);

        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;


        boolean finalStatus = status1;
        ((AppCompatButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(finalStatus)
                {
                    Intent intent = new Intent(VerificationActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    finish();
                }


                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }
    private ProgressDialog showLoadingDialog(){
        ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
//        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();

        return progress;

    }
    private void hideLoadingDialog(){

    }
}