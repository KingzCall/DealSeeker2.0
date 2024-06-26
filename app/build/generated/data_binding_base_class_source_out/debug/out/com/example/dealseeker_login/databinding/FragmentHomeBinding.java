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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.dealseeker_login.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button addToWishlistButton;

  @NonNull
  public final EditText emailInput;

  @NonNull
  public final FrameLayout main;

  @NonNull
  public final EditText passwordInput;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final EditText searchEditText;

  @NonNull
  public final Button signUpButton;

  private FragmentHomeBinding(@NonNull FrameLayout rootView, @NonNull Button addToWishlistButton,
      @NonNull EditText emailInput, @NonNull FrameLayout main, @NonNull EditText passwordInput,
      @NonNull RecyclerView recyclerView, @NonNull EditText searchEditText,
      @NonNull Button signUpButton) {
    this.rootView = rootView;
    this.addToWishlistButton = addToWishlistButton;
    this.emailInput = emailInput;
    this.main = main;
    this.passwordInput = passwordInput;
    this.recyclerView = recyclerView;
    this.searchEditText = searchEditText;
    this.signUpButton = signUpButton;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addToWishlistButton;
      Button addToWishlistButton = ViewBindings.findChildViewById(rootView, id);
      if (addToWishlistButton == null) {
        break missingId;
      }

      id = R.id.email_input;
      EditText emailInput = ViewBindings.findChildViewById(rootView, id);
      if (emailInput == null) {
        break missingId;
      }

      FrameLayout main = (FrameLayout) rootView;

      id = R.id.password_input;
      EditText passwordInput = ViewBindings.findChildViewById(rootView, id);
      if (passwordInput == null) {
        break missingId;
      }

      id = R.id.recyclerView;
      RecyclerView recyclerView = ViewBindings.findChildViewById(rootView, id);
      if (recyclerView == null) {
        break missingId;
      }

      id = R.id.searchEditText;
      EditText searchEditText = ViewBindings.findChildViewById(rootView, id);
      if (searchEditText == null) {
        break missingId;
      }

      id = R.id.sign_up_button;
      Button signUpButton = ViewBindings.findChildViewById(rootView, id);
      if (signUpButton == null) {
        break missingId;
      }

      return new FragmentHomeBinding((FrameLayout) rootView, addToWishlistButton, emailInput, main,
          passwordInput, recyclerView, searchEditText, signUpButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
