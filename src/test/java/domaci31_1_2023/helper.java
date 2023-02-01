package domaci31_1_2023;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class helper {


        public  int response(String u) throws IOException {

            URL url = new URL(u);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            return http.getResponseCode();
        }

    public void downloadFile(String url, String filePath) {
        try {
            downloadUsingNIO(url, filePath);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
    }

