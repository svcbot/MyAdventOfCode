package day6;

import java.util.*;

public class UniversalOrbitMap {
    // key= space object, value= direct orbits
    Map<String, Set<String>> orbitsMap = new HashMap<>();
    // key=child, value=parent
    Map<String, String> parentMap = new HashMap<>();

    public UniversalOrbitMap(List<String> orbitsInput) {
        orbitsInput.forEach(this::processOrbit);
        parentMap.put("COM", "COM");
    }

    private void processOrbit(String orbit) {
        String[] decodedOrbit = orbit.split("\\)");
        if (orbitsMap.containsKey(decodedOrbit[0])) {
            orbitsMap.get(decodedOrbit[0]).add(decodedOrbit[1]);
        } else {
            Set<String> directOrbits = new HashSet<>();
            directOrbits.add(decodedOrbit[1]);
            orbitsMap.put(decodedOrbit[0], directOrbits);
        }
        if (!parentMap.containsKey(decodedOrbit[1])) {
            parentMap.put(decodedOrbit[1], decodedOrbit[0]);
        }
    }

    public int getOrbitCountChecksum() {
        return getOrbitsCount();
    }

    private int getOrbitsCount() {
        return getOrbitsCount("COM", 0);
    }

    private int getOrbitsCount(String orbit, int depth) {
        int totalOrbits = 0;
        if (orbitsMap.containsKey(orbit)) {
            for (String child : orbitsMap.get(orbit)) {
                totalOrbits += getOrbitsCount(child, depth + 1);
            }
        }
        return totalOrbits + depth;
    }

    public int getTransfersCount(String from, String to) {
        Map<String, Integer> visitedParents = new HashMap<>();
        int yourTransfers = 0;
        int santasTransfers = 0;
        String yourNextLocation = from;
        String santasNextLocation = to;

        // create path from YOU to COM. Not the most efficient way, but easy to code
        while (!yourNextLocation.equals("COM")) {
            yourNextLocation = parentMap.get(yourNextLocation);
            visitedParents.put(yourNextLocation, yourTransfers);
            yourTransfers++;
        }

        // here we just search until santas next location appears in the visited parents map
        // then just add santas current transfers, and thats it
        while (!santasNextLocation.equals("COM")) {
            santasNextLocation = parentMap.get(santasNextLocation);
            if (visitedParents.containsKey(santasNextLocation)) {
                return santasTransfers + visitedParents.get(santasNextLocation);
            } else {
                visitedParents.put(santasNextLocation, santasTransfers);
            }
            santasTransfers++;
        }

        return yourTransfers + santasTransfers;

    }
}
