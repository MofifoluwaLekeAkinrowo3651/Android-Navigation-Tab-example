package dieko.akinrowo.diekoassign3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;



public class DiekoFragment extends Fragment {

    private Button b;
    private int startx = 10, starty = 10, endx=300, endy=300;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.diekofragment, container, false);

        b = (Button) v.findViewById(R.id.clear_button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCanvas(v);
            }
        });

        return v;
    }

    public void clearCanvas(View v){
        Canvas canvas =
        .drawColor(Color.TRANSPARENT);
        startx = 0;
        starty = 0;
        endx = 0;
        endy = 0;
    }
}