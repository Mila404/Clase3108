package com.example.clase3108;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.clase3108.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private EditText txt_number1, txt_number2, txt_res;

    private RadioButton rad_sum, rad_sub, rad_mul, rad_div;

    private RadioGroup rad_group;

    private CheckBox check_sum, check_sub, check_mul, check_div;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        txt_number1 = (EditText) binding.txtNumber1;
        txt_number2 = (EditText) binding.txtNumber2;
        txt_res = (EditText) binding.txtRes;
        rad_sum = (RadioButton) binding.radSum;
        rad_sub = (RadioButton) binding.radSub;
        rad_mul = (RadioButton) binding.radMultiply;
        rad_div = (RadioButton) binding.radDivide;
        rad_group = (RadioGroup) binding.radGroup;

        check_sum = (CheckBox) binding.checkSum;
        check_sub = (CheckBox) binding.checkSub;
        check_mul = (CheckBox) binding.checkMul;
        check_div = (CheckBox) binding.checkDiv;

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.btnCalculate.setOnClickListener((View v) -> {
            if (rad_sum.isChecked()) {
                sum();
            } else if (rad_sub.isChecked()) {
                sub();
            } else if (rad_mul.isChecked()) {
                mul();
            } else if (rad_div.isChecked()) {
                div();
            } else if (check_sum.isChecked() && check_sub.isChecked()) {
                String suma = sum();
                String resta= sub();
                String res = String.valueOf("La suma es: " + suma + ", La resta es: " + resta);
                txt_res.setText(res);
            } else if (check_sum.isChecked() && check_div.isChecked()) {
                String suma = sum();
                String divi= div();
                String res = String.valueOf("La suma es: " + suma + ", La división es: " + divi);
                txt_res.setText(res);
            } else if (check_sum.isChecked() && check_mul.isChecked()) {
                String suma = sum();
                String multi= mul();
                String res = String.valueOf("La suma es: " + suma + ", La multiplicación es: " + multi);
                txt_res.setText(res);
            } else if (check_sub.isChecked() && check_div.isChecked()) {
                String resta = sub();
                String divi= div();
                String res = String.valueOf("La resta es: " + resta + ", La división es: " + divi);
                txt_res.setText(res);
            } else if (check_sub.isChecked() && check_mul.isChecked()) {
                String resta = sub();
                String multi= mul();
                String res = String.valueOf("La resta es: " + resta + ", La multiplicación es: " + multi);
                txt_res.setText(res);
            } else if (check_div.isChecked() && check_mul.isChecked()) {
                String divi = div();
                String multi= mul();
                String res = String.valueOf("La división es: " + divi + ", La multiplicación es: " + multi);
                txt_res.setText(res);
            }

            else {
                showMessage();
            }
        });
    }

    //

    public void showMessage() {
        Toast.makeText(this.getContext(), "No se ha seleccionado ninguna operación", Toast.LENGTH_SHORT).show();
    }

    public String sum() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = val_1 + val_2;
        String res = String.valueOf(sum);
        txt_res.setText(res);
        return res;
    }

    public String sub() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = val_1 - val_2;
        String res = String.valueOf(sum);
        txt_res.setText(res);
        return res;
    }

    public String mul() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = val_1 * val_2;
        String res = String.valueOf(sum);
        txt_res.setText(res);
        return res;
    }

    public String div() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        String res = "";
        if (val_2 != 0) {
            double sum = val_1 / val_2;
            res = String.valueOf(sum);
            txt_res.setText(res);
        } else {
            Toast.makeText(this.getContext(), "No se puede dividir por 0", Toast.LENGTH_SHORT).show();
        }
        return res;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}