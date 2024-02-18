package sesac.sesacspringboot.tripjavatest.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
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
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TouristController {
    @Autowired
    TouristService touristService;

    @Autowired
    TouristRepository touristRepository;

    @RequestMapping("/api")
    public String save() throws IOException {
        String result = "";

//        try {
//            // contentTypeId=32 정보 가져오기
//            String urlStr32 = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=8myOFHTKg5wG3cMyGkOevQcnl%2Fi8kjFcocILGvHrELWdcfS3zsjZwcd2UJtNwoGDB%2F7Hmn8gv8SWwwAsQga%2BEA%3D%3D&MobileOS=ETC&MobileApp=test&_type=json&areaCode=1&contentTypeId=32&numOfRows=10";
//            URL url32 = new URL(urlStr32);
//            BufferedReader br32;
//            br32 = new BufferedReader(new InputStreamReader(url32.openStream(), "UTF-8"));
//
//            result = br32.readLine();
//
//            // JSON 파싱 객체 생성
//            JSONParser jsonParser = new JSONParser();
//            JSONPObject jsonObject = (JSONPObject) jsonParser.parse(result);
//
//            // response 를 받아옴
//            JSONPObject parseResponse = (JSONPObject) jsonObject.get("response");
//
//            // body 를 받아옴
//            JSONObject parseBody = (JSONObject) parseResponse.get("body");
//
//            // Items 를 받아옴
//            JSONObject parseItems = (JSONObject) parseBody.get("items");
//
//            // Item 배열을 받아옴
//            JSONArray array = (JSONArray) parseItems.get("item");
//
//            for(int i=0; i<array.size(); i++) {
//                JSONObject tmp = (JSONObject) array.get(i);
//                TouristEntity tourist = TouristEntity.builder()
//                        .contentid((String)tmp.get("contentid"))
//                        .contenttypeid((String)tmp.get("contenttypeid"))
//                        .title((String)tmp.get("title"))
//                        .addr1((String)tmp.get("addr1"))
//                        .areacode((String)tmp.get("areacode"))
//                        .sigungucode((String)tmp.get("sigungucode"))
//                        .firstimage((String)tmp.get("firstimage"))
//                        .mapx((String)tmp.get("mapx"))
//                        .mapy((String)tmp.get("mapy"))
//                        .build();
//                touristRepository.save(tourist);
//            }
//
//            // contentTypeId=12 정보 가져오기
//            String urlStr12 = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=8myOFHTKg5wG3cMyGkOevQcnl%2Fi8kjFcocILGvHrELWdcfS3zsjZwcd2UJtNwoGDB%2F7Hmn8gv8SWwwAsQga%2BEA%3D%3D&MobileOS=ETC&MobileApp=test&_type=json&areaCode=1&contentTypeId=12&numOfRows=10";
//            URL url12 = new URL(urlStr12);
//            BufferedReader br12;
//            br12 = new BufferedReader(new InputStreamReader(url12.openStream(), "UTF-8"));
//
//            result = br12.readLine();
//
//            jsonObject = (JSONObject) jsonParser.parse(result);
//            parseResponse = (JSONObject) jsonObject.get("response");
//            parseBody = (JSONObject) parseResponse.get("body");
//            parseItems = (JSONObject) parseBody.get("items");
//            array = (JSONArray) parseItems.get("item");
//
//            for(int i=0; i<array.size(); i++) {
//                JSONObject tmp = (JSONObject) array.get(i);
//                TouristEntity tourist = TouristEntity.builder()
//                        .contentid((String)tmp.get("contentid"))
//                        .contenttypeid((String)tmp.get("contenttypeid"))
//                        .title((String)tmp.get("title"))
//                        .addr1((String)tmp.get("addr1"))
//                        .areacode((String)tmp.get("areacode"))
//                        .sigungucode((String)tmp.get("sigungucode"))
//                        .firstimage((String)tmp.get("firstimage"))
//                        .mapx((String)tmp.get("mapx"))
//                        .mapy((String)tmp.get("mapy"))
//                        .build();
//                touristRepository.save(tourist);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
        return "index";
    }

    @RequestMapping("/findAll")
    public List<TouristEntity> findAll() {
        // contentTypeId=32와 contentTypeId=12 정보 모두 조회
        List<TouristEntity> touristList = touristRepository.findAll();
        return touristList;
    }
}
