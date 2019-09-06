package tslic.discogs.client.models;

import java.net.URL;
import lombok.Data;

@Data
public class ArtistSummary {

  private Integer id;

  private String name;

  private URL thumbnailUrl;
}
