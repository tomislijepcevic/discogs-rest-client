package tslic.discogs.client.models;

import lombok.Data;

@Data
public class Image {

  private Integer height;

  private Integer width;

  private String resourceUrl;

  private String type;

  private String uri;

  private String uri150;
}
