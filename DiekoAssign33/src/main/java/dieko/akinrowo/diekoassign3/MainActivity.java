package dieko.akinrowo.diekoassign3;
//Dieko Akinrowo - N01343651

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new DiekoFragment())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNav =
            item -> {

                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.dieko_home:
                        fragment = new DiekoFragment();
                        break;

                    case R.id.dieko_Page2:
                        fragment = new AkinrowoFragment();
                        break;

                    case R.id.dieko_Page3:
                        fragment = new n01343651Fragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .commit();

                return true;
            };

    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(R.string.NAME_ID);

        alertDialogBuilder
                .setMessage("Do you want to exit the app?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> {

                    Toast.makeText(getApplicationContext(), "Bye bye!",
                            Toast.LENGTH_LONG).show();
                    System.exit(0);
                })

                .setNegativeButton("No", (dialog, id) -> dialog.cancel());

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}