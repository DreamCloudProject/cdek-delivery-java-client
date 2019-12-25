package com.cdek.java.model.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Package {

  private String number;
  private Integer weigth;
  private Integer length;
  private Integer width;
  private Integer height;
  private String comment;
  private List<Item> items;

}
