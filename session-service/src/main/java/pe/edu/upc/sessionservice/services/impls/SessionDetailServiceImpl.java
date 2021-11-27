package pe.edu.upc.sessionservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.sessionservice.entities.SessionDetail;
import pe.edu.upc.sessionservice.repositories.SessionDetailRepository;
import pe.edu.upc.sessionservice.services.SessionDetailService;
import pe.edu.upc.sessionservice.services.SessionService;

import java.util.List;
import java.util.Optional;

@Service
public class SessionDetailServiceImpl implements SessionDetailService {
    @Autowired
    private SessionDetailRepository sessionDetailRepository;

    @Transactional
    @Override
    public SessionDetail save(SessionDetail entity) throws Exception {
        return sessionDetailRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SessionDetail> findAll() throws Exception {
        return sessionDetailRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<SessionDetail> findById(Long aLong) throws Exception {
        return sessionDetailRepository.findById(aLong);
    }

    @Transactional
    @Override
    public SessionDetail update(SessionDetail entity) throws Exception {
        return sessionDetailRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        sessionDetailRepository.deleteById(aLong);
    }
}
