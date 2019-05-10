package com.iuciangb.dialogutilssample;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;

/**
 * @author YY
 * @create 2019/5/10
 * @Describe
 **/
public class DialogUtils {

    private final static String TYPE_STRING = "string";
    private static AlertDialog sAlertDialog;

    public interface PositiveButtonListener extends DialogInterface.OnClickListener {
        @Override
        void onClick(DialogInterface dialog, int which);
    }

    public interface NegativeButtonListener extends DialogInterface.OnClickListener {
        @Override
        void onClick(DialogInterface dialog, int which);
    }

    public static class AlertDialogText {
        private int mTitleId;
        private String mMessage;
        private int mPositionButtonTextId;
        private int mNegativeButtonTextId;
        private Context mContext;

        public AlertDialogText(Context context) {
            mContext = context;
        }

        public void setTitleId(int titleId) {
            mTitleId = titleId;
        }

        public void setMessage(String message) {
            mMessage = message;
        }

        public void setPositionButtonTextId(int positionButtonTextId) {
            mPositionButtonTextId = positionButtonTextId;
        }

        public void setNegativeButtonTextId(int navigationButtonTextId) {
            mNegativeButtonTextId = navigationButtonTextId;
        }

        public int getTitleId() {
            return mTitleId;
        }

        public String getMessage() {
            return mMessage;
        }

        public int getPositionButtonTextId() {
            return isStringResValid(mContext, mPositionButtonTextId) ? mPositionButtonTextId : R.string.text_confirm;
        }

        public int getNegativeButtonTextId() {
            return isStringResValid(mContext, mNegativeButtonTextId) ? mNegativeButtonTextId : R.string.text_cancel;
        }
    }

    public static void showOnlyAlertDialog(Context context, int titleId, int messageId) {
        showOnlyAlertDialog(context, titleId, messageId, false);
    }

    public static void showOnlyAlertDialog(Context context, int titleId, int messageId, boolean isEnableCancel) {
        dismissDialog();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        setTitle(context, builder, titleId);
        builder.setMessage(messageId);
        builder.setPositiveButton(R.string.text_confirm, null);

        showAlertDialog(builder, isEnableCancel);
    }

    public static void showOnlyAlertDialog(Context context, int titleId, String message) {
        showOnlyAlertDialog(context, titleId, message, false);
    }

    public static void showOnlyAlertDialog(Context context, int titleId, String message, boolean isEnableCancel) {
        dismissDialog();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        setTitle(context, builder, titleId);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.text_confirm, null);

        showAlertDialog(builder, isEnableCancel);
    }

    public static void showPositiveButtonAlertDialog(Context context, int titleId, int messageId, PositiveButtonListener positiveButtonListener) {
        showPositiveButtonAlertDialog(context, titleId, messageId, positiveButtonListener, false);
    }

    public static void showPositiveButtonAlertDialog(Context context, int titleId, int messageId, PositiveButtonListener positiveButtonListener, boolean isEnableCancel) {
        dismissDialog();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        setTitle(context, alertDialogBuilder, titleId);
        alertDialogBuilder.setMessage(messageId);
        alertDialogBuilder.setPositiveButton(R.string.text_confirm, positiveButtonListener);

        showAlertDialog(alertDialogBuilder, isEnableCancel);
    }

    public static void showPositiveButtonAlertDialog(Context context, int titleId, String message, PositiveButtonListener positiveButtonListener) {
        showPositiveButtonAlertDialog(context, titleId, message, positiveButtonListener, false);
    }

    public static void showPositiveButtonAlertDialog(Context context, int titleId, String message, PositiveButtonListener positiveButtonListener, boolean isEnableCancel) {
        dismissDialog();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        setTitle(context, alertDialogBuilder, titleId);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton(R.string.text_confirm, positiveButtonListener);

        showAlertDialog(alertDialogBuilder, isEnableCancel);
    }

    public static void showNegativeButtonAlertDialog(Context context, AlertDialogText alertDialogText, NegativeButtonListener negativeButtonListener) {
        showNegativeButtonAlertDialog(context, alertDialogText, negativeButtonListener, false);
    }

    public static void showNegativeButtonAlertDialog(Context context, AlertDialogText alertDialogText, NegativeButtonListener negativeButtonListener, boolean isEnableCancel) {
        dismissDialog();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        setTitle(context, alertDialogBuilder, alertDialogText.getTitleId());
        alertDialogBuilder.setMessage(alertDialogText.getMessage());
        alertDialogBuilder.setPositiveButton(alertDialogText.getPositionButtonTextId(), null);
        alertDialogBuilder.setNegativeButton(alertDialogText.getNegativeButtonTextId(), negativeButtonListener);

        showAlertDialog(alertDialogBuilder, isEnableCancel);
    }

    public static void showTwoButtonAlertDialog(Context context, AlertDialogText alertDialogText,
                                                PositiveButtonListener positiveButtonListener, NegativeButtonListener negativeButtonListener) {
        showTwoButtonAlertDialog(context, alertDialogText, positiveButtonListener, negativeButtonListener, false);
    }

    public static void showTwoButtonAlertDialog(Context context, AlertDialogText alertDialogText,
                                                PositiveButtonListener positiveButtonListener, NegativeButtonListener negativeButtonListener, boolean isEnableCancel) {
        dismissDialog();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        setTitle(context, alertDialogBuilder, alertDialogText.getTitleId());
        if (!TextUtils.isEmpty(alertDialogText.getMessage())) {
            alertDialogBuilder.setMessage(alertDialogText.getMessage());
        }
        alertDialogBuilder.setPositiveButton(alertDialogText.getPositionButtonTextId(), positiveButtonListener);
        alertDialogBuilder.setNegativeButton(alertDialogText.getNegativeButtonTextId(), negativeButtonListener);

        showAlertDialog(alertDialogBuilder, isEnableCancel);
    }

    private static void showAlertDialog(AlertDialog.Builder alertDialogBuilder, boolean isEnableCancel) {
        sAlertDialog = alertDialogBuilder.create();
        sAlertDialog.setCancelable(isEnableCancel);
        sAlertDialog.show();
    }

    private static void dismissDialog() {
        if (sAlertDialog == null) {
            return;
        }
        if (sAlertDialog.isShowing()) {
            sAlertDialog.dismiss();
            sAlertDialog = null;
        }
    }

    private static void setTitle(Context context, AlertDialog.Builder builder, int titleId) {
        if (isStringResValid(context, titleId)) {
            builder.setTitle(titleId);
        }
    }

    private static boolean isStringResValid(Context context, int textId) {
        return FunctionUtils.isStringResValid(context, textId);
    }
}
