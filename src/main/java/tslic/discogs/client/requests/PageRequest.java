package tslic.discogs.client.requests;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class PageRequest {

  private Integer page;

  private Integer perPage;
}
