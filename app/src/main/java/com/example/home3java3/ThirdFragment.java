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

public class ThirdFragment extends Fragment {
    public static final String KEY_BUNDLE = "key.third";
    private TextView text_value;
    private Button btn3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text_value = view.findViewById(R.id.text_fragThird);
        btn3 = view.findViewById(R.id.btn_next3);
        if (getArguments() != null) {
            String value = getArguments().getString(SecondFragment.KEY_BUNDLE);
            text_value.setText(value);

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bag = new Bundle();
                    bag.putString(KEY_BUNDLE, text_value.getText().toString());
                    FourthFragment fragment = new FourthFragment();
                    fragment.setArguments(bag);
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
                }
            });
        }


    }}