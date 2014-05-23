package com.jeffinmadison.mygasmilage.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import android.view.View;

/**
 * Created by Jeff on 3/24/2014.
 * Copyright JeffInMadison 2014
 */
public class ImageUtils {
    public static Bitmap scaledBitmap(Bitmap source, float scale) {
        int scaledWidth = (int) (scale * source.getWidth());
        if (scaledWidth % 4 != 0) {
            //workaround for bug explained here https://plus.google.com/+RomanNurik/posts/TLkVQC3M6jW
            scaledWidth = (scaledWidth / 4) * 4;
        }
        return Bitmap.createScaledBitmap(source, scaledWidth, (int) (scale * source.getHeight()), true);
    }

    public static Bitmap blurRenderScript(Context context, Bitmap sourceBitmap, float blurRadius) {

        Bitmap output = Bitmap.createBitmap(sourceBitmap.getWidth(), sourceBitmap.getHeight(), sourceBitmap.getConfig());

        RenderScript renderScript = RenderScript.create(context);
        ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        Allocation inAlloc = Allocation.createFromBitmap(renderScript, sourceBitmap, Allocation.MipmapControl.MIPMAP_NONE, Allocation.USAGE_GRAPHICS_TEXTURE);
        Allocation outAlloc = Allocation.createFromBitmap(renderScript, output);
        scriptIntrinsicBlur.setRadius(blurRadius);
        scriptIntrinsicBlur.setInput(inAlloc);
        scriptIntrinsicBlur.forEach(outAlloc);
        outAlloc.copyTo(output);
        renderScript.destroy();
        return output;
    }

    public static Bitmap getRoundedBitmap(Bitmap scaleBitmapImage, int targetDiameter) {
        Bitmap targetBitmap = Bitmap.createBitmap(targetDiameter, targetDiameter,Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetDiameter - 1) / 2,
                        ((float) targetDiameter - 1) / 2,
                        (Math.min(((float) targetDiameter),
                        ((float) targetDiameter)) / 2),
                        Path.Direction.CCW);

        canvas.clipPath(path);
        canvas.drawBitmap(scaleBitmapImage,
                                new Rect(0, 0, scaleBitmapImage.getWidth(), scaleBitmapImage.getHeight()),
                                new Rect(0, 0, targetDiameter, targetDiameter), null);
        return targetBitmap;
    }

    public static Bitmap RGB565toARGB888(Bitmap img) {
        int numPixels = img.getWidth()* img.getHeight();
        int[] pixels = new int[numPixels];

        //Get JPEG pixels.  Each int is the color values for one pixel.
        img.getPixels(pixels, 0, img.getWidth(), 0, 0, img.getWidth(), img.getHeight());

        //Create a Bitmap of the appropriate format.
        Bitmap result = Bitmap.createBitmap(img.getWidth(), img.getHeight(), Bitmap.Config.ARGB_8888);

        //Set RGB pixels.
        result.setPixels(pixels, 0, result.getWidth(), 0, 0, result.getWidth(), result.getHeight());
        return result;
    }

    public static Bitmap getBitmapDrawableFromView(Context context, View targetView) {
        Bitmap bitmap =
                Bitmap.createBitmap(targetView.getWidth(), targetView.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        targetView.draw(canvas);
        return bitmap;
    }


    public static Bitmap getBlurredBitmapDrawableFromView(Context context, View targetView, float radius) {
        Bitmap bitmap =
                Bitmap.createBitmap(targetView.getWidth(), targetView.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        targetView.draw(canvas);

        Bitmap blurredBitmap;
        if ( radius > 0f) {
            blurredBitmap = blurRenderScript(context, bitmap, radius);
        } else {
            blurredBitmap = bitmap;
        }
        return blurredBitmap;
    }
}
