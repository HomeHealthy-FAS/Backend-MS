package pe.edu.upc.sessionservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.sessionservice.entities.Session;
import pe.edu.upc.sessionservice.repositories.SessionRepository;
import pe.edu.upc.sessionservice.services.SessionService;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    @Transactional
    @Override
    public Session save(Session entity) throws Exception {
        return sessionRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Session> findAll() throws Exception {
        return sessionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Session> findById(Long aLong) throws Exception {
        return sessionRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Session update(Session entity) throws Exception {
        return sessionRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        sessionRepository.deleteById(aLong);
    }
}
