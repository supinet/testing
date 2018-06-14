package codility;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;


/**
 * Created by supi on 6/10/18.
 */
public class NewJhonsPhotosTest {

    int photoIdx = 0;
    String moreThanTen;

    @Test
    public void testSolution() {

        String result =
                "Warsaw02.jpg\n" +
                        "London1.png\n" +
                        "Warsaw01.png\n" +
                        "Paris2.jpg\n" +
                        "Paris1.jpg\n" +
                        "London2.jpg\n" +
                        "Paris3.png\n" +
                        "Warsaw03.jpg\n" +
                        "Warsaw09.png\n" +
                        "Warsaw07.jpg\n" +
                        "Warsaw06.jpg\n" +
                        "Warsaw08.jpg\n" +
                        "Warsaw04.png\n" +
                        "Warsaw05.png\n" +
                        "Warsaw10.jpg";

        String content =
                "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                        "john.png, London, 2015-06-20 15:13:22\n" +
                        "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                        "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                        "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                        "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                        "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                        "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                        "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                        "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                        "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                        "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                        "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                        "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                        "g.jpg, Warsaw, 2016-02-29 22:13:11";

        Assert.assertEquals(result, solution(content));
    }

    public String solution(String content) {

        List<String> values = Arrays.asList(content.split("\n"));
        List<Photo> photos = new ArrayList<>();
        values.stream().forEach(v -> photos.add(createPhoto(v)));
        Map<String, List<Photo>> citiesGroups = photos.stream().sorted(comparing(p -> p.city)).collect(groupingBy(p -> p.city));

        List<String> result = new ArrayList<>();
        citiesGroups.entrySet().stream().forEach(e -> {
            setupController(e);
            e.getValue().stream().sorted(comparing(d -> d.dateTime)).forEach(v -> {
                result.add(createResultPhoto(v, photoIdx, moreThanTen));
                photoIdx++;
            });
        });
        return result.toString();
    }

    private void setupController(Map.Entry<String, List<Photo>> entry) {
        moreThanTen = entry.getValue().size() >= 10 ? "0" : "";
        photoIdx = 1;
    }

    private String createResultPhoto(Photo v, int photoIdx, String moreThanTen) {
        String result = setupName(v, photoIdx, moreThanTen);
        return result;
    }

    private String setupName(Photo v, int photoIdx, String moreThanTen) {
        return moreThanTen.concat(Integer.toString(photoIdx)).length() >= 3 ? v.city.concat(Integer.toString(photoIdx)).concat(v.extension) : v.city.concat(moreThanTen).concat(Integer.toString(photoIdx)).concat(v.extension).concat("\n");
    }

    private Photo createPhoto(String v) {
        Photo photo = new Photo();
        photo.city = v.substring(v.indexOf(",") + 1, v.lastIndexOf(",")).trim();
        photo.extension = v.substring(v.lastIndexOf(".") + 0, v.indexOf(",") + 0).trim();
        photo.dateTime = LocalDateTime.parse(v.substring(v.lastIndexOf(", ") + 1).trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return photo;
    }

    public class Photo implements Comparable<Photo> {
        String city;
        String extension;
        LocalDateTime dateTime;

        public LocalDateTime getDateTime() {
            return dateTime;
        }

        @Override
        public int compareTo(Photo o) {
            return getDateTime().compareTo(o.dateTime);
        }
    }
}