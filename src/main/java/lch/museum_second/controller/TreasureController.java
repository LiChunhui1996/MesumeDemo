package lch.museum_second.controller;

import lch.museum_second.domain.Treasure;
import lch.museum_second.service.TreasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TreasureController {

    @Autowired
    private TreasureService treasureService;

    @RequestMapping("/getTreasureList")
    public String selectAllController(ModelMap modelMap) {
        List<Treasure> treasures = treasureService.selectAllService();
        modelMap.addAttribute("items", treasures);
        return "treasure_list";
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public List<Treasure> selectByValueController(@RequestBody HashMap<String, String> map) {
        System.out.println(map.get("name"));
        List<Treasure> treasures;
        if (isNumeric(map.get("name").toString())) {
            int id = Integer.parseInt(map.get("name"));
            treasures = treasureService.selectByIdService(id);
        } else {
            treasures = treasureService.selectByNameService(map.get("name"));
        }
        System.out.println(treasures.toString());
        return treasures;
    }

    private boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }

    @RequestMapping(value = "/updateOne", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String updateTreasure(@RequestBody HashMap<String, String> map) {
        Treasure treasure = new Treasure();
        treasure.setId(Integer.parseInt(map.get("id")));
        treasure.setName(map.get("name"));
        treasure.setFindPlace(map.get("find_place"));
        treasure.setOwnTime(map.get("own_time"));
        treasure.setWeb(map.get("web"));
        treasure.setStory(map.get("story"));
        treasure.setCraft(map.get("craft"));
        treasure.setStudy(map.get("study"));
        System.out.println(treasure.toString());

        int result = treasureService.updateTreasureService(treasure);
        if (result == 1) {
            return "1";
        } else {
            return "-1";
        }
    }


    @RequestMapping(value = "/insertOne", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String insertTreasure(@RequestBody HashMap<String, String> map) {
        Treasure treasure = new Treasure();
        treasure.setId(Integer.parseInt(map.get("id")));
        treasure.setName(map.get("name"));
        treasure.setFindPlace(map.get("find_place"));
        treasure.setOwnTime(map.get("own_time"));
        treasure.setWeb(map.get("web"));
        treasure.setStory(map.get("story"));
        treasure.setCraft(map.get("craft"));
        treasure.setStudy(map.get("study"));

        System.out.println(treasure.toString());

        int result = treasureService.insertTreasure(treasure);
        if (result == 1) {
            return "1";
        } else {
            return "-1";
        }
    }


    @RequestMapping(value = "/deleteOne", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String deleteTreasure(@RequestBody HashMap<String, String> map) {

        Integer id = Integer.parseInt(map.get("id"));

        int result = treasureService.deleteTreasureService(id);
        if (result == 1) {
            return "1";
        } else {
            return "-1";
        }


    }

    @RequestMapping(value = "/countTreasure", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String selectTreasureCount() {
        Integer count = treasureService.selectTreasureCountService();
        System.out.println("数量为：" + count);
        return count.toString();
    }
}
