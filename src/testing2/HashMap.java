package testing2;

/**
 * Created by joetomjob on 3/19/20.
 */

class KeyVal {
    String key;
    String value;

    KeyVal(){}
    KeyVal(String k, String v){
        this.key = k;
        this.value = v;
    }
}

public class HashMap {
    KeyVal[] map = new KeyVal[5];
    int size = 0;

    public void put(String k, String v) {
        size++;
        int index = hashFunc(k)/map.length;
        while (map[index] != null && map[index].key != "DELETED") {
            index++;
            if(index == map.length) {
                index = 0;
            }
        }
        map[index] = new KeyVal(k, v);
        if(size/map.length > 0.7){
            size = 0;
            KeyVal[] old = map;
            map = new KeyVal[2 * map.length];
            for (KeyVal o : old) {
                if(o != null) {
                    put(o.key, o.value);
                }
            }
        }
    }

    public String get(String k) {
        int index = hashFunc(k) % map.length;
        while (map[index] != null && map[index].key != k) {
            index++;
            if(index == map.length) {
                index = 0;
            }
        }
        if(map[index] == null) {
            return "";
        }
        return map[index].value;
    }

    public void remove(String k){
        int index = hashFunc(k) % map.length;
        while (map[index] != null && map[index].key != k) {
            index++;
            if(index == map.length) {
                index = 0;
            }
        }
        if(map[index] != null) {
            map[index].key = "DELETED";
            map[index].value = "DELETED";
        }
    }

    public void printMap(){
        System.out.println("_______________________");
        for (KeyVal k : map) {
            if(k != null){
                System.out.println(k.key + " : " + k.value);
            } else {
                System.out.println("NULL");
            }
        }
        System.out.println("_______________________");
    }

    public int hashFunc(String k) {
        return k.length();
    }

    public static void main(String[] args) {
        HashMap hmap = new HashMap();
        hmap.printMap();
        hmap.put("JTJ", "JOE");
        hmap.put("JRM", "JINU");
        hmap.put("JAT", "JOB");
        hmap.printMap();
        hmap.put("MJ", "MARIAMMA");
        hmap.put("RMJ", "ROSE");
        hmap.put("IJT", "IAN");
        hmap.put("NMT", "NIA");
        hmap.printMap();
        System.out.println(hmap.get("MJ"));
        hmap.remove("RMJ");
        hmap.printMap();
        // Enter into deleted location
        hmap.put("RMT", "ROSE");
        hmap.printMap();
        System.out.println(hmap.get("MK"));
    }
}
