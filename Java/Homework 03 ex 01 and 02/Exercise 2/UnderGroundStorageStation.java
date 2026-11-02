import java.util.ArrayList;
import java.util.List;

public class UnderGroundStorageStation {
    private List<StubTrack> stubs;

    public UnderGroundStorageStation() {
        this.stubs = new ArrayList<>();
    }

    public void addStub(StubTrack stub){
        stubs.add(stub);
    }

    public boolean arriveStation(Tramway t){
        int max = 0;
        StubTrack bestTrack = null;
        for(StubTrack track : stubs){
            if(track.amountOfFreeSpots() > max) {
                max = track.amountOfFreeSpots();
                bestTrack = track;
            }
        }
        if(bestTrack==null){
            return false;
        }
        return bestTrack.push(t);
    }

    public Tramway departStation(){
        if(stubs.isEmpty() || stubs == null){
            return null;
        }
        StubTrack fullTrack = stubs.get(0);
        for(int i=0; i<stubs.size(); i++){
            if(stubs.get(i).amountOfFreeSpots() < fullTrack.amountOfFreeSpots()){
                fullTrack = stubs.get(i);
            }
        }
        if(fullTrack.amountOfFreeSpots()==0){
            return null;
        }
        return fullTrack.pop();
    }

}
