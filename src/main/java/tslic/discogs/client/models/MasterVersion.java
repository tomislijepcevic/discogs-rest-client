package tslic.discogs.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URL;
import java.util.List;
import lombok.Data;

@Data
public class MasterVersion {

  private Integer id;

  private String title;

  private String status;

  /** Concatenated names of releases formats, delimited with comma. */
  private String format;

  private String country;

  private Integer released;

  /** Format names */
  private List<String> majorFormats;

  /** Concatenated catno's of releases labels */
  private String catno;

  private String label;

  @JsonProperty("thumb")
  private URL thumbnail;
}
