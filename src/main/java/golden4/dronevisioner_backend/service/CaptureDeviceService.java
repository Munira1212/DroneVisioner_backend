package golden4.dronevisioner_backend.service;

import golden4.dronevisioner_backend.dto.CaptureDeviceConverter;
import golden4.dronevisioner_backend.dto.CaptureDeviceDTO;
import golden4.dronevisioner_backend.dto.VisualMediaTypeConverter;
import golden4.dronevisioner_backend.dto.VisualMediaTypeDTO;
import golden4.dronevisioner_backend.model.CaptureDevice;
import golden4.dronevisioner_backend.model.VisualMediaType;
import golden4.dronevisioner_backend.repository.CaptureDeviceRepository;
import golden4.dronevisioner_backend.repository.VisualMediaTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CaptureDeviceService {


    private final CaptureDeviceRepository captureDeviceRepository;

    private final VisualMediaTypeRepository visualMediaTypeRepository;

    private final CaptureDeviceConverter captureDeviceConverter;

    private final VisualMediaTypeConverter visualMediaTypeConverter;


    VisualMediaTypeService visualMediaTypeService;
    @Autowired
    public CaptureDeviceService(CaptureDeviceRepository captureDeviceRepository, VisualMediaTypeRepository visualMediaTypeRepository, CaptureDeviceConverter captureDeviceConverter, VisualMediaTypeConverter visualMediaTypeConverter) {
        this.captureDeviceRepository = captureDeviceRepository;
        this.visualMediaTypeRepository = visualMediaTypeRepository;
        this.captureDeviceConverter = captureDeviceConverter;
        this.visualMediaTypeConverter = visualMediaTypeConverter;
    }


    public CaptureDeviceDTO createCaptureDevice(CaptureDeviceDTO captureDeviceDTO) {
        System.out.println("save: " + captureDeviceDTO);

        CaptureDevice captureDeviceToSave = captureDeviceConverter.toEntity(captureDeviceDTO);
        CaptureDevice savedCaptureDevice = captureDeviceRepository.save(captureDeviceToSave);
        return captureDeviceConverter.toDTO(savedCaptureDevice);
    }

    @Transactional
    public CaptureDeviceDTO saveCaptureDevice(CaptureDeviceDTO captureDeviceDTO) {
        System.out.println("saveCaptureDevice: " + captureDeviceDTO);
        // Convert the DTO to an entity
        CaptureDevice captureDeviceToSave = captureDeviceConverter.toEntity(captureDeviceDTO);

        // Save the CaptureDevice entity
        CaptureDevice savedCaptureDevice = captureDeviceRepository.save(captureDeviceToSave);

        // Convert the saved entity back to DTO
        return captureDeviceConverter.toDTO(savedCaptureDevice);
    }




    /*public List<CaptureDeviceDTO> getCaptureDeviceByID(int id){
        List<CaptureDevice> getCaptureDeviceByID = captureDeviceRepository.findAllById(id);

        return getCaptureDeviceByID.stream().map(captureDeviceConverter::toDTO).toList();
    }*/


    public CaptureDeviceDTO getCaptureDeviceById(int captureDeviceId) {
        CaptureDevice captureDevice = captureDeviceRepository.findById(captureDeviceId)
                .orElseThrow(() -> new RuntimeException("CaptureDevice not found"));

        return captureDeviceConverter.toDTO(captureDevice);
               // convertEntityToDTO(captureDevice);
    }


}










