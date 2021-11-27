package pe.edu.upc.socialservice.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Complaint;

import java.util.List;

@Service
public interface ComplaintService {
    List<Complaint> getAllComplaints();
    Complaint getComplaintById(Long id);
    Complaint createComplaint(Long customerId, Long reasonId, Complaint complaintRequest);
    Complaint updateComplaint(Long customerId, Long reasonId, Long complaintId, Complaint complaintRequest);
    Complaint deleteComplaint(Long id);
}
