package com.wuadam.imageformat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText etUrl;
    private Button btnDetermine;
    private TextView tvFormat;
    private Button btnJgp;
    private Button btnPng;
    private Button btnWebp;
    private Button btnGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrl = findViewById(R.id.et_url);
        btnDetermine = findViewById(R.id.btn_determine);
        tvFormat = findViewById(R.id.tv_format);
        btnJgp = findViewById(R.id.btn_jgp);
        btnPng = findViewById(R.id.btn_png);
        btnWebp = findViewById(R.id.btn_webp);
        btnGif = findViewById(R.id.btn_gif);

        btnDetermine.setOnClickListener(onClickListener);
        btnJgp.setOnClickListener(onClickListener);
        btnPng.setOnClickListener(onClickListener);
        btnWebp.setOnClickListener(onClickListener);
        btnGif.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == btnDetermine) {
                final String urlStr = etUrl.getText().toString();
                if (TextUtils.isEmpty(urlStr)) {
                    tvFormat.setText("url empty");
                    return;
                }
                tvFormat.setText("fetching ...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        InputStream inputStream = null;
                        try {
                            URL url = new URL(urlStr);
                            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                            httpURLConnection.setConnectTimeout(10000);           //设置连接超时时间
                            httpURLConnection.setReadTimeout(30000);
                            httpURLConnection.setDoInput(true);                  //打开输入流，以便从服务器获取数据
                            httpURLConnection.setDoOutput(false);                 //Get请求不需要DoOutPut
                            httpURLConnection.setRequestMethod("GET");          //设置以Get方式请求数据
                            httpURLConnection.setUseCaches(false);               //不使用缓存
                            //设置请求体的类型是文本类型
                            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            httpURLConnection.connect();

                            int response = httpURLConnection.getResponseCode();            //获得服务器的响应码
                            if(response == HttpURLConnection.HTTP_OK) {
                                inputStream = httpURLConnection.getInputStream();
                                final FormatHelper.FORMAT format = FormatHelper.getFormat(inputStream);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (format == null) {
                                            tvFormat.setText("error");
                                        } else {
                                            tvFormat.setText(format.extension);
                                        }
                                    }
                                });
                            }
                        } catch (final IOException e) {
                            e.printStackTrace();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvFormat.setText(e.getMessage());
                                }
                            });
                        } finally {
                            try {
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            } else if (view == btnJgp) {
                etUrl.setText("https://jpeg.org/images/jpeg-home.jpg");
            } else if (view == btnPng) {
                etUrl.setText("http://www.libpng.org/pub/png/PngSuite/basn0g02.png");
            } else if (view == btnWebp) {
                etUrl.setText("http://isparta.github.io/compare-webp/image/gif_webp/webp/2.webp");
            } else if (view == btnGif) {
                etUrl.setText("http://isparta.github.io/compare-webp/image/gif_webp/gif/2.gif");
            }
        }
    };
}
