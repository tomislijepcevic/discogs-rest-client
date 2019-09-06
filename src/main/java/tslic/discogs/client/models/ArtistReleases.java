package tslic.discogs.client.models;

import java.util.List;
import lombok.Data;

@Data
public class ArtistReleases {

  private Pagination pagination;

  private List<ArtistReleaseBase> releases;
}
