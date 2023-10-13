package com.daman.sankydiagramm;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;

    public class MainActivity extends FlutterActivity {

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        flutterEngine
                .getPlatformViewsController()
                .getRegistry()
                .registerViewFactory("<platform-view-type>", new NativeViewFactory());
        flutterEngine
                .getPlatformViewsController()
                .getRegistry()
                .registerViewFactory("<platform-view-type-sanky-diagram>", new SankyDiagramFactory(getActivity()));


    }

}
