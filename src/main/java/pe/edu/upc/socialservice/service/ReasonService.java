package pe.edu.upc.socialservice.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Reason;

import java.util.List;

@Service
public interface ReasonService {
    List<Reason> getAllReasons();
    Reason getReasonById(Long id);
    Reason createReason(Reason reasonRequest);
    Reason updateReason(Long id, Reason reasonRequest);
    Reason deleteReason(Long id);
}
