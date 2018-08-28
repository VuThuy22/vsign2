package com.example.elcomplus.vsign.screens.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.elcomplus.vsign.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ServiceVsignFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.btn_signUp)
    Button btnSignUp;

    public static ServiceVsignFragment newInstance() {
        Bundle args = new Bundle();

        ServiceVsignFragment fragment = new ServiceVsignFragment();
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
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        unbinder = ButterKnife.bind(this, view);
        String phone="";
        String syntax="";

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater=LayoutInflater.from(getActivity());
                View dialogView=inflater.inflate(R.layout.dialog_send_sms,null);
                TextView txtSms=dialogView.findViewById(R.id.txt_sms);
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setTitle("Thông báo");
                builder.setPositiveButton("Soạn ngay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        Uri data = Uri.parse("sms:");
                        intent.setData(data);
                        startActivity(intent);
//                        SmsManager smsManager=SmsManager.getDefault();
//                        smsManager.sendTextMessage("0967275298",null,"hehehe",null,null);
                    }
                });
               AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

//    {
//        public Map<String, String> getHeaders(){
//        Map<String, String> header=new HashMap<String, String>();
//        header.put("","");
//        header.put("","");
//        return header;
//    }
//    }

//
}
