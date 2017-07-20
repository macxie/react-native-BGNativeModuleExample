package com.macxie.nativemoduleexample;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import java.lang.String;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by develop03 on 17/7/20.
 */
public class BGNativeExampleModule extends ReactContextBaseJavaModule{

    public BGNativeExampleModule(ReactApplicationContext ReactContext) {
        super(ReactContext);
    }
    @Override
    public String getName() {
        return 'BGNativeExampleModule';
    }

    @ReactMethod
    public void testPrint(String name, ReadableMap info) {
        Log.i(TAG, name);
        Log.i(TAG, info.toString());
    }

    @ReactMethod
    public void getNativeClass(Callback callback) {
        callback.invoke("BGNativeExampleModule");
    }

    @ReactMethod
    public void testPromises(Boolean isResolve, Promise promise) {
        if(isResolve) {
            promise.resolve(isResolve.toString());
        }
        else {
            promise.reject(isResolve.toString());
        }
    }

    @Override
    public  Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("BGModuleName", "BGNativeModuleExample");
        return constants;
    }
}
