package sesac.sesacspringboot.tripjavatest.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sesac.sesacspringboot.tripjavatest.entity.TouristEntity;
import sesac.sesacspringboot.tripjavatest.repository.TouristRepository;
import sesac.sesacspringboot.tripjavatest.service.TouristService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TouristController {
    @Autowired
    TouristService touristService;

    @Autowired
    TouristRepository touristRepository;

    @RequestMapping("/api")
    public String save() {
        // 지역 코드와 지역 이름을 매핑하는 Map을 생성
        Map<Integer, String> areaCodeMap = new HashMap<>();
        areaCodeMap.put(1, "서울");
        areaCodeMap.put(2, "인천");
        areaCodeMap.put(3, "대전");
        areaCodeMap.put(4, "대구");
        areaCodeMap.put(5, "광주");
        areaCodeMap.put(6, "부산");
        areaCodeMap.put(7, "울산");
        areaCodeMap.put(8, "세종");
        areaCodeMap.put(31, "경기");
        areaCodeMap.put(32, "강원");
        areaCodeMap.put(33, "충북");
        areaCodeMap.put(34, "충남");
        areaCodeMap.put(35, "경북");
        areaCodeMap.put(36, "경남");
        areaCodeMap.put(37, "전북");
        areaCodeMap.put(38, "전남");
        areaCodeMap.put(39, "제주");

        // 각 지역 코드에 대한 URL을 생성하고 데이터를 저장 (관광지, 음식점, 숙소 각 지역별 100개씩)
        for (int areaCode = 1; areaCode <= 8; areaCode++) {
            String url12 = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=8myOFHTKg5wG3cMyGkOevQcnl%2Fi8kjFcocILGvHrELWdcfS3zsjZwcd2UJtNwoGDB%2F7Hmn8gv8SWwwAsQga%2BEA%3D%3D&MobileOS=ETC&MobileApp=test&_type=json&areaCode=" + areaCode + "&contentTypeId=12&numOfRows=50";
            String url39 = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=8myOFHTKg5wG3cMyGkOevQcnl%2Fi8kjFcocILGvHrELWdcfS3zsjZwcd2UJtNwoGDB%2F7Hmn8gv8SWwwAsQga%2BEA%3D%3D&MobileOS=ETC&MobileApp=test&_type=json&areaCode=" + areaCode + "&contentTypeId=32&numOfRows=50";
            String url57 = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=8myOFHTKg5wG3cMyGkOevQcnl%2Fi8kjFcocILGvHrELWdcfS3zsjZwcd2UJtNwoGDB%2F7Hmn8gv8SWwwAsQga%2BEA%3D%3D&MobileOS=ETC&MobileApp=test&_type=json&areaCode=" + areaCode + "&contentTypeId=39&numOfRows=50";
            saveTouristData(url12, areaCodeMap.get(areaCode));
            saveTouristData(url39, areaCodeMap.get(areaCode));
            saveTouristData(url57, areaCodeMap.get(areaCode));
        }
        // 31부터 39까지의 지역 코드에 대한 URL을 생성하고 데이터를 저장 (관광지, 음식점, 숙소 각 지역별 100개씩)
        for (int areaCode = 31; areaCode <= 39; areaCode++) {
            String url12 = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=8myOFHTKg5wG3cMyGkOevQcnl%2Fi8kjFcocILGvHrELWdcfS3zsjZwcd2UJtNwoGDB%2F7Hmn8gv8SWwwAsQga%2BEA%3D%3D&MobileOS=ETC&MobileApp=test&_type=json&areaCode=" + areaCode + "&contentTypeId=12&numOfRows=50";
            String url39 = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=8myOFHTKg5wG3cMyGkOevQcnl%2Fi8kjFcocILGvHrELWdcfS3zsjZwcd2UJtNwoGDB%2F7Hmn8gv8SWwwAsQga%2BEA%3D%3D&MobileOS=ETC&MobileApp=test&_type=json&areaCode=" + areaCode + "&contentTypeId=32&numOfRows=50";
            String url57 = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=8myOFHTKg5wG3cMyGkOevQcnl%2Fi8kjFcocILGvHrELWdcfS3zsjZwcd2UJtNwoGDB%2F7Hmn8gv8SWwwAsQga%2BEA%3D%3D&MobileOS=ETC&MobileApp=test&_type=json&areaCode=" + areaCode + "&contentTypeId=39&numOfRows=50";
            saveTouristData(url12, areaCodeMap.get(areaCode));
            saveTouristData(url39, areaCodeMap.get(areaCode));
            saveTouristData(url57, areaCodeMap.get(areaCode));
        }

        return "index";
    }

    private void saveTouristData(String urlStr, String areaName) {
//
//
//        try {
//            URL url = new URL(urlStr);
//            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//            String result = br.readLine();
//
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
//            JSONObject parseResponse = (JSONObject) jsonObject.get("response");
//            JSONObject parseBody = (JSONObject) parseResponse.get("body");
//            JSONObject parseItems = (JSONObject) parseBody.get("items");
//            JSONArray array = (JSONArray) parseItems.get("item");
//
//            TouristService touristService = new TouristService();
//
//            double mapx = 127.0226983297;
//            double mapy = 37.6368246468;
//
//            for (int i = 0; i < array.size(); i++) {
//                JSONObject tmp = (JSONObject) array.get(i);
//
//                double latitude = Double.parseDouble(tmp.get("mapx").toString());
//                double longitude = Double.parseDouble(tmp.get("mapy").toString());
//
//
//                double dist = touristService.distance(latitude, longitude, mapx, mapy, "meter");
//
//                TouristEntity tourist = TouristEntity.builder()
//                        .contentid((String) tmp.get("contentid"))
//                        .contenttypeid((String) tmp.get("contenttypeid"))
//                        .title((String) tmp.get("title"))
//                        .addr1((String) tmp.get("addr1"))
//                        .areacode((String) tmp.get("areacode"))
//                        .sigungucode((String) tmp.get("sigungucode"))
//                        .firstimage((String) tmp.get("firstimage"))
//                        .mapx((double) tmp.get("mapx"))
//                        .mapy((double) tmp.get("mapy"))
//                        .distance(dist)
//                        .build();
//
//
//                touristRepository.save(tourist);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//    @GetMapping("/tourist")
//    public List<TouristEntity> getTouristWithinDistance(@RequestParam("distance") double distance) {
//        return touristRepository.findByDistanceLessThanEqual(distance);
//
    }

}