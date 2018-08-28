package com.example.elcomplus.vsign.screens.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.elcomplus.vsign.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MySignFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.btn_addSignDefault)
    Button btnAddSignDefault;
    @BindView(R.id.txt_signDefault)
    TextView txtSignDefault;
    Context context;
    public static MySignFragment newInstance() {
        Bundle args = new Bundle();
        MySignFragment fragment = new MySignFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mysign, container, false);
        this.context=context;
        unbinder = ButterKnife.bind(this, view);
        btnAddSignDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
