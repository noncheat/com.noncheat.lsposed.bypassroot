package com.noncheat.lsposed.bypassroot;

import java.util.ArrayList;
import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Hook implements IXposedHookLoadPackage {
    private static final String TAG = "NoncheatBypassRoot";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        Class<?> classAccessibilityManagerCompat = XposedHelpers.findClass("android.view.accessibility.AccessibilityManager", loadPackageParam.classLoader);
        XposedHelpers.findAndHookMethod(classAccessibilityManagerCompat, "getEnabledAccessibilityServiceList", int.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) {
                List result = new ArrayList<>();
                param.setResult(result);
            }
        });
    }
}
