package ma.irirsi.gestionpaieservice.infra.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080/v1/api/collaborator")
public interface ColaborateurService {
    @GetMapping("/matricule/{matricule}")
    public Object findByMatricule(@PathVariable String matricule);
}
