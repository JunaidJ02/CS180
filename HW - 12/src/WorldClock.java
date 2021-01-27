import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Homework 12 -- WorldClock Class
 *
 * This is the WorldClock class of homework 12
 *
 * @author Junaid Javed, javedj@purdue.edu
 * @version November 14, 2019
 *
 */
public class WorldClock implements Runnable {
    static final String TITLE = "World Clock";
    static final String[][] LOCATIONS = {
            {"Pago Pago"},  //-11
            {"Honolulu", "Papeete"},   //-10
            {"Anchorage"},  //-9
            {"Vancouver", "Los Angeles"},    //-8
            {"Edmonton", "Denver"},  //-7
            {"Mexico City", "Chicago"},  //-6
            {"Miami", "Toronto", "New York"}, //-5
            {"Santiago", "Halifax"}, //-4
            {"Rio De Janeiro"}, //-3
            {"King Edward Point"}, //-2
            {"Praia"},  //-1
            {"UTC", "Lisbon", "London"},  //0
            {"Madrid", "Paris", "Rome", "Berlin", "Stockholm"}, //+1
            {"Athens", "Cairo", "Jerusalem"}, //+2
            {"Moscow", "Jeddah"},    //+3
            {"Dubai"},  //+4
            {"Karachi"},    //+5
            {"Dhaka"},  //+6
            {"Bangkok"},    //+7
            {"Singapore", "Hong Kong", "Beijing", "Taipei"},   //+8
            {"Seoul", "Tokyo"}, //+9
            {"Guam", "Sydney"}, //+10
            {"Noumea"}, //+11
            {"Wellington"}  //+12
    };
    static String[] cities;
    static final String[] BUTTONNAMES = {"Enter Next Destination", "Quit"};

    public void run() {
        //Stage 1
        int stage1 = JOptionPane.showConfirmDialog(null,
                "Welcome to the World Clock!", TITLE, JOptionPane.OK_CANCEL_OPTION);

        //Stage 1 clicked "OK"
        if (stage1 == 0) {
            //Stage 2

            String city = (String) JOptionPane.showInputDialog(null, "Which city is in the local time zone?",
                    TITLE, JOptionPane.QUESTION_MESSAGE, null, cities, cities[0]);


            //Stage 2 clicked "OK"
            if (city != null) {
                //Stage 3
                String[] timeSplit = checkTime();
                if (timeSplit == null) return;
                int cityOffset = timeOffset(city) - 11;
                //Stage 3 clicked "OK"
                int hour = Integer.parseInt(timeSplit[0]);
                int minute = Integer.parseInt(timeSplit[1]);

                //Stage 5 clicked "OK"
                while (true) {
                    String destination = (String) JOptionPane.showInputDialog(null,
                            "Which city is the destination time zone?",
                            TITLE, JOptionPane.QUESTION_MESSAGE, null, cities, cities[0]);
                    if (destination != null) {
                        int destinationOffset = timeOffset(destination) - 11;
                        System.out.println(destinationOffset);
                        System.out.println(cityOffset);
                        System.out.println(hour);
                        hour = hour - cityOffset + destinationOffset;
                        if (hour < 0) {
                            JOptionPane.showMessageDialog(null, "In " + destination +
                                    ", it is " + (23 + hour) + ":" + minute + " in the day before.");
                        } else if (hour > 24) {
                            hour %= 25;
                            JOptionPane.showMessageDialog(null, "In " + destination +
                                    ", it is " + hour + ":" + minute + " in the next day.");
                        } else {
                            JOptionPane.showMessageDialog(null, "In " + destination +
                                    ", it is " + hour + ":" + minute);
                        }

                        int leave = JOptionPane.showOptionDialog(null, "Continue with the World Clock?",
                                TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, BUTTONNAMES, BUTTONNAMES[0]);
                        if (leave != 0) {
                            JOptionPane.showMessageDialog(null, "Thank you for using the World Clock.",
                                    TITLE, JOptionPane.PLAIN_MESSAGE);
                            break;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Thank you for using the World Clock.",
                                TITLE, JOptionPane.PLAIN_MESSAGE);
                        return;
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Thank you for using the World Clock.",
                        TITLE, JOptionPane.PLAIN_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Thank you for using the World Clock.",
                    TITLE, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public String[] checkTime() {
        //Stage 4
        while (true) {
            String time = JOptionPane.showInputDialog(null, "What is your local time? (0-23):(0-59)",
                    TITLE, JOptionPane.OK_CANCEL_OPTION);
            if (time == null) {
                JOptionPane.showMessageDialog(null, "Thank you for using the World Clock.",
                        TITLE, JOptionPane.PLAIN_MESSAGE);
                return null;
            }
            if (!time.contains(":")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid time. For example, 13:30.",
                        TITLE, JOptionPane.ERROR_MESSAGE);
                continue;
            }
            String[] timeSplit = time.split(":");
            if (timeSplit.length != 2) {
                JOptionPane.showMessageDialog(null, "Please enter a valid time. For example, 13:30.",
                        TITLE, JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (Integer.parseInt(timeSplit[0]) > 23) {
                JOptionPane.showMessageDialog(null, "Please enter a valid time. For example, 13:30.",
                        TITLE, JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (Integer.parseInt(timeSplit[0]) < 0) {
                JOptionPane.showMessageDialog(null, "Please enter a valid time. For example, 13:30.",
                        TITLE, JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (Integer.parseInt(timeSplit[1]) > 59) {
                JOptionPane.showMessageDialog(null, "Please enter a valid time. For example, 13:30.",
                        TITLE, JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (Integer.parseInt(timeSplit[1]) < 0) {
                JOptionPane.showMessageDialog(null, "Please enter a valid time. For example, 13:30.",
                        TITLE, JOptionPane.ERROR_MESSAGE);
                continue;
            }

            return timeSplit;

        }
    }

    public int timeOffset(String city) {
        for (int i = 0; i < LOCATIONS.length; i++) {
            for (int j = 0; j < LOCATIONS[i].length; j++) {
                if (LOCATIONS[i][j].equals(city)) {
                    return i;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        List cityList = new ArrayList();
        for (int i = 0; i < LOCATIONS.length; i++) {
            for (int j = 0; j < LOCATIONS[i].length; j++) {
                cityList.add(LOCATIONS[i][j]);
            }
        }
        cities = (String[]) cityList.toArray(new String[cityList.size()]);
        SwingUtilities.invokeLater(new WorldClock());
    }
}

