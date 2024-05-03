// Generated by view binder compiler. Do not edit!
package com.example.dealseeker_login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.dealseeker_login.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentProfileBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final FrameLayout main;

  @NonNull
  public final Button privacyPolicy;

  @NonNull
  public final Button settings;

  @NonNull
  public final Button socialMedia;

  private FragmentProfileBinding(@NonNull FrameLayout rootView, @NonNull FrameLayout main,
      @NonNull Button privacyPolicy, @NonNull Button settings, @NonNull Button socialMedia) {
    this.rootView = rootView;
    this.main = main;
    this.privacyPolicy = privacyPolicy;
    this.settings = settings;
    this.socialMedia = socialMedia;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      FrameLayout main = (FrameLayout) rootView;

      id = R.id.privacy_policy;
      Button privacyPolicy = ViewBindings.findChildViewById(rootView, id);
      if (privacyPolicy == null) {
        break missingId;
      }

      id = R.id.settings;
      Button settings = ViewBindings.findChildViewById(rootView, id);
      if (settings == null) {
        break missingId;
      }

      id = R.id.social_media;
      Button socialMedia = ViewBindings.findChildViewById(rootView, id);
      if (socialMedia == null) {
        break missingId;
      }

      return new FragmentProfileBinding((FrameLayout) rootView, main, privacyPolicy, settings,
          socialMedia);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
