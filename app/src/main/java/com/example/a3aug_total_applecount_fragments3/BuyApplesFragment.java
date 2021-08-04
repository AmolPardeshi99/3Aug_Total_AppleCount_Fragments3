package com.example.a3aug_total_applecount_fragments3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class BuyApplesFragment extends Fragment {
    private EditText mEtApplesToBuy;
    private Button mBtnGoBack;
    private FragmentCommunicationListener listener;
    private int ApplesAfterBuy = 0;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (FragmentCommunicationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mBtnGoBack = view.findViewById(R.id.btnBack);
        mEtApplesToBuy = view.findViewById(R.id.etApplesToBuy);
        mBtnGoBack.setOnClickListener(new View.OnClickListener() {
            Bundle bundle = getArguments();

            @Override
            public void onClick(View v) {
                if (getArguments() != null) {
                    ApplesAfterBuy = Integer.parseInt(bundle.getString("NoOfApples")) -
                            Integer.parseInt(mEtApplesToBuy.getText().toString());
                    if (listener != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("ApplesAfterBuying", ApplesAfterBuy + "");
                        listener.datafromBuyApplePage(bundle);
                    }
                }
            }
        });
    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//
//    }
}