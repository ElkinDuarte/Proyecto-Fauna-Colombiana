    package com.example.fauna_colombiana1.service;

    import com.example.fauna_colombiana1.model.TmAnimal;
    import com.example.fauna_colombiana1.repository.AnimalRepository;
    import org.springframework.stereotype.Service;

    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;


    @Service
    public class AnimalService {

        private final AnimalRepository repository;

        public AnimalService(AnimalRepository repository) {
            this.repository = repository;
        }

        public Page<TmAnimal> findAll(Pageable pageable) {
            return repository.findAll(pageable);
        }

        public TmAnimal findById(Integer id) {
            return repository.findById(id).orElse(null);
        }

        public TmAnimal save(TmAnimal animal) {
            return repository.save(animal);
        }

        public void delete(Integer id) {
            repository.deleteById(id);
        }
    }
