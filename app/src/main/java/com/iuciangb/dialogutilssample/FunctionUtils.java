package com.iuciangb.dialogutilssample;

import android.content.Context;

/**
 * @author YY
 * @create 2019/5/10
 * @Describe
 **/
public class FunctionUtils {
    private final static String RES_TYPE_STRING = "string";
    private final static String RES_TYPE_DRAWABLE = "drawable";

    public static boolean isStringResValid(Context context, int resId) {
        return isResValid(context, resId, RES_TYPE_STRING);
    }

    public static boolean isDrawableResValid(Context context, int resId) {
        return isResValid(context, resId, RES_TYPE_DRAWABLE);
    }

    private static boolean isResValid(Context context, int resId, String type) {
        int checkExistence = context.getResources().getIdentifier(String.valueOf(resId), "string", context.getPackageName());
        return checkExistence > 0;
    }
}
