import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';

class SankyDiagram extends StatefulWidget {
  const SankyDiagram({super.key});

  @override
  State<SankyDiagram> createState() => _SankyDiagramState();
}

class _SankyDiagramState extends State<SankyDiagram> {
  @override
  Widget build(BuildContext context) {
// This is used in the platform side to register the view.
    const String viewType = '<platform-view-type-sanky-diagram>';
// Pass parameters to the platform side.
    final Map<String, dynamic> creationParams = <String, dynamic>{
      "daman":"Testing"
    };

    return Scaffold(
      appBar: AppBar(title: const Text('Sanky Diagram'),),
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
        ),
         /*child: AndroidView(
          viewType: viewType,
          layoutDirection: TextDirection.ltr,
          creationParams: creationParams,
          creationParamsCodec: const StandardMessageCodec(),
        ),*/
      ),
    );
  }
}
