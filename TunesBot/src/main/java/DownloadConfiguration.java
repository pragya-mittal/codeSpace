import com.fasterxml.jackson.annotation.JsonProperty;
import config.AppConfig;
import io.dropwizard.Configuration;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by pragya.mittal on 2/20/16.
 */
public class DownloadConfiguration extends Configuration {
  @Valid
  @NotNull
  @JsonProperty
  @Getter
  AppConfig appConfig;
}
