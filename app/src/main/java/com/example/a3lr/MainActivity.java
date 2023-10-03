package com.example.a3lr;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btn_click(View view) {
        Toast myToast= Toast.makeText(getApplicationContext(),"2 секунды",Toast.LENGTH_SHORT);
        myToast.show();
    }

    public void btn_click_2(View view) {
        Toast myToast= Toast.makeText(getApplicationContext(),"3.5 секунды",Toast.LENGTH_LONG);
        myToast.show();
    }

    public void btn_click_3(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выход из приложения")
                .setIcon(R.drawable.test_icon)
                .setMessage("Вы уверены, что хотите выйти?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void btn_click_4(View view) {
        String[] items={"Да","Нет"};
        boolean[] selectedItems={false,false};
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Вы сегодня завтракали?")
                .setCancelable(false)
                .setMultiChoiceItems(items, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        selectedItems[i]=b;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String selected="";

                            if(selectedItems[0]==true && selectedItems[1]==false){
                                Toast toast=Toast.makeText(getApplicationContext(),"Молодцы!",Toast.LENGTH_LONG);
                                toast.show();
                            }
                            else {
                                Toast toast=Toast.makeText(getApplicationContext(),"Плохо!",Toast.LENGTH_LONG);
                                toast.show();
                            }
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

}