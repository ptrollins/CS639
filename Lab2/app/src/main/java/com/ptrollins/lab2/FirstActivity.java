package com.ptrollins.lab2;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class FirstActivity extends ActionBarActivity {

    private Button prevButton, nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onNextButtonClick(View view) {



    }

    public void onPrevButtonClick(View view) {



    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        public PlaceholderFragment() {
        }

        View rootView;

        int[] arrayImages = {R.drawable.angry_bird, R.drawable.dog, R.drawable.cat};
        String[] arrayNames = {"Angry Bird", "Dog", "Cat"};
        int index;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_first, container, false);
            index=1;
            Button prev = (Button)rootView.findViewById(R.id.previousButton);
            prev.setOnClickListener(this);

            Button next = (Button)rootView.findViewById(R.id.nextButton);
            next.setOnClickListener(this);

            ((ImageView) rootView.findViewById(R.id.ivPet)).setImageResource(arrayImages[index]);
            ((TextView) rootView.findViewById(R.id.textTitle)).setText(arrayNames[index]);

            return rootView;
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.previousButton:
                    if (index > 0) {
                        index--;
                        ((TextView) rootView.findViewById(R.id.textTitle)).setText(arrayNames[index]);
                        ((ImageView) rootView.findViewById(R.id.ivPet)).setImageResource(arrayImages[index]);
                    }
                    else
                        Toast.makeText(getActivity().getApplicationContext(), "There are no more pictures.", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nextButton:
                    if (index < (arrayImages.length - 1)){
                        index++;
                        ((TextView) rootView.findViewById(R.id.textTitle)).setText(arrayNames[index]);
                        ((ImageView) rootView.findViewById(R.id.ivPet)).setImageResource(arrayImages[index]);
                        }
                    else
                        Toast.makeText(getActivity().getApplicationContext(), "There are no more pictures.", Toast.LENGTH_SHORT).show();
                break;
            }

        }
    }
}
