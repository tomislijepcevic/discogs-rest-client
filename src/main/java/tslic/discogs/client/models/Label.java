package tslic.discogs.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import lombok.Data;

@Data
public class Label {

  private Integer id;

  private URI uri;

  private String name;

  private String contactInfo;

  private String profile;

  private String dataQuality;

  private List<String> urls = new LinkedList<>();

  private LabelSummary parentLabel;

  @JsonProperty("sublabels")
  private List<LabelSummary> subLabels = new LinkedList<>();

  private List<Image> images = new LinkedList<>();
}
