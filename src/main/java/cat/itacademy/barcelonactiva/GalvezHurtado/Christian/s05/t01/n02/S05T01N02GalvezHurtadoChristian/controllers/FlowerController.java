package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n02.S05T01N02GalvezHurtadoChristian.controllers;

import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n02.S05T01N02GalvezHurtadoChristian.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n02.S05T01N02GalvezHurtadoChristian.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n02.S05T01N02GalvezHurtadoChristian.model.dto.Message;
import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n02.S05T01N02GalvezHurtadoChristian.model.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerController {

    @Autowired
    FlowerService flowerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<FlowerDTO>> listFlowers(){
        List<FlowerDTO> flowers = flowerService.listDTOs();
        return new ResponseEntity<List<FlowerDTO>>(flowers, HttpStatus.OK);
    }

    @GetMapping("/getOne/{idFlower}")
    public ResponseEntity<FlowerDTO> flowerById(@PathVariable("idFlower") int idFlower){

        if(!flowerService.existByIdFlower(idFlower)) {
            return new ResponseEntity(new Message("This Flower doesn't exist."), HttpStatus.NOT_FOUND);
        }else {
            FlowerDTO flower = flowerService.convertToDTO(flowerService.getFlower(idFlower).get());
            return new ResponseEntity(flower, HttpStatus.OK);
        }
    }

    //Ponemos ? para no devolver ningún tipo de dato
    @PostMapping("/add")
    public ResponseEntity<?> createFlower(@RequestBody FlowerDTO flowerDTO){

        //Antiguamente StringUtils.isBlank(contenidoAVerSiEstáVacío)
        if(flowerDTO.getNameFlower() == null){
            return new ResponseEntity<>(new Message("Name is required."), HttpStatus.BAD_REQUEST);
        } else if(flowerDTO.getCountryFlower().isBlank()){
            return new ResponseEntity<>(new Message("Country is required."), HttpStatus.BAD_REQUEST);
        } else {
            FlowerEntity flower = new FlowerEntity(flowerDTO.getNameFlower(), flowerDTO.getCountryFlower());
            flowerService.saveFlower(flower);
            return new ResponseEntity<>(new Message("Flower created."), HttpStatus.OK);
        }
    }

    @PutMapping("/update/{idFlower}")
    public ResponseEntity<?> updateFlower(@PathVariable("idFlower") int idFlower, @RequestBody FlowerDTO flowerDTO){

        if (!flowerService.existByIdFlower(idFlower)){
            return new ResponseEntity<>(new Message("This Flower doesn't exist."), HttpStatus.NOT_FOUND);
        }else if (flowerDTO.getNameFlower() == null || flowerDTO.getCountryFlower() == null){
            return new ResponseEntity<>(new Message("Name and Country is required."), HttpStatus.BAD_REQUEST);
        }else {
            flowerService.getFlower(idFlower).get().setNameFlower(flowerDTO.getNameFlower());
            flowerService.getFlower(idFlower).get().setCountryFlower(flowerDTO.getCountryFlower());
            return new ResponseEntity<>(new Message("Flower Updated." + flowerService.getFlower(idFlower).get().toString()), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{idFlower}")
    public ResponseEntity<?> deleteFlower(@PathVariable("idFlower") int idFlower){
        if (!flowerService.existByIdFlower(idFlower)){
            return new ResponseEntity<>(new Message("This Flower doesn't exist."), HttpStatus.NOT_FOUND);
        }else{
            flowerService.deleteFlower(idFlower);
            return new ResponseEntity<>(new Message("Flower deleted."), HttpStatus.OK);
        }
    }
}