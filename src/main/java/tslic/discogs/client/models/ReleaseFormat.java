package tslic.discogs.client.models;

import java.util.LinkedList;
import java.util.List;
import lombok.Data;

@Data
public class ReleaseFormat {

  private String name;

  private String text;

  private List<String> descriptions = new LinkedList<>();
}
