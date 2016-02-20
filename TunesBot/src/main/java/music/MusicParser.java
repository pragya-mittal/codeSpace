package music;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pragya.mittal on 2/20/16.
 */
public class MusicParser {

    private String file;
    private HashMap<String, MusicConf> mapMusic;

    public MusicParser(String file) {
        mapMusic = new HashMap<>();
        this.file = file;
    }

    public HashMap<String, MusicConf> getMusicConf() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // Convert JSON string from file to Object
        try {
            mapMusic = mapper.readValue(new File(file), new TypeReference<Map<String, MusicConf>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(mapMusic);
        return mapMusic;
    }



}
