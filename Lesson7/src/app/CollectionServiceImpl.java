package app;

import java.util.Date;
import java.util.UUID;

public class CollectionServiceImpl implements Collection {

    private String[] strArr;
    //Індекс розширення масиву.
    private int extensionIndex;
    //Вказівник на поточний елемент у масиві.
    private int currentIndex = 0;
    //Рядок позначення порожніх елементів у колекції.
    private String emptyString = UUID.randomUUID().toString() + new Date().getTime();

    public CollectionServiceImpl() {
        strArr = new String[10];
        extensionIndex = strArr.length - 3;
    }

    public CollectionServiceImpl(int size) {
        strArr = createArray(size);
        extensionIndex = size >= 5 ? size - 3 : size - 1;
    }

    @Override
    public String toString() {
        String toString = "";
        for (String str : strArr) {
            if (str != emptyString) {
                toString += str + " ";
            }
        }
        return toString;
    }

    //Додає елемент за вказаним індексом у колекцію;
    //Створює плюс десять порожніх елементів у колекцію, якщо вільних комірок стає мало;
    //Якщо індекс < 0 або виходить за межі розміру колекції.
    @Override
    public boolean add(int index, String value) {
        try {
            if (strArr[index] == emptyString) {
                strArr[index] = value;
                checkNeedAndExtensionArray();
                replaceEmptyToValue();
                return true;
            } else {
                traveledArray(index);
            }
            strArr[index] = value;
            replaceEmptyToValue();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    //Метод додає елементи до кінця колекції;
    //Створює плюс десять порожніх елементів у колекцію, якщо вільних комірок стає мало.

    @Override
    public boolean add(String value) {
        try {
            if (strArr[currentIndex + 1] == emptyString) {
                strArr[currentIndex++] = value;
            } else {
                while (strArr[currentIndex] != emptyString) {
                    currentIndex++;
                    if (currentIndex >= strArr.length) extensionArray();
                }
                strArr[currentIndex++] = value;
            }
            checkNeedAndExtensionArray();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //Видалення елемента колекції за допомогою заданого індексу;
    //Якщо індекс < 0 або > розміру колекції, метод поверне false.
    @Override
    public boolean delete(int index) {
        try {
            strArr[index] = emptyString;
            replaceEmptyToValue();
            findFirstEmpty();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //Видалення 1-го знайденого елементу за значенням із колекції;
    //Навіть якщо нічого не було знайдено для видалення з колекції, метод поверне true (як знак успішної операції).
    @Override
    public boolean delete(String value) {
        try {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals(value)) {
                    strArr[i] = emptyString;
                    replaceEmptyToValue();
                    findFirstEmpty();
                    break;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //Видалення усіх знайдених елементів за значенням із колекції;
    //Навіть якщо нічого не було знайдено для видалення із колекції, метод поверне true (як знак успішної операції).
    public boolean deleteAll(String value) {
        try {
            for (int i = 0; i < strArr.length; i++) {
                if (value.equals(strArr[i])) {
                    strArr[i] = emptyString;
                }
            }
            replaceEmptyToValue();
            findFirstEmpty();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //Повертає елемент за індексом;
    //Якщо індекс виходить за межі розміру колекції, поверне Null.
    @Override
    public String get(int index) {
        if (index < 0 || index >= strArr.length) {
            return null;
        }
        return strArr[index];
    }

    private void checkNeedAndExtensionArray() {
        if (strArr.length - emptyCounter() >= extensionIndex) {
            extensionArray();
        }
    }

    private int emptyCounter() {
        int counter = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == emptyString) {
                counter++;
            }
        }
        return counter;
    }

    private void extensionArray() {
        String[] newArr = new String[strArr.length + 10];
        for (int i = 0; i < newArr.length; i++) {
            if (i < strArr.length) {
                newArr[i] = strArr[i];
            } else {
                newArr[i] = emptyString;
            }
        }
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

            if (secondItem == emptyString) {
                strArr[i + 1] = firstItem;
                break;
            }

            strArr[i + 1] = firstItem;
            firstItem = secondItem;
            secondItem = strArr[i + 2];
        }
    }

    private void replaceEmptyToValue() {
        String[] newArr = new String[strArr.length - emptyCounter()];
        for (int i = 0, j = 0; i < strArr.length && j < newArr.length; i++) {
            if (strArr[i] != emptyString) {
                newArr[j++] = strArr[i];
            }
        }
        for (int i = 0; i < strArr.length; i++) {
            if (i < newArr.length) {
                strArr[i] = newArr[i];
            } else {
                strArr[i] = emptyString;
            }
        }
    }

    private void findFirstEmpty() {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == emptyString) {
                currentIndex = i;
                break;
            }
        }
    }

    private String[] createArray(int size) {
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = emptyString;
        }
        return arr;
    }
}

