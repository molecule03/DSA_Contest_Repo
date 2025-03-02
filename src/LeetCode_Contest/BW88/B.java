package LeetCode_Contest.BW88;

public class B {
    public static void main(String[] args) {

        LUPrefix lu = new LUPrefix(4);
        lu.upload(3);
        lu.longest();
        lu.upload(1);
        lu.longest();
        lu.upload(2);
        lu.longest();

    }

    /**
     * LUPrefix class represents a data structure that maintains a list of uploaded videos
     * and provides methods to upload videos and find the length of the longest uploaded prefix.
     */
    static class LUPrefix {
        boolean list[];
        int max = 1;

        /**
         * Constructor for LUPrefix class.
         * @param n An integer representing the initial size of the list.
         */
        public LUPrefix(int n) {
            list = new boolean[n+2];
            list[0] = true;
            max = 1;
        }

        /**
         * Uploads a video to the list.
         * @param video An integer representing the video to be uploaded.
         */
        public void upload(int video) {
            list[video] = true;
            while(list[max] == true) max++;
        }

        /**
         * Returns the length of the longest uploaded prefix.
         * @return An integer representing the length of the longest uploaded prefix.
         */
        public int longest() {
            return max-1;
        }
    }
}
