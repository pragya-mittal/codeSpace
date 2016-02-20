//package adserver;
//
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//import config.AppConfig;
//
///**
// * Created by deepak.barr on 20/02/16.
// */
//public enum AdClient {
//  INSTANCE;
//  private AppConfig conf;
//
//  public static AdClient get() {
//    return INSTANCE;
//  }
//
//  public void init(AppConfig conf) {
//    this.conf = conf;
//  }
//
//  public String downloadAd() throws IOException {
//    Client client = Client.create();
//    WebResource webResource = client.resource("http://172.20.201.232:8080/service/orders");
//    ClientResponse response = webResource.accept("application/octet-stream")
//      .get(ClientResponse.class);
//
//    File s = response.getEntity(File.class);
//    File ff = new File(conf.getAdsLocation() + "/" + s.getName());
//    s.renameTo(ff);
//    FileWriter fr = new FileWriter(s);
//    fr.flush();
//    return ff.getAbsolutePath();
//  }
//
//  public void mergeWithAd(String musicFile) {
//    try {
//      String adFile = downloadAd();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//
//  }
//}
