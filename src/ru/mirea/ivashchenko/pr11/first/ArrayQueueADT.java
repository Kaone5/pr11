package ru.mirea.ivashchenko.pr11.first;

public class ArrayQueueADT {
    private int size;
    private int head;
    private int tail;
    private Object[] elements = new Object[10];

    static void fixCapacity(ArrayQueueADT queue, int capacity)
    {
        assert queue != null;
        int len = queue.elements.length;
        if (capacity > len)
        {
            Object[] newElements = new Object[queue.elements.length * 2];
            int i = 0;
            while (queue.tail!=queue.head)
            {
                newElements[i] = queue.elements[queue.head];
                queue.head = (queue.head + 1) % len;
                i++;
            }
            queue.head = 0;
            queue.tail = len - 1;
            queue.elements = newElements;
        }
    }

    public static void enqueue(ArrayQueueADT queue, Object element)
    {
        assert queue != null;
        assert element != null;
        fixCapacity(queue, queue.size + 2);
        queue.elements[queue.tail] = element;
        queue.tail = (queue.tail + 1) % queue.elements.length;
        queue.size++;
    }

    public static Object element(ArrayQueueADT queue)
    {
        assert queue != null;
        assert queue.size > 0;
        return queue.elements[queue.head];
    }

    public static Object dequeue(ArrayQueueADT queue)
    {
        assert queue != null;
        Object ret = element(queue);
        queue.elements[queue.head] = null;
        queue.head = (queue.head + 1) % queue.elements.length;
        queue.size--;
        return ret;
    }

    public static int size(ArrayQueueADT queue)
    {
        assert queue != null;
        return queue.size;
    }

    public static boolean isEmpty(ArrayQueueADT queue)
    {
        assert queue != null;
        return (queue.size == 0);
    }

    public static void clear(ArrayQueueADT queue)
    {
        assert queue != null;
        queue.head = 0;
        queue.tail = 0;
        queue.size = 0;
    }

    public static void push(ArrayQueueADT queue, Object element)
    {
        assert queue != null;
        assert element != null;
        fixCapacity(queue, queue.size + 2);
        queue.head = queue.head - 1;
        if (queue.head < 0) {
            queue.head = queue.elements.length - 1;
        }
        queue.elements[queue.head] = element;
        queue.size++;
    }

    public static Object peek(ArrayQueueADT queue)
    {
        assert queue != null;
        assert queue.size > 0;
        int ltail = queue.tail - 1;
        if (ltail < 0) {
            ltail = queue.elements.length - 1;
        }
        return queue.elements[ltail];
    }

    public static Object remove(ArrayQueueADT queue)
    {
        assert queue != null;
        assert queue.size > 0;
        queue.tail = queue.tail - 1;
        if (queue.tail < 0)
        {
            queue.tail = queue.elements.length - 1;
        }
        Object ret = queue.elements[queue.tail];
        queue.elements[queue.tail] = null;
        queue.size--;
        return ret;
    }
}