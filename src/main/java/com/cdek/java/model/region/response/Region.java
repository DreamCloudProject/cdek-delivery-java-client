package com.cdek.java.model.region.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Region {

  @Size(max = 2)
  private String countryCode;

  @Size(max = 255)
  private String country;

  @Size(max = 255)
  private String region;

  @Size(max = 255)
  private String regionCode;

  @Size(max = 255)
  private String kladrRegionCode;

  private UUID fiasRegionCode;

  private List<Error> errors;

}
