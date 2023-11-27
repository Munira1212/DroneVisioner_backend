package golden4.dronevisioner_backend.service;
<<<<<<< HEAD
import golden4.dronevisioner_backend.dto.AppointmentConverter;
import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.model.Appointment;
import golden4.dronevisioner_backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {


    @Autowired
    private final AppointmentRepository appointmentRepository;

    @Autowired
    private final AppointmentConverter appointmentConverter;

    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentConverter appointmentConverter) {
=======

import golden4.dronevisioner_backend.dto.AppointmentConverter;
import golden4.dronevisioner_backend.dto.AppointmentDTO;
import golden4.dronevisioner_backend.model.Appointment;
import golden4.dronevisioner_backend.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentService
{
    private final AppointmentRepository appointmentRepository;
    private final AppointmentConverter appointmentConverter;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentConverter appointmentConverter){
>>>>>>> 4-as-a-product-owner-i-desire-a-digital-booking-system-so-that-customers-can-streamline-appointment-scheduling
        this.appointmentRepository = appointmentRepository;
        this.appointmentConverter = appointmentConverter;
    }

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO){
        Appointment appointmentToSave = appointmentConverter.toEntity(appointmentDTO);

        // ensure it's a create
        appointmentToSave.setAppointment_ID(0);

        Appointment savedAppointment = appointmentRepository.save(appointmentToSave);

>>>>>>> 4-as-a-product-owner-i-desire-a-digital-booking-system-so-that-customers-can-streamline-appointment-scheduling
        return appointmentConverter.toDTO(savedAppointment);
    }
}
