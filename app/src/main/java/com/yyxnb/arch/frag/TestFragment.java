package com.yyxnb.arch.frag;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.yyxnb.arch.R;
import com.yyxnb.yyxarch.base.BaseFragment;
import com.yyxnb.yyxarch.nav.NavigationFragment;
import com.yyxnb.yyxarch.utils.BarStyle;
import com.yyxnb.yyxarch.utils.ToastUtils;
import com.yyxnb.yyxarch.utils.log.LogUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends BaseFragment {

    private TextView tvShow;
    private Button button, button1, button2, button3, button4;
    private String value;

    @Override
    public int initLayoutResID() {
        return R.layout.fragment_test;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        tvShow = fv(R.id.tvShow);
        button = fv(R.id.button);
        button1 = fv(R.id.button1);
        button2 = fv(R.id.button2);
        button3 = fv(R.id.button3);
        button4 = fv(R.id.button4);

        value = getArguments().getString("value");
    }

    @Override
    public void initVariables(@NotNull Bundle bundle) {
        super.initVariables(bundle);

        value = bundle.getString("value");
    }

    @Override
    public void initViewData() {
        super.initViewData();

//        tvShow.setText(getDebugTag());
        tvShow.setText(value);

        LogUtils.INSTANCE.w("--- " + value);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityRootFragment(new TestFragment(), true);
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startFragment(new TestFragment());

            }
        });

        button2.setOnClickListener(v -> {

            startFragment(new TwoFragment(), 0x111);
        });

        button3.setOnClickListener(v -> {

            NavigationFragment navigationFragment = getNavigationFragment();
            if (navigationFragment != null) {
                navigationFragment.popToRootFragment();
            }
        });

        button4.setOnClickListener(v -> {

            finish();
        });

    }

    @NotNull
    @Override
    public BarStyle preferredStatusBarStyle() {
        return BarStyle.DarkContent;
    }

    @Override
    public int preferredStatusBarColor() {
        return Color.TRANSPARENT;
    }

    @Override
    public void onFragmentResult(int requestCode, int resultCode, @Nullable Bundle result) {
        super.onFragmentResult(requestCode, resultCode, result);
        if (requestCode == 0x111 && resultCode == 0x110) {
            ToastUtils.INSTANCE.normal("0x111 " + result.getString("msg", "null"));
        }
    }

    public static TestFragment newInstance(String value) {

        Bundle args = new Bundle();
        args.putString("value", value);
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
