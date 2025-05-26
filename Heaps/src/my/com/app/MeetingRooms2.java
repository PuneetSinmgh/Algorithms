package my.com.app;

import java.util.*;

class Interval{
    int start;
    int end;
    
    Interval(int s , int e){
        this.start = s;
        this.end = e;
    }
}

class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals.length == 0 )
            return 0;
        if(intervals.length == 1 )
            return 1;
        
        List<Interval> intervalList = new ArrayList();
        
        for(int i=0; i<intervals.length; i++){
            if(intervals[i].length==2)
                intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        
        Collections.sort(intervalList, new Comparator<Interval>(){
           
            public int compare(Interval a, Interval b){
                return (a.start > b.start)?1 : (a.start==b.start)?0 : -1;
            }
        });

        List<Interval> rooms = new ArrayList();
        int res =0; 
        boolean booked = false;
        for(Interval d : intervalList){
            booked = false;
            if(rooms.isEmpty()){
                rooms.add(d);
                booked= true;
                res++;
                continue;
            }
            for(Interval o : rooms){
                if(o.end<=d.start){
                    o.start = d.start;
                    o.end = d.end;
                    booked =true;
                    break;
                }
            }
            
            if(booked == false){
                res +=1;
                rooms.add(d);
                booked =true;
            }
                
        }
        
        return res;
    }
}