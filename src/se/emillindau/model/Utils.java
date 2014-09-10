package se.emillindau.model;

import se.emillindau.model.Player;

import java.util.List;

/**
 * Created by Emil on 2014-05-05.
 * assigned to spelrepubliken in se.emillindau
 */
public class Utils {

    private static List<Player> mList;

    public static List<Player> quickSortByScore(List<Player> array) {
        if(array == null || array.size() <= 1) {
            // Since we're timing, do nothing here
            // the array is 'already sorted'
        } else {
            mList = array;
            quickSort(0, array.size() - 1);
        }
        return mList;
    }

    // For recursive use
    private static void quickSort(int low, int high) {
        int i = low, j = high;
        double pivot = mList.get(low + (high-low)/2).getPoints();

        while(i <= j) {
            while(mList.get(i).getPoints() < pivot) {
                i++;
            }
            while(mList.get(j).getPoints() > pivot) {
                j--;
            }
            if(i <= j) {
                Player temp = mList.get(i);
                mList.set(i, mList.get(j));
                mList.set(j, temp);
                i++;
                j--;
            }
        }
        if(low < j)
            quickSort(low, j);
        if(i < high)
            quickSort(i, high);
    }
}
