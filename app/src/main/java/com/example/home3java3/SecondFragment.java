package com.example.home3java3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    public static final String KEY_BUNDLE = "key.second";
    private TextView text_value;
    private Button btn2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text_value = view.findViewById(R.id.text_fragSecond);
        btn2 = view.findViewById(R.id.btn_next2);
        if (getArguments() != null) {
        String value = getArguments().getString(FirstFragment.KEY_BUNDLE);
        text_value.setText(value);

    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Bundle bag = new Bundle();
            bag.putString(KEY_BUNDLE, text_value.getText().toString());
            ThirdFragment fragment = new ThirdFragment();
            fragment.setArguments(bag);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
        }
    });
    }
}}