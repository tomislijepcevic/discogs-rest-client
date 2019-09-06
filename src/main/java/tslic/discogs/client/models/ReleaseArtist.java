package tslic.discogs.client.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReleaseArtist extends ArtistSummary {

  private String anv;

  private String join;

  private String tracks;
}
