package com.keremturker.imagepicker;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
 import com.keremturker.multiimagepicker.ImageLoader;


public class GlideLoader implements ImageLoader {

	private static final long serialVersionUID = 1L;

	@Override
    public void displayImage(Context context, String path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                  .into(imageView);
    }

}
