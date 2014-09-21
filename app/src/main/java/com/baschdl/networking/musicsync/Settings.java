package com.baschdl.networking.musicsync;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class Settings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void checkServer(View view) {
        Button checkButton = (Button) findViewById(R.id.server_check_button);
        checkButton.setClickable(false);
        EditText serverAddress = (EditText) findViewById(R.id.serveraddress);
        if (serverAddress.getText().toString() == null) {
            NoAddressDialog nad = new NoAddressDialog();
            nad.show();
            return;
        }
        String path = serverAddress.getText().toString();
        String ipAddress = path.substring(2, path.indexOf("/", 3));

        try
        {
            InetAddress inet = InetAddress.getByName(ipAddress);
            boolean status = inet.isReachable(5000); //Timeout = 5000 milli seconds

            if (status)
            {
                if (checkFolder(view)) {
                    //popup reachable
                }
            }
            else
            {
                //popup unreachable
            }
        }
        catch (UnknownHostException e)
        {
            //popup unreachable
        }
        catch (IOException e)
        {
            //popup unreachable
        }
        //check folder
    }

    private boolean checkFolder(View view) {
        return false;
    }

}
