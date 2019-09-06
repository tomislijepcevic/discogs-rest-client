package tslic.discogs.client.models;

import lombok.Data;

@Data
public class Pagination {

  private Integer items;

  private Integer page;

  private Integer perPage;

  private Integer pages;
}
