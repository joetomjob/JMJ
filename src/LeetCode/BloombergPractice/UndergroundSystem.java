package LeetCode.BloombergPractice;

import java.util.HashMap;

public class UndergroundSystem {
  class StationTime {
    String station;
    int time;

    StationTime(){}
    StationTime(String station, int time) {
      this.station = station;
      this.time = time;
    }
  }

  class AvgTime{
    Double totalTime;
    int count;

    AvgTime(){}
    AvgTime(Double totalTime, int count) {
      this.totalTime = totalTime;
      this.count = count;
    }
  }


  HashMap<Integer, StationTime> checkInStatus = new HashMap<>();
  HashMap<String, AvgTime> avgTime = new HashMap<>();
  public void checkIn(int id, String stationName, int t) {
    this.checkInStatus.put(id, new StationTime(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    StationTime st = this.checkInStatus.get(id);
    Integer curTime = t - st.time;
    AvgTime existTime = this.avgTime.getOrDefault(st.station+"_"+stationName, new AvgTime(0.0, 0));
    Double newTime = existTime.totalTime + curTime;
    int newCount = existTime.count + 1;

    this.avgTime.put(st.station+"_"+stationName, new AvgTime(newTime, newCount));
  }

  public double getAverageTime(String startStation, String endStation) {
    AvgTime existTime = this.avgTime.get(startStation+"_"+endStation);
    return existTime.totalTime / existTime.count;
  }

  public static void main(String[] args){

  }
}
