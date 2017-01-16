package com.example.benny.okhttptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.SAXParserFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Button SendButton;
    private TextView ShowText;
    private String TAG = "BENNY!!!!!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowText = (TextView) findViewById(R.id.ShowText);
        SendButton = (Button) findViewById(R.id.SendButton);
        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithOkHttp();
            }
        });
    }


    // communicate with OkHttp
    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://10.0.2.2:8000/get_data.json")
                            .build();
                    Response response = okHttpClient.newCall(request).execute();
                    String responseRes = response.body().string();
                    //ShowRes(responseRes);
                    //parseXMLWithPull(responseRes);
                    //parseXMLWithSAX(responseRes);
                    parseJSONwithJSONObejct(responseRes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void ShowRes(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ShowText.setText(response);
            }
        });
    }

    //parse XML with PULL method
    private void parseXMLWithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType = xmlPullParser.getEventType();
            String id = "";
            String name = "";
            String version = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        } else if ("name".equals(nodeName)) {
                            name = xmlPullParser.nextText();
                        } else if ("version".equals(nodeName)) {
                            version = xmlPullParser.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("app".equals(nodeName)) {
                            Log.d(TAG, "id : " + id);
                            Log.d(TAG, "name : " + name);
                            Log.d(TAG, "version : " + version);
                        }
                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //parse with SAX method
    private void parseXMLWithSAX(String xmlData) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();
            ContentHandler contentHandler = new ContentHandler();
            xmlReader.setContentHandler(contentHandler);
            xmlReader.parse(new InputSource(new StringReader(xmlData)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //JSONObject
    private void parseJSONwithJSONObejct(String JsonData) {
        try {
            JSONArray jsonArray = new JSONArray(JsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d(TAG, "id:" + id);
                Log.d(TAG, "name: " + name);
                Log.d(TAG, "version: " + version);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
