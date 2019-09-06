package tslic.discogs.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URL;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LabelRelease extends ReleaseSummary {

  private Integer year;

  private String status;

  //   concatenated names of release formats, delimited with comma
  private String format;

  //  concatenated names of release main artists
  private String artist;

  private String catno;

  @JsonProperty("thumb")
  private URL thumbnail;
}
