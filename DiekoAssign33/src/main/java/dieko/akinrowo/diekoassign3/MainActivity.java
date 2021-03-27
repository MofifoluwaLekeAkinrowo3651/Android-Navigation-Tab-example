package dieko.akinrowo.diekoassign3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

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
}