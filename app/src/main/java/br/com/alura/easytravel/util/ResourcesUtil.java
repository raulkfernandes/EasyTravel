package br.com.alura.easytravel.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourcesUtil {

    private static final String DRAWABLE = "drawable";

    public static Drawable getImageDrawable(Context context, String drawablePath) {
        Resources contextResources = context.getResources();
        int drawableId = contextResources.getIdentifier(drawablePath, DRAWABLE, context.getPackageName());
        return contextResources.getDrawable(drawableId);
    }
}
