import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/music")
public class DownloadResource {

    String musicLoc = "";

    public DownloadResource(String musicLoc) {
        this.musicLoc = musicLoc;

    }

    @GET
    @Path("getMusicList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMusicList() throws Exception {
        return Response.ok(new File(musicLoc+"/abc.mp3"), MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"abc_pragya.mp3\"")
                .build();
    }

    @GET
    @Path("getMusic")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getMusic(@QueryParam("trackId") String trackId) throws Exception {
        return Response.ok(new File(musicLoc+"/abc.mp3"), MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"abc_pragya.mp3\"")
                .build();
    }

}