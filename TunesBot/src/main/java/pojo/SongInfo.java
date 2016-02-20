package pojo;

import lombok.Data;

/**
 * Created by deepak.barr on 20/02/16.
 */
@Data
public class SongInfo {
    String songName;
    String artistName;
    String url;

    public SongInfo(String songName, String artistName, String url) {
      this.songName = songName;
      this.artistName = artistName;
      this.url = url;
    }
}
