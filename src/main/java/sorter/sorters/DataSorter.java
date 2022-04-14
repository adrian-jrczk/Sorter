package sorter.sorters;

import java.util.List;

public abstract class DataSorter {

    public abstract void loadData(String data);

    public abstract List<String> sortAscending();

    public abstract List<String> sortDescending();

    public abstract List<String> sortByOccurrence();

    public abstract int getLoadedItemsSize();
}
