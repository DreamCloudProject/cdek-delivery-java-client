package com.cdek.java.model.region.request;

import com.cdek.java.model.handbook.Country;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RegionRequest {

  private List<Country> countryCode;
  private String regionCode;
  private String kladrRegionCode;
  private UUID fiasRegionGuid;
  private Integer size;
  private Integer page;
  private String lang;

}
