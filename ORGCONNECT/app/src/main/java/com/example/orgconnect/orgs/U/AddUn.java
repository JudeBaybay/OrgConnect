package com.example.orgconnect.orgs.U;

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

public class AddUn extends AppCompatActivity {

    private ImageView addUnImage;
    private EditText addUnName, addUnEmail;
    private Spinner addUnPost;
    private Button addUnBtn;
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
        setContentView(R.layout.activity_add_un);
        addUnImage = findViewById(R.id.addUnImage);
        addUnName = findViewById(R.id.addUnName);
        addUnEmail = findViewById(R.id.addUnEmail);
        addUnPost = findViewById(R.id.addUnPost);
        addUnBtn = findViewById(R.id.addUnBtn);

        reference = FirebaseDatabase.getInstance().getReference().child("Unleashed Officers");

        storageReference = FirebaseStorage.getInstance().getReference();

        pd = new ProgressDialog(this);

        String [] items1 = new String[]{"Select Position", "President", "Vice President", "Secretary", "Assistant Secretary", "Treasurer", "Assistant Treasurer", "Auditor", "Assistant Auditor", "Business Manager", "Project Manager", "Tech Officer", "4th Year Representative", "3rd Year Representative", "2nd Year Representative", "1st Year Year Representative", "Grade 12 Representative", "Grade 11 Representative"};
        addUnPost.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items1));

        addUnPost.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                post = addUnPost.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addUnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        addUnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();
            }
        });
    }
    private void checkValidation() {
        name = addUnName.getText().toString();
        email = addUnEmail.getText().toString();

        if (name.isEmpty()) {
            addUnName.setError("Empty");
            addUnName.requestFocus();
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            addUnEmail.setError("Invalid Email");
            addUnEmail.requestFocus();
        } else if (email.isEmpty()) {
            addUnEmail.setError("Empty");
            addUnEmail.requestFocus();
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
        filePath = storageReference.child("Unleased Officers").child(finalimg+"jpg");
        final UploadTask uploadTask= filePath.putBytes(finalimg);
        uploadTask.addOnCompleteListener(AddUn.this, new OnCompleteListener<UploadTask.TaskSnapshot>() {
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
                    Toast.makeText(AddUn.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void insertData() {
        dbRef = reference.child(post);
        final String uniqueKey = dbRef.push().getKey();


        UnData teacherData = new UnData(name, email, downloadUrl, uniqueKey);

        dbRef.child(uniqueKey).setValue(teacherData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                pd.dismiss();
                Toast.makeText(AddUn.this, "Officer Added", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddUn.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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
            addUnImage.setImageBitmap(bitmap);
        }
    }
}