package sesac.sesacspringboot.tripjavatest.service;

import sesac.sesacspringboot.tripjavatest.entity.TouristEntity;
import sesac.sesacspringboot.tripjavatest.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    @Autowired
    TouristRepository tourListRepository;
    public void creatData(List<TouristEntity> touristEntities) {
        for(TouristEntity entity : touristEntities ) {
            tourListRepository.save(entity);
            System.out.println(entity);
        }
    }

    public double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        if (unit.equals("meter")) {
            dist = dist * 1609.344;
        }
        return dist;
    }
}
