package tslic.discogs.client.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class MasterVersionsRequest extends PageRequest {

  private String format;

  private String label;

  private String released;

  private String country;

  private SortField sort;

  private SortOrder sortOrder;

  public enum SortField {
    RELEASED,
    TITLE,
    FORMAT,
    LABEL,
    CATNO,
    COUNTRY;

    @Override
    public String toString() {
      return super.toString().toLowerCase();
    }
  }
}
