package com.example.barcodes;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class CreateBarcode extends AppCompatActivity {

    private EditText etProductId;
    private Button btnGenerate;
    private ImageView ivResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_barcode);
        
        Generate();
    }

    private void Generate() {
        etProductId = findViewById(R.id.editTextProductId);
        ivResult = findViewById(R.id.imageViewResult);
        btnGenerate = findViewById(R.id.buttonGenerate);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etProductId.getText().toString();
                /*if (!text.isEmpty()){
                    new ImageDownloaderTask(ivResult).execute(" https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=" + text);
                }else{
                    Toast.makeText(CreateBarcode.this, "Lütfen bir metin giriniz", Toast.LENGTH_SHORT).show();
                }*/

                try {
                    QRGEncoder encoder = new QRGEncoder(text,null, QRGContents.Type.TEXT, 1000);
                    Bitmap bitmap = encoder.getBitmap();
                    ivResult.setImageBitmap(bitmap);
                }catch (Exception e ){
                    System.out.print(e);
                }




            }
        });
    }



}