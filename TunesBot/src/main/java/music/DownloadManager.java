package music;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by pragya.mittal on 2/20/16.
 */
public class DownloadManager {
    SongDownloader.URLObj[] urls;
    String dirname;

    public DownloadManager(String dirname, SongDownloader.URLObj[] urllist) {
        this.urls = urllist;
        this.dirname = dirname;
    }

    public void downLoadFiles() throws Exception {
        for (SongDownloader.URLObj url : urls) {
            downloadToFile(dirname + "/" + url.songName + "_" + url.artistName + ".mp3", url.url);
        }
    }

    private void downloadToFile(String dirname, String url) throws Exception {
        URLConnection conn = new URL(url).openConnection();
        InputStream is = conn.getInputStream();

        File file = new File(dirname);
        if (!file.exists()) {
            OutputStream outstream = new FileOutputStream(file);
            byte[] buffer = new byte[4096];
            int len;
            while ((len = is.read(buffer)) > 0) {
                outstream.write(buffer, 0, len);
            }
            outstream.close();
        }
        else {
            System.out.println("File exists");
        }
    }
}
