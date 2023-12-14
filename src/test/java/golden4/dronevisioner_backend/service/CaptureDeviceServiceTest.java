package golden4.dronevisioner_backend.service;

import golden4.dronevisioner_backend.dto.CaptureDeviceConverter;
import golden4.dronevisioner_backend.dto.CaptureDeviceDTO;
import golden4.dronevisioner_backend.model.CaptureDevice;
import golden4.dronevisioner_backend.model.VisualMediaType;
import golden4.dronevisioner_backend.repository.CaptureDeviceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;




class CaptureDeviceServiceTest {
    @InjectMocks
    private CaptureDeviceService captureDeviceService;
    @Mock
    private CaptureDeviceRepository captureDeviceRepository;

    @Mock
    private CaptureDeviceConverter captureDeviceConverter;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getCaptureDeviceById() {
        // Arrange
        CaptureDevice captureDevice = new CaptureDevice();
        int existingCaptureDeviceId = 1;

        when(captureDeviceRepository.findById(existingCaptureDeviceId)).thenReturn(Optional.of(captureDevice));

        VisualMediaType visualMediaType = new VisualMediaType(1, "drone");
        CaptureDeviceDTO expectedDTO = new CaptureDeviceDTO(1, "canon", "black 13", visualMediaType);
        when(captureDeviceConverter.toDTO(captureDevice)).thenReturn(expectedDTO);

        // Act
        CaptureDeviceDTO resultDTO = captureDeviceService.getCaptureDeviceById(existingCaptureDeviceId);

        // Assert
        assertEquals(expectedDTO, resultDTO);
    }





}