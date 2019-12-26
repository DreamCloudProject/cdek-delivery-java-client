package com.cdek.java.model.handbook;

public enum Currency {

  RUB("Российский рубль", "Россия"),
  USD("Доллар США", "США"),
  EUR("Евро", "Страны Европы"),
  KZT("Тенге", "Казахстан"),
  GBP("Фунт стерлингов", "Великобритания"),
  CNY("Юань", "Китай"),
  BYN("Белорусский рубль", "Белоруссия"),
  UAH("Гривна", "Украина"),
  AMD("Армянский драм", "Армения"),
  KGS("Киргизский сом", "Киргизия"),
  TL("Турецкая лира", "Турция"),
  THB("Тайский бат", "Тайланд"),
  KRW("Южнокорейская вона", "Южная Корея"),
  AED("Дирхам ОАЭ", "ОАЭ"),
  UZS("Узбекский сум", "Узбекистан"),
  MNT("Монгольский тугрик", "Монголия");

  private String name;
  private String country;

  Currency(String name, String country) {
    this.name = name;
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public String getCountry() {
    return country;
  }
}
