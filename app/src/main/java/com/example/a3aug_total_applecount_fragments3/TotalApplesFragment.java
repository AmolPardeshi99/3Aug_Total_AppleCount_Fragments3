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
import android.widget.TextView;


public class TotalApplesFragment extends Fragment {

    private EditText mEtAppleAvailable;
    private Button mBtnNext;
    private TextView mTvAppleAvailable;
    private FragmentCommunicationListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (FragmentCommunicationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mTvAppleAvailable = view.findViewById(R.id.tvAppleAvailable);
        mEtAppleAvailable = view.findViewById(R.id.etAppleAvailable);
        mBtnNext = view.findViewById(R.id.btnNext);

        if (getArguments()!= null){
            mTvAppleAvailable.setText("Total Available Apples after buying are - "+getArguments().getString("ApplesAfterBuying"));
        }
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    Bundle bundle = new Bundle();
                    bundle.putString("NoOfApples",mEtAppleAvailable.getText().toString());
                    listener.datafromAvailableApplePage(bundle);
                }
            }
        });
    }
}