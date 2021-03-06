package music;

import java.util.*;

import config.AppConfig;
import pojo.SongInfo;

/**
 * Created by pragya.mittal on 2/20/16.
 */
public class SongDownloadTask extends TimerTask {
  AppConfig conf;
  String client_id = "02gUJC0hH2ct1EGOcYXQIzRFU91c72Ea";

  public SongDownloadTask(AppConfig conf) {
    this.conf = conf;
  }

  @Override
  public void run() {
    try {

      System.out.println("****** Running.....");
      MusicConf musicConf;
      DownloadManager downloadManager;
      MusicParser musicParser = new MusicParser(conf.getMusicMetaLocation());
      List<SongInfo> urls = new ArrayList<>();
      Map<String, MusicConf> musicConfMap = musicParser.getMusicConf();
      for (Map.Entry entry : musicConfMap.entrySet()) {
        musicConf = (MusicConf) entry.getValue();
        urls.add(new SongInfo(musicConf.getTitle(), musicConf.getArtist(), musicConf.getUrl()));
      }
      downloadManager = new DownloadManager(conf.getMusicLocation(), urls.toArray(new SongInfo[urls.size()]));
      downloadManager.downLoadFiles();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public String getSongName(String trackId) {
    Map<String, String> mapTrackName = getMapTrackName();
    return mapTrackName.get(trackId);
  }

  public Map<String, String> getMapTrackName() {
    MusicParser musicParser = new MusicParser(conf.getMusicMetaLocation());
    Map<String, MusicConf> musicConfMap = musicParser.getMusicConf();
    Map<String, String> mapNameNTrack = new HashMap<>();
    for (Map.Entry entry : musicConfMap.entrySet() ) {
      MusicConf musicConf = (MusicConf)entry.getValue();
      mapNameNTrack.put(musicConf.getTrackid(), musicConf.getTitle() + "_" + musicConf.getArtist());
    }
    return mapNameNTrack;
  }

}
