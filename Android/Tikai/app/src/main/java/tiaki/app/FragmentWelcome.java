package tiaki.app;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import model.Session;

public class FragmentWelcome extends Fragment {

    private TextView textView;
    private ImageView imageView;
    private Session session;

    public FragmentWelcome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View v = inflater.inflate(R.layout.fragment_welcome, container, false);
        session = Session.getInstance();
        textView = (TextView) v.findViewById(R.id.welcome_username);
        textView.setText(session.getUsername());
        imageView = (ImageView) v.findViewById(R.id.img_user_welcome);
        Glide.with(getActivity()).load(session.getUrlImage()).into(imageView);
        return v;
    }

}
