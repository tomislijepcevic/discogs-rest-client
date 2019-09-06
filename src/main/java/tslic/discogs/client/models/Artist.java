package tslic.discogs.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import lombok.Data;

@Data
public class Artist {

  private Integer id;

  private URI uri;

  private String name;

  @JsonProperty("realname")
  private String realName;

  private String profile;

  private String dataQuality;

  @JsonProperty("namevariations")
  private List<String> nameVariations = new LinkedList<>();

  private List<String> urls = new LinkedList<>();

  private List<ArtistAlias> aliases = new LinkedList<>();

  private List<Group> groups = new LinkedList<>();

  private List<Member> members = new LinkedList<>();

  private List<Image> images = new LinkedList<>();
}
