package dieko.akinrowo.diekoassign3;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class n01343651Fragment extends Fragment {

    private ImageView moon_ImgView, earth_ImgView;
    private Button start, stop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        Button start = findViewById(R.id.start_btn);
//        start.setOnClickListener(this);
//        stop = (Button) findViewById(R.id.stop_btn);
//        stop.setOnClickListener(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.n01343651fragment, container, false);

        earth_ImgView = (ImageView) v.findViewById(R.id.earth);
        moon_ImgView = (ImageView) v.findViewById(R.id.moon);

        start = (Button) v.findViewById(R.id.start_btn);
        start.setOnClickListener(v12 -> startAnimation());

        stop = (Button) v.findViewById(R.id.stop_btn);
        stop.setOnClickListener(v1 -> stopAnimation());

//        TextView text = v.findViewById(R.id.r_txt);
//        text.setText(R.string.name);
//        RotateAnimation rotate= (RotateAnimation) AnimationUtils.loadAnimation(getContext(),R.anim.rotate);
//        text.setAnimation(rotate);

        return v;
    }

        private void startAnimation () {
            Toast.makeText(getContext(), "Starting...", Toast.LENGTH_SHORT).show();

            earth_ImgView.setImageResource(R.drawable.earth);
            moon_ImgView.setImageResource(R.drawable.moon);

            Animation earthAnim = AnimationUtils.loadAnimation(getContext(), R.anim.earth_anim);
            Animation moonAnim = AnimationUtils.loadAnimation(getContext(), R.anim.moon_anim);

            earthAnim.setRepeatCount(Animation.INFINITE);
            moonAnim.setRepeatMode(Animation.RESTART);
            moonAnim.setRepeatCount(Animation.INFINITE);

            moon_ImgView.startAnimation(moonAnim);
            earth_ImgView.startAnimation(earthAnim);
        }

        private void stopAnimation () {
            Toast.makeText(getContext(), "Stopping...", Toast.LENGTH_SHORT).show();
            earth_ImgView.clearAnimation();
            moon_ImgView.clearAnimation();
        }
    }
