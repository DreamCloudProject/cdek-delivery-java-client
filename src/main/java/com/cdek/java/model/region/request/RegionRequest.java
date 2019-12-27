package com.cdek.java.model.region.request;

import com.cdek.java.model.handbook.Country;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RegionRequest {

  private List<Country> countryCodes;
  private String regionCode;
  private String kladrRegionCode;
  private UUID fiasRegionGuid;
  private Integer size;
  private Integer page;
  private String lang;

}
