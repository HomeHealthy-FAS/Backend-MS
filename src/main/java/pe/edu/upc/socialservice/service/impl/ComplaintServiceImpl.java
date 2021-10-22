package pe.edu.upc.socialservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Complaint;
import pe.edu.upc.socialservice.entity.Customer;
import pe.edu.upc.socialservice.entity.Reason;
import pe.edu.upc.socialservice.repository.ComplaintRepository;
import pe.edu.upc.socialservice.repository.CustomerRepository;
import pe.edu.upc.socialservice.repository.ReasonRepository;
import pe.edu.upc.socialservice.service.ComplaintService;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReasonRepository reasonRepository;

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id).orElse(null);
    }

    @Override
    public Complaint createComplaint(Long customerId, Long reasonId, Complaint complaintRequest) {
        Complaint complaint = complaintRequest;
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Reason reason = reasonRepository.findById(reasonId).orElse(null);

        complaint.setCustomer(customer);
        complaint.setReason(reason);

        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint updateComplaint(Long customerId, Long reasonId, Long complaintId, Complaint complaintRequest) {
        if (!customerRepository.existsById(customerId))
            return null;
        if (!reasonRepository.existsById(reasonId))
            return null;
        return complaintRepository.findById(complaintId).map(requestMap -> {
            requestMap.setDescription(complaintRequest.getDescription());
            return complaintRepository.save(requestMap);
        }).orElse(null);
    }

    @Override
    public Complaint deleteComplaint(Long id) {
        Complaint complaintDb = getComplaintById(id);
        if (complaintDb ==null){
            return  null;
        }
        complaintDb.setStatus("DELETED");
        return complaintRepository.save(complaintDb);
    }
}
