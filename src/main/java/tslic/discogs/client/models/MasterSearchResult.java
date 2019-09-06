package tslic.discogs.client.models;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MasterSearchResult extends SearchResult {

  private String catno;

  private String country;

  private Integer year;

  private List<String> genre;

  private List<String> style;

  private List<String> label;

  private List<String> format;
}
