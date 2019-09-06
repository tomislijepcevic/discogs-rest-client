package tslic.discogs.client.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReleaseSearchResult extends MasterSearchResult {

  private Integer masterId;
}
