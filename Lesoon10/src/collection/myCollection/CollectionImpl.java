package collection.myCollection;

import java.util.Iterator;

public class CollectionImpl implements Collection, Iterator {

    private String[] strArr;

    private int size = 0;
    private int itrCounter = 0;

    public CollectionImpl() {
        strArr = createArray(10);
    }

    public CollectionImpl(int size) {
        strArr = createArray(size);
    }


    @Override
    public boolean add(String o) {
        try {
            strArr[size++] = o;
        } catch (Exception e) {
            return false;
        }
        if (needExtension()) {
            strArr = mergeArray(strArr, createArray(10));
        }
        return true;
    }

    public String[] getArray() {
        return strArr;
    }

    @Override
    public boolean add(int index, String o) {
        try {
            if (index >= strArr.length) {
                return false;
            }
            if (index == strArr.length - 1 && strArr[index] == null && size < index) {
                strArr[index] = o;
                size++;
                convertArrayToCorrectSize();
                if (needExtension()) {
                    strArr = mergeArray(strArr, createArray(10));
                }
                return true;
            }

            String[] startArr = index == 0 ?
                    cutArray(strArr, index, strArr.length) :
                    cutArray(strArr, 0, index);

            if (index == 0) {
                strArr = new String[]{o};
                strArr = mergeArray(strArr, startArr);
                size++;
            } else {
                String[] endArr = cutArray(strArr, index, strArr.length);
                strArr = mergeArray(startArr, new String[1]);
                strArr[index] = o;
                strArr = mergeArray(strArr, endArr);
                size++;
            }
            convertArrayToCorrectSize();
        } catch (Exception e) {
            return false;
        }
        if (needExtension()) {
            strArr = mergeArray(strArr, createArray(10));
        }
        return true;
    }

    @Override
    public boolean delete(String o) {
        int indexFoundElement = -1;
        for (int i = 0; i < strArr.length; i++) {
            if (o == null && strArr[i] == null) {
                indexFoundElement = i;
                break;
            } else if (strArr[i].equals(o)) {
                indexFoundElement = i;
                break;
            }
        }
        if (indexFoundElement == -1) {
            return false;
        }

        try {

            if (indexFoundElement == strArr.length - 1) {
                strArr = cutArray(strArr, 0, strArr.length - 1);
                size--;
                return true;
            }

            String[] startArr = indexFoundElement == 0 ?
                    cutArray(strArr, indexFoundElement + 1, strArr.length) :
                    cutArray(strArr, 0, indexFoundElement);

            if (indexFoundElement == 0) {
                strArr = startArr;
                size--;
            } else {
                String[] endArr = cutArray(strArr, indexFoundElement + 1, strArr.length);
                strArr = mergeArray(startArr, endArr);
                size--;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String get(int index) {
        try {
            String tmp = strArr[index];
        } catch (Exception e) {
            return e.toString();
        }
        return strArr[index];
    }

    @Override
    public boolean contain(String o) {
        for (int i = 0; i < size; i++) {
            if (o != null && strArr[i] != null) {
                if (o.equals(strArr[i])) {
                    return true;
                }
            } else if (o == strArr[i]) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean equals(Collection str) {
        if (str.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (str.get(i) != null && strArr[i] != null) {
                if (!str.get(i).equals(strArr[i])) {
                    return false;
                }
            } else {
                if (str.get(i) != strArr[i]) {
                    return false;
                }
            }

        }
        return true;
    }

    @Override
    public boolean clear() {
        try {
            strArr = createArray(10);
            size = 0;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < size; i++) {
            res = res + " " + strArr[i];
        }
        return res.trim();
    }

    private String[] createArray(int size) {
        return new String[size];
    }

    private String[] cutArray(String[] arr, int start, int end) {
        String[] startArr = end == 0 ?
                new String[1] :
                new String[end - start];
        for (int i = 0, j = start; i < startArr.length; i++) {
            startArr[i] = arr[j++];
        }
        return startArr;
    }

    private String[] mergeArray(String[] arr1, String[] arr2) {
        String[] arr = new String[arr1.length + arr2.length];
        int counter = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[counter++];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr[counter++] = arr2[i];
        }
        return arr;
    }

    private void convertArrayToCorrectSize() {
        int size = this.size == countNotNull() ? countNotNull() : this.size;
        int strArrayLength = strArr.length;
        int counterNULL = this.size - countNotNull();
        String[] arr = new String[size];
        for (int i = 0, j = 0; i < strArr.length && j < arr.length; i++) {
            if (strArr[i] != null) {
                arr[j++] = strArr[i];
            }
            if (counterNULL > 0 && strArr[i] == null) {
                arr[j++] = null;
                counterNULL--;
            }
        }
        strArr = mergeArray(arr, createArray(strArrayLength - arr.length));
    }

    private int countNotNull() {
        int counter = 0;
        for (String str : strArr) {
            if (str != null) {
                counter++;
            }
        }
        return counter;
    }

    private boolean needExtension() {
        return size + 3 >= strArr.length;
    }


    @Override
    public boolean hasNext() {
        if (itrCounter >= size()) {
            itrCounter = 0;
            return false;
        }
        return itrCounter < size();
    }

    @Override
    public Object next() {
        return get(itrCounter++);
    }

    @Override
    public void remove() {
        delete(get(itrCounter));
        size--;
    }

    public CollectionImpl getUnique() {
        CollectionImpl list = new CollectionImpl();
        for (int i = 0; i < size; i++) {
            if (!list.contain(get(i))) {
                list.add(get(i));
            }
        }
        return list;
    }

    private boolean isUnique(CollectionImpl list, String str) {
        if (list.size() == 0) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }
}
