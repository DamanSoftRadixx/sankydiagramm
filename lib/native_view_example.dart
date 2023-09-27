// import 'package:flutter/material.dart';
// import 'package:flutter/services.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';


class NativeViewExample extends StatelessWidget {
  const NativeViewExample({super.key});

  @override
  Widget build(BuildContext context) {
    const String viewType = '<platform-view-type>';
    final Map<String, dynamic> creationParams = <String, dynamic>{};

/*
    return Scaffold(
      appBar: AppBar(title: Text('Native View'),),
      body: Container(
        color: Colors.teal,
        padding: EdgeInsets.symmetric(vertical: 18,horizontal: 10),
        child: AndroidView(
          viewType: viewType,
          layoutDirection: TextDirection.ltr,
          creationParams: creationParams,
          creationParamsCodec: const StandardMessageCodec(),
        ),
      ),
    );*/
    return Scaffold(
      appBar: AppBar(title: Text('Native View'),),
      body: Container(
        color: Colors.teal,
        padding: EdgeInsets.symmetric(vertical: 18,horizontal: 10),
        child: PlatformViewLink(
      viewType: viewType,
      surfaceFactory:
          (context, controller) {
        return AndroidViewSurface(
          controller: controller as AndroidViewController,
          gestureRecognizers: const <Factory<OneSequenceGestureRecognizer>>{},
          hitTestBehavior: PlatformViewHitTestBehavior.opaque,
        );
      },
      onCreatePlatformView: (params) {
        return PlatformViewsService.initSurfaceAndroidView(
          id: params.id,
          viewType: viewType,
          layoutDirection: TextDirection.ltr,
          creationParams: creationParams,
          creationParamsCodec: const StandardMessageCodec(),
          onFocus: () {
            params.onFocusChanged(true);
          },
        )
          ..addOnPlatformViewCreatedListener(params.onPlatformViewCreated)
          ..create();
      },
    )
      ),
    );
  }
}
