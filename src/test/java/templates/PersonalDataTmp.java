package templates;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonalDataTmp {
    private String _sort;
    private String _elements;
    @JsonProperty("organization:not")
    private String organizationNot;
    private Integer _page;
    private Integer _count;
    @JsonProperty("family:missing")
    private Boolean familyMissing;


}
