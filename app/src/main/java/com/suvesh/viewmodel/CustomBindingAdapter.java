package com.suvesh.viewmodel;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.suvesh.utils.Utils;

import java.io.File;

/**
 * Created by Suvesh on 07/08/2017 AD.
 */

public class CustomBindingAdapter {


//    @BindingAdapter(value = {"app:image"})
//    public static void setImage(SimpleDraweeView view, ProductUploadData.UploadImage image) {
//        if (image != null) {
//            Uri uri;
//            if (image.isFromNetwork()) {
//                uri = Uri.parse(image.getPath());
//            } else {
//                uri = Uri.fromFile(new File(image.getPath()));
//            }
//            view.getHierarchy().getRoundingParams().setBorderWidth(Utils.dpToPx(2));
//            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).setResizeOptions(new ResizeOptions(400, 400)).build();
//            PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder().setOldController(view.getController()).setImageRequest(request).build();
//            view.setController(controller);
//        }
//    }

    @BindingAdapter(value = {"app:image"})
    public static void setImage(SimpleDraweeView view, String image) {
        if (image != null) {
            Uri uri = Uri.fromFile(new File(image));
            view.getHierarchy().getRoundingParams().setBorderWidth(Utils.dpToPx(2));
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).setResizeOptions(new ResizeOptions(400, 400)).build();
            PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder().setOldController(view.getController()).setImageRequest(request).build();
            view.setController(controller);
        }
    }




    @InverseBindingAdapter(attribute = "selectedItem")
    public static Object getSelectedItem(Spinner view) {
        return view.getSelectedItem();
    }

    @BindingAdapter(value = {"selectedItemAttrChanged"})
    public static void setListener(Spinner view, final InverseBindingListener inverseBindingListener) {
        view.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                inverseBindingListener.onChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                inverseBindingListener.onChange();
            }
        });
    }

    @BindingAdapter(value = {"app:visible"})
    public static void setVisible(View view, Boolean visible) {
        if(visible != null && visible) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    @BindingAdapter(value = {"app:checked"})
    public static void setChecked(CheckBox view, Boolean checked) {
        if(checked != null) {
            view.setChecked(checked);
        } else {
            view.setChecked(false);
        }
    }

    @InverseBindingAdapter(attribute = "checked")
    public static boolean getChecked(CheckBox view) {
        return view.isChecked();
    }

    @BindingAdapter(value = {"checkedAttrChanged"})
    public static void setListener(CheckBox view, final InverseBindingListener inverseBindingListener) {
        view.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                inverseBindingListener.onChange();
            }
        });
    }


    @BindingAdapter(value = {"app:errorText"})
    public static void setErrorText(TextView view, String errMsg) {
        if (errMsg != null) {
            view.setText(errMsg);
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

}
