// Generated by view binder compiler. Do not edit!
package com.example.dealseeker_login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.dealseeker_login.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSearchBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button btnAudio;

  @NonNull
  public final Button btnBeauty;

  @NonNull
  public final Button btnCameras;

  @NonNull
  public final Button btnComputers;

  @NonNull
  public final Button btnGames;

  @NonNull
  public final Button btnHousehold;

  @NonNull
  public final Button btnPhones;

  @NonNull
  public final Button btnSports;

  @NonNull
  public final FrameLayout main;

  @NonNull
  public final EditText usernameInput;

  private FragmentSearchBinding(@NonNull FrameLayout rootView, @NonNull Button btnAudio,
      @NonNull Button btnBeauty, @NonNull Button btnCameras, @NonNull Button btnComputers,
      @NonNull Button btnGames, @NonNull Button btnHousehold, @NonNull Button btnPhones,
      @NonNull Button btnSports, @NonNull FrameLayout main, @NonNull EditText usernameInput) {
    this.rootView = rootView;
    this.btnAudio = btnAudio;
    this.btnBeauty = btnBeauty;
    this.btnCameras = btnCameras;
    this.btnComputers = btnComputers;
    this.btnGames = btnGames;
    this.btnHousehold = btnHousehold;
    this.btnPhones = btnPhones;
    this.btnSports = btnSports;
    this.main = main;
    this.usernameInput = usernameInput;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_search, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSearchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAudio;
      Button btnAudio = ViewBindings.findChildViewById(rootView, id);
      if (btnAudio == null) {
        break missingId;
      }

      id = R.id.btnBeauty;
      Button btnBeauty = ViewBindings.findChildViewById(rootView, id);
      if (btnBeauty == null) {
        break missingId;
      }

      id = R.id.btnCameras;
      Button btnCameras = ViewBindings.findChildViewById(rootView, id);
      if (btnCameras == null) {
        break missingId;
      }

      id = R.id.btnComputers;
      Button btnComputers = ViewBindings.findChildViewById(rootView, id);
      if (btnComputers == null) {
        break missingId;
      }

      id = R.id.btnGames;
      Button btnGames = ViewBindings.findChildViewById(rootView, id);
      if (btnGames == null) {
        break missingId;
      }

      id = R.id.btnHousehold;
      Button btnHousehold = ViewBindings.findChildViewById(rootView, id);
      if (btnHousehold == null) {
        break missingId;
      }

      id = R.id.btnPhones;
      Button btnPhones = ViewBindings.findChildViewById(rootView, id);
      if (btnPhones == null) {
        break missingId;
      }

      id = R.id.btnSports;
      Button btnSports = ViewBindings.findChildViewById(rootView, id);
      if (btnSports == null) {
        break missingId;
      }

      FrameLayout main = (FrameLayout) rootView;

      id = R.id.username_input;
      EditText usernameInput = ViewBindings.findChildViewById(rootView, id);
      if (usernameInput == null) {
        break missingId;
      }

      return new FragmentSearchBinding((FrameLayout) rootView, btnAudio, btnBeauty, btnCameras,
          btnComputers, btnGames, btnHousehold, btnPhones, btnSports, main, usernameInput);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
