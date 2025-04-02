package mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DistrictDto implements MasterDto {
    private Integer distId;
    private String distName;
    private Boolean isValid;
    private List<CityDto> cities;
    private StateDto state;

    public DistrictDto() {
    }

    public DistrictDto(Integer distId, String distName, Boolean isValid) {
        this.distId = distId;
        this.distName = distName;
        this.isValid = isValid;
        this.cities = new ArrayList<>();
    }

    public Integer getDistId() {
        return distId;
    }

    public void setDistId(Integer distId) {
        this.distId = distId;
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public List<CityDto> getCities() {
        return cities;
    }

    public void setCities(List<CityDto> cities) {
        this.cities = cities;
    }

    public void addCity(CityDto city) {
        this.cities.add(city);
    }

    public void removeCity(CityEntity city) {
        this.cities = this.cities.stream().filter(c -> !Objects.equals(c.getCityId(), city.getCityId())).toList();
    }

    public StateDto getState() {
        return state;
    }

    public void setState(StateDto state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DistrictDto{" +
                "distId=" + distId +
                ", distName='" + distName + '\'' +
                ", isValid=" + isValid +
                ", cities=" + cities +
                ", state=" + state.getStateName() +
                '}';
    }
    
}
