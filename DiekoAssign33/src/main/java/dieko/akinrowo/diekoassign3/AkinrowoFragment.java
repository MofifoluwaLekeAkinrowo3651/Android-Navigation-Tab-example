package dieko.akinrowo.diekoassign3;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import static androidx.core.content.ContextCompat.getDrawable;

public class AkinrowoFragment extends Fragment {

    private AnimationDrawable frameAnim;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.akinrowofragment, container, false);

        imageView = (ImageView) view.findViewById(R.id.frame_view);

        view.findViewById(R.id.cam_btn).setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });

        view.findViewById(R.id.start_btn2).setOnClickListener(view1 -> start());

        view.findViewById(R.id.stop_btn2).setOnClickListener(view12 -> stop());

        return view;
    }

    private void start() {
        imageView.findViewById(R.id.frame_view);
        Drawable[] frames = new Drawable[6];
        frames[0] = getDrawable(getContext(),R.drawable.p1);
        frames[1] = getDrawable(getContext(),R.drawable.p2);
        frames[2] = getDrawable(getContext(),R.drawable.p3);
        frames[3] = getDrawable(getContext(),R.drawable.p4);
        frames[4] = getDrawable(getContext(),R.drawable.p5);
        frames[5] = getDrawable(getContext(),R.drawable.p6);

        frameAnim = new AnimationDrawable();
        // infinitely loop
        frameAnim.setOneShot(false);

        //add all frames to animation
        for (Drawable frame : frames) {
            frameAnim.addFrame(frame,300);
        }

        imageView.setBackgroundDrawable(frameAnim);
        frameAnim.start();
        Toast.makeText(getContext(), "Starting...", Toast.LENGTH_SHORT).show();
    }

    private void stop() {
        frameAnim.stop();
        Toast.makeText(getContext(), "Stopping...", Toast.LENGTH_SHORT).show();
    }
}
