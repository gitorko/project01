# Concurrency

1. CyclicBarrier - CyclicBarriers are used in programs in which we have a fixed number of threads that must wait for each other to reach a common point before continuing execution.
2. Phaser
3. CountDownLatch
4. Exchanger - share objects between two threads of type T
5. Semaphore
6. SynchronousQueue

LinkedBlockingQueue (unbounded)
SynchronousQueue - space for only 1
ArrayBlockingQueue (bounded)
DelayQueue - unbounded blocking queue of delayed elements, element can only be taken when its delay has expired.

## Thread Pool Size
https://www.youtube.com/watch?v=ErNre5varF8&ab_channel=DefogTech

## Types of ExecutorService
ExecutorService uses BlockingQueue by default

newFixedThreadPool - LinkedBlockingQueue
newSingleThreadExecutor
newCachedThreadPool - SynchronousQueue, dynamically scale the threads to handle the amount of tasks, threads are idle for 60 second, they will be scaled down

## Rejection policy

1. AbortPolicy - This is the default policy. It causes the executor to throw a RejectedExecutionException.
2. CallerRunsPolicy - the producer thread will be employed to run the task it just submitted. This is effective back pressure.
3. DiscardOldestPolicy - accept the task and throw away the oldest task in the BlockingQueue
4. DiscardPolicy - accept the task but silently throw it away
5. Custom Policy - We can implement the RejectedExecutionHandler interface and provide our own logic to handle

## Questions

1. ShutdownNow vs Shutdown
2. Dynamic Striping - Striped64 class
3. Deadlock vs Livelock
4. Lock vs Synchronized Block
5. ReentrantReadWriteLock.ReadLock vs ReentrantReadWriteLock.WriteLock
6. Stamped lock - optimistic locking
7. DelayQueue

## Links
https://www.linkedin.com/pulse/java-executor-explained-hohuan-chang/
https://howtodoinjava.com/java/multi-threading/scheduledexecutorservice/
https://www.javacodegeeks.com/2016/12/implement-thread-pool-java.html
https://howtodoinjava.com/java/multi-threading/how-to-use-blockingqueue-and-threadpoolexecutor-in-java/
https://www.javacodemonk.com/implement-custom-thread-pool-in-java-without-executor-framework-ca10e61d
https://www.baeldung.com/java-longadder-and-longaccumulator
https://www.interviewbit.com/multithreading-interview-questions/
https://medium.com/@tarunjain07/volatile-reentrant-lock-vs-synchronize-condition-variable-66e870a8434d
https://www.baeldung.com/java-concurrent-locks
https://www.javacodemonk.com/discuss-internals-of-a-concurrenthashmap-chm-in-java-b537d34e
https://www.linkedin.com/pulse/java-8-future-vs-completablefuture-saral-saxena/
https://howtodoinjava.com/java/multi-threading/java-delayqueue/

## Pool size
Fixed thread pool number - cores

- cpu intensive = num of cores
- io intensive = time it takes for IO to complete.
- ideal thread pool size = cores * (1 + (wait time/cpu time))

## Mutex vs Semaphore

A mutex (or Mutual Exclusion Semaphores) is a locking mechanism used to synchronize access to a resource. Only one task (can be a thread or process based on OS abstraction) can acquire the mutex. It means there will be ownership associated with mutex, and only the owner can release the lock (mutex).
Semaphore (or Binary Semaphore) is signaling mechanism (“I am done, you can carry on” kind of signal). For example, if you are listening songs (assume it as one task) on your mobile and at the same time your friend called you, an interrupt will be triggered upon which an interrupt service routine (ISR) will signal the call processing task to wakeup. A binary semaphore is NOT protecting a resource from access. Semaphores are more suitable for some synchronization problems like producer-consumer.

Short version:
A mutex can be released only by the thread that had acquired it.
A binary semaphore can be signaled by any thread (or process).

## Read vs Write lock
Read Lock – if no thread acquired the write lock or requested for it then multiple threads can acquire the read lock
Write Lock – if no threads are reading or writing then only one thread can acquire the write lock

## Bulkhead pattern
https://www.youtube.com/watch?v=R2FT5edyKOg&ab_channel=DefogTech
