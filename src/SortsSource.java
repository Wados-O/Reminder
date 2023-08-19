import java.util.List;

public class SortsSource  {
    static List<Task> tasks = Input.arrayList;

    /**
     * This method must use for sort on Category
     */
    public static void sortOnCategory() {
        tasks.sort(new TaskByCategoryComparator());

    }

    /**
     * This method must be used for sort on Priority
     */
    public static void sortOnPriority() {
        tasks.sort(new TaskByPriorityComparator());

    }

    /**
     * This method must be used for
     * sort on the date of created
     */

    public static void sortDate() {
        tasks.sort(new TaskByPlaneDateComparator());

    }

    /**
     * This method must be used for sort on Done Undone
     * At fist are undone tasks and after than done
     */
    public static void sortIsDone() {
        tasks.sort(new TaskByDoneComporator());
        TaskOperation.printTaskList();
    }

}
