package pe.edu.upc.socialservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Reason;
import pe.edu.upc.socialservice.repository.ReasonRepository;
import pe.edu.upc.socialservice.service.ReasonService;

import java.util.List;

@Service
public class ReasonServiceImpl implements ReasonService {

    @Autowired
    private ReasonRepository reasonRepository;

    @Override
    public List<Reason> getAllReasons() {
        return reasonRepository.findAll();
    }

    @Override
    public Reason getReasonById(Long id) {
        return reasonRepository.findById(id).orElse(null);
    }

    @Override
    public Reason createReason(Reason reasonRequest) {
        return reasonRepository.save(reasonRequest);
    }

    @Override
    public Reason updateReason(Long id, Reason reasonRequest) {
        Reason reasonDb = reasonRepository.findById(id).orElse(null);
        if (reasonDb == null){
            return null;
        }
        reasonDb.setDescription(reasonRequest.getDescription());
        reasonDb.setStatus(reasonRequest.getStatus());

        return reasonRepository.save(reasonDb);
    }

    @Override
    public Reason deleteReason(Long id) {
        Reason reasonDb = reasonRepository.findById(id).orElse(null);
        if (reasonDb == null){
            return null;
        }
        reasonDb.setStatus("DELETED");

        return reasonRepository.save(reasonDb);
    }
}
