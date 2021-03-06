package ua.kpi.comsys.iv8214.ui.part1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ua.kpi.comsys.iv8214.R;

public class Part1Fragment extends Fragment {

    private Part1ViewModel part1ViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        part1ViewModel =
                new ViewModelProvider(this).get(Part1ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_part1, container, false);
        final TextView textView = root.findViewById(R.id.text_part1);
        part1ViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                textView.setMovementMethod(new ScrollingMovementMethod());
            }
        });
        return root;
    }
}