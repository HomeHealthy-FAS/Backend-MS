package pe.edu.upc.sessionservice.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.sessionservice.entities.AvailableSchedule;
import pe.edu.upc.sessionservice.repositories.AvailableScheduleRepository;
import pe.edu.upc.sessionservice.services.AvailableScheduleService;

import java.util.List;
import java.util.Optional;

@Service
public class AvailableScheduleServiceImpl implements AvailableScheduleService {
    @Autowired
    private AvailableScheduleRepository availableScheduleRepository;

    @Transactional
    @Override
    public AvailableSchedule save(AvailableSchedule entity) throws Exception {
        return availableScheduleRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AvailableSchedule> findAll() throws Exception {
        return availableScheduleRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<AvailableSchedule> findById(Long aLong) throws Exception {
        return availableScheduleRepository.findById(aLong);
    }

    @Transactional
    @Override
    public AvailableSchedule update(AvailableSchedule entity) throws Exception {
        return availableScheduleRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        availableScheduleRepository.deleteById(aLong);
    }
}
