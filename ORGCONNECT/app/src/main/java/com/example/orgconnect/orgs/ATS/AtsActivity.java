package com.example.orgconnect.orgs.ATS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.orgconnect.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class AtsActivity extends AppCompatActivity {

    private ImageView updateAtsImage;
    private EditText updateAtsName, updateAtsEmail;
    private Button updateAtsBtn, deleteAtsBtn;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Bitmap bitmap = null;
    private String name, email,image;
    private String downloadUrl, post, uniqueKey;
    private StorageReference storageReference;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ats);

        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        image = getIntent().getStringExtra("image");

        uniqueKey = getIntent().getStringExtra("key");
        post = getIntent().getStringExtra("post");

        updateAtsImage = findViewById(R.id.updateAtsImage);
        updateAtsName = findViewById(R.id.updateAtsName);
        updateAtsEmail = findViewById(R.id.updateAtsEmail);
        updateAtsBtn = findViewById(R.id.updateAtsBtn);
        deleteAtsBtn = findViewById(R.id.deleteAtsBtn);

        reference = FirebaseDatabase.getInstance().getReference().child("Athlos Club Officers");
        storageReference = FirebaseStorage.getInstance().getReference();

        try {
            Picasso.get().load(image).into(updateAtsImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        updateAtsName.setText(name);
        updateAtsEmail.setText(email);

        updateAtsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        updateAtsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = updateAtsName.getText().toString();
                email = updateAtsEmail.getText().toString();
                checkValidation();
            }
        });

        deleteAtsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });

    }

    private void deleteData() {
        reference.child(post).child(uniqueKey).removeValue()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(AtsActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AtsActivity.this, UpdateAts.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AtsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void checkValidation() {
        if (name.isEmpty()){
            updateAtsName.setError("Empty");
            updateAtsName.requestFocus();

        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            updateAtsEmail.setError("Invalid Email");
            updateAtsEmail.requestFocus();
        } else if (email.isEmpty()) {
            updateAtsEmail.setError("Empty");
            updateAtsEmail.requestFocus();
        } else if (bitmap == null) {
            updateData(image);
        }else {
            uploadImage();
        }
    }

    private void updateData(String s) {

        HashMap hp = new HashMap();
        hp.put("name", name);
        hp.put("email", email);
        hp.put("post", post);
        hp.put("image", s);


        reference.child(post).child(uniqueKey).updateChildren(hp).addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                Toast.makeText(AtsActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AtsActivity.this, UpdateAts.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AtsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void uploadImage() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50 ,baos);
        byte[] finalimg = baos.toByteArray();
        final StorageReference filePath;
        filePath = storageReference.child("Athlos Club Officers").child(finalimg+"jpg");
        final UploadTask uploadTask= filePath.putBytes(finalimg);
        uploadTask.addOnCompleteListener(AtsActivity.this, new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if (task.isSuccessful()){
                    uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    downloadUrl = String.valueOf(uri);
                                    updateData(downloadUrl);
                                }
                            });
                        }
                    });
                }else{
//                    pd.dismiss();
                    Toast.makeText(AtsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openGallery() {
        Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImage, PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),selectedImageUri);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            updateAtsImage.setImageBitmap(bitmap);
        }
    }
}
