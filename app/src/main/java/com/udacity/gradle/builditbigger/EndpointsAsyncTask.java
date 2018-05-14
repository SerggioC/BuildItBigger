package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.sergiocruz.androidlibrary.JokeActivity;
import com.udacity.gradle.builditbigger.backend.myBackendApi.MyBackendApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyBackendApi myApiService = null;

    private Context context;
    private TaskCompletedInterface taskCompletedInterface;

    public EndpointsAsyncTask(Context context, TaskCompletedInterface taskCompletedInterface) {
        this.context = context;
        this.taskCompletedInterface = taskCompletedInterface;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {

        if (myApiService == null) {  // Only do this once

            MyBackendApi.Builder builder = new MyBackendApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    // local running Google Cloud Engine
                    .setRootUrl("http://192.168.1.88:8080/_ah/api/")
                    // Online Google Cloud Engine
                    .setRootUrl("https://build-it-bigger-final.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJokeFromSergio().execute().getAjoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        Toast.makeText(context, joke, Toast.LENGTH_LONG).show();

        // Launch Android Library Module - androidlibrary with String joke data as Extra
        Intent intent = new Intent(context, com.sergiocruz.androidlibrary.JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY, joke);
        context.startActivity(intent);

        if (taskCompletedInterface != null) {
            taskCompletedInterface.onTaskCompleted(joke);
        }

    }

    public interface TaskCompletedInterface {
        void onTaskCompleted(String returnData);
    }
}