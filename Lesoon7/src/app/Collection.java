package app;

public class Collection implements CollectionService {

    private String[] strArr;
    private int extensionIndex;
    private int currentIndex = 0;

    public Collection() {
        strArr = new String[10];
        extensionIndex = strArr.length - 3;
    }

    public Collection(int size) {
        strArr = new String[size];
        extensionIndex = size >= 5 ? size - 3 : size - 1;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        for (String str : strArr) {
            if (str != null) {
                toString.append(str).append(" ");
            }
        }
        return toString.toString();
    }

    @Override
    public boolean add(int index, String value) {
        try {
            if (strArr[index] == null) {
                strArr[index] = value;
                checkNeedAndExtensionArray();
                replaceNullToValue();
                return true;
            } else {
                traveledArray(index);
            }
            strArr[index] = value;
            replaceNullToValue();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean add(String value) {
        try {
            if (strArr[currentIndex + 1] != null) {
                while (strArr[currentIndex] != null) {
                    currentIndex++;
                    if (currentIndex >= strArr.length) extensionArray();
                }
            }
            strArr[currentIndex++] = value;
            checkNeedAndExtensionArray();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int index) {
        try {
            strArr[index] = null;
            replaceNullToValue();
            findFirstNull();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String value) {
        try {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals(value)) {
                    strArr[i] = null;
                    replaceNullToValue();
                    findFirstNull();
                    break;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteAll(String value) {
        try {
            for (int i = 0; i < strArr.length; i++) {
                if (value.equals(strArr[i])) {
                    strArr[i] = null;
                }
            }
            replaceNullToValue();
            findFirstNull();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= strArr.length) {
            return null;
        }
        return strArr[index];
    }

    private void checkNeedAndExtensionArray() {
        if (strArr.length - nullCounter() >= extensionIndex) {
            extensionArray();
        }
    }

    private int nullCounter() {
        int counter = 0;
        for (String s : strArr) {
            if (s == null) {
                counter++;
            }
        }
        return counter;
    }

    private void extensionArray() {
        String[] newArr = new String[strArr.length + 10];
        System.arraycopy(strArr, 0, newArr, 0, strArr.length);
        strArr = newArr;
        extensionIndex = strArr.length - 3;
    }

    private void traveledArray(int index) {
        String firstItem = strArr[index];
        String secondItem = strArr[index + 1];
        boolean needCheck = true;
        int travelLength = strArr.length;
        for (int i = index; i < travelLength; i++) {
            if (needCheck && i + 2 >= strArr.length) {
                extensionArray();
                needCheck = false;
            }

            if (secondItem == null) {
                strArr[i + 1] = firstItem;
                break;
            }

            strArr[i + 1] = firstItem;
            firstItem = secondItem;
            secondItem = strArr[i + 2];
        }
    }

    private void replaceNullToValue() {
        String[] newArr = new String[strArr.length - nullCounter()];
        for (int i = 0, j = 0; i < strArr.length && j < newArr.length; i++) {
            if (strArr[i] != null) {
                newArr[j++] = strArr[i];
            }
        }
        for (int i = 0; i < strArr.length; i++) {
            if (i < newArr.length) {
                strArr[i] = newArr[i];
            } else {
                strArr[i] = null;
            }
        }
    }

    private void findFirstNull() {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == null) {
                currentIndex = i;
                break;
            }
        }
    }
}

