package com.example.ecommerce;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SuccessToast {

    public static void showSuccessToast(Context context, String message) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.custom_success_toast,
                (ViewGroup) ((android.app.Activity) context).findViewById(R.id.custom_success_toast_container));

        // Thiết lập text
        TextView text = layout.findViewById(R.id.text_success_toast);
        text.setText(message);

        // Thiết lập icon (optional, nếu bạn có icon thành công)
        ImageView image = layout.findViewById(R.id.image_success_toast);
        image.setImageResource(R.drawable.baseline_check_circle_24); // Thay bằng icon của bạn

        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}