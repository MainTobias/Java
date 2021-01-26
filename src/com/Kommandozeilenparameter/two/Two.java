package com.Kommandozeilenparameter.two;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

//Verbesserungen:
//keine
//Hinzugefügt:
//sollte args nicht lehr sein wird es einfach ausgerechnet sonst wird input gefordert
//alles ist selbst geschrieben bis auf getDistanceBetween funktion
class City {
    public final String name;
    public final long id;
    public final double lat;
    public final double lon;

    public City(String name, long id, double lat, double lon) {
        this.name = name;
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }


    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

public class Two {
    private final static Object[][] cities;
    private final static HashMap<String, Integer> citiesMap;
    final static String inpPrompt = "Enter the name of the city you are looking for or just the first letter: ";
    final static String help = "In case you cant find a city enter 0 and make sure you spelled it correctly or add more characters.\nCity(number): ";
    final static String userInpHelp = "You have selected a number outside of the given range or it is malformed make sure your input looks something like: 3";

    static {
        cities = new Object[][]{{"", "Wien", "Linz", "Graz", "Salzburg", "Innsbruck", "Klagenfurt"},
                {"Wien", 0, 188, 204, 302, 468, 310},
                {"Linz", -1, 0, 276, 125, 291, 274},
                {"Graz", -1, -1, 0, 278, 444, 152},
                {"Salzburg", -1, -1, -1, 0, 166, 242},
                {"Innsbruck", -1, -1, -1, -1, 0, 326},
                {"Klagenfurt", -1, -1, -1, -1, -1, 0},

        };
        citiesMap = new HashMap<>();
        for (int i = 1; i < cities[0].length; i++) citiesMap.put((String) cities[0][i], i);
    }

    public static void main(String[] args) {
        int distance = 0;
        StringBuilder out = new StringBuilder("Die Strecke von ");
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                for (int j = 0; j < cities[0].length; j++) {
                    if (((String) (cities[0][j])).startsWith(args[i])) {
                        args[i] = (String) cities[0][j];
                    }
                }
            }
            out.append(args[0]);
            for (int i = 1; i < args.length; i++) {
                out.append(i+1 < args.length ? " über " + args[i] : " bis " + args[i]);
                int addDistance;
                if((addDistance = (Integer)(cities[citiesMap.get(args[i-1])][citiesMap.get(args[i])])) > 0){
                    distance += addDistance;
                } else if ((addDistance = (Integer)(cities[citiesMap.get(args[i])][citiesMap.get(args[i-1])])) > 0) {
                    distance += addDistance;
                }
            }
            out.append(String.format(" beträgt %dkm.", distance));
            System.out.println(out);
        } else {
            System.out.println("First city");
            City one = getCity();
            System.out.println("Second city");
            City two = getCity();
            System.out.println("The distance between " + one.name + " and " + two.name + " is " + Math.round(getDistanceBetween(one, two)) + "km.");
        }
    }


    private static double getDistanceBetween(City a, City b) {
        if ((a.lat == b.lat) && (a.lon == b.lon)) {
            return 0;
        } else {
            double theta = a.lon - b.lon;
            double dist = Math.sin(Math.toRadians(a.lat)) * Math.sin(Math.toRadians(b.lat)) + Math.cos(Math.toRadians(a.lat)) * Math.cos(Math.toRadians(b.lat)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;
            return (dist);
        }
    }

    static private City getCity() {
        Scanner sc = new Scanner(System.in);
        System.out.print(inpPrompt);
        String line = sc.nextLine().strip();
        List<City> cities = getCities(line);
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(i + 1 + ". " + cities.get(i).name);
        }
        System.out.print(help);
        if (sc.hasNextInt()) {
            int selected = sc.nextInt();
            if (selected == 0) {
                return getCity();
            }
            if (selected >= 1 && selected <= cities.size()) {
                return cities.get(selected - 1);
            } else {
                System.out.println(userInpHelp);
            }
        } else {
            System.out.println(userInpHelp);
        }
        return getCity();
    }


    static private List<City> getCities(String startsWith) {
        List<City> cities = new ArrayList<>();
        try {
            URL url = new URL(String.format("https://nominatim.openstreetmap.org/search?city=%s&format=xml&limit=20", startsWith.charAt(0) + startsWith.substring(1).toLowerCase()));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                String respone = new String(conn.getInputStream().readAllBytes());
                List<Map<String, Object>> citiesAsMaps = xmlDecode(respone);
                for (Map<String, Object> m : citiesAsMaps)
                    cities.add(new City((String) (m.get("display_name")), (Long) (m.get("osm_id")), (Double) (m.get("lat")), (Double) (m.get("lon"))));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (cities.isEmpty()) {
            return getCities(startsWith);
        }
        return cities;
    }

    static private List<Map<String, Object>> xmlDecode(String json) {
        json = json.strip().replaceAll("(<\\?xml.*?>|<searchresults.*>|<\\/searchresults>)", "");
        String[] strings = json.split("(<place |\\/>\\s*<place)");
        List<Map<String, Object>> data = new ArrayList<>();
        List<String> removes = new ArrayList<>();
        for (String s : strings) {
            if (s.isBlank()) continue;
            data.add(toMap(s.replace("/>", "")));
        }
        return data;
    }

    static private Map<String, Object> toMap(String json) {
        Map<String, Object> data = new HashMap<>();
        json = json.strip();
        try {
            String[] keysvalues = json.split("(\"\\s+|'\\s+)");
            for (String keysvalue : keysvalues) {
                String key = keysvalue.split("=")[0];
                Object value = keysvalue.split("=")[1].substring(1);
                try {
                    value = Long.parseLong(String.valueOf(value));
                } catch (Exception e) {
                    try {
                        value = Double.parseDouble(String.valueOf(value));
                    } catch (Exception e2) {
                    }
                }
                data.put(key, value);
            }
        } catch (Exception e) {
            System.out.println("-" + json + "-");
        }
        return data;
    }
}
