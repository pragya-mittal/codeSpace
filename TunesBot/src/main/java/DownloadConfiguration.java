import com.fasterxml.jackson.annotation.JsonProperty;
import config.AppConfig;
import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by pragya.mittal on 2/20/16.
 */
public class DownloadConfiguration extends Configuration {

  @Valid
  @NotNull
  @JsonProperty("appConfig")
  AppConfig appConfig;

  public AppConfig getAppConfig() {
    return appConfig;
  }

  public void setAppConfig(AppConfig appConfig) {
    this.appConfig = appConfig;
  }
}
