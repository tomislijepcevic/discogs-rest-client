package tslic.discogs.client.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class SearchRequest extends PageRequest {

  private Integer page;

  private Integer perPage;

  private String query;

  private SearchType type;

  private String title;

  private String releaseTitle;

  private String credit;

  private String artist;

  private String anv;

  private String label;

  private String genre;

  private String style;

  private String country;

  private String year;

  private String format;

  private String catno;

  private String barcode;

  private String track;

  public enum SearchType {
    RELEASE,
    MASTER,
    ARTIST,
    LABEL;

    @Override
    public String toString() {
      return super.toString().toLowerCase();
    }
  }
}
