import com.sun.jdi.Value;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<Map<String, String>> animalList = new ArrayList<>();
        Map<String, String>animal1 = new HashMap<>();

        animal1.put("habitat","ocean");
        animal1.put("name","shark");
        animalList.add(animal1);

        Map<String, String>animal2 = new HashMap<>();
        animal2.put("habitat","land");
        animal2.put("name","bear");
        animalList.add(animal2);

        Map<String, String>animal3 = new HashMap<>();
        animal3.put("habitat","land");
        animal3.put("name","moose");
        animalList.add(animal3);

        Map<String, String>animal4 = new HashMap<>();
        animal4.put("habitat","swamp");
        animal4.put("name","frog");
        animalList.add(animal4);

        Map<String, String>animal5 = new HashMap<>();
        animal5.put("habitat","ocean");
        animal5.put("name","jelly fish");
        animalList.add(animal5);

        Map<String, String>animal6 = new HashMap<>();
        animal6.put("habitat","swamp");
        animal6.put("name","heron");
        animalList.add(animal6);

        Map<String, String>animal7 = new HashMap<>();
        animal7.put("habitat","ocean");
        animal7.put("name","whale");
        animalList.add(animal7);

        List<String>habitats=new ArrayList<>();

        for(Map<String,String> habitat:animalList){   //從List中的每個Map抓取habitat資料
            habitats.add(habitat.get("habitat"));     //並存入新創的List中
        }

        habitats=habitats.stream().distinct().collect(Collectors.toList()); //將重複出現的地點做移除

        Map<String, List<String>> animalMap=new HashMap<>(); //題目要求

        for(String allHabitat :habitats){  //用抓出來沒重複的地點跑回圈
            List<String>animals=new ArrayList<>(); //用來放各別地點所屬的動物
            for(Map<String,String>habitat:animalList){
                if(allHabitat.equals(habitat.get("habitat"))){ //當大迴圈當時的地點等於小迴圈當時Map中的地點,代表該動物屬於目前大迴圈所跑的地點
                    animals.add(habitat.get("name")); //將屬於同個地點的動物存入同一個List
                }
            }
            animalMap.put(allHabitat,animals);//將地點跟上述找到對應的動物List放入
        }

        System.out.println("第一題");
        for (String habitat: animalMap.keySet()){
            System.out.println(habitat+ " : " + String.join(" , ", animalMap.get(habitat)));
        }

        System.out.println("---------------------------------------------------");

        Map<String, String>capitalMap=new HashMap<>();

        capitalMap.put("USA","Washington");
        capitalMap.put("Japan","Tokyo");
        capitalMap.put("Thailand","Bangkok");
        capitalMap.put("UK","London");
        capitalMap.put("Australia","Canberra");
        capitalMap.put("Denmark","Copenhagen");
        capitalMap.put("Egypt","Cairo");
        capitalMap.put("Vietnam","Hanoi");
        capitalMap.put("Italy","Rome");
        capitalMap.put("Brazil","Brazilia");

        //System.out.println(capitalMap);

        System.out.println("第二題");
        for (String key: capitalMap.keySet()){
            System.out.println(key+ ": " + capitalMap.get(key));
        }





    }
}
