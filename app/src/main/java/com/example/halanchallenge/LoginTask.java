package com.example.halanchallenge;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.ContentValues.TAG;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import com.google.gson.Gson;

public class LoginTask extends AsyncTask<String, Void, ConnectionResponse> {


    private String username, password;
    private Context context;

    LoginTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        //TODO: Before process async task (show progress bar, loader, fade..)
    }

    @Override
    protected ConnectionResponse doInBackground(String... params) {

        //Set username and password
        this.username = params[0];
        this.password = params[1];

        try {
            //Setup URL connection
            URL url = new URL("https://assessment-sn12.halan.io/auth");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.addRequestProperty("Content-Type", "application/json");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            JSONObject body = new JSONObject();
            body.put("username", username);
            body.put("password", password);

            writer.write(body.toString());
            writer.close();
            connection.connect();


            int status = connection.getResponseCode();
            BufferedReader bufferedReader = null;
            if (status == 200) {
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            StringBuilder result = new StringBuilder();
            String strCurrentLine;
            while ((strCurrentLine = bufferedReader.readLine()) != null) {
                result.append(strCurrentLine);
            }
            connection.disconnect();
            return new ConnectionResponse(status, result.toString());

        } catch (java.net.MalformedURLException e) {
            Log.w(TAG, "Exception while constructing URL" + e.getMessage());
        } catch (IOException | JSONException e) {
            Log.w(TAG, "Exception occured while logging in: " + e.getMessage());
        }
        return new ConnectionResponse(500, "Server error");
    }

    @Override
    protected void onPostExecute(ConnectionResponse connectionResponse) {
        //TODO: After async task finished based on task success
        if (connectionResponse.status == 200) {
            Intent myIntent = new Intent(context, ProductsListActivity.class);
            myIntent.putExtra("RESPONSE", connectionResponse.result);
            myIntent.setFlags(FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(myIntent);
        } else {
            try {
                JSONObject jsonObject = new JSONObject(connectionResponse.result);
                Toast.makeText(context, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context, connectionResponse.result, Toast.LENGTH_SHORT).show();
            }
        }
    }
}

class ConnectionResponse {
    int status;
    String result;

    ConnectionResponse(int status, String result) {
        this.status = status;
        this.result = result;
    }
}