package com.khanhnd.ud_docbao;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TinTucAdapter adapter;
    List<TinTuc> danhSachTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewRSS);
        danhSachTin = new ArrayList<>();

        adapter = new TinTucAdapter(this, danhSachTin);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        TaiDuLieuRSS();
    }
    private void TaiDuLieuRSS() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://vnexpress.net/rss/kinh-doanh.rss");
                    InputStream is = url.openStream();

                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    XmlPullParser parser = factory.newPullParser();
                    parser.setInput(is, "UTF-8");

                    int eventType = parser.getEventType();
                    boolean isInsideItem = false;
                    String title = "", pubDate = "", imageUrl = "";

                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        String tagName = parser.getName();

                        if (eventType == XmlPullParser.START_TAG) {
                            if (tagName.equalsIgnoreCase("item")) {
                                isInsideItem = true;
                                title = ""; pubDate = ""; imageUrl = "";
                            } else if (isInsideItem) {
                                if (tagName.equalsIgnoreCase("title")) {
                                    title = parser.nextText();
                                } else if (tagName.equalsIgnoreCase("pubDate")) {
                                    pubDate = parser.nextText();
                                } else if (tagName.equalsIgnoreCase("description")) {
                                    String desc = parser.nextText();

                                    if (desc.contains("src=\"")) {
                                        int start = desc.indexOf("src=\"") + 5;
                                        int end = desc.indexOf("\"", start);
                                        imageUrl = desc.substring(start, end);

                                    }
                                }
                            }
                        } else if (eventType == XmlPullParser.END_TAG && tagName.equalsIgnoreCase("item")) {
                            isInsideItem = false;
                            danhSachTin.add(new TinTuc(title, pubDate, imageUrl));
                        }
                        eventType = parser.next();
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
}
}