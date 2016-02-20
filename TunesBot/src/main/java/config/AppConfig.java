package config;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by deepak.barr on 20/02/16.
 */
public class AppConfig {
  @Getter
  @Setter
  @JsonProperty
  @NotNull
  public String musicLocation;
  @Getter
  @Setter
  @JsonProperty
  @NotNull
  public String musicMetaLocation;
  @Getter
  @Setter
  @JsonProperty
  @NotNull
  public String adsLocation;
}
