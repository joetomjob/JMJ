package LeetCode.ArraysAndStrings;

import java.util.HashMap;

class CheckInStatus{
  String station;
  int startTime;

  CheckInStatus(String station, int startTime){
    this.station = station;
    this.startTime = startTime;
  }
}

class TotaltimeCount{
  double totalTime;
  double totalCount;

  TotaltimeCount(double totalTime, double totalCount){
    this.totalTime = totalTime;
    this.totalCount = totalCount;
  }
}

public class UndergroundSystem {
  HashMap<Integer, CheckInStatus> checkin;
  HashMap<String, TotaltimeCount> totalMap;

  public UndergroundSystem(){
    checkin = new HashMap<>();
    totalMap = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t){
    this.checkin.put(id, new CheckInStatus(stationName, t));
  }

  public void checkout(int id, String stationName, int t){
    CheckInStatus c = this.checkin.get(id);
    TotaltimeCount total = totalMap.getOrDefault(getStationKey(c.station, stationName), new TotaltimeCount(0.0, 0.0));

    double curTot = t - c.startTime;
    totalMap.put(getStationKey(c.station, stationName), new TotaltimeCount(curTot + total.totalTime, total.totalCount + 1));
  }

  public double getAverageTime(String startStation, String endStation){
    TotaltimeCount t = totalMap.getOrDefault(getStationKey(startStation, endStation), new TotaltimeCount(0.0, 0.0));
    return t.totalCount > 0 ? t.totalTime / t.totalCount : 0.0;
  }


  public String getStationKey(String s1, String s2){
    return s1 + "->" + s2;
  }
}
