package cl.usm.hdd.tipocertamen.controllers;

import cl.usm.hdd.tipocertamen.entitites.Solicitud;
import cl.usm.hdd.tipocertamen.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;
    private boolean esTipoValido(String tipoSolicitud){

        String [] tipos = {"SolicitudCedula", "RetiroCedula", "SolicitudCertificadoNac", "SolicitudCertificadoDef"};

        return Stream.of(tipos).anyMatch(t ->t.equalsIgnoreCase(tipoSolicitud));
    }
    @PostMapping("/ingresarSolicitud")
    public ResponseEntity<Solicitud> createSolicitud(@RequestBody Solicitud solicitud){
        if(!esTipoValido(solicitud.getTipoSolicitud())){
            return ResponseEntity.badRequest().build();
        }else{
            try {
                Solicitud sol = solicitudService.createSolicitud(solicitud);
                return ResponseEntity.ok(sol);
            } catch (Exception ex) {
                return ResponseEntity.internalServerError().build();
            }
        }
    }
    @GetMapping("/verSolicitudes")
    public ResponseEntity<List<Solicitud>> getSolicitud(){
        try{
            return ResponseEntity.ok(solicitudService.getSolicitud());
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("verSolicitudes/{tipo}")
    public ResponseEntity<List<Solicitud>> findSolicitudes(@PathVariable String tipo){
        try{
            return ResponseEntity.ok(this.solicitudService.findSolicitudes(tipo));
        } catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}
