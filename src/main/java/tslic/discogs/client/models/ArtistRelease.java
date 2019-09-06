package tslic.discogs.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArtistRelease extends ArtistReleaseBase {

  /** Concatenated names of releases formats, delimited with comma. */
  private String format;

  private String status;

  /** Concatenated names of releases labels */
  private String label;

  @JsonProperty("trackinfo")
  private String trackInfo;
}
