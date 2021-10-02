package pe.edu.upc.socialservice.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Reason;

@Service
public interface ReasonService {
    Page<Reason> getAllReasons(Pageable pageable);
    Reason getReasonById(Long id);
    Reason createReason(Reason reasonRequest);
    Reason updateReason(Long id, Reason reasonRequest);
    ResponseEntity<?> deleteReason(Long id);
}
