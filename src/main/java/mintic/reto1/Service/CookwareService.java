package mintic.reto1.Service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mintic.reto1.Model.Cookware;
import mintic.reto1.Repository.CookwareRepository;


@Service
public class CookwareService {
    @Autowired
    private CookwareRepository CookwareRepository;

    public List<Cookware> getAll() {
        return CookwareRepository.getAll();
    }

   public Optional<Cookware> getCookware(String reference) {
        return CookwareRepository.getCookware(reference);
    }

    public Cookware create(Cookware cookware) {
        if (cookware.getReference() == null) {
            return cookware;
        } else {
            return CookwareRepository.create(cookware);
        }
    }

    public Cookware update(Cookware cookware) {

        if (cookware.getReference() != null) {
            Optional<Cookware> CookwareDb = CookwareRepository.getCookware(cookware.getReference());
            if (CookwareDb.isPresent()) {
                
                if (cookware.getBrand()!= null) {
                    CookwareDb.get().setBrand(cookware.getBrand());
                }
                
                if (cookware.getCategory() != null) {
                    CookwareDb.get().setCategory(cookware.getCategory());
                }

                if (cookware.getMateriales() != null) {
                    CookwareDb.get().setMateriales(cookware.getMateriales());
                }

                if (cookware.getDimensiones() != null) {
                    CookwareDb.get().setDimensiones(cookware.getDimensiones());
                }

                /*if (cookware.getSize() != null) {
                    CookwareDb.get().setSize(cookware.getSize());
                }*/
                
                if (cookware.getDescription() != null) {
                    CookwareDb.get().setDescription(cookware.getDescription());
                }
                if (cookware.getPrice() != 0.0) {
                    CookwareDb.get().setPrice(cookware.getPrice());
                }
                if (cookware.getQuantity() != 0) {
                    CookwareDb.get().setQuantity(cookware.getQuantity());
                }
                if (cookware.getPhotography() != null) {
                    CookwareDb.get().setPhotography(cookware.getPhotography());
                }
                
                CookwareDb.get().setAvailability(cookware.isAvailability());
                CookwareRepository.update(CookwareDb.get());
                return CookwareDb.get();
            } else {
                return cookware;
            }
        } else {
            return cookware;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getCookware(reference).map(Cookware -> {
            CookwareRepository.delete(Cookware);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
