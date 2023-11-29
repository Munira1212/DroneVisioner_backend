package golden4.dronevisioner_backend.service;

import golden4.dronevisioner_backend.dto.CaptureDeviceConverter;
import golden4.dronevisioner_backend.dto.CaptureDeviceDTO;
import golden4.dronevisioner_backend.dto.VisualMediaTypeConverter;
import golden4.dronevisioner_backend.dto.VisualMediaTypeDTO;
import golden4.dronevisioner_backend.model.CaptureDevice;
import golden4.dronevisioner_backend.model.VisualMediaType;
import golden4.dronevisioner_backend.repository.CaptureDeviceRepository;
import golden4.dronevisioner_backend.repository.VisualMediaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualMediaTypeService {

    @Autowired
    private final CaptureDeviceRepository captureDeviceRepository;
    @Autowired
    private final VisualMediaTypeRepository visualMediaTypeRepository;
    @Autowired
    private final CaptureDeviceConverter captureDeviceConverter;
    @Autowired
    private final VisualMediaTypeConverter visualMediaTypeConverter;

    @Autowired
    public VisualMediaTypeService(CaptureDeviceRepository captureDeviceRepository, VisualMediaTypeRepository visualMediaTypeRepository, CaptureDeviceConverter captureDeviceConverter, VisualMediaTypeConverter visualMediaTypeConverter) {
        this.captureDeviceRepository = captureDeviceRepository;
        this.visualMediaTypeRepository = visualMediaTypeRepository;
        this.captureDeviceConverter = captureDeviceConverter;
        this.visualMediaTypeConverter = visualMediaTypeConverter;
    }

    public VisualMediaTypeDTO createVisualMediaType(VisualMediaTypeDTO visualMediaTypeDTO){
        System.out.println("save: " + visualMediaTypeDTO);
        VisualMediaType visualMediaTypeToSave = visualMediaTypeConverter.toEntity(visualMediaTypeDTO);
        VisualMediaType savedvisualmediatype = visualMediaTypeRepository.save(visualMediaTypeToSave);

        return visualMediaTypeConverter.toDTO(savedvisualmediatype);
    }


    public List< VisualMediaTypeDTO> getAllVisualMediaType(){
        List< VisualMediaType> getVisualMediaType = visualMediaTypeRepository.findAll();
        return getVisualMediaType.stream().map(visualMediaTypeConverter::toDTO).toList();
    }


}
