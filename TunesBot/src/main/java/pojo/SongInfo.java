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

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
