import java.util.*;

public class BrowserHistory {

    private List<String> history;
    private int currentIndex;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currentIndex = 0;
    }

    public void visit(String url) {
        // Clear forward history
        history = new ArrayList<>(history.subList(0, currentIndex + 1));
        history.add(url);
        currentIndex++;
    }

    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex = Math.min(history.size() - 1, currentIndex + steps);
        return history.get(currentIndex);
    }

    // Test the class
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");

        System.out.println(browserHistory.back(1));      // facebook.com
        System.out.println(browserHistory.back(1));      // google.com
        System.out.println(browserHistory.forward(1));   // facebook.com

        browserHistory.visit("linkedin.com");

        System.out.println(browserHistory.forward(2));   // linkedin.com
        System.out.println(browserHistory.back(2));      // google.com
        System.out.println(browserHistory.back(7));      // leetcode.com
    }
}