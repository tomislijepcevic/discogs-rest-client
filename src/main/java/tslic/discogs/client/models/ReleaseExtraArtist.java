package tslic.discogs.client.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReleaseExtraArtist extends ReleaseArtist {

  private String role;
}
