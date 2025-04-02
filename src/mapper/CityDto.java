package mapper;

public class CityDto implements MasterDto {
    private Integer cityId;
    private String cityName;
    private Boolean isValid;
    private DistrictDto district;


    public CityDto() {
    }

    public CityDto(Integer cityId, String cityName, Boolean isValid) {
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

    public DistrictDto getDistrict() {
        return this.district;
    }

    public void setDistrict(DistrictDto district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", isValid=" + isValid +
                ", district=" + district.getDistName() +
                '}';
    }
}
