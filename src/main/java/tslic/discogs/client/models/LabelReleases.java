package tslic.discogs.client.models;

import java.util.List;
import lombok.Data;

@Data
public class LabelReleases {

  private Pagination pagination;

  private List<LabelRelease> releases;
}
