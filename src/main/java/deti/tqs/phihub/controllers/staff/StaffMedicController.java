package deti.tqs.phihub.controllers.staff;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import deti.tqs.phihub.dtos.MedicSchema;
import deti.tqs.phihub.models.Medic;
import deti.tqs.phihub.models.Speciality;
import deti.tqs.phihub.services.MedicService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/staff/medics")
public class StaffMedicController {

    private MedicService medicService;

    public StaffMedicController(MedicService medicService) {
        this.medicService = medicService;
    }

    @PostMapping
    public ResponseEntity<Medic> saveMedic(@RequestBody MedicSchema medicSchema) {

        Medic medic = new Medic();
        medic.setName(medicSchema.name());
        medic.setSpecialities(Speciality.fromStrings(medicSchema.specialities()));

        Medic savedMedic = medicService.save(medic);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedic);
    }


}
