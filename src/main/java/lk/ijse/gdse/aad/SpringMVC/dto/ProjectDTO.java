package lk.ijse.gdse.aad.SpringMVC.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProjectDTO {
    private String projectId;
    private String projectName;
    private String techLeadID;
    private String projectDeadLine;
}
