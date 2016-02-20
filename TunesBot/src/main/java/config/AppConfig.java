package config;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by deepak.barr on 20/02/16.
 */
public class AppConfig {
  @JsonProperty
  @NotNull
  public String musicLocation;
  @JsonProperty
  @NotNull
  public String musicMetaLocation;
  @JsonProperty
  @NotNull
  public String adsLocation;

  public String getMusicLocation() {
    return musicLocation;
  }

  public void setMusicLocation(String musicLocation) {
    this.musicLocation = musicLocation;
  }

  public String getMusicMetaLocation() {
    return musicMetaLocation;
  }

  public void setMusicMetaLocation(String musicMetaLocation) {
    this.musicMetaLocation = musicMetaLocation;
  }

  public String getAdsLocation() {
    return adsLocation;
  }

  public void setAdsLocation(String adsLocation) {
    this.adsLocation = adsLocation;
  }
}
