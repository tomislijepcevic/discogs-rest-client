package tslic.discogs.client.models;

import java.net.URL;
import lombok.Data;

@Data
public class Company {

  private Integer id;

  private String name;

  private String catno;

  private URL thumbnailUrl;
}
