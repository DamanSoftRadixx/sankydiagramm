package com.daman.sankydiagramm;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;

public class PlatformViewPlugin implements FlutterPlugin {
    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        binding.getPlatformViewRegistry().registerViewFactory("<platform-view-type>", new NativeViewFactory());
        binding.getPlatformViewRegistry().registerViewFactory("<platform-view-type-sanky-diagram>", new SankyDiagramFactory(null));
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {}
}