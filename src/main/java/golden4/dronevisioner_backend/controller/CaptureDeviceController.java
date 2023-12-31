package golden4.dronevisioner_backend.controller;

import golden4.dronevisioner_backend.dto.CaptureDeviceDTO;
import golden4.dronevisioner_backend.model.CaptureDevice;
import golden4.dronevisioner_backend.service.CaptureDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CaptureDeviceController {


    private final CaptureDeviceService captureDeviceService;

    @Autowired
    public CaptureDeviceController(CaptureDeviceService captureDeviceService) {
        this.captureDeviceService = captureDeviceService;
    }
  /*  @PostMapping("/captureDevice")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CaptureDeviceDTO> createCaptureDevice(@RequestBody CaptureDeviceDTO captureDeviceDTO) {
        CaptureDeviceDTO createdCaptureDevice = captureDeviceService.createCaptureDevice(captureDeviceDTO);
        return new ResponseEntity<>(createdCaptureDevice, HttpStatus.CREATED);
    }*/

  @PostMapping("/captureDevice")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CaptureDeviceDTO> createCaptureDevice(@RequestBody CaptureDeviceDTO captureDeviceDTO){
        System.out.println(captureDeviceDTO);
        CaptureDeviceDTO createCaptureDevice = captureDeviceService.createCaptureDevice(captureDeviceDTO);
        return new ResponseEntity<>(createCaptureDevice, HttpStatus.CREATED);

    }

   /* @GetMapping("/captureDevice/{id}")
    public ResponseEntity getCaptureDeviceByID(@PathVariable int id) {
        return new ResponseEntity<>(captureDeviceService.getCaptureDeviceByID() , HttpStatus.OK);
    }*/
    @GetMapping("captureDevice/{captureDeviceId}")
    public ResponseEntity<CaptureDeviceDTO> getCaptureDeviceById(@PathVariable int captureDeviceId) {
        try {
            CaptureDeviceDTO captureDeviceDTO = captureDeviceService.getCaptureDeviceById(captureDeviceId);
            return ResponseEntity.ok(captureDeviceDTO);
        } catch (Exception e) {
            // Handle exceptions, e.g., captureDevice not found
            return ResponseEntity.notFound().build();
        }
    }


}
