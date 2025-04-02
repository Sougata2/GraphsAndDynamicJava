package mapper;

import java.util.ArrayList;
import java.util.List;

public class StateDto implements MasterDto {
    private Integer stateId;
    private String stateName;
    private Boolean isValid;
    private List<DistrictDto> districts;

    public StateDto() {
    }

    public StateDto(Integer stateId, String stateName, Boolean isValid) {
        this.districts = new ArrayList<>();
        this.stateId = stateId;
        this.stateName = stateName;
        this.isValid = isValid;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public void addDistrict(DistrictDto district) {
        this.districts.add(district);
    }

    public List<DistrictDto> getDistricts() {
        return this.districts;
    }

    @Override
    public String toString() {
        return "StateDto{" +
                "stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                ", isValid=" + isValid +
                ", districts=" + districts +
                '}';
    }
}
