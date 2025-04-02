package mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DistrictEntity implements MasterEntity {
    private Integer distId;
    private String distName;
    private Boolean isValid;
    private List<CityEntity> cities;
    private StateEntity state;

    public DistrictEntity() {
    }

    public DistrictEntity(Integer distId, String distName, Boolean isValid) {
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

    public List<CityEntity> getCities() {
        return cities;
    }

    public void setCities(List<CityEntity> cities) {
        this.cities = cities;
    }

    public void addCity(CityEntity city) {
        this.cities.add(city);
    }

    public void removeCity(CityEntity city) {
        this.cities = this.cities.stream().filter(c -> !Objects.equals(c.getCityId(), city.getCityId())).toList();
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "DistrictEntity{" +
                "distId=" + distId +
                ", distName='" + distName + '\'' +
                ", isValid=" + isValid +
                ", cities=" + cities +
                ", state=" + state.getStateName() +
                '}';
    }
}
