package com.daman.sankydiagramm;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.Map;

class NativeViewFactory extends PlatformViewFactory {
    Activity activityContext;
    NativeViewFactory(@Nullable  Activity contextMainActivity) {
        super(StandardMessageCodec.INSTANCE);
        activityContext=contextMainActivity;
    }

    @NonNull
    @Override
    public PlatformView create(@NonNull Context context, int id, @Nullable Object args) {
        final Map<String, Object> creationParams = (Map<String, Object>) args;
        return new NativeView(activityContext, id, creationParams);
    }
}