package music;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.SongInfo;

/**
 * Created by pragya.mittal on 2/20/16.
 */

public class DownloadManager {
    SongInfo[] songs;
    String dirname;
    private static final Logger log = LoggerFactory.getLogger(DownloadManager.class);

    public DownloadManager(String dirname, SongInfo[] songs) {
        this.songs = songs;
        this.dirname = dirname;
    }

    public void downLoadFiles() throws Exception {
        for (SongInfo song : songs) {
            String musicFile=dirname + "/" + song.getSongName() + "_" + song.getArtistName() + ".mp3";
            downloadToFile(musicFile, song.getUrl());
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

        } else {
            log.info("File exists");
        }
    }
}
