package com.example.orgconnect.orgs.PNS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AddPns extends AppCompatActivity {

    private ImageView addPnsImage;
    private EditText addPnsName, addPnsEmail;
    private Spinner addPnsPost;
    private Button addPnsBtn;
    private Bitmap bitmap;
    private String post;
    private String name, email, downloadUrl = "";
    private static final int PICK_IMAGE_REQUEST = 1;
    private DatabaseReference reference, dbRef;
    private StorageReference storageReference;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pns);

        addPnsImage = findViewById(R.id.addPnsImage);
        addPnsName = findViewById(R.id.addPnsName);
        addPnsEmail = findViewById(R.id.addPnsEmail);
        addPnsPost = findViewById(R.id.addPnsPost);
        addPnsBtn = findViewById(R.id.addPnsBtn);

        reference = FirebaseDatabase.getInstance().getReference().child("Pen N' Scroll Officers");

        storageReference = FirebaseStorage.getInstance().getReference();

        pd = new ProgressDialog(this);

        String [] items1 = new String[]{"Select Position", "President", "Vice President", "Secretary", "Assistant Secretary", "Treasurer", "Assistant Treasurer", "Auditor", "Assistant Auditor", "Business Manager", "Project Manager", "Tech Officer", "4th Year Representative", "3rd Year Representative", "2nd Year Representative", "1st Year Year Representative", "Grade 12 Representative", "Grade 11 Representative"};
        addPnsPost.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items1));

        addPnsPost.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                post = addPnsPost.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addPnsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        addPnsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();
            }
        });
    }
    private void checkValidation() {
        name = addPnsName.getText().toString();
        email = addPnsEmail.getText().toString();

        if (name.isEmpty()) {
            addPnsName.setError("Empty");
            addPnsName.requestFocus();
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            addPnsEmail.setError("Invalid Email");
            addPnsEmail.requestFocus();
        } else if (email.isEmpty()) {
            addPnsEmail.setError("Empty");
            addPnsEmail.requestFocus();
        } else if (post.equals("Select Position")) {
            Toast.makeText(this, "Please Officer Position", Toast.LENGTH_SHORT).show();
        } else if (bitmap == null) {
            pd.setMessage("Uploading...");
            pd.show();
            insertData();
        }else {
            pd.setMessage("Uploading...");
            pd.show();
            uploadImage();
        }
    }

    private void uploadImage() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50 ,baos);
        byte[] finalimg = baos.toByteArray();
        final StorageReference filePath;
        filePath = storageReference.child("Pen N' Scroll Officers").child(finalimg+"jpg");
        final UploadTask uploadTask= filePath.putBytes(finalimg);
        uploadTask.addOnCompleteListener(AddPns.this, new OnCompleteListener<UploadTask.TaskSnapshot>() {
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
                                    insertData();
                                }
                            });
                        }
                    });
                }else{
                    pd.dismiss();
                    Toast.makeText(AddPns.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void insertData() {
        dbRef = reference.child(post);
        final String uniqueKey = dbRef.push().getKey();


        PnsData teacherData = new PnsData(name, email, downloadUrl, uniqueKey);

        dbRef.child(uniqueKey).setValue(teacherData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                pd.dismiss();
                Toast.makeText(AddPns.this, "Officer Added", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddPns.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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
            addPnsImage.setImageBitmap(bitmap);
        }
    }
        
}