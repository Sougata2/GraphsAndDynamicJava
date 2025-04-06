package mapper;

public class CityEntity implements MasterEntity {
    private Integer cityId;
    private String cityName;
    private Boolean isValid;
    private DistrictEntity district;


    public CityEntity() {
    }

    public CityEntity(Integer cityId, String cityName, Boolean isValid) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.isValid = isValid;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public DistrictEntity getDistrict() {
        return this.district;
    }

    public void setDistrict(DistrictEntity district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "{" +
                "\"cityId\":" + cityId +
                ", \"cityName\":\"" + cityName + '\"' +
                ", \"isValid\":" + isValid +
                ", \"district\":\"" + district.getDistName() + "\"" +
                '}';
    }

    @Override
    public Integer getId() {
        return this.cityId;
    }
}
