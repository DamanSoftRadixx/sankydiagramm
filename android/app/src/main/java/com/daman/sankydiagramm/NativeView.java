package com.daman.sankydiagramm;

/*import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.platform.PlatformView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import io.flutter.plugin.platform.PlatformView;
import com.highsoft.highcharts.core.*;
import com.highsoft.highcharts.common.hichartsclasses.*;

class NativeView implements PlatformView {
    @NonNull private final TextView textView;

    NativeView(@NonNull Context context, int id, @Nullable Map<String, Object> creationParams) {

        textView = new TextView(context);
        textView.setTextSize(14);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView.setText("Rendered on a native Android view (id: " + id + ")");
    }

    @NonNull
    @Override
    public View getView() {
        return textView;
    }

    @Override
    public void dispose() {}
}*/



import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Map;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.platform.PlatformView;


class NativeView  implements PlatformView {

    private TextView textView;


    NativeView(@NonNull Context context, int id, @Nullable Map<String, Object> creationParams) {
        textView = new TextView(context);
        textView.setTextSize(14);
        textView.setBackgroundColor(Color.rgb(255, 255, 255));
        textView.setText("Rendered on a native Android view (id: )");
    }


    @NonNull
    public View getView() {
        return textView;
    }

    @Override
    public void dispose() {
    }
}



