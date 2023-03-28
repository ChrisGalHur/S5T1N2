package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n02.S05T01N02GalvezHurtadoChristian.model.services;

import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n02.S05T01N02GalvezHurtadoChristian.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n02.S05T01N02GalvezHurtadoChristian.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n02.S05T01N02GalvezHurtadoChristian.model.repository.FlowerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlowerService {

    @Autowired
    FlowerRepository flowerRepository;

    public FlowerDTO convertToDTO(FlowerEntity flowerEntity){
        return new FlowerDTO(flowerEntity.getPk_FlorID(), flowerEntity.getNameFlower(),flowerEntity.getCountryFlower());
    }

    public List<FlowerEntity> listFlower(){
        return flowerRepository.findAll();
    }

    public Optional<FlowerEntity> getFlower(int idFlower){
        return flowerRepository.findById(idFlower);
    }

    public void saveFlower(FlowerEntity flowerEntity){
        flowerRepository.save(flowerEntity);
    }

    public void deleteFlower(int idFlower){
        flowerRepository.deleteById(idFlower);
    }

    public boolean existByIdFlower(int idFlower){
        return flowerRepository.existsById(idFlower);
    }

    public List<FlowerDTO> listDTOs(){
        return flowerRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}