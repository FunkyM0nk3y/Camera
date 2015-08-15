package com.example.funkym0nk3y.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{

  Button btnFoto;
  ImageView imgFoto;
  Bitmap bitMap;
  static int TAKE_PICTURE = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnFoto = (Button) findViewById(R.id.btnTakePic);
    imgFoto = (ImageView) findViewById(R.id.picture);
    btnFoto.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    startActivityForResult(intent, TAKE_PICTURE);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    if ( requestCode == TAKE_PICTURE && resultCode == RESULT_OK && intent != null ) {
      Bundle extras = intent.getExtras();
      bitMap = (Bitmap) extras.get("data");
      imgFoto.setImageBitmap(bitMap);
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if ( id == R.id.action_settings ) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
