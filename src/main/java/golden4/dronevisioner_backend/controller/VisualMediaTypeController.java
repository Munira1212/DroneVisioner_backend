package golden4.dronevisioner_backend.controller;

import golden4.dronevisioner_backend.dto.CaptureDeviceDTO;
import golden4.dronevisioner_backend.dto.VisualMediaTypeDTO;
import golden4.dronevisioner_backend.service.VisualMediaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class VisualMediaTypeController {

@Autowired
    VisualMediaTypeService visualMediaTypeService;

  /*  @PostMapping("/visualMediaType")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VisualMediaTypeDTO> createVisualMediaType(@RequestBody VisualMediaTypeDTO visualMediaTypeDTO){
        System.out.println(visualMediaTypeDTO);
        VisualMediaTypeDTO createVisualMediaType = visualMediaTypeService.createVisualMediaType(visualMediaTypeDTO);
        return new ResponseEntity<>(createVisualMediaType, HttpStatus.CREATED);

    }*/


    @GetMapping("/visualMediaType")
    public ResponseEntity getAllvisualMediaType() {
        return new ResponseEntity<>(visualMediaTypeService.getAllVisualMediaType(), HttpStatus.OK);
    }
    @PostMapping("/PostVisualMediaType")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VisualMediaTypeDTO> createCaptureDevice(@RequestBody VisualMediaTypeDTO visualMediaTypeDTO){
        System.out.println(visualMediaTypeDTO);
        VisualMediaTypeDTO createvisualMediaType = visualMediaTypeService.createVisualMediaType(visualMediaTypeDTO);
        return new ResponseEntity<>(createvisualMediaType, HttpStatus.CREATED);

    }





}
