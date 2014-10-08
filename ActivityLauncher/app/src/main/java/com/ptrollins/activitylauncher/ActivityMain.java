package com.ptrollins.activitylauncher;

import android.content.Intent;
import android.net.Uri;
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



public class ActivityMain extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
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

    public void onLaunchNew(View view) {

        startActivity(new Intent(this, NewActivity.class));

    }

    public void onLaunchText(View view) {

        final Intent intentSMS = new Intent(Intent.ACTION_SENDTO);
        intentSMS.setData(Uri.parse("smsto:" + Uri.encode("19125559876")));
        intentSMS.putExtra("sms_body","Hello you.");
        startActivity(intentSMS);

    }

    public void onLaunchPhone(View view) {

        final Intent intentCall = new Intent(Intent.ACTION_DIAL);
        intentCall.setData(Uri.parse("tel:19125559876"));
        startActivity(intentCall);

    }

    public void onLaunchBrowser(View view) {

        final Intent intentBrowse = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
        startActivity(intentBrowse);

    }

    public void onLaunchMaps(View view) {

        Uri geo = Uri.parse("geo:38.899533, -77.036476");
        final Intent intentMap = new Intent(Intent.ACTION_VIEW, geo);
        startActivity(intentMap);

    }

    public void onLaunchShare(View view) {

        Intent intentShare = new Intent();
        intentShare.setAction(Intent.ACTION_SEND);
        intentShare.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        intentShare.setType("text/plain");
        startActivity(Intent.createChooser(intentShare, getResources().getText(R.string.send_to)));

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_activity_main, container, false);
            return rootView;
        }


    }
}
