package pe.edu.upc.product.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.product.entities.Routine;
import pe.edu.upc.product.repositories.RoutineRepository;
import pe.edu.upc.product.services.RoutineService;

import java.util.List;
import java.util.Optional;

@Service
public class RoutineServiceImpl implements RoutineService {

    @Autowired
    private RoutineRepository routineRepository;

    @Transactional
    @Override
    public Routine save(Routine entity) throws Exception {
        return routineRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Routine> findAll() throws Exception {
        return routineRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Routine> findById(Long aLong) throws Exception {
        return routineRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Routine update(Routine entity) throws Exception {
        return routineRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        routineRepository.deleteById(aLong);
    }
}
