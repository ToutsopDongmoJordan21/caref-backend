package com.project.caref.controllers;

import com.project.caref.exeption.ResourceNotFoundException;
import com.project.caref.models.Accessoire;
import com.project.caref.models.dto.AccessoireDto;
import com.project.caref.repository.AccessoireRepository;
import com.project.caref.service.AccessoireDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AccessoireController {
    @Autowired
    private AccessoireRepository accessoireRepository;

    @Autowired
    private AccessoireDetailsService accessoireDetailsService;

    @GetMapping("/accessoires")
    public ResponseEntity<?> getAllAccessoires() {

        return ResponseEntity.ok(accessoireDetailsService.findAllAccessoire());
    }

    @GetMapping("/accessoires/{id}")
    public ResponseEntity<?> getAccessoireById(@PathVariable(value = "id") Long accessoireId) {
        return ResponseEntity.ok(accessoireDetailsService.findOneAccessoireById(accessoireId));
    }

    @PostMapping("/accessoires")
    public ResponseEntity<?> saveAccessoires(@Valid @RequestBody AccessoireDto accessoire) throws Exception {
        return ResponseEntity.ok(accessoireDetailsService.save(accessoire));
    }

    @DeleteMapping("/accessoires/{id}")
    public Map<String, Boolean> deleteAccessoire(@PathVariable(value = "id") Long accessoireId)
        throws ResourceNotFoundException {
        Accessoire accessoire = accessoireRepository.findById(accessoireId)
                .orElseThrow(() -> new ResourceNotFoundException("Accessoire not found for this id :: " +accessoireId));

        accessoireRepository.delete(accessoire);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Accessoire was successful delete", Boolean.TRUE);
        return response;
    }

    @PutMapping("/accessoires/{id}")
    public ResponseEntity<?> updateAccessoire(@PathVariable(value = "id") Long accessoireId,
                                                       @RequestBody AccessoireDto accessoireDto) throws ResourceNotFoundException{

        return ResponseEntity.ok(accessoireDetailsService.updateAccessoire(accessoireId, accessoireDto));
    }

}
