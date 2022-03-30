package com.demo.basics.datastructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Implement Map - EASY]()
 *
 * - hash
 * - capacity increase
 */
public class CustomMap {

    @Test
    public void test() {
        int capacity = 32;
        int loadFactor = 5;
        ARMap<String, String> armap = new ARMap<>();
        //ARMap<String, String> armap = new ARMap<>(capacity);
        //ARMap<String, String> armap = new ARMap<>(capacity, loadFactor);
        Map<String, String> defaultMap = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            UUID key = UUID.randomUUID();
            UUID value = UUID.randomUUID();
            armap.put(key.toString(), value.toString());
            defaultMap.put(key.toString(), value.toString());
        }

        for (Map.Entry<String, String> entry : defaultMap.entrySet()) {
            Assertions.assertEquals(defaultMap.get(entry.getKey()), armap.get(entry.getKey()));
        }
        //armap.printMap();
    }

    @Test
    public void testCollision() {
        Map map = new ARMap();
        int dataSize = 100;

        for (int i = 0; i < dataSize; ++i) {
            map.put(new CollidingKey(String.valueOf(i)), i);
            map.put(new LessCollidingKey(i), i);
            map.put(new NonCollidingKey(i), i);
        }
        for (int i = 0; i < dataSize; ++i) {
            map.get(new CollidingKey(String.valueOf(i)));
            map.get(new LessCollidingKey(i));
            map.get(new NonCollidingKey(i));
        }
    }

    class ARMap<K, V> implements Map<K, V> {

        private int capacity;
        private float loadFactor;
        private int threshold;
        private AREntry<K, V>[] buckets;
        private AtomicLong counter = new AtomicLong(0L);

        public ARMap() {
            this.capacity = 16;
            this.loadFactor = 0.75f;
            this.threshold = (int) (capacity * loadFactor);
            this.buckets = new AREntry[capacity];
        }

        public ARMap(int capacity) {
            this.capacity = capacity;
            this.loadFactor = 0.75f;
            this.threshold = (int) (capacity * loadFactor);
            this.buckets = new AREntry[capacity];
        }

        public ARMap(int capacity, float loadFactor) {
            this.capacity = capacity;
            this.loadFactor = loadFactor;
            this.threshold = (int) (capacity * loadFactor);
            this.buckets = new AREntry[capacity];
        }

        @Override
        public V get(Object key) {
            AREntry<K, V> entry = buckets[getHash((K) key)];
            while (entry != null && !key.equals(entry.getKey())) {
                entry = entry.getNext();
            }
            return entry != null ? entry.getValue() : null;
        }

        @Override
        public V put(K key, V value) {
            int bucketIndex = getHash(key);
            AREntry<K, V> entry = buckets[bucketIndex];
            if (entry != null) {
                boolean done = false;
                while (!done) {
                    if (key.equals(entry.getKey())) {
                        //case when value already exists.
                        entry.setValue(value);
                        done = true;
                    } else if (entry.getNext() == null) {
                        //reach end of link list
                        entry.setNext(new AREntry<K, V>(key, value));
                        done = true;
                    }
                    entry = entry.getNext();
                }
            } else {
                // nothing there at all; just shove the new entry in
                buckets[bucketIndex] = new AREntry<K, V>(key, value);
            }

            //when threshold is reached increase capacity
            if (counter.incrementAndGet() > threshold) {
                System.out.println("Item Count: " + counter.get() + ", Rehashing capacity from : " + capacity + " to : " + capacity * 2);
                capacity = capacity * 2;
                this.threshold = (int) (capacity * loadFactor);
                AREntry<K, V>[] newBuckets = new AREntry[capacity];
                AREntry<K, V>[] oldBuckets = this.buckets;
                this.buckets = newBuckets;

                //iterate over each bucket and insert.
                for (AREntry<K, V> a : oldBuckets) {
                    if (a != null) {
                        put(a.getKey(), a.getValue());
                        AREntry<K, V> b = a.getNext();
                        while (b != null) {
                            put(b.getKey(), b.getValue());
                            b = b.getNext();
                        }
                    }

                }
            }
            return null;
        }

        @Override
        public int size() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean isEmpty() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean containsKey(Object key) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean containsValue(Object value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public V remove(Object key) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void putAll(Map<? extends K, ? extends V> m) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Set<K> keySet() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Collection<V> values() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Set<Entry<K, V>> entrySet() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private int getHash(K key) {
            int hash = key.hashCode();
            if (hash < 0) {
                hash = hash * -1;
            }
            hash = hash % capacity;
            return hash;
        }

        public void printMap() {
            System.out.println("Counting Buckets");
            int i = 0;
            for (AREntry<K, V> a : buckets) {
                if (a != null) {
                    int j = 0;
                    AREntry<K, V> b = a.getNext();
                    while (b != null) {
                        b = b.getNext();
                        j++;
                    }
                    System.out.println("Bucket " + i + " has  " + j + " objects");
                    i++;
                }
            }
        }
    }

    @Data
    class AREntry<K, V> {

        private AREntry<K, V> next;
        private final K key;
        private V value;

        public AREntry(K key, V value) {
            this.key = key;
            this.setValue(value);
        }
    }

    class CollidingKey {
        private String key;

        public CollidingKey(String key) {
            super();
            this.key = key;
        }

        @Override
        public int hashCode() {
            return 999999999;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CollidingKey)) {
                return false;
            }
            return this.key.equals(((CollidingKey) obj).key);
        }

    }

    class LessCollidingKey {
        private int key;

        public LessCollidingKey(int key) {
            super();
            this.key = key;
        }

        @Override
        public int hashCode() {
            return key % 100;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof LessCollidingKey)) {
                return false;
            }
            return this.key == ((LessCollidingKey) obj).key;
        }

    }

    class NonCollidingKey {
        private int key;

        public NonCollidingKey(int key) {
            super();
            this.key = key;
        }

        @Override
        public int hashCode() {
            return key;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof NonCollidingKey)) {
                return false;
            }
            return this.key == ((NonCollidingKey) obj).key;
        }
    }
}
