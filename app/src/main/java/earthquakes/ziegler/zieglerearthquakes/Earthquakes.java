package earthquakes.ziegler.zieglerearthquakes;

    import java.io.IOException;
    import java.io.InputStream;
    import java.net.URL;
    import java.net.URLConnection;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    public class Earthquakes extends JFrame {
        private static final long serialVersionUID = 1L;

        public Earthquakes() throws IOException {
            //access earthquake information
            URL url = new URL(
                    "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_month.geojson");
            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();

            byte b[] = new byte[4096];
            int n = -1;
            StringBuilder builder = new StringBuilder();
            while ((n = in.read(b)) != -1) {
                builder.append(new String(b, 0, n));
            }
            String json = builder.toString();

            //convert the json to gson
            Gson gson = new Gson();
            MonthQuakes monthQuakes = gson.fromJson(json, MonthQuakes.class);

            //set JFrame properties
            setTitle("Earthquakes");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //set JFrame size relative to amount of Quakes in features array
            Quake[] features = monthQuakes.getFeatures();
            setSize(300, 100 + (11 * features.length));

            //create array that contains Stings of all earthquakes' place and magnitude
            String[] array = new String[features.length];
            int j = 0;
            for (Quake i : monthQuakes.getFeatures()) {
                array[j] = i.getProperties().toString();
                j++;
            }

            //create a JList using the array
            JList<String> list = new JList<String>(array);

            //add JList to JFrame
            add(list);

            setVisible(true);
        }

        public static void main(String[] args) throws IOException {

            new Earthquakes();
        }
}
