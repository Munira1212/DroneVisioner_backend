package golden4.dronevisioner_backend.dto;

import golden4.dronevisioner_backend.model.VisualMediaType;

public record CaptureDeviceDTO(int captureDevice_ID, String brand, String version, VisualMediaType visualMediaType) {
}
