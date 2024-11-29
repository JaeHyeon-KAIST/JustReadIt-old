package jri.AladdinOpenAPI;

public class SeriesInfo {

  private int seriesId;
  private String seriesLink;
  private String seriesName;

  // 기본 생성자
  public SeriesInfo() {
  }

  // 게터와 세터 메서드

  public int getSeriesId() {
    return seriesId;
  }

  public void setSeriesId(int seriesId) {
    this.seriesId = seriesId;
  }

  public String getSeriesLink() {
    return seriesLink;
  }

  public void setSeriesLink(String seriesLink) {
    this.seriesLink = seriesLink;
  }

  public String getSeriesName() {
    return seriesName;
  }

  public void setSeriesName(String seriesName) {
    this.seriesName = seriesName;
  }
}
