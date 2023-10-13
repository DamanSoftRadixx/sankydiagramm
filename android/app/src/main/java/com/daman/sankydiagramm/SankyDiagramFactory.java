package com.daman.sankydiagramm;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.Map;

class SankyDiagramFactory extends PlatformViewFactory {
    Activity activity;
    SankyDiagramFactory(@org.jetbrains.annotations.Nullable Activity activity)    {
        super(StandardMessageCodec.INSTANCE);
        this.activity=activity;
    }

    @NonNull
    @Override
    public PlatformView create(@NonNull Context context, int id, @Nullable Object args) {
        final Map<String, Object> creationParams = (Map<String, Object>) args;
        return new SinkyDiagramView(activity, id, creationParams);
    }
}
