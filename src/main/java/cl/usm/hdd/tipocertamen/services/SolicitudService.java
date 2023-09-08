package cl.usm.hdd.tipocertamen.services;

import cl.usm.hdd.tipocertamen.entitites.Solicitud;

import java.util.List;

public interface SolicitudService {
    List<Solicitud> getSolicitud();
    List<Solicitud> findSolicitudes(String tipoSolicitud);
    Solicitud createSolicitud(Solicitud solicitud);

}
