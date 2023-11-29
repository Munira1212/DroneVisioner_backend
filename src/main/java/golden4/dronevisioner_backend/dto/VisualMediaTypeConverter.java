package golden4.dronevisioner_backend.dto;

import golden4.dronevisioner_backend.model.VisualMediaType;
import org.springframework.stereotype.Component;

@Component
public class VisualMediaTypeConverter {

    public VisualMediaType toEntity(VisualMediaTypeDTO visualMediaTypeDTO){
        VisualMediaType visualMediaType = new VisualMediaType();
        visualMediaType.setVisualMediaType_ID(visualMediaTypeDTO.visualMediaType_ID());
        visualMediaType.setType_Name(visualMediaTypeDTO.type_Name());

        return visualMediaType;

    }

    public VisualMediaTypeDTO toDTO(VisualMediaType visualMediaType){
        return new VisualMediaTypeDTO(
              visualMediaType.getVisualMediaType_ID(),
              visualMediaType.getType_Name()
        );
    }
}
