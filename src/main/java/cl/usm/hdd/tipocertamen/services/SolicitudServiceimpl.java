package cl.usm.hdd.tipocertamen.services;

import cl.usm.hdd.tipocertamen.entitites.Solicitud;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SolicitudServiceimpl implements SolicitudService{
    private static List<Solicitud> solicitudes = new ArrayList<>();
    @Override
    public List<Solicitud> getSolicitud() {
        return solicitudes;
    }

    @Override
    public List<Solicitud> findSolicitudes(String tipoSolicitud) {
        return solicitudes.stream().filter(s->s.getTipoSolicitud().equalsIgnoreCase(tipoSolicitud)).collect(Collectors.toList());
    }

    @Override
    public Solicitud createSolicitud(Solicitud solicitud) {
        solicitudes.add(solicitud);
        return solicitud;
    }
}
