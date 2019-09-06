package tslic.discogs.client.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class ArtistReleasesRequest extends PageRequest {

  private SortField sort;

  private SortOrder sortOrder;

  public enum SortField {
    YEAR,
    TITLE,
    FORMAT;

    @Override
    public String toString() {
      return super.toString().toLowerCase();
    }
  }
}
