import config.AppConfig;
import music.MusicConf;
import music.MusicParser;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/music")
public class DownloadResource {

  AppConfig conf;

  public DownloadResource(AppConfig conf) {
    this.conf = conf;
  }

  @GET
  @Path("getMusicList")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, MusicConf> getMusicList() throws Exception {
    MusicParser musicParser = new MusicParser(conf.getMusicMetaLocation());
    return musicParser.getMusicConf();
  }

  @GET
  @Path("getMusic")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public Response getMusic(@QueryParam("trackId") String trackId) throws Exception {
    return Response.ok(new File(conf.getMusicLocation() + "/abc.mp3"), MediaType.APPLICATION_OCTET_STREAM)
      .header("Content-Disposition", "attachment; filename=\"abc_pragya.mp3\"")
      .build();
  }

}