package music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pragya.mittal on 2/20/16.
 */
public class SongDownloader {
    String musicLoc;
    String jsonFile;
    String client_id = "02gUJC0hH2ct1EGOcYXQIzRFU91c72Ea";
    public SongDownloader(String musicLoc, String jsonFile) {
        this.musicLoc = musicLoc;
        this.jsonFile = jsonFile;

    }
    class URLObj {
        String songName;
        String artistName;
        String url;

        public URLObj(String songName, String artistName,String url) {
            this.songName = songName;
            this.artistName = artistName;
            this.url = url;
        }
    }

    public void createurlNDownloadFile() throws Exception {
        MusicConf musicConf;
        DownloadManager downloadManager;
        MusicParser musicParser = new MusicParser(jsonFile);
        List<URLObj> urls = new ArrayList<>();
        HashMap<String, MusicConf> musicConfMap = musicParser.getMusicConf();
        for (Map.Entry entry : musicConfMap.entrySet() ) {
            String url = "https://api.soundcloud.com/tracks/";
            musicConf = (MusicConf)entry.getValue();
            url += musicConf.getTrackid() + "/stream?client_id=" + client_id;
            urls.add(new URLObj(musicConf.getTitle(), musicConf.getArtist() , url));
        }
        downloadManager = new DownloadManager(musicLoc, urls.toArray(new URLObj[urls.size()]));
        downloadManager.downLoadFiles();
    }

}
