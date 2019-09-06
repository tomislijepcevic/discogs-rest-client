package tslic.discogs.client.models;

import java.net.URI;
import lombok.Data;

@Data
public class Video {

  private URI uri;

  private String duration;

  private Boolean embed;

  private String title;

  private String description;
}
