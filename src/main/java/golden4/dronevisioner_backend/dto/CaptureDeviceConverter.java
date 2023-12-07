package golden4.dronevisioner_backend.dto;

import golden4.dronevisioner_backend.model.CaptureDevice;
import org.springframework.stereotype.Component;

@Component
public class CaptureDeviceConverter {

    public CaptureDevice toEntity(CaptureDeviceDTO captureDeviceDTO){
        CaptureDevice captureDevice = new CaptureDevice();

        captureDevice.setCaptureDevice_ID(captureDeviceDTO.captureDevice_ID());
        captureDevice.setBrand(captureDeviceDTO.brand());
        captureDevice.setVersion(captureDeviceDTO.version());
        captureDevice.setVisualMediaType(captureDeviceDTO.visualMediaType());

        return captureDevice;

    }

    public CaptureDeviceDTO toDTO(CaptureDevice captureDevice){
        return new CaptureDeviceDTO(
                captureDevice.getCaptureDevice_ID(),
                captureDevice.getBrand(),
                 captureDevice.getVersion(),
                captureDevice.getVisualMediaType()
        );
    }
}





