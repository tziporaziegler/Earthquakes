package earthquakes.ziegler.zieglerearthquakes;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class QuakeJsonLoadTask extends AsyncTask<String, Void, String> {

    private Quake[] quakes;

    @Override
    protected String doInBackground(String... params) {

        try {
            URL url = new URL(params[0]);
            URLConnection conn = url.openConnection();

            Gson gson = new GsonBuilder()
                    .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            InputStream in = getResources().openRawResource(R.raw.presidents);
            Quake quakes[] = gson.fromJson(new InputStreamReader(in), Quake[].class);
            return results.getFeatures()[0].getProperties().getPlace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    protected void onPostExecute(String result) {
        QuakeAdapter adapter = new QuakeAdapter(quakes);
        recyclerView.setAdapter(adapter);
    }
}