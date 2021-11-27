package pe.edu.upc.sessionservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.sessionservice.entities.Progress;
import pe.edu.upc.sessionservice.repositories.ProgressRepository;
import pe.edu.upc.sessionservice.services.ProgressService;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressServiceImpl implements ProgressService {
    @Autowired
    private ProgressRepository progressRepository;

    @Transactional
    @Override
    public Progress save(Progress entity) throws Exception {
        return progressRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Progress> findAll() throws Exception {
        return progressRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Progress> findById(Long aLong) throws Exception {
        return progressRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Progress update(Progress entity) throws Exception {
        return progressRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        progressRepository.deleteById(aLong);
    }
}
