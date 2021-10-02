package pe.edu.pe.planningservice.services.impls;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.pe.planningservice.entities.Diet;
import pe.edu.pe.planningservice.repositories.DietRepository;
import pe.edu.pe.planningservice.services.DietService;

import java.util.List;
import java.util.Optional;

@Service
public class DietServiceImpl implements DietService {
    @Autowired
    private DietRepository dietRepository;

    @Transactional
    @Override
    public Diet save(Diet entity) throws Exception {
        return dietRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Diet> findAll() throws Exception {
        return dietRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Diet> findById(Long aLong) throws Exception {
        return dietRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Diet update(Diet entity) throws Exception {
        return dietRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        dietRepository.deleteById(aLong);
    }
}
