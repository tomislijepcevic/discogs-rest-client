package tslic.discogs.client.models;

import java.net.URI;
import lombok.Data;

@Data
public class Master {

  private Integer id;

  private URI uri;

  private Integer mainRelease;
}
